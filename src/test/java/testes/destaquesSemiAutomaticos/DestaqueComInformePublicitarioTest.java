package testes.destaquesSemiAutomaticos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.destaques.DestaquesComInformePublicitario;

import crops.CropsDestaques;


public class DestaqueComInformePublicitarioTest {
	
	private static DestaquesComInformePublicitario destaque;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaque = new DestaquesComInformePublicitario();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		destaque.fechar();
	}
	
	@Test
	public void exibiuChamadaDeInformePublicitarioNosDestaques(){
		assertNotNull(destaque.exibiuChamadaDeInformePublicitarioNosDestaques());
	}
	
	@Test
	public void verificaSeOTituloEspecialPublicitarioEstaSendoExibido(){
		String resultadoEsperado = "Especial Publicitário";
		assertEquals(resultadoEsperado.toLowerCase(), destaque.exibiuTextoDeEspecialPublicitarioNosDestaques());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEspecialPublicitarioEstaSendoExibido(){
		assertTrue(destaque.exibiuTituloDaMateria());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEspecialPublicitarioPossuiUmLink(){
		assertTrue(destaque.exibiuTituloDaMateriaComLink());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEspecialPublicitarioPossuiUmLinkValido(){
		assertTrue(destaque.exibiuTituloDaMateriaComLinkValido());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEspecialPublicitarioPossuiNoMaximo70Caracteres(){
		assertTrue(destaque.exibiuTituloComNoMaximo70Caracteres());
	}
	
	@Test
	public void verificaSeMateriaEspecialPublicitarioEstaExibindoUmaImagem(){
		assertTrue(destaque.exibiuImagem());
	}
	
	@Test
	public void verificaSeMateriaEspecialPublicitarioPossuiOCropCorreto(){
		assertTrue(destaque.exibiuCropCorretoParaAImagem());
	}
	
	@Test
	public void verificaSeMateriaEspecialPublicitarioEstaExibindoAImagemComOWidthCorreto(){
		String widthEsperado = CropsDestaques.semiAutomaticoMateria.getWidth();
		assertEquals(widthEsperado, destaque.exibiuWidthImagem());
	}
	
	@Test
	public void verificaSeMateriaEspecialPublicitarioEstaExibindoAImagemComOHeightCorreto(){
		String heightEsperado = CropsDestaques.semiAutomaticoMateria.getHeight();
		assertEquals(heightEsperado, destaque.exibiuHeightImagem());
	}
}