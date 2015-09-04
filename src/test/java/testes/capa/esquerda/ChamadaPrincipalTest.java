package testes.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaPrincipal;

import br.com.infoglobo.pages.Navegador;

public class ChamadaPrincipalTest {
	
	private static ChamadaPrincipal capa;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new ChamadaPrincipal(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@Test
	public void verificaSeOBoxDaChamadaPrincipalEstaSendoExibida(){
		assertNotNull(capa.acessaChamadaPrincipal());
	}
	
	@Test
	public void verificaSeAEditoriaDaChamadaPrincipalEstaSendoExibida(){
		assertTrue(capa.exibiuEditoriaNaChamadaPrincipal());
	}
	
	@Test
	public void verificaSeAEditoriaDaChamadaPrincipalPossuiUmLink(){
		assertTrue(capa.exibiuLinkNaEditoriaDaChamadaPrincipal());
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDaChamadaPrincipalEhValido(){
		assertTrue(capa.getBoxChamadaPrincipalEditoriaLinkValido());
	}
	
	@Test
	public void verificaSeAMateriaDaChamadaPrincipalPossuiUmTitulo(){
		assertTrue(capa.exibiuTituloDaChamadaPrincipal());
	}
	
	@Test
	public void verificaSeAMateriaDaChamadaPrincipalPossuiUmTituloComUmLink(){
		assertTrue(capa.exibiuTituloDaChamadaPrincipalComUmLink());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDaChamadaPrincipalPossuiUmLinkValido(){
		assertTrue(capa.getBoxChamadaPrincipalTituloLinkValido());
	}
	
	@Test
	public void verificaSeAMateriaDaChamadaPrincipalEstaExibindoOAutor(){
		assertTrue(capa.exibiuAutorDaChamadaPrincipal());
	}
	
	@Test
	public void verificaSeADescricaoDaMateriaDaChamadaPrincipalEstaSendoExibida(){
		assertTrue(capa.exibiuDescricaoDaMateriaChamadaPrincipal());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDaChamadaPrincipalEstaSendoExibido(){
		assertTrue(capa.exibiuComentariosParaAChamadaPrincipal());
	}
	
	@Test
	public void verificaSeOBoxDeWebChamadasPossuemUmLink(){
		assertTrue(capa.exibiuLinkNoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeOBoxDeWebChamadasPossuemUmLinkValido(){
		assertTrue(capa.getBoxWebChamadaLinkValido());
	}
	
	@Test
	public void verificaSeOPrimeiroBoxDeWebChamadaPossuemUmaFoto(){
		assertTrue(capa.getBoxWebChamadaFotoParaOPrimeiroBox());
	}
	
	@Test
	public void verificaSeAPrimeiraFotoDaWebChamadaPossueAClasseLinkAnimado(){
		assertTrue(capa.getBoxWebChamadaPrimeiraFotoLinkAnimado());
	}
	
	@Test
	public void verificaSeAFotoDaWebChamadaDoPrimeiroBoxPossuiOWidthDe60Px(){
		assertTrue(capa.getBoxWebChamadaDoPrimeiroBoxComFotoWidth());
	}
	
	@Test
	public void verificaSeAFotoDaWebChamadaPossuemOHeightDe60Px(){
		assertTrue(capa.getBoxWebChamadaDoPrimeiroBoxComFotoHeight());
	}
	
	@Test
	public void verificaSeOPrimeiroBoxDaWebChamadaEstaExibindoTituloDeOpiniaoOuEntrevistaOuNenhum(){
		assertTrue(capa.getBoxWebChamadaTituloPrimeiroBox());
	}
	
	@Test
	public void verificaSeOPrimeiroBoxDaWebChamadaEstaExibindoAutor(){
		assertTrue(capa.getWebChamadaAutorPrimeiroBox());
	}
	
	@Test
	public void verificaSeOSegundoBoxDeWebChamadaPossuemUmaFoto(){
		assertTrue(capa.getBoxWebChamadaFotoParaOSegundoBox());
	}
	
	@Test
	public void verificaSeASegundaFotoDaWebChamadaPossueAClasseLinkAnimado(){
		assertTrue(capa.getBoxWebChamadaSegundaFotoLinkAnimado());
	}
	
	@Test
	public void verificaSeAFotoDaWebChamadaDoSegundoBoxPossuiOWidthDe60Px(){
		assertTrue(capa.getBoxWebChamadaDoSegundoBoxComFotoWidth());
	}
	
	@Test
	public void verificaSeAFotoDaWebChamadaDoPrimeiroBoxPossuiOHeightDe60Px(){
		assertTrue(capa.getBoxWebChamadaDoSegundoBoxComFotoHeight());
	}
	
	@Test
	public void verificaSeOSegundoBoxDaWebChamadaEstaExibindoTituloDeOpiniaoOuEntrevistaOuNenhum(){
		assertTrue(capa.getBoxWebChamadaTituloSegundoBox());
	}
	
	@Test
	public void verificaSeOSegundoBoxDaWebChamadaEstaExibindoAutor(){
		assertTrue(capa.getWebChamadaAutorSegundoBox());
	}
	
	@Test
	public void verificaSeOBoxDaWebChamadaEstaExibindoUmTexto(){
		assertTrue(capa.getBoxWebChamadaDescricao());
	}
	
	@Test
	public void verificaSeOsBoxDasWebChamadasEstaoExibindoTituloComNoMaximo44Caracteres(){
		assertTrue(capa.getBoxWebChamadaTitulosBoxMaximoCaracteres());
	}

	@Test
	public void verificaSeAsDescricoesDasWebChamadasPossuemMaisDe80Caracteres(){
		assertTrue(capa.exibiuTamanhoDoTituloCorreto());
	}
	
	@Test
	public void verificaSeOBoxDaMateriaDaRelacionadaEstaSendoExibido(){
		assertNotNull(capa.exibiuChamadaSecundaria());
	}
	
	@Test
	public void verificaSeAMateriaRelacionadaEstaExibindoUmaFoto(){
		assertTrue(capa.exibiuUmaFotoNaChamadaSecundaria());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaRelacionadaPossuiAClasseLinkAnimado(){
		//Não pode exibir
		assertTrue(capa.exibiuClasseAnimadaParaAImagemDaChamadaSecundaria());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaRelacionadaPossuiOWidthDe140px(){
		assertTrue(capa.exibiuImagemDaChamadaSecundariaComWidthCorreto());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaRelacionadaPossuiOHeightDe84px(){
		assertTrue(capa.exibiuImagemDaChamadaSecundariaComHeightCorreto());
	}
	
	@Test
	public void verificaSeAMateriaRelacionadaPossuiUmTitulo(){
		assertTrue(capa.exibiuTituloParaAChamadaSecundaria());
	}
	
	@Test
	public void verificaSeAMateriaRelacionadaPossuiUmTituloComUmLink(){
		assertTrue(capa.exibiuUmTituloComLinkParaAChamadaSecundaria());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaRelacionadaPossuiUmLinkValido(){
		assertTrue(capa.getBoxMateriaRelacionadaLinkValido());
	}
	
	@Test
	public void verificaSeAMateriaRelacionadaEstaExibindoOAutor(){
		assertTrue(capa.exibiuAutorParaAChamadaSecundaria());
	}
	
	@Test
	public void verificaSeADescricaoDaMateriaRelacionadaEstaSendoExibinda(){
		assertTrue(capa.exibiuDescricaoParaAChamadaSecundaria());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDaMateriaRelacionadaEstaSendoExibido(){
		assertTrue(capa.getBoxMateriaRelacionadaComentarios());
	}
}