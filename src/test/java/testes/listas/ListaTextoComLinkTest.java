package testes.listas;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.lista.ListaTextoComLink;

import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class ListaTextoComLinkTest {
	
	private static ListaTextoComLink lista;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		lista = new ListaTextoComLink();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		lista.fechar();
	}
	
	//Teste criado relacionado ao defeito: DE2892 [PRD] Links no texto dos fatos de um lista de fatos ficam não clicáveis
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOTextoDaListaDeFatoEstaApresentandoUmLink() {
		assertTrue(lista.exibiuLinkNoTexto());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOLinkDaListaDeFatoEhValido() {
		assertTrue(lista.exibiuLinkValidoNoTexto());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAListaDeFatosEstaExibindoOMaximoDeCaracteresValidos() {
		assertTrue(lista.exibiuMaximoDeCaracteresComUmLinkTexto());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void clicouNoLinkEAbriuEmUmaNovaJanela() throws InterruptedException{
		lista.clicouNoLink();
		assertTrue(lista.abriuEmUmaNovaJanela());
	}
}