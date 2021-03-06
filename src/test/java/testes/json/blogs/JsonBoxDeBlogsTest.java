package testes.json.blogs;

import static com.eclipsesource.restfuse.Assert.assertOk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

import pages.json.blogs.JsonBoxDeBlogs;

import br.com.infoglobo.pages.ConfiguracoesTeste;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.RequestContext;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@RunWith(HttpJUnitRunner.class)
public class JsonBoxDeBlogsTest {

	private static JsonBoxDeBlogs blogs;
	
	@Rule
	public Destination destination = getDestination();
	
	public Destination getDestination() {
		try {
			
			final ConfiguracoesTeste conf = new ConfiguracoesTeste();
			final String urlDestino = conf.getUrlAmbiente();
			final String caminho = blogs.getUrlPaginaAtual().replace(urlDestino, "");
			final Destination destino = new Destination(this, urlDestino);
			
			RequestContext context = destino.getRequestContext();
			context.addPathSegment( "caminho", caminho);
			
			return destino;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	 @BeforeClass
	 public static void antesDeCadaTeste() throws Exception {
		 blogs = new JsonBoxDeBlogs();
	 }
	
	 @AfterClass
	 public static void depoisDeCadaTeste() {
		 blogs.fechar();
	 }

	@Context
	private Response response; // will be injected after every request

	@HttpTest(method = Method.GET, path = "{caminho}")
	public void verificaSeOJsonDoBoxDeBlogsDoASPQuePreencheOGenteDoGloboEstaTrazendoConteudo() {
		
		assertEquals(200, response.getStatus());
		assertOk(response);
		assertTrue("Conteudo vazio na URL JSON: \n" + response.getUrl(), StringUtils.isNotEmpty(response.getBody()));
	}

}
