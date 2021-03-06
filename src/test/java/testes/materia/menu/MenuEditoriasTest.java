package testes.materia.menu;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.menu.MenuEditorias;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class MenuEditoriasTest {
	
	private static MenuEditorias menuLateralEsquerdoo;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(menuLateralEsquerdoo.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		menuLateralEsquerdoo = new MenuEditorias(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		menuLateralEsquerdoo.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDoMenuEstaSendoExibido() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oMenuEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeNoMenuLateralEsquerdoAOpcaoDeHomeEstaSendoExibida() throws InterruptedException {
		String resultadoEsperado = "Home";
		assertEquals(resultadoEsperado, menuLateralEsquerdoo.oNomeHomeEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAListaDeEditoriasEstaSendoExibidaNoMenu() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.aListaDeEditoriasEstaSendoExibida());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOsItensDaAListaDeEditoriasEstaoExibindoONomeDaEditoria() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.osNomeDasEditoriasEstaoSendoExibidos());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeOsItensDaAListaDeEditoriasPossuemUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.osNomeDasEditoriasPossuemUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeOsLinksDosItensDaAListaDeEditoriasSaoValidos() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.osLinkNosItensDasEditoriasSaoValidos());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeOCompartilhamentoDoFacebookEstaSendoExibido() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oCompartilharDoFacebookEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeOCompartilhamentoDoFacebookPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oCompartilhamentoDoFacebookPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeOLinkDoCompartilhamentoDoFacebookEhValido() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDeCompartilharDoFacebookEhValido());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeOCompartilhamentoDoTwitterEstaSendoExibido() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oCompartilharDoTwitterEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOCompartilhamentoDoTwitterPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oCompartilhamentoDoTwitterPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeOLinkDoCompartilhamentoDoTwitterEhValido() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDeCompartilharDoTwitterEhValido());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOCompartilhamentoDoGooglePlusEstaSendoExibido() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oCompartilharDoGooglePlusEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOCompartilhamentoDoGooglePlusPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oCompartilhamentoDoGooglePlusPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeOLinkDoCompartilhamentoDoGooglePlusEhValido() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDeCompartilharDoGooglePlusEhValido());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeOMemoriaEstaSendoExibidoNoFimDoMenu() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oMemoriaEstaSendoExibido());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void verificaSeOTituloMemoriaEstaSendoExibidoNoMenu() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloMemoriaEstaNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeOTituloMemoriaPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloMemoriaPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=19)
	@Test
	public void verificaSeOLinkDoTituloMemoriaEstaCorreto() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDoMemoriaPossuiEstaCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeOAcervoEstaSendoExibidoNoFimDoMenu() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oAcervoEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=21)
	@Test
	public void verificaSeOTituloAcervoEstaSendoExibidoNoMenu() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloAcervoEstaNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=22)
	@Test
	public void verificaSeOTituloAcervoPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloAcervoPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=23)
	@Test
	public void verificaSeOLinkDoTituloAcervoEstaCorreto() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDoAcervoEstaCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=24)
	@Test
	public void verificaSeOElaEstaSendoExibidoNoFimDoMenu() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oElaEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=25)
	@Test
	public void verificaSeOTituloElaEstaSendoExibidoNoMenu() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloElaEstaNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=26)
	@Test
	public void verificaSeOTituloElaPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloElaPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=27)
	@Test
	public void verificaSeOLinkDoTituloElaEstaCorreto() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDoElaEstaCorreto());
	}
	
	
	@OrdemExecucaoTeste(Ordem=28)
	@Test
	public void verificaSeOPatriciaKogutEstaSendoExibidoNoFimDoMenu() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oPatriciaKogutEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=29)
	@Test
	public void verificaSeOTituloPatriciaKogutEstaSendoExibidoNoMenu() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloPatriciaKogutEstaNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=30)
	@Test
	public void verificaSeOTituloPatriciaKogutPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloPatriciaKogutPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=31)
	@Test
	public void verificaSeOLinkDoTituloPatriciaKogutEstaCorreto() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDoPatriciaKogutEstaCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=32)
	@Test
	public void verificaSeORioShowEstaSendoExibidoNoFimDoMenu() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oRioShowEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=33)
	@Test
	public void verificaSeOTituloRioShowEstaSendoExibidoNoMenu() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloRioShowEstaNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=34)
	@Test
	public void verificaSeOTituloRioShowPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloRioShowPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=35)
	@Test
	public void verificaSeOLinkDoTituloRioShowEstaCorreto() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDoRioShowEstaCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=36)
	@Test
	public void verificaSeOExtraEstaSendoExibidoNoFimDoMenu() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oExtraEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=37)
	@Test
	public void verificaSeOTituloExtraEstaSendoExibidoNoMenu() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloExtraEstaNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=38)
	@Test
	public void verificaSeOTituloExtraPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloExtraPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=39)
	@Test
	public void verificaSeOLinkDoTituloExtraEstaCorreto() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDoExtraEstaCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=40)
	@Test
	public void verificaSeOClassificadosDoRioEstaSendoExibidoNoFimDoMenu() throws InterruptedException {
		assertNotNull(menuLateralEsquerdoo.oClassificadosDoRioEstaSendoExibido());
	}
	
	@OrdemExecucaoTeste(Ordem=41)
	@Test
	public void verificaSeOTituloClassificadosDoRioEstaSendoExibidoNoMenu() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloClassificadosDoRioEstaNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=42)
	@Test
	public void verificaSeOTituloClassificadosDoRioPossueUmLink() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oTituloClassificadosDoRioPossuiUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=43)
	@Test
	public void verificaSeOLinkDoTituloClassificadosDoRioEstaCorreto() throws InterruptedException {
		assertTrue(menuLateralEsquerdoo.oLinkDoClassificadosDoRioEstaCorreto());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem=44)
	public void verificaSeOTituloClubeSouMaisRioEstaSendoExibidoNoMenu(){
		assertEquals("Clube Sou + Rio", menuLateralEsquerdoo.oTituloClubeSouMaisRioEstaNoMenu());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem=45)
	public void verificaSeOTituloClubeSouMaisRioPossueUmLink(){
		assertTrue(menuLateralEsquerdoo.oTituloClubeSouMaisRioPossuiUmLink());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem=46)
	public void verificaSeOLinkDoTituloClubeSouMaisRioEstaCorreto(){
		assertTrue(menuLateralEsquerdoo.oLinkDoClubeSouMaisRioEstaCorreto());
	}
}
