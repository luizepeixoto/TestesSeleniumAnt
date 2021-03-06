package pages.tabelas.carioca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaCampeonatoCariocaPaginaTempoReal  extends TabelaCampeonatoCariocaPaginaPadrao {	
	
	public TabelaCampeonatoCariocaPaginaTempoReal(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement obterBannerArroba() {
		return getDriver().findElement(By.className("container-arroba-banner"));
	}

	public boolean naoExibiuOBotaoDeRegulamento() {
		if (exibiuOBotaoDeRegulamento()) {
			return false;
		} else {
			return true;
		}
	}
}