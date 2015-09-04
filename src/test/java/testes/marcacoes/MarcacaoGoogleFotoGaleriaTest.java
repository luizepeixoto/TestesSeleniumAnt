package testes.marcacoes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.marcacoes.MarcacaoGoogleFotoGaleria;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class MarcacaoGoogleFotoGaleriaTest {

	public static MarcacaoGoogleFotoGaleria marcacaoFotoGaleria;
	static String tipoEsperado;
	static String palavraChaveEsperada;
	static String linguagemEsperada;
	static String dataDePublicacaoEsperada;
	static String dataDeModificacaoEsperada;
	static String tituloEsperado;
	static String descricaoEsperada;
	static int quantidadeDeImagens;
	static ArrayList<String> imagens;
	static String donoDosDireitosAutoraisEsperado;
	static String nomeDoDonoDosDireitosAutoraisEsperado;
	static String urlDoDonoEsparado;
	static String tipoDoPublicadorEsparado;
	static String urlDoPublicadorEsperado;
	static String nomeDoPublicadorEsperado;
	static String logoDoPublicadorEsperado;

	@BeforeClass
	public static void berofe() throws Exception {

		marcacaoFotoGaleria = new MarcacaoGoogleFotoGaleria(Navegador.CHROME);

		tipoEsperado = marcacaoFotoGaleria.getTipoDeEsperado();
		palavraChaveEsperada = marcacaoFotoGaleria.getPalavraChaveEsperada();
		linguagemEsperada = marcacaoFotoGaleria.getLinguagemEsperada();
		dataDePublicacaoEsperada = marcacaoFotoGaleria.getDataDePublicacaoEsperada();
		dataDeModificacaoEsperada = marcacaoFotoGaleria.getDataDeModificacaoEsperada();
		tituloEsperado = marcacaoFotoGaleria.getTituloEsperado();
		descricaoEsperada = marcacaoFotoGaleria.getDescricaoEsperada();
		imagens = marcacaoFotoGaleria.getPrimeiraImagemEsperada();
		donoDosDireitosAutoraisEsperado = marcacaoFotoGaleria.getDonoEsperado();
		nomeDoDonoDosDireitosAutoraisEsperado = marcacaoFotoGaleria.getNomeDoDonoEsperado();
		urlDoDonoEsparado = marcacaoFotoGaleria.getUrlDoDonoEsperado();
		tipoDoPublicadorEsparado = marcacaoFotoGaleria.getTipoDoPublicadorEsperado();
		urlDoPublicadorEsperado = marcacaoFotoGaleria.getUrlDoPublicadorEsperado();
		nomeDoPublicadorEsperado = marcacaoFotoGaleria.getNomeDoPublicadorEsperado();
		logoDoPublicadorEsperado = marcacaoFotoGaleria.getLogoDoPublicadorEsperado();

		marcacaoFotoGaleria.irParaAplicacaoDeMarcacao();
	}

	@AfterClass
	public static void fecharBrowser() {
		marcacaoFotoGaleria.fechar();
	}

	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificarTipoDeMateria() {
		assertEquals(tipoEsperado, marcacaoFotoGaleria.getTipoAtual());
	}

	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificarPalavraChave() {
		assertEquals(palavraChaveEsperada, marcacaoFotoGaleria.getPalavraChaveAtual());
	}

	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificarLinguagemDoConteudo() {
		assertEquals(linguagemEsperada, marcacaoFotoGaleria.getLinguagemAtual());
	}

	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificarDonoDosDireitosAutorais() {
		assertEquals("Item 1", marcacaoFotoGaleria.getDonoAtual());
	}

	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificarPublicador() {
		assertEquals("Item 2", marcacaoFotoGaleria.getPublicadorAtual());
	}

	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificarDataDePublicacao() {
		assertEquals(dataDePublicacaoEsperada, marcacaoFotoGaleria.getDataDePublicacaoAtual());
	}

	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificarDataDeModificacao() {
		assertEquals(dataDeModificacaoEsperada, marcacaoFotoGaleria.getDataDeModificacaoAtual());
	}

	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificarTituloDaGaleria() {
		assertEquals(tituloEsperado, marcacaoFotoGaleria.getTituloAtual());
	}

	@OrdemExecucaoTeste(Ordem = 9)
	@Test
	public void verificarDescricaoDaMateria() {
		assertEquals(descricaoEsperada, marcacaoFotoGaleria.getDescricaoAtual());
	}

	@OrdemExecucaoTeste(Ordem = 10)
	@Test
	public void verificarImagens() {
		assertEquals(imagens, marcacaoFotoGaleria.getImagensAtuais());
	}

	@OrdemExecucaoTeste(Ordem = 11)
	@Test
	public void verificarSeHaMarcacaoParaDoDonoDosDireitosAutorais() {
		assertEquals("Item 1", marcacaoFotoGaleria.getItemDeMarcacao());
	}

	@OrdemExecucaoTeste(Ordem = 12)
	@Test
	public void verificarTipoDeMarcacaoDoDonoDosDireitosAutorais() {
		assertEquals(donoDosDireitosAutoraisEsperado, marcacaoFotoGaleria.getTipoDeMarcacao());
	}

	@OrdemExecucaoTeste(Ordem = 13)
	@Test
	public void verificarNomeDoDonoDosDireitosAutorais() {
		assertEquals(nomeDoDonoDosDireitosAutoraisEsperado, marcacaoFotoGaleria.getNomeDoDono());
	}

	@OrdemExecucaoTeste(Ordem = 14)
	@Test
	public void verificarUrlDoDonoDosDireitosAutorais() {
		assertEquals(urlDoDonoEsparado, marcacaoFotoGaleria.getUrlDoDonoAtual());
	}

	@OrdemExecucaoTeste(Ordem = 15)
	@Test
	public void verificarSeHaMarcacaoParaPublicador() {
		assertEquals("Item 2", marcacaoFotoGaleria.getPublicador());
	}

	@OrdemExecucaoTeste(Ordem = 16)
	@Test
	public void verificarTipoDoPublicador() {
		assertEquals(tipoDoPublicadorEsparado, marcacaoFotoGaleria.getTipoSegundoItem());
	}

	@OrdemExecucaoTeste(Ordem = 17)
	@Test
	public void verificarNomeDoPublicador() {
		assertEquals(nomeDoPublicadorEsperado, marcacaoFotoGaleria.getNomeDoPublicador());
	}

	@OrdemExecucaoTeste(Ordem = 18)
	@Test
	public void verificarUrlDoPublicador() {
		assertEquals(urlDoPublicadorEsperado, marcacaoFotoGaleria.getUrlDoPublicadorAtual());
	}

	@OrdemExecucaoTeste(Ordem = 19)
	@Test
	public void verificarLogoDoPublicador() {
		assertEquals(logoDoPublicadorEsperado, marcacaoFotoGaleria.getLogoAtual());
	}
}
