package pages.materia.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxEmDestaque extends AceitacaoAbstractTest {
	
	public BoxEmDestaque(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement obterBoxEmDestaque() {
		return getDriver().findElement(By.className("em-destaque"));
	}
	
	public boolean exibiuBoxEmDestaque() {
		return obterBoxEmDestaque().isDisplayed();
	}
	
	private WebElement obterTituloDoBox() {
		return obterBoxEmDestaque().findElement(By.tagName("p"));
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
	
	public List<WebElement> listaDeMaterias() {
		return obterBoxEmDestaque().findElements(By.tagName("li"));
	}
	
	private int obterQuantidadeDeMaterias() {
		return listaDeMaterias().size();
	}
	
	public boolean exibiuListaDeMaterias() {
		return obterQuantidadeDeMaterias() == Integer.parseInt("5");
	}
	
	private WebElement obterTituloDaMateriaDeAcordoComAPosicao(int posicao) {
		return listaDeMaterias().get(posicao).findElement(By.className("titulo"));
	}
	
	public boolean exibiuEditoria() {
		for(int i=0;i<obterQuantidadeDeMaterias();i++){
			if(listaDeMaterias().get(i).findElement(By.className("editoria")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagemOuDescricao() {
		int qtdeMaterias = obterQuantidadeDeMaterias();
		for (int i = 0; i < qtdeMaterias; i++) {
			//Caso não possua atributo 'class'
			//A imagem deve estar sendo exibida
			if (listaDeMaterias().get(i).getAttribute("class").equals("")) {
				//Imagem
				if(! listaDeMaterias().get(i).findElement(By.tagName("img")).isDisplayed()) {
					System.out.println("A matéria " + (i + 1) + " não está exibindo a imagem conforme esperado.");
					return false;
				}
				//Link Imagem
				if(! listaDeMaterias().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
					System.out.println("A matéria " + (i + 1) + " não está exibindo um link para a imagem conforme esperado.");
					return false;
				}
				//Width
				if(Integer.parseInt(listaDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("width")) > 234){
					System.out.println("A matéria " + (i + 1) + " não está exibindo a imagem com o width esperado.");
					return false;
				}
				//Height
				if(Integer.parseInt(listaDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("height")) > 141){
					System.out.println("A matéria " + (i + 1) + " não está exibindo a imagem com o height esperado.");
					return false;
				}
				
			}
			
			//Caso possua atributo 'class=no-image'
			//A descrição da matéria deve estar sendo exibida
			if (listaDeMaterias().get(i).getAttribute("class").equals("no-image")) {
				if (listaDeMaterias().get(i).findElement(By.className("subtitulo")).getText().isEmpty()) {
					System.out.println("A matéria " + (i + 1) + " não está exibindo a descrição conforme esperado.");
					return false;
				}
			}
		}
		return true;
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
	
	public boolean exibiuTituloComNoMaximo72Caracteres() {
		//72 + 3 caracteres dos "..."
		for(int i=0;i<obterQuantidadeDeMaterias();i++){
			if(listaDeMaterias().get(i).findElement(By.className("titulo")).getText().length() > 75){
				return false;
			}
		}
		return true;
	}
	
	public boolean repetiuAlgumaMateriaDoBox() {
		String titulo1 = listaDeMaterias().get(0).findElement(By.className("titulo")).getText();
		String titulo2 = listaDeMaterias().get(1).findElement(By.className("titulo")).getText();
		String titulo3 = listaDeMaterias().get(2).findElement(By.className("titulo")).getText();
		String titulo4 = listaDeMaterias().get(3).findElement(By.className("titulo")).getText();
		String titulo5 = listaDeMaterias().get(4).findElement(By.className("titulo")).getText();
		
		if((titulo1==titulo2) || (titulo1==titulo3) || (titulo1==titulo4) || (titulo1==titulo5) ||
							 (titulo2==titulo3) || (titulo2==titulo4) || (titulo2==titulo5) ||
							 (titulo3==titulo4) || (titulo3==titulo5) || (titulo4==titulo5)){
			return false;
		}
		return true;
	}
	
	public boolean repetiuAMateriaNoBox() {
		
		String tituloMateria = getDriver().findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText();
		
		if(tituloMateria.equals(listaDeMaterias().get(0).findElement(By.className("titulo")).getText()) ||
				tituloMateria.equals(listaDeMaterias().get(1).findElement(By.className("titulo")).getText()) ||
				tituloMateria.equals(listaDeMaterias().get(2).findElement(By.className("titulo")).getText()) ||
				tituloMateria.equals(listaDeMaterias().get(3).findElement(By.className("titulo")).getText()) ||
				tituloMateria.equals(listaDeMaterias().get(4).findElement(By.className("titulo")).getText())){
			return false;
		}
		return true;
	}
	
	public boolean naoExibiuMateriaDeEspecialPublicitarioNoBoxEmDestaqueAgoraNoGLobo() {
		List<WebElement> totalDeMateriasEspecialPublicitario = obterBoxEmDestaque().findElements(By.className("especial-publicitario"));
		return totalDeMateriasEspecialPublicitario.size() == Integer.parseInt("0");
	}
}