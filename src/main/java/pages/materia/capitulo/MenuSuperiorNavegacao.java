package pages.materia.capitulo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pages.tealium.MarcacoesDoTealium;

import br.com.infoglobo.pages.Navegador;

public class MenuSuperiorNavegacao extends MarcacoesDoTealium {
	
	public MenuSuperiorNavegacao() throws Exception {
		super();
	}
	
	public MenuSuperiorNavegacao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	void executaScrollParaBaixo() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(0, 3000)");
		Thread.sleep(1500);
	}
	
	void executaScrollParaAparecerOMenu() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(0, 6000)");
		Thread.sleep(1500);
	}
	
	void executaScrollParaCima() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(1600, 0)"); 
		Thread.sleep(1000);
	}
	
	public WebElement exibiuMenuNoTopo() {
		return getDriver().findElement(By.id("sticker-capitulo"));
	}

	public boolean exibiuTituloDaMateriaNoMenu() throws InterruptedException {
		executaScrollParaAparecerOMenu();
		Thread.sleep(1000);
		return !exibiuMenuNoTopo().findElement(By.className("cap-titulo")).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean exibiuTituloDaMateriaPrincipalNoMenuNoTopo() {
		String tituloDaMateriaPrincipal = getDriver().findElement(By.className("materia-capitulos")).findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText();
		String tituloDaMateriaNoMenu = exibiuMenuNoTopo().findElement(By.className("cap-titulo")).findElement(By.tagName("a")).getAttribute("innerHTML").substring(0, 50);	
		
		return tituloDaMateriaPrincipal.contains(tituloDaMateriaNoMenu);
	}
	
	public List<WebElement> listaDe12CapitulosDoMenu() {
		return exibiuMenuNoTopo().findElement(By.className("completo")).findElements(By.tagName("li"));
	}

	public boolean exibiuUmaListaDe12Capitulos() {
		return listaDe12CapitulosDoMenu().size() == Integer.parseInt("12");
	}

	public boolean exibiuTituloDeCadaMateriaNoToolTipDoMenu() {
		for(int i=0; i<listaDe12CapitulosDoMenu().size(); i++){
			if(listaDe12CapitulosDoMenu().get(i).findElement(By.tagName("a")).getAttribute("outerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public List<WebElement> listaTotalDeMaterias() {
		return getDriver().findElement(By.className("materia-capitulos")).findElements(By.className("capituloPage"));
	}
	
	public boolean exibiuOTituloCorretoNoToolTipParaCadaCapituloDoMenu() throws InterruptedException {
		executaScrollParaBaixo();
		Thread.sleep(1000);
		for(int i=0; i<listaDe12CapitulosDoMenu().size(); i++){
			for(int y=0; y<listaTotalDeMaterias().size(); y++){
				
				String tituloAtualNoToolTip = listaDe12CapitulosDoMenu().get(i).findElement(By.tagName("a")).getAttribute("original-title");
				
				String tituloAtualDoCapitulo = listaTotalDeMaterias().get(y).findElement(By.className("titulo")).getText().toLowerCase();			
				
				final String auxiliar = tituloAtualNoToolTip.substring(tituloAtualNoToolTip.indexOf("·") +2);			
				
				if(!tituloAtualDoCapitulo.contains(auxiliar.toLowerCase())){
					return false;
				}
			}
			
		}
		return true;
	}
	
	public boolean executaNavegacaoPeloMenu() throws InterruptedException {
		executaScrollParaBaixo();
		getDriver().findElement(By.linkText("1")).click();
		if(!listaDe12CapitulosDoMenu().get(0).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("2")).click();
		if(!listaDe12CapitulosDoMenu().get(1).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("3")).click();
		if(!listaDe12CapitulosDoMenu().get(2).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("4")).click();
		if(!listaDe12CapitulosDoMenu().get(3).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("5")).click();
		if(!listaDe12CapitulosDoMenu().get(4).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("6")).click();
		if(!listaDe12CapitulosDoMenu().get(5).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("7")).click();
		if(!listaDe12CapitulosDoMenu().get(6).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("8")).click();
		if(!listaDe12CapitulosDoMenu().get(7).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("9")).click();
		if(!listaDe12CapitulosDoMenu().get(8).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("10")).click();
		if(!listaDe12CapitulosDoMenu().get(9).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("11")).click();
		if(!listaDe12CapitulosDoMenu().get(10).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
	//	executaScrollParaBaixo();
		getDriver().findElement(By.linkText("12")).click();
		if(!listaDe12CapitulosDoMenu().get(11).findElement(By.className("active")).isDisplayed()){
			return false;
		}
		esperaCarregar3Segundos();
		executaScrollParaBaixo();
		return true;
	}
}