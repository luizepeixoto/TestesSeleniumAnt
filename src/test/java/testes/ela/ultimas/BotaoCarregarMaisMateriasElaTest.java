package testes.ela.ultimas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.ela.ultimas.UltimasNoticiasEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class BotaoCarregarMaisMateriasElaTest {
	
	private static UltimasNoticiasEla ultimasNoticias;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ultimasNoticias = new UltimasNoticiasEla(Navegador.CHROME);
		ultimasNoticias.esperaCarregar(3);
		ultimasNoticias.executaScrollParaAparecerOTituloDeUmaPosicao(ultimasNoticias.acessaBotaoCarregarMaisNoticias());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ultimasNoticias.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOTituloDoBotaoDeCarregarMaisMateriasEstaSendoExibidoCorretamente() throws InterruptedException{
		String tituloEsperado = "CARREGAR MAIS NOTÍCIAS";
		assertEquals(tituloEsperado, ultimasNoticias.exibiuTituloDoBotao());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOBotaoDeCarregarMaisMateriasEstaSendoExibidoComOLayoutCorreto() throws InterruptedException{
		assertTrue(ultimasNoticias.exibiuBotaoComOLayoutCorretoParaOEla());
	}
}