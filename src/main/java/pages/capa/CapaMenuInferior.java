package pages.capa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class CapaMenuInferior extends AceitacaoAbstractTest {
	
	public CapaMenuInferior() throws Exception {
		super();
	}
	
	public CapaMenuInferior(Navegador navegador) throws Exception {
		super(navegador);
	}

	//Box Page Not Found//
	public WebElement exibiuOBoxDoPageNotFound() {
		return getDriver().findElement(By.className("box-page-not-found"));
	}

	public String exibiuOTituloDoPageNotFound() {
		return exibiuOBoxDoPageNotFound().findElement(By.tagName("h2")).getText();
	}
	
	public boolean oTituloPageNotFoundPossuiUmLink() {
		return exibiuOBoxDoPageNotFound().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean oLinkDoTituloDoPageNotFoundEstaCorreto() {
		return !exibiuOBoxDoPageNotFound().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public List<WebElement> totalDematerias(){
		return exibiuOBoxDoPageNotFound().findElements(By.tagName("li"));
	}
	
	public boolean exibiuAsMateriasDoPageNotFound() {
		return totalDematerias().size() == 6;
	}

	public boolean asMateriasDoPageNotFoundPossuemTag() {
		for(int i=0; i<totalDematerias().size(); i++){
			if(totalDematerias().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean asMateriasDoPageNotFoundPossuemUmLink() {
		for(int i=0; i<totalDematerias().size(); i++){
			if(!totalDematerias().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean osLinksDasMateriasDoPageNotFoundSaoValidos() {
		for(int i=0; i<totalDematerias().size(); i++){
			if(totalDematerias().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean asMateriasDoPageNotFoundPossuemImagem() {
		for(int i=0; i<totalDematerias().size(); i++){
			if(!totalDematerias().get(i).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean oAltDasImagensDasMateriasDoPageNotFoundPossuemAutor() {
		for(int i=0; i<totalDematerias().size(); i++){
			if(!totalDematerias().get(i).findElement(By.tagName("img")).getAttribute("alt").contains("Foto:")){
				return false;
			}
		}
		return true;
	}

	public boolean asImagensDasMateriasDoPageNotFoundPossuemWidthDe140Px() {
		for(int i=0; i<totalDematerias().size(); i++){
			if(!totalDematerias().get(i).findElement(By.tagName("img")).getAttribute("width").equals("140")){
				return false;
			}
		}
		return true;
	}

	public boolean asImagensDasMateriasDoPageNotFoundPossuemHeightDe85Px() {
		for(int i=0; i<totalDematerias().size(); i++){
			if(!totalDematerias().get(i).findElement(By.tagName("img")).getAttribute("height").equals("85")){
				return false;
			}
		}
		return true;
	}

	public boolean asMateriasDoPageNotFoundPossuemTitulo() {
		for(int i=0; i<totalDematerias().size(); i++){
			if(totalDematerias().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	//Box Seleção O Globo//
	
	public void scrollAteSelecao() throws InterruptedException{
		esperaCarregar(4);
		executarScroll(getDriver().findElement(By.className("secaoOGlobo")).getLocation().toString());
	}
	
	public WebElement exibiuOBoxDoSelecaoOGlobo() {
		return getDriver().findElement(By.className("secaoOGlobo"));
	}
	
	private WebElement obterTituloDoBoxSelecaoOGlobo() {
		return exibiuOBoxDoSelecaoOGlobo().findElement(By.tagName("h2"));
	}

	public String exibiuOTituloDoSelecaoOGlobo() {
		return obterTituloDoBoxSelecaoOGlobo().getText();
	}
	
	public boolean oTituloSelecaoOGloboNaoPossuiUmLink() {
		try {
			obterTituloDoBoxSelecaoOGlobo().findElement(By.tagName("a"));
			return false;
		} catch (Exception e) {
			return true;
		}
	}
	
	public boolean oLinkDoTituloDoSelecaoOGloboEstaCorreto() {
		return !obterTituloDoBoxSelecaoOGlobo().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public List<WebElement> totalDeMateriasSelecaoOGlobo(){
		return exibiuOBoxDoSelecaoOGlobo().findElements(By.tagName("li"));
	}
	
	public boolean exibiuAsMateriasDoSelecaoOGlobo() {
		return totalDeMateriasSelecaoOGlobo().size() == 6;
	}

	public boolean asMateriasDoSelecaoOGloboPossuemTag() {
		for(int i=0; i<totalDeMateriasSelecaoOGlobo().size(); i++){
			if(totalDeMateriasSelecaoOGlobo().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean oTituloDasMateriasDoSelecaoOGloboPossuemUmLink() {
		for(int i=0; i<totalDeMateriasSelecaoOGlobo().size(); i++){
			if(!totalDeMateriasSelecaoOGlobo().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean osLinksDoTituloDasMateriasDoSelecaoOGloboSaoValidos() {
		for(int i=0; i<totalDeMateriasSelecaoOGlobo().size(); i++){
			if(totalDeMateriasSelecaoOGlobo().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean asMateriasDoSelecaoOGloboPossuemImagem() {
		for(int i=0; i<totalDeMateriasSelecaoOGlobo().size(); i++){
			if(!totalDeMateriasSelecaoOGlobo().get(i).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean oAltDasImagensDasMateriasDoSelecaoOGloboPossuemAutor() {
		for(int i=0; i<totalDeMateriasSelecaoOGlobo().size(); i++){
			if(!totalDeMateriasSelecaoOGlobo().get(i).findElement(By.tagName("img")).getAttribute("alt").contains("Foto:")){
				return false;
			}
		}
		return true;
	}

	public boolean asImagensDasMateriasDoSelecaoOGloboPossuemWidthDe189Px() {
		for(int i=0; i<totalDeMateriasSelecaoOGlobo().size(); i++){
			if(totalDeMateriasSelecaoOGlobo().get(i).findElement(By.tagName("img")).getAttribute("width").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean asImagensDasMateriasDoSelecaoOGloboPossuemHeightDe114Px() {
		for(int i=0; i<totalDeMateriasSelecaoOGlobo().size(); i++){
			if(totalDeMateriasSelecaoOGlobo().get(i).findElement(By.tagName("img")).getAttribute("height").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean asMateriasDoSelecaoOGloboPossuemTitulo() {
		for(int i=0; i<totalDeMateriasSelecaoOGlobo().size(); i++){
			if(totalDeMateriasSelecaoOGlobo().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	//Box Fotogaleria//
	public WebElement getBoxDeFotogaleriaDaCapa() {
		return getDriver().findElement(By.className("fotogalerias"));
	}

	public String oTituloDoBoxDeFotogaleriaEstaSendoExibido() {
		return getBoxDeFotogaleriaDaCapa().findElement(By.tagName("h2")).getText();
	}
	
	public List<WebElement> getListaDeFotogalerias() {
		return getBoxDeFotogaleriaDaCapa().findElement(By.id("fotogaleriaHome")).findElements(By.tagName("li"));
	}
	
	public boolean aPrimeiraImagemDasFotogaleriasEstaoSendoExibidas() {
		for(int i = 0; i<getListaDeFotogalerias().size(); i++){
			if(getListaDeFotogalerias().get(i).findElement(By.tagName("img")).getAttribute("src").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getTituloDaFotoDoBoxDeFotogaleriaDaCapa() throws InterruptedException {
		executarScroll(exibiuOBoxDoPageNotFound().getLocation());
		for(int i = 0; i<getListaDeFotogalerias().size(); i++){
			if(! getListaDeFotogalerias().get(i).findElement(By.tagName("h3")).isDisplayed()){
				return false;
			}
			obterBotaoProximoDoBoxDeFotogaleria().click();
			esperaCarregar(1);
		}
		return true;
	}
	
	public boolean exibiuTituloComNoMaximo33Caracteres() {
		for(int i = 0; i<getListaDeFotogalerias().size(); i++){
			if(getListaDeFotogalerias().get(i).findElement(By.tagName("a")).getText().length() > 50){
				return false;
			}
		}
		return true;
	}
	
	public boolean asFotogaleriasPossuemUmLink() {
		for(int i = 0; i<getListaDeFotogalerias().size(); i++){
			if(getListaDeFotogalerias().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean osLinksDasFotogaleriasSaoValidos() {
		for(int i = 0; i<getListaDeFotogalerias().size(); i++){
			if(getListaDeFotogalerias().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean estaSendoExibidaUmaListaDeFotogalerias() {
		return getListaDeFotogalerias().size() > 1;
	}

	public String getBotaoAnteriorDoBoxDeFotogaleria() {
		return getBoxDeFotogaleriaDaCapa().findElement(By.className("nav")).findElement(By.className("anterior")).getText();
	}
	
	public WebElement oPrimeiroBotaoDeNavegacaoEstaSendoExibido() {
		return getBoxDeFotogaleriaDaCapa().findElement(By.className("nav")).findElement(By.className("disabled"));
	}
	
	private WebElement obterBotaoProximoDoBoxDeFotogaleria() {
		return getBoxDeFotogaleriaDaCapa().findElement(By.className("nav")).findElement(By.className("proxima"));
	}

	public boolean getBotaoProximoDoBoxDeFotogaleria() {
		return obterBotaoProximoDoBoxDeFotogaleria().isDisplayed();
	}

	public String getTextoDaNavegacaoDoBoxDeFotogaleria() {
		return getBoxDeFotogaleriaDaCapa().findElement(By.className("nav")).findElement(By.tagName("span")).getText();
	}
}
