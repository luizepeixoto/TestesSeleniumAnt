package testes.enquete;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.enquete.EnqueteSuperVotada;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class EnqueteSuperVotadaTest {
	
	private static EnqueteSuperVotada enquete;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		enquete = new EnqueteSuperVotada(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		enquete.fechar();
	}
	
	/*	Matéria dever ser configurada com:
	 		Enquete permitindo n votos porém apenas um voto por opção; 
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
		assertNotNull(enquete.exibiuOpcaoVotada());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmaFoto(){
		assertTrue(enquete.exibiuUmaFotoNaOpcaoVotada());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmTitulo(){
		assertTrue(enquete.exibiuUmTituloParaOpcaoVotada());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmSubtitulo(){
		assertTrue(enquete.exibiuUmSubtituloParaOpcaoVotada());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmaDescricao(){
		assertTrue(enquete.exibiuAsOpcoesDeVotoComUmaDescricao());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmBotaoDeVotado(){
		assertTrue(enquete.exibiuOBotaoDeVotado());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmTituloDeVerResultado(){
		String tituloEsperado = "ver resultado";
		assertEquals(tituloEsperado, enquete.exibiuTituloDeVerResultado());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmLinkDeVerResultado(){
		assertTrue(enquete.exibiuLinkDeVerResultado());
	}
}