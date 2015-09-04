package testes.editorias.euReporter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.editoria.EuReporterMenuSubEditorias;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class EuReporterMenuTest {
	
	private static EuReporterMenuSubEditorias eureporter;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(eureporter.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		eureporter = new EuReporterMenuSubEditorias(Navegador.CHROME);
		eureporter.esperaCarregar(2);
		eureporter.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		eureporter.fechar();
	}
	
	@Test
	public void verificaSeAEditoriaEuReporterEstaSendoExibidaNoMenu(){
		String resultadoEsperado="EU-REPÓRTER";
		assertEquals(resultadoEsperado, eureporter.getEditoria());
	}
	
	@Test
	public void verificaSeAEditoriaEuReporterExibidaNoMenuPossuiUmLink(){
		assertTrue(eureporter.getEditoriaLink());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaQueEstaSendoExibidaNoMenuPossuiUmLinkValido(){
		assertTrue(eureporter.getEditoriaLinkValido());
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasEstaExibindoAEditoriaDaMateria() throws InterruptedException{
		String resultadoEsperado="EU-REPÓRTER";
		assertEquals(resultadoEsperado, eureporter.getEditoriaMenuEsquerdo());
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasPossuiUmLink() throws InterruptedException{
		assertTrue(eureporter.getEditoriaMenuEsquerdoLink());
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasPossuiUmLinkValido() throws InterruptedException{
		assertTrue(eureporter.getEditoriaMenuEsquerdoLinkValido());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaQueEstaSendoExibidaNoMenuPrincipalEhAMesmaExibidaNoMenuEsquerdoDeSubEditorias() throws InterruptedException{
		assertTrue(eureporter.getEditoriaMenuEsquerdoCompara());
	}
	
	@Test
	public void verificaSeAbaixoDoMenuEsquerdoDeSubeditoriasEstaSendoExibidoOTextoDeIrParaAPagina() throws InterruptedException{
		String resultadoEsperado="ir para a página";
		assertEquals(resultadoEsperado, eureporter.getTextoIrPagina());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiUmLink() throws InterruptedException{
		assertTrue(eureporter.getTextoIrPaginaURL());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiUmLinkValido() throws InterruptedException{
		assertTrue(eureporter.getTextoIrPaginaURLValido());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiOMesmoLinkDaEditoriaExibidaAcima(){
		assertTrue(eureporter.getIrPaginaComparaLinkEditoria());
	}
	
	@Test
	public void verificaSeAListaDeSubeditoriasEstaSendoExbida() throws InterruptedException{
		assertTrue(eureporter.getListaSub());
	}
	
	@Test
	public void verificaSeAListaDeSubeditoriasEstaoExibindoONomeDaSubeditoria() throws InterruptedException{
		assertTrue(eureporter.exibiuNomeSubEditorias());
	}
	
	@Test
	public void verificaSeAListaDeSubeditoriasEstaoExibindoUmLinkNoNomeDaSubeditoria() throws InterruptedException{
		assertTrue(eureporter.getListaSubNomeLink());
	}
	
	@Test
	public void verificaSeAListaDeSubeditoriasEstaoExibindoUmLinkValidoNoNomeDaSubeditoria() throws InterruptedException{
		assertTrue(eureporter.getListaSubNomeLinkValido());
	}
}