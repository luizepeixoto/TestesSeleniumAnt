package testes.tabelas.copaDoBrasil;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabela.copaDoBrasil.TabelaCopaDoBrasil;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TabelaCopaDoBrasilTest {

	private static TabelaCopaDoBrasil tabela;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new TabelaCopaDoBrasil(Navegador.CHROME);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOTituloDaTabelaDaCopaDoBrasilEstaSendoExibidoNoTopoDaPagina() {
		String tituloEsperado="Copa do Brasil 2015";
		assertEquals(tituloEsperado, tabela.exibiuTituloDaTabela());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOMenuEstaSendoExibido() {
		assertNotNull(tabela.exibiuOMenuDaTabela());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOsTitulosDasFasesDoMenuEstaoCorretos() {
		assertTrue(tabela.exibiuTabFasePrevia());
		assertTrue(tabela.exibiuTabPrimeiraFase());
		assertTrue(tabela.exibiuTabSegundaFase());
		assertTrue(tabela.exibiuTabTerceiraFase());
		assertTrue(tabela.exibiuTabOitavasDeFinal());
		assertTrue(tabela.exibiuTabQuartasDeFinal());
		assertTrue(tabela.exibiuTabSemiFinal());
		assertTrue(tabela.exibiuTabFinal());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOBoxDeJogosDaFasePreviaEstaSendoExibido() throws InterruptedException {
		tabela.clicarTabFasePrevia();
		assertTrue(tabela.exibiuOBoxDeJogosPreliminares());
	}
	
//	@OrdemExecucaoTeste(Ordem=5)
//	@Test
//	public void verificaSeADataDosJogosPreliminaresEstaSendoExibido() {
//		assertTrue(tabela.exibiuADataDosJogosPreliminares());
//	}
//	
//	@OrdemExecucaoTeste(Ordem=6)
//	@Test
//	public void verificaSeAHoraDosJogosPreliminaresEstaSendoExibido() {
//		assertTrue(tabela.exibiuAHoraDosJogosPreliminares());
//	}
//	
//	@OrdemExecucaoTeste(Ordem=7)
//	@Test
//	public void verificaSeOsEstadiosDosJogosPreliminaresEstaoSendoExibido() {
//		assertTrue(tabela.exibiuOEstadioDosJogosPreliminares());
//	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeAPrimeiraFaseEstaExibindoOTotalDeJogosCorretamente() throws InterruptedException {
		tabela.clicarTabPrimeiraFase();
		assertTrue(tabela.exibiuONumeroCorretoDeJogosDaPrimeiraFase());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeASegundaFaseEstaExibindoOTotalDeJogosCorretamente() throws InterruptedException {
		tabela.clicarTabSegundaFase();
		assertTrue(tabela.exibiuONumeroCorretoDeJogosDaSegundaFase());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeATerceiraFaseEstaExibindoOTotalDeJogosCorretamente() throws InterruptedException {
		tabela.clicarTabTerceiraFase();
		assertTrue(tabela.exibiuONumeroCorretoDeJogosDaTerceiraFase());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeAFaseDeOitavasDeFinalEstaExibindoOTotalDeJogosCorretamente() throws InterruptedException {
		tabela.clicarTabOitavasDeFinal();
		assertTrue(tabela.exibiuONumeroCorretoJogosDasOitavas());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeAFaseDeQuartasDeFinalEstaExibindoOTotalDeJogosCorretamente() throws InterruptedException {
		tabela.clicarTabQuartasDeFinal();
		assertTrue(tabela.exibiuONumeroCorretoDeJogosDasQuartas());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeAFaseSemiFinalEstaExibindoOTotalDeJogosCorretamente() throws InterruptedException {
		tabela.clicarTabSemiFinal();
		assertTrue(tabela.exibiuONumeroCorretoDeJogosDaSemiFinais());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeAFaseFinalEstaExibindoOTotalDeJogosCorretamente() throws InterruptedException {
		tabela.clicarTabFinal();
		assertTrue(tabela.exibiuONumeroCorretoDeJogosDaFinal());
	}
}
