package pages.materia.comentario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class FormularioBotaoResponder extends AceitacaoAbstractTest {

	public FormularioBotaoResponder(Navegador navegador) throws Exception {
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
	
	public boolean exibiuOBotaoDeResponder() {
		return getDriver().findElement(By.xpath(".//span[contains(@class, 'bt-responder')]")).isDisplayed();
	}
	
	public String exibiuOTituloDeResponder() {
		return getDriver().findElement(By.xpath(".//span[contains(@class, 'bt-responder')]")).getText();
	}
	
	public void clicarNoBotaoDeResponder() {
		getDriver().findElement(By.xpath(".//span[contains(@class, 'bt-responder')]")).click();
	}
	
	public boolean exibiuUmaNovaCaixaDeComentario() {
		return getDriver().findElement(By.xpath(".//form[contains(@class, 'comment-reply')]")).isDisplayed();
	}
	
	public List<WebElement> listaComTodosOsComentarios(){
		return getDriver().findElement(By.className("lista-comentarios")).findElements(By.tagName("li"));
	}
	
	public WebElement acessoAoPrimeiroBlocoDeComentario(){
		return listaComTodosOsComentarios().get(0).findElement(By.className("form")).findElement(By.className("comment-reply"));
	}
	
	public boolean exibiuONomeDoUsuario() {
		return !acessoAoPrimeiroBlocoDeComentario().findElement(By.className("nomeDoUsuario")).getText().isEmpty();
	}
	
	public boolean exibiuOTituloDeCaracteresRestantes() {
		return acessoAoPrimeiroBlocoDeComentario().findElement(By.className("caracteres")).getAttribute("textContent").contains("Caracteres restantes:");
	}

	public boolean exibiuOTotalDeCaracteresParaOComentario() {
		return acessoAoPrimeiroBlocoDeComentario().findElement(By.className("caracteres")).findElement(By.className("limite")).getAttribute("textContent").equals("500");
	}
	
	public boolean exibiuAreaDeComentario() {
		return acessoAoPrimeiroBlocoDeComentario().findElement(By.tagName("textarea")).isDisplayed();
	}
	
	public String exibiuCaptchaTexto() {
		return acessoAoPrimeiroBlocoDeComentario().findElement(By.className("captcha")).findElement(By.tagName("span")).getAttribute("textContent");
	}
	
	public boolean exibiuAreaDoCaptcha() {
		return acessoAoPrimeiroBlocoDeComentario().findElement(By.className("captcha")).findElement(By.tagName("input")).isDisplayed();
	}
	
	public boolean exibiuImagemDoCaptcha() {
		return acessoAoPrimeiroBlocoDeComentario().findElement(By.className("captcha")).findElement(By.className("img")).findElement(By.tagName("img")).isDisplayed();
	}
	
	public String exibiuTextoDeTrocarImagemDoCaptcha() {
		return acessoAoPrimeiroBlocoDeComentario().findElement(By.className("captcha")).findElement(By.tagName("a")).getAttribute("textContent");
	}

	public boolean exibiuBotaoEnviar() {
		//*[@id='formComentario']/*[contains(@class, 'button')]
		return  acessoAoPrimeiroBlocoDeComentario().findElement(By.className("button-form")).isDisplayed();
	}
}
