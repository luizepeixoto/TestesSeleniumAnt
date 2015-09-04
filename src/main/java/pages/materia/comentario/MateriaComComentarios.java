package pages.materia.comentario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaComComentarios extends AceitacaoAbstractTest {
	
	public MateriaComComentarios() throws Exception {
		super();
	}
	
	public MateriaComComentarios(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement getClasseComentarios(){
		return getDriver().findElement(By.className("comentarios"));
	}

	public WebElement exibiuComentarioNoMenu(){
		return getDriver().findElement(By.className("menu-interacao")).findElement(By.id("comentar"));
	}
	
	public String exibiuTextoComentar(){
		return exibiuComentarioNoMenu().findElement(By.tagName("a")).getText().toLowerCase();
	}
	
	public boolean exibiuComentarioDoMenuComLink(){
		return exibiuComentarioNoMenu().findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuComentarioDoMenuComUmLinkValido(){
		return !exibiuComentarioNoMenu().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public WebElement exibiuBoxDeComentarioNaMateria(){
		return getDriver().findElement(By.tagName("article")).findElement(By.className("comentarios"));
	}
	
	public String exibiuTituloParaComentar() throws InterruptedException{
		getDriver().manage().deleteAllCookies();
		Thread.sleep(3000);
		return getDriver().findElement(By.cssSelector("div.login")).getText().toLowerCase();
	}
	
	public List<WebElement> getBoxComentarioListaA(){
		return getClasseComentarios().findElement(By.className("login")).findElements(By.tagName("a"));
	}
	
	public boolean exibiuTotalDeComentarios(){
		return getClasseComentarios().findElement(By.tagName("h3")).getText().contains("comentários");
	}
	
	public WebElement getClasseComentario(){
		return getClasseComentarios().findElement(By.className("lista-comentarios"));
	}
	
	public List<WebElement> getListaComentario(){
		return getClasseComentario().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public int getClassesRespostasPreenchidas(){
		List<WebElement> listaDeClasseResposta = getDriver().findElement(By.className("lista-comentarios")).findElement(By.tagName("ul")).findElements(By.className("respostas"));
		int contadorUl = 0;
		
		for(int i = 0; i < listaDeClasseResposta.size(); i++){
			if(listaDeClasseResposta.get(i).findElements(By.tagName("ul")).size() > 0){
				contadorUl ++;
			}
		}
		return contadorUl;
	}
	
	public int getBoxTotalListaComentario(){
		return getListaComentario().size() - getClassesRespostasPreenchidas();
	}
	
	public boolean exibiuListaDeComentarios(){
		return getBoxTotalListaComentario()>0;
	}
	
	public boolean exibiuAutorParaOsComentarios(){
		for(int i=0;i<getBoxTotalListaComentario();i++){
			if( getListaComentario().get(i).findElement(By.className("content")).findElement(By.className("autor")).findElement(By.tagName("strong")).getText() != ""){
				return true;
			}
		}
		return false;
	}
	
	public boolean exibiuBulletAoLadoDoAutor(){
		for(int i=0;i<getBoxTotalListaComentario();i++){
			if( !getListaComentario().get(i).findElement(By.className("content")).findElement(By.className("autor")).findElement(By.tagName("span")).getText().contains("•")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTempoParaOsComentarios(){
		for(int i=0;i<getBoxTotalListaComentario();i++){
			if( getListaComentario().get(i).findElement(By.className("content")).findElement(By.className("autor")).findElement(By.tagName("time")).getText() != ""){
				return true;
			}
		}
		return false;
	}
	
	public boolean exibiuUmTextoEmCadaUmDosComentarios(){
		for(int i=0;i<getBoxTotalListaComentario();i++){
			if( getListaComentario().get(i).findElement(By.className("content")).findElement(By.className("text")).getText() != ""){
				return true;
			}
		}
		return false;
	}
	
	public boolean exibiuAutorParaCadaUmaDasRespostas(){
		List<WebElement> listaDeClasseResposta = getDriver().findElement(By.className("lista-comentarios")).findElement(By.tagName("ul")).findElements(By.className("respostas"));
		for(int i = 0; i < listaDeClasseResposta.size(); i++){
			if(listaDeClasseResposta.get(i).findElements(By.tagName("ul")).size() > 0){
				if(listaDeClasseResposta.get(i).findElement(By.tagName("ul")).findElement(By.tagName("li")).findElement(By.className("autor")).findElement(By.tagName("strong")).getText() == ""){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuUmBulletParaCadaAutor(){
		List<WebElement> listaDeClasseResposta = getDriver().findElement(By.className("lista-comentarios")).findElement(By.tagName("ul")).findElements(By.className("respostas"));
		for(int i = 0; i < listaDeClasseResposta.size(); i++){
			if(listaDeClasseResposta.get(i).findElements(By.tagName("ul")).size() > 0){
				if(!listaDeClasseResposta.get(i).findElement(By.tagName("ul")).findElement(By.tagName("li")).findElement(By.className("autor")).findElement(By.tagName("span")).getText().contains("•")){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuTempoDecorridoParaCadaUmaDasRespostas(){
		List<WebElement> listaDeClasseResposta = getDriver().findElement(By.className("lista-comentarios")).findElement(By.tagName("ul")).findElements(By.className("respostas"));
		for(int i = 0; i < listaDeClasseResposta.size(); i++){
			if(listaDeClasseResposta.get(i).findElements(By.tagName("ul")).size() > 0){
				if(listaDeClasseResposta.get(i).findElement(By.tagName("ul")).findElement(By.tagName("li")).findElement(By.className("autor")).findElement(By.tagName("time")).getText() == ""){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean getComentarioRespostaTexto(){
		List<WebElement> listaDeClasseResposta = getDriver().findElement(By.className("lista-comentarios")).findElement(By.tagName("ul")).findElements(By.className("respostas"));
		for(int i = 0; i < listaDeClasseResposta.size(); i++){
			if(listaDeClasseResposta.get(i).findElements(By.tagName("ul")).size() > 0){
				if(listaDeClasseResposta.get(i).findElement(By.tagName("ul")).findElement(By.tagName("li")).findElement(By.className("text")).getText() == ""){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuBotaoDeMaisComentarios(){
		return getClasseComentario().findElement(By.className("mais-comentarios")).isDisplayed();
	}
	
	public boolean getBotaoMaisComentarioLink(){
		return getClasseComentario().findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean getBotaoMaisComentarioLinkValido(){
		return !getClasseComentario().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public String getBotaoMaisComentarioTexto(){
		return getClasseComentario().findElement(By.className("mais-comentarios")).getText();
	}

	public String exibiuOTitleCorretoParaOBotaoMaisComentario(){
		return getClasseComentario().findElement(By.tagName("a")).getAttribute("title");
	}
	
}