package pages.enquete;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EnqueteSuperResultados extends AceitacaoAbstractTest {
	
	public EnqueteSuperResultados() throws Exception {
		super();
	}
	
	public EnqueteSuperResultados(Navegador navegador) throws Exception {
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
	
	public WebElement exibiuOpcaoVotada() {
		return getDriver().findElement(By.className("candidatos")).findElement(By.className("voted"));
	}
	
	public boolean exibiuLinkDeVerResultado() {
		return exibiuOpcaoVotada().findElement(By.className("inner")).findElement(By.className("result")).findElement(By.tagName("a")).isDisplayed();
	}

	public void clicarEmVerResultados() {
		getDriver().findElement(By.cssSelector("p.result > a")).click();
	}

	public WebElement exibiuPaginaDeResultados() {
		return getDriver().findElement(By.className("resultado"));
	}
	
	public WebElement exibiuClasseHead() {
		return getDriver().findElement(By.className("head"));
	}
	
	public boolean exibiuTituloDaPaginaDeResultados() {
		return !exibiuClasseHead().findElement(By.tagName("h1")).getText().isEmpty();
	}

	public boolean exibiuUmaListaDeResultados() {
		return !exibiuClasseHead().findElement(By.tagName("h2")).getText().isEmpty();
	}
	
	public List<WebElement> listaTotalDeResultados() {
		return getDriver().findElement(By.className("resultado")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaFotoParaCadaUmDosResultados() {
		for(int i=0; i< listaTotalDeResultados().size(); i++){
			if(!listaTotalDeResultados().get(i).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAPosicaoDeCadaUmDosResultados() {
		for(int i=0; i< listaTotalDeResultados().size(); i++){
			if(listaTotalDeResultados().get(i).findElement(By.className("qnt")).findElement(By.className("pos")).getAttribute("innerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuBarraDeProgressoParaCadaUmDosResultados() {
		for(int i=0; i< listaTotalDeResultados().size(); i++){
			if(!listaTotalDeResultados().get(i).findElement(By.className("qnt")).findElement(By.className("bar")).findElement(By.tagName("div")).findElement(By.tagName("span")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOPercentualDeFotosDeCadaUmDosResultados() {
		for(int i=0; i< listaTotalDeResultados().size(); i++){
			if(listaTotalDeResultados().get(i).findElement(By.className("qnt")).findElement(By.className("bar")).getAttribute("innerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloParaCadaUmDosResultados() {
		for(int i=0; i< listaTotalDeResultados().size(); i++){
			if(listaTotalDeResultados().get(i).findElement(By.className("qnt")).findElement(By.tagName("h2")).getAttribute("innerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public WebElement exibiuOBotaoDeVotarNovamente() {
		return getDriver().findElement(By.className("vote-again"));
	}

	public boolean exibiuOBotaoDeVotarNovamenteComUmLink() {
		return exibiuOBotaoDeVotarNovamente().findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuOTituloCorretoNoBotaoDeVotarNovamente() {
		return exibiuOBotaoDeVotarNovamente().findElement(By.tagName("a")).getText();
	}

	public void clicarEmVotarNovamente() {
		getDriver().findElement(By.cssSelector("div.vote-again > a")).click();
	}

	public WebElement exibiuAPaginaDeVotacao() {
		return getDriver().findElement(By.className("candidatos"));
	}
}
