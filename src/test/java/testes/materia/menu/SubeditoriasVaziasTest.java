package testes.materia.menu;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.menu.MenuEditoriaSubeditoriaVazia;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class SubeditoriasVaziasTest {
	
	private static MenuEditoriaSubeditoriaVazia subeditoriaVazia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(subeditoriaVazia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		subeditoriaVazia = new MenuEditoriaSubeditoriaVazia(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		subeditoriaVazia.fechar();
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaEstaSendoExibidaNoMenu(){
		assertTrue(subeditoriaVazia.exibiuEditoria());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaQueEstaSendoExibidaNoMenuPossuiUmLink(){
		assertTrue(subeditoriaVazia.exibiuLinkNaEditoria());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaQueEstaSendoExibidaNoMenuPossuiUmLinkValido(){
		assertTrue(subeditoriaVazia.exibiuUmLinkValidoNaEditoria());
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasEstaExibindoAEditoriaDaMateria() throws InterruptedException{
		assertTrue(subeditoriaVazia.exibiuEditoriaDoLadoEsquerdoDoMenu());
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasPossuiUmLink() throws InterruptedException{
		assertTrue(subeditoriaVazia.ExibiuUmLinkNaChamadaDaEditoriaNoladoEsquerdo());
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasPossuiUmLinkValido(){
		assertTrue(subeditoriaVazia.getEditoriaMenuEsquerdoLinkValido());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaQueEstaSendoExibidaNoMenuPrincipalEhAMesmaExibidaNoMenuEsquerdoDeSubEditorias() throws InterruptedException{
		assertTrue(subeditoriaVazia.getEditoriaMenuEsquerdoCompara());
	}
	
	@Ignore
	@Test
	public void verificaSeAbaixoDoMenuEsquerdoDeSubeditoriasEstaSendoExibidoOTextoDeIrParaAPagina(){
		assertTrue(subeditoriaVazia.getTextoIrPagina());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiUmLink() throws InterruptedException{
		assertTrue(subeditoriaVazia.getTextoIrPaginaURL());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiUmLinkValido() throws InterruptedException{
		assertTrue(subeditoriaVazia.getTextoIrPaginaURLValido());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiOMesmoLinkDaEditoriaExibidaAcima(){
		assertTrue(subeditoriaVazia.getIrPaginaComparaLinkEditoria());
	}
	
	@Test
	public void verificaSeAListaDeSubeditoriasEstaVazia(){
		assertTrue(subeditoriaVazia.getListaSubVazia());
	}
}