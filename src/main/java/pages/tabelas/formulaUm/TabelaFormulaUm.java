package pages.tabelas.formulaUm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaFormulaUm extends TabelaFormulaUmPaginaPadrao {	
	
	public TabelaFormulaUm(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuTituloDaTabela() {
		return !obterTabela().findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText().isEmpty();					
	}
	
	public boolean exibiuOMenuDaTabela() {
		return obterOMenuDaTabela().isDisplayed();
	}
	
	public boolean exibiuOpcaoDoCalendario() {
		return obterBotaoDaAbaCalendario().isDisplayed();
	}
	
	public boolean exibiuOpcaoDoResultadoPorPiloto() {
		return obterBotaoDaAbaResultadoPorPiloto().isDisplayed();
	}
	
	public boolean exibiuOpcaoDoResultadoPorEquipe() {
		return obterBotaoDaAbaResultadoPorEquipe().isDisplayed();
	}
	
	public boolean exibiuOpcaoDoResultadoPorCorrida() {
		return obterBotaoDaAbaResultadoPorCorrida().isDisplayed();
	}
	
	public boolean exibiuTituloDaAbaCalendarioNoMenu() {
		return obterBotaoDaAbaCalendario().getText().equalsIgnoreCase("Calendário");
	}
	
	public boolean exibiuTituloDaAbaResultadoPorPilotoNoMenu() {
		return obterBotaoDaAbaResultadoPorPiloto().getText().equalsIgnoreCase("Resultado por Piloto");
	}
	
	public boolean exibiuTituloDaAbaResultadoPorEquipeNoMenu() {
		return obterBotaoDaAbaResultadoPorEquipe().getText().equalsIgnoreCase("Resultado por Equipe");
	}
	
	public boolean exibiuTituloDaAbaResultadoPorCorridaNoMenu() {
		return obterBotaoDaAbaResultadoPorCorrida().getText().equalsIgnoreCase("Resultado por Corrida");
	}
	
	private WebElement obterAbaAtual() {
		return obterTabela().findElement(By.xpath("div[@style='display: block;']"));
	}
	
	public boolean exibiuAAbaAtualAbertaPorPadrao() {
		return obterAbaAtual().isDisplayed();
	}
	
	private WebElement obterImagemDaTabelaFacil() {
		List<WebElement> listaDeDivsTabelaJogos = obterTabela().findElements(By.className("tabela-jogos"));
		int ultimoDivTabelaJogos = listaDeDivsTabelaJogos.size() - 1;
		
		return listaDeDivsTabelaJogos.get(ultimoDivTabelaJogos).findElement(By.tagName("img"));
	}

	public boolean exibiuAImagemDaTabelaFacil() {
		return obterImagemDaTabelaFacil().isDisplayed();
	}

	public boolean exibiuOLinkDaImagemDaTabelaFacilCorreto() {
		return obterImagemDaTabelaFacil().getAttribute("src").contains("tabelafacil");
	}
}