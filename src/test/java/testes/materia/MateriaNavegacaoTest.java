package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaNavegacao;

import br.com.infoglobo.pages.Navegador;

public class MateriaNavegacaoTest {
	
	private static MateriaNavegacao materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaNavegacao(Navegador.CHROME);
		materia.aguardaBoxDeNavegacaoCarregar();
		materia.executaScrollAteOBoxDePaginacao();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoEstaSendoExibido(){
		assertNotNull(materia.exibiuBoxDeNavegacao());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoParaAMateriaAnteriorEstaSendoExibido(){
		assertNotNull(materia.exibiuBoxDeNavegacaoAnterior());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoAnteriorPossuiUmLink(){
		assertTrue(materia.exibiuUmLinkNoNoBoxDeNavegacaoAnterior());
	}
	
	@Test
	public void verificaSeOLinkDeNavegacaoMaisAntigaEhValido(){
		assertTrue(materia.getBoxPaginacaoAntigaLinkValido());
	}
	
	@Test
	public void verificaSeOTituloAnteriorEstaSendoExibido(){
		String tituloEsperado = "ANTERIOR";
		assertEquals(tituloEsperado, materia.getBoxPaginacaoAntigaTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaMaisAntigaEstaSendoExibidoEmNegrito(){
		assertTrue(materia.exibiuTituloDaMateriaAnteriorEmNegrito());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoParaAMateriaMaisRecenteEstaSendoExibido(){
		assertNotNull(materia.exibiuPaginacaoProxima());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoMaisRecentePossuiUmLink(){
		assertTrue(materia.getBoxPaginacaoRecenteLink());
	}
	
	@Test
	public void verificaSeOLinkDeNavegacaoMaisRecenteEhValido(){
		assertTrue(materia.getBoxPaginacaoRecenteLinkValido());
	}
	
	@Test
	public void verificaSeOTituloMaisRecenteEstaSendoExibidoEmUmaFonteDiferente(){
		String tituloEsperado = "PRÓXIMA";
		assertEquals(tituloEsperado, materia.getBoxPaginacaoRecenteTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaMaisRecenteEstaSendoExibidoEmNegrito(){
		assertTrue(materia.exibiuTituloDaMateriaProximaEmNegrito());
	}
}