package testes.tabelas.brasileiro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.tabelas.brasileiro.TabelaSerieA;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TabelaSerieARegulamentoTest {

	private static TabelaSerieA tabela;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new TabelaSerieA(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar3Segundos();
		tabela.executarScroll(tabela.getDriver().findElement(By.className("rebaixado")).getLocation());
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeOBotaoDeRegulamentoEstaSendoExibido() {
		assertTrue(tabela.exibiuBotaoDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOTituloDoBotaoDeRegulamentoEstaSendoExibido() throws InterruptedException {
		String tituloEsperado = "ABRIR REGULAMENTO";
		tabela.esperaCarregar1Segundo();
		assertEquals(tituloEsperado, tabela.exibiuTituloDoBotaoDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAoClicarNoBotaoDeRegulamentoOTituloMudaParaFecharRegulamento() throws InterruptedException {
		String tituloEsperado = "FECHAR REGULAMENTO";
		tabela.clicarNoBotaoDeRegulamento();
		tabela.esperaCarregar1Segundo();
		assertEquals(tituloEsperado, tabela.exibiuTituloDoBotaoDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeAposClicarNoBotaoDeRegulamentoOTextoComORegulamentoEstaSendoExibido() {
		assertTrue(tabela.exibiuTextoDoRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeOBackgroundDaCaixaDeRegulamentoEstaSendoExibidoNaCorCinza() {
		assertTrue(tabela.exibiuCorCinzaParaOBoxComOTextoDoRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeOTextoDoRegulamentoEstaSendoExibidoComAFonteEACorCorreta() {
		assertTrue(tabela.exibiuTextoEAFonteDoRegulamentoCorretos());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeOTextoDoRegulamentoEstaCorreto() {
		assertTrue(tabela.exibiuTextoDoRegulamentoSerieACorreto());
	}
	
	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeAposClicarNoBotaoDeFecharRegulamentoOTextoDeixaDeSerExibido() throws InterruptedException {
		tabela.clicarNoBotaoDeFecharRegulamento();
		tabela.esperaCarregar1Segundo();
		assertTrue(tabela.deixouDeExibirOTextoDoRegulamento());
	}
}