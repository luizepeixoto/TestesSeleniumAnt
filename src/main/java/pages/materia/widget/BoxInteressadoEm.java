package pages.materia.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxInteressadoEm extends AceitacaoAbstractTest {
	
	public BoxInteressadoEm(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement obterBoxInteressadoEm() {
		return getDriver().findElement(By.className("estou-interessado"));
	}
	
	public boolean exibiuOBoxInteressadoEm(){
		return obterBoxInteressadoEm().isDisplayed();
	}
	
	private WebElement obterTituloDoBox() {
		return obterBoxInteressadoEm().findElement(By.tagName("p"));
	}
	
	public boolean exibiuTitulo() {
		//Elemento titulo
		if (! obterTituloDoBox().isDisplayed()) {
			System.out.println("O título do box não está sendo exibido.");
			return false;
		}
		//Valor Elemento titulo
		if (obterTituloDoBox().getText().isEmpty()) {
			System.out.println("O valor do elemento título do box não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	private List<WebElement> obterListaDeMaterias() {
		return obterBoxInteressadoEm().findElement(By.id("estouInteressado")).findElements(By.tagName("li"));
	}
	
	private int obterQuantidadeDeMaterias() {
		return obterListaDeMaterias().size();
	}
	
	public boolean exibiuCincoMaterias() {
		return obterQuantidadeDeMaterias() == 5;
	}

	public boolean exibiuEditoria() {
		for(int i=0; i < obterQuantidadeDeMaterias(); i++){
			if(obterListaDeMaterias().get(i).findElement(By.className("editoria")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOCropCorretoEUmLinkNasImagens() {
		String cropEsperado = CropsDeArticles.materiaBoxDaZunit.cropProporcional();
		int qtdeMaterias = obterQuantidadeDeMaterias();
		
		//Caso não possua atributo 'class'
		//A imagem deve estar sendo exibida
		for (int i = 0; i < qtdeMaterias; i++) {
			if (obterListaDeMaterias().get(i).getAttribute("class").equals("")) {
				//Imagem
				if(! obterListaDeMaterias().get(i).findElement(By.tagName("img")).isDisplayed()) {
					System.out.println("A matéria " + (i + 1) + " não está exibindo a imagem conforme esperado.");
					return false;
				}
				//Crop Imagem
				if(! obterListaDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("src").contains(cropEsperado)) {
					System.out.println("A matéria " + (i + 1) + " não está exibindo o crop da imagem conforme esperado.");
					return false;
				}
				//Link Imagem
				if(! obterListaDeMaterias().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
					System.out.println("A matéria " + (i + 1) + " não está exibindo um link para a imagem conforme esperado.");
					return false;
				}
			}
		}	
		return true;
	}
	
	private WebElement obterTituloDaMateriaDeAcordoComAPosicao(int posicao) {
		return obterListaDeMaterias().get(posicao).findElement(By.className("titulo"));
	}
	
	public boolean exibiuOTituloDasMaterias() {
		for (int i = 0; i < obterQuantidadeDeMaterias(); i++) {
			//Elemento titulo
			if(! obterTituloDaMateriaDeAcordoComAPosicao(i).isDisplayed()){
				System.out.println("O titulo da matéria " + (i + 1) + " não está sendo exibido.");
				return false;
			}
			//Valor Elemento titulo
			if(obterTituloDaMateriaDeAcordoComAPosicao(i).getText().isEmpty()){
				System.out.println("O valor do elemento titulo da matéria " + (i + 1) + " não está sendo exibido.");
				return false;
			}
		}
		return true;
	}
	
	public boolean repetiuAlgumaMateriaDoBox() {
		String titulo1 = obterListaDeMaterias().get(0).findElement(By.className("titulo")).getText();
		String titulo2 = obterListaDeMaterias().get(1).findElement(By.className("titulo")).getText();
		String titulo3 = obterListaDeMaterias().get(2).findElement(By.className("titulo")).getText();
		String titulo4 = obterListaDeMaterias().get(3).findElement(By.className("titulo")).getText();
		String titulo5 = obterListaDeMaterias().get(4).findElement(By.className("titulo")).getText();
		
		if((titulo1==titulo2) || (titulo1==titulo3) || (titulo1==titulo4) || (titulo1==titulo5) ||
							 (titulo2==titulo3) || (titulo2==titulo4) || (titulo2==titulo5) ||
							 (titulo3==titulo4) || (titulo3==titulo5) || (titulo4==titulo5)){
			return false;
		}
		return true;
	}
	
	public boolean repetiuAMateriaNoBox() {
		
		String tituloMateria = getDriver().findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText();
		
		if(tituloMateria.equals(obterListaDeMaterias().get(0).findElement(By.className("titulo")).getText()) ||
				tituloMateria.equals(obterListaDeMaterias().get(1).findElement(By.className("titulo")).getText()) ||
				tituloMateria.equals(obterListaDeMaterias().get(2).findElement(By.className("titulo")).getText()) ||
				tituloMateria.equals(obterListaDeMaterias().get(3).findElement(By.className("titulo")).getText()) ||
				tituloMateria.equals(obterListaDeMaterias().get(4).findElement(By.className("titulo")).getText())){
			return false;
		}
		return true;
	}
}