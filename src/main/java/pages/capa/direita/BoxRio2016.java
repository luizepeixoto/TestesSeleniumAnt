package pages.capa.direita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDaDireita;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxRio2016 extends AceitacaoAbstractTest {
	
	private String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
	
	public BoxRio2016(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement acessaBoxRio2016() {
		return getDriver().findElement(By.className("col-right")).findElement(By.className("boxRio2016"));
	}

	public boolean exibiuBoxRio2016() {
		return acessaBoxRio2016().isDisplayed();
	}
	
	public WebElement acessaImagemDoBoxRio2016() {
		return acessaBoxRio2016().findElement(By.tagName("a")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuImagemCropWidthHeightCorretamente(){
		
		int contadorDeErros=0;
		
		String cropEsperado = CropsCapaColunaDaDireita.boxRio2016.getCropProporcional();
		String widthEsperado = 	CropsCapaColunaDaDireita.boxRio2016.getWidth();	
		String heightEsperado = CropsCapaColunaDaDireita.boxRio2016.getHeight();
		
		String urlAtual = acessaImagemDoBoxRio2016().getAttribute("src");
		String widthAtual = acessaImagemDoBoxRio2016().getAttribute("width");	
		String heightAtual = acessaImagemDoBoxRio2016().getAttribute("height");
		
		if(!acessaImagemDoBoxRio2016().isDisplayed()){
			imprimirMensagemDeErroGenerica("Não exibiu imagem no box.");
			contadorDeErros++; 
		}
		
		if(!urlAtual.contains(cropEsperado)){
			imprimirMensagemDeErroDeUmaTag("crop da imagem do destaque do box", cropEsperado, urlAtual);
			contadorDeErros++; 
		}
		
		if(Integer.parseInt(widthAtual) > Integer.parseInt(widthEsperado)){
			imprimirMensagemDeErroDeUmaTag("width da imagem do destaque do box", widthEsperado, widthAtual);
			contadorDeErros++; 
		}
		
		if(Integer.parseInt(heightAtual) > Integer.parseInt(heightEsperado)){
			imprimirMensagemDeErroDeUmaTag("height da imagem do destaque do box", heightEsperado, heightAtual);
			contadorDeErros++; 
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public WebElement acessaInformacoesDoBox(){
		return acessaBoxRio2016().findElement(By.className("sobre")); 
	}
	
	public boolean exibiuOBoxComBackgroundCorreto() {
		
		String backgroundEsperado = "rgba(255, 255, 255, 0.8)"; 
		String backgroundAtual = acessaInformacoesDoBox().getCssValue("background-color");
		
		if(!backgroundAtual.equals(backgroundEsperado)){
			imprimirMensagemDeErroDeUmaTag("background do box", backgroundEsperado, backgroundAtual);
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuImagemDoRio2016Corretamente() {
		
		int contadorDeErros=0;
		
		WebElement logo2016 = acessaInformacoesDoBox().findElement(By.tagName("p"));
		
		String backgroundColorEsperado = "rgba(0, 0, 0, 0)";//transparent
		String widthLogoEsperado = "115px";
		String heightLogoEsperado = "24px";
		String marginTopLogoEsperado = "20px";
		String marginBottomLogoEsperado = "15px";
		
		String backgroundImageAtual = logo2016.getCssValue("background-image");
		String backgroundColorAtual = logo2016.getCssValue("background-color");
		String widthLogoAtual = logo2016.getCssValue("width");
		String heightLogoAtual = logo2016.getCssValue("height");
		String marginTopLogoAtual = logo2016.getCssValue("margin-top");
		String marginBottomLogoAtual = logo2016.getCssValue("margin-bottom");
		
		if(backgroundImageAtual.isEmpty()){
			imprimirMensagemDeErroGenerica("Não exibiu um logo. Valor atual: ["+backgroundImageAtual+"]");
			contadorDeErros++; 
		}
		
		if(!backgroundColorAtual.equals(backgroundColorEsperado)){
			imprimirMensagemDeErroDeUmaTag("transparência do logo", backgroundColorEsperado, backgroundColorAtual);
			contadorDeErros++; 
		}
		
		if(!widthLogoAtual.equals(widthLogoEsperado)){
			imprimirMensagemDeErroDeUmaTag("width do logo", widthLogoEsperado, widthLogoAtual);
			contadorDeErros++; 
		}
		
		if(!heightLogoAtual.equals(heightLogoEsperado)){
			imprimirMensagemDeErroDeUmaTag("height do logo", heightLogoEsperado, heightLogoAtual);
			contadorDeErros++; 
		}
		
		if(!marginTopLogoAtual.equals(marginTopLogoEsperado)){
			imprimirMensagemDeErroDeUmaTag("margin Top do logo", marginTopLogoEsperado, marginTopLogoAtual);
			contadorDeErros++; 
		}
		
		if(!marginBottomLogoAtual.equals(marginBottomLogoEsperado)){
			imprimirMensagemDeErroDeUmaTag("margin Bottom do logo", marginBottomLogoEsperado, marginBottomLogoAtual);
			contadorDeErros++; 
		}
		
		return validacaoDeErros(contadorDeErros);
	}

	public WebElement acessaMateria(){
		return acessaInformacoesDoBox().findElement(By.className("materia"));
	}
	
	public boolean exibiuUmaEditoriaNoBox() {
		
		int contadorDeErros = 0;
		
		String tamanhoFonteEsperada = "15px";
		String corFonteEsperada = "rgba(30, 150, 200, 1)";
		String textTransformEsperado = "uppercase";

		WebElement acessaEditoria = acessaMateria().findElement(By.tagName("p"));

		String tituloAtual = acessaEditoria.getText();
		String fonteAtual = acessaEditoria.getCssValue("font-family");
		String tamanhoFonteAtual = acessaEditoria.getCssValue("font-size");
		String corFonteAtual = acessaEditoria.getCssValue("color");
		String textTransformAtual = acessaEditoria.getCssValue("text-transform");
			
			if (tituloAtual.isEmpty()) {
				imprimirMensagemDeErroGenerica("Não exibiu editoria no box.");
				contadorDeErros++;
			}

			if (!fonteEsperada.equals(fonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("fonte do título da editoria", fonteEsperada, fonteAtual);
				contadorDeErros++;
			}

			if (!tamanhoFonteEsperada.equals(tamanhoFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte do editoria", tamanhoFonteEsperada, tamanhoFonteAtual);
				contadorDeErros++;
			}

			if (!corFonteEsperada.equals(corFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("cor da fonte da editoria", corFonteEsperada, corFonteAtual);
				contadorDeErros++;
			}

			if (!textTransformEsperado.equals(textTransformAtual)) {
				imprimirMensagemDeErroDeUmaTag("text transform da editoria", textTransformEsperado, textTransformAtual);
				contadorDeErros++;
			}

		return validacaoDeErros(contadorDeErros);
		
	}

	public boolean exibiuUmTituloNoBox() {
	
		int contadorDeErros = 0;
		int quantidadeMaximaDeCaracteresPermitidoNoTitulo = 73;
		
		String tamanhoFonteEsperada = "18px";
		String corFonteEsperada = "rgba(28, 49, 77, 1)";
	
		WebElement acessaTitulo = acessaMateria().findElement(By.className("titulo"));
	
		String tituloAtual = acessaTitulo.getText();
		String fonteAtual = acessaTitulo.getCssValue("font-family");
		String tamanhoFonteAtual = acessaTitulo.getCssValue("font-size");
		String corFonteAtual = acessaTitulo.getCssValue("color");
		int totalDeCaracteresDoTituloAtual = tituloAtual.length();
			
			if (tituloAtual.isEmpty()) {
				imprimirMensagemDeErroGenerica("Não exibiu título da matéria.");
				contadorDeErros++;
			}
	
			if (!fonteEsperada.equals(fonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("fonte do título da matéria", fonteEsperada, fonteAtual);
				contadorDeErros++;
			}
	
			if (!tamanhoFonteEsperada.equals(tamanhoFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título da matéria", tamanhoFonteEsperada, tamanhoFonteAtual);
				contadorDeErros++;
			}
	
			if (!corFonteEsperada.equals(corFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("cor da fonte do título da matéria", corFonteEsperada, corFonteAtual);
				contadorDeErros++;
			}
	
			if (totalDeCaracteresDoTituloAtual > quantidadeMaximaDeCaracteresPermitidoNoTitulo) {
				imprimirMensagemDeErroDeUmaTag("total de caracteres do título da matéria", Integer.toString(quantidadeMaximaDeCaracteresPermitidoNoTitulo), Integer.toString(totalDeCaracteresDoTituloAtual));
				contadorDeErros++;
			}
	
		return validacaoDeErros(contadorDeErros);
	
	}

	public boolean exibiuUmBotaoNoBox() {
		
		int contadorDeErros = 0;
		
		String tamanhoFonteEsperada = "16px";
		String corFonteEsperada = "rgba(30, 150, 200, 1)";
		String backgroundEsperado = "rgba(248, 248, 248, 1)";
		String textTransformEsperado = "uppercase";
		
		WebElement acessabotao = acessaMateria().findElement(By.className("more"));
	
		String tituloAtual = acessabotao.getText();
		String fonteAtual = acessabotao.getCssValue("font-family");
		String tamanhoFonteAtual = acessabotao.getCssValue("font-size");
		String corFonteAtual = acessabotao.getCssValue("color");
		String backgroundAtual = acessabotao.getCssValue("background-color");
		String textTransformAtual = acessabotao.getCssValue("text-transform");;
		
			if (tituloAtual.isEmpty()) {
				imprimirMensagemDeErroGenerica("Não exibiu título dentro do box.");
				contadorDeErros++;
			}
	
			if (!fonteEsperada.equals(fonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("fonte do título do botão", fonteEsperada, fonteAtual);
				contadorDeErros++;
			}
	
			if (!tamanhoFonteEsperada.equals(tamanhoFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título do botão", tamanhoFonteEsperada, tamanhoFonteAtual);
				contadorDeErros++;
			}
	
			if (!corFonteEsperada.equals(corFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("cor da fonte do título do botão", corFonteEsperada, corFonteAtual);
				contadorDeErros++;
			}
			
			if (!backgroundEsperado.equals(backgroundAtual)) {
				imprimirMensagemDeErroDeUmaTag("background do botão", backgroundEsperado, backgroundAtual);
				contadorDeErros++;
			}
			
			if (!textTransformEsperado.equals(textTransformAtual)) {
				imprimirMensagemDeErroDeUmaTag("textTransform do título do botão", textTransformEsperado, textTransformAtual);
				contadorDeErros++;
			}
	
		return validacaoDeErros(contadorDeErros);
	}
}