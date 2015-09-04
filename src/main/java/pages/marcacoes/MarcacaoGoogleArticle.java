package pages.marcacoes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MarcacaoGoogleArticle extends AceitacaoAbstractTest {

	public MarcacaoGoogleArticle() throws Exception {
		super();
	}

	public MarcacaoGoogleArticle(Navegador navegador) throws Exception {
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

	public void irParaAplicacaoDeMarcacaoComMateriaDePRD() {
		String urlASerVerificada = getDriver().getCurrentUrl();
		String urlGoogleWebmaster = "https://www.google.com/webmasters/tools/richsnippets";
		getDriver().navigate().to(urlGoogleWebmaster);
		getDriver().findElement(By.xpath("//*[@id=\"url-input\"]")).sendKeys(urlASerVerificada);
		getDriver().findElement(By.xpath("//*[@id=\"url-preview-button\"]/div")).click();
	}
	

	public String obterConteudo(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}

	public String buscarMarcacoes(String atributoDeXpath, String atributoDeComparacao) {
		return getDriver().findElement(By.xpath(atributoDeXpath)).getAttribute(atributoDeComparacao);
	}

	public String getMarcacao() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/div")).getText();
	}

	public String getTipoAtual() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[1]/td[2]")).getText();
	}

	public String getPropriedade() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[2]/td[1]")).getText();
	}

	public String getPalavraChave() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]")).getText();
	}

	public String getLinguagem() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]")).getText();
	}

	public String getDetentor() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/div")).getText();
	}

	public String getPublicador() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/div")).getText();
	}

	public String getDataDePublicacao() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]")).getText();
	}

	public String getDataDeModificacao() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[6]/td[2]")).getText();
	}

	public String getTitulo() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[7]/td[2]")).getText();
	}

	public String getDescricao() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[8]/td[2]")).getText();
	}

	public String getAutor() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[9]/td[2]")).getText().toLowerCase();
	}

	public String getImagem() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[10]/td[2]")).getText();
	}

	public String getArticlebody() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[11]/td[2]")).getText().substring(0, 100);
	}

	public String getPrimeiroItem() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[4]/div/div")).getText();
	}

	public String getTipoDoItem() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[4]/div/table/tbody/tr[1]/td[2]")).getText();
	}

	public String getNomeDoDonoDosDireitosAutorais() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[4]/div/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]")).getText();
	}

	public String getUrlDoDonoDosDireitosAutorais() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[4]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]")).getText();
	}

	public String getSegundoItem() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[5]/div/div")).getText();
	}

	public String getTipoDeMarcacaoDoPublicador() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[5]/div/table/tbody/tr[1]/td[2]")).getText();
	}

	public String getNomeDoPublicador() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[5]/div/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]")).getText();
	}

	public String getUrlDoPublicador() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[5]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/a")).getText();
	}

	public String getLogoDoPublicador() {
		return getDriver().findElement(By.xpath("//*[@id=\"extracted-data-google\"]/div[5]/div/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]")).getText();
	}

	public String getTipoEsperado() {
		return buscarMarcacoes("//*[@itemtype='http://schema.org/NewsArticle']", "itemtype").toLowerCase();
	}

	public String getPalavraChaveEsperada() {
		return buscarMarcacoes("//*[@itemprop='keywords']", "content").trim();
	}

	public String getLinguagemEsperada() {
		return buscarMarcacoes("//*[@itemprop='inLanguage']", "content");
	}

	public String getDataDePublicacaoEsperada() {
		return buscarMarcacoes("//*[@itemprop='datePublished']", "content");
	}

	public String getDataDeModificacaoEsperada() {
		return buscarMarcacoes("//*[@itemprop='dateModified']", "content");
	}

	public String getTituloEsperado() {
		return getDriver().findElement(By.xpath("//*[@itemprop='headline']")).getText();
	}

	public String getDescricaoEsperada() {
		return getDriver().findElement(By.xpath("//*[@itemprop='description']")).getText();
	}

	public String getImagemEsperada() {
		return buscarMarcacoes("//*[@itemprop='image']", "src");
	}

	public ArrayList<String> getImagens() {
		List<WebElement> valor;
		valor = getDriver().findElements(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[count(td[contains(text(), 'image:')])=1]/td[2]"));
		ArrayList<String> lista = new ArrayList<String>();

		for (WebElement l : valor) {
			lista.add(l.getText());
		}
		return lista;
	}

	public String getDonoEsperado() {
		return buscarMarcacoes("//*[@itemprop='copyrightHolder']", "itemtype").toLowerCase();
	}

	public String getNomeDoDonoEsperado() {
		return buscarMarcacoes("//*[@itemprop='name']", "content");
	}

	public String getUrlDoDonoEsperado() {
		return buscarMarcacoes("//*[@itemprop='url']", "content");
	}

	public String getTipoDoPublicadorEsperado() {
		return buscarMarcacoes("//*[@itemprop='publisher']", "itemtype").toLowerCase();
	}

	public String getUrlDoPublicadorEsperado() {
		return obterConteudo("//*[@id=\"sticker\"]/div/div/div/div/div/div[2]/a");
	}

	public String getNomeDoPublicadorEsperado() {
		List<WebElement> valor = getDriver().findElements(By.xpath("//*[@itemprop='name']"));
		ArrayList<String> lista = new ArrayList<String>();
		for (WebElement l : valor) {
			lista.add(l.getAttribute("content"));
		}
		return lista.get(1);
	}

	public String getLogoDoPublicadorEsperado() {
		return buscarMarcacoes("//*[@itemprop='logo']", "src");
	}

	public String getAutorEsperado() {
		return getDriver().findElement(By.xpath("//*[@itemprop='author']")).getText().toLowerCase();
	}

	public int getTamanhoDoArticlebody() {
		return obterConteudo("//tr[td[contains(.,'articlebody:')]]/td[2]").length() - 2;
	}

	public String getArticlebodyEsperado() {
		return obterConteudo("//*[@itemprop='articleBody']/p").substring(0, 100);
	}

}
