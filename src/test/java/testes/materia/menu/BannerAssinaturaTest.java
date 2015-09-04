package testes.materia.menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.menu.MenuBusca;

import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BannerAssinaturaTest {
	
	private static MenuBusca busca;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(busca.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		busca = new MenuBusca();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		busca.fechar();
	}
	
	@Test
	public void verificaSeOBoxQueContemOBannerDeAssinaturaDigitalEstaSendoExibido(){
		assertNotNull(busca.exibiuBoxAssinatura());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaDigitalPossuiUmLink(){
		assertNotNull(busca.getBoxAssinaturaLink());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaDigitalPossuiUmLinkValido(){
		assertNotNull(busca.getBoxAssinaturaLinkValido());
	}
	
	@Test
	public void verificaSeOTextoDoBannerDeAssinaturaDigitalEstaCorreto(){
		String resultadoEsperado="Clique e assine";
		assertEquals(resultadoEsperado,busca.getBoxAssinaturaLinkTexto());
	}
}