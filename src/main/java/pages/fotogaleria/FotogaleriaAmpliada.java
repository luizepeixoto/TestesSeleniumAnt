package pages.fotogaleria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class FotogaleriaAmpliada extends AceitacaoAbstractTest {
	
	public FotogaleriaAmpliada() throws Exception {
		super();
	}
	
	public FotogaleriaAmpliada(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement acessaClasseFullGallery(){
		return getDriver().findElement(By.className("fullGalleryContainer"));
	}
	
	public boolean exibiuOpcaoDeAmpliarImagem() {
		return acessaClasseFullGallery().findElement(By.className("resize")).findElement(By.tagName("i")).isEnabled();
	}
	
	public List<WebElement> totalDeFotosDaFotogaleria(){
		return acessaClasseFullGallery().findElement(By.className("gallery")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public void clicarNaImagemParaAmpliar() {
		totalDeFotosDaFotogaleria().get(1).findElement(By.tagName("img")).click();
	} 
	
	public boolean exibiuBotaoDeReduzirAmpliacao(){
		return acessaClasseFullGallery().findElement(By.className("contract")).findElement(By.className("fa-compress")).isEnabled();
	}
	
	public WebElement acessaBoxDeNavegacao(){
		return acessaClasseFullGallery().findElements(By.className("nav")).get(1);
	}
	
	public boolean exibiuUmaListaCircularNaAmpliacaoDaPaginacaoDaFotogaleria() {
		if(!acessaBoxDeNavegacao().findElement(By.className("prev")).isDisplayed() || 
				acessaBoxDeNavegacao().findElements(By.tagName("a")).get(0).getAttribute("class").contains("disabled")){
			System.out.println("A navegação anterior está desativada");
			return false;
		}
		
		if(!acessaBoxDeNavegacao().findElement(By.className("next")).isDisplayed()|| 
				acessaBoxDeNavegacao().findElements(By.tagName("a")).get(1).getAttribute("class").contains("disabled")){
			System.out.println("A navegação próxima está desativada");
			return false;
		}
		
		return true;
	}
											   	
	public void clicarNaProximaFotoAmpliada(){
		
		getDriver().findElement(By.cssSelector("div.gallery > div.nav > a.next > i.fa.fa-angle-right")).click();
	}
	
	public void clicarNaFotoAnteriorAmpliada(){
		getDriver().findElement(By.cssSelector("div.gallery > div.nav > a.prev > i.fa.fa-angle-left")).click();
	}											
	
	public boolean exibiuCropHeightWidthCorretoParaAsImagens() throws InterruptedException{
		
		for(int i=1; i<totalDeFotosDaFotogaleria().size(); i++){
			
			String urlDaImagemAtual =  totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")).getAttribute("src");
			String widthDaImagemAtual =  totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")).getAttribute("width");
			String heightDaImagemAtual =  totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")).getAttribute("height");
			
			if(urlDaImagemAtual.contains(CropsDeArticles.fotogaleriaHorizontalAmpliada.cropProporcional())){
				
				if(Integer.parseInt(widthDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaHorizontalAmpliada.getWidth())){
					imprimirMensagemDeErroDeImagem(i, widthDaImagemAtual, CropsDeArticles.fotogaleriaHorizontalAmpliada.getWidth());
					return false;
				}
			
				if(Integer.parseInt(heightDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaHorizontalAmpliada.getHeight())){
					imprimirMensagemDeErroDeImagem(i, heightDaImagemAtual, CropsDeArticles.fotogaleriaHorizontalAmpliada.getHeight());
					return false;
				}
			
			} else 
				
			if(urlDaImagemAtual.contains(CropsDeArticles.fotogaleriaVerticalAmpliada.cropProporcional())){
					
				if(Integer.parseInt(widthDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaVerticalAmpliada.getWidth())){
					imprimirMensagemDeErroDeImagem(i, widthDaImagemAtual, CropsDeArticles.fotogaleriaVerticalAmpliada.getWidth());
					return false;
				}
			
				if(Integer.parseInt(heightDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaVerticalAmpliada.getHeight())){
					imprimirMensagemDeErroDeImagem(i, heightDaImagemAtual, CropsDeArticles.fotogaleriaVerticalAmpliada.getHeight());
					return false;
				}
			}
			else{
				imprimirMensagemDeErro("crop correto", i);
				return false;
			}
			
			esperaCarregar(2);
			executarMouseOver(totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")));
			clicarNaProximaFotoAmpliada();
			esperaCarregar(1);
		}
		
		return true;
	}
	
	public boolean exibiuTituloAutorETotalDeImagens() throws InterruptedException{
		
		for(int i= totalDeFotosDaFotogaleria().size() - 1; i > 1 ; i--){
			
			int totalDeFotos = totalDeFotosDaFotogaleria().size() - 1;
			
			esperaCarregar(1);
			executarMouseOver(totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")));
			WebElement descricaoDaFoto = totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("p"));
			String descricaoDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("p")).getAttribute("innerHTML");
			
			executarMouseOver(totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")));
			esperaCarregar(1);
			String totalDeFotosDaFotoAtual = getDriver().findElement(By.className("details")).findElement(By.className("caption")).getText(); 
			
			if(descricaoDaFotoAtual.isEmpty() || (! descricaoDaFoto.isDisplayed())){
				imprimirMensagemDeErro("descrição da foto", i);
				return false;
			}
			
			if(!totalDeFotosDaFotoAtual.equals(""+ Integer.toString(i) +" / "+ totalDeFotos)  ){
				imprimirMensagemDeErro("total de fotos", i);
				return false;
			}
			
			esperaCarregar(2);
			executarMouseOver(totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")));
			clicarNaFotoAnteriorAmpliada();
		}
		
		return true;
	}
	
	public void clicarParaFecharAmplicao(){
		getDriver().findElement(By.cssSelector("i.fa.fa-compress")).click();
	}

	public boolean exibiuTitulo() {
		return getDriver().findElement(By.className("details")).findElement(By.className("title")).isDisplayed();
	}
}