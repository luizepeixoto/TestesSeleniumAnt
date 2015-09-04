package testes.marcacoes;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.marcacoes.MarcacaoFacebook;

import br.com.infoglobo.pages.Navegador;

public class MarcacaoFacebookTest {

	static MarcacaoFacebook marcacaoFacebook;

	static String tituloDaMateriaEsperado;
	static String tipoDaMateriaEsperado;
	static String secaoEsperada;
	static String linguagemEsperada;
	static String dataDePublicacaoEsperada;
	static String dataDeModificacaoEsperada;
	static String tagEsperada;
	static String descricaoEsperada;
	static int quantidadeDeImagens;
	static String imagemEsperada;
	static String urlEsperada;
	static String nomeDoSiteEsperado;

	@BeforeClass
	public static void berofe() throws Exception {
		marcacaoFacebook = new MarcacaoFacebook(Navegador.CHROME);
		tituloDaMateriaEsperado = marcacaoFacebook.getTituloDaMateriaEsperado();
		tipoDaMateriaEsperado = marcacaoFacebook.getTipoDaMateriaEsperado();
		secaoEsperada = marcacaoFacebook.getSecaoEsperada();
		linguagemEsperada = marcacaoFacebook.getLinguagemEsperada();
		dataDePublicacaoEsperada = marcacaoFacebook.getDataDePublicacaoEsperada();
		dataDeModificacaoEsperada = marcacaoFacebook.getDataDeModificacaoEsperada();
		tagEsperada = marcacaoFacebook.getTagEsperada();
		descricaoEsperada = marcacaoFacebook.getDescricaoEsperada();
		imagemEsperada = marcacaoFacebook.getImagemEsperada();
		urlEsperada = marcacaoFacebook.getUrlEsperrada();
		nomeDoSiteEsperado = marcacaoFacebook.getNomeDoSiteEsperado();

		marcacaoFacebook.irParaAplicacaoDeMarcacao();
	}

	@AfterClass
	public static void fecharBrowser() {
		marcacaoFacebook.fechar();
	}

	@Test
	public void verificarTituloDaMateria() {
		assertEquals(tituloDaMateriaEsperado, marcacaoFacebook.getTituloDaMateria());
	}

	@Test
	public void verificarTipoDaMateria() {
		assertEquals(tipoDaMateriaEsperado, marcacaoFacebook.getTipoDaMateria());
	}

	@Test
	public void verificarDataDePublicacao() {
		assertEquals(dataDePublicacaoEsperada, marcacaoFacebook.getDataDePublicacao());
	}

	@Test
	public void verificarDataDeModificacao() {
		assertEquals(dataDeModificacaoEsperada, marcacaoFacebook.getDataDeModificacao());
	}

	@Test
	public void verificarSecao() {
		assertEquals(secaoEsperada, marcacaoFacebook.getSecao());
	}

	@Test
	public void verificarTag() {
		assertEquals(tagEsperada, marcacaoFacebook.getTag());
	}

	@Test
	public void verificarImagem() {
		assertEquals(imagemEsperada, marcacaoFacebook.getImagem());
	}

	@Test
	public void verificarUrl() {
		assertEquals(urlEsperada, marcacaoFacebook.getUrl());
	}

	@Test
	public void verificarDescricao() {
		assertEquals(descricaoEsperada, marcacaoFacebook.getDescricao());
	}

	@Test
	public void verificarLinguagemDoConteudo() {
		assertEquals(linguagemEsperada, marcacaoFacebook.getLinguagem());
	}

	@Test
	public void verificarNomeDoSite() {
		assertEquals(nomeDoSiteEsperado, marcacaoFacebook.getNomeDoSite());
	}

}
