package testes.editorias.destaques;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.editoria.destaques.DestaqueHorizontalCom3Colunas2Fotos;


public class DestaqueHorizontalCom3Colunas2FotosTest {
	
	private static DestaqueHorizontalCom3Colunas2Fotos editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new DestaqueHorizontalCom3Colunas2Fotos();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	public void exibiuBoxEmDestaque(){
		assertNotNull(editoria.exibiuDestaque());
	}
	
	@Test
	public void exibiuASubeditoria(){
		assertTrue(editoria.exibiuASubeditoria());
	}
	
	@Test
	public void exibiuOTitulo(){
		assertTrue(editoria.exibiuOTitulo());
	}
	
	@Test
	public void exibiuOSubtitulo(){
		assertTrue(editoria.exibiuOSubtitulo());
	}
	
	@Test
	public void exibiuUmaListaDeMaterias(){
		assertTrue(editoria.exibiuUmaListaDeMaterias());
	}
	
	@Test
	public void exibiuOTituloDasMaterias(){
		assertTrue(editoria.exibiuOTituloDasMaterias());
	}
	
	@Test
	public void exibiuOTituloDasMateriasComUmLink(){
		assertTrue(editoria.exibiuUmLinkNoTitulo());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloDasMaterias(){
		assertTrue(editoria.exibiuUmLinkValidoNoTitulo());
	}
	
	@Test
	public void exibiuUmaFotoNaLateraEsquerdaDoDestaque(){
		assertTrue(editoria.getFotoEsquerda());
	}
	
	@Test
	public void exibiuAFotoNaLateraEsquerdaComOWidthCorreto(){
		String widthEsperado="667";
		assertEquals(widthEsperado, editoria.getWidthEsquerda());
	}
	
	@Test
	public void exibiuAFotoNaLateraEsquerdaComOHeightCorreto(){
		String heightEsperado="400";
		assertEquals(heightEsperado, editoria.getHeightEsquerda());
	}
	
	@Test
	public void exibiuUmaFotoNaLateraDireitaDoDestaque(){
		assertTrue(editoria.getFotoDireita());
	}
	
	@Test
	public void exibiuAFotoNaLateraDireitaComOWidthCorreto(){
		String widthEsperado="667";
		assertEquals(widthEsperado, editoria.getWidthDireita());
	}
	
	@Test
	public void exibiuAFotoNaLateraDireitaComOHeightCorreto(){
		String heightEsperado="400";
		assertEquals(heightEsperado, editoria.getHeightDireita());
	}
	
	@Ignore
	@Test
	public void exibiuUmEspacoEntreAsFotos(){
		assertNotNull(editoria.exibiuUmEspacoSeparandoAsImagens());
	}
	
	@Test
	public void exibiuUmaListaDeMateriasRelacionadas(){
		assertTrue(editoria.exibiuMateriasRelacionadas());
	}
	
	@Test
	public void exibiuFotoParaAsMateriasRelacionadas(){
		assertTrue(editoria.exibiuFotoNasMateriasRelacionadas());
	}
	
	@Test
	public void exibiuWidthCorretoParaFotoNasMateriasRelacionadas(){
		assertTrue(editoria.exibiuWidthParaMateriasRelacionadas());
	}
	
	@Test
	public void exibiuHeightCorretoParaFotoNasMateriasRelacionadas(){
		assertTrue(editoria.exibiuHeightParaMateriasRelacionadas());
	}
	
	@Test
	public void exibiuAutorParaAsMateriasRelacionadas(){
		assertTrue(editoria.exibiuAutor());
	}
	
	@Test
	public void exibiuTituloParaAsMateriasRelacionadas(){
		assertTrue(editoria.exibiuTituloNasMateriasRelacionadas());
	}
	
	@Test
	public void exibiuLinkNosTitulosDasMateriasRelacionadas(){
		assertTrue(editoria.exibiuUmLinkNoTituloDasMateriasRelacionadas());
	}
	
	@Test
	public void exibiuUmLinkValidoNosTitulosDasMateriasRelacionadas(){
		assertTrue(editoria.exibiuUmLinkValidoNoTituloDasMateriasRelacionadas());
	}
	
	@Test
	public void exibiuTituloComMaisDe60CaracteresNasMateriasRelacionadas(){
		assertTrue(editoria.exibiuTamanhoDoTituloCorreto());
	}
	
	@Test
	public void exibiuAutorNaChamadaPrincipal(){
		assertTrue(editoria.exibiuAutorNaChamadaPrincipal());
	}
}
