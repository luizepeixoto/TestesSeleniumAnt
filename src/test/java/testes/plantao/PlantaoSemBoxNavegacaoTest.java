package testes.plantao;

import static org.junit.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.plantao.PlantaoSemBoxNavegacao;
import br.com.infoglobo.pages.Navegador;

public class PlantaoSemBoxNavegacaoTest {
	
private static PlantaoSemBoxNavegacao plantao;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		plantao = new PlantaoSemBoxNavegacao(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		plantao.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoNaoEstaSendoExibidoParaMateriasComDataDeCriacaoMaioreMenorQue7Dias(){
		assertTrue(plantao.exibiuBoxDeNavegacao());
	}

}
