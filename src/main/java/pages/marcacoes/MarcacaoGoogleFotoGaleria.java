package pages.marcacoes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MarcacaoGoogleFotoGaleria extends AceitacaoAbstractTest {

	WebElement element;

	public MarcacaoGoogleFotoGaleria() throws Exception {
		super();
	}

	public MarcacaoGoogleFotoGaleria(Navegador navegador) throws Exception {
		super(navegador);
	}

	public void irParaAplicacaoDeMarcacao() throws Exception {

		if (getAmbiente().equals("PRD")) {
			irParaAplicacaoDeMarcacaoComMateriaDePRD();

		}
		else {

			String pagina = getDriver().getPageSource();
			String urlGoogleWebmaster = "https://www.google.com/webmasters/tools/richsnippets";
			getDriver().navigate().to(urlGoogleWebmaster);

			getDriver().findElement(By.xpath("//*[@id=\"tab-html\"]")).click();
			getDriver().findElement(By.xpath("//*[@id=\"html-input\"]")).clear();
			getDriver().findElement(By.xpath("//*[@id=\"html-input\"]")).sendKeys(pagina);
			getDriver().findElement(By.xpath("//*[@id=\"html-preview-button\"]/div")).click();
		}
	}

	public void irParaAplicacaoDeMarcacaoComMateriaDePRD() {
		String urlASerVerificada = getDriver().getCurrentUrl();
		String urlGoogleWebmaster = "https://www.google.com/webmasters/tools/richsnippets";
		getDriver().navigate().to(urlGoogleWebmaster);
		getDriver().findElement(By.xpath("//*[@id=\"url-input\"]")).sendKeys(urlASerVerificada);
		getDriver().findElement(By.xpath("//*[@id=\"url-preview-button\"]/div")).click();
	}

	public void fecharNavegador() {
		getDriver().close();
	}

	public String obterConteudo(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}

	public String buscarMarcacoes(String atributoDeXpath, String atributoDeComparacao) {
		return getDriver().findElement(By.xpath(atributoDeXpath)).getAttribute(atributoDeComparacao);
	}

	public String getPalavraChaveAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]");
	}

	public String getLinguagemAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]");
	}

	public String getDonoAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]");
	}

	public String getPublicadorAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]");
	}

	public String getDataDePublicacaoAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]");
	}

	public String getDataDeModificacaoAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[6]/td[2]");
	}

	public String getTituloAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[7]/td[2]");
	}

	public String getDescricaoAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[8]/td[2]");
	}

	public String getPrimeiraImagemAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[9]/td[2]");
	}

	public String getSegundaImagem() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[10]/td[2]");
	}

	public String getTerceiraImagem() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[11]/td[2]");
	}

	public String getQuartaImagem() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[12]/td[2]");
	}

	public String getQuintaImagem() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[13]/td[2]");
	}

	public String getSextaImagem() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[14]/td[2]");
	}

	public String getItemDeMarcacao() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[4]/div/div");
	}

	public String getTipoDeMarcacao() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[4]/div/table/tbody/tr[1]/td[2]");
	}

	public String getNomeDoDono() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[4]/div/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]");
	}

	public String getUrlDoDonoAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[4]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]");
	}

	public String getPublicador() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[5]/div/div");
	}

	public String getTipoSegundoItem() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[5]/div/table/tbody/tr[1]/td[2]");
	}

	public String getNomeDoPublicador() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[5]/div/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]");
	}

	public String getUrlDoPublicadorAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[5]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/a");
	}

	public String getLogoAtual() {
		String logo = obterConteudo("//*[@id=\"extracted-data-google\"]/div[5]/div/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]");
		return logo;
	}

	public String getTipoAtual() {
		return obterConteudo("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[1]/td[2]");
	}

	public String getTipoDeEsperado() {
		return buscarMarcacoes("//*[@itemtype='http://schema.org/ImageGallery']", "itemtype").toLowerCase();
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

	public ArrayList<String> getPrimeiraImagemEsperada() {
		List<WebElement> valor = getDriver().findElements(By.xpath("//*[@itemprop='image']"));
		ArrayList<String> lista = new ArrayList<String>();
		for (WebElement l : valor) {
			lista.add(l.getAttribute("src"));
		}
		return lista;
	}

	public ArrayList<String> getImagensAtuais() {
		List<WebElement> valor = getDriver().findElements(By.xpath("//*[@id=\"extracted-data-google\"]/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[count(td[contains(text(), 'image:')])=1]/td[2]"));
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
}
