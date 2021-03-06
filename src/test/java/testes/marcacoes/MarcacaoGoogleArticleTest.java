package testes.marcacoes;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.marcacoes.MarcacaoGoogleArticle;

import br.com.infoglobo.pages.Navegador;

public class MarcacaoGoogleArticleTest {

	static MarcacaoGoogleArticle marcacaoGoogleArticle;

	static String tipoEsperado;
	static String palavraChaveEsperada;
	static String linguagemEsperada;
	static String dataDePublicacaoEsperada;
	static String dataDeModificacaoEsperada;
	static String tituloEsperado;
	static String descricaoEsperada;
	static int tamanhoDoArticlebody;
	static String imagemEsperada;
	static String donoDosDireitosAutoraisEsperado;
	static String nomeDoDonoDosDireitosAutoraisEsperado;
	static String urlDoDonoEsparado;
	static String tipoDoPublicadorEsperado;
	static String urlDoPublicadorEsperado;
	static String nomeDoPublicadorEsperado;
	static String logoDoPublicadorEsperado;
	static String autorEsperado;
	static String articlebodyEsperado;

	@BeforeClass
	public static void berofe() throws Exception {
		marcacaoGoogleArticle = new MarcacaoGoogleArticle(Navegador.CHROME);

		tipoEsperado = marcacaoGoogleArticle.getTipoEsperado();
		palavraChaveEsperada = marcacaoGoogleArticle.getPalavraChaveEsperada();
		linguagemEsperada = marcacaoGoogleArticle.getLinguagemEsperada();
		dataDePublicacaoEsperada = marcacaoGoogleArticle.getDataDePublicacaoEsperada();
		dataDeModificacaoEsperada = marcacaoGoogleArticle.getDataDeModificacaoEsperada();
		tituloEsperado = marcacaoGoogleArticle.getTituloEsperado();
		descricaoEsperada = marcacaoGoogleArticle.getDescricaoEsperada();
		imagemEsperada = marcacaoGoogleArticle.getImagemEsperada();
		donoDosDireitosAutoraisEsperado = marcacaoGoogleArticle.getDonoEsperado();
		nomeDoDonoDosDireitosAutoraisEsperado = marcacaoGoogleArticle.getNomeDoDonoEsperado();
		urlDoDonoEsparado = marcacaoGoogleArticle.getUrlDoDonoEsperado();
		tipoDoPublicadorEsperado = marcacaoGoogleArticle.getTipoDoPublicadorEsperado();
		urlDoPublicadorEsperado = marcacaoGoogleArticle.getUrlDoPublicadorEsperado();
		nomeDoPublicadorEsperado = marcacaoGoogleArticle.getNomeDoPublicadorEsperado();
		logoDoPublicadorEsperado = marcacaoGoogleArticle.getLogoDoPublicadorEsperado();
		autorEsperado = marcacaoGoogleArticle.getAutorEsperado();
		articlebodyEsperado = marcacaoGoogleArticle.getArticlebodyEsperado();

		marcacaoGoogleArticle.irParaAplicacaoDeMarcacao();

		tamanhoDoArticlebody = marcacaoGoogleArticle.getTamanhoDoArticlebody();
	}

	@AfterClass
	public static void fecharBrowser() {
		marcacaoGoogleArticle.fechar();
	}

	@Test
	public void verificarSeHaMarcacaoDoGoogleNaPagina() {
		assertEquals("Item ", marcacaoGoogleArticle.getMarcacao());
	}

	@Test
	public void verificarTipoDoObjeto() {
		assertEquals(tipoEsperado, marcacaoGoogleArticle.getTipoAtual());
	}

	@Test
	public void verificarPropriedade() {
		assertEquals("property:", marcacaoGoogleArticle.getPropriedade());
	}

	@Test
	public void verificarPalavraChave() {
		assertEquals(palavraChaveEsperada, marcacaoGoogleArticle.getPalavraChave());
	}

	@Test
	public void verificarLinguagemDoConteudo() {
		assertEquals(linguagemEsperada, marcacaoGoogleArticle.getLinguagem());
	}

	@Test
	public void verificarDetentorDosDireitosAutorais() {
		assertEquals("Item 1", marcacaoGoogleArticle.getDetentor());
	}

	@Test
	public void verificarPublicador() {
		assertEquals("Item 2", marcacaoGoogleArticle.getPublicador());
	}

	@Test
	public void verificarDataDePublicacao() {
		assertEquals(dataDePublicacaoEsperada, marcacaoGoogleArticle.getDataDePublicacao());
	}

	@Test
	public void verificarDataDeModificacao() {
		assertEquals(dataDeModificacaoEsperada, marcacaoGoogleArticle.getDataDeModificacao());
	}

	@Test
	public void verificarTituloDaMateria() {
		assertEquals(tituloEsperado, marcacaoGoogleArticle.getTitulo());
	}

	@Test
	public void verificarDescricaoDaMateria() {
		assertEquals(descricaoEsperada, marcacaoGoogleArticle.getDescricao());
	}

	@Test
	public void verificarAutor() {
		assertEquals(autorEsperado, marcacaoGoogleArticle.getAutor());
	}

	@Test
	public void verificarImagem() {
		assertEquals(imagemEsperada, marcacaoGoogleArticle.getImagem());
	}

	@Test
	public void verificarArticlebody() {
		assertEquals(articlebodyEsperado, marcacaoGoogleArticle.getArticlebody());
	}

	@Test
	public void verificarSeExistePrimeiroItem() {
		assertEquals("Item 1", marcacaoGoogleArticle.getPrimeiroItem());
	}

	@Test
	public void verificarTipoDeMarcacaoDoDonoDosDireitosAutorais() {
		assertEquals(donoDosDireitosAutoraisEsperado, marcacaoGoogleArticle.getTipoDoItem());
	}

	@Test
	public void verificarNomeDoDono() {
		assertEquals(nomeDoDonoDosDireitosAutoraisEsperado, marcacaoGoogleArticle.getNomeDoDonoDosDireitosAutorais());
	}

	@Test
	public void verificarUrlDoDonoDosDireitosAutorais() {
		assertEquals(urlDoDonoEsparado, marcacaoGoogleArticle.getUrlDoDonoDosDireitosAutorais());
	}

	@Test
	public void verificarSeExisteSegundoItem() {
		assertEquals("Item 2", marcacaoGoogleArticle.getSegundoItem());
	}

	@Test
	public void verificarTipoDoTipoDeMarcacaoDoPublicador() {
		assertEquals(tipoDoPublicadorEsperado, marcacaoGoogleArticle.getTipoDeMarcacaoDoPublicador());
	}

	@Test
	public void verificarNomeDoPublicador() {
		assertEquals(nomeDoPublicadorEsperado, marcacaoGoogleArticle.getNomeDoPublicador());
	}

	@Test
	public void verificarUrlDoPublicador() {
		assertEquals(urlDoPublicadorEsperado, marcacaoGoogleArticle.getUrlDoPublicador());
	}

	@Test
	public void verificarLogoDoPublicador() {
		assertEquals(logoDoPublicadorEsperado, marcacaoGoogleArticle.getLogoDoPublicador());
	}
}
