package testes.capa.meio;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.CapaMeioMancheteInformePublicitario;


public class MancheteInformePublicitarioTest {
	
	private static CapaMeioMancheteInformePublicitario colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new CapaMeioMancheteInformePublicitario();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void verificaSeOInformePublicitarioNaoEstaSendoExibidoNaColunaDoMeio(){
		assertTrue(colunaDoMeio.exibiuInformePublicitarioNaColunaDoMeio());
	}
	
	@Test
	public void verificaSeOTituloEspecialPublicitarioEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuTituloEspecialPublicitarioNasChamadasDaColunaDoMeio());
	}
	
	@Test
	public void verificaSeOsTitulosDasMateriasEstaoSendoExibidosEmItalico(){
		assertTrue(colunaDoMeio.exibiuTituloDaMateriaEmItalico());
	}
	
	@Test
	public void verificaSeAlgumaDasMateriasRelacionadasEstaExibindoATarjaDeEspecialPublicitario(){
		assertTrue(colunaDoMeio.exibiuMateriaRelacionadaSemTarjaDeEspecialPublicitario());
	}
	
	@Test
	public void verificaSeAlgumaDasMateriasRelacionadasDoSegundoBlocoEstaExibindoATarjaDeEspecialPublicitario(){
		assertTrue(colunaDoMeio.exibiuMateriaRelacionadaSemTarjaDeEspecialPublicitarioParaAsmateriasDoSegundoBloco());
	}
	
	@Test
	public void verificaSeAlgumaDasMateriasRelacionadasDoTerceiroBlocoEstaExibindoATarjaDeEspecialPublicitario(){
		assertTrue(colunaDoMeio.exibiuMateriaRelacionadaSemTarjaDeEspecialPublicitarioParaAsmateriasDoTerceiroBloco());
	}
}