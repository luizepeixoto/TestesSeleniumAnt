package pages.materia.comentario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ComentarioInvalido extends AceitacaoAbstractTest {

	public ComentarioInvalido() throws Exception {
		super();
	}

	public ComentarioInvalido(Navegador navegador) throws Exception {
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
	
	public void preencherComentarioComTextoInvalido() {
		String textoComLink = "http://globostg.globoi.com/teste-jenkins/webdriver-os-comentarios-para-esta-materia-devem-permanecer-em-aberto-1031156#comentshttp://globostg.globoi.com/teste-jenkins/webdriver-os-comentarios-para-esta-materia-devem-permanecer-em-aberto-1031156#comentshttp://globostg.globoi.com/teste-jenkins/webdriver-os-comentarios-para-esta-materia-devem-permanecer-em-aberto-1031156#comentshttp://globostg.globoi.com/teste-jenkins/webdriver-os-comentarios-para-esta-materia-devem-permanecer-em-aberto-1031156#com";
		getDriver().findElement(By.id("mensagemComentario")).sendKeys(textoComLink);
	}
	
	public void preencherComentarioComTextoValido() {
		String textoValido = "Muito interessante o texto!";
		getDriver().findElement(By.id("mensagemComentario")).sendKeys(textoValido);
	}
	
	public void preencherOCaptcha() {
		String captchaAleatorio = "gevc";
		getDriver().findElement(By.id("captchaComentario01")).sendKeys(captchaAleatorio);
	}
	
	public void apertarOEnter() {
		getDriver().findElement(By.id("captchaComentario01")).sendKeys(Keys.RETURN);
	}
	
	public String exibiuMensagemDeErro() {
		return getDriver().findElement(By.cssSelector("span.msg.erro")).getAttribute("textContent");
	}
	
	public String exibiuMensagemDeErroDoCaptcha() {
		return getDriver().findElement(By.cssSelector("span.msg.erro")).getAttribute("textContent");
	}
	
	public String exibiuMensagemParaPreencherOTexto(){
		return getDriver().findElement(By.cssSelector("span.msg.erro")).getAttribute("textContent");
	}
	
	public boolean verificaOTotalDoCaracteresRestantes() throws InterruptedException{
		getDriver().findElement(By.id("mensagemComentario")).sendKeys("Testando Caracteres");
		esperaCarregar(3);
		String totalDeComentarios = getDriver().findElement(By.cssSelector("strong.limite")).getAttribute("textContent");
		return Integer.parseInt(totalDeComentarios) < 500;
	}

	public boolean exibiuMensagemParaPreencherOTextoApenasUmaVez() {
		List<WebElement> listaComClassesMSGErro = getDriver().findElement(By.className("comentarios")).findElements(By.className("erro"));
		
		if(listaComClassesMSGErro.size() > Integer.parseInt("1")){
			imprimirMensagemDeErroGenerica("Verificar se está sendo exibido mais de uma mensagem de erro.");
			return false;
		}
		
		return true;
	}
}