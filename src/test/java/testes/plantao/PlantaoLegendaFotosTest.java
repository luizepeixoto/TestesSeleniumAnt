package testes.plantao;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.plantao.PlantaoLegendaFotos;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class PlantaoLegendaFotosTest {
	
	private static PlantaoLegendaFotos paginaDePlantao;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		paginaDePlantao = new PlantaoLegendaFotos(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		paginaDePlantao.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeALegendaDaFotoDePrimeiraPosicaoPossuiAFonteArial() {
		assertTrue(paginaDePlantao.exibiuAFonteArialParaALegendaDaFotoDePrimeiraPosicao());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeALegendaDaFotoDePrimeiraPosicaoPossuiOTamanhoDe13px() {
		assertTrue(paginaDePlantao.exibiuOTamanhoDe13pxParaParaALegendaDaFotoDePrimeiraPosicao());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeALegendaDaFotoCentroGrandePossuiAFonteArial() {
		assertTrue(paginaDePlantao.exibiuAFonteArialParaALegendaDaFotoCentroGrande());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeALegendaDaFotoCentroGrandePossuiOTamanhoDe13px() {
		assertTrue(paginaDePlantao.exibiuOTamanhoDe13pxParaALegendaDaFotoCentroGrande());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaVerticalPossuiAFonteOGloboCondensed() throws InterruptedException {
		assertTrue(paginaDePlantao.exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaVertical());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaVerticalOTamanhoDe15px() throws InterruptedException {
		assertTrue(paginaDePlantao.exibiuOTamanhoDe13pxParaALegendaDaFotoEsquerdaVertical());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaGrandePossuiAFonteOGloboCondensed() throws InterruptedException {
		assertTrue(paginaDePlantao.exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaGrande());
	}
	
	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaGrandeOTamanhoDe15px() {
		assertTrue(paginaDePlantao.exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaGrande());
	}
	
	@OrdemExecucaoTeste(Ordem = 9)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaPequenaPossuiAFonteOGloboCondensed() throws InterruptedException {
		assertTrue(paginaDePlantao.exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaPequena());
	}
	
	@OrdemExecucaoTeste(Ordem = 10)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaPequenaOTamanhoDe15px() throws InterruptedException {
		assertTrue(paginaDePlantao.exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaPequena());
	}
}