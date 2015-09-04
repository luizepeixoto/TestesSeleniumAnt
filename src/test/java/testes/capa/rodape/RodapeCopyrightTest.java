package testes.capa.rodape;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.Rodape;


public class RodapeCopyrightTest {
	
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
	public void exibiuOBannerDoCopyright(){
		assertNotNull(footer.exibiuNoFooterOBannerDoCopyright());
	}
	
	@Test
	public void exibiuOBannerDoCopyrightComWidth112Px(){
		assertNotNull(footer.exibiuOBannerDoCopyrightComWidth112Px());
	}
	
	@Test
	public void exibiuOBannerDoCopyrightComHeight60Px(){
		assertNotNull(footer.exibiuOBannerDoCopyrightComHeight60Px());
	}
	
	@Test
	public void exibiuOBannerDoCopyrightComUmLink(){
		assertNotNull(footer.exibiuOCopyrightComUmLink());
	}
	
	@Test
	public void exibiuOBannerDoCopyrightComUmLinkValido(){
		String urlEsperada="http://www.gda.com/";
		assertEquals(urlEsperada, footer.exibiuOCopyrightComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDoCopyright(){
		DateFormat formatoData = new SimpleDateFormat("yyyy");
		String anoAtual = formatoData.format(new Date());
		
		String resultadoEsperado="© 1996 - " + anoAtual + ". Todos direitos reservados a Infoglobo Comunicação e Participações S.A. Este material não pode ser publicado, transmitido por broadcast, reescrito ou redistribuído sem autorização.";
		assertEquals(resultadoEsperado, footer.exibiuOTextoDoCopyright());
	}
}
