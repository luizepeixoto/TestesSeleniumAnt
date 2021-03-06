package pages.ela.capa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDestaques;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class CapaElaDestaques extends AceitacaoAbstractTest {

	public CapaElaDestaques(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement acessaBoxDeDestaque() {
		return getDriver().findElement(By.className("hightlightsEla"));
	}

	public boolean exibiuBoxDeDestaquesDasCapas() {
		return acessaBoxDeDestaque().isDisplayed();
	}

	public List<WebElement> listaComDestaques() {
		return acessaBoxDeDestaque().findElement(By.tagName("ul")).findElements(By.xpath("li[not(contains(@class, 'vertical'))]"));
	}

	public int totalDeDestaques() {
		return listaComDestaques().size();
	}

	public boolean exibiuEditoriaDoBoxDeDestaquesDasCapas() {

		int contadorDeErros = 0;

		String fonteEsperada = "OgloboXCondensed, Arial";
		String tamanhoFonteEsperada = "20px";
		String corFonteEsperada = "rgba(255, 25, 41, 1)";
		String textTransformEsperado = "uppercase";

		for (int i = 0; i < totalDeDestaques(); i++) {

			WebElement acessaEditoriaPosicaoAtual = listaComDestaques().get(i).findElement(By.tagName("h2"));

			String editoriaAtual = acessaEditoriaPosicaoAtual.getText();
			String fonteAtual = acessaEditoriaPosicaoAtual.getCssValue("font-family");
			String tamanhoFonteAtual = acessaEditoriaPosicaoAtual.getCssValue("font-size");
			String corFonteAtual = acessaEditoriaPosicaoAtual.getCssValue("color");
			String textTransformAtual = acessaEditoriaPosicaoAtual.getCssValue("text-transform");

			if (editoriaAtual.isEmpty()) {
				imprimirMensagemDeErroGenerica("Não exibiu editoria para a posição: "+(i+1)+".");
				contadorDeErros++;
			}

			if (!fonteEsperada.equals(fonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("fonte da editoria para a posição: "+(i+1)+"", fonteEsperada, fonteAtual);
				contadorDeErros++;
			}

			if (!tamanhoFonteEsperada.equals(tamanhoFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte da editoria para a posição: "+(i+1)+"", tamanhoFonteEsperada, tamanhoFonteAtual);
				contadorDeErros++;
			}

			if (!corFonteEsperada.equals(corFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("cor da fonte da editoria para a posição: "+(i+1)+"", corFonteEsperada, corFonteAtual);
				contadorDeErros++;
			}

			if (!textTransformEsperado.equals(textTransformAtual)) {
				imprimirMensagemDeErroDeUmaTag("text transform da fonte da editoria para a posição: "+(i+1)+"", textTransformEsperado, textTransformAtual);
				contadorDeErros++;
			}
		}

		return validacaoDeErros(contadorDeErros);
	}

	public boolean exibiuImagemNasChamadasDasBoxDeDestaquesDasCapas() {

		int contadorDeErros = 0;

		String cropEsperado = CropsDestaques.boxDestaqueCapaElaPequeno.cropProporcional();
		String widthEsperado = CropsDestaques.boxDestaqueCapaElaPequeno.getWidth();
		String heightEsperado = CropsDestaques.boxDestaqueCapaElaPequeno.getHeight();
		String classeAnimadaEsperada = "link animado-scale";

		for (int i = 0; i < totalDeDestaques(); i++) {

			WebElement acessaImagemAtual = listaComDestaques().get(i).findElement(By.tagName("a")).findElement(By.tagName("img"));
			WebElement acessaLinkDaImagem = listaComDestaques().get(i).findElement(By.tagName("a"));

			String urlAtual = acessaImagemAtual.getAttribute("src");
			String widthAtual = acessaImagemAtual.getAttribute("width");
			String heightAtual = acessaImagemAtual.getAttribute("height");
			String classeImagemAtual = acessaLinkDaImagem.getAttribute("class");

			if (!acessaImagemAtual.isDisplayed()) {
				imprimirMensagemDeErroGenerica("Não exibiu imagem para a posição: "+(i+1)+".");
				contadorDeErros++;
			}

			if (!urlAtual.contains(cropEsperado)) {
				imprimirMensagemDeErroGenerica("Não exibiu crop correto para a posição: "+(i+1)+".");
				contadorDeErros++;
			}

			if (!widthAtual.equals(widthEsperado)) {
				imprimirMensagemDeErroDeUmaTag("width da imagem na posição: "+(i+1)+"", widthEsperado, widthAtual);
				contadorDeErros++;
			}

			if (!heightAtual.equals(heightEsperado)) {
				imprimirMensagemDeErroDeUmaTag("height da imagem na posição: "+(i+1)+"", heightEsperado, heightAtual);
				contadorDeErros++;
			}

			if (!classeImagemAtual.equals(classeAnimadaEsperada)) {
				imprimirMensagemDeErroDeUmaTag("classe animação para imagem na posição: "+(i+1)+"", heightEsperado, heightAtual);
				contadorDeErros++;
			}
		}

		return validacaoDeErros(contadorDeErros);
	}
	
	public WebElement acessaPosicaoDoPrimeiroTitulo(){
		return listaComDestaques().get(0).findElement(By.tagName("div")).findElement(By.tagName("h3"));
	}
	
	public boolean exibiuTituloNasChamadasDosBoxDeDestaquesDasCapas() {

		int contadorDeErros = 0;
		
		int quantidadeMaximaDeCaracteresPermitidoNoTitulo = 25;
		String fonteEsperada = "OgloboXCondensed, Arial";
		String tamanhoFonteEsperada = "60px";
		String corFonteEsperada = "rgba(37, 49, 74, 1)";
		String textTransformEsperado = "uppercase";
		String corFonteLinkEsperada = "rgba(48, 48, 48, 1)";

		for (int i = 0; i < totalDeDestaques(); i++) {

			WebElement acessaTituloAtual = listaComDestaques().get(i).findElement(By.tagName("div")).findElement(By.tagName("h3"));
			WebElement acessaTituloComLinkAtual = acessaTituloAtual.findElement(By.tagName("a"));

			String tituloAtual = acessaTituloAtual.getText();
			String fonteAtual = acessaTituloAtual.getCssValue("font-family");
			String tamanhoFonteAtual = acessaTituloAtual.getCssValue("font-size");
			String corFonteAtual = acessaTituloAtual.getCssValue("color");
			String textTransformAtual = acessaTituloAtual.getCssValue("text-transform");
			String corFonteLinkAtual = acessaTituloComLinkAtual.getCssValue("color");
			
			int totalDeCaracteresDoTituloAtual = tituloAtual.length();
			
			if (tituloAtual.isEmpty()) {
				imprimirMensagemDeErroGenerica("Não exibiu título para a posição: " + (i + 1) + "");
				contadorDeErros++;
			}

			if (!fonteEsperada.equals(fonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("fonte do título para a posição: " + (i + 1) + "", fonteEsperada, fonteAtual);
				contadorDeErros++;
			}

			if (!tamanhoFonteEsperada.equals(tamanhoFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título para a posição: " + (i + 1) + "", tamanhoFonteEsperada, tamanhoFonteAtual);
				contadorDeErros++;
			}

			if (!corFonteEsperada.equals(corFonteAtual)) {
				imprimirMensagemDeErroDeUmaTag("cor da fonte do título para a posição: " + (i + 1) + "", corFonteEsperada, corFonteAtual);
				contadorDeErros++;
			}

			if (!textTransformEsperado.equals(textTransformAtual)) {
				imprimirMensagemDeErroDeUmaTag("text transform da fonte do título para a posição: " + (i + 1) + "", textTransformEsperado, textTransformAtual);
				contadorDeErros++;
			}

			if (!corFonteLinkEsperada.equals(corFonteLinkAtual)) {
				imprimirMensagemDeErroDeUmaTag("cor do link do título para a posição: " + (i + 1) + "", corFonteLinkEsperada, corFonteLinkAtual);
				contadorDeErros++;
			}
			
			if (totalDeCaracteresDoTituloAtual > quantidadeMaximaDeCaracteresPermitidoNoTitulo) {
				imprimirMensagemDeErroDeUmaTag("total de caracteres do título para a posição: " + (i + 1) + "", Integer.toString(quantidadeMaximaDeCaracteresPermitidoNoTitulo), Integer.toString(totalDeCaracteresDoTituloAtual));
				contadorDeErros++;
			}
		}

		return validacaoDeErros(contadorDeErros);
	}

	public boolean exibiuDescricaoNasChamadasDosBoxDeDestaquesDasCapas() {

		int contadorDeErros = 0;
		
		int quantidadeMaximaDeCaracteresPermitidoNaDescricao = 103;
		String fonteEsperada = "OgloboXCondensed, Arial";
		String tamanhoFonteDescricaoEsperada = "25px";
		String corFonteDescricaoEsperada = "rgba(48, 48, 48, 1)";
		String textTransformDescricaoEsperado = "none";

		for (int i = 0; i < totalDeDestaques(); i++) {

			WebElement acessaDescricaoAtual = listaComDestaques().get(i).findElement(By.tagName("div")).findElement(By.tagName("p"));

			String descricaoAtual = acessaDescricaoAtual.getText();
			int totalDeCaracteresDaDescricaoAtual = descricaoAtual.length();
			String fonteDescricaoAtual = acessaDescricaoAtual.getCssValue("font-family");
			String tamanhoFonteDescricaoAtual = acessaDescricaoAtual.getCssValue("font-size");
			String corFonteDescricaoAtual = acessaDescricaoAtual.getCssValue("color");
			String textTransformDescricaoAtual = acessaDescricaoAtual.getCssValue("text-transform");

			if (descricaoAtual.isEmpty()) {
				imprimirMensagemDeErroGenerica("Não exibiu descrição para a posição: " + (i + 1) + "");
				contadorDeErros++;
			}

			if (!fonteEsperada.equals(fonteDescricaoAtual)) {
				imprimirMensagemDeErroDeUmaTag("fonte do descrição para a posição: " + (i + 1) + "", fonteEsperada, fonteDescricaoAtual);
				contadorDeErros++;
			}

			if (!tamanhoFonteDescricaoEsperada.equals(tamanhoFonteDescricaoAtual)) {
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte do descrição para a posição: " + (i + 1) + "", tamanhoFonteDescricaoEsperada, tamanhoFonteDescricaoAtual);
				contadorDeErros++;
			}

			if (!corFonteDescricaoEsperada.equals(corFonteDescricaoAtual)) {
				imprimirMensagemDeErroDeUmaTag("cor da fonte do descrição para a posição: " + (i + 1) + "", corFonteDescricaoEsperada, corFonteDescricaoAtual);
				contadorDeErros++;
			}

			if (!textTransformDescricaoEsperado.equals(textTransformDescricaoAtual)) {
				imprimirMensagemDeErroDeUmaTag("text transform da fonte do descrição para a posição: " + (i + 1) + "", textTransformDescricaoEsperado, textTransformDescricaoAtual);
				contadorDeErros++;
			}
			
			if (totalDeCaracteresDaDescricaoAtual > quantidadeMaximaDeCaracteresPermitidoNaDescricao) {
				imprimirMensagemDeErroDeUmaTag("total de caracteres do título para a posição: " + (i + 1) + "", Integer.toString(quantidadeMaximaDeCaracteresPermitidoNaDescricao), Integer.toString(totalDeCaracteresDaDescricaoAtual));
				contadorDeErros++;
			}
		}

		return validacaoDeErros(contadorDeErros);
	}

	public WebElement acessaDestaquePrincipal() {
		return acessaBoxDeDestaque().findElement(By.tagName("ul")).findElement(By.className("vertical"));
	}

	public boolean exibiuChamadaPrincipalDosBoxDeDestaquesDasCapasCorretamente() {

		int contadorDeErros = 0;

		String fonteEsperada = "OgloboXCondensed, Arial";
		String tamanhoFonteTituloEsperada = "60px";
		String corFonteTituloEsperada = "rgba(37, 49, 74, 1)";
		String textTransformTituloEsperado = "uppercase";
		String alinhamentoEsperado = "center";
		String corLinkTituloEsperada = "rgba(255, 255, 255, 1)";
		
		String tamanhoFonteDescricaoEsperada = "25px";
		String corFonteDescricaoEsperada = "rgba(255, 255, 255, 1)";
		String textTransformDescricaoEsperado = "none";
		
		String cropEsperado = CropsDestaques.boxDestaqueCapaElaGrande.cropProporcional();
		String widthEsperado = CropsDestaques.boxDestaqueCapaElaGrande.getWidth();
		String heightEsperado = CropsDestaques.boxDestaqueCapaElaGrande.getHeight();
		String classeAnimadaEsperada = "link animado-scale";

		WebElement acessaTituloAtual = acessaDestaquePrincipal().findElement(By.tagName("div")).findElement(By.tagName("h3"));
		WebElement acessaTituloComLinkAtual = acessaTituloAtual.findElement(By.tagName("a"));

		WebElement acessaImagemAtual = acessaDestaquePrincipal().findElement(By.tagName("a")).findElement(By.tagName("img"));
		WebElement acessaLinkDaImagem = acessaDestaquePrincipal().findElement(By.tagName("a"));
		
		WebElement acessaDescricaoAtual = acessaDestaquePrincipal().findElement(By.tagName("div")).findElement(By.tagName("p"));

		String tituloaAtual = acessaTituloAtual.getText();
		String fonteAtual = acessaTituloAtual.getCssValue("font-family");
		String tamanhoFonteAtual = acessaTituloAtual.getCssValue("font-size");
		String corFonteAtual = acessaTituloAtual.getCssValue("color");
		String textTransformAtual = acessaTituloAtual.getCssValue("text-transform");
		String alinhamentoAtual = acessaTituloAtual.getCssValue("text-align");
		String corFonteLinkAtual = acessaTituloComLinkAtual.getCssValue("color");
		
		String descricaoAtual = acessaDescricaoAtual.getText();
		String fonteDescricaoAtual = acessaDescricaoAtual.getCssValue("font-family");
		String tamanhoFonteDescricaoAtual = acessaDescricaoAtual.getCssValue("font-size");
		String corFonteDescricaoAtual = acessaDescricaoAtual.getCssValue("color");
		String textTransformDescricaoAtual = acessaDescricaoAtual.getCssValue("text-transform");
		
		String urlAtual = acessaImagemAtual.getAttribute("src");
		String widthAtual = acessaImagemAtual.getAttribute("width");
		String heightAtual = acessaImagemAtual.getAttribute("height");
		String classeImagemAtual = acessaLinkDaImagem.getAttribute("class");
		
		try {
			if(acessaDestaquePrincipal().findElement(By.tagName("h2")).isDisplayed()){
				imprimirMensagemDeErroGenerica("Está sendo exibido título para a segunda posição.");
				return false;
			}
		} catch (Exception e) {
			
		}
		
		/*validação do título*/
		if (tituloaAtual.isEmpty()) {
			imprimirMensagemDeErroGenerica("Não exibiu título para a segunda posição.");
			contadorDeErros++;
		}
		
		if (!fonteEsperada.equals(fonteAtual)) {
			imprimirMensagemDeErroDeUmaTag("fonte do título para a segunda posição.", fonteEsperada, fonteAtual);
			contadorDeErros++;
		}

		if (!tamanhoFonteTituloEsperada.equals(tamanhoFonteAtual)) {
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título para a segunda posição.", tamanhoFonteTituloEsperada, tamanhoFonteAtual);
			contadorDeErros++;
		}

		if (!corFonteTituloEsperada.equals(corFonteAtual)) {
			imprimirMensagemDeErroDeUmaTag("cor da fonte do título para a segunda posição.", corFonteTituloEsperada, corFonteAtual);
			contadorDeErros++;
		}

		if (!textTransformTituloEsperado.equals(textTransformAtual)) {
			imprimirMensagemDeErroDeUmaTag("text transform da fonte do título para a segunda posição.", textTransformTituloEsperado, textTransformAtual);
			contadorDeErros++;
		}

		if (!alinhamentoEsperado.equals(alinhamentoAtual)) {
			imprimirMensagemDeErroDeUmaTag("alinhamento do título para a segunda posição.", alinhamentoEsperado, alinhamentoAtual);
			contadorDeErros++;
		}

		if (!corLinkTituloEsperada.equals(corFonteLinkAtual)) {
			imprimirMensagemDeErroDeUmaTag("cor do link do título para a segunda posição.", corLinkTituloEsperada, corFonteLinkAtual);
			contadorDeErros++;
		}
		
		/*validação da descrição*/
		if (descricaoAtual.isEmpty()) {
			imprimirMensagemDeErroGenerica("Não exibiu descrição para a segunda posição.");
			contadorDeErros++;
		}

		if (!fonteEsperada.equals(fonteDescricaoAtual)) {
			imprimirMensagemDeErroDeUmaTag("fonte do descrição para a segunda posição.", fonteEsperada, fonteDescricaoAtual);
			contadorDeErros++;
		}

		if (!tamanhoFonteDescricaoEsperada.equals(tamanhoFonteDescricaoAtual)) {
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do descrição para a segunda posição.", tamanhoFonteDescricaoEsperada, tamanhoFonteDescricaoAtual);
			contadorDeErros++;
		}

		if (!corFonteDescricaoEsperada.equals(corFonteDescricaoAtual)) {
			imprimirMensagemDeErroDeUmaTag("cor da fonte do descrição para a segunda posição.", corFonteDescricaoEsperada, corFonteDescricaoAtual);
			contadorDeErros++;
		}

		if (!textTransformDescricaoEsperado.equals(textTransformDescricaoAtual)) {
			imprimirMensagemDeErroDeUmaTag("text transform da fonte do descrição para a segunda posição.", textTransformDescricaoEsperado, textTransformDescricaoAtual);
			contadorDeErros++;
		}
		
		/*validação da imagem*/
		if (!acessaImagemAtual.isDisplayed()) {
			imprimirMensagemDeErroGenerica("Não exibiu imagem para a segunda posição.");
			contadorDeErros++;
		}

		if (!urlAtual.contains(cropEsperado)) {
			imprimirMensagemDeErroGenerica("Não exibiu crop correto para a segunda posição.");
			contadorDeErros++;
		}

		if (!widthAtual.equals(widthEsperado)) {
			imprimirMensagemDeErroDeUmaTag("width da imagem na segunda posição.", widthEsperado, widthAtual);
			contadorDeErros++;
		}

		if (!heightAtual.equals(heightEsperado)) {
			imprimirMensagemDeErroDeUmaTag("height da imagem na segunda posição.", heightEsperado, heightAtual);
			contadorDeErros++;
		}

		if (!classeImagemAtual.equals(classeAnimadaEsperada)) {
			imprimirMensagemDeErroDeUmaTag("classe animação para imagem na segunda posição.", heightEsperado, heightAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);

	}
	
	public boolean exibiuChamadaPrincipalDosBoxDeDestaquesComUmaTarjaCinza(){
		
		int contadorDeErros = 0;
		
		String corCinzaEsperada = "rgba(34, 34, 34, 1)";
		String backgroundEsperado = "rgba(0, 0, 0, 0.6)";
		
		WebElement acessaTarjaCinza = acessaDestaquePrincipal().findElement(By.tagName("div"));
		
		String corCinzaAtual = acessaTarjaCinza.getCssValue("color");
		String backgroundAtual = acessaTarjaCinza.getCssValue("background-color");
		
		if (!corCinzaAtual.equals(corCinzaEsperada)) {
			imprimirMensagemDeErroDeUmaTag("tarja cinza na segunda posição", corCinzaEsperada, corCinzaAtual);
			contadorDeErros++;
		}

		if (!backgroundAtual.equals(backgroundEsperado)) {
			imprimirMensagemDeErroDeUmaTag("background da tarja cinza na segunda posição", backgroundEsperado, backgroundAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
}