package testes.ultimas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.ultimas.UltimasNoticiasComInformePublicitario;


public class UltimasComInformePublicitarioTest {
	
	private static UltimasNoticiasComInformePublicitario materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new UltimasNoticiasComInformePublicitario();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeAPaginaDeUltimasNoticiasEstaExibindoUmaChamadaDeInformePublicitario(){
		assertNotNull(materia.exibiuChamadaDeInformePublicitario());
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibidaNaChamadaDeInformePublicitario(){
		assertTrue(materia.exibiuEditoriaNaChamadaDoInformePublicitario());
	}
	
	@Test
	public void verificaSeOTituloEstaSendoExibidaNaChamadaDeInformePublicitario(){
		assertTrue(materia.exibiuTituloEmItalicoNaChamadaDoInformePublicitario());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmaFotoOuADescricaoNaChamadaDoInforme(){
		assertTrue(materia.exibiuFotoOuDescricaoNaChamadaDoInformePublicitario());
	}
}