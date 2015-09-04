package pages.editoria.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaqueHorizontalEspecialCom3Colunas extends AceitacaoAbstractTest {
	
	public DestaqueHorizontalEspecialCom3Colunas() throws Exception{
		super();
	}
	
	public DestaqueHorizontalEspecialCom3Colunas(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuDestaque() {
		return getDriver().findElement(By.className("destaque-especial"));
	}
	
	public WebElement exibiuDestaquePrincipal() {
		return exibiuDestaque().findElement(By.className("principal"));
	}
	
	public WebElement exibiuClasseResumo() {
		return exibiuDestaque().findElement(By.className("resumo"));
	}
	
	public WebElement exibiuClasseClearfix() {
		return exibiuDestaque().findElement(By.className("clearfix"));
	}
	
	public String exibiuTituloUrgente() {
		return exibiuDestaquePrincipal().findElement(By.tagName("h2")).getText();
	}

	public boolean exibiuTituloUrgenteNaCorVermelha() {
		return exibiuDestaquePrincipal().findElement(By.tagName("h2")).findElement(By.className("urgente")).getText().equals("Urgente");
	}

	public boolean exibiuLinkNoTituloUrgente() {
		return exibiuDestaquePrincipal().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkValidoNoTituloUrgente() {
		return !exibiuDestaquePrincipal().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloDaMateria() {
		return !exibiuDestaquePrincipal().findElement(By.className("titulo-materia")).getText().isEmpty();
	}

	public boolean exibiuTituloDaMateriaComLink() {
		return exibiuDestaquePrincipal().findElement(By.className("titulo-materia")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloDaMateriaComLinkValido() {
		return !exibiuDestaquePrincipal().findElement(By.className("titulo-materia")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuDescricaoDaMateria() {
		return !exibiuDestaquePrincipal().findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean exibiuFotoDoDestaque() {
		return exibiuDestaquePrincipal().findElement(By.tagName("img")).isDisplayed();
	}

	public String getWidthDaFotoEmDestaque() {
		return exibiuDestaquePrincipal().findElement(By.tagName("img")).getAttribute("width");
	}

	public Object getHeightDaFotoEmDestaque() {
		return exibiuDestaquePrincipal().findElement(By.tagName("img")).getAttribute("height");
	}

	public boolean exibiuLinkNaFotoDoDestaque() {
		return exibiuDestaquePrincipal().findElements(By.tagName("a")).get(1).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuLinkValidoNaFotoDoDestaque() {
		return !exibiuDestaquePrincipal().findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty();
	}

	public boolean exibiuResumo() {
		return !exibiuClasseResumo().findElement(By.tagName("p")).getText().isEmpty();
	}

	public boolean exibiuAutor() {
		return !exibiuClasseResumo().findElement(By.className("depoimento")).findElement(By.tagName("p")).getText().isEmpty();
	}

	public boolean exibiuDescricaoDoAutor() {
		return !exibiuClasseResumo().findElement(By.className("depoimento")).findElement(By.tagName("span")).getText().isEmpty();
	}

	public List<WebElement> listaDeMaterias() {
		return exibiuClasseClearfix().findElements(By.tagName("li"));
	}
	
	public boolean exibiuListaDeMaterias() {
		return listaDeMaterias().size() > 0;
	}

	public boolean exibiuAsMateriasComFoto() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(!listaDeMaterias().get(i).findElement(By.tagName("img")).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuAsFotosComWidth234() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(!listaDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("width").equals("234")){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuAsFotosComHeight140() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(!listaDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("height").equals("140")){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuLinkNasFotos() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(!listaDeMaterias().get(i).findElement(By.tagName("a")).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuLinkValidoNasFotos() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(listaDeMaterias().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuTitulosNasMaterias() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(!listaDeMaterias().get(i).findElement(By.tagName("p")).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuTitulosComMaximoDeCaracteresPermitido() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(listaDeMaterias().get(i).findElement(By.tagName("p")).getText().length() > 63){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuLinkNoTitulosNasMaterias() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(!listaDeMaterias().get(i).findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuLinkValidoNoTitulosNasMaterias() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiImagemNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiImagemNaPosicao.size() > 0){
				if(listaDeMaterias().get(i).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuAutorNaChamadaPrincipal() {
		return !exibiuDestaque().findElement(By.xpath("//div[@class='principal com-fundo azul']/div/span/b")).getText().isEmpty();
	}

	public boolean exibiuAutorNaChamadaResumo() {
		return !exibiuDestaque().findElement(By.xpath("//div[@class='sub']/div/span/b")).getText().isEmpty();
	}

	public boolean exibiuAutorNaChamadadeOpiniao() {
		return !exibiuDestaque().findElement(By.xpath("//div[@class='web-chamada clearfix quatro']/div/a/h5")).getText().isEmpty();
	}
}
