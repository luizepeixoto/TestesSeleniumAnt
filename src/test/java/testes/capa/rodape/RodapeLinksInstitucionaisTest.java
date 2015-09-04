package testes.capa.rodape;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.Rodape;


public class RodapeLinksInstitucionaisTest {
	
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
	public void exibiuNoFooterOBoxDeLinksInstitucionais(){
		assertNotNull(footer.exibiuNoFooterOLinksInstitucionais());
	}
	
	@Test
	public void exibiuOTextoDeCentralDoAssinante(){
		String textoEsperado="Portal do Assinante";
		assertEquals(textoEsperado, footer.exibiuOTextoDeCentralDoAssinante());
	}
	
	@Test
	public void exibiuCentralDoAssinanteComUmLink(){
		assertTrue(footer.exibiuCentralDoAssinanteComUmLink());
	}
	
	@Test
	public void exibiuCentralDoAssinanteComUmLinkValido(){
		String urlEsperada="http://www.centraldoassinante.oglobo.com.br";
		assertEquals(urlEsperada, footer.exibiuCentralDoAssinanteComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeClubeSouRio(){
		String textoEsperado="Clube Sou+Rio";
		assertEquals(textoEsperado, footer.exibiuOTextoDeClubeSouRio());
	}
	
	@Test
	public void exibiuClubeSouRioComUmLink(){
		assertTrue(footer.exibiuClubeSouRioComUmLink());
	}
	
	@Test
	public void exibiuClubeSouRioComUmLinkValido(){
		String urlEsperada="https://clubesoumaisrio.oglobo.globo.com/";
		assertEquals(urlEsperada, footer.exibiuClubeSouRioComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeFacaSuaAssinatura(){
		String textoEsperado="Faça sua assinatura";
		assertEquals(textoEsperado, footer.exibiuOTextoDeFacaSuaAssinatura());
	}
	
	@Test
	public void exibiuFacaSuaAssinaturaComUmLink(){
		assertTrue(footer.exibiuFacaSuaAssinaturaComUmLink());
	}
	
	@Test
	public void exibiuFacaSuaAssinaturaComUmLinkValido(){
		//String urlEsperada="https://seguro.oglobo.com.br/assinatura/Default.aspx?id_parc=26";
		assertTrue(footer.exibiuFacaSuaAssinaturaComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeAgenciaOGlobo(){
		String textoEsperado="Agência O Globo";
		assertEquals(textoEsperado, footer.exibiuOTextoDeAgenciaOGlobo());
	}
	
	@Test
	public void exibiuAgenciaOGloboComUmLink(){
		assertTrue(footer.exibiuAgenciaOGloboComUmLink());
	}
	
	@Test
	public void exibiuAgenciaOGloboComUmLinkValido(){
		String urlEsperada="http://www.agenciaoglobo.com.br/";
		assertEquals(urlEsperada, footer.exibiuAgenciaOGloboComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeOGloboShopping(){
		String textoEsperado="O Globo Shopping";
		assertEquals(textoEsperado, footer.exibiuOTextoDeOGloboShopping());
	}
	
	@Test
	public void exibiuOGloboShoppingComUmLink(){
		assertTrue(footer.exibiuOGloboShoppingComUmLink());
	}
	
	@Test
	public void exibiuOGloboShoppingComUmLinkValido(){
		String urlEsperada="http://shopping.oglobo.com.br/";
		assertEquals(urlEsperada, footer.exibiuOGloboShoppingComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeFaleConosco(){
		String textoEsperado="Fale conosco";
		assertEquals(textoEsperado, footer.exibiuOTextoDeFaleConosco());
	}
	
	@Test
	public void exibiuFaleConoscoComUmLink(){
		assertTrue(footer.exibiuFaleConoscoComUmLink());
	}
	
	@Test
	public void exibiuFaleConoscoComUmLinkValido(){
		//String urlEsperada="http://oglobo.globo.com/fale-conosco";
		assertTrue(footer.exibiuFaleConoscoComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeDefesaDoConsumidor(){
		String textoEsperado="Defesa do Consumidor";
		assertEquals(textoEsperado, footer.exibiuOTextoDeDefesaDoConsumidor());
	}
	
	@Test
	public void exibiuDefesaDoConsumidorComUmLink(){
		assertTrue(footer.exibiuDefesaDoConsumidorComUmLink());
	}
	
	@Test
	public void exibiuDefesaDoConsumidorComUmLinkValido(){
		String urlEsperada="https://defesa.oglobo.com.br/";
		assertEquals(urlEsperada, footer.exibiuDefesaDoConsumidorComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeExpediente(){
		String textoEsperado="Expediente";
		assertEquals(textoEsperado, footer.exibiuOTextoDeExpediente());
	}
	
	@Test
	public void exibiuExpedienteComUmLink(){
		assertTrue(footer.exibiuExpedienteComUmLink());
	}
	
	@Test
	public void exibiuExpedienteComUmLinkValido(){
		//String urlEsperada="http://oglobo.globo.com/expediente/";
		assertTrue(footer.exibiuExpedienteComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeAnuncieConosco(){
		String textoEsperado="Anuncie conosco";
		assertEquals(textoEsperado, footer.exibiuOTextoDeAnuncieConosco());
	}
	
	@Test
	public void exibiuAnuncieConoscoComUmLink(){
		assertTrue(footer.exibiuAnuncieConoscoComUmLink());
	}
	
	@Test
	public void exibiuAnuncieConoscoComUmLinkValido(){
		//String urlEsperada="http://anuncie.globo.com/infoglobo/";
		assertTrue(footer.exibiuAnuncieConoscoComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeTrabalheConosco(){
		String textoEsperado="Trabalhe conosco";
		assertEquals(textoEsperado, footer.exibiuOTextoDeTrabalheConosco());
	}
	
	@Test
	public void exibiuTrabalheConoscoComUmLink(){
		assertTrue(footer.exibiuTrabalheConoscoComUmLink());
	}
	
	@Test
	public void exibiuTrabalheConoscoComUmLinkValido(){
		String urlEsperada="http://www.vagas.com.br/infoglobo";
		assertEquals(urlEsperada, footer.exibiuTrabalheConoscoComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDePolíticaDePrivacidade(){
		String textoEsperado="Política de privacidade";
		assertEquals(textoEsperado, footer.exibiuOTextoDePoliticaDePrivacidade());
	}
	
	@Test
	public void exibiuPolíticaDePrivacidadeComUmLink(){
		assertTrue(footer.exibiuPoliticaDePrivacidadeComUmLink());
	}
	
	@Test
	public void exibiuPolíticaDePrivacidadeComUmLinkValido(){
		String urlEsperada="http://oglobo.globo.com/politica-de-privacidade/";
		assertEquals(urlEsperada, footer.exibiuPoliticaDePrivacidadeComUmLinkValido());
	}
	
	@Test
	public void exibiuOTextoDeTermosDeUso(){
		String textoEsperado="Termos de uso";
		assertEquals(textoEsperado, footer.exibiuOTextoDeTermosDeUso());
	}
	
	@Test
	public void exibiuTermosDeUsoComUmLink(){
		assertTrue(footer.exibiuTermosDeUsoComUmLink());
	}
	
	@Test
	public void exibiuTermosDeUsoComUmLinkValido(){
		String urlEsperada="http://oglobo.globo.com/termos-de-uso/";
		assertEquals(urlEsperada, footer.exibiuTermosDeUsoComUmLinkValido());
	}
}
