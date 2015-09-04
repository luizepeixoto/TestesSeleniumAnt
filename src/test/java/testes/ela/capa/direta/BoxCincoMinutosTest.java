package testes.ela.capa.direta;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.capa.CapaEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxCincoMinutosTest {
	
	private static CapaEla colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new CapaEla(Navegador.CHROME);
		colunaDaDireita.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		colunaDaDireita.esperaCarregar(2);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeCincoMinutosEstaSendoExibido(){
		assertTrue(colunaDaDireita.exibiuBoxDeCincoMinutos());
	}
	
	@Test
	public void verificaSeOIframeBoxDeCincoMinutosEstaCorreto(){
		assertTrue(colunaDaDireita.exibiuInformacoesCorretasNoBoxDeCincoMinutos());
	}
}