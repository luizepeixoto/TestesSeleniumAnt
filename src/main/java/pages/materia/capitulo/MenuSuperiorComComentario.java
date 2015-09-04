package pages.materia.capitulo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuSuperiorComComentario extends AceitacaoAbstractTest {
	
	public MenuSuperiorComComentario() throws Exception {
		super();
	}
	
	public MenuSuperiorComComentario(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuBalaoDeComentarios() {
		List<WebElement> possuiBalaoDeComentarios = getDriver().findElement(By.className("menu-interacao")).findElements(By.id("comentar"));
		return (possuiBalaoDeComentarios.size() > Integer.parseInt("0"));
	}

	public boolean exibiuTituloComentarios() {
		List<WebElement> possuiTituloComentarios = getDriver().findElements(By.className("comentarios"));
		return (possuiTituloComentarios.size() > Integer.parseInt("0"));
	}
	
	public String exibiuTituloParaComentar() throws InterruptedException{
		getDriver().manage().deleteAllCookies();
		Thread.sleep(3000);
		return getDriver().findElement(By.cssSelector("p.title")).getText().toLowerCase();
	}

	public WebElement exibiuBotaoDeComentar() {
		return getDriver().findElement(By.cssSelector("p.btn"));
	}

	public String exibiuTituloComentarDentroDoBotao() {
		return getDriver().findElement(By.cssSelector("p.btn > a")).getText().toLowerCase();
	}
	
	public boolean exibiuTextoDeResponsabilidadeDoAutor() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return !getDriver().findElement(By.xpath("//header/p[2]")).getText().isEmpty();
	}						
	
	public String exibiuTituloPerguntasFrequentes() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return getDriver().findElement(By.xpath("//header/ul/li/a")).getText().toLowerCase();
	}
	
	public boolean exibiuLinkNoTituloPerguntasFrequentes() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return getDriver().findElement(By.xpath("//header/ul/li/a")).isDisplayed();
	}
	
	public String exibiuTituloTermosDeUso() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return getDriver().findElement(By.xpath("//header/ul/li[2]/a")).getText().toLowerCase();
	}
	
	public boolean exibiuLinkNoTituloTermosDeUso() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return getDriver().findElement(By.xpath("//header/ul/li[2]/a")).isDisplayed();
	}
}