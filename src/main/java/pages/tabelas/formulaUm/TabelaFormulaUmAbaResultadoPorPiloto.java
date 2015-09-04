package pages.tabelas.formulaUm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaFormulaUmAbaResultadoPorPiloto extends TabelaFormulaUmPaginaPadrao {	
	
	public TabelaFormulaUmAbaResultadoPorPiloto(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterAbaResultadoPorPiloto() {
		return obterTabela().findElement(By.id("resultPorPiloto"));
	}
	
	public boolean exibiuBoxDaAbaResultadoPorPilotoAposClicarNoMenu() {
		obterBotaoDaAbaResultadoPorPiloto().click();
		return obterAbaResultadoPorPiloto().isDisplayed();
	}
	
	private WebElement obterTituloDaAba() {
		return obterAbaResultadoPorPiloto().findElement(By.tagName("h3"));
	}

	public boolean exibiuTituloDaAba() {
		String tituloEsperado = "Classificação geral de pilotos";
		return obterTituloDaAba().getText().equalsIgnoreCase(tituloEsperado);
	}
	
	private WebElement obterTabelaDeResultadoPorPiloto() {
		return obterAbaResultadoPorPiloto().findElement(By.id("classificacaoPiloto2015"));
	}

	public boolean exibiuATabelaDeResultadoPorPiloto() {
		return obterTabelaDeResultadoPorPiloto().isDisplayed();
	}
	
	private List<WebElement> obterListaDasColunasDeResultadoPorPiloto() {
		return obterTabelaDeResultadoPorPiloto().findElement(By.tagName("thead")).findElements(By.tagName("th"));
	}
	
	private int obterQuantidadeDasColunasDeResultadoPorPiloto() {
		return obterListaDasColunasDeResultadoPorPiloto().size();
	}

	public boolean exibiuAsColunasDeResultadoPorPiloto() {
		int qtde = obterQuantidadeDasColunasDeResultadoPorPiloto();
		for (int coluna = 0; coluna < qtde; coluna++) {
			if (! obterListaDasColunasDeResultadoPorPiloto().get(coluna).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuONomeDasColunasDeResultadoPorPiloto() {
		int qtde = obterQuantidadeDasColunasDeResultadoPorPiloto();
		for (int coluna = 0; coluna < qtde; coluna++) {
			if (obterListaDasColunasDeResultadoPorPiloto().get(coluna).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	private List<WebElement> obterListaDosPilotosDeResultadoPorPiloto() {
		return obterTabelaDeResultadoPorPiloto().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}
	
	private int obterQuantidadeDosPilotosDeResultadoPorPiloto() {
		return obterListaDosPilotosDeResultadoPorPiloto().size();
	}

	public boolean exibiuNoMinimoUmPilotoNoResultadoPorPiloto() {
		return obterQuantidadeDosPilotosDeResultadoPorPiloto() > 0;
	}

	public boolean exibiuAPosicaoONomeAEquipeEOsValoresDestesCamposParaCadaPiloto() {
		int qtde = obterQuantidadeDosPilotosDeResultadoPorPiloto();
		for (int piloto = 0; piloto < qtde; piloto++) {
			//Posicao
			if (! obterListaDosPilotosDeResultadoPorPiloto().get(piloto).findElement(By.className("tbl-st-pos")).isDisplayed()) {
				System.out.println("Não foi exibida a posição do piloto " + (piloto+1) + ".");
				return false;
			}
			//Valor da Posicao
			if (obterListaDosPilotosDeResultadoPorPiloto().get(piloto).findElement(By.className("tbl-st-pos")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor da posição do piloto " + (piloto+1) + ".");
				return false;
			}
			//Nome do Piloto
			if (! obterListaDosPilotosDeResultadoPorPiloto().get(piloto).findElement(By.className("tbl-driver")).isDisplayed()) {
				System.out.println("Não foi exibido o nome do piloto " + (piloto+1) + ".");
				return false;
			}
			//Valor do Nome do Piloto
			if (obterListaDosPilotosDeResultadoPorPiloto().get(piloto).findElement(By.className("tbl-driver")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor do nome do piloto " + (piloto+1) + ".");
				return false;
			}
			//Equipe do Piloto
			if (! obterListaDosPilotosDeResultadoPorPiloto().get(piloto).findElement(By.className("tbl-team")).isDisplayed()) {
				System.out.println("Não foi exibida a equipe do piloto " + (piloto+1) + ".");
				return false;
			}
			//Valor da Equipe do Piloto
			if (obterListaDosPilotosDeResultadoPorPiloto().get(piloto).findElement(By.className("tbl-team")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor da equipe do piloto " + (piloto+1) + ".");
				return false;
			}
		}
		return true;
	}
}