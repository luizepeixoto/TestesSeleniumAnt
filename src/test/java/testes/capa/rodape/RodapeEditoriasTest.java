package testes.capa.rodape;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.Rodape;


public class RodapeEditoriasTest {
	
	private static Rodape footer;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		footer = new Rodape();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		footer.fechar();
	}
	
	@Test
	public void exibiuOFooter(){
		assertNotNull(footer.exibiuOFooter());
	}
	
	@Test
	public void exibiuOFooterDeEditorias(){
		assertNotNull(footer.exibiuOFooterComDasEditorias());
	}
	
	@Test
	public void exibiuAEditoriaRio(){
		assertNotNull(footer.exibiuNoFooterAEditoriaRio());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeRio(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasRio());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeRioComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasRioComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeRioComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasRioComLinkValido());
	}

	@Test
	public void exibiuAEditoriaSaude(){
		assertNotNull(footer.exibiuNoFooterAEditoriaSaude());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeSaude(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasSaude());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeSaudeComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasSaudeComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeSaudeComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasSaudeComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaBrasil(){
		assertNotNull(footer.exibiuNoFooterAEditoriaBrasil());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeBrasil(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasBrasil());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeBrasilComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasBrasilComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeBrasilComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasBrasilComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaCiencia(){
		assertNotNull(footer.exibiuNoFooterAEditoriaCiencia());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeCiencia(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasCiencia());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeCienciaComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasCienciaComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeCienciaComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasCienciaComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaMundo(){
		assertNotNull(footer.exibiuNoFooterAEditoriaMundo());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeMundo(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasMundo());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeMundoComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasMundoComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeMundoComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasMundoComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaCultura(){
		assertNotNull(footer.exibiuNoFooterAEditoriaCultura());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeCultura(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasCultura());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeCulturaComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasCulturaComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeCulturaComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasCulturaComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaEconomia(){
		assertNotNull(footer.exibiuNoFooterAEditoriaEconomia());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEconomia(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEconomia());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEconomiaComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEconomiaComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEconomiaComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEconomiaComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaEstilo(){
		assertNotNull(footer.exibiuNoFooterAEditoriaEstilo());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEstilo(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEstilo());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEstiloComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEstiloComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEstiloComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEstiloComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaSociedade(){
		assertNotNull(footer.exibiuNoFooterAEditoriaSociedade());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeSociedade(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasSociedade());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeSociedadeComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasSociedadeComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeSociedadeComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasSociedadeComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaEsportes(){
		assertNotNull(footer.exibiuNoFooterAEditoriaEsportes());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEsportes(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEsportes());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEsportesComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEsportesComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeEsportesComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasEsportesComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaTecnologia(){
		assertNotNull(footer.exibiuNoFooterAEditoriaTecnologia());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeTecnologia(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasTecnologia());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeTecnologiaComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasTecnologiaComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeTecnologiaComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasTecnologiaComLinkValido());
	}
	
	@Test
	public void exibiuAEditoriaMais(){
		assertNotNull(footer.exibiuNoFooterAEditoriaMais());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeMais(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasMais());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeMaisComUmLink(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasMaisComLink());
	}
	
	@Test
	public void exibiuAsSubeditoriasDeMaisComUmLinkValido(){
		assertTrue(footer.exibiuNoFooterAsSubEditoriasMaisComLinkValido());
	}
}
