package testes.revenue;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.revenue.MarcacoesCapaDestaque3Colunas;


public class MarcacoesEditoriaComDestaqueHorizontal3ColunasTest {
	
	private static MarcacoesCapaDestaque3Colunas capa;
	private String codigoFonte = capa.exibiuCodigoFonteDaPagina(); 
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new MarcacoesCapaDestaque3Colunas();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	//Capa apenas com as colunas esquerda, centro, direita, destaque de 2 colunas e destaque de 3 colunas
	
	@Test
	public void exibiuTagDataVrZoneManchete3ColsNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("data-vr-zone=\"Manchete-3cols\""));
	}
	
	@Test
	public void exibiuTagDataVrZoneEsquerdaBNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("data-vr-zone=\"Esquerda-c\""));
	}
	
	@Test
	public void exibiuTagDataVrZoneCentroBNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("data-vr-zone=\"Centro-c\""));
	}
	
	@Test
	public void exibiuTagDataVrZoneDireitaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("data-vr-zone=\"Direita-b\""));
	}
}