package testes.colunas;

import static org.junit.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.coluna.ColunaSemBoxNavegacao;
import br.com.infoglobo.pages.Navegador;


public class ColunaSemBoxNavegacaoTest {
	
private static ColunaSemBoxNavegacao coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new ColunaSemBoxNavegacao(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		coluna.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoNaoEstaSendoExibidoParaMateriasComDataDeCriacaoMaioreMenorQue7Dias(){
		assertTrue(coluna.exibiuBoxDeNavegacao());
	}

}
