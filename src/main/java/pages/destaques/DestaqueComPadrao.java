package pages.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDestaques;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaqueComPadrao extends AceitacaoAbstractTest {
	
	public DestaqueComPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}

	public boolean exibiuOAntititulo() {
		return !getDriver().findElement(By.className("subtitulo-container")).findElement(By.className("subtitulo")).getText().isEmpty();
	}

	public WebElement acessaDestaqueHorizontal() {
		return getDriver().findElement(By.className("destaque-horizontal"));
	}
	
	public boolean exibiuDestaqueHorizontal() {
		return acessaDestaqueHorizontal().isDisplayed();
	}
	
	public WebElement acessaFotoDestaqueHorizontal(){
		return acessaDestaqueHorizontal().findElement(By.tagName("a")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoDoDestaqueHorizontal() {
		return acessaFotoDestaqueHorizontal().isDisplayed();
	}
	
	public WebElement acessaTituloDoDestaqueHorizontal() {
		return acessaDestaqueHorizontal().findElement(By.className("titulo"));
	}
	
	public boolean exibiuTituloDoDestaqueHorizontal() {
		return !acessaTituloDoDestaqueHorizontal().getText().isEmpty();
	}
	
	public boolean exibiuTituloDoDestaqueHorizontalComNoMaximo96Caracteres() {
		return acessaDestaqueHorizontal().findElement(By.className("titulo")).getText().length() < 99;
	}
	
	public boolean exibiuLinkNoTituloDoDestaqueHorizontal() {
		return acessaDestaqueHorizontal().findElement(By.className("titulo")).findElement(By.tagName("a")).isDisplayed();
	}

	public WebElement acessaDescricaoDoDestaqueHorizontal() {
		return acessaDestaqueHorizontal().findElement(By.className("subtitulo"));
	}
	
	public boolean exibiuDescricaoDoDestaqueHorizontal() {
		return !acessaDescricaoDoDestaqueHorizontal().getText().isEmpty();
	}
	
	public boolean exibiuDescricaoDoDestaqueHorizontalComNoMaximo143Caracteres() {
		
		int quantidadeMaximaDeCaracteres = 146;
		String descricaoAtual = acessaDescricaoDoDestaqueHorizontal().getText();
		
		if(descricaoAtual.length() > quantidadeMaximaDeCaracteres){
			imprimirMensagemDeErroGenerica("Quantidade máxima de caracteres excedida.");
			return false;
		}
		
		return true;
	}
	
	public List<WebElement> listaDeMateriasDestaques(){
		return getDriver().findElement(By.className("destaques-lista")).findElements(By.tagName("li"));
	}
	
	public int totalDemateriasEmDestaques(){
		return listaDeMateriasDestaques().size();
	}

	public boolean exibiuListaDeDestaques() {
		return listaDeMateriasDestaques().size() > 0;
	}

	public boolean exibiuFotoOuDescricaoNosDestaquesDaLista() {
		
		for(int i=0; i < totalDemateriasEmDestaques(); i++){
			
			WebElement materiaAtual = listaDeMateriasDestaques().get(i).findElement(By.className("inner-border"));
			
			try {
					materiaAtual.findElement(By.tagName("h3")).isDisplayed();
					
					String descricaoAtual = materiaAtual.findElement(By.tagName("h3")).getText();
					if(descricaoAtual.length() > 96){
						return false;
					}
						
			} catch (Exception e) {
				if(!materiaAtual.findElement(By.tagName("img")).isDisplayed()){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean exibiuFotoDosDestaquesComOCropWidthEHeightCorretos() {
		
		int contadorDeErros = 0;
		
		String cropEsperado = CropsDestaques.semiAutomaticoMateria.cropProporcional();
		String widthEsperado = CropsDestaques.semiAutomaticoMateria.getWidth();
		String heightEsperado = CropsDestaques.semiAutomaticoMateria.getHeight();
		
		for(int i = 0; i < totalDemateriasEmDestaques(); i++){
			
			WebElement fotoAtual = listaDeMateriasDestaques().get(i).findElement(By.tagName("a")).findElement(By.tagName("img"));
			
			String urlFotoAtual = fotoAtual.getAttribute("src");
			String widthFotoAtual = fotoAtual.getAttribute("width");
			String heightFotoAtual = fotoAtual.getAttribute("height"); 
			
			if(!urlFotoAtual.contains(cropEsperado)){
				imprimirMensagemDeErroDeUmaTag("crop incorreto", widthFotoAtual, widthEsperado);
				contadorDeErros++;
			}
			
			if(Integer.parseInt(widthFotoAtual) > Integer.parseInt(widthEsperado)){
				imprimirMensagemDeErroDeUmaTag("width da foto horizontal", widthFotoAtual, widthEsperado);
				contadorDeErros++;
			}
			
			if(Integer.parseInt(heightFotoAtual) > Integer.parseInt(heightEsperado)){
				imprimirMensagemDeErroDeUmaTag("height da foto horizontal", heightFotoAtual, heightEsperado);
				contadorDeErros++;
			}
	
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuTituloComNoMaximo100Caracteres() {
		
		int contadorDeErros = 0;
		int quantidadeMaximaDeCaracteres = 100;
		
		for(int i = 0; i < totalDemateriasEmDestaques(); i++){
			
			WebElement fotoAtual = listaDeMateriasDestaques().get(i).findElement(By.tagName("h2")).findElement(By.tagName("a"));
			
			String textoTituloAtual = fotoAtual.getText();
			
			if(textoTituloAtual.isEmpty()){
				imprimirMensagemDeErroGenerica("Não exibiu título para a "+(i+1)+"ª matéria.");
				contadorDeErros++;
			}
			
			if(textoTituloAtual.length() > quantidadeMaximaDeCaracteres){
				imprimirMensagemDeErroDeUmaTag("Quantidade máxima de caracteres", Integer.toString(quantidadeMaximaDeCaracteres), Integer.toString(textoTituloAtual.length()));
				return false;
			}
		}
		
		return validacaoDeErros(contadorDeErros);
	}

	public boolean exibiuTituloMaisSobre() {
		return !getDriver().findElement(By.className("mais-sobre-titulo")).getText().isEmpty();
	}
}