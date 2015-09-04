package testes.materia.comentario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.comentario.MateriaSemComentarioHabilitado;


public class MateriaSemComentarioHabilitadoTest {
	
	private static MateriaSemComentarioHabilitado materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaSemComentarioHabilitado();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBalaoDeComentarioNaoEstaSendoExibidoNoMenu(){
		assertTrue(materia.exibiuBalaoDeComentarios());
	}
	
	@Test
	public void verificaSeOTituloDeComentariosNaoEstaSendoExibido(){
		assertTrue(materia.exibiuTituloComentarios());
	}
}