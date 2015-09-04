package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaNavegacaoSemProxima;

import br.com.infoglobo.pages.Navegador;

public class MateriaNavegacaoSemProximaTest {
	
	private static MateriaNavegacaoSemProxima materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaNavegacaoSemProxima(Navegador.CHROME);
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
	public void verificaSeOBoxDeNavegacaoParaAMateriaMaisRecenteEstaSendoExibidoNaCorCinza(){
		assertTrue(materia.exibiuBoxDeNavegacaoDeProximaDesativado());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoMaisRecenteNaoPossuiUmLink(){
		assertTrue(materia.exibiuBoxDeProximaSemLink());
	}
	
	@Test
	public void verificaSeOTituloProximaEstaSendoExibidoEmUmaFonteDiferente(){
		String tituloEsperado = "PRÓXIMA";
		assertEquals(tituloEsperado, materia.getBoxPaginacaoRecenteTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaProximaEstaSendoExibidoEmNegrito(){
		assertTrue(materia.exibiuOTituloDoBoxDeProximoEmNegrito());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxDeNavegacaoMaisRecenteEhOMesmoTituloDaMateriaDaPagina(){
		assertTrue(materia.exibiuOTituloDoBoxProximaIgualAoTituloDaMateria());
	}
}