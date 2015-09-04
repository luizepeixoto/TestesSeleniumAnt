package pages.enquete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EnqueteEnriquecidaVotada extends AceitacaoAbstractTest {
	
	public EnqueteEnriquecidaVotada() throws Exception {
		super();
	}
	
	public EnqueteEnriquecidaVotada(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void clicarEmVotar() throws InterruptedException {
		Thread.sleep(1000);
		getDriver().findElement(By.cssSelector("a.ng-binding")).click();		
	}

	public void inserirEmail(String email) throws InterruptedException {
		Thread.sleep(1000);
		getDriver().findElement(By.id("login")).sendKeys(email);	
	}

	public void inserirSenha(String senha) throws InterruptedException {
		Thread.sleep(1000);
		getDriver().findElement(By.id("password")).sendKeys(senha);
	}
	
	public void clicarNoBotaoEntrar() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.className("button")).click();	
	}
	
	public WebElement exibiuClassePollHeader() {
		return getDriver().findElement(By.className("poll-header"));
	}
	
	public WebElement exibiuOpcaoVotada() {
		return getDriver().findElement(By.className("candidatos")).findElement(By.className("closed"));
	}
	
	public boolean exibiuUmTituloParaOpcaoVotada() {
		return !exibiuOpcaoVotada().findElement(By.className("inner")).findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuUmSubtituloParaOpcaoVotada() {
		return !exibiuOpcaoVotada().findElement(By.className("inner")).findElement(By.className("sub")).getText().isEmpty();
	}

	public String exibiuOBotaoDeVotado() {
		return getDriver().findElement(By.xpath("//ul[@class='candidatos']/li/div/div[1]/span")).getText();
	}
}
