package pages.capa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class RodapeBannerAssinatura extends AceitacaoAbstractTest {
	
	public RodapeBannerAssinatura() throws Exception {
		super();
	}
	
	public RodapeBannerAssinatura(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void aguardaOBannerSerExibido(){
		while(! getDriver().findElement(By.id("subscriptionFooter")).isDisplayed()){
			if(getDriver().findElement(By.id("subscriptionFooter")).isDisplayed()){
				break;
			}
		}
	}
	
	public void clicarParaPaginarParaDireita() throws InterruptedException{
		esperaCarregar(1);
		getDriver().findElement(By.cssSelector("a.next")).click();
	}
	
	public WebElement exibiuBannerDeAssinatura() {
		return getDriver().findElement(By.id("subscriptionFooter")).findElement(By.className("btnTitle"));
	}

	public boolean exibiuTitulo() {
		return !exibiuBannerDeAssinatura().findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean exibiuLinkNoTitulo() {
		return exibiuBannerDeAssinatura().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkCorretoNoTitulo() {
		return !exibiuBannerDeAssinatura().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTextoQuemAssina() throws InterruptedException {
		getDriver().findElement(By.xpath("//*[@id=\"subscriptionFooter\"]/div/p/a")).click();
		esperaCarregar(1);
		return !getDriver().findElement(By.className("advantages")).findElement(By.className("title")).getText().isEmpty();
	}

	public boolean exibiuBannerDeProdutos() {
		return getDriver().findElement(By.className("advantages")).findElement(By.tagName("img")).isDisplayed();
	}
	
	public String exibiuPrimeiroParagrafoDeVantagens() throws InterruptedException {
		return getDriver().findElement(By.className("advantages")).findElements(By.tagName("p")).get(1).getText();
	}
	
	public String exibiuSegundoParagrafoDeVantagens() throws InterruptedException {
		return getDriver().findElement(By.className("advantages")).findElements(By.tagName("p")).get(2).getText();
	}
	
	public String exibiuTerceiroParagrafoDeVantagens() throws InterruptedException {
		return getDriver().findElement(By.className("advantages")).findElements(By.tagName("p")).get(3).getText();
	}
	
	public WebElement exibiuClasseSubscriptionContent() {
		return getDriver().findElement(By.className("subscriptionContent"));
	}
	
	public WebElement exibiuClasseSignUp() {
		return getDriver().findElement(By.className("subscriptionContent")).findElement(By.className("signUp"));
	}
	
	public String exibiuTituloQueroAssinar() {
		return exibiuClasseSignUp().getText();
	}

	public boolean exibiuLinkNoTextoDeQueroAssinar() {
		return exibiuClasseSignUp().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkCorretoNoTextoDeQueroAssinar() {
		return !exibiuClasseSignUp().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public boolean exibiuBannerDeRelacionamentoOGlobo() {
		return exibiuClasseSubscriptionContent().findElement(By.className("seal")).isDisplayed();
	}

	public boolean exibiuPaginacaoParaDireita() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionFooter\"]/div/div/div[1]/a[2]")).isDisplayed();
	}
	
	public boolean exibiuPaginacaoParaEsquerdaComoDesabilitada() {
		return exibiuClasseSubscriptionContent().findElement(By.className("subscriptionNav")).findElements(By.tagName("a")).get(0).getAttribute("class").contains("disabled");
	}
	
	public boolean exibiuPaginacaoParaEsquerda() throws InterruptedException {
		clicarParaPaginarParaDireita();
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionFooter\"]/div/div/div[1]/a[1]")).isDisplayed();
	}

	public boolean exibiuTituloSiteDoGlobo() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[2]/div[1]/p[1]")).isDisplayed();
	}

	public String exibiuTextoSiteDoGlobo() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[2]/div[1]/p[2]")).getText();
	}

	public boolean exibiuSegundoBanner() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[2]/img")).isDisplayed();
	}

	public boolean exibiuTituloEdicaoDigital() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[2]/div[2]/p[1]")).isDisplayed();
	}

	public String exibiuTextoEdicaoDigital() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[2]/div[2]/p[2]")).getText();
	}
	
	public boolean exibiuTituloSiteAcervo() throws InterruptedException {
		//getDriver().findElement(By.xpath("//*[@id=\"subscriptionFooter\"]/div/div/div[1]/a[2]")).click();
		//esperaCarregar(1);
		clicarParaPaginarParaDireita();
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[3]/div[1]/p[1]")).isDisplayed();
	}

	public Object exibiuTextoSiteAcervo() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[3]/div[1]/p[2]")).getText();
	}

	public boolean exibiuTerceiroBanner() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[3]/img")).isDisplayed();
	}
	
	public boolean exibiuTituloGloboMais() {
		return getDriver().findElement(By.xpath("//*[@id=\"subscriptionSlider\"]/li[3]/div[2]/p[1]")).isDisplayed();
	}

	public String exibiuTextoGloboMais() throws InterruptedException {
		return exibiuClasseSubscriptionContent().findElement(By.className("acervo")).findElement(By.className("right")).findElements(By.tagName("p")).get(1).getText();
	}
	
	public boolean exibiuPaginacaoParaADireita() {
		return exibiuClasseSubscriptionContent().findElement(By.className("subscriptionNav")).findElements(By.tagName("a")).get(1).getAttribute("class").contains("disabled");
	}
}