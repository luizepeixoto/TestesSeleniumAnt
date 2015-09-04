package pages.editoria.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaqueHorizontalCom3Colunas1Foto extends AceitacaoAbstractTest {
	
	public DestaqueHorizontalCom3Colunas1Foto() throws Exception{
		super();
	}
	
	public DestaqueHorizontalCom3Colunas1Foto(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuDestaque() {
		return getDriver().findElement(By.className("box-editorias"));
	}

	public WebElement exibiuClasseFotoRight() {
		return exibiuDestaque().findElement(By.className("foto-right"));
	}
	
	public boolean exibiuASubeditoria() {
		return !exibiuClasseFotoRight().findElement(By.tagName("p")).getText().isEmpty();
	}

	public boolean exibiuOTitulo() {
		return !exibiuClasseFotoRight().findElement(By.tagName("h1")).getText().isEmpty();
	}

	public boolean exibiuOSubtitulo() {
		return !exibiuClasseFotoRight().findElement(By.tagName("h2")).getText().isEmpty();
	}

	public List<WebElement> listaDeMaterias() {
		return exibiuClasseFotoRight().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaListaDeMaterias() {
		return listaDeMaterias().size()>0;
	}

	public boolean exibiuOTituloDasMaterias() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(listaDeMaterias().get(i).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkNoTitulo() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(!listaDeMaterias().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoNoTitulo() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(listaDeMaterias().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getFoto() {
		return exibiuClasseFotoRight().findElement(By.className("img")).findElement(By.tagName("img")).isDisplayed();
	}

	public String getWidth() {
		return exibiuClasseFotoRight().findElement(By.className("img")).findElement(By.tagName("img")).getAttribute("width");
	}

	public String getHeight() {
		return exibiuClasseFotoRight().findElement(By.className("img")).findElement(By.tagName("img")).getAttribute("height");
	}
	
	public List<WebElement> listaDeMateriasRelacionadas() {
		return getDriver().findElement(By.className("web-chamadas")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuMateriasRelacionadas() {
		return listaDeMateriasRelacionadas().size()>1;
	}

	public boolean exibiuFotoNasMateriasRelacionadas() {
		for(int i=0; i<listaDeMateriasRelacionadas().size();i++){
			List<WebElement> possuiImagem = listaDeMateriasRelacionadas().get(i).findElements(By.tagName("img"));
			if(possuiImagem.size()>0){
				if(!listaDeMateriasRelacionadas().get(i).findElement(By.tagName("img")).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuWidthParaMateriasRelacionadas() {
		for(int i=0; i<listaDeMateriasRelacionadas().size();i++){
			List<WebElement> possuiImagem = listaDeMateriasRelacionadas().get(i).findElements(By.tagName("img"));
			if(possuiImagem.size()>0){
				if(!(listaDeMateriasRelacionadas().get(i).findElement(By.tagName("img")).getAttribute("width").equals("60") || 
						listaDeMateriasRelacionadas().get(i).findElement(By.tagName("img")).getAttribute("width").equals("140"))){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuHeightParaMateriasRelacionadas() {
		for(int i=0; i<listaDeMateriasRelacionadas().size();i++){
			List<WebElement> possuiImagem = listaDeMateriasRelacionadas().get(i).findElements(By.tagName("img"));
			if(possuiImagem.size()>0){
				if(!(listaDeMateriasRelacionadas().get(i).findElement(By.tagName("img")).getAttribute("height").equals("60") || 
						listaDeMateriasRelacionadas().get(i).findElement(By.tagName("img")).getAttribute("height").equals("84"))){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuAutor() {
		for(int i=0; i<listaDeMateriasRelacionadas().size();i++){
			List<WebElement> possuiAutor = listaDeMateriasRelacionadas().get(i).findElements(By.tagName("p"));
			if(possuiAutor.size()>0){
				if(listaDeMateriasRelacionadas().get(i).findElement(By.tagName("p")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuTituloNasMateriasRelacionadas() {
		for(int i=0; i<listaDeMateriasRelacionadas().size();i++){
				if(listaDeMateriasRelacionadas().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
					return false;
				}
		}
		return true;
	}

	public boolean exibiuUmLinkNoTituloDasMateriasRelacionadas() {
		for(int i=0; i<listaDeMateriasRelacionadas().size();i++){
			if(!listaDeMateriasRelacionadas().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
	}
		return true;
	}

	public boolean exibiuUmLinkValidoNoTituloDasMateriasRelacionadas() {
		for(int i=0; i<listaDeMateriasRelacionadas().size();i++){
			if(listaDeMateriasRelacionadas().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
	}
		return true;
	}

	public boolean exibiuTamanhoDoTituloCorreto() {
		for(int i=0; i<listaDeMateriasRelacionadas().size();i++){
			if(listaDeMateriasRelacionadas().get(i).findElement(By.tagName("h3")).getText().length()>65){
				return false;
			}
	}
		return true;
	}

	public boolean exibiuAutorNaChamadaPrincipal() {
		return !exibiuDestaque().findElement(By.xpath("//div[@class='base foto-right']/div/h2/b")).getText().isEmpty();
	}

}
