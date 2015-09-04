package pages.fotogaleria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.Device;
import br.com.infoglobo.pages.Navegador;

public class Fotogaleria extends BoxDeUltimasFotogalerias {
	
	public Fotogaleria() throws Exception {
		super();
	}
	
	public Fotogaleria(Navegador navegador) throws Exception {
		super(navegador);
	}

	public Fotogaleria(Navegador navegador, Device device) throws Exception {
		super(navegador, device);
	}

	public WebElement acessaClasseFullGallery(){
		return getDriver().findElement(By.className("fullGalleryContainer"));
	}
	
	public boolean exibiuOpcaoDeAmpliarImagem() {
		return acessaClasseFullGallery().findElement(By.className("resize")).findElement(By.tagName("i")).isEnabled();
	}
	
	public WebElement acessaBoxDeDetalhes(){
		return acessaClasseFullGallery().findElement(By.className("details"));
	}
	
	public WebElement acessaTitulo(){
		return acessaBoxDeDetalhes().findElement(By.className("title"));
	}
	
	public WebElement acessaBoxDeNavegacao(){
		return acessaBoxDeDetalhes().findElement(By.className("nav"));
	}
	
	public boolean exibiuTituloDaFotogaleria(){
		return !acessaTitulo().getText().isEmpty();
	}
	
	public boolean exibiuTotalDeFotosDaFotogaleria(){
		return !acessaBoxDeDetalhes().findElement(By.className("caption")).getText().isEmpty();
	}
	
	public boolean exibiuUmaListaCircularNaPaginacaoDaFotogaleria() {
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
	
	public List<WebElement> totalDeFotosDaFotogaleria(){
		return acessaClasseFullGallery().findElement(By.className("gallery")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public void clicarNaProximaFoto(){
		getDriver().findElement(By.cssSelector("i.fa.fa-angle-right")).click();
	}
	
	public boolean exibiuCropHeightWidthCorretoParaAsImagens() throws InterruptedException{
		
		for(int i=1; i<totalDeFotosDaFotogaleria().size(); i++){
			
			String urlDaImagemAtual =  totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")).getAttribute("src");
			String widthDaImagemAtual =  totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")).getAttribute("width");
			String heightDaImagemAtual =  totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("img")).getAttribute("height");
			
			if(urlDaImagemAtual.contains(CropsDeArticles.fotogaleriaHorizontal.cropProporcional())){
				
				if(Integer.parseInt(widthDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaHorizontal.getWidth())){
					imprimirMensagemDeErroDeImagem(i, widthDaImagemAtual, CropsDeArticles.fotogaleriaHorizontal.getWidth());
					return false;
				}
			
				if(Integer.parseInt(heightDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaHorizontal.getHeight())){
					imprimirMensagemDeErroDeImagem(i, heightDaImagemAtual, CropsDeArticles.fotogaleriaHorizontal.getHeight());
					return false;
				}
			
			} else 
				
			if(urlDaImagemAtual.contains(CropsDeArticles.fotogaleriaVertical.cropProporcional())){
					
				if(Integer.parseInt(widthDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaVertical.getWidth())){
					imprimirMensagemDeErroDeImagem(i, widthDaImagemAtual, CropsDeArticles.fotogaleriaVertical.getWidth());
					return false;
				}
			
				if(Integer.parseInt(heightDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaVertical.getHeight())){
					imprimirMensagemDeErroDeImagem(i, heightDaImagemAtual, CropsDeArticles.fotogaleriaVertical.getHeight());
					return false;
				}
			}
			else{
				imprimirMensagemDeErro("crop correto", i);
				return false;
			}
			
			clicarNaProximaFoto();
			esperaCarregar1Segundo();
		}
		
		return true;
	}
	
	public boolean exibiuTituloAutorETotalDeImagens() throws InterruptedException{
		
		for(int i=1; i<totalDeFotosDaFotogaleria().size(); i++){
			
			int totalDeFotos = totalDeFotosDaFotogaleria().size() - 1;
			String descricaoDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("p")).getText();
			String fonteDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("p")).findElement(By.tagName("span")).getText();
			String corDaFonteDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.tagName("p")).findElement(By.tagName("span")).getCssValue("color");
			String totalDeFotosDaFotoAtual = getDriver().findElement(By.cssSelector("div.caption")).getText();
			
			if(descricaoDaFotoAtual.isEmpty()){
				imprimirMensagemDeErro("descrição da foto", i);
				return false;
			}
			
			if(fonteDaFotoAtual.isEmpty()){
				imprimirMensagemDeErro("fonte/autor da foto", i);
				return false;
			}
			
			if(!corDaFonteDaFotoAtual.equals("rgba(172, 172, 172, 1)")){
				imprimirMensagemDeErro("cor da fonte/autor da foto", i);
				return false;
			}
			
			if(!totalDeFotosDaFotoAtual.equals(""+ Integer.toString(i) +" / "+ totalDeFotos)  ){
				imprimirMensagemDeErro("total de fotos", i);
				return false;
			}
			
			clicarNaProximaFoto();
			esperaCarregar1Segundo();
		}
		
		return true;
	}
	
	public WebElement AcessaSuperLeaderboard() {
		return getDriver().findElement(By.className("super-leaderboard")).findElement(By.className("publicidade-container"));
	}
	
	public boolean exibiuBannerSuperLeaderboard() {
		return AcessaSuperLeaderboard().isDisplayed();
	}
	
	public boolean exibiuFundoPretoParaOBanner() {
		String corEsperada = "rgba(0, 0, 0, 1)";
		return getDriver().findElement(By.className("super-leaderboard")).getCssValue("background-color").equals(corEsperada);
	}

	public boolean exibiuChamadaDeLinkRelacionado() {
		return acessaClasseFullGallery().findElement(By.className("article")).isDisplayed();
	}
	
	public boolean exibiuTituloLeiaAMateria(){
		String tituloEsperado = "LEIA A MATÉRIA";
		String tituloAtual = acessaClasseFullGallery().findElement(By.className("article")).findElement(By.tagName("span")).getText();
		String corDoTituloEsperada = "rgba(30, 150, 200, 1)";
		String corDoTituloAtual = acessaClasseFullGallery().findElement(By.className("article")).findElement(By.tagName("span")).getCssValue("color");
		
		if(!tituloEsperado.equals(tituloAtual)){
			System.out.println("Titulo leia mais não está sendo exibido corretamente. Titulo atual: "+tituloAtual+"");
			return false;
		}
		
		if(!corDoTituloEsperada.equals(corDoTituloAtual)){
			System.out.println("Cor esperada: "+corDoTituloEsperada+". Cor do titulo atual: "+corDoTituloAtual+"");
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBanner(){
		try {
			if(acessaClasseLastFrom().findElement(By.id("bannerBoxFotogaleria")).isDisplayed()){
				imprimirMensagemDeErroGenerica("Exibiu banner no box de últimas");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean exibiuTituloParaAMateriaRelacionada() {
		return !acessaClasseFullGallery().findElement(By.className("article")).findElements(By.tagName("span")).get(1).getText().isEmpty();
	}

	public boolean exibiuUmLinkParaOTituloDaMateriaRelacionada() {
		return !acessaClasseFullGallery().findElement(By.className("article")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	/*Testes para o Ipad*/
	
	public boolean naoExibiuOpcaoDeAmpliarImagemParaOIpad(){
		
		if(acessaBoxDeNavegacao().findElement(By.className("prev")).isDisplayed()){
			System.out.println("A navegação anterior está sendo exibida");
			return false;
		}
		
		if(acessaBoxDeNavegacao().findElement(By.className("next")).isDisplayed()){
			System.out.println("A navegação próxima está sendo exibida");
			return false;
		}
		
		return true;
	}
	
	public WebElement acessaClasseFullGalleryNoIpad() {
		return acessaClasseFullGallery().findElement(By.className("gallery"));
	}
	
	public boolean exibiuTituloDaFotogaleriaNoIpad() {
		return !acessaClasseFullGalleryNoIpad().findElement(By.className("ipad")).getText().isEmpty();
	}
	
	public boolean exibiuTotalDeFotosDaFotogaleriaDoIPad(){
		return !acessaClasseFullGalleryNoIpad().findElement(By.className("caption")).getAttribute("innerHTML").isEmpty();
	}
	
	public List<WebElement> totalDeFotosDaFotogaleriaNoIpad(){
		return acessaClasseFullGalleryNoIpad().findElement(By.className("cycle-slideshow")).findElements(By.tagName("li"));
	}
	
	public WebElement acessaBoxDeUltimas(){
		return getDriver().findElement(By.className("boxFotogaleria"));
	}
	
	public boolean exibiuLinkDeMaisFotogalerias(){
		try {
			acessaBoxDeUltimas().findElement(By.className("link")).isDisplayed();
				imprimirMensagemDeErroGenerica("Exibiu link de ver mais fotogalerias");
				return false;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public WebElement acessaClasseSharing(){
		return getDriver().findElement(By.className("sharing"));
	}
}