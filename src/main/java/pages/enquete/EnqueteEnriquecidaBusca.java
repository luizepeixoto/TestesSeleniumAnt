package pages.enquete;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EnqueteEnriquecidaBusca extends AceitacaoAbstractTest {
	
	public EnqueteEnriquecidaBusca() throws Exception {
		super();
	}
	
	public EnqueteEnriquecidaBusca(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuClassePollHeader() {
		return getDriver().findElement(By.className("poll-header clearfix"));
	}
	
	public List<WebElement> listaDeOpcoesDeVotoDeCadaEnquete() {
		return getDriver().findElement(By.className("candidatos")).findElements(By.tagName("li"));
	}

	public boolean exibiuCampoDeBusca() {
		return getDriver().findElement(By.xpath("//div[@class='poll-search']")).isDisplayed();
	}
	
	public String exibiuPlaceholderNoCampoDeBusca() {
		return getDriver().findElement(By.xpath("//div[@class='poll-search']/input")).getAttribute("placeholder");
	}
	
	public void preencherOCampoBusca() throws InterruptedException{
		getDriver().findElement(By.xpath("//div[@class='poll-search']/input")).sendKeys("Bloco");
		Thread.sleep(1000);
	}
	
	public boolean exibiuResultadoDeBuscaCorreto() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			if(!listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.tagName("h2")).getText().contains("Bloco")){
				return false;
			}
		}
		return true;
	}
}
