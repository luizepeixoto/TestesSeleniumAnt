package testes.json.aplicativos;

import static com.eclipsesource.restfuse.Assert.assertOk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

import pages.json.aplicativos.JsonPais;

import br.com.infoglobo.pages.ConfiguracoesTeste;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.RequestContext;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@RunWith(HttpJUnitRunner.class)
public class JsonPaisTest {

	private static JsonPais pais;
	
	@Rule
	public Destination destination = getDestination();
	
	public Destination getDestination() {
		try {
			
			final ConfiguracoesTeste conf = new ConfiguracoesTeste();
			final String urlDestino = conf.getUrlAmbiente();
			final Destination destino = new Destination(this, urlDestino+"{caminho}");
			
			RequestContext context = destino.getRequestContext();
			context.addPathSegment( "caminho", pais.getUrlPaginaAtual().replace(urlDestino, ""));
			
			return destino;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	 @BeforeClass
	 public static void antesDeCadaTeste() throws Exception {
		 pais = new JsonPais();
	 }
	
	 @AfterClass
	 public static void depoisDeCadaTeste() {
		 pais.fechar();
	 }

	@Context
	private Response response; // will be injected after every request

	@HttpTest(method = Method.GET, path = "/")
	public void verificaSeOJsonDaPaginaDePaisQuePreencheOsAplicativosEstaTrazendoConteudo() {
		assertEquals(200, response.getStatus());
		assertOk(response);
		assertTrue("Conteudo vazio na URL JSON: \n" + response.getUrl(), StringUtils.isNotEmpty(response.getBody()));
	}
}
