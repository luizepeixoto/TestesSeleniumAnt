package testes.temporeal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.temporeal.AbasPosJogo;

import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class AbaPosJogoFotogaleriaTest {
	
	/*Fotogaleria na aba de imagens com no mínimo 3 fotos*/
	
	private static AbasPosJogo tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new AbasPosJogo();
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void verificaSeAFotogaleriaEstaSendoExibidaNaPrimeiraTab(){
		assertNotNull(tempoReal.exibiuFotogaleria());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void verificaSeEstaSendoExibidaUmaListaDeFotos(){
		assertTrue(tempoReal.exibiuUmalistaDeFotosParaAFotogaleria());
	}
	
//	@Test
//	@OrdemExecucaoTeste(Ordem = 3)
//	public void verificaSeParaCadaFotoEstaSendoExibidaUmaLegenda(){
//		assertTrue(tempoReal.exibiuUmaLegendaParaCadaFoto());
//	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void verificaSeParaCadaFotoEstaSendoExibidoOBoxDeCompatilhamento(){
		assertTrue(tempoReal.exibiuUmBoxDeCompartilhamentoParaCadaFoto());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void verificaSeParaCadaFotoEstaSendoExibidoOCompatilhamentoDoFacebook(){
		assertTrue(tempoReal.exibiuOCompartilhamentoDoFacebookParaCadaFoto());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void verificaSeParaCadaFotoEstaSendoExibidoOCompatilhamentoDoTwitter(){
		assertTrue(tempoReal.exibiuOCompartilhamentoDoTwitterParaCadaFoto());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void verificaSeParaCadaFotoEstaSendoExibidoOCompatilhamentoDoGooglePlus(){
		assertTrue(tempoReal.exibiuOCompartilhamentoDoGooglePlusParaCadaFoto());
	}
}