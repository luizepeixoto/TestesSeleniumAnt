package testes.compartilhamento;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.capitulo.MenuLateralSemAutor;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class CompartilhamentoInlineMateriaCapituloMenuLateralTest {
	
	private static MenuLateralSemAutor materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuLateralSemAutor(Navegador.CHROME);
		materia.esperaCarregar(3);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOCompartilhamentoInlineDaMateriaEstaSendoExibidoNoTopoDaMateria(){
		materia.executarScroll(materia.acessaClasseHeadMateria().getLocation());
		assertTrue(materia.exibiuCompartilhamento(materia.acessaClasseMateriaEmCapitulo(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOBotaoDeCurtirEstaSendoExibidoNoTopoDaMateria(){
		assertTrue(materia.exibiuBotaoDelike(materia.acessaClasseMateriaEmCapitulo(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOBotaoDeRecomendarEstaSendoExibidoNoTopoDaMateria(){
		assertTrue(materia.exibiuBotaoDeRecomendar(materia.acessaClasseMateriaEmCapitulo(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeOBotaoDoTwitterEstaSendoExibidoNoTopoDaMateria(){
		assertTrue(materia.exibiuBotaoDeTwitter(materia.acessaClasseMateriaEmCapitulo(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeOBotaoDoGooglePlusEstaSendoExibidoNoTopoDaMateria(){
		assertTrue(materia.exibiuBotaoDoGooglePlus(materia.acessaClasseMateriaEmCapitulo(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeOsBotoesDeCompartilhamentoEstaoSendoExibidosNaOrdemCorretaNoTopoDaPagina(){
		assertTrue(materia.exibiuOsBotoesDeCompartilhamentoNaOrdemCorrreta(materia.acessaClasseMateriaEmCapitulo(), 0));
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeOCompartilhamentoInlineDaMateriaEstaSendoExibidoNoFinalDaMateria() throws InterruptedException{
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.acessaCompartilhamento(materia.acessaClasseMateriaEmCapitulo(), 1));
		materia.esperaCarregar(2);
		assertTrue(materia.exibiuCompartilhamento(materia.acessaClasseMateriaEmCapitulo(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeOBotaoDeCurtirEstaSendoExibidoNoFinalDaMateria(){
		assertTrue(materia.exibiuBotaoDelike(materia.acessaClasseMateriaEmCapitulo(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeOBotaoDeRecomendarEstaSendoExibidoNoFinalDaMateria(){
		assertTrue(materia.exibiuBotaoDeRecomendar(materia.acessaClasseMateriaEmCapitulo(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOBotaoDoTwitterEstaSendoExibidoNoFinalDaMateria(){
		assertTrue(materia.exibiuBotaoDeTwitter(materia.acessaClasseMateriaEmCapitulo(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeOBotaoDoGooglePlusEstaSendoExibidoNoFinalDaMateria(){
		assertTrue(materia.exibiuBotaoDoGooglePlus(materia.acessaClasseMateriaEmCapitulo(), 1));
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOsBotoesDeCompartilhamentoEstaoSendoExibidosNaOrdemCorretaNoFinalDaPagina(){
		assertTrue(materia.exibiuOsBotoesDeCompartilhamentoNaOrdemCorrreta(materia.acessaClasseMateriaEmCapitulo(), 1));
	}
}