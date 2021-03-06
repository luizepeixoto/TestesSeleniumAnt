package testes.enquete;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.enquete.EnqueteEnriquecidaVotada;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@Ignore
@RunWith(OrdenadorTestes.class)
public class EnqueteEnriquecidaVotadaTest {
	
	private static EnqueteEnriquecidaVotada enquete;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		enquete = new EnqueteEnriquecidaVotada(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		enquete.fechar();
	}
	
	/*	Enquete Bloco de carnaval dever ser configurada com:
	 		Enquete permitindo n votos porém apenas um voto por opção; 
	 		Primeiro bloco deve estar votado.
	 		Não marcar a flag de exibir resultados antes do fechamento 
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
	public void verificaSeAEnqueteVotadaPossuiUmTitulo() throws Exception{
		executarLoginNaEnquete("testecadun@hotmail.com", "secret123");
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
		assertEquals("VOTADO", enquete.exibiuOBotaoDeVotado());
	}
}