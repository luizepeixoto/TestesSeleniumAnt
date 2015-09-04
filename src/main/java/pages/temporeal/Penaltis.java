package pages.temporeal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class Penaltis extends AceitacaoAbstractTest {
	
	public Penaltis(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement exibiuBoxDeDisputaDePenaltis() {
		return getDriver().findElement(By.className("placar")).findElement(By.className("placar-penaltis"));
	}

	public boolean exibiuPlacarFinalDeDisputaDePenaltisDoTimeA() {
		return !exibiuBoxDeDisputaDePenaltis().findElement(By.className("gol-penalti-A")).getText().isEmpty();
	}

	public boolean exibiuPlacarFinalDeDisputaDePenaltisDoTimeB() {
		return !exibiuBoxDeDisputaDePenaltis().findElement(By.className("gol-penalti-B")).getText().isEmpty();
	}
	
	public String exibiuTextoDisputaDePenaltis() {
		return exibiuBoxDeDisputaDePenaltis().findElement(By.tagName("span")).getText();
	}
	
	public boolean exibiuDezBolinhasNaDisputaDePenaltisTimeA() {
		List<WebElement> listaTotalDePenaltis = getDriver().findElement(By.className("placar-penaltis")).findElement(By.className("penaltis-time-A")).findElements(By.tagName("li"));
		return listaTotalDePenaltis.size() == Integer.parseInt("10");
	}
	
	public boolean exibiuAlgumaDasDezBolinhasDePenaltisDoTimeAComoAproveitada() {
		List<WebElement> totalDePenaltisAproveitados = getDriver().findElement(By.className("placar-penaltis")).findElement(By.className("penaltis-time-A")).findElements(By.className("cobranca-aproveitada"));
		return totalDePenaltisAproveitados.size() > Integer.parseInt("0");
	}
	
	public boolean exibiuAlgumaDasDezBolinhasDePenaltisDoTimeAComoDesperdicada() {
		List<WebElement> totalDePenaltisAproveitados = getDriver().findElement(By.className("placar-penaltis")).findElement(By.className("penaltis-time-A")).findElements(By.className("cobranca-desperdicada"));
		return totalDePenaltisAproveitados.size() > Integer.parseInt("0");
	}
	
	public boolean exibiuDezBolinhasNaDisputaDePenaltisTimeB() {
		List<WebElement> listaTotalDePenaltis = getDriver().findElement(By.className("placar-penaltis")).findElement(By.className("penaltis-time-B")).findElements(By.tagName("li"));
		return listaTotalDePenaltis.size() == Integer.parseInt("10");
	}
	
	public boolean exibiuAlgumaDasDezBolinhasDePenaltisDoTimeBComoAproveitada() {
		List<WebElement> totalDePenaltisAproveitados = getDriver().findElement(By.className("placar-penaltis")).findElement(By.className("penaltis-time-B")).findElements(By.className("cobranca-aproveitada"));
		return totalDePenaltisAproveitados.size() > Integer.parseInt("0");
	}
	
	public boolean exibiuAlgumaDasDezBolinhasDePenaltisDoTimeBComoDesperdicada() {
		List<WebElement> totalDePenaltisAproveitados = getDriver().findElement(By.className("placar-penaltis")).findElement(By.className("penaltis-time-B")).findElements(By.className("cobranca-aproveitada"));
		return totalDePenaltisAproveitados.size() > Integer.parseInt("0");
	}
}