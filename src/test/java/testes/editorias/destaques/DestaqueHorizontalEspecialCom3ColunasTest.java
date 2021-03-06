package testes.editorias.destaques;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.editoria.destaques.DestaqueHorizontalEspecialCom3Colunas;


public class DestaqueHorizontalEspecialCom3ColunasTest {
	
	private static DestaqueHorizontalEspecialCom3Colunas editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new DestaqueHorizontalEspecialCom3Colunas();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	public void exibiuBoxDeDestaqueEspecial(){
		assertNotNull(editoria.exibiuDestaque());
	}
	
	@Test
	public void verificaSeOTituloUrgenteEstaSendoExibido(){
		String resultadoEsperado = "Urgente";
		assertEquals(resultadoEsperado, editoria.exibiuTituloUrgente());
	}
	
	@Test
	public void verificaSeOTituloUrgenteEstaSendoExibidoNaCorVermelha(){
		assertTrue(editoria.exibiuTituloUrgenteNaCorVermelha());
	}
	
	@Ignore
	@Test
	public void exibiuLinkNoTituloUrgente(){
		assertTrue(editoria.exibiuLinkNoTituloUrgente());
	}
	
	@Ignore
	@Test
	public void exibiuLinkValidoNoTituloUrgente(){
		assertTrue(editoria.exibiuLinkValidoNoTituloUrgente());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEstaSendoExibido(){
		assertTrue(editoria.exibiuTituloDaMateria());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPossuiUmLink(){
		assertTrue(editoria.exibiuTituloDaMateriaComLink());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPossuiUmLinkValido(){
		assertTrue(editoria.exibiuTituloDaMateriaComLinkValido());
	}
	
	@Test
	public void verificaSeDescricaoDaMateriaEstaSendoExibida(){
		assertTrue(editoria.exibiuDescricaoDaMateria());
	}
	
	@Test
	public void verificaSeAFotoDoDestaqueEstaSendoExibida(){
		assertTrue(editoria.exibiuFotoDoDestaque());
	}
	
	@Test
	public void verificaSeAFotoDoDestaqueComWidthDe1260Px(){
		String widthEsperado="1260";
		assertEquals(widthEsperado, editoria.getWidthDaFotoEmDestaque());
	}
	
	@Test
	public void verificaSeAFotoDoDestaquePossuiHeightDe550Px(){
		String heightEsperado="550";
		assertEquals(heightEsperado, editoria.getHeightDaFotoEmDestaque());
	}
	
	@Test
	public void verificaSeAFotoDoDestaquePossuiUmLink(){
		assertTrue(editoria.exibiuLinkNaFotoDoDestaque());
	}
	
	@Test
	public void verificaSeAFotoDoDestaquePossuiUmLnkValido(){
		assertTrue(editoria.exibiuLinkValidoNaFotoDoDestaque());
	}
	
	@Test
	public void verificaSeOResumoDaMateriaEstaSendoExibida(){
		assertTrue(editoria.exibiuResumo());
	}
	
	@Test
	public void verificaSeOAutorDoResumoEstaSendoExibido(){
		assertTrue(editoria.exibiuAutor());
	}
	
	@Test
	public void verificaSeADescricaoDoAutorDoResumoEstaSendoExibido(){
		assertTrue(editoria.exibiuDescricaoDoAutor());
	}
	
	@Test
	public void verificaSeFoiExibidoUmaListaDeMateriasRelacionadas(){
		assertTrue(editoria.exibiuListaDeMaterias());
	}
	
	@Test
	public void verificaSeAsMateriasPossuemFoto(){
		assertTrue(editoria.exibiuAsMateriasComFoto());
	}
	
	@Test
	public void verificaSeAsFotosDasMateriasPossuemWidthCom234Px(){
		assertTrue(editoria.exibiuAsFotosComWidth234());
	}
	
	@Test
	public void verificaSeAsFotosDasMateriasPossuemHeightCom140Px(){
		assertTrue(editoria.exibiuAsFotosComHeight140());
	}
	
	@Test
	public void verificaSeAsFotosDasMateriasPossuemUmLink(){
		assertTrue(editoria.exibiuLinkNasFotos());
	}
	
	@Test
	public void verificaSeAsFotosDasMateriasPossuemUmLinkValido(){
		assertTrue(editoria.exibiuLinkValidoNasFotos());
	}
	
	@Test
	public void verificaSeAsMateriasPossuemUmTitulo(){
		assertTrue(editoria.exibiuTitulosNasMaterias());
	}
	
	@Test
	public void verificaSeOsTitulosDasMateriasPossuemNoMaximo60Caracteres(){
		assertTrue(editoria.exibiuTitulosComMaximoDeCaracteresPermitido());
	}
	
	@Test
	public void verificaSeOsTitulosDasMateriasPossuemUmLink(){
		assertTrue(editoria.exibiuLinkNoTitulosNasMaterias());
	}
	
	@Test
	public void verificaSeOsTitulosDasMateriasPossuemUmLinkValido(){
		assertTrue(editoria.exibiuLinkValidoNoTitulosNasMaterias());
	}
	
	@Test
	public void exibiuAutorNaChamadaPrincipal(){
		assertTrue(editoria.exibiuAutorNaChamadaPrincipal());
	}
	
	@Test
	public void exibiuAutorNaChamadaResumo(){
		assertTrue(editoria.exibiuAutorNaChamadaResumo());
	}
	
	@Test
	public void exibiuAutorNaChamadaDeOpiniao(){
		assertTrue(editoria.exibiuAutorNaChamadadeOpiniao());
	}
	
	
	
}
