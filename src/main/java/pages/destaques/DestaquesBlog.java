package pages.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaquesBlog extends AceitacaoAbstractTest {
	
	public DestaquesBlog() throws Exception {
		super();
	}

	public DestaquesBlog(Navegador navegador) throws Exception {
		super(navegador);
	}

	public boolean exibiuOAntititulo() {
		return !getDriver().findElement(By.className("subtitulo-container")).findElement(By.className("subtitulo")).getText().isEmpty();
	}

	public WebElement exibiuDestaqueHorizontal() {
		return getDriver().findElement(By.className("destaque-horizontal"));
	}

	public boolean exibiuFotoDoDestaqueHorizontal() {
		List<WebElement> possuiFotoNoDestaque = exibiuDestaqueHorizontal().findElements(By.tagName("img"));
		if(possuiFotoNoDestaque.size() > 0){
			if(exibiuDestaqueHorizontal().findElement(By.tagName("img")).getAttribute("src").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNaFotoDoDestaque() {
		List<WebElement> possuiFotoNoDestaque = exibiuDestaqueHorizontal().findElements(By.tagName("img"));
		if(possuiFotoNoDestaque.size() > 0){
			if(!exibiuDestaqueHorizontal().findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNaFotoDoDestaque() {
		List<WebElement> possuiFotoNoDestaque = exibiuDestaqueHorizontal().findElements(By.tagName("img"));
		if(possuiFotoNoDestaque.size() > 0){
			if(exibiuDestaqueHorizontal().findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuFotoDoDestaqueComWidth470() {
		List<WebElement> possuiFotoNoDestaque = exibiuDestaqueHorizontal().findElements(By.tagName("img"));
		if(possuiFotoNoDestaque.size() > 0){
			if(!exibiuDestaqueHorizontal().findElement(By.tagName("img")).getAttribute("width").equals("470")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuFotoDoDestaqueComHeight281() {
		List<WebElement> possuiFotoNoDestaque = exibiuDestaqueHorizontal().findElements(By.tagName("img"));
		if(possuiFotoNoDestaque.size() > 0){
			if(!exibiuDestaqueHorizontal().findElement(By.tagName("img")).getAttribute("height").equals("281")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloDoDestaqueHorizontal() {
		return !exibiuDestaqueHorizontal().findElement(By.className("titulo")).getText().isEmpty();
	}

	public boolean exibiuLinkNoTituloDoDestaqueHorizontal() {
		return exibiuDestaqueHorizontal().findElement(By.className("titulo")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkValidoNoTituloDoDestaqueHorizontal() {
		return !exibiuDestaqueHorizontal().findElement(By.className("titulo")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTempoDestaqueHorizontal() {
		return !exibiuDestaqueHorizontal().findElement(By.className("tempo")).getText().isEmpty();
	}

	public boolean exibiuDescricaoDoDestaqueHorizontal() {
		return !exibiuDestaqueHorizontal().findElement(By.className("subtitulo")).getText().isEmpty();
	}
	
	public List<WebElement> listaDeDestaques(){
		return getDriver().findElement(By.className("destaques-lista")).findElements(By.tagName("li"));
	}

	public boolean exibiuListaDeDestaques() {
		return listaDeDestaques().size() > 0;
	}

	public boolean exibiuFotoParaOPrimeiroDestaqueDaLista() {
		List<WebElement> exibiuFoto = listaDeDestaques().get(0).findElement(By.className("inner-border")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("img")).getAttribute("src").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuFotoDaListaComWidth234Px() {
		List<WebElement> exibiuFoto = listaDeDestaques().get(0).findElement(By.className("inner-border")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("img")).getAttribute("width").equals("234")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuFotoDaListaComHeight140Px() {
		List<WebElement> exibiuFoto = listaDeDestaques().get(0).findElement(By.className("inner-border")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("img")).getAttribute("height").equals("140")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNaFotoDoOPrimeiroDestaqueDaLista() {
		List<WebElement> exibiuFoto = listaDeDestaques().get(0).findElement(By.className("inner-border")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoNaFotoDoOPrimeiroDestaqueDaLista() {
		List<WebElement> exibiuFoto = listaDeDestaques().get(0).findElement(By.className("inner-border")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloParaOPrimeiroDestaqueDaLista() {
		return !listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuTituloComNoMaximo72Caracteres() {
		return listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("h2")).getText().length() < 72;
	}

	public boolean exibiuLinkNoTituloDoPrimeiroDestaqueDaLista() {
		return listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoTituloDoPrimeiroDestaqueDaLista() {
		return !listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean getTempoDePostagemParaOPrimeiroDestaqueDaLista() {
		return !listaDeDestaques().get(0).findElement(By.className("inner-border")).findElement(By.className("tempo")).getText().isEmpty();
	}

	public WebElement exibiuClasseDestaques() {
		return getDriver().findElement(By.className("destaques-lista"));
	}
			
	public WebElement exibiuChamadaDeBlog() {
		return exibiuClasseDestaques().findElement(By.className("blog-post"));
	}

	public boolean exibiuTituloDoBlog() {
		return exibiuChamadaDeBlog().findElement(By.className("tipo-conteudo")).getText().equals("Blog");
	}

	public boolean exibiuImagemDoBlog() {
		return exibiuChamadaDeBlog().findElement(By.className("imagem-blog")).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean getImagemDoBlogWidth() {
		return exibiuChamadaDeBlog().findElement(By.className("imagem-blog")).findElement(By.tagName("img")).getAttribute("width").equals("60");
	}

	public boolean getImagemDoBlogHeight() {
		return exibiuChamadaDeBlog().findElement(By.className("imagem-blog")).findElement(By.tagName("img")).getAttribute("height").equals("60");
	}

	public boolean exibiuNomeDoBlog() {
		return !exibiuChamadaDeBlog().findElement(By.className("nome")).getText().isEmpty();
	}

	public WebElement exibiuLinkNoNomeDoBlog() {
		return exibiuChamadaDeBlog().findElement(By.className("titulo-blog")).findElement(By.tagName("a")).findElement(By.className("nome"));
	}

	public boolean exibiuLinkValidoNoNomeDoBlog() {
		return !exibiuChamadaDeBlog().findElement(By.className("titulo-blog")).findElement(By.tagName("a")).getAttribute("href").isEmpty();	
	}

	public boolean exibiuAutorDoBlog() {
		return !exibiuChamadaDeBlog().findElement(By.className("titulo-blog")).findElement(By.className("autor")).getText().isEmpty();
	}
	
	public WebElement exibiuLinkNoAutorDoBlog() {
		return exibiuChamadaDeBlog().findElement(By.className("titulo-blog")).findElement(By.tagName("a")).findElement(By.className("autor"));
	}

	public boolean exibiuTituloDoPostDoBlog() {
		return !exibiuChamadaDeBlog().findElement(By.className("link-post")).findElement(By.className("chamada")).getText().isEmpty();
	}
	
	public boolean exibiuTituloDoPostComNoMaximo53Caracteres() {
		return exibiuChamadaDeBlog().findElement(By.className("link-post")).findElement(By.className("chamada")).getText().length() < 56;
	}
	
	public boolean exibiuLinkNoTituloDoPost() {
		return !exibiuChamadaDeBlog().findElement(By.className("link-post")).getAttribute("href").isEmpty();
	}

	public boolean exibiuDescricaoDoPostDoBlog() {
		return !exibiuChamadaDeBlog().findElement(By.className("resumo")).getText().isEmpty();
	}
	
	public boolean exibiuDescricaoDoPostDoBlogComNoMaximo120Caracteres() {
		return exibiuChamadaDeBlog().findElement(By.className("resumo")).getText().length() < 123;
	}
}
