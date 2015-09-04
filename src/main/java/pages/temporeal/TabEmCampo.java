package pages.temporeal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabEmCampo extends AceitacaoAbstractTest {

	public TabEmCampo(Navegador navegador) throws Exception{
		super(navegador);	
	}

	public boolean exibiuOnzeTitularesEscaladosParaTimeUm() {
		//return getDriver().findElements(By.xpath("//div[@class='escalacao-time-A small-6 medium-6 large-6 column']/ul/li")).size() == Integer.parseInt("11");
		List<WebElement> totalDeJogadores = getDriver().findElement(By.className("escalacao-time-A")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
		return 	totalDeJogadores.size() > Integer.parseInt("10");
	}

	public boolean exibiuOnzeTitularesEscaladosParaTimeDois() {
		//return getDriver().findElements(By.xpath("//div[@class='escalacao-time-B right small-6 medium-6 large-6 column']/ul/li")).size() == Integer.parseInt("11");
		List<WebElement> totalDeJogadores = getDriver().findElement(By.className("escalacao-time-B")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
		return 	totalDeJogadores.size() > Integer.parseInt("10");
	}

	public boolean exibiuNomeDoTecnicoDoTimeUm() {
		return !getDriver().findElement(By.xpath("//div[@class='escalacao-time-A small-6 medium-6 large-6 column']/div/p[2]")).getText().isEmpty();
	}

	public boolean exibiuNomeDoTecnicoDoTimeDois() {
		return !getDriver().findElement(By.xpath("//div[@class='escalacao-time-B right small-6 medium-6 large-6 column']/div/p[2]")).getText().isEmpty();
	}												

	public boolean exibiuEscudoTimeUm() {
		return getDriver().findElement(By.xpath("//div[@class='placar-em-campo centralizador small-4 medium-4 large-4 column']/div/img")).isDisplayed();
	}

	public boolean exibiuEscudoTimeDois() {
		return getDriver().findElement(By.xpath("//div[@class='placar-em-campo centralizador small-4 medium-4 large-4 column']/div/img[2]")).isDisplayed();
	}

	public void clicarEmCampo() {
		getDriver().findElement(By.xpath("//*[@id='box-em-campo']/a")).click();
		
	}
	
	
	
	
	
	
	
	
	
	
}
