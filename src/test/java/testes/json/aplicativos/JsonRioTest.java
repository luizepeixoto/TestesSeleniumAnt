package testes.json.aplicativos;

import static com.eclipsesource.restfuse.Assert.assertOk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

import pages.json.aplicativos.JsonRio;

import br.com.infoglobo.pages.ConfiguracoesTeste;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.RequestContext;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@RunWith(HttpJUnitRunner.class)
public class JsonRioTest {

	private static JsonRio rio;
	
	@Rule
	public Destination destination = getDestination();
	
	public Destination getDestination() {
		try {
			
			final ConfiguracoesTeste conf = new ConfiguracoesTeste();
			final String urlDestino = conf.getUrlAmbiente();
			final Destination destino = new Destination(this, urlDestino+"{caminho}");
			
			RequestContext context = destino.getRequestContext();
			context.addPathSegment( "caminho", rio.getUrlPaginaAtual().replace(urlDestino, ""));
			
			return destino;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	 @BeforeClass
	 public static void antesDeCadaTeste() throws Exception {
		 rio = new JsonRio();
	 }
	
	 @AfterClass
	 public static void depoisDeCadaTeste() {
		 rio.fechar();
	 }

	@Context
	private Response response; // will be injected after every request

	@HttpTest(method = Method.GET, path = "/")
	public void verificaSeOJsonDaPaginaDoRioQuePreencheOsAplicativosEstaTrazendoConteudo() {
		assertEquals(200, response.getStatus());
		assertOk(response);
		assertTrue("Conteudo vazio na URL JSON: \n" + response.getUrl(), StringUtils.isNotEmpty(response.getBody()));
	}
}
