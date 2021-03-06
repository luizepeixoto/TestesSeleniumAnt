package testes.tabelas.copaAmerica;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.copaAmerica.CopaAmerica;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class CopaAmericaRegulamentoTest {

	private static CopaAmerica tabela;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new CopaAmerica(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar(5);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeOBotaoDeRegulamentoEstaSendoExibido() throws InterruptedException {
		tabela.ScrollAteOTitulo(2);
		assertTrue(tabela.exibiuBotaoDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOTituloDoBotaoDeRegulamentoEstaSendoExibido() throws InterruptedException {
		String tituloEsperado = "ABRIR REGULAMENTO";
		tabela.esperaCarregar(1);
		assertEquals(tituloEsperado, tabela.exibiuTituloDoBotaoDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAoClicarNoBotaoDeRegulamentoOTituloMudaParaFecharRegulamento() throws InterruptedException {
		String tituloEsperado = "FECHAR REGULAMENTO";
		tabela.clicarNoBotaoDeRegulamento();
		tabela.esperaCarregar(1);
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
		assertTrue(tabela.exibiuTextoDoRegulamentoCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeAposClicarNoBotaoDeFecharRegulamentoOTextoDeixaDeSerExibido() throws InterruptedException {
		tabela.clicarNoBotaoDeFecharRegulamento();
		tabela.esperaCarregar(1);
		assertTrue(tabela.deixouDeExibirOTextoDoRegulamento());
	}
}