package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaComUmaPublicidade;


public class MateriaComUmaPublicidadeTest {
	
	private static MateriaComUmaPublicidade materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComUmaPublicidade();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeNaColunaDaDireitaEstaSendoExibidoApenasUmaPublicidadeNaMateria(){
		assertTrue(materia.exibiuApenasUmaPublicidade());
	}
	
	@Test
	public void verificaSeOTituloPublicidadeEstaSendoExibidoAcimaDoBoxDePublicidadeArroba(){
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
		assertNotNull(materia.getBoxScriptPublicidade());
	}
}