package pages.destaques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.tealium.MarcacoesDoTealium;

import br.com.infoglobo.pages.Navegador;

public class DestaquesTopicoAutomatico extends MarcacoesDoTealium {
	
	//Teste criado ao defeito DE2368: Problema nas editorias semi automáticas do Globo
	
	public DestaquesTopicoAutomatico() throws Exception {
		super();
	}

	public DestaquesTopicoAutomatico(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuTituloDoTopico() {
		return !getDriver().findElement(By.className("titulo-ultimas")).findElement(By.tagName("h1")).getText().isEmpty();
	}
	
	public boolean exibiuAChamadaDoTituloMaisDe() {
		return !getDriver().findElement(By.className("mais-sobre-titulo")).getText().isEmpty();
	}
	
	public boolean exibiuTituloMaisDeComAPalavraTopico() {
		if ((getDriver().findElement(By.className("mais-sobre-titulo")).getText().contains("Tópico")) || (getDriver().findElement(By.className("mais-sobre-titulo")).getText().contains("Topico"))){
			return false;
		}
		return true;
	}
	
	public boolean exibiuTituloDoTopicoAposOTituloDeMaisDe() {
		String tituloTopico = getDriver().findElement(By.className("titulo-ultimas")).findElement(By.tagName("h1")).getText();
		return getDriver().findElement(By.className("mais-sobre-titulo")).getText().contains(tituloTopico);
	}

	public WebElement bannerHalPage(){
		return getDriver().findElement(By.className("halfpage"));	
	}

	public boolean exibiuBannerHalfPage() {
		return bannerHalPage().isDisplayed();
	}

	public String exibiuNomePublicidade() {
		return bannerHalPage().findElement(By.tagName("p")).findElement(By.tagName("a")).getText();
	}
}
