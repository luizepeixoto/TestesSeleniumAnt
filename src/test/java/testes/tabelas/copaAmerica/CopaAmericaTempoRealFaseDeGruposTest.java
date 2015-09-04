package testes.tabelas.copaAmerica;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.copaAmerica.CopaAmericaComTempoReal;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class CopaAmericaTempoRealFaseDeGruposTest {

	private static CopaAmericaComTempoReal tabela;
	private static String posicaoScrollDesejado = "container-arroba-banner"; 
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new CopaAmericaComTempoReal(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar(5);
		tabela.scrollAteATabela(posicaoScrollDesejado);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeAPrimeiraFaseEhAFaseAtualCasoNaoSejaAcessaADesejada() {
		assertTrue(tabela.acessaAFaseDesejada(0));
	}
	
	/*Início da Validação do Primeiro Grupo*/
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOTituloDoGrupoAEstaSendoExibido() throws InterruptedException {
		tabela.ScrollAteOTitulo(0);
		assertTrue(tabela.exibiuTituloDoGrupoCorretamente(0, "GRUPO A"));
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeATabelaDeClassificacaoDoGrupoAEstasendoExibida() {
		assertTrue(tabela.exibiuTabelaDeClassificacaoDoGrupoSelecionado(0));
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeOsTitulosDaTabelasDeClassificacaoDoGrupoAEstaoSendoExibidos() {
		assertTrue(tabela.exibiuTituloDasColunasDasTabelaDeClassificacaoDoGrupoSelecionado(0));
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeOConteudoDaTabelaDeClassificacaoDoGrupoAEhValido() {
		assertTrue(tabela.exibiuConteudoValidoParaCadaUmaDasColunasDasTabelaDeClassificacaoDoGrupoSelecionado(0));
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeOsDoisPrimeiroTimesDaTabelaDeClassificacaoDoGrupoAEstaSendoExibidosComUmaTarjaVerde() {
		assertTrue(tabela.exibiuUmaTarjaVerdeParaOsDoisPrimeirosTimesDoGrupoSelecionado(0));
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeOTerceiroTimeDaTabelaDeClassificacaoDoGrupoAEstaSendoExibidoComUmaTarjaAzul() {
		assertTrue(tabela.exibiuUmaTarjaAzulParaOTerceiroTimeDoGrupoSelecionado(0));
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeOQuartoTimeDaTabelaDeClassificacaoDoGrupoAEstaSendoExibidoSemTarja() {
		assertTrue(tabela.exibiuOQuartoTimeDoGrupoSelecionadoSemTarja(0));
	}
	
	@OrdemExecucaoTeste(Ordem = 9)
	@Test
	public void verificaSeAsLinhasDaTabelaDeClassificacaoEstaoSendoExibidasComDegrade() {
		assertTrue(tabela.exibiuLinhasDaTabelaDoGrupoSelecionadoDoTempoRealEmDegrade(0));
	}
	
	@OrdemExecucaoTeste(Ordem = 10)
	@Test
	public void verificaSeATabelaDeRodadasDoGrupoAEstaSendoExibida() {
		assertTrue(tabela.exibiuTabelaDeRodadasDoGrupoSelecionado(0));
	}
	
	@OrdemExecucaoTeste(Ordem = 11)
	@Test
	public void verificaSeAsInformacoesDasRodadasDoGrupoAEstaoSendoExibidas() throws InterruptedException {
		assertTrue(tabela.exibiuOInformacoesDasRodadasDoGrupoSelecionado(0, "a.next"));
	}
	
	/*Início da Validação do Segundo Grupo*/
	@OrdemExecucaoTeste(Ordem = 12)
	@Test
	public void verificaSeOTituloDoGrupoBEstaSendoExibido() throws InterruptedException {
		tabela.ScrollAteOTitulo(1);
		assertTrue(tabela.exibiuTituloDoGrupoCorretamente(1, "GRUPO B"));
	}
	
	@OrdemExecucaoTeste(Ordem = 13)
	@Test
	public void verificaSeATabelaDeClassificacaoDoGrupoBEstasendoExibida() {
		assertTrue(tabela.exibiuTabelaDeClassificacaoDoGrupoSelecionado(1));
	}
	
	@OrdemExecucaoTeste(Ordem = 14)
	@Test
	public void verificaSeOsTitulosDaTabelasDeClassificacaoDoGrupoBEstaoSendoExibidos() {
		assertTrue(tabela.exibiuTituloDasColunasDasTabelaDeClassificacaoDoGrupoSelecionado(1));
	}
	
	@OrdemExecucaoTeste(Ordem = 15)
	@Test
	public void verificaSeOConteudoDaTabelaDeClassificacaoDoGrupoBEhValido() {
		assertTrue(tabela.exibiuConteudoValidoParaCadaUmaDasColunasDasTabelaDeClassificacaoDoGrupoSelecionado(1));
	}
	
	@OrdemExecucaoTeste(Ordem = 16)
	@Test
	public void verificaSeOsDoisPrimeiroTimesDaTabelaDeClassificacaoDoGrupoBEstaoSendoExibidosComUmaTarjaVerde() {
		assertTrue(tabela.exibiuUmaTarjaVerdeParaOsDoisPrimeirosTimesDoGrupoSelecionado(1));
	}
	
	@OrdemExecucaoTeste(Ordem = 17)
	@Test
	public void verificaSeOTerceiroTimeDaTabelaDeClassificacaoDoGrupoBEstaSendoExibidoComUmaTarjaDeAzul() {
		assertTrue(tabela.exibiuUmaTarjaAzulParaOTerceiroTimeDoGrupoSelecionado(1));
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem = 18)
	@Test
	public void verificaSeOQuartoTimeDaTabelaDeClassificacaoDoGrupoBEstaSendoExibidoSemTarjaDeClassificacao() {
		assertTrue(tabela.exibiuOQuartoTimeDoGrupoSelecionadoNoTempoRealSemTarja(1));
	}
	
	@OrdemExecucaoTeste(Ordem = 19)
	@Test
	public void verificaSeAsLinhasDaTabelaDeClassificacaoDoGrupoBEstaoSendoExibidasComDegrade() {
		assertTrue(tabela.exibiuLinhasDaTabelaDoGrupoSelecionadoDoTempoRealEmDegrade(1));
	}
	
	@OrdemExecucaoTeste(Ordem = 20)
	@Test
	public void verificaSeATabelaDeRodadasDoGrupoBEstaSendoExibida() {
		assertTrue(tabela.exibiuTabelaDeRodadasDoGrupoSelecionado(1));
	}
	
	@OrdemExecucaoTeste(Ordem = 21)
	@Test
	public void verificaSeAsInformacoesDasRodadasDoGrupoBEstaoSendoExibidas() throws InterruptedException {
		assertTrue(tabela.exibiuOInformacoesDasRodadasDoGrupoSelecionado(1, "div.navTabelas.grupoB > a.next"));
	}
	
	/*Início da Validação do Terceiro Grupo*/
	@OrdemExecucaoTeste(Ordem = 22)
	@Test
	public void verificaSeOTituloDoGrupoCEstaSendoExibido() throws InterruptedException {
		tabela.ScrollAteOTitulo(2);
		assertTrue(tabela.exibiuTituloDoGrupoCorretamente(2, "GRUPO C"));
	}
	
	@OrdemExecucaoTeste(Ordem = 23)
	@Test
	public void verificaSeATabelaDeClassificacaoDoGrupoCEstasendoExibida() {
		assertTrue(tabela.exibiuTabelaDeClassificacaoDoGrupoSelecionado(2));
	}
	
	@OrdemExecucaoTeste(Ordem = 24)
	@Test
	public void verificaSeOsTitulosDaTabelasDeClassificacaoDoGrupoCEstaoSendoExibidos() {
		assertTrue(tabela.exibiuTituloDasColunasDasTabelaDeClassificacaoDoGrupoSelecionado(2));
	}
	
	@OrdemExecucaoTeste(Ordem = 25)
	@Test
	public void verificaSeOConteudoDaTabelaDeClassificacaoDoGrupoCEhValido() {
		assertTrue(tabela.exibiuConteudoValidoParaCadaUmaDasColunasDasTabelaDeClassificacaoDoGrupoSelecionado(2));
	}
	
	@OrdemExecucaoTeste(Ordem = 26)
	@Test
	public void verificaSeOsDoisPrimeiroTimesDaTabelaDeClassificacaoDoGrupoCEstaoSendoExibidosComUmaTarjaVerde() {
		assertTrue(tabela.exibiuUmaTarjaVerdeParaOsDoisPrimeirosTimesDoGrupoSelecionado(2));
	}
	
	@OrdemExecucaoTeste(Ordem = 27)
	@Test
	public void verificaSeOTerceiroTimeDaTabelaDeClassificacaoDoGrupoCEstaSendoExibidoComUmaTarjaDeAzul() {
		assertTrue(tabela.exibiuUmaTarjaAzulParaOTerceiroTimeDoGrupoSelecionado(2));
	}
	
	@OrdemExecucaoTeste(Ordem = 28)
	@Test
	public void verificaSeOQuartoTimeDaTabelaDeClassificacaoDoGrupoCEstaSendoExibidoSemTarjaDeClassificacao() {
		assertTrue(tabela.exibiuOQuartoTimeDoGrupoSelecionadoNoTempoRealSemTarja(2));
	}
	
	@OrdemExecucaoTeste(Ordem = 29)
	@Test
	public void verificaSeAsLinhasDaTabelaDeClassificacaoDoGrupoCEstaoSendoExibidasComDegrade() {
		assertTrue(tabela.exibiuLinhasDaTabelaDoGrupoSelecionadoDoTempoRealEmDegrade(2));
	}
	
	@OrdemExecucaoTeste(Ordem = 30)
	@Test
	public void verificaSeATabelaDeRodadasDoGrupoCEstaSendoExibida() {
		assertTrue(tabela.exibiuTabelaDeRodadasDoGrupoSelecionado(2));
	}
	
	@OrdemExecucaoTeste(Ordem = 31)
	@Test
	public void verificaSeAsInformacoesDasRodadasDoGrupoCEstaoSendoExibidas() throws InterruptedException {
		assertTrue(tabela.exibiuOInformacoesDasRodadasDoGrupoSelecionado(2, "div.navTabelas.grupoC > a.next"));
	}
}