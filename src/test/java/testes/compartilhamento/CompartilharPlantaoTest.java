package testes.compartilhamento;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.compartilhamento.CompartilharPlantao;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class CompartilharPlantaoTest {
	
	private static CompartilharPlantao compartilhar;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		compartilhar = new CompartilharPlantao(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		compartilhar.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDoMenuDeCompartilharEstaSendoExibidoNoMenu() throws InterruptedException {
		assertNotNull(compartilhar.getBoxCompartilhar());
	}

	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOTextoCompartilharEstaSendoExibidoNoMenu() throws InterruptedException{
		String resultadoEsperado="compartilhar";
		assertEquals(resultadoEsperado, compartilhar.getTituloCompartilhar().toLowerCase());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeMenuCompartilharPossuiUmaListaDeCompartilhamento() throws InterruptedException{
		assertTrue(compartilhar.listaDeCompartilhamentoEhIgualATres());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAOpcaoCompartilharPeloFacebookEstaSendoExibidoNoMenu() throws InterruptedException{
		assertTrue(compartilhar.OCompartilharPeloFacebookEstaNaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAOpcaoCompartilharPeloFacebookEstaExibidoNoMenuOTextoRecomendar() throws InterruptedException{
		String resultadoEsperado="recomendar";
		assertEquals(resultadoEsperado, compartilhar.OTextoRecomendarEstaNaLista().toLowerCase());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeAOpcaoCompartilharPeloFacebookPossuiUmaURL() throws InterruptedException{
		assertTrue(compartilhar.OCompartilharPeloFacebookPossuiLink());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeAOpcaoCompartilharPeloFacebookPossuiUmaURLValida() throws InterruptedException{
		assertTrue(compartilhar.OCompartilharPeloFacebookPossuiUmLinkValido());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeONumeroTotalDeCompartilhamentoDoFacebookEstaSendoExibido() throws InterruptedException{
		assertNotNull(compartilhar.exibiuTotalDeCompartilhamentosDoFacebook());
	}
	
	//Compartilhamento do twitter
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeAOpcaoCompartilharPeloTwitterEstaSendoExibidoNoMenu() throws InterruptedException{
		assertTrue(compartilhar.OCompartilharPeloTwitterEstaNaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeAOpcaoCompartilharPeloTwitterEstaExibidoNoMenuOTextoTweet() throws InterruptedException{
		String resultadoEsperado="tweet";
		assertEquals(resultadoEsperado, compartilhar.OTextoTweetEstaNaLista().toLowerCase());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeAOpcaoCompartilharPeloTwitterPossuiUmaURL() throws InterruptedException{
		assertTrue(compartilhar.OCompartilharPeloTwitterPossuiLink());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeAOpcaoCompartilharPeloTwitterPossuiUmaURLValida() throws InterruptedException{
		assertTrue(compartilhar.OCompartilharPeloTwitterPossuiUmLinkValido());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeONumeroTotalDeCompartilhamentoDoTwitterEstaSendoExibido() throws InterruptedException{
		assertNotNull(compartilhar.exibiuTotalDeCompartilhamentosDoTwitter());
	}
	
	//Compartilhamento do GooglePlus
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeAOpcaoCompartilharPeloGooglePlusEstaSendoExibidoNoMenu() throws InterruptedException{
		assertTrue(compartilhar.OCompartilharPeloGooglePlusEstaNaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeAOpcaoCompartilharPeloGooglePlusEstaExibidoNoMenuOTextoGoogle() throws InterruptedException{
		String resultadoEsperado="google+";
		assertEquals(resultadoEsperado, compartilhar.OTextoGooglePlusEstaNaLista().toLowerCase());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeAOpcaoCompartilharPeloGooglePlusPossuiUmaURL() throws InterruptedException{
		assertTrue(compartilhar.OCompartilharPeloGooglePlusPossuiLink());
	}
}