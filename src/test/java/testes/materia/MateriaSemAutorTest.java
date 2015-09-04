package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaSemAutor;

import br.com.infoglobo.pages.Navegador;

public class MateriaSemAutorTest {
	
	private static MateriaSemAutor materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaSemAutor(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void VerificaSeOAutorDaMateriaEstaSendoExibidoComoOGloboQuandoEleNaoEhPreenchido(){
		String autorEsperado = "O GLOBO";
		assertEquals(autorEsperado, materia.exibiuAutorComoOGlobo());
	}
}