package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxGenteDoGloboComExclusoes extends AceitacaoAbstractTest {
	private String urlDaPagina;
	private String urlAposClicar;

	public BoxGenteDoGloboComExclusoes(Navegador navegador) throws Exception {
		super(navegador);
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public void executaScrollAteAPosicaoDesejada() throws InterruptedException {
		esperaCarregar(5);
		executarScroll(getDriver().findElement(By.xpath("//div[@class='gente-do-globo']")).getLocation().toString());
	}

	public String tituloGenteDoGlobo() throws InterruptedException {
		esperaCarregar(5);
		return getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/p")).getText();
	}

	public int quantidadeMinimaColunistas() {
		return getDriver().findElement(By.className("gente-do-globo")).findElement(By.tagName("ul")).findElements(By.tagName("li")).size();
	}

	public boolean tituloDoPrimeiroBlog() {
		return !getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[1]/a/div/span[1]")).getText().isEmpty();

	}

	public boolean tituloDoPostDoPrimeiroBlog() {
		return !getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[1]/a/div/span[2]")).getText().isEmpty();
	}

	public boolean tituloDoSegundoBlog() {
		return !getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[2]/a/div/span[1]")).getText().isEmpty();
	}

	public boolean tituloDoSegundoPost() {
		return !getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[2]/a/div/span[2]")).getText().isEmpty();
	}

	public String formatoDataEHora() {
		return getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[2]/a/div/span[3]")).getText();
	}

	public String tituloVerTodosOsBlogs() {
		return getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/a")).getText();
	}

	public void clicouNoTituloDeUmBlog() {
		getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[1]/a/div/span[1]")).click();

	}

	public String getUrlAtual() {
		return getDriver().getCurrentUrl();
	}

	public boolean redirecionouParaPaginaDoBlog() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTituloVerTodosOs() {
		getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/a")).click();
	}

	public boolean redirecionouParaPaginaDeBlogs() {
		return this.urlDaPagina != this.urlAposClicar;
	}
}