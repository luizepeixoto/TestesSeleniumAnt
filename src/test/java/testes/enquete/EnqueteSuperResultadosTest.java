package testes.enquete;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.enquete.EnqueteSuperResultados;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class EnqueteSuperResultadosTest {
	
	private static EnqueteSuperResultados enquete;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		enquete = new EnqueteSuperResultados(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		enquete.fechar();
	}
	
	/*	Matéria dever ser configurada com:
	  		Enquete ainda deve estar habilitada para votos
			Lista de opções para a enquete apresentada;
			Cada uma das opções deve possui foto, subtítulo e descrição;
			Uma das opções já deve estar votada;
	 */	
	
	public void executarLoginNaEnquete(String email, String senha) throws Exception{
		enquete.clicarEmVotar();
		enquete.inserirEmail(email);
		enquete.inserirSenha(senha);
		enquete.clicarNoBotaoEntrar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeUmaDasOpcoesDaListaEhUmaOpcaoVotada() throws Exception{
		executarLoginNaEnquete("testecadun@hotmail.com", "secret123");
		assertTrue(enquete.exibiuLinkDeVerResultado());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeAoClicarNoLinkDeVerResultadoAPaginaDeResultadosSeraExibida() throws Exception{
		enquete.clicarEmVerResultados();
		assertNotNull(enquete.exibiuPaginaDeResultados());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOTituloDaPaginaDeResultadosEstaSendoExibido() throws Exception{
		assertTrue(enquete.exibiuTituloDaPaginaDeResultados());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeUmaListaDeOpcoesDeResultadosEstaSendoExibido() throws Exception{
		assertTrue(enquete.exibiuUmaListaDeResultados());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeCadaUmDosResultadosEstaExibindoUmaFoto() throws Exception{
		assertTrue(enquete.exibiuUmaFotoParaCadaUmDosResultados());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeCadaUmDosResultadosEstaExibindoANumeroDaPosicao() throws Exception{
		assertTrue(enquete.exibiuAPosicaoDeCadaUmDosResultados());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeCadaUmDosResultadosEstaExibindoABarraDeProgressoDoTotalDeFotos() throws Exception{
		assertTrue(enquete.exibiuBarraDeProgressoParaCadaUmDosResultados());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeCadaUmDosResultadosEstaExibindoOPercentualDeFotos() throws Exception{
		assertTrue(enquete.exibiuOPercentualDeFotosDeCadaUmDosResultados());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeCadaUmDosResultadosEstaExibindoOTitulo() throws Exception{
		assertTrue(enquete.exibiuTituloParaCadaUmDosResultados());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeNoFinalDaPaginaEstaSendoExibidoOBotaoDeVotarNovamente() throws Exception{
		assertNotNull(enquete.exibiuOBotaoDeVotarNovamente());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeOTituloDoBotaoDeVotarNovamentePossuiUmLink() throws Exception{
		assertTrue(enquete.exibiuOBotaoDeVotarNovamenteComUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOTituloDoBotaoDeVotarNovamenteEstaExibindoOTituloCarreto() throws Exception{
		String tituloEsperado = "VOTAR NOVAMENTE";
		assertEquals(tituloEsperado, enquete.exibiuOTituloCorretoNoBotaoDeVotarNovamente());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeAoClicarNoBotaoDeVotarNovamenteOUsuarioSeraRedirecionadoParaAPaginaDeVotacao() throws Exception{
		enquete.clicarEmVotarNovamente();
		assertNotNull(enquete.exibiuAPaginaDeVotacao());
	}
}