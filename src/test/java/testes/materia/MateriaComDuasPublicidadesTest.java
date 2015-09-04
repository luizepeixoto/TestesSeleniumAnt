package testes.materia;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaComDuasPublicidades;


public class MateriaComDuasPublicidadesTest {
	
	private static MateriaComDuasPublicidades materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComDuasPublicidades();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeNaColunaDaDireitaEstaSendoExibidoDuasPublicidadesNaMateria(){
		assertTrue(materia.exibiuApenasDuasPublicidades());
	}
	
	@Test
	public void verificaSeOTituloPublicidadeEstaSendoExibodoParaCadaUmaDasPropagandas(){
		assertTrue(materia.exibiuOTituloPublicidade());
	}
	
	@Test
	public void verificaSeOTituloPropagandaAcimaDoSuperLeaderboardPossuiUmLink(){
		assertTrue(materia.exibiuOTituloPublicidadePossuiUmLink());
	}
	
	@Test
	public void verificaSeOTituloPropagandaAcimaDoSuperLeaderboardPossuiUmLinkValido(){
		assertTrue(materia.exibiuOTituloPublicidadePossuiUmLinkValido());
	}
	
	@Test
	public void verificaSeOLinkDoTituloPropagandaAcimaDoSuperLeaderboardEstaAbrindoNumaNovaJanela(){
		assertTrue(materia.exibiuOLinkNoTituloPublicidadeComTargetBlank());
	}
	
	@Test
	public void verificaSeOScriptDePublicidadeArrobaEstaSendoCarregado(){
		assertTrue(materia.getBoxScriptPublicidade());
	}
}