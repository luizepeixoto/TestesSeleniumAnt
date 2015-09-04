package testes.materia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaNavegacaoSemAnterior;

import br.com.infoglobo.pages.Navegador;

public class MateriaNavegacaoSemAnteriorTest {
	
	private static MateriaNavegacaoSemAnterior materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaNavegacaoSemAnterior(Navegador.CHROME);
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
	public void verificaSeOBoxDeNavegacaoParaAMateriaMaisAntigaEstaSendoExibidoNaCorCinza(){
		assertTrue(materia.exibiuBoxDeAnteriorDesativado());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoAnteriorEstaSendoExibidoSemLinkLink(){
		assertTrue(materia.exibiuUmLinkNoBoxDePaginacaoAnterior());
	}
	
	@Test
	public void verificaSeOTituloAnteriorEstaSendoExibidoCorretamente(){
		String tituloEsperado = "ANTERIOR";
		assertEquals(tituloEsperado, materia.exibiuTitulodaMateriaNoBoxPaginacaoMaisAntiga());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaAnteriorEstaSendoExibidoEmNegrito(){
		assertTrue(materia.exibiuTituloDaMateriaAnteriorEmNegrito());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxDeNavegacaoAnteriorEhOMesmoTituloDaMateriaDaPagina(){
		assertTrue(materia.exibiuOTituloDoBoxAnteriorIgualAoTituloDaMateria());
	}
}