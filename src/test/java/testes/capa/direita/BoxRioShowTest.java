package testes.capa.direita;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

import org.junit.runner.RunWith;

import pages.capa.direita.BoxRioShow;

@RunWith(OrdenadorTestes.class)
public class BoxRioShowTest {

	private static BoxRioShow colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxRioShow(Navegador.CHROME);
		colunaDaDireita.esperaCarregar3Segundos();
		colunaDaDireita.executaScrollParaAparecerOTituloDeUmaPosicao(colunaDaDireita.exibiuBoxDoRioShow());
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void verificaSeOBoxDoRioShowEstaSendoExibido(){
		assertNotNull(colunaDaDireita.exibiuBoxDoRioShow());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void verificaSeOBoxDoRioShowEstaExibindoAPaginacaoNoFimDoBox(){
		assertTrue(colunaDaDireita.exibiuBoxDeNavegacaoDosConteudos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void verificaSeANavegacaoDoBoxDoRioShowEstaExibindoAPaginacaoParaEsquerda(){
		assertTrue(colunaDaDireita.exibiuBoxDeNavegacaoParaAEsquerda());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void verificaSeANavegacaoDoBoxDoRioShowEstaExibindoAPaginacaoParaDireita(){
		assertTrue(colunaDaDireita.exibiuBoxDeNavegacaoParaADireita());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void verificaSeANavegacaoDoBoxDoRioShowEstaExibindoAlgumaPaginacaoDesabilitada(){
		assertTrue(colunaDaDireita.exibiuAlgumaDasPaginacoesComoDesabilitada());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void verificaSeOBoxDoRioShowEstaExibindoUmaListaDeConteudos(){
		assertTrue(colunaDaDireita.exibiuUmaListaDeConteudos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void verificaSeParaCadaUmDosConteudosEstaSendoExibidoUmTitulo() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuTituloParaCadaUmDosConteudos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void verificaSeParaCadaUmDosConteudosOTituloPossuiNoMaximo90Caracteres() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuTituloParaCadaUmDosConteudosComNoMaximo90Caracteres());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void verificaSeParaCadaUmDosConteudosEstaSendoExibidoUmaDescricao() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuDescricaoParaCadaUmDosConteudos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void verificaSeANavegacaoDoBoxEstaSendoExibidaAbaixoDoBox() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuBoxDeNavegacaoDosConteudos());
	}
}