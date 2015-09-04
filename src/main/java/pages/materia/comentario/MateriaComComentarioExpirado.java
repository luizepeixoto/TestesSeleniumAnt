package pages.materia.comentario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaComComentarioExpirado extends AceitacaoAbstractTest {

	public MateriaComComentarioExpirado() throws Exception {
		super();
	}
	
	public void esperaCaixaDeComentarioCarregar(){
		while(! getDriver().findElement(By.className("comentarios")).isDisplayed()){
			if(getDriver().findElement(By.className("comentarios")).isDisplayed()){
				break;
			}
		}
	}
	
	public MateriaComComentarioExpirado(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuBalaoDeComentario() {
		return getDriver().findElement(By.className("menu-interacao")).findElement(By.className("comentar")).isDisplayed();
	}

	public String exibiuTituloDeComentarioFinalizado() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.cssSelector("div.finalizada")).getText();
	}						
	
	public boolean exibiuTextoDeResponsabilidadeDoAutor() throws InterruptedException {
		esperaCarregar(1);
		return !getDriver().findElement(By.xpath("//header/p")).getText().isEmpty();
	}						
	
	public String exibiuTituloPerguntasFrequentes() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//header/ul/li/a")).getText().toLowerCase();
	}
	
	public boolean exibiuLinkNoTituloPerguntasFrequentes() throws InterruptedException {
//		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//header/ul/li/a")).isDisplayed();
	}
	
	public String exibiuTituloTermosDeUso() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//header/ul/li[2]/a")).getText().toLowerCase();
	}
	
	public boolean exibiuLinkNoTituloTermosDeUso() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//header/ul/li[2]/a")).isDisplayed();
	}
	
	public boolean exibiuLogin() {
		final List<WebElement> lista = getDriver().findElements(By.cssSelector("p.btn"));
		return lista.size() == Integer.parseInt("0");
	}
	
	public boolean exibiuBotaoResponder() {
		final List<WebElement> lista = getDriver().findElements(By.cssSelector("span.bt-responder"));
		return lista.size() == Integer.parseInt("0");
	}
	
	public boolean exibiuBotaoDenunciar() {
		final List<WebElement> lista = getDriver().findElements(By.xpath("//li[@id='c17978']/div/p[3]/span[2]"));
		return lista.size() == Integer.parseInt("0");
	}
}