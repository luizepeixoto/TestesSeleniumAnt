package testes.tabelas.copaAmerica;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.copaAmerica.CopaAmericaComTempoReal;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class CopaAmericaTempoRealFaseFinalTest {

	private static CopaAmericaComTempoReal tabela;
	
	private String faseDesejada = "finais";
	private static String posicaoScrollDesejado = "container-arroba-banner"; 
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new CopaAmericaComTempoReal(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar(5);
		tabela.scrollAteATabela(posicaoScrollDesejado);
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