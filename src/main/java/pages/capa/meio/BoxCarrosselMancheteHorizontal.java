package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDoMeio;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxCarrosselMancheteHorizontal extends AceitacaoAbstractTest {
	
	public BoxCarrosselMancheteHorizontal() throws Exception{
		super();
	}
	
	public BoxCarrosselMancheteHorizontal(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuCarrossel() {
		return getDriver().findElement(By.className("box-carrossel"));
	}
	
	public List<WebElement> listaTotalDeFoto() {
		return exibiuCarrossel().findElement(By.className("carrossel-container")).findElements(By.className("active"));
	}
	
	public boolean exibiuMaisDeUmaFoto() {
		return listaTotalDeFoto().size()>1;
	}
	
	public boolean exibiuFotos() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(!listaTotalDeFoto().get(i).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuAltNasFotos() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(listaTotalDeFoto().get(i).findElement(By.tagName("img")).getAttribute("alt").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkParaCadaFoto() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(!listaTotalDeFoto().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoParaCadaFoto() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(listaTotalDeFoto().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuCropCorretoParaAsImagensDoCarrossel() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(!listaTotalDeFoto().get(i).findElement(By.tagName("img")).getAttribute("src").contains(CropsCapaColunaDoMeio.boxCarrossel.cropProporcional())){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuWidthCorretoParaAsImagensDoCarrossel() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(!listaTotalDeFoto().get(i).findElement(By.tagName("img")).getAttribute("width").equals(CropsCapaColunaDoMeio.boxCarrossel.getWidth())){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuHeightCorretoParaAsImagensDoCarrossel() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(!listaTotalDeFoto().get(i).findElement(By.tagName("img")).getAttribute("height").equals(CropsCapaColunaDoMeio.boxCarrossel.getHeight())){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTitulo() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(listaTotalDeFoto().get(i).findElement(By.className("nome-item")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkNoTitulo() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(!listaTotalDeFoto().get(i).findElements(By.tagName("a")).get(1).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkValidoNoTitulo() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(listaTotalDeFoto().get(i).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricao() {
		for(int i=0; i<listaTotalDeFoto().size();i++){
			if(listaTotalDeFoto().get(i).findElement(By.className("sobre-item")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLink() {
		return getDriver().findElement(By.className("ver-todos")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuTextoNoLink() {
		return !getDriver().findElement(By.className("ver-todos")).findElement(By.tagName("a")).getText().isEmpty();
	}
	
	public boolean exibiuLinkValido() {
		return !getDriver().findElement(By.className("ver-todos")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public WebElement exibiuNavegacao() {
		return exibiuCarrossel().findElement(By.className("nav"));
	}

	public boolean exibiuTotalDeFotos() {
		return exibiuNavegacao().findElement(By.className("count-container")).getText().contains("1 de");
	}

	public boolean exibiuNavegacaoParaDireitaDesativada() {
		return exibiuNavegacao().findElement(By.className("disabled")).getText().equals("Anterior");
	}

	public boolean exibiuNavegacaoParaEsquerda() {
		return exibiuNavegacao().findElement(By.className("proxima")).getText().equals("Próximo");
	}
}