package testes.materia.menu;

import static org.junit.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.materia.menu.MenuSubEditorias;

public class SubeditoriasTest {
	
	private static MenuSubEditorias subeditoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		subeditoria = new MenuSubEditorias();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		subeditoria.fechar();
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaEstaSendoExibidaNoMenu(){
		assertTrue(subeditoria.getEditoria());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaQueEstaSendoExibidaNoMenuPossuiUmLink(){
		assertTrue(subeditoria.getEditoriaLink());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaQueEstaSendoExibidaNoMenuPossuiUmLinkValido(){
		assertTrue(subeditoria.getEditoriaLinkValido());
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasPossuiUmLink(){
		assertTrue(subeditoria.getEditoriaMenuEsquerdoLink());
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasPossuiUmLinkValido(){
		assertTrue(subeditoria.getEditoriaMenuEsquerdoLinkValido());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaQueEstaSendoExibidaNoMenuPrincipalEhAMesmaExibidaNoMenuEsquerdoDeSubEditorias(){
		assertTrue(subeditoria.getEditoriaMenuEsquerdoCompara());
	}
	
	@Ignore
	@Test
	public void verificaSeAbaixoDoMenuEsquerdoDeSubeditoriasEstaSendoExibidoOTextoDeIrParaAPagina(){
		assertTrue(subeditoria.getTextoIrPagina());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiUmLink(){
		assertTrue(subeditoria.getTextoIrPaginaURL());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiUmLinkValido(){
		assertTrue(subeditoria.getTextoIrPaginaURLValido());
	}
	
	@Test
	public void verificaSeOTextoDeIrParaAPaginaPossuiOMesmoLinkDaEditoriaExibidaAcima(){
		assertTrue(subeditoria.getIrPaginaComparaLinkEditoria());
	}
	
	@Test
	public void verificaSeAListaDeSubeditoriasEstaSendoExbida(){
		assertTrue(subeditoria.getListaSub());
	}
	
	@Test
	public void verificaSeAListaDeSubeditoriasEstaoExibindoUmLinkNoNomeDaSubeditoria(){
		assertTrue(subeditoria.getListaSubNomeLink());
	}
	
	@Test
	public void verificaSeAListaDeSubeditoriasEstaoExibindoUmLinkValidoNoNomeDaSubeditoria(){
		assertTrue(subeditoria.getListaSubNomeLinkValido());
	}
}