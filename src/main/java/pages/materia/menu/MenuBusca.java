package pages.materia.menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuBusca extends AceitacaoAbstractTest {
	
	public MenuBusca() throws Exception {
		super();
	}
	
	public MenuBusca(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void executaClickMenuBusca(){
		getDriver().findElement(By.className("search-link")).click();
	}
	
	public void executaClearNoCampoDeBusca(){
		getDriver().findElement(By.className("search-link")).clear();
	}
	
	public void executaClickParaBuscar(){
		getDriver().findElement(By.className("search-submit")).click();
	}
	
	public void esperarPaginaCarregar() throws InterruptedException{
		Thread.sleep(6000);
	}
	
	public WebElement exibiuBoxDeBusca() throws InterruptedException{
		esperarPaginaCarregar();
		return getDriver().findElement(By.id("buscar"));
	}
	
	public String getBoxBuscaTitulo(){
		return getDriver().findElement(By.className("search-link")).getText();
	}
	
	public boolean verificarExibicaoDaBusca() throws InterruptedException{
		executaClickMenuBusca();
		esperarPaginaCarregar();
		return getDriver().findElement(By.xpath("//*[@id='formBusca']/div/input")).isDisplayed();
	}
	
	public WebElement getClassContainer(){
		return getDriver().findElement(By.className("input-container"));
	}
	
	public boolean getBoxBuscaPlaceholder(){
		return getClassContainer().findElement(By.tagName("input")).getAttribute("placeholder").equals("Buscar");
	}
	
	public boolean executarBuscaValidaComResultado() throws InterruptedException{
		esperarPaginaCarregar();
		executaClickMenuBusca();
		getDriver().findElement(By.xpath("//*[@class='search-input']")).sendKeys("big brother");
		executaClickParaBuscar();
		esperarPaginaCarregar();
		
		int i=1;
		
		while (! getDriver().findElement(By.className("resultado_da_busca")).isDisplayed()) {
			System.out.println("Tentativa " + i);
			if (getDriver().findElement(By.className("resultado_da_busca")).isDisplayed()) {
				break;
			}
			i++;
		}
		
		System.out.println("A Página de busca tentou carregar " + i);
		
		List<WebElement> resultadoEncontrado = getDriver().findElements(By.className("resultado_da_busca"));
		return resultadoEncontrado.size() > Integer.parseInt("0");
	}
	
	public boolean executarBuscaValidaSemResultado() throws InterruptedException{
		esperarPaginaCarregar();
		executaClickMenuBusca();
		getDriver().findElement(By.xpath("//*[@class='search-input']")).sendKeys("ddqwdwqdwqdwqdwq");
		executaClickParaBuscar();
		esperarPaginaCarregar();
		
		int i=1;
		
		while (! getDriver().findElement(By.className("nao-encontrado")).isDisplayed()) {
			System.out.println("Tentativa " + i);
			if (getDriver().findElement(By.className("nao-encontrado")).isDisplayed()) {
				break;
			}
			i++;
		}
		
		System.out.println("A Página de busca tentou carregar " + i);
		
		List<WebElement> resultadoEncontrado = getDriver().findElements(By.className("nao-encontrado"));
		return resultadoEncontrado.size() > Integer.parseInt("0");
	}
	
	public boolean executarBuscaInvalida() throws InterruptedException{
		esperarPaginaCarregar();
		executaClickMenuBusca();
		getDriver().findElement(By.xpath("//*[@class='search-input']")).sendKeys("<script>alert();</script>");
		executaClickParaBuscar();
		esperarPaginaCarregar();
		
		int i=1;
		
		while (! getDriver().findElement(By.className("proximidade")).isDisplayed()) {
			System.out.println("Tentativa " + i);
			if (getDriver().findElement(By.className("proximidade")).isDisplayed()) {
				break;
			}
			i++;
		}
		
		System.out.println("A Página de busca tentou carregar " + i);
		
		List<WebElement> resultadoEncontrado = getDriver().findElements(By.className("proximidade"));
		return resultadoEncontrado.size() > Integer.parseInt("0");
	}

	public WebElement exibiuBoxAssinatura() {
		return getDriver().findElement(By.id("banner-assinatura"));
	}
	
	public boolean getBoxAssinaturaLink() {
		return exibiuBoxAssinatura().findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean getBoxAssinaturaLinkValido() {
		return exibiuBoxAssinatura().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public String getBoxAssinaturaLinkTexto() {
		return exibiuBoxAssinatura().findElement(By.tagName("a")).getText();
	}
}
