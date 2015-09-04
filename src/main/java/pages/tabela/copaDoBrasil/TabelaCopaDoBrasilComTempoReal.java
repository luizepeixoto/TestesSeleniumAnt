package pages.tabela.copaDoBrasil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabelaCopaDoBrasilComTempoReal  extends AceitacaoAbstractTest {	
	
	public TabelaCopaDoBrasilComTempoReal(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement exibiuClasseCopaDoBrasil(){
		return getDriver().findElement(By.className("page-copadobrasil-2015"));
	}
	
	public String exibiuTituloDaTabela() {
		return exibiuClasseCopaDoBrasil().findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText();					
	}
	
	public void rolarAPaginaAteATabela(){
		executarScroll(getDriver().findElement(By.className("container-arroba-banner")).getLocation().toString());
	}
	
	public WebElement exibiuOMenuDaTabela(){
		return exibiuClasseCopaDoBrasil().findElement(By.className("menu-camp"));
	}
	
	public List<WebElement> listaDeOpcoesDeTabsDeFases() {
		return exibiuOMenuDaTabela().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuTabFasePrevia() {
		return listaDeOpcoesDeTabsDeFases().get(0).findElement(By.tagName("a")).getText().contains("FASE PRÉVIA");
	}

	public boolean exibiuTabPrimeiraFase() {
		return listaDeOpcoesDeTabsDeFases().get(1).findElement(By.tagName("a")).getText().contains("1ª FASE");
	}
	
	public boolean exibiuTabSegundaFase() {
		return listaDeOpcoesDeTabsDeFases().get(2).findElement(By.tagName("a")).getText().contains("2ª FASE");
	}
	
	public boolean exibiuTabTerceiraFase() {
		return listaDeOpcoesDeTabsDeFases().get(3).findElement(By.tagName("a")).getText().contains("3ª FASE");
	}

	public boolean exibiuTabOitavasDeFinal() {
		return listaDeOpcoesDeTabsDeFases().get(4).findElement(By.tagName("a")).getText().contains("OITAVAS");
	}

	public boolean exibiuTabQuartasDeFinal() {
		return listaDeOpcoesDeTabsDeFases().get(5).findElement(By.tagName("a")).getText().contains("QUARTAS");
	}

	public boolean exibiuTabSemiFinal() {
		return listaDeOpcoesDeTabsDeFases().get(6).findElement(By.tagName("a")).getText().contains("SEMIFINAL");
	}

	public boolean exibiuTabFinal() {
		return listaDeOpcoesDeTabsDeFases().get(7).findElement(By.tagName("a")).getText().contains("FINAL");
	}
	
	public void clicarTabFasePrevia() {
		getDriver().findElement(By.linkText("FASE PRÉVIA")).click();
	}

	public void clicarTabPrimeiraFase() {
		getDriver().findElement(By.linkText("1ª FASE")).click();
	}
	
	public void clicarTabSegundaFase() {
		getDriver().findElement(By.linkText("2ª FASE")).click();
	}
	
	public void clicarTabTerceiraFase() {
		getDriver().findElement(By.linkText("3ª FASE")).click();
	}

	public void clicarTabOitavasDeFinal() {
		getDriver().findElement(By.linkText("OITAVAS")).click();
	}

	public void clicarTabQuartasDeFinal() {
		getDriver().findElement(By.linkText("QUARTAS")).click();
	}

	public void clicarTabSemiFinal() {
		getDriver().findElement(By.linkText("SEMIFINAL")).click();
	}

	public void clicarTabFinal() {
		getDriver().findElement(By.linkText("FINAL")).click();
	}
	
	public boolean exibiuOBoxDeJogosPreliminares() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().manage().deleteAllCookies();
		List<WebElement> totalDeJogos = exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElement(By.className("row")).findElements(By.className("large-8")); 
		return totalDeJogos.size() == Integer.parseInt("2");
	}

	public boolean exibiuONumeroCorretoDeJogosDaPrimeiraFase() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> totalDeJogos = exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElement(By.className("row")).findElements(By.className("large-8")); 
		return totalDeJogos.size() == Integer.parseInt("80");
	}
	
	public boolean exibiuONumeroCorretoDeJogosDaSegundaFase() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> totalDeJogos = exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElement(By.className("row")).findElements(By.className("large-8")); 
		return totalDeJogos.size() == Integer.parseInt("40");
	}
	
	public boolean exibiuONumeroCorretoDeJogosDaTerceiraFase() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> totalDeJogos = exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElement(By.className("row")).findElements(By.className("large-8")); 
		return totalDeJogos.size() == Integer.parseInt("20");
	}
	
	public boolean exibiuONumeroCorretoJogosDasOitavas() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> totalDeJogos = exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElement(By.className("row")).findElements(By.className("large-8")); 
		return totalDeJogos.size() == Integer.parseInt("16");
	}
	
	public boolean exibiuONumeroCorretoDeJogosDasQuartas() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> totalDeJogos = exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElement(By.className("row")).findElements(By.className("large-8")); 
		return totalDeJogos.size() == Integer.parseInt("8");
	}
	
	public boolean exibiuONumeroCorretoDeJogosDaSemiFinais() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> totalDeJogos = exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElement(By.className("row")).findElements(By.className("large-8")); 
		return totalDeJogos.size() == Integer.parseInt("4");
	}
	
	public boolean exibiuONumeroCorretoDeJogosDaFinal() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> totalDeJogos = exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElement(By.className("row")).findElements(By.className("large-8")); 
		return totalDeJogos.size() == Integer.parseInt("2");
	}
	
	
	public List<WebElement> listaDeTotalDeJogos() {
		return exibiuClasseCopaDoBrasil().findElement(By.className("fases")).findElements(By.className("jogo"));
	}
}