package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaSemBoxNavegacao;

import br.com.infoglobo.pages.Navegador;

public class MateriaSemBoxNavegacaoTest {
	
	private static MateriaSemBoxNavegacao materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaSemBoxNavegacao(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoNaoEstaSendoExibidoParaMateriasComDataDeCriacaoMaioreMenorQue7Dias(){
		assertTrue(materia.exibiuBoxDeNavegacao());
	}
}