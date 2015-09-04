package testes.fotogaleria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.fotogaleria.BoxDeUltimasFotogalerias;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxDeUltimasMenuTest {
	
	private static BoxDeUltimasFotogalerias fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new BoxDeUltimasFotogalerias(Navegador.CHROME);
		fotogaleria.executaScrollParaAparecerOTituloDeUmaPosicao(fotogaleria.acessaClasseLastFrom());
		fotogaleria.esperaCarregar(3);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		fotogaleria.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDeUltimasFotogaleriasEstaSendoExibidaNoFimDaPagina(){
		assertTrue(fotogaleria.exibiuMaisDeUmaOpcaoDeEditoriasNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeAoClicarEmCadaUmDasEditoriasElasEstaoSendoExibidasComAClasseActive() throws InterruptedException{
		assertTrue(fotogaleria.exibiuAposClicarAsEditoriasComAClasseActive());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeEmCadaUmDasEditoriasEstaSendoExibidoNoMinimoUmaFotogaleria(){
		assertTrue(fotogaleria.exibiuNoMinimoUmaFotogaleriaParaCadaEditoria());
	}
}