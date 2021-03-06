package testes.informe.publicitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaInformePublicitario;


public class ChamadaInformeDestaque3ColunasTest {
	
	private static ChamadaInformePublicitario materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new ChamadaInformePublicitario();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOInformePublicitarioNaoEstaSendoExibidoNoDestaque3Colunas(){
		assertTrue(materia.exibiuInformePublicitarioNaChamadaDestaque3Colunas());
	}
}