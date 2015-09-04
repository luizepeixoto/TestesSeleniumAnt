package testes.capa.direita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxArroba;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxArrobaTest {
	
	private static BoxArroba capaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(capaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception{
		capaDaDireita = new BoxArroba(Navegador.CHROME);
		capaDaDireita.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		capaDaDireita.executaScrollAteAPosicaoDesejada(capaDaDireita.acessaCapaDaDireita);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste(){
		capaDaDireita.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBannerArrobaEstaSendoExibidonaPagina() throws InterruptedException{
		capaDaDireita.executaScrollParaAparecerOTituloPublicidade(capaDaDireita.acessaCapaDaDireita);
		assertNotNull(capaDaDireita.acessaBannerArroba(capaDaDireita.acessaCapaDaDireita));
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOBannerArrobaEstaExibindoUmTituloDePublicidade(){
		String tituloEsperado = "PUBLICIDADE";
		assertEquals(tituloEsperado, capaDaDireita.exibiuTituloPublicidade(capaDaDireita.acessaCapaDaDireita));
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOTituloPublicidadeAcimaDoBannerArrobaPossuiUmLink(){
		assertTrue(capaDaDireita.exibiuLinkNoTituloPublicidade(capaDaDireita.acessaCapaDaDireita));
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOLinkDoTituloPublicidadeAcimaDoBannerArrobaEstaAbrindoNumaNovaJanela(){
		assertTrue(capaDaDireita.exibiuOLinkNoTituloPublicidadeComTargetBlank(capaDaDireita.acessaCapaDaDireita));
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeOScriptDePublicidadeArrobaEstaSendoCarregado(){
		assertNotNull(capaDaDireita.validarScriptPublicidade(capaDaDireita.acessaCapaDaDireita));
	}
}