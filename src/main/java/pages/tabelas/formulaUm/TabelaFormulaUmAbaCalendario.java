package pages.tabelas.formulaUm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaFormulaUmAbaCalendario extends TabelaFormulaUmPaginaPadrao {	
	
	public TabelaFormulaUmAbaCalendario(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterAbaCalendario() {
		return obterTabela().findElement(By.id("calendario"));
	}
	
	public boolean exibiuBoxDaAbaCalendarioAposClicarNoMenu() {
		obterBotaoDaAbaCalendario().click();
		return obterAbaCalendario().isDisplayed();
	}
	
	private WebElement obterTituloDaAba() {
		return obterAbaCalendario().findElement(By.tagName("h3"));
	}

	public boolean exibiuTituloDaAba() {
		String tituloEsperado = "Calendário";
		return obterTituloDaAba().getText().equalsIgnoreCase(tituloEsperado);
	}
	
	private WebElement obterCalendario() {
		return obterAbaCalendario().findElement(By.id("calendario"));
	}

	public boolean exibiuOCalendario() {
		return obterCalendario().isDisplayed();
	}
	
	private List<WebElement> obterListaDasColunasDoCalendario() {
		return obterCalendario().findElement(By.tagName("thead")).findElements(By.tagName("th"));
	}

	public boolean exibiuAsColunasDoCalendario() {
		for (int coluna = 0; coluna < 7; coluna++) {
			if (! obterListaDasColunasDoCalendario().get(coluna).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuONomeDasColunasDoCalendario() {
		for (int coluna = 0; coluna < 7; coluna++) {
			if (obterListaDasColunasDoCalendario().get(coluna).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	private List<WebElement> obterListaDasCorridasDoCalendario() {
		return obterCalendario().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}

	public boolean exibiuNoMinimoUmaCorridaNoCalendario() {
		return obterListaDasCorridasDoCalendario().size() > 0;
	}

	public boolean exibiuADataAHoraOGrandePremioOCircuitoACidadeEOsValoresDestesCamposParaCadaCorrida() {
		int qtdeCorridas = obterListaDasCorridasDoCalendario().size();
		for (int corrida = 0; corrida < qtdeCorridas; corrida++) {
			//Data
			if (! obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-date")).isDisplayed()) {
				System.out.println("Não foi exibida a data na corrida " + (corrida+1) + ".");
				return false;
			}
			//Valor da Data
			if (obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-date")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor da data na corrida " + (corrida+1) + ".");
				return false;
			}
			//Hora
			if (! obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-time")).isDisplayed()) {
				System.out.println("Não foi exibida a hora na corrida " + (corrida+1) + ".");
				return false;
			}
			//Valor da Hora
			if (obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-time")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor da hora na corrida " + (corrida+1) + ".");
				return false;
			}
			//GP
			if (! obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-gpname")).isDisplayed()) {
				System.out.println("Não foi exibido o grande prêmio na corrida " + (corrida+1) + ".");
				return false;
			}
			//Valor do GP
			if (obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-gpname")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor do grande prêmio na corrida " + (corrida+1) + ".");
				return false;
			}
			//Circuito
			if (! obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-venue")).isDisplayed()) {
				System.out.println("Não foi exibido o circuito na corrida " + (corrida+1) + ".");
				return false;
			}
			//Valor do Circuito
			if (obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-venue")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor do circuito na corrida " + (corrida+1) + ".");
				return false;
			}
			//Cidade
			if (! obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-city")).isDisplayed()) {
				System.out.println("Não foi exibida a cidade na corrida " + (corrida+1) + ".");
				return false;
			}
			//Valor da Cidade
			if (obterListaDasCorridasDoCalendario().get(corrida).findElement(By.className("tbl-city")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor da cidade na corrida " + (corrida+1) + ".");
				return false;
			}
		}
		return true;
	}
}