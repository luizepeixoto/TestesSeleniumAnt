package pages.plantao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.tealium.MarcacoesDoTealium;

import br.com.infoglobo.pages.Navegador;

public class PlantaoNavegacao extends MarcacoesDoTealium {
	
	public PlantaoNavegacao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void aguardaBoxDeNavegacaoCarregar(){
		 while(!exibiuBoxDeNavegacao().isDisplayed()){
			 if(exibiuBoxDeNavegacao().isDisplayed()){
				 break;
			 }
		 }
	}
	
	public void executaScrollAteOBoxDePaginacao(){
		 executarScroll(exibiuBoxDeNavegacao().getLocation());
	}
	
	public WebElement exibiuBoxDeNavegacao(){
		return getDriver().findElement(By.className("navegacao"));
	}
	
	public WebElement exibiuBoxDeNavegacaoAnterior(){
		return exibiuBoxDeNavegacao().findElement(By.className("mais-antiga"));
	}
	
	public boolean exibiuUmLinkNoNoBoxDeNavegacaoAnterior(){
		return exibiuBoxDeNavegacaoAnterior().findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean getBoxPaginacaoAntigaLinkValido(){
		return !exibiuBoxDeNavegacaoAnterior().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public String getBoxPaginacaoAntigaTitulo(){
		return exibiuBoxDeNavegacaoAnterior().findElement(By.className("base")).findElement(By.tagName("span")).getText();
	}
	
	public boolean exibiuTituloDoPlantaoAnteriorEmNegrito(){
		return exibiuBoxDeNavegacaoAnterior().findElement(By.className("base")).findElement(By.tagName("strong")).isDisplayed();
	}
	
	public WebElement exibiuPaginacaoProxima(){
		return exibiuBoxDeNavegacao().findElement(By.className("mais-recente"));
	}
	
	public boolean getBoxPaginacaoRecenteLink(){
		return exibiuPaginacaoProxima().findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean getBoxPaginacaoRecenteLinkValido(){
		return !exibiuPaginacaoProxima().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public String getBoxPaginacaoRecenteTitulo(){
		return exibiuPaginacaoProxima().findElement(By.className("base")).findElement(By.tagName("span")).getText();
	}
	
	public boolean exibiuTituloDPlantaoProximaEmNegrito(){
		return exibiuPaginacaoProxima().findElement(By.className("base")).findElement(By.tagName("strong")).isDisplayed();
	} 
	
}
