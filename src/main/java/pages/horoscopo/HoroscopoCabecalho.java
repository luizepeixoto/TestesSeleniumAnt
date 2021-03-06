package pages.horoscopo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class HoroscopoCabecalho extends AceitacaoAbstractTest {
	
	public HoroscopoCabecalho() throws Exception {
		super();
	}
	
	public HoroscopoCabecalho(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement exibiuOBoxDeLinks() {
		return getDriver().findElement(By.xpath("/html/body/div[3]"));
	}

	public boolean exibiuLinkOGlobo() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li/a")).isDisplayed();
	}

	public boolean exibiuOLinkOGloboCorreto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li/a")).getAttribute("href").equals("http://oglobo.globo.com/");
	}

	public String exibiuTextoOGlobo() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li/a")).getText();
	}

	public boolean exibiuLinkDoMemoria() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[2]/a")).isDisplayed();
	}

	public boolean exibiuOLinkDoMemoriaCorreto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[2]/a")).getAttribute("href").equals("http://memoria.oglobo.globo.com/");
	}

	public String exibiuTextoDoMemoria() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[2]/a")).getText();
	}

	public boolean exibiuLinkDoAcervo() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[3]/a")).isDisplayed();
	}

	public boolean exibiuOLinkDoAcervoCorreto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[3]/a")).getAttribute("href").equals("http://acervo.oglobo.globo.com/");
	}

	public String exibiuTextoDoAcervo() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[3]/a")).getText();
	}

	public boolean exibiuLinkDoSiteEla() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[4]/a")).isDisplayed();
	}

	public boolean exibiuOLinkDoSiteElaCorreto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[4]/a")).getAttribute("href").equals("http://www.eladigital.com.br/");
	}

	public String exibiuTextoDoSiteEla() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[4]/a")).getText();
	}

	public boolean exibiuLinkDoPatriciaKogut() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a")).isDisplayed();
	}

	public boolean exibiuOLinkDoPatriciaKogutCorreto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a")).getAttribute("href").equals("http://www.patriciakogut.com.br/");
	}

	public String exibiuTextoDoPatriciaKogut() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a")).getText();
	}

	public boolean exibiuLinkDoRioShow() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[6]/a")).isDisplayed();
	}

	public boolean exibiuOLinkDoRioShowCorreto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[6]/a")).getAttribute("href").equals("http://rioshow.oglobo.globo.com/");
	}

	public String exibiuTextoDoRioShow() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[6]/a")).getText();
	}

	public boolean exibiuLinkDoExtra() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[7]/a")).isDisplayed();
	}

	public boolean exibiuOLinkDoExtraCorreto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[7]/a")).getAttribute("href").equals("http://extra.globo.com/");
	}

	public String exibiuTextoDoExtra() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[7]/a")).getText();
	}

	public boolean exibiuLinkDoClassificadosDoRio() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[8]/a")).isDisplayed();
	}

	public boolean exibiuOLinkDoClassificadosDoRioCorreto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[8]/a")).getAttribute("href").equals("http://classificadosdorio.globo.com/");
	}

	public String exibiuTextoDoClassificadosDoRio() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[8]/a")).getText();
	}

	public WebElement exibiuOBoxCentralDoCabecalho() {
		return getDriver().findElement(By.className("logo-home"));
	}

	public boolean exibiuOBannerDoCabecalho() {
		return exibiuOBoxCentralDoCabecalho().findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuUmLinkNoBanner() {
		return exibiuOBoxCentralDoCabecalho().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuOLinkCorretoNoBanner() {
		return !exibiuOBoxCentralDoCabecalho().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public WebElement exibiuClasseRedesSociais() {
		return getDriver().findElement(By.className("menu-contents")).findElement(By.className("redes-sociais"));
	}

	public WebElement exibiuOIconeFacebook() {
		return exibiuClasseRedesSociais().findElement(By.className("facebook"));
	}

	public boolean exibiuUmLinkNoIconeDoFacebook() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuUmLinkValidoNoIconeDoFacebook() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).getAttribute("href");
	}

	public WebElement exibiuOIconeTwitter() {
		return exibiuClasseRedesSociais().findElement(By.className("twitter"));
	}

	public boolean exibiuUmLinkNoIconeDoTwitter() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(1).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuUmLinkValidoNoIconeDoTwitter() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(1).findElement(By.tagName("a")).getAttribute("href");
	}

	public WebElement exibiuOIconeGooglePlus() {
		return exibiuClasseRedesSociais().findElement(By.className("plus"));
	}

	public boolean exibiuUmLinkNoIconeDoGooglePlus() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(2).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuUmLinkValidoNoIconeDoGooglePlus() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(2).findElement(By.tagName("a")).getAttribute("href");
	}
	
	public WebElement exibiuOBannerDeAssinatura() {
		return getDriver().findElement(By.id("banner-assinatura"));
	}

	public boolean exibiuUmLinkNoBannerDeAssinatura() {
		return exibiuOBannerDeAssinatura().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoBannerDeAssinatura() {
		return !exibiuOBannerDeAssinatura().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public WebElement exibiuABuscaNoCabecalho() {
		return getDriver().findElement(By.id("buscar"));
	}

	public boolean executouABusca() throws InterruptedException {
		getDriver().findElement(By.xpath("/html/body/header/div/div/div/div[2]/ul[2]/li/a")).click();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("/html/body/header/div/div/div/div[2]/ul[2]/li[2]/form/div/input")).sendKeys("big brother");
		Thread.sleep(500);
		getDriver().findElement(By.className("search-submit")).click();
		Thread.sleep(2000);
		
		return !getDriver().findElement(By.className("resultadosEncontrados")).getText().isEmpty();
	}

	public WebElement exibiuOMenuDeTopicos() {
		return getDriver().findElement(By.xpath("/html/body/header/div[3]/div/div/div/ul"));
	}

	public Object exibiuOTituloTopicos() {
		return getDriver().findElement(By.xpath("/html/body/header/div[3]/div/div/div/ul/li")).getText();
	}
	
	public List<WebElement> listaTotalDeTopicos() {
		return getDriver().findElement(By.className("artigo-topicos")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}

	public boolean exibiuListaDeTopicos() {
		return listaTotalDeTopicos().size()>0;
	}

	public boolean exibiuTituloParaOsTopicos() {
		for(int i=1;i<listaTotalDeTopicos().size();i++){
			if(listaTotalDeTopicos().get(i).getText().isEmpty()){
				return false;
			}
		}
		return true; 
	}

	public boolean exibiuLinkNoTituloDosTopicos() {
		for(int i=1;i<listaTotalDeTopicos().size();i++){
			if(!listaTotalDeTopicos().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true; 
	}

	public boolean oLinkDosTopicosSaoValidos() {
		for(int i=1;i<listaTotalDeTopicos().size();i++){
			if(listaTotalDeTopicos().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true; 
	}

	public WebElement exibiuCabecalhoComEditorias() {
		getDriver().manage().window().maximize();
		return getDriver().findElement(By.className("menu-home"));
	}

	public List<WebElement> listaTotalDeEditorias(){
		return getDriver().findElement(By.className("menu-home")).findElements(By.className("link-menu"));
	}
	public boolean exibiuUmaListaDeEditorias() {
		return listaTotalDeEditorias().size() > 0;
	}

	public boolean exibiuOTituloDeCadaEditoria() {
		for(int i=0;i<listaTotalDeEditorias().size();i++){
			if(listaTotalDeEditorias().get(i).getText().isEmpty()){
				return false;
			}
		}return true;
	}

	public String exibiuOTituloHomeComoAtivo() {
		return getDriver().findElements(By.className("no-arrow")).get(0).getText();
	}
	
public boolean exibiuListaDeLinksNoMenuMais() throws InterruptedException {
		
		WebElement menu = getDriver().findElement(By.cssSelector("body > header > div.nav > div > div > nav > ul > li.mais > span"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> totalDeLinksDeMais = getDriver().findElement(By.className("mais")).findElements(By.tagName("li"));
		return totalDeLinksDeMais.size()>0;
	}

	public boolean exibiuOsItensDeMaisComTitulo() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("body > header > div.nav > div > div > nav > ul > li.mais > span"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> totalDeLinksDeMais = getDriver().findElement(By.className("mais")).findElements(By.tagName("li"));
		for(int i=0; i<totalDeLinksDeMais.size();i++){
			if(totalDeLinksDeMais.get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOsItensDeMaisComUmLinkNoTitulo() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("body > header > div.nav > div > div > nav > ul > li.mais > span"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> totalDeLinksDeMais = getDriver().findElement(By.className("submenu-home")).findElements(By.tagName("li"));
		for(int i=0; i<totalDeLinksDeMais.size();i++){
			if(!totalDeLinksDeMais.get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOsItensDeMaisComUmLinkValidoNoTitulo() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("body > header > div.nav > div > div > nav > ul > li.mais > span"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(1000);
		List<WebElement> totalDeLinksDeMais = getDriver().findElement(By.className("mais")).findElements(By.tagName("li"));
		for(int i=0; i<totalDeLinksDeMais.size();i++){
			if(totalDeLinksDeMais.get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
}
