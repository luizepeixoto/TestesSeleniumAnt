package pages.materia.comentario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaComUmComentario extends AceitacaoAbstractTest {

	public MateriaComUmComentario(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void esperaCaixaDeComentarioCarregar(){
		while(! getDriver().findElement(By.className("comentarios")).isDisplayed()){
			if(getDriver().findElement(By.className("comentarios")).isDisplayed()){
				break;
			}
		}
	}
	
	public WebElement exibiuClasseComentarios() {
		return getDriver().findElement(By.className("comentarios"));
	}

	public String getTituloDeComentariosIgualUm(){
		return exibiuClasseComentarios().findElement(By.tagName("h3")).getText().toLowerCase();
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
	
	public boolean getTotalDeComentarios(){
		List<WebElement> resultado = exibiuClasseComentarios().findElement(By.className("lista-comentarios")).findElements(By.tagName("li"));
		return resultado.size() == Integer.parseInt("1");
	}

	public boolean exibiuBoxDeCarregarMaisComentarios(){
		List<WebElement> resultado = getDriver().findElement(By.className("lista-comentarios")).findElements(By.className("more"));
		return resultado.size() == Integer.parseInt("0");
	}
}