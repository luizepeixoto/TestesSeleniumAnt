package pages.capa.direita;

import org.openqa.selenium.By;
import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxDeEnqueteAberta extends AceitacaoAbstractTest {
	
	public BoxDeEnqueteAberta(Navegador navegador) throws Exception{
		super(navegador);
	}

	public boolean exibiuAEnquete() throws InterruptedException {
		esperaCarregar(1);
		executarScroll(getDriver().findElement(By.className("enquete")).getLocation().toString());
		return getDriver().findElement(By.xpath("//*[contains(@id , 'votacao-')]")).isDisplayed();
	}

	public String exibiuTituloEnquete() {
		return getDriver().findElement(By.xpath("//*[contains(@id , 'votacao-')]/p[1]")).getText();
	}

	public boolean exibiuPerguntaDaEnquete() {
		return getDriver().findElement(By.xpath("//*[contains(@id , 'votacao-')]/p[2]")).isDisplayed();
	}

	public boolean exibiuOpcoesDaEnquete() {
		return getDriver().findElement(By.xpath("//*[contains(@id , 'votacao-')]/form/fieldset")).isDisplayed();
	}
	
	public String exibiuLinkVerResultado() {
		return getDriver().findElement(By.xpath("//*[contains(@id , 'votacao-')]/a")).getText();
	}

	public void clicouNaPrimeiraOpcao() {
		getDriver().findElement(By.name("opcaoVoto")).click();
	}

	public String exibiuTextoDigiteOCaptcha() {
		executarScroll(getDriver().findElement(By.xpath("//*[contains(@id , 'votacao-')]/form/fieldset/div[6]")).getLocation().toString());
		return getDriver().findElement(By.className("formulario-enquete")).findElement(By.className("captcha-enquete")).findElement(By.tagName("em")).getText();
	}

	public boolean exibiuImagemCaptcha() {
		return getDriver().findElement(By.className("formulario-enquete")).findElement(By.className("captcha-enquete")).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuCampoParaDigitarOCodigoCaptcha() {
		return getDriver().findElement(By.className("formulario-enquete")).findElement(By.className("captcha-enquete")).findElement(By.tagName("input")).isDisplayed();
	}

	public boolean exibiuBotaoVotar() {
		return getDriver().findElement(By.className("formulario-enquete")).findElement(By.className("submit-enquete")).findElement(By.tagName("input")).isDisplayed();
	}
	
	public void clicarParaAmpliouAImagemDaEnquete() {
		getDriver().findElement(By.cssSelector("img.ng-scope")).click();
	}
	
	public boolean ampliouImagemDaEnquete() {
		return getDriver().findElement(By.cssSelector("img.cboxPhoto")).isDisplayed();
	}
	
	public void clicarParaFechouAmpliacaoDaImagemDaEnquete() {
		getDriver().findElement(By.id("cboxClose")).click();
	}

	public boolean fechouAmpliacaoDaImagemDaEnquete() {
		try { 
			getDriver().findElement(By.id("cboxLoadedContent")).findElement(By.tagName("img")).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}
	
	public boolean exibiuBotaoTrocarCaptcha() {
		return getDriver().findElement(By.className("formulario-enquete")).findElement(By.className("captcha-enquete")).findElement(By.className("reload")).isDisplayed();
	}
	
	public void inserirEmail(String email) throws InterruptedException {
		getDriver().findElement(By.id("login")).sendKeys(email);	
	}

	public void inserirSenha(String senha) throws InterruptedException {
		getDriver().findElement(By.id("password")).sendKeys(senha);
	}

	public void clicarNoBotaoEntrar() throws InterruptedException {
		getDriver().findElement(By.className("button")).click();
	}
}