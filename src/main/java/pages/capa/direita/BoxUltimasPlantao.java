package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxUltimasPlantao extends AceitacaoAbstractTest {
	
	private String urlDaPagina;
	private String urlAposClicar;

	public BoxUltimasPlantao(Navegador navegador) throws Exception {
		super(navegador);
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public void scrollAteOBox() throws InterruptedException {
		esperaCarregar(3);
		executarScroll(getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']")).getLocation().toString());
		esperaCarregar(3);
	}

	public boolean exibiuBoxUltimasNoticias() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']")).isDisplayed();
	}

	public String exibiuTituloPlantao() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/p/a")).getText();
	}

	public int exibiuQuantidadeMaiorQueUm() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']")).findElement(By.tagName("div")).findElement(By.tagName("ul")).findElements(By.tagName("li")).size();
	}

	public String exibiuHoraNoFormatoHHMM() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/div/ul/li[1]/span/b[1]")).getText();
	}

	public String exibiuDataNoFormatoDDMM() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/div/ul/li[1]/span/b[2]")).getText();
	}

	public boolean exibiuNomeEditoriaOuSubeditoria() {
		return !getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/div/ul/li[1]/a/span")).getText().isEmpty();
	}

	public boolean exibiuTituloDoConteudo() {
		return !getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/div/ul/li[1]/a/span")).getText().isEmpty();
	}

	public String exibiuTituloVerTodasAsMateriasDoSite() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/a")).getText();
	}

	public void clicouNoTituloPlantao() {
		getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/p/a")).click();
	}

	public boolean redirecionouParaAPaginaDePlantoesDaEditoria() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTituloVerTodasAsMateriasDoSite() {
		getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/a")).click();
	}

	public void clicouNoConteudo() {
		getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/div/ul/li[1]/a/span")).click();
	}

	public boolean redirecionouParaAPaginaDoConteudo() {
		return this.urlDaPagina != this.urlAposClicar;
	}
}