package testes.informe.publicitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaInformePublicitario;


public class ExclusoesDeWidgetsTest {
	
	private static MateriaInformePublicitario exclusoes;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		exclusoes = new MateriaInformePublicitario();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		exclusoes.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeAgoraEmDestaqueNaoEstaSendoExibido(){
		assertTrue(exclusoes.exibiuBoxDeAgoraEmDestaque());
	}
	
	@Test
	public void verificaSeOBoxDaZunitNaoEstaSendoExibido(){
		assertTrue(exclusoes.exibiuBoxDaZunit());
	}
	
	@Test
	public void verificaSeOBoxDeMaisLidasNaoEstaSendoExibido(){
		assertTrue(exclusoes.exibiuBoxDeMaisLidasDoSite());
	}
}