package testes.ela.editoria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.ela.editoria.DestaquesElaVideos;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class DestaqueElaComVideoTest {
	
	private static DestaquesElaVideos destaque;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaque = new DestaquesElaVideos(Navegador.CHROME);
		destaque.esperaCarregar(2);
		destaque.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		destaque.executaScrollParaAparecerOTituloDeUmaPosicao(destaque.obterBoxDeVideos());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		destaque.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void verificaSeOBoxDeVideosEstaSendoExibido() {
		assertTrue(destaque.exibiuOBoxDeVideos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void verificaSeOTituloDoBoxEstaSendoExibido() {
		assertTrue(destaque.exibiuOTituloDoBoxDeVideos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void verificaSeOContadorAtualEhIgualAUm() {
		assertTrue(destaque.exibiuOContadorAtualIgualAUm());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void verificaSeOContadorTotalEhIgualAoTotalDeVideosDoBox() {
		assertTrue(destaque.exibiuOContadorTotalIgualAoTotalDeVideosDoBox());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void verificaSeASetaAnteriorEstaSendoExibida() {
		assertTrue(destaque.exibiuASetaAnterior());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void verificaSeASetaPosteriorEstaSendoExibida() {
		assertTrue(destaque.exibiuASetaPosterior());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void verificaSeASetaAnteriorEstaSendoExibidaDesabilitadaPorPadrao() {
		assertTrue(destaque.exibiuASetaAnteriorDesabilitadaPorPadrao());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void verificaSeNoMinimoUmVideoEstaSendoExibido() {
		assertTrue(destaque.exibiuNoMinimoUmVideo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void verificaSeOContadorAtualEhAtualizadoAoAvancarOsVideos() throws InterruptedException {
		assertTrue(destaque.exibiuOContadorAtualSendoAtualizadoAoAvancarOsVideos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void verificaSeASetaDePosteriorEstaSendoExibidaDesabilitadaNoUltimoVideo() {
		assertTrue(destaque.exibiuASetaPosteriorDesabilitadaNoUltimoVideo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void verificaSeOContadorAtualEhAtualizadoAoVoltarOsVideos() throws InterruptedException {
		assertTrue(destaque.exibiuOContadorAtualSendoAtualizadoAoVoltarOsVideos());
	}
}