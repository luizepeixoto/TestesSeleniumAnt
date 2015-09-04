package pages.capa.direita;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxMaisBlogs extends AceitacaoAbstractTest {
	private String urlDaPagina;
	private String urlAposClicar;

	public BoxMaisBlogs(Navegador navegador) throws Exception{
		super(navegador);
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public boolean exibiuBoxMaisBlogs() throws InterruptedException {
		esperaCarregar(2);
		return getDriver().findElement(By.className("mais-blogs")).isDisplayed();
	}

	public String exibiuTituloMaisBlogs() {
		return getDriver().findElement(By.className("mais-blogs")).findElement(By.tagName("p")).getText();
	}
	
	public List<WebElement> listaDeColunistas() {
		return getDriver().findElement(By.className("mais-blogs")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}

	public int exibiuMinimoDeUmColunistas() {
		return listaDeColunistas().size();
	}
	
	public boolean exibiuUmLinkEmCadaChamadaDosBlogs() {
		for(int i=0; i<listaDeColunistas().size(); i++){
			if(!listaDeColunistas().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagemDoBlog() {
		for(int i=0; i<listaDeColunistas().size(); i++){
			if(!listaDeColunistas().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuAutorDeCadaBlog() {
		for(int i=0; i<listaDeColunistas().size(); i++){
			if(listaDeColunistas().get(i).findElement(By.tagName("a")).findElement(By.className("autor")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloDosPostsNaChamadaDosBlogs() {
		for(int i=0; i<listaDeColunistas().size(); i++){
			if(listaDeColunistas().get(i).findElement(By.tagName("a")).findElement(By.className("chamada")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDataDoPostsNasChamadaDosBlogs() {
		for(int i=0; i<listaDeColunistas().size(); i++){
			if(listaDeColunistas().get(i).findElement(By.tagName("a")).findElement(By.className("data")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public String formatoDataEHora() {
		return getDriver().findElement(By.xpath("//div[@class='mais-blogs clearfix']/ul/li[1]/a/div/span[3]")).getText();
	}

	public String exibiuTituloVerTodosOsBlogs() {
		return getDriver().findElement(By.xpath("//div[@class='mais-blogs clearfix']/a")).getText();
	}

	public void clicouNoTituloMaisBlogs() {
		getDriver().findElement(By.xpath("//div[@class='mais-blogs clearfix']/p/a")).click();	
	}

	public boolean redirecionouParaAPaginaDeBlogs() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTituloDoPrimeiroBlog() {
		getDriver().findElement(By.xpath("//div[@class='mais-blogs clearfix']/ul/li[1]/a/div/span[1]")).click();		
	}

	public boolean redirecionouParaAPaginaDoBlog() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTituloVerTodosOsBlogs() {
		getDriver().findElement(By.xpath("//div[@class='mais-blogs clearfix']/a")).click();
	}
}