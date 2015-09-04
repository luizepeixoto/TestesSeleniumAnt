package pages.tabelas.formulaUm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaFormulaUmAbaResultadoPorCorrida extends TabelaFormulaUmPaginaPadrao {	
	
	public TabelaFormulaUmAbaResultadoPorCorrida(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterAbaResultadoPorCorrida() {
		return obterTabela().findElement(By.id("resultPorCorrida"));
	}
	
	public boolean exibiuBoxDaAbaResultadoPorCorridaAposClicarNoMenu() {
		obterBotaoDaAbaResultadoPorCorrida().click();
		return obterAbaResultadoPorCorrida().isDisplayed();
	}
	
	private WebElement obterTituloDaAba() {
		return obterAbaResultadoPorCorrida().findElement(By.tagName("h3"));
	}

	public boolean exibiuTituloDaAba() {
		String tituloEsperado = "Resultados por corrida";
		return obterTituloDaAba().getText().equalsIgnoreCase(tituloEsperado);
	}
	
	private List<WebElement> obterListaDeBandeiras() {
		return obterAbaResultadoPorCorrida().findElement(By.className("flags")).findElements(By.tagName("div"));
	}
	
	private int obterQuantidadeDeBandeiras() {
		return obterListaDeBandeiras().size();
	}
	
	public boolean exibiuAsBandeirasDosPaisesSedesDeCorrida() {
		int qtde = obterQuantidadeDeBandeiras();
		
		for (int i = 0; i < qtde; i++) {
			if (! obterListaDeBandeiras().get(i).isDisplayed()) {
				return false;
			}
		}
		
		return true;
	}
	
	private WebElement obterBoxDaTabelaDeClassificacao() {
		return obterAbaResultadoPorCorrida().findElement(By.className("classificacao"));
	}
	
	private WebElement obterTabelaDeResultadoPorCorrida(int corrida) {
		return obterBoxDaTabelaDeClassificacao().findElements(By.id("corridas")).get(corrida);
	}

	public boolean exibiuATabelaDeResultadoPorCorridaParaCadaCorrida() {
		int qtde = obterQuantidadeDeBandeiras();
		for (int i = 0; i < qtde; i++) {
			obterListaDeBandeiras().get(i).click();
			while (! obterBoxDaTabelaDeClassificacao().isDisplayed()) {
				if (obterBoxDaTabelaDeClassificacao().isDisplayed()) {
					break;
				}
			}
			if (! obterTabelaDeResultadoPorCorrida(i).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	private List<WebElement> obterListaDasColunasDeResultadoPorCorridaDeAcordoComACorrida(int corrida) {
		return obterTabelaDeResultadoPorCorrida(corrida).findElement(By.tagName("thead")).findElements(By.tagName("th"));
	}
	
	private int obterQuantidadeDasColunasDeResultadoPorEquipe(int corrida) {
		return obterListaDasColunasDeResultadoPorCorridaDeAcordoComACorrida(corrida).size();
	}

	public boolean exibiuAsColunasEONomeDasColunasDeResultadoPorCorridaParaCadaCorrida() throws InterruptedException {
		int qtde = obterQuantidadeDeBandeiras();
		for (int corrida = 0; corrida < qtde; corrida++) {
			obterListaDeBandeiras().get(corrida).click();
			esperaCarregar(2);
			int qtdeColunas = obterQuantidadeDasColunasDeResultadoPorEquipe(corrida);
			for (int coluna = 0; coluna < qtdeColunas; coluna++) {
				if (! obterListaDasColunasDeResultadoPorCorridaDeAcordoComACorrida(corrida).get(coluna).isDisplayed()) {
					System.out.println("Não foi exibida a coluna " + (coluna+1) + " na corrida " + (corrida+1) + ".");
					return false;
				}
				if (obterListaDasColunasDeResultadoPorCorridaDeAcordoComACorrida(corrida).get(coluna).getText().isEmpty()) {
					System.out.println("Não foi exibido o nome da coluna " + (coluna+1) + " na corrida " + (corrida+1) + ".");
					return false;
				}
			}	
		}
		return true;
	}
}