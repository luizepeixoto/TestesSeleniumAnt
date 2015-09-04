package testes.materia.comentario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.comentario.ComentarioComRespostas;


public class ComentarioComRespostasTest {
	
	private static ComentarioComRespostas materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new ComentarioComRespostas();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOComentarioEstaSendoExibidoNoMenu(){
		assertNotNull(materia.getComentarioMenu());
	}
	
	@Test
	public void verificaSeOComentarioPossuiMaisDeUmaResposta(){
		assertTrue(materia.getTotalRespostas());
	}
	
	@Test
	public void verificaSeAsRespostasPossuemONomeDoAutorSendoExibido(){
		assertTrue(materia.getAutorDasRespostas());
	}
	
	@Test
	public void verificaSeAsRespostasPossuemONomeDoAutorEADataSendoSeparadasPorUmBullet(){
		assertTrue(materia.getBulletEntreAutorEResposta());
	}
	
	@Test
	public void verificaSeAsRespostasPossuemDataDePostagem(){
		assertTrue(materia.getDataDasRespostas());
	}
	
	@Test
	public void verificaSeAsRespostasPossuemUmTextoValido(){
		assertTrue(materia.getTextoDasRespostas());
	}
}