package pages.marcacoes;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MarcacaoFacebook extends AceitacaoAbstractTest {

	public MarcacaoFacebook() throws Exception {
		super();
	}

	public MarcacaoFacebook(Navegador navegador) throws Exception {
		super(navegador);
	}

	public void irParaAplicacaoDeMarcacao() throws Exception {

		if (getAmbiente().equals("PRD")) {
			irParaAplicacaoDeMarcacaoComMateriaDePRD();

		}
		else {
			irParaAplicacaoDeComMateriaSTG();
		}
	}

	private void irParaAplicacaoDeComMateriaSTG() {
		String pagina = getDriver().getPageSource();
		String urlGoogleWebmaster = "https://www.google.com/webmasters/tools/richsnippets";
		getDriver().navigate().to(urlGoogleWebmaster);

		getDriver().findElement(By.xpath("//*[@id=\"tab-html\"]")).click();
		getDriver().findElement(By.xpath("//*[@id=\"html-input\"]")).clear();
		getDriver().findElement(By.xpath("//*[@id=\"html-input\"]")).sendKeys(pagina);
		getDriver().findElement(By.xpath("//*[@id=\"html-preview-button\"]/div")).click();
	}

	private void irParaAplicacaoDeMarcacaoComMateriaDePRD() {
		String urlASerVerificada = getDriver().getCurrentUrl();
		String urlGoogleWebmaster = "https://www.google.com/webmasters/tools/richsnippets";
		getDriver().navigate().to(urlGoogleWebmaster);
		getDriver().findElement(By.xpath("//*[@id=\"url-input\"]")).sendKeys(urlASerVerificada);
		getDriver().findElement(By.xpath("//*[@id=\"url-preview-button\"]/div")).click();
	}

	public String buscarMarcacao(String atributoDeXpath, String atributoDeComparacao) {
		return getDriver().findElement(By.xpath(atributoDeXpath)).getAttribute(atributoDeComparacao);
	}

	public String getTituloDaMateria() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getTipoDaMateria() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[3]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getDataDePublicacao() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getDataDeModificacao() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[5]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getSecao() {
		String secao = getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[7]/td/div/table/tbody/tr/td[2]")).getText();
		return secao;
	}

	public String getTag() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[8]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getImagem() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[9]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getUrl() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[10]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getDescricao() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[11]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getLinguagem() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[12]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String getNomeDoSite() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[2]/div[2]/table/tbody/tr[13]/td/div/table/tbody/tr/td[2]")).getText();
	}

	public String obterConteudo(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}

	public String getTituloDaMateriaEsperado() {
		return buscarMarcacao("//*[@property='og:title']", "content");
	}

	public String getTipoDaMateriaEsperado() {
		return buscarMarcacao("//*[@property='og:type']", "content");
	}

	public String getDataDePublicacaoEsperada() {
		return buscarMarcacao("//*[@property='article:published_time']", "content");
	}

	public String getDataDeModificacaoEsperada() {
		return buscarMarcacao("//*[@property='article:modified_time']", "content");
	}

	public String getPublicadorEsperado() {
		return buscarMarcacao("//*[@property='article:publisher']", "content");
	}

	public String getSecaoEsperada() {
		return buscarMarcacao("//*[@property='article:section']", "content");
	}

	public String getTagEsperada() {
		return buscarMarcacao("//*[@property='article:tag']", "content").trim();
	}

	public String getImagemEsperada() {
		return buscarMarcacao("//*[@property='og:image']", "content");
	}

	public String getUrlEsperrada() {
		return buscarMarcacao("//*[@property='og:url']", "content");
	}

	public String getDescricaoEsperada() {
		return buscarMarcacao("//*[@property='og:description']", "content");
	}

	public String getLinguagemEsperada() {
		return buscarMarcacao("//*[@property='og:locale']", "content");
	}

	public String getNomeDoSiteEsperado() {
		return buscarMarcacao("//*[@property='og:site_name']", "content");
	}

}
