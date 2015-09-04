package pages.tabelas.libertadores;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaLibertadoresFaseDeGruposPaginaPadrao extends TabelaLibertadoresPaginaPadrao {
	
	public TabelaLibertadoresFaseDeGruposPaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterBoxDosJogosDaFaseDeGrupos() {
		return obterTabela().findElement(By.className("fase-de-grupos"));
	}
	
	public boolean exibiuBoxDosJogosDaFaseDeGruposAposClicarNoMenu() {
		obterBotaoDaFaseDeGrupos().click();
		return obterBoxDosJogosDaFaseDeGrupos().isDisplayed();
	}
	
	private List<WebElement> obterListaDosGruposDaFase() {
		return obterBoxDosJogosDaFaseDeGrupos().findElements(By.xpath("//div[contains(@data-ng-repeat, 'grupo')]"));
	}
	
	private int obterQuantidadeDosGruposDaFase() {
		return obterListaDosGruposDaFase().size();
	}
	
	public boolean exibiuNoMinimoUmGrupoDaFase() {
		return obterQuantidadeDosGruposDaFase() > 0;
	}
	
	private WebElement obterGrupoDeAcordoComAPosicao(int posicao) {
		return obterListaDosGruposDaFase().get(posicao);
	}

	public boolean exibiuONomeParaCadaGrupoDaFase() {
		int qtde = obterQuantidadeDosGruposDaFase();
		
		for (int i = 0; i < qtde; i++) {
			if (obterGrupoDeAcordoComAPosicao(i).findElement(By.tagName("h3")).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	private WebElement obterTabelaDeClassificacaoDeAcordoComOGrupo(int grupo) {
		return obterGrupoDeAcordoComAPosicao(grupo).findElement(By.className("classificacao-jogos"));
	}

	public boolean exibiuATabelaDeClassificacaoParaCadaGrupoDaFase() {
		int qtde = obterQuantidadeDosGruposDaFase();
		
		for (int i = 0; i < qtde; i++) {
			if (! obterTabelaDeClassificacaoDeAcordoComOGrupo(i).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	private List<WebElement> obterListaDasColunasDaTabelaDeClassificacaoDeAcordoComOGrupo(int grupo) {
		return obterTabelaDeClassificacaoDeAcordoComOGrupo(grupo).findElement(By.tagName("thead")).findElements(By.tagName("th"));
	}

	public boolean exibiuAsColunasDaTabelaDeClassificacaoParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			int qtdeColunas = obterListaDasColunasDaTabelaDeClassificacaoDeAcordoComOGrupo(grupo).size();
			for (int coluna = 0; coluna < qtdeColunas; coluna++) {
				if (obterListaDasColunasDaTabelaDeClassificacaoDeAcordoComOGrupo(grupo).get(coluna).getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuAsPosicoesDosTimesDaTabelaDeClassificacaoParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			int qtdeTimes = obterListaDosTimesDaTabelaDeClassificacaoDeAcordoComOGrupo(grupo).size();
			for (int time = 0; time < qtdeTimes; time++) {
				if (obterListaDosTimesDaTabelaDeClassificacaoDeAcordoComOGrupo(grupo).get(time).findElement(By.tagName("td")).findElement(By.xpath("span[contains(@data-ng-bind, 'classificacao.Posicao')]")).getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	private List<WebElement> obterListaDosTimesDaTabelaDeClassificacaoDeAcordoComOGrupo(int grupo) {
		return obterTabelaDeClassificacaoDeAcordoComOGrupo(grupo).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}
	
	public boolean exibiuOsTimesDaTabelaDeClassificacaoParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			int qtdeTimes = obterListaDosTimesDaTabelaDeClassificacaoDeAcordoComOGrupo(grupo).size();
			for (int time = 0; time < qtdeTimes; time++) {
				if (obterListaDosTimesDaTabelaDeClassificacaoDeAcordoComOGrupo(grupo).get(time).findElement(By.tagName("td")).findElement(By.xpath("span[contains(@data-ng-bind, 'classificacao.NomeEquipe')]")).getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuOsDoisPrimeirosTimesDaTabelaDeClassificacaoDestacadosParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		String corEsperada = "rgba(0, 128, 0, 1)";
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			for (int time = 0; time <= 1; time++) {
				if (! obterListaDosTimesDaTabelaDeClassificacaoDeAcordoComOGrupo(grupo).get(time).getCssValue("border-left-color").equals(corEsperada)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private WebElement obterRodadaAtualDeAcordoComOGrupo(int grupo) {
		return obterGrupoDeAcordoComAPosicao(grupo).findElement(By.className("jogos-rodada")).findElement(By.className("cycle-slide-active"));
	}
	
	public boolean exibiuARodadaAtualParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			if (! obterRodadaAtualDeAcordoComOGrupo(grupo).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOTituloDaRodadaAtualParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			if (obterRodadaAtualDeAcordoComOGrupo(grupo).findElement(By.tagName("dt")).findElement(By.tagName("span")).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	private WebElement obterBoxDeNavegacaoDeAcordoComOGrupo(int grupo) {
		return obterGrupoDeAcordoComAPosicao(grupo).findElement(By.className("jogos-rodada")).findElement(By.className("navTabelas"));
	}
	
	private WebElement obterBotaoDeRodadaAnteriorDeAcordoComOGrupo(int grupo) {
		return obterBoxDeNavegacaoDeAcordoComOGrupo(grupo).findElement(By.className("prev"));
	}
	
	public boolean exibiuOBotaoDeRodadaAnteriorParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			if (! obterBotaoDeRodadaAnteriorDeAcordoComOGrupo(grupo).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	private WebElement obterBotaoDeRodadaPosteriorDeAcordoComOGrupo(int grupo) {
		return obterBoxDeNavegacaoDeAcordoComOGrupo(grupo).findElement(By.className("next"));
	}
	
	public boolean exibiuOBotaoDeRodadaPosteriorParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			if (! obterBotaoDeRodadaPosteriorDeAcordoComOGrupo(grupo).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	private List<WebElement> obterListaDeJogosDaRodadaAtualDeAcordoComOGrupo(int grupo) {
		return obterRodadaAtualDeAcordoComOGrupo(grupo).findElements(By.xpath("dd[contains(@data-ng-repeat, 'jogo')]"));
	}
	
	private int obterQuantidadeDeJogosDaRodadaAtualDeAcordoComOGrupo(int grupo) {
		return obterListaDeJogosDaRodadaAtualDeAcordoComOGrupo(grupo).size();
	}
	
	public boolean exibiuAListaDeJogosDaRodadaAtualParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			if (obterQuantidadeDeJogosDaRodadaAtualDeAcordoComOGrupo(grupo) < 0) {
				return false;
			}
		}
		return true;
	}
	
	private WebElement obterTimeMandanteNosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(int grupo, int jogo) {
		return obterListaDeJogosDaRodadaAtualDeAcordoComOGrupo(grupo).get(jogo).findElement(By.className("time-casa"));
	}
	
	private WebElement obterTimeVisitanteNosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(int grupo, int jogo) {
		return obterListaDeJogosDaRodadaAtualDeAcordoComOGrupo(grupo).get(jogo).findElement(By.className("time-fora"));
	}
	
	public boolean exibiuOsEscudosDosTimesNosJogosDaRodadaAtualParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			int qtdeJogos = obterQuantidadeDeJogosDaRodadaAtualDeAcordoComOGrupo(grupo);
			for (int jogo = 0; jogo < qtdeJogos; jogo++) {
					if (! obterTimeMandanteNosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(grupo, jogo).findElement(By.tagName("img")).isDisplayed()) {
						System.out.println("Não foi exibido escudo da equipe mandante no jogo " + (jogo+1) + " do grupo " + (grupo+1) + ".");
						return false;
					}
					if (! obterTimeVisitanteNosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(grupo, jogo).findElement(By.tagName("img")).isDisplayed()) {
						System.out.println("Não foi exibido escudo da equipe visitante no jogo " + (jogo+1) + " do grupo " + (grupo+1) + ".");
						return false;
					}
			}
		}
		return true;
	}
	
	public boolean exibiuOsNomesDosTimesNosJogosDaRodadaAtualParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			int qtdeJogos = obterQuantidadeDeJogosDaRodadaAtualDeAcordoComOGrupo(grupo);
			for (int jogo = 0; jogo < qtdeJogos; jogo++) {
					if (obterTimeMandanteNosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(grupo, jogo).findElement(By.className("sigla")).getText().isEmpty()) {
						System.out.println("Não foi exibido nome da equipe mandante no jogo " + (jogo+1) + " do grupo " + (grupo+1) + ".");
						return false;
					}
					if (obterTimeVisitanteNosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(grupo, jogo).findElement(By.className("sigla")).getText().isEmpty()) {
						System.out.println("Não foi exibido escudo da equipe visitante no jogo " + (jogo+1) + " do grupo " + (grupo+1) + ".");
						return false;
					}
			}
		}
		return true;
	}
	
	private WebElement obterDadosDosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(int grupo, int jogo) {
		return obterListaDeJogosDaRodadaAtualDeAcordoComOGrupo(grupo).get(jogo).findElement(By.className("servico"));
	}
	
	public boolean exibiuADataOEstadioEAHoraNosJogosDaRodadaAtualParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			int qtdeJogos = obterQuantidadeDeJogosDaRodadaAtualDeAcordoComOGrupo(grupo);
			for (int jogo = 0; jogo < qtdeJogos; jogo++) {
					if (obterDadosDosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(grupo, jogo).findElement(By.className("data")).getText().isEmpty()) {
						System.out.println("Não foi exibida a data no jogo " + (jogo+1) + " do grupo " + (grupo+1) + ".");
						return false;
					}
					if (obterDadosDosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(grupo, jogo).findElement(By.className("estadio")).getText().isEmpty()) {
						System.out.println("Não foi exibido o estádio no jogo " + (jogo+1) + " do grupo " + (grupo+1) + ".");
						return false;
					}
					if (obterDadosDosJogosDaRodadaAtualDeAcordoComOGrupoEComAPosicaoDoJogo(grupo, jogo).findElement(By.className("hora")).getText().isEmpty()) {
						System.out.println("Não foi exibida a hora no jogo " + (jogo+1) + " do grupo " + (grupo+1) + ".");
						return false;
					}
			}
		}
		return true;
	}
	
	private List<WebElement> obterListaDeRodadasDeAcordoComOGrupo(int grupo) {
		return obterGrupoDeAcordoComAPosicao(grupo).findElement(By.className("jogos-rodada")).findElement(By.tagName("div")).findElements(By.xpath("dl[contains(@class, 'cycle-slide')][not(contains(@class, 'cycle-sentinel'))]"));
	}
	
	private int obterQuantidadeDeRodadasDeAcordoComOGrupo(int grupo) {
		return obterListaDeRodadasDeAcordoComOGrupo(grupo).size();
	}
	
	public boolean exibiuOBotaoDeRodadaPosteriorDesabilitadoNaUltimaRodadaParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			executarScroll(obterGrupoDeAcordoComAPosicao(grupo).getLocation());
			int qtdeRodadas = obterQuantidadeDeRodadasDeAcordoComOGrupo(grupo);
			for (int rodada = 0; rodada < qtdeRodadas; rodada++) {
				obterBotaoDeRodadaPosteriorDeAcordoComOGrupo(grupo).click();
			}
			if (! obterBotaoDeRodadaPosteriorDeAcordoComOGrupo(grupo).getAttribute("class").contains("disabled")) {
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOBotaoDeRodadaAnteriorDesabilitadoNaPrimeiraRodadaParaCadaGrupoDaFase() {
		int qtdeGrupos = obterQuantidadeDosGruposDaFase();
		
		for (int grupo = 0; grupo < qtdeGrupos; grupo++) {
			executarScroll(obterGrupoDeAcordoComAPosicao(grupo).getLocation());
			int qtdeRodadas = obterQuantidadeDeRodadasDeAcordoComOGrupo(grupo);
			for (int rodada = 0; rodada < qtdeRodadas; rodada++) {
				obterBotaoDeRodadaAnteriorDeAcordoComOGrupo(grupo).click();
			}
			if (! obterBotaoDeRodadaAnteriorDeAcordoComOGrupo(grupo).getAttribute("class").contains("disabled")) {
				return false;
			}
		}
		return true;
	}
	
	private WebElement obterBoxDeLegendas() {
		return obterBoxDosJogosDaFaseDeGrupos().findElement(By.className("legendas"));
	}
	
	public boolean exibiuALegendaDoCampeonato() {
		return obterBoxDeLegendas().isDisplayed();
	}
	
	protected WebElement obterLegendaClassificados() {
		return obterBoxDeLegendas().findElement(By.className("classificados"));
	}

	public boolean exibiuACorParaOsTimesClassificadosNaLegenda() {
		String corEsperada = "rgba(0, 128, 0, 1)";
		return obterLegendaClassificados().findElement(By.tagName("span")).getCssValue("background-color").equalsIgnoreCase(corEsperada);
	}

	public boolean exibiuOTextoParaOsTimesClassificadosNaLegenda() {
		return ! obterLegendaClassificados().getText().isEmpty();
	}
}