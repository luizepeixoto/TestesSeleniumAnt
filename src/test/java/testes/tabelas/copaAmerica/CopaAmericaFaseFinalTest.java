package testes.tabelas.copaAmerica;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.copaAmerica.CopaAmerica;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class CopaAmericaFaseFinalTest {

	private static CopaAmerica tabela;
	
	private String faseDesejada = "finais";
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new CopaAmerica(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar(5);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeASemiFinalEhAFaseAtualCasoNaoSejaAcessaADesejada() {
		assertTrue(tabela.acessaAFaseDesejada(3));
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeATabelaDaFaseFinalEstaSendoExibida() {
		assertTrue(tabela.exibiuFaseDesejada(faseDesejada));
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeOsJogosEstaoExibindoAsInformacoesCorretas() {
		assertTrue(tabela.exibiuDiaHoraELocalDoJogo(faseDesejada));
	}
}