package testes.capa.meio;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.BoxDeVideos;


public class BoxVideosTest {
	
	private static BoxDeVideos colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new BoxDeVideos();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeVideosEstaSendoExibido(){
		assertTrue(colunaDoMeio.getBoxDeVideosEstaSendoExibido());
	}
	
	@Test
	public void verificaSeOTituloDoBoxDeVideosEstaSendoExibido(){
		assertTrue(colunaDoMeio.getTituloDoBoxDeVideos());
	}
	
	@Test
	public void verificaSeOLinkParaTodosOsVideosDoBoxDeVideosEstaSendoExibido(){
		assertTrue(colunaDoMeio.getLinkParaTodosOsVideosDoBoxDeVideosEstaSendoExibido());
	}
	
	@Test
	public void verificaSeOVideoEmDestaqueDoBoxDeVideosEstaSendoExibido(){
		assertTrue(colunaDoMeio.getVideoEmDestaqueDoBoxDeVideosEstaSendoExibido());
	}
	
	@Test
	public void verificaSeOAntitituloDoVideoEmDestaqueDoBoxDeVideosEstaSendoExibido(){
		assertTrue(colunaDoMeio.getAntitituloDoVideoEmDestaqueDoBoxDeVideosEstaSendoExibido());
	}
	
	@Test
	public void verificaSeOTituloDoVideoEmDestaqueDoBoxDeVideosEstaSendoExibido(){
		assertTrue(colunaDoMeio.getTituloDoVideoEmDestaqueDoBoxDeVideosEstaSendoExibido());
	}
	
	@Test
	public void verificaSeAAreaDeOutrosVideosDoBoxDeVideosEstaSendoExibida(){
		assertTrue(colunaDoMeio.getAreaDeOutrosVideosDoBoxDeVideosEstaSendoExibida());
	}
	
	@Test
	public void verificaSeAAreaDeOutrosVideosDoBoxDeVideosEstaExibindoQuatroVideos(){
		assertTrue(colunaDoMeio.getAreaDeOutrosVideosDoBoxDeVideosEstaExibindoQuatroVideos());
	}
	
	@Test
	public void verificaSeOPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink(){
		assertTrue(colunaDoMeio.getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink());
	}
	
	@Test
	public void verificaSeOPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem(){
		assertTrue(colunaDoMeio.getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem());
	}
	
	@Test
	public void verificaSeOPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo(){
		assertTrue(colunaDoMeio.getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo());
	}
		
	@Test
	public void verificaSeOPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo(){
		assertTrue(colunaDoMeio.getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo());
	}
	
	@Test
	public void verificaSeOSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink(){
		assertTrue(colunaDoMeio.getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink());
	}
	
	@Test
	public void verificaSeOSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem(){
		assertTrue(colunaDoMeio.getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem());
	}
	
	@Test
	public void verificaSeOSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo(){
		assertTrue(colunaDoMeio.getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo());
	}
		
	@Test
	public void verificaSeOSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo(){
		assertTrue(colunaDoMeio.getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo());
	}
	
	@Test
	public void verificaSeOTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink(){
		assertTrue(colunaDoMeio.getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink());
	}
	
	@Test
	public void verificaSeOTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem(){
		assertTrue(colunaDoMeio.getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem());
	}
	
	@Test
	public void verificaSeOTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo(){
		assertTrue(colunaDoMeio.getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo());
	}
		
	@Test
	public void verificaSeOTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo(){
		assertTrue(colunaDoMeio.getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo());
	}
	
	@Test
	public void verificaSeOQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink(){
		assertTrue(colunaDoMeio.getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink());
	}
	
	@Test
	public void verificaSeOQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem(){
		assertTrue(colunaDoMeio.getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem());
	}
	
	@Test
	public void verificaSeOQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo(){
		assertTrue(colunaDoMeio.getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo());
	}
		
	@Test
	public void verificaSeOQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo(){
		assertTrue(colunaDoMeio.getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo());
	}
}