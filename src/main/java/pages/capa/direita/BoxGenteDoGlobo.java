package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxGenteDoGlobo extends AceitacaoAbstractTest {
	private String urlDaPagina;
	private String urlAposClicar;

	public BoxGenteDoGlobo(Navegador navegador) throws Exception {
		super(navegador);
		this.urlDaPagina = getDriver().getCurrentUrl();
	}
	
	public String tituloGenteDoGlobo() throws InterruptedException {
		return getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/p")).getText();
	}

	public int quantidadeMinimaColunistas() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.className("gente-do-globo")).findElement(By.tagName("ul")).findElements(By.tagName("li")).size();
	}

	public boolean tituloDoPrimeiroBlog() throws InterruptedException {
		esperaCarregar(1);
		return !getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[1]/a/div/span[1]")).getText().isEmpty();
	}

	public boolean tituloDoPostDoPrimeiroBlog() throws InterruptedException {
		esperaCarregar(1);
		return !getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[1]/a/div/span[2]")).getText().isEmpty();
	}

	public boolean tituloDoSegundoBlog() throws InterruptedException {
		esperaCarregar(1);
		return !getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[2]/a/div/span[1]")).getText().isEmpty();
	}

	public boolean tituloDoSegundoPost() throws InterruptedException {
		esperaCarregar(1);
		return !getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[2]/a/div/span[2]")).getText().isEmpty();
	}

	public String formatoDataEHora() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[2]/a/div/span[3]")).getText();
	}

	public String tituloVerTodosOsBlogs() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/a")).getText();
	}

	public void clicouNoTituloDeUmBlog() throws InterruptedException {
		esperaCarregar(1);
		getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/ul/li[1]/a/div/span[1]")).click();
	}

	public String getUrlAtual() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().getCurrentUrl();
	}

	public boolean redirecionouParaPaginaDoBlog() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTituloVerTodosOs() throws InterruptedException {
		esperaCarregar(1);
		getDriver().findElement(By.xpath("//div[@class='gente-do-globo']/a")).click();
	}

	public boolean redirecionouParaPaginaDeBlogs() throws InterruptedException {
		esperaCarregar(1);
		return this.urlDaPagina != this.urlAposClicar;
	}
}