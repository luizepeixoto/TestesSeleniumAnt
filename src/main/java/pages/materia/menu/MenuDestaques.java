package pages.materia.menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuDestaques extends AceitacaoAbstractTest {

	public MenuDestaques() throws Exception {
		super();
	}
	
	public MenuDestaques(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement getDestaquesDoMenu() {
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver().findElement(By.className("assunto-destaque"));
	}

	public void mouseOver() throws InterruptedException{
		getDriver().manage().deleteAllCookies();
		//WebElement menu = getDriver().findElement(By.cssSelector("#bt-editoria > a"));
		WebElement menu = getDriver().findElement(By.xpath("//*[@id=\"bt-editoria\"]/a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(1000);
	}
	
	public void mouseOverCom2Segundos() throws InterruptedException{
		WebElement menu = getDriver().findElement(By.cssSelector("#bt-editoria > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);
	}
	
	public boolean oTituloAssuntosEmDestaqueEstaSendoExibidoNoMenu() throws InterruptedException {
		
		WebElement menu = getDriver().findElement(By.xpath("//*[@id=\"bt-editoria\"]/a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);
		
		//return getDriver().findElement(By.xpath("//*[@id=\"menu-editoria\"]/div[1]/div/div/div[2]/h3")).getText().equals("ASSUNTOS EM DESTAQUE");
		return getDriver().findElement(By.xpath("//*[@id='menu-editoria']/div[1]/div/div/div[2]/h3")).getAttribute("innerHTML").equals("Assuntos em Destaque");
	}

	public boolean oMenuPossuiDestaquesPrincipais(){
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElements(By.className("large-5"));
		return resultadoEsperado.size()>0;
	}

	public boolean aPrimeiraMateriaEmDestaquePossuiFoto() throws InterruptedException {
		
		mouseOver();
		
		List<WebElement> TotalDeLarge5 = getDestaquesDoMenu().findElements(By.className("large-5"));
				
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElements(By.className("large-5")).get(0).findElements(By.tagName("img"));
		
		if(resultadoEsperado.size()>0){
			if(getDestaquesDoMenu().findElements(By.className("large-5")).get(0).findElement(By.tagName("img")).isDisplayed()){
				return true;
			}
		}else{
			if(TotalDeLarge5.get(1).findElement(By.className("subtitulo")).getText().isEmpty()){
				return false;
			}
		}
		return false;
	}
	
	public boolean oWidthDaFotoEhDe380Px() throws InterruptedException {
		mouseOver();
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElements(By.className("large-5")).get(0).findElements(By.tagName("img"));
		if(resultadoEsperado.size()>0){
			if(Integer.parseInt(getDestaquesDoMenu().findElements(By.className("large-5")).get(0).findElement(By.tagName("img")).getAttribute("width")) > 380){
				return false;
			}
		}
		return true;
	}
	
	public boolean oHeightDaFotoEhDe230Px() throws InterruptedException {
		mouseOver();
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElements(By.className("large-5")).get(0).findElements(By.tagName("img"));
		if(resultadoEsperado.size()>0){
			if(Integer.parseInt(getDestaquesDoMenu().findElements(By.className("large-5")).get(0).findElement(By.tagName("img")).getAttribute("height")) > 230){
				return false;
			}
		}
		return true;
	}
	
	public boolean aSegundaMateriaEmDestaquePossuiFoto() throws InterruptedException {
		getDriver().manage().window().maximize();
		
		mouseOver();
		
		List<WebElement> TotalDeLarge5 = getDestaquesDoMenu().findElements(By.className("large-5"));
				
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElements(By.className("large-5")).get(1).findElements(By.tagName("img"));
		
		if(resultadoEsperado.size()>0){
			if(getDestaquesDoMenu().findElements(By.className("large-5")).get(1).findElement(By.tagName("img")).isDisplayed()){
				return true;
			}
		}else{
			if(TotalDeLarge5.get(1).findElement(By.className("subtitulo")).getText().isEmpty()){
				return false;
			}
		}
		return false;
	}
	
	public boolean oWidthDaSegundaFotoEhDe380Px() throws InterruptedException {
		mouseOver();
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElements(By.className("large-5")).get(1).findElements(By.tagName("img"));
		if(resultadoEsperado.size()>0){
			if(Integer.parseInt(getDestaquesDoMenu().findElements(By.className("large-5")).get(1).findElement(By.tagName("img")).getAttribute("width")) > 380){
				return false;
			}
		}
		return true;
	}
	
	public boolean oHeightDaSegundaFotoEhDe230Px() throws InterruptedException {
		mouseOver();
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElements(By.className("large-5")).get(1).findElements(By.tagName("img"));
		if(resultadoEsperado.size()>0){
			if(Integer.parseInt(getDestaquesDoMenu().findElements(By.className("large-5")).get(1).findElement(By.tagName("img")).getAttribute("height")) > 230){
				return false;
			}
		}
		return true;
	}
	
	public boolean osTitulosDasMateriasEmDestaqueEstaoSendoExibidos() throws InterruptedException {
		mouseOver();
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElements(By.className("large-5"));

		for(int i=0; i<resultadoEsperado.size() ; i++){
			if(resultadoEsperado.get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean aListaDeMateriaEmDestaqueEstaSendoExibida() throws InterruptedException {
		mouseOverCom2Segundos();
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElement(By.className("large-6")).findElements(By.tagName("li"));

		return resultadoEsperado.size()>0;
	}

	public boolean asMateriasEmDestaquePossuemTitulo() throws InterruptedException {
		//mouseOverCom2Segundos();
//		WebElement menu = getDriver().findElement(By.cssSelector("#bt-editoria > a"));
//		Actions mouseOver = new Actions(getDriver());
//		mouseOver.moveToElement(menu).perform();
//		Thread.sleep(2000);
		mouseOver();
		
		List<WebElement> resultadoEsperado = getDriver().findElement(By.className("assunto-destaque")).findElement(By.className("large-6")).findElements(By.tagName("li"));
		
		for(int i=0; i<resultadoEsperado.size(); i++){
			if(resultadoEsperado.get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean asMateriasEmDestaquePossuemUmLinkNoTitulo() throws InterruptedException {

//		WebElement menu = getDriver().findElement(By.cssSelector("#bt-editoria > a"));
//		Actions mouseOver = new Actions(getDriver());
//		mouseOver.moveToElement(menu).perform();
//		Thread.sleep(2000);
		mouseOver();
		
		List<WebElement> resultadoEsperado = getDriver().findElement(By.className("assunto-destaque")).findElement(By.className("large-6")).findElements(By.tagName("li"));
		
		for(int i=0; i<resultadoEsperado.size(); i++){
			if(!resultadoEsperado.get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean oLinkNoTituloDasMateriasEmDestaqueEhValido() throws InterruptedException {

		WebElement menu = getDriver().findElement(By.cssSelector("#bt-editoria > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);
		
		List<WebElement> resultadoEsperado = getDestaquesDoMenu().findElement(By.className("large-6")).findElements(By.tagName("li"));
		
		for(int i=0; i<resultadoEsperado.size(); i++){
			if(resultadoEsperado.get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
}
