package testes.informe.publicitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaInformePublicitario;


public class PublicidadeInformePublicitarioTest {
	
	private static MateriaInformePublicitario materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaInformePublicitario();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxDePropagandaDeMateriaPatrocinadaEstaSendoExibidaNoFimDaPagina(){
		assertNotNull(materia.exibiuBoxDePropagandaDePatrocinada());
	}
	
	@Test
	public void verificaSeOBoxDePropagandaDeMateriaEstaExibindoATagScriptDosBanners(){
		assertTrue(materia.exibiuTagScriptComAChamadaDoBanner());
	}
	
	@Test
	public void verificaSeOBoxDePropagandaDaMateriaPatrocinadaEstaSendoExibindoOAvisoDeResposabilidade(){
		String resultadoEsperado = "conteúdo de responsabilidade do anunciante";
		assertEquals(resultadoEsperado.toLowerCase(), materia.exibiuFraseDeResponsabilidadeNoBoxDePropaganda());
	}
}