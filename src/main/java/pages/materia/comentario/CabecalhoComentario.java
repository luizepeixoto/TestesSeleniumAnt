package pages.materia.comentario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class CabecalhoComentario extends AceitacaoAbstractTest {
	
	public CabecalhoComentario(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement scrollAteACaixaDeComentario() {
		return getDriver().findElement(By.className("navegacao"));
	}
	
	public String exibiuTituloParaComentar() throws InterruptedException{
		return getDriver().findElement(By.cssSelector("p.title")).getText().toLowerCase();
	}

	public WebElement exibiuBotaoDeComentar() {
		return getDriver().findElement(By.cssSelector("p.btn"));
	}

	public String exibiuTituloComentarDentroDoBotao() {
		return getDriver().findElement(By.cssSelector("p.btn > a")).getText().toLowerCase();
	}
	
	public boolean exibiuTextoDeResponsabilidadeDoAutor() throws InterruptedException {
		esperaCarregar(1);
		return !getDriver().findElement(By.xpath("//header/p[2]")).getText().isEmpty();
	}						
	
	public String exibiuTituloPerguntasFrequentes() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//header/ul/li/a")).getText().toLowerCase();
	}
	
	public boolean exibiuLinkNoTituloPerguntasFrequentes() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//header/ul/li/a")).isDisplayed();
	}
	
	public String exibiuTituloTermosDeUso() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//header/ul/li[2]/a")).getText().toLowerCase();
	}
	
	public boolean exibiuLinkNoTituloTermosDeUso() throws InterruptedException {
		esperaCarregar(1);
		return getDriver().findElement(By.xpath("//header/ul/li[2]/a")).isDisplayed();
	}
}