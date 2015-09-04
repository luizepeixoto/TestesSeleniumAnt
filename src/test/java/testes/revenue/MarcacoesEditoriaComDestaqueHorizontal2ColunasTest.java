package testes.revenue;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.revenue.MarcacoesCapaDestaque2Colunas;


public class MarcacoesEditoriaComDestaqueHorizontal2ColunasTest {
	
	private static MarcacoesCapaDestaque2Colunas capa;
	private String codigoFonte = capa.exibiuCodigoFonteDaPagina(); 
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new MarcacoesCapaDestaque2Colunas();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	//Capa apenas com as colunas esquerda, centro, direita e destaque de 2 colunas
	
	@Test
	public void exibiuTagDataVrZoneManchete2ColsNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("data-vr-zone=\"Manchete-2cols"));
	}
	
	@Test
	public void exibiuTagDataVrZoneEsquerdaBNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("data-vr-zone=\"Esquerda-b\""));
	}
	
	@Test
	public void exibiuTagDataVrZoneCentroBNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("data-vr-zone=\"Centro-b\""));
	}
	
	@Test
	public void exibiuTagDataVrZoneDireitaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("data-vr-zone=\"Direita\""));
	}
}