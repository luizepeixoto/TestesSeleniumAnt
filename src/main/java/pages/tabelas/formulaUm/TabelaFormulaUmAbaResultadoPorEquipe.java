package pages.tabelas.formulaUm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaFormulaUmAbaResultadoPorEquipe extends TabelaFormulaUmPaginaPadrao {	
	
	public TabelaFormulaUmAbaResultadoPorEquipe(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterAbaResultadoPorEquipe() {
		return obterTabela().findElement(By.id("resultPorEquipe"));
	}
	
	public boolean exibiuBoxDaAbaResultadoPorEquipeAposClicarNoMenu() {
		obterBotaoDaAbaResultadoPorEquipe().click();
		return obterAbaResultadoPorEquipe().isDisplayed();
	}
	
	private WebElement obterTituloDaAba() {
		return obterAbaResultadoPorEquipe().findElement(By.tagName("h3"));
	}

	public boolean exibiuTituloDaAba() {
		String tituloEsperado = "Classificação geral de equipes";
		return obterTituloDaAba().getText().equalsIgnoreCase(tituloEsperado);
	}
	
	private WebElement obterTabelaDeResultadoPorEquipe() {
		return obterAbaResultadoPorEquipe().findElement(By.id("classificacaoEquipe2015"));
	}

	public boolean exibiuATabelaDeResultadoPorEquipe() {
		return obterTabelaDeResultadoPorEquipe().isDisplayed();
	}
	
	private List<WebElement> obterListaDasColunasDeResultadoPorEquipe() {
		return obterTabelaDeResultadoPorEquipe().findElement(By.tagName("thead")).findElements(By.tagName("th"));
	}
	
	private int obterQuantidadeDasColunasDeResultadoPorEquipe() {
		return obterListaDasColunasDeResultadoPorEquipe().size();
	}

	public boolean exibiuAsColunasDeResultadoPorEquipe() {
		int qtde = obterQuantidadeDasColunasDeResultadoPorEquipe();
		for (int coluna = 0; coluna < qtde; coluna++) {
			if (! obterListaDasColunasDeResultadoPorEquipe().get(coluna).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuONomeDasColunasDeResultadoPorEquipe() {
		int qtde = obterQuantidadeDasColunasDeResultadoPorEquipe();
		for (int coluna = 0; coluna < qtde; coluna++) {
			if (obterListaDasColunasDeResultadoPorEquipe().get(coluna).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	private List<WebElement> obterListaDasEquipesDeResultadoPorEquipe() {
		return obterTabelaDeResultadoPorEquipe().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}

	public boolean exibiuNoMinimoUmaEquipeNoResultadoPorEquipe() {
		return obterListaDasEquipesDeResultadoPorEquipe().size() > 0;
	}

	public boolean exibiuAPosicaoONomeEOsValoresDestesCamposParaCadaEquipe() {
		int qtdeEquipes = obterListaDasEquipesDeResultadoPorEquipe().size();
		for (int i = 0; i < qtdeEquipes; i++) {
			//Posicao
			if (! obterListaDasEquipesDeResultadoPorEquipe().get(i).findElement(By.className("tbl-st-pos")).isDisplayed()) {
				System.out.println("Não foi exibida a posição da equipe " + (i+1) + ".");
				return false;
			}
			//Valor da Posicao
			if (obterListaDasEquipesDeResultadoPorEquipe().get(i).findElement(By.className("tbl-st-pos")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor da posição da equipe " + (i+1) + ".");
				return false;
			}
			//Equipe
			if (! obterListaDasEquipesDeResultadoPorEquipe().get(i).findElement(By.className("tbl-team")).isDisplayed()) {
				System.out.println("Não foi exibido o nome da equipe " + (i+1) + ".");
				return false;
			}
			//Valor da Equipe
			if (obterListaDasEquipesDeResultadoPorEquipe().get(i).findElement(By.className("tbl-team")).getText().isEmpty()) {
				System.out.println("Não foi exibido o valor do nome da equipe " + (i+1) + ".");
				return false;
			}
		}
		return true;
	}
}