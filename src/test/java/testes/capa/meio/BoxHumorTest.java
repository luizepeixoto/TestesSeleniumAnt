package testes.capa.meio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.BoxHumor;

import crops.CropsCapaColunaDoMeio;


public class BoxHumorTest {
	
	private static BoxHumor colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new BoxHumor();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeHumorEstaSendoExibido(){
		assertNotNull(colunaDoMeio.exibiuBoxDeHumor());
	}
	
	@Test
	public void verificaSeOTituloHumorEstaSendoExibido(){
		String resultadoEsperado="Humor";
		assertEquals(resultadoEsperado, colunaDoMeio.exibiuOTituloHumor());
	}
	
	@Test
	public void verificaSeOBoxDeHumorEstaExibindoUmaFotoComWidthCorreto(){
		assertTrue(colunaDoMeio.exibiuFoto());
	}
	
	@Test
	public void verificaSeOBoxDeHumorEstaExibindoUmaFotoComOCropCorreto(){
		assertTrue(colunaDoMeio.exibiuCropCorretoParaAFoto());
	}
	
	@Test
	public void verificaSeAFotoDoWidthEstaCorreta(){
		String widthEsperado = CropsCapaColunaDoMeio.boxHumor.getWidth();
		assertEquals(widthEsperado, colunaDoMeio.getWidthDaFoto());
	}
	
	@Test
	public void verificaSeAFotoDoHeightEstaCorreta(){
		String heightEsperado = CropsCapaColunaDoMeio.boxHumor.getHeight();
		assertEquals(heightEsperado, colunaDoMeio.getHeightDaFoto());
	}
	
	@Test
	public void verificaSeAFotoPossuiUmLink(){
		assertTrue(colunaDoMeio.exibiuLinkNaFoto());
	}
	
	@Test
	public void verificaSeOLinkDaFotoEhValido(){
		assertTrue(colunaDoMeio.exibiuLinkvalidoNaFoto());
	}
}