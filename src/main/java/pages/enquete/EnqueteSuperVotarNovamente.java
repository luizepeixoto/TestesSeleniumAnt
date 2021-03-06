package pages.enquete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EnqueteSuperVotarNovamente extends AceitacaoAbstractTest {
	
	public EnqueteSuperVotarNovamente() throws Exception {
		super();
	}
	
	public EnqueteSuperVotarNovamente(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void clicarEmVotar() throws InterruptedException {
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='tpl-content']/div[1]/welcome-link/div/a")).click();		
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
		getDriver().findElement(By.xpath("//*[@id='tpl-content']/div[2]/div[1]/form/div[4]/button")).click();	
	}
	
	public WebElement exibiuClassePollHeader() {
		return getDriver().findElement(By.className("poll-header"));
	}
	
	public WebElement exibiuOpcaoDeVotarNovamente() {
		return getDriver().findElement(By.className("candidatos")).findElement(By.className("voted"));
	}
	
	public boolean exibiuUmaFotoNaOpcaoVotada() {
		return exibiuOpcaoDeVotarNovamente().findElement(By.className("inner")).findElement(By.className("img")).findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuUmFlagNaFotoDaOpcaoVotada() {
		return exibiuOpcaoDeVotarNovamente().findElement(By.className("inner")).findElement(By.className("img")).findElement(By.tagName("span")).isDisplayed();
	}

	public boolean exibiuUmTituloParaOpcaoVotada() {
		return !exibiuOpcaoDeVotarNovamente().findElement(By.className("inner")).findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuUmSubtituloParaOpcaoVotada() {
		return !exibiuOpcaoDeVotarNovamente().findElement(By.className("inner")).findElement(By.className("sub")).getText().isEmpty();
	}

	public boolean exibiuAsOpcoesDeVotoComUmaDescricao() {
		return !exibiuOpcaoDeVotarNovamente().findElement(By.className("inner")).findElement(By.className("desc")).getText().isEmpty();
	}

	public String exibiuOBotaoDeVotado() {
		return exibiuOpcaoDeVotarNovamente().findElement(By.className("inner")).findElement(By.className("vote-btn")).findElement(By.tagName("a")).getText();
	}

	public String exibiuTituloDeVerResultado() {
		return exibiuOpcaoDeVotarNovamente().findElement(By.className("inner")).findElement(By.className("result")).findElement(By.tagName("a")).getText();
	}

	public boolean exibiuLinkDeVerResultado() {
		return exibiuOpcaoDeVotarNovamente().findElement(By.className("inner")).findElement(By.className("result")).findElement(By.tagName("a")).isDisplayed();
	}

}
