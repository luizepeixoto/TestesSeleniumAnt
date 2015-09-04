package testes.ela.editoria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.ela.editoria.DestaquesElaLista;

import br.com.infoglobo.pages.Navegador;

public class DestaqueElaComListaTest {
	
	private static DestaquesElaLista ultimas;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ultimas = new DestaquesElaLista(Navegador.CHROME);
		ultimas.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		ultimas.executaScrollParaAparecerOTituloDeUmaPosicao(ultimas.acessaLista());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ultimas.fechar();
	}
	
	@Test
	public void exibiuChamadaDeListas(){
		assertTrue(ultimas.acessaChamadaDeLista());
	}
	
	@Test
	public void exibiuOTituloDeListas(){
		assertTrue(ultimas.exibiuTituloDeListas());
	}
	
	@Test
	public void exibiuONumeroDaLista(){
		assertTrue(ultimas.exibiuONumeroDaLista());
	}
	
	@Test
	public void exibiuOTituloDaLista(){
		assertTrue(ultimas.exibiuOTituloDaLista());
	}
	
	@Test
	public void exibiuOTituloDaListaComNoMaximo57Caracteres(){
		assertTrue(ultimas.exibiuOTituloComNoMaximo57Caracteres());
	}
	
	@Test
	public void exibiuLinkNoNumeroENoTituloLista(){
		assertTrue("Não exibiu o link para o número da Lista", ultimas.exibiuLinkNaLista());
		assertTrue("Não exibiu o link para o título", ultimas.exibiuLinkNoTitulo());
	}
	
	@Test
	public void exibiuLinkValido(){
		assertTrue(ultimas.exibiuLinkValido());
	}
	
	@Test
	public void exibiuDescricaoDaLista(){
		assertTrue(ultimas.exibiuADescricaoDaLista());
	}
	
	@Test
	public void exibiuADesricaoDaListaComNoMaximo83Caracteres(){
		assertTrue(ultimas.exibiuADescricaoComNoMaximo83Caracteres());
	}
}