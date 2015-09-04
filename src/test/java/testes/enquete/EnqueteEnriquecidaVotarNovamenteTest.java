package testes.enquete;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.enquete.EnqueteEnriquecidaVotarNovamente;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class EnqueteEnriquecidaVotarNovamenteTest {
	
	private static EnqueteEnriquecidaVotarNovamente enquete;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		enquete = new EnqueteEnriquecidaVotarNovamente(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		enquete.fechar();
	}
	
	/*	Enquete de bloco de carnaval dever ser configurada com:
	 		Enquete permitindo n votos e n votos por opção; 
			Lista de opções para a enquete apresentada;
			Cada uma das opções deve possuir subtítulo e descrição;
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
		assertNotNull(enquete.exibiuOpcaoDeVotarNovamente());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmTitulo(){
		assertTrue(enquete.exibiuUmTituloParaOpcaoVotada());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmSubtitulo(){
		assertTrue(enquete.exibiuUmSubtituloParaOpcaoVotada());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAEnqueteVotadaPossuiUmBotaoDeVotado(){
		String tituloEsperado = "VOTAR NOVAMENTE";
		assertEquals(tituloEsperado, enquete.exibiuOBotaoDeVotado());
	}
}