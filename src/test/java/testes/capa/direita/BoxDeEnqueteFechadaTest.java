package testes.capa.direita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxDeEnqueteFechada;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxDeEnqueteFechadaTest {
	
	private static BoxDeEnqueteFechada colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxDeEnqueteFechada(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuAEnquete() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuAEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloEnquete(){
		assertEquals("Enquete", colunaDaDireita.exibiuTituloEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuPerguntaDaEnquete(){
		assertTrue(colunaDaDireita.exibiuPerguntaDaEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuOpcoesDaEnquete(){
		assertTrue(colunaDaDireita.exibiuOpcoesDaEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void verificaSeAsOpcoesDaEnqueteEstaoExibindoUmaFoto(){
		assertTrue(colunaDaDireita.exibiuOpcoesDaEnqueteComFoto());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void verificaSeAsOpcoesDaEnqueteEstaoExibindoUmTitulo(){
		assertTrue(colunaDaDireita.exibiuOpcoesDaEnqueteComTitulo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void verificaSeAsOpcoesDaEnqueteEstaoExibindoOTotalPercentualDeVotos(){
		assertTrue(colunaDaDireita.exibiuOpcoesDaEnqueteComOTotalPercentual());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void verificaSeAsOpcoesDaEnqueteEstaoExibindoABarraComPercentualDeVotos(){
		assertTrue(colunaDaDireita.exibiuOpcoesDaEnqueteComABarraPercentual());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void verificaSeOResultadoDoComOTotalDeVotosEstaSendoExibidoNoFimDoBx(){
		assertTrue(colunaDaDireita.exibiuOTituloComOTotalDeResultados());
	}
}
