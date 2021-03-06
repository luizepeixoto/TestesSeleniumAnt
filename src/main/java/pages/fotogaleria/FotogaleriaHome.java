package pages.fotogaleria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.Device;
import br.com.infoglobo.pages.Navegador;

public class FotogaleriaHome extends Fotogaleria {
	
	public FotogaleriaHome() throws Exception {
		super();
	}
	
	public FotogaleriaHome(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public FotogaleriaHome(Navegador navegador, Device device) throws Exception {
		super(navegador, device);
	}
	
	public WebElement acessaClassePhotoGallery(){
		return getDriver().findElement(By.id("photoGallery")).findElement(By.className("large-16"));
	}

	public boolean exibiuTituloDeRecomendadas() {
		return !acessaClassePhotoGallery().findElement(By.className("title")).getText().isEmpty();
	}
	
	public List<WebElement> listaTotalDeFotogalerias(){
		return acessaClassePhotoGallery().findElement(By.className("recommended")).findElements(By.tagName("li"));
	}
	
	public int totalDeFotogalerias(){
		return listaTotalDeFotogalerias().size();
	}
	
	public boolean exibiuUmaListaDeFotogalerias() {
		return totalDeFotogalerias() > Integer.parseInt("2");
	}

	public boolean exibiuUmaImagemParaCadaUmaDasFotogalerias() {
		
		for(int i = 0; i < totalDeFotogalerias(); i++){
			
			if(!listaTotalDeFotogalerias().get(i).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("imagem da fotogaleria", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuUmLinkNasImagensDasFotogalerias() {
		
		for(int i = 0; i < totalDeFotogalerias(); i++){
			
			if(!listaTotalDeFotogalerias().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("imagem da fotogaleria dem link", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuCropCorretoParaAsImagensDasFotogalerias() {
		
		String cropEsperado = CropsDeArticles.fotogaleriaHomeDeUltimasRecomendadas.cropProporcional();
		
		for(int i = 0; i < totalDeFotogalerias(); i++){
			
			String urlDaFotoNaPosicaoAtual =  listaTotalDeFotogalerias().get(i).findElement(By.tagName("img")).getAttribute("src");
			
			if(!urlDaFotoNaPosicaoAtual.contains(cropEsperado)){
				imprimirMensagemDeErro("imagem da com crop incorreto", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuWidthCorretoParaAsImagensDasFotogalerias() {
		
		String widthEsperado =  CropsDeArticles.fotogaleriaHomeDeUltimasRecomendadas.getWidth();
		
		for(int i = 0; i < totalDeFotogalerias(); i++){
			
			String widthAtual =  listaTotalDeFotogalerias().get(i).findElement(By.tagName("img")).getAttribute("width");
			
			if(Integer.parseInt(widthAtual) > Integer.parseInt(widthEsperado) || Integer.parseInt(widthAtual) == Integer.parseInt("0")){
				imprimirMensagemDeErro("imagem com width incorreto", i);
				imprimirMensagemDeErroDeImagem(i, widthAtual, widthEsperado);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuHeightCorretoParaAsImagensDasFotogalerias() {
		
		String heightEsperado =  CropsDeArticles.fotogaleriaHomeDeUltimasRecomendadas.getHeight();
		
		for(int i = 0; i < totalDeFotogalerias(); i++){
			
			String heightAtual =  listaTotalDeFotogalerias().get(i).findElement(By.tagName("img")).getAttribute("height");
			
			if(Integer.parseInt(heightAtual) > Integer.parseInt(heightEsperado) || Integer.parseInt(heightAtual) == Integer.parseInt("0")){
				imprimirMensagemDeErro("imagem com height incorreto", i);
				imprimirMensagemDeErroDeImagem(i, heightAtual, heightEsperado);
				return false;
			}
		}
		
		return true;
	}
	
	public boolean exibiuEfeitoDeHoverParaAsImagensDasFotogalerias() {
		
		String classeEsperada = "hover";
		
		for(int i = 0; i < totalDeFotogalerias(); i++){
			
			String classeHoverImagemAtual =  listaTotalDeFotogalerias().get(i).findElement(By.tagName("span")).getAttribute("class");
			
			if(!classeHoverImagemAtual.equals(classeEsperada)){
				imprimirMensagemDeErro("classe hover para a imagem", i);
				return false;
			}
		}
		
		return true;
	}


	public boolean exibiuUmTituloParaAsImagensDasFotogalerias() {
		
		for(int i = 0; i < totalDeFotogalerias(); i++){
			
			String tituloAtual =  listaTotalDeFotogalerias().get(i).findElement(By.className("label")).getText();
			
			if(tituloAtual.isEmpty()){
				imprimirMensagemDeErro("título para a imagem", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuFonteETamanhoDaImagemCorretamenteParasTituloDasFotogalerias() {
		
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String tamanhoDaFonteEsperado = "37px";
		String estiloEsperado = "italic";
		String corEsperada = "rgba(255, 255, 255, 1)";
		
		for(int i = 0; i < totalDeFotogalerias(); i++){
			
			String fonteAtual =  listaTotalDeFotogalerias().get(i).findElement(By.className("label")).getCssValue("font-family");
			String tamanhoDaFonteAtual = listaTotalDeFotogalerias().get(i).findElement(By.className("label")).getCssValue("font-size");
			String estiloDaFonteAtual = listaTotalDeFotogalerias().get(i).findElement(By.className("label")).getCssValue("font-style");
			String corDaFonteAtual = listaTotalDeFotogalerias().get(i).findElement(By.className("label")).getCssValue("color");
			
					
			if(!fonteAtual.equals(fonteEsperada)){
				imprimirMensagemDeErro("tipo correto da fonte", i);
				return false;
			}
			
			if(!tamanhoDaFonteAtual.equals(tamanhoDaFonteEsperado)){
				imprimirMensagemDeErro("tamanho correto da fonte", i);
				return false;
			}
			
			if(!estiloDaFonteAtual.equals(estiloEsperado)){
				imprimirMensagemDeErro("estilo correto da fonte", i);
				return false;
			}
			
			if(!corDaFonteAtual.equals(corEsperada)){
				imprimirMensagemDeErro("cor correta da fonte", i);
				return false;
			}
		}
		
		return true;
		
	}
	
	public WebElement acessaClassePopular(){
		return getDriver().findElement(By.id("photoGallery")).findElement(By.className("popular"));
	}
	
	public boolean exibiuOBoxDeMaisVistas(){
		return acessaClassePopular().isDisplayed();
	}
	
	public String exibiuTituloDeMaisVistas(){
		return acessaClassePopular().findElement(By.className("title")).getText();
	}

	public List<WebElement> listaDeFotogaleriasMaisVistas(){
		return acessaClassePopular().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public int totalDeFotogaleriasMaisVistas(){
		return listaDeFotogaleriasMaisVistas().size();
	}
	
	public boolean exibiuTresFotogaleriasNoBoxDeMaisVistas() {
		return totalDeFotogaleriasMaisVistas() == Integer.parseInt("3");
	}

	public boolean exibiuUmaImagemParaCadaUmaDasFotogaleriasDoBoxDeMaisVistas() {

		for(int i=0; i < totalDeFotogaleriasMaisVistas(); i++){
			
			WebElement imagemAtual = listaDeFotogaleriasMaisVistas().get(i).findElement(By.tagName("img"));
			
			if(!imagemAtual.isDisplayed()){
				imprimirMensagemDeErro("imagem", i);
				return false;
			}
		}
		
		return true;
	}
	
	public boolean exibiuUmLinkNasImagensDasFotogaleriasDoBoxDeMaisVistas() {

		for(int i=0; i < totalDeFotogaleriasMaisVistas(); i++){
			
			WebElement imagemAtualComLink = listaDeFotogaleriasMaisVistas().get(i).findElement(By.tagName("a")).findElement(By.tagName("img"));
			
			if(!imagemAtualComLink.isDisplayed()){
				imprimirMensagemDeErro("link da imagem", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuCropCorretoParaAsImagensDasFotogaleriasDoBoxDeMaisVistas() {
		
		String cropEsperado = CropsDeArticles.fotogaleriaHomeDeUltimasMaisVistas.cropProporcional();
		
		for(int i=0; i < totalDeFotogaleriasMaisVistas(); i++){
			
			String urlDaimagemAtual = listaDeFotogaleriasMaisVistas().get(i).findElement(By.tagName("img")).getAttribute("src");
			
			if(!urlDaimagemAtual.contains(cropEsperado)){
				imprimirMensagemDeErro("imagem com crop correto", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuWidthCorretoParaAsImagensDasFotogaleriasDoBoxDeMaisVistas() {

		String widthEsperado = CropsDeArticles.fotogaleriaHomeDeUltimasMaisVistas.getWidth();
		
		for(int i=0; i < totalDeFotogaleriasMaisVistas(); i++){
			
			String widthDaImagemAtual = listaDeFotogaleriasMaisVistas().get(i).findElement(By.tagName("img")).getAttribute("width");
			
			if(Integer.parseInt(widthDaImagemAtual) > Integer.parseInt(widthEsperado) && Integer.parseInt(widthDaImagemAtual) == Integer.parseInt("0")){
				imprimirMensagemDeErro("imagem com width incorreto", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuHeightCorretoParaAsImagensDasFotogaleriasDoBoxDeMaisVistas() {
		
		String heightEsperado = CropsDeArticles.fotogaleriaHomeDeUltimasMaisVistas.getHeight();
		
		for(int i=0; i < totalDeFotogaleriasMaisVistas(); i++){
			
			String widthDaImagemAtual = listaDeFotogaleriasMaisVistas().get(i).findElement(By.tagName("img")).getAttribute("height");
			
			if(Integer.parseInt(widthDaImagemAtual) > Integer.parseInt(heightEsperado) && Integer.parseInt(widthDaImagemAtual) == Integer.parseInt("0")){
				imprimirMensagemDeErro("imagem com height incorreto", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuUmTituloParaAsImagensDasFotogaleriasDoBoxDeMaisVistas() {
		
		for(int i=0; i < totalDeFotogaleriasMaisVistas(); i++){
			
			String tituloAtual = listaDeFotogaleriasMaisVistas().get(i).findElement(By.className("label")).getText();
			
			if(tituloAtual.isEmpty()){
				imprimirMensagemDeErro("título", i);
				return false;
			}
		}
		
		return true;
	}

	public boolean exibiuFonteETamanhoDaImagemCorretamenteParasTituloDasFotogaleriasDoBoxDeMaisVistas() {
		
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String tamanhoDaFonteEsperado = "20px";
		String estiloEsperado = "italic";
		String corEsperada = "rgba(255, 255, 255, 1)";
		
		for(int i = 0; i < totalDeFotogaleriasMaisVistas(); i++){
			
			String fonteAtual =  listaDeFotogaleriasMaisVistas().get(i).findElement(By.className("label")).getCssValue("font-family");
			String tamanhoDaFonteAtual = listaDeFotogaleriasMaisVistas().get(i).findElement(By.className("label")).getCssValue("font-size");
			String estiloDaFonteAtual = listaDeFotogaleriasMaisVistas().get(i).findElement(By.className("label")).getCssValue("font-style");
			String corDaFonteAtual = listaDeFotogaleriasMaisVistas().get(i).findElement(By.className("label")).getCssValue("color");
					
			if(!fonteAtual.equals(fonteEsperada)){
				imprimirMensagemDeErro("tipo correto da fonte", i);
				return false;
			}
			
			if(!tamanhoDaFonteAtual.equals(tamanhoDaFonteEsperado)){
				imprimirMensagemDeErro("tamanho correto da fonte", i);
				return false;
			}
			
			if(!estiloDaFonteAtual.equals(estiloEsperado)){
				imprimirMensagemDeErro("estilo correto da fonte", i);
				return false;
			}
			
			if(!corDaFonteAtual.equals(corEsperada)){
				imprimirMensagemDeErro("cor correta da fonte", i);
				return false;
			}
		}
		
		return true;
		
	}

	public boolean exibiuBannerArroba() {
		return getDriver().findElement(By.className("arroba")).findElement(By.className("publicidade-container")).isDisplayed();
	}
	
	public String exibiuTituloDaEditoriaFotogalerias() {
		return getDriver().findElement(By.id("bt-editoria")).getText();
	}
	
	public boolean exibiuMenuDeEditorias() {
		try {
			getDriver().findElement(By.className("navegacao-central")).isDisplayed();
			System.out.println("Exibiu o menu de editorias.");
			return false;
		} catch (Exception e) {
			
		}
		
		return true;
	}
	
	public boolean exibiuMenuLateral(){
		
		WebElement menuLateral = getDriver().findElement(By.className("navegacao-container")).findElement(By.tagName("a"));
		
		executarMouseOver(menuLateral);
		
		String pegarClasseStatus = getDriver().findElement(By.className("navegacao-container")).findElement(By.id("bt-menu")).getAttribute("class");
		String pegarClasseMenu = getDriver().findElement(By.className("navegacao-container")).findElement(By.tagName("nav")).getAttribute("class");
		
		if(!(pegarClasseStatus.contains("aberta")) || !(pegarClasseMenu.contains("aberta"))){
			imprimirMensagemDeErroGenerica("Menu lateral não está abrindo");
			return false;
		}
		
		return true;
	}
}