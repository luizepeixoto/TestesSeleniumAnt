package testes.tabelas.carioca;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.carioca.TabelaCampeonatoCarioca;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TabelaCampeonatoCariocaTest {

	private static TabelaCampeonatoCarioca tabela;
		
	@BeforeClass
	public static void before() throws Exception{
		tabela = new TabelaCampeonatoCarioca(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeONomeDoCampeonatoEstaSendoExibido() {
		assertTrue(tabela.exibiuONomeDoCampeonato());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeAClassificacaoEstaSendoExibida() {
		assertTrue(tabela.exibiuAClassificacaoDoCampeonato());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAsColunasDaTabelaDeClassificacaoEstaoSendoExibidas() {
		assertTrue(tabela.exibiuAsColunasDaTabelaDeClassificacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeOsTimesDaTabelaDeClassificacaoEstaoSendoExibidos() {
		assertTrue(tabela.exibiuOsTimesDaTabelaDeClassificacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeAsPosicoesDosTimesDaTabelaDeClassificacaoEstaoSendoExibidas() {
		assertTrue(tabela.exibiuAsPosicoesDosTimesDaTabelaDeClassificacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeOsQuatroPrimeirosTimesEstaoSendoExibidosDestacadosNaTabelaDeClassificacao() {
		assertTrue(tabela.exibiuOsQuatroPrimeirosTimesDestacadosNaTabelaDeClassificacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeOsDoisUltimosTimesEstaoSendoExibidosDestacadosNaTabelaDeClassificacao() {
		assertTrue(tabela.exibiuOsDoisUltimosTimesDestacadosNaTabelaDeClassificacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeARodadaEstaSendoExibida() {
		assertTrue(tabela.exibiuARodadaDoCampeonato());
	}
	
	@OrdemExecucaoTeste(Ordem = 9)
	@Test
	public void verificaSeOTituloDaRodadaAtualEstaSendoExibido() {
		assertTrue(tabela.exibiuOTituloDaRodadaAtualDoCampeonato());
	}
	
	@OrdemExecucaoTeste(Ordem = 10)
	@Test
	public void verificaSeOBotaoDeRodadaAnteriorEstaSendoExibido() {
		assertTrue(tabela.exibiuOBotaoDeRodadaAnteriorDoCampeonato());
	}
	
	@OrdemExecucaoTeste(Ordem = 11)
	@Test
	public void verificaSeOBotaoDeRodadaPosteriorEstaSendoExibido() {
		assertTrue(tabela.exibiuOBotaoDeRodadaPosteriorDoCampeonato());
	}
	
	@OrdemExecucaoTeste(Ordem = 12)
	@Test
	public void verificaSeAListaDeJogosDaRodadaAtualEstaSendoExibida() {
		assertTrue(tabela.exibiuAListaDeJogosDaRodadaAtual());
	}
	
	@OrdemExecucaoTeste(Ordem = 13)
	@Test
	public void verificaSeOsEscudosDosTimesEstaoSendoExibidosNosJogosDaRodadaAtual() {
		assertTrue(tabela.exibiuOsEscudosDosTimesNosJogosDaRodadaAtual());
	}
	
	@OrdemExecucaoTeste(Ordem = 14)
	@Test
	public void verificaSeAsSiglasDosTimesEstaoSendoExibidasNosJogosDaRodadaAtual() {
		assertTrue(tabela.exibiuAsSiglasDosTimesNosJogosDaRodadaAtual());
	}
	
	@OrdemExecucaoTeste(Ordem = 15)
	@Test
	public void verificaSeADataEAHoraEstaoSendoExibidasNosJogosDaRodadaAtual() {
		assertTrue(tabela.exibiuDataEAHoraNosJogosDaRodadaAtual());
	}
	
	@OrdemExecucaoTeste(Ordem = 16)
	@Test
	public void verificaSeOBotaoDeRodadaPosteriorEstaDesabilitadoNaUltimaRodada() throws InterruptedException {
		assertTrue(tabela.exibiuOBotaoDeRodadaPosteriorDesabilitadoNaUltimaRodada());
	}
	
	@OrdemExecucaoTeste(Ordem = 17)
	@Test
	public void verificaSeOBotaoDeRodadaAnteriorEstaDesabilitadoNaPrimeiraRodada() throws InterruptedException {
		assertTrue(tabela.exibiuOBotaoDeRodadaAnteriorDesabilitadoNaPrimeiraRodada());
	}
	
	@OrdemExecucaoTeste(Ordem = 18)
	@Test
	public void verificaSeNaPenultimaRodadaOTituloSemifinalEstaSendoExibido() throws InterruptedException {
		assertTrue(tabela.exibiuOTituloSemifinalNaPenultimaRodada());
	}
	
	@OrdemExecucaoTeste(Ordem = 19)
	@Test
	public void verificaSeNaUltimaRodadaOTituloFinalEstaSendoExibido() throws InterruptedException {
		assertTrue(tabela.exibiuOTituloFinalNaUltimaRodada());
	}
	
	@OrdemExecucaoTeste(Ordem = 20)
	@Test
	public void verificaSeALegendaEstaSendoExibida() {
		assertTrue(tabela.exibiuALegendaDoCampeonato());
	}
	
	@OrdemExecucaoTeste(Ordem = 21)
	@Test
	public void verificaSeACorParaOsTimesClassificadosEstaSendoExibida() {
		assertTrue(tabela.exibiuACorParaOsTimesClassificadosNaLegenda());
	}
	
	@OrdemExecucaoTeste(Ordem = 22)
	@Test
	public void verificaSeOTextoParaOsTimesClassificadosEstaSendoExibido() {
		assertTrue(tabela.exibiuOTextoParaOsTimesClassificadosNaLegenda());
	}
	
	@OrdemExecucaoTeste(Ordem = 23)
	@Test
	public void verificaSeACorParaOsTimesRebaixadosEstaSendoExibida() {
		assertTrue(tabela.exibiuACorParaOsTimesRebaixadosNaLegenda());
	}
	
	@OrdemExecucaoTeste(Ordem = 24)
	@Test
	public void verificaSeOTextoParaOsTimesRebaixadosEstaSendoExibido() {
		assertTrue(tabela.exibiuOTextoParaOsTimesRebaixadosNaLegenda());
	}
	
	@OrdemExecucaoTeste(Ordem = 25)
	@Test
	public void verificaSeOBotaoDeRegulamentoEstaSendoExibido() {
		assertTrue(tabela.exibiuOBotaoDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 26)
	@Test
	public void verificaSeOBotaoDeRegulamentoEstaExibindoOTextoAbrirRegulamento() {
		assertTrue(tabela.exibiuOTextoAbrirRegulamentoNoBotaoDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 27)
	@Test
	public void verificaSeORegulamentoEhExibidoAposClicarNoBotaoDeRegulamento() throws InterruptedException {
		assertTrue(tabela.exibiuORegulamentoAposClicarNoBotaoDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 28)
	@Test
	public void verificaSeAposClicarNoBotaoOTextoEhAlteradoParaFecharRegulamento() {
		assertTrue(tabela.exibiuOTextoFecharRegulamentoAposClicarNoBotaoDeRegulamento());
	}
}