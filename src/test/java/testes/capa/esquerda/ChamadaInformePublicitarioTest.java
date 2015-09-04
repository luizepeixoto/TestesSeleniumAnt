package testes.capa.esquerda;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaInformePublicitario;

public class ChamadaInformePublicitarioTest {
	
	private static ChamadaInformePublicitario chamada;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		chamada = new ChamadaInformePublicitario();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		chamada.fechar();
	}
	
	@Test
	public void verificaSeAChamadaDeInformePublicitarioEstaSendoExibida(){
		assertNotNull(chamada.exibiuChamadaDeInformePublicitario());
	}
	
	@Test
	public void verificaSeOTituloEspecialPublicitarioEstaSendoExibido(){
		String resultadoEsperado = "Especial Publicitário";
		assertEquals(resultadoEsperado, chamada.exibiuTituloDeEspecialPublicitario());
	}
	
	@Test
	public void verificaSeOTituloEspecialPublicitarioPossuiUmLink(){
		assertTrue(chamada.exibiuTituloDeEspecialPublicitarioComLink());
	}
	
	@Test
	public void verificaSeOTituloEspecialPublicitarioPossuiUmLinkValido(){
		assertTrue(chamada.exibiuTituloDeEspecialPublicitarioComLinkValido());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEspecialPublicitarioEstaSendoExibido(){
		assertTrue(chamada.exibiuTituloDaMateria());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEspecialPublicitarioPossuiUmLink(){
		assertTrue(chamada.exibiuTituloDaMateriaComLink());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEspecialPublicitarioPossuiUmLinkValido(){
		assertTrue(chamada.exibiuTituloDaMateriaComLinkValido());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEspecialPublicitarioPossuiNoMaximo70Caracteres(){
		assertTrue(chamada.exibiuTituloComNoMaximo70Caracteres());
	}
	
	@Test
	public void verificaSeMateriaEspecialPublicitarioEstaExibindoUmaImagem(){
		assertTrue(chamada.exibiuImagem());
	}
	
	@Test
	public void verificaSeMateriaEspecialPublicitarioEstaExibindoAImagemComOWidthCorreto(){
		String widthEsperado="460";
		assertEquals(widthEsperado, chamada.exibiuWidthImagem());
	}
	
	@Test
	public void verificaSeMateriaEspecialPublicitarioEstaExibindoAImagemComOHeightCorreto(){
		String heightEsperado="200";
		assertEquals(heightEsperado, chamada.exibiuHeightImagem());
	}
	
	@Test
	public void verificaSeAImagemEspecialPublicitarioPossuiAClasseAnimada(){
		assertTrue(chamada.exibiuClasseAnimadaNaImagem());
	}
	
	@Test
	public void verificaSeOEspecialPublicitarioNaoEstaExibindoUmAutorOuDescricao(){
		assertTrue(chamada.exibiuAutorOuDescricao());
	}
}
