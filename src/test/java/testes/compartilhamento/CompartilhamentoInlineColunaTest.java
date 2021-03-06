package testes.compartilhamento;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.coluna.Coluna;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class CompartilhamentoInlineColunaTest {
	
	private static Coluna coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new Coluna(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		coluna.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOCompartilhamentoInlineDaMateriaEstaSendoExibidoNoTopoDaMateria() throws InterruptedException{
		coluna.executarScroll(coluna.acessaClasseCorpoColuna().getLocation());
		coluna.esperaCarregar(2);
		assertTrue(coluna.exibiuCompartilhamento(coluna.acessaClasseCorpoColuna(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeOBotaoDeCurtirEstaSendoExibidoNoTopoDaMateria(){
		assertTrue(coluna.exibiuBotaoDelike(coluna.acessaClasseCorpoColuna(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOBotaoDeRecomendarEstaSendoExibidoNoTopoDaMateria(){
		assertTrue(coluna.exibiuBotaoDeRecomendar(coluna.acessaClasseCorpoColuna(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOBotaoDoTwitterEstaSendoExibidoNoTopoDaMateria(){
		assertTrue(coluna.exibiuBotaoDeTwitter(coluna.acessaClasseCorpoColuna(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeOBotaoDoGooglePlusEstaSendoExibidoNoTopoDaMateria(){
		assertTrue(coluna.exibiuBotaoDoGooglePlus(coluna.acessaClasseCorpoColuna(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeOsBotoesDeCompartilhamentoEstaoSendoExibidosNaOrdemCorretaNoTopoDaPagina(){
		assertTrue(coluna.exibiuOsBotoesDeCompartilhamentoNaOrdemCorrreta(coluna.acessaClasseCorpoColuna(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void verificaSeOCompartilhamentoInlineDaMateriaEstaSendoExibidoNoFinalDaMateria() throws InterruptedException{
		coluna.executaScrollParaAparecerOTituloDeUmaPosicao(coluna.acessaCompartilhamento(coluna.acessaCorpoDamateria(), 1));
		coluna.esperaCarregar(2);
		assertTrue(coluna.exibiuCompartilhamento(coluna.acessaCorpoDamateria(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeOBotaoDeCurtirEstaSendoExibidoNoFinalDaMateria(){
		assertTrue(coluna.exibiuBotaoDelike(coluna.acessaCorpoDamateria(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=19)
	@Test
	public void verificaSeOBotaoDeRecomendarEstaSendoExibidoNoFinalDaMateria(){
		assertTrue(coluna.exibiuBotaoDeRecomendar(coluna.acessaCorpoDamateria(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeOBotaoDoTwitterEstaSendoExibidoNoFinalDaMateria(){
		assertTrue(coluna.exibiuBotaoDeTwitter(coluna.acessaCorpoDamateria(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=21)
	@Test
	public void verificaSeOBotaoDoGooglePlusEstaSendoExibidoNoFinalDaMateria(){
		assertTrue(coluna.exibiuBotaoDoGooglePlus(coluna.acessaCorpoDamateria(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=22)
	@Test
	public void verificaSeOsBotoesDeCompartilhamentoEstaoSendoExibidosNaOrdemCorretaNoFinalDaPagina(){
		assertTrue(coluna.exibiuOsBotoesDeCompartilhamentoNaOrdemCorrreta(coluna.acessaCorpoDamateria(), 1));
	}
}