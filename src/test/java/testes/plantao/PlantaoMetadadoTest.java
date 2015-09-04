package testes.plantao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.plantao.Plantao;


public class PlantaoMetadadoTest {
	
	private static Plantao plantao;
	private String contextoPagina = plantao.exibiuCodigoFonteDaPagina(); 
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		plantao = new Plantao();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		plantao.fechar();
	}
	
	@Test
	public void verificaSeAMetatagCanonicalEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<link rel=\"canonical\""));
	}
	
	@Test
	public void verificaSeAMetatagOGTitleEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"og:title\""));
	}
	
	@Test
	public void verificaSeAMetatagOGTypeEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"og:type\" content=\"article\""));
	}
	
	@Test
	public void verificaSeAMetatagPublishedTimeEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"article:published_time\""));
	}
	
	@Test
	public void verificaSeAMetatagModifiedTimeEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"article:modified_time\""));
	}
	
	@Test
	public void verificaSeAMetatagSectionEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"article:section\""));
	}
	
	@Test
	public void verificaSeAMetatagArticleTagEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"article:tag\""));
	}
	
	@Test
	public void verificaSeAMetatagOGImageEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"og:image\""));
	}
	
	@Test
	public void verificaSeAMetatagOGUrlEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"og:url\""));
	}
	
	@Test
	public void verificaSeAMetatagOGLocaleEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"og:locale\" content=\"pt_BR\""));
	}
	
	@Test
	public void verificaSeAMetatagOGSiteNameEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("property=\"og:site_name\" content=\"O Globo\""));
	}
	
	@Test
	public void verificaSeAMetatagGoogleBotEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("name=\"googlebot-news\" content=\"noindex\""));
	}
	
	@Test
	public void verificaSeAMetatagTwitterWidgetCSPEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<meta name=\"twitter:widgets:csp\" content=\"on\"/>"));
	}
	
	@Test
	public void verificaSeAMetatagTwitterCardEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<meta name=\"twitter:card\" content=\"summary_large_image\"/>"));
	}
	
	@Test
	public void verificaSeAMetatagTwitterSiteEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<meta name=\"twitter:site\" content=\"@JornalOGlobo\"/>"));
	}
	
	@Test
	public void verificaSeAMetatagTwitterTitleEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<meta name=\"twitter:title\""));
	}
	
	@Test
	public void verificaSeAMetatagTwitterDescriptionEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<meta name=\"twitter:description\""));
	}
	
	@Test
	public void verificaSeAMetatagTwitterImageEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<meta name=\"twitter:image\" "));
	}
	
	@Test
	public void verificaSeAMetatagLinkRelativeRSSEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<link rel=\"alternate\" type=\"application/rss+xml\""));
	}
	
	@Test
	public void verificaSeAMetatagRelativeEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<link rel=\"alternate\" media=\"only screen and (max-width: 640px)\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropItemTypeEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemtype=\"http://schema.org/NewsArticle\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropKeywordEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"keywords\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropInLanguageEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"inLanguage\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropCopyrightHolderEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"copyrightHolder\" itemtype=\"http://schema.org/Organization\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropNameDaAgenciaOGloboEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"name\" content=\"Agência O Globo\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropURLDaAgenciaOGloboEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"url\" content=\"http://www.agenciaoglobo.com.br\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropPublisherEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"publisher\" itemtype=\"http://schema.org/Organization\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropNameDaOGloboEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"name\" content=\"OGlobo\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropLogoEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"logo\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropDatePublishedEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"datePublished\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropDateModifiedEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"dateModified\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropHeadlineEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("<h1 itemprop=\"headline\">"));
	}
	
	@Test
	public void verificaSeAMetatagItempropAuthorEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"author\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropImageEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"image\""));
	}
	
	@Test
	public void verificaSeAMetatagItempropArticleBodyEstaSendoCarregadoNoCodigoDaPagina(){
		assertTrue(contextoPagina.contains("itemprop=\"articleBody\""));
	}
}