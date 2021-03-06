package testes.informe.publicitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.informe.publicitario.EditoriaInformeDestaquePequeno;


public class EditoriaInformeComDestaquePequenoBannersTest {
	
	private static EditoriaInformeDestaquePequeno editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new EditoriaInformeDestaquePequeno();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	public void verificaSeOBannerSuperLeaderboardDoInformePublicitarioEstaSendoExibidoNoTopoDaPagina(){
		assertTrue(editoria.exibiuBannerSuperLeaderboardDoInformePublicitarioNoTopoDaPagina());
	}
	
	@Test
	public void verificaSeOBannerDoInformePublicitarioEstaSendoExibidoNoFimDaPagina(){
		assertTrue(editoria.exibiuBannerDoInformePublicitarioNoFimDaPagina());
	}
	
	@Test
	public void verificaSeOBannerDoGloboShoppingNaoEstaSendoExibidoNoFimDaPagina(){
		assertTrue(editoria.exibiuBannerDoGloboShoppingNoFimDaPagina());
	}
	
}