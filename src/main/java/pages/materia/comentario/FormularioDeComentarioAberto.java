package pages.materia.comentario;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class FormularioDeComentarioAberto extends AceitacaoAbstractTest {

	public FormularioDeComentarioAberto() throws Exception {
		super();
	}

	public FormularioDeComentarioAberto(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void esperaCaixaDeComentarioCarregar(){
		while(! getDriver().findElement(By.className("comentarios")).isDisplayed()){
			if(getDriver().findElement(By.className("comentarios")).isDisplayed()){
				break;
			}
		}
	}
	
	public void clicarNoBotaoDeComentario() throws InterruptedException {
		getDriver().findElement(By.xpath("(//a[contains(text(),'Comentar')])[2]")).click();
	}
	
	public boolean exibiuCaixaDeComentario() {
		return getDriver().findElement(By.xpath(".//form[@id='formComentario']")).isDisplayed();
	}
	
	public boolean exibiuONomeDoUsuario() {
		return !getDriver().findElement(By.cssSelector("strong.nome")).getAttribute("innerHTML").isEmpty();
	}

	public boolean exibiuOTituloDeCaracteresRestantes() {
		return getDriver().findElement(By.cssSelector("p.caracteres")).getAttribute("innerHTML").contains("Caracteres restantes:");
	}

	public boolean exibiuOTotalDeCaracteresParaOComentario() {
		return getDriver().findElement(By.cssSelector("strong.limite")).getAttribute("textContent").contains("500");
	}
	
	public boolean exibiuAreaDeComentario() {
		return getDriver().findElement(By.cssSelector("textarea")).isDisplayed();
	}
	
	public String exibiuCaptchaTexto() {
		return getDriver().findElement(By.cssSelector("div.captcha > span")).getAttribute("textContent");
	}
	
	public boolean exibiuAreaDoCaptcha() {
		return getDriver().findElement(By.xpath(".//textarea[@id='mensagemComentario']")).isDisplayed();
	}
	
	public boolean exibiuImagemDoCaptcha() {
		return getDriver().findElement(By.cssSelector("img[alt=\"captcha\"]")).isDisplayed();
	}
	
	public String exibiuTextoDeTrocarImagemDoCaptcha() {
		return getDriver().findElement(By.xpath(".//a[@id='trocarCaptcha']")).getAttribute("textContent");
	}

	public boolean exibiuBotaoEnviar() {
		//*[@id='formComentario']/*[contains(@class, 'button')]
		return getDriver().findElement(By.id("formComentario")).findElement(By.className("button-form")).isDisplayed();
	}
}