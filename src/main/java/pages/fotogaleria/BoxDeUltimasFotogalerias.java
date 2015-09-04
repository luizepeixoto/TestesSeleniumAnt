package pages.fotogaleria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.tealium.MarcacoesDoTealium;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.Device;
import br.com.infoglobo.pages.Navegador;

public class BoxDeUltimasFotogalerias extends MarcacoesDoTealium {
	
	public BoxDeUltimasFotogalerias() throws Exception {
		super();
	}
	
	public BoxDeUltimasFotogalerias(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public BoxDeUltimasFotogalerias(Navegador navegador, Device device) throws Exception {
		super(navegador, device);
	}
	
	public WebElement acessaClasseLastFrom(){
		return getDriver().findElement(By.id("lastFrom"));
	}
	
	public boolean exibiuBoxDeUltimasFotogalerias() {
		return acessaClasseLastFrom().isDisplayed();
	}
	
	public boolean exibiuTituloDeUltimasDe() {
		try {
			if(acessaClasseLastFrom().findElement(By.className("title")).isDisplayed()){
				imprimirMensagemDeErroGenerica("Está sendo exibido um título.");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	
	public List<WebElement> listaComTodasAsEditoriasdoMenu(){
		return acessaClasseLastFrom().findElement(By.className("editorias")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuMenuUltimasDeFotogalerias() {
		return listaComTodasAsEditoriasdoMenu().size() > 1;
	} 
	
	public boolean exibiuPrimeiraOpcaoTodasDoMenuUltimasDeFotogalerias() {
		return listaComTodasAsEditoriasdoMenu().get(0).getText().equals("Todas");
	} 
	
	public boolean exibiuPrimeiraOpcaoTodasEstaSelecionadaComoAtiva() {
		return listaComTodasAsEditoriasdoMenu().get(0).getAttribute("class").contains("active");
	}

	public boolean exibiuEditoriaNasOpcoesDoMenu() {
		for(int i=0; i<listaComTodasAsEditoriasdoMenu().size(); i++){
			if(listaComTodasAsEditoriasdoMenu().get(i).getText().isEmpty()){
				imprimirMensagemDeErro("título da editoria do menu", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuEditoriaNasOpcoesDoMenuComUmLink() {
		for(int i=1; i<listaComTodasAsEditoriasdoMenu().size(); i++){
			if(!listaComTodasAsEditoriasdoMenu().get(i).findElement(By.tagName("a")).isDisplayed()){
				imprimirMensagemDeErro("link no título da editoria do menu", i);
				return false;
			}
		}
		return true;
	}
	
	public List<WebElement> listaDeFotogalerias() {
		return acessaClasseLastFrom().findElement(By.className("cycle-carousel-wrap")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaListaDeFotogalerias() {
		return listaDeFotogalerias().size() > Integer.parseInt("1");
	}
	
	public int posicaoInicailDaListaDeFotogalerias() {
		/*o plugin utilizado no frontend sempre triplica o total de imagens do carrossel*/
		return listaDeFotogalerias().size() / 3;
	}

	public boolean exibiuUmaListaDeFotogaleriasComUmaImagem() {
		for(int i=posicaoInicailDaListaDeFotogalerias(); i < posicaoInicailDaListaDeFotogalerias() + 4; i++){ /*listaDeFotogalerias().size() trocado por amostragem de 4*/
			if(!listaDeFotogalerias().get(i).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("imagem", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkNasImagensENosTitulosDasFotogalerias() {
		for(int i=posicaoInicailDaListaDeFotogalerias(); i < posicaoInicailDaListaDeFotogalerias() + 4; i++){ /*listaDeFotogalerias().size() trocado por amostragem de 4*/
			
			if(!listaDeFotogalerias().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("imagem sem link", i);
				return false;
			}
			
			if(!listaDeFotogalerias().get(i).findElement(By.tagName("a")).findElement(By.tagName("span")).isDisplayed()){
				imprimirMensagemDeErro("titulo sem link", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAsFotosDaListaDeFotogaleriasComOCropCorreto() {
		for(int i=posicaoInicailDaListaDeFotogalerias(); i < posicaoInicailDaListaDeFotogalerias() + 4; i++){ /*listaDeFotogalerias().size() trocado por amostragem de 4*/
			String urlDaImagemAtual = listaDeFotogalerias().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("src");
			if(!urlDaImagemAtual.contains(CropsDeArticles.fotogaleriaBoxDeUltimas.cropProporcional())){
				imprimirMensagemDeErro("crop incorreto", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAsFotosDaListaDeFotogaleriasComOWidthCorreto() {
		for(int i=posicaoInicailDaListaDeFotogalerias(); i < posicaoInicailDaListaDeFotogalerias() + 4; i++){ /*listaDeFotogalerias().size() trocado por amostragem de 4*/
			String widthDaImagemAtual = listaDeFotogalerias().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("width");
			if(Integer.parseInt(widthDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaBoxDeUltimas.getWidth())){
				imprimirMensagemDeErroDeImagem(i, widthDaImagemAtual, CropsDeArticles.fotogaleriaBoxDeUltimas.getWidth());
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAsFotosDaListaDeFotogaleriasComOHeightCorreto() {
		for(int i=posicaoInicailDaListaDeFotogalerias(); i < posicaoInicailDaListaDeFotogalerias() + 4; i++){ /*listaDeFotogalerias().size() trocado por amostragem de 4*/
			String heightDaImagemAtual = listaDeFotogalerias().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("height");
			if(Integer.parseInt(heightDaImagemAtual) > Integer.parseInt(CropsDeArticles.fotogaleriaBoxDeUltimas.getHeight())){
				imprimirMensagemDeErroDeImagem(i, heightDaImagemAtual, CropsDeArticles.fotogaleriaBoxDeUltimas.getHeight());
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloParaAsOpcoesDeFotogalerias() {
		for(int i=posicaoInicailDaListaDeFotogalerias(); i < posicaoInicailDaListaDeFotogalerias() + 4; i++){ /*listaDeFotogalerias().size() trocado por amostragem de 4*/
			if(listaDeFotogalerias().get(i).findElement(By.className("label")).getAttribute("innerHTML").isEmpty()){
				imprimirMensagemDeErro("título", i);
				return false;
			}
		}
		return true;
	}

	public WebElement acessaNavegacao(){
		return acessaClasseLastFrom().findElement(By.className("carousel")).findElement(By.className("nav"));
	}
	
	public boolean exibiuPaginacaoDeFotogalerias() {
		return acessaNavegacao().isDisplayed();
	}

	public boolean exibiuUmaListaCircularNaPaginacaoDoBoxDeFotogalerias() {
		if(!acessaNavegacao().findElement(By.className("prev")).isDisplayed()){
			System.out.println("A navegação anterior está desativada");
			return false;
		}
		
		if(!acessaNavegacao().findElement(By.className("next")).isDisplayed()){
			System.out.println("A navegação próxima está desativada");
			return false;
		}
		
		return true;
	}

	public boolean exibiuUmaFotogaleriaDiferenteAoPaginarOBox() throws InterruptedException {
		
		int posicaoAtual = 0;
		int novaPosicaoAtual = 0; 
		
		for(int i=0; i < listaDeFotogalerias().size(); i++){ 
			
			if(listaDeFotogalerias().get(i).getAttribute("class").contains("cycle-slide-active")){
				posicaoAtual=i;
				break;
			}
		}
		
		System.out.println("A posição atual é [" + (posicaoAtual) + "]");
		
		getDriver().findElement(By.cssSelector("div.carousel > div.nav > a.next > i.fa.fa-angle-right")).click();
		esperaCarregar1Segundo();
		getDriver().findElement(By.cssSelector("div.carousel > div.nav > a.next > i.fa.fa-angle-right")).click();
		
		for(int y=0; y < listaDeFotogalerias().size(); y++){ 
			
			if(	listaDeFotogalerias().get(y).getAttribute("class").contains("cycle-slide-active")){
				novaPosicaoAtual=y;
				break;
			}
		}
		
		System.out.println("A nova posição é [" + (novaPosicaoAtual) + "]");
		
		if(posicaoAtual == novaPosicaoAtual){
			System.out.println("A posição do carrossel não mudou.");
			return false;
		}
		
		return true;
	} 
	
	public int todasDeEditoriasNoMenu(){
		return listaComTodasAsEditoriasdoMenu().size();
	}
	
	public boolean exibiuMaisDeUmaOpcaoDeEditoriasNoMenu() {
		return todasDeEditoriasNoMenu() >  Integer.parseInt("1");
	}
	
	public boolean exibiuAposClicarAsEditoriasComAClasseActive() throws InterruptedException {
		
		for(int i = 0; i < todasDeEditoriasNoMenu() - 1; i++){
			
			if(!listaComTodasAsEditoriasdoMenu().get(i).getAttribute("class").contains("active")){
				imprimirMensagemDeErro("a posição atual do menu com a classe active", i);
				return false;
			}
			
			esperaCarregar1Segundo();
			listaComTodasAsEditoriasdoMenu().get(i+1).findElement(By.tagName("a")).click();
			esperaCarregar1Segundo();
		}
		
		return true;
	}
	
	public void clicaNaPrimeiraOpcaoDoMenu(){
		listaComTodasAsEditoriasdoMenu().get(1).findElement(By.tagName("a")).click();
	}
	
	public boolean exibiuNoMinimoUmaFotogaleriaParaCadaEditoria() {
		
		clicaNaPrimeiraOpcaoDoMenu();
		
		for(int i = 1; i <= todasDeEditoriasNoMenu() - 1; i++){
			
			List<WebElement> listaComFotogaleriasDaPosicaoAtual = getDriver().findElement(By.className("carousel")).findElements(By.xpath("*[contains(@class, 'ng-scope')]"));
			
			if(listaComFotogaleriasDaPosicaoAtual.size() == Integer.parseInt("0")){
				imprimirMensagemDeErro("fotogaleria", i);
				return false;
			}
			
			if(i < todasDeEditoriasNoMenu() - 1){
				listaComTodasAsEditoriasdoMenu().get(i+1).findElement(By.tagName("a")).click();
			}
		}
		
		return true;
	}
	
	public WebElement acessaLinkDeMaisFotogalerias(){
		
		List<WebElement> listaTotalDeTagsADentroDoBoxDeFotogaleria = getDriver().findElement(By.className("boxFotogaleria")).findElements(By.tagName("a"));
		int totalDeTagsA = listaTotalDeTagsADentroDoBoxDeFotogaleria.size();
		
		WebElement acessaUltimaPosicao = listaTotalDeTagsADentroDoBoxDeFotogaleria.get(totalDeTagsA - Integer.parseInt("1"));
		return acessaUltimaPosicao;
	}
	
	public boolean exibiuUmTituloComUmLinkParaAEditoriaDeFotogaleria() {
		return acessaLinkDeMaisFotogalerias().isDisplayed();
	}
	
	public boolean exibiuUmTituloComUmLinkComOLayoutCorreto(){
		
		int contadorDeErros = 0;
		
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String tamanhoFonteEsperada = "15px";
		String corFonteEsperada = "rgba(30, 150, 200, 1)";
		String textTransformEsperado = "uppercase";
		
		String tituloAtual = acessaLinkDeMaisFotogalerias().getText();
		String fonteAtual = acessaLinkDeMaisFotogalerias().getCssValue("font-family");
		String tamanhoFonteAtual = acessaLinkDeMaisFotogalerias().getCssValue("font-size");
		String corFonteAtual = acessaLinkDeMaisFotogalerias().getCssValue("color");
		String textTransformAtual = acessaLinkDeMaisFotogalerias().getCssValue("text-transform");;
		
			if (tituloAtual.isEmpty()) {
				imprimirMensagemDeErroGenerica("Não exibiu título dentro do box.");
				contadorDeErros++;
			}
	
			if (!fonteEsperada.equals(fonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("fonte do título", fonteEsperada, fonteAtual);
				contadorDeErros++;
			}
	
			if (!tamanhoFonteEsperada.equals(tamanhoFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título", tamanhoFonteEsperada, tamanhoFonteAtual);
				contadorDeErros++;
			}
	
			if (!corFonteEsperada.equals(corFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("cor da fonte do título", corFonteEsperada, corFonteAtual);
				contadorDeErros++;
			}
			
			if (!textTransformEsperado.equals(textTransformAtual)) {
				imprimirMensagemDeErroDeUmaTag("textTransform do título", textTransformEsperado, textTransformAtual);
				contadorDeErros++;
			}
	
		return validacaoDeErros(contadorDeErros);
	}
}