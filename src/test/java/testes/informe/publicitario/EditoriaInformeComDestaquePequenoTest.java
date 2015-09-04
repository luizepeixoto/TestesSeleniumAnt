package testes.informe.publicitario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.informe.publicitario.EditoriaInformeDestaquePequeno;


public class EditoriaInformeComDestaquePequenoTest {
	
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
	public void verificaSeAChamadaDoEspecialPublicitarioEstaSendoExibidoNoTopoDaPagina(){
		assertNotNull(editoria.exibiuChamadaDeEspecialPublicitario());
	}
	
	@Test
	public void verificaSeOTituloEspecialPublicitarioEstaSendoExibidoNoTopoDaPagina(){
		String tituloEsperado = "Especial publicitário";
		String tituloAtual = editoria.exibiuTituloEspecialPublicitario().toLowerCase();
		assertEquals(tituloEsperado.toLowerCase(), tituloAtual);
	}
	
	@Test
	public void verificaSeODestaqueEstaSendoExibido(){
		assertNotNull(editoria.exibiuDestaque());
	}
	
	@Test
	public void verificaSeAFotoDoDestaqueEstaSendoExibida(){
		assertTrue(editoria.exibiuFotoDoDestaque());
	}
	
	@Test
	public void verificaSeAChamadaDaFotoDoDestaquePossuiUmLink(){
		assertTrue(editoria.exibiuFotoDoDestaqueComLink());
	}
	
	@Test
	public void verificaSeOLinkDaChamadaDaFotoDoDestaqueEhValido(){
		assertTrue(editoria.exibiuFotoDoDestaqueComUmLinkValido());
	}
	
	@Test
	public void verificaSeAFotoDoDestaquePossuiOHeightCorreto(){
		String heightEsperado = "281";
		String heightAtual = editoria.getHeightDestaquePrincipal();
		assertEquals(heightEsperado, heightAtual);
	}
	
	@Test
	public void verificaSeAFotoDoDestaquePossuiOWidthCorreto(){
		String widthEsperado = "470";
		String widthAtual = editoria.getWidthDestaquePrincipal();
		assertEquals(widthEsperado, widthAtual);
	}
	
	@Test
	public void verificaSeOTituloDoDestaqueEstaSendoExbido(){
		assertTrue(editoria.exibiuTituloNoDestaque());
	}
	
	@Test
	public void verificaSeOTituloDoDestaquePossuiNoMaximo99Caracteres(){
		assertTrue(editoria.exibiuTituloComOMaximo99Caracteres());
	}
	
	@Test
	public void verificaSeOTituloDoDestaquePossuiUmLink(){
		assertTrue(editoria.exibiuLinkNoTituloDoDestaque());
	}
	
	@Test
	public void verificaSeOLinkDoTituloDoDestaqueEhValido(){
		assertTrue(editoria.exibiuUmLinkValidoNoTituloDoDestaque());
	}
	
	@Test
	public void verificaSeADescricaoDoDestaqueEstaSendoExbida(){
		assertTrue(editoria.exibiuDescricaoDoDestaque());
	}
	
	@Test
	public void verificaSeOSubtituloDoDestaquePossuiNoMaximo143Caracteres(){
		assertTrue(editoria.exibiuSubtituloDoDestaqueComnoMaximo143Caracteres());
	}
	
	@Test
	public void verificaSeOsDestaquesSecundariosEstaoSendoExibidos(){
		assertTrue(editoria.exibiuListaDeDestaquesSecundarios());
	}
	
	@Test
	public void verificaSeOsDestaquesSecundariosPossuemUmaFoto(){
		assertTrue(editoria.exibiuDestaquesSecundariosComFoto());
	}
	
	@Test
	public void verificaSeOWidthDasFotosDosDestaquesSecundariosEstaCorreto(){
		assertTrue(editoria.exibiuWidthDosDestaquesSecundariosCorreto());
	}
	
	@Test
	public void verificaSeOHeightDasFotosDosDestaquesSecundariosEstaCorreto(){
		assertTrue(editoria.exibiuHeightDosDestaquesSecundariosCorreto());
	}
	
	@Test
	public void verificaSeAFotoDosDestaquesSecundariosPossuemUmLink(){
		assertTrue(editoria.exibiuLinkNaFotoDosDestaquesSecundarios());
	}
	
	@Test
	public void verificaSeDestaquesSecundariosPossuemUmTitulo(){
		assertTrue(editoria.exibiuTituloNosDestaquesSecundarios());
	}
	
	@Test
	public void verificaSeOTituloDosDestaquesSecundariosPossuemAQuantidadeMaximaDeCaracteres(){
		assertTrue(editoria.exibiuTituloDosDestaquesSecundariosComOMaximoDeCaracteres());
	}
	
	@Test
	public void verificaSeTituloMaisSobreAEditoriaEstaSendoExibida(){
		assertTrue(editoria.exibiuTituloMaisSobreAEditoria());
	}
	
	@Test
	public void verificaSeAsOutrasMateriasDoInformePublicitarioEstaoSendoExibidas(){
		assertTrue(editoria.exibiuListaDeOutrasMaterias());
	}
	
	@Test
	public void verificaSeAsMateriasDoInformePublicitarioPossuemUmaFotoOuUmaDescricao(){
		assertTrue(editoria.exibiuFotoOuDescricaoParaAsMaterias());
	}
	
	@Test
	public void verificaSeAsMateriasDoInformePublicitarioPossuemUmTitulo(){
		assertTrue(editoria.exibiuTituloParaAsMaterias());
	}
	
	@Test
	public void verificaSeAsMateriasDoInformePublicitarioPossuemOTempoDePostagem(){
		assertTrue(editoria.exibiuTempoDePostagemParaAsMaterias());
	}
}