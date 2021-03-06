package pages.materia.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxListaDeFatosInlinePadrao extends AceitacaoAbstractTest {
	
	int quantidadeDeVezesAPaginar = quantidadeDeFatos() - Integer.parseInt("1");
	
	public BoxListaDeFatosInlinePadrao() throws Exception {
		super();
	}
	
	public BoxListaDeFatosInlinePadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement acessaBoxDeListaDeFatosInline() {
		return getDriver().findElement(By.className("listadeFatosMateria"));
	}
	
	public boolean exibiuBoxDeListaDeFatosInline(){
		return acessaBoxDeListaDeFatosInline().isDisplayed();
	}
	
	public WebElement acessaCabecalhoDaListaDeFatosInline() {
		return acessaBoxDeListaDeFatosInline().findElement(By.className("headList"));
	}
	
	public WebElement acessaTituloDaListaDeFatosInline() {
		return acessaCabecalhoDaListaDeFatosInline().findElement(By.tagName("h2")).findElement(By.tagName("a"));
	}
	
	public boolean exibiuTituloDaListaDeFatosInline() {
		return acessaTituloDaListaDeFatosInline().isDisplayed();
	}

	public boolean exibiuLayoutCorretoParaOTituloDaListaDeFatosInline() {
		
		int contadorDeErros = 0;
		
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String corFonteEsperada = "rgba(51, 51, 51, 1)";
		String tamanhoFonteEsperada = "32px";
		
		String fonteAtual = acessaTituloDaListaDeFatosInline().getCssValue("font-family");
		String corFonteAtual = acessaTituloDaListaDeFatosInline().getCssValue("color");
		String tamanhoFonteAtual = acessaTituloDaListaDeFatosInline().getCssValue("font-size");
		
		if (!fonteEsperada.equals(fonteAtual)) {
			imprimirMensagemDeErroDeUmaTag("fonte do título", fonteEsperada, fonteAtual);
			contadorDeErros++;
		}
		
		if (!corFonteEsperada.equals(corFonteAtual)) {
			imprimirMensagemDeErroDeUmaTag("cor da fonte do título", corFonteEsperada, corFonteAtual);
			contadorDeErros++;
		}
		
		if (!tamanhoFonteEsperada.equals(tamanhoFonteAtual)) {
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título", tamanhoFonteEsperada, tamanhoFonteAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public WebElement acessaPaginaçao(){
		return acessaCabecalhoDaListaDeFatosInline().findElement(By.className("passadores"));
	}
	
	public boolean exibiuPaginacaoDaListaDeFatosInline() {
		return acessaPaginaçao().isDisplayed();
	}

	public boolean exibiuPaginacaoDoPrimeiroFatoDeFormaCorreta() {
		
		int contadorDeErros = 0;
		
		String classeDesabilitadaEsperada = "prev disabled";
		String classeHabilitadaEsperada = "next";
		
		List<WebElement> paginacao = acessaPaginaçao().findElements(By.tagName("a"));
		WebElement acessaSetaDaEsquerda = paginacao.get(0);
		WebElement acessaSetaDaDireita = paginacao.get(1);
		
		if(!(acessaSetaDaEsquerda.isDisplayed()) ||  !(acessaSetaDaEsquerda.getAttribute("class").equals(classeDesabilitadaEsperada))){
			imprimirMensagemDeErroGenerica("Não exibiu paginação para a esquerda de forma correta.");
			contadorDeErros++;
		}
		
		if(!(acessaSetaDaDireita.isDisplayed()) ||  !(acessaSetaDaDireita.getAttribute("class").equals(classeHabilitadaEsperada))){
			imprimirMensagemDeErroGenerica("Não exibiu paginação para a esquerda de forma correta.");
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public List<WebElement> listaComFatos(){
		return acessaBoxDeListaDeFatosInline().findElements(By.xpath("//*[contains(@class, 'list0')]//ul[contains(@class, 'cycle-slide')][not(contains(@class, 'cycle-sentinel'))]"));
	}
	
	public int quantidadeDeFatos(){
		return listaComFatos().size();
	}
	
	public void clicarNoProximoItem(){
		getDriver().findElement(By.cssSelector("a.next")).click();
	}
	
	public void clicarNoItemAnterior(){
		getDriver().findElement(By.cssSelector("a.prev")).click();
	}
	
	public boolean exibiuCropWidthEHeightCorretosParaAsImagensDeCadaFatos() throws InterruptedException {
		
		int contadorDeErros = 0;
				
		String cropHorizontal = CropsDeArticles.listaDeFatosHorizontalInline.cropProporcional();
		String cropVertical = CropsDeArticles.listaDeFatosVerticalInline.cropProporcional();
		
		String fonteLegendaEsperada = "Georgia, serif";
		String corLegendaEsperada = "rgba(153, 153, 153, 1)";
		String tamanhoLegendaEsperada = "11px";
		String alinhamentoLegendaEsperada = "right";
		String estiloLegendaEsperada = "italic";
		
		int widthHorizontalEsperado = Integer.parseInt(CropsDeArticles.listaDeFatosHorizontalInline.getWidth());
		int heightHorizontalEsperado = Integer.parseInt(CropsDeArticles.listaDeFatosHorizontalInline.getHeight());
		int widthVerticallEsperado = Integer.parseInt(CropsDeArticles.listaDeFatosVerticalInline.getWidth());
		int heightVerticalEsperado = Integer.parseInt(CropsDeArticles.listaDeFatosVerticalInline.getHeight());
		
		for(int i=0; i < quantidadeDeFatos(); i++){
			
			WebElement acessaFatoAtual = listaComFatos().get(i).findElement(By.tagName("li"));
			WebElement fotoFatoAtual = acessaFatoAtual.findElement(By.tagName("figure"));
			WebElement acessaLegendaAtual = acessaFatoAtual.findElement(By.tagName("figure")).findElement(By.tagName("figcaption"));
			
			String urlFotoAtual = fotoFatoAtual.findElement(By.tagName("img")).getAttribute("src");
			String widthFotoAtual = fotoFatoAtual.findElement(By.tagName("img")).getAttribute("width");
			String heightFotoAtual = fotoFatoAtual.findElement(By.tagName("img")).getAttribute("height");
			
			String corLegendaAtual = acessaLegendaAtual.getCssValue("color");
			String fonteLegendaAtual = acessaLegendaAtual.getCssValue("font-family");
			String tamanhoLegendaAtual = acessaLegendaAtual.getCssValue("font-size");
			String alinhamentoLegendaAtual = acessaLegendaAtual.getCssValue("text-align");
			String estiloLegendaAtual = acessaLegendaAtual.getCssValue("font-style");
			
			/*Validação das fotos*/
			if(urlFotoAtual.contains(cropHorizontal)){
				
				if(Integer.parseInt(widthFotoAtual) > widthHorizontalEsperado){
					imprimirMensagemDeErroDeUmaTag("width da foto horizontal, na "+(i+1)+"ª posição", widthFotoAtual, CropsDeArticles.listaDeFatosHorizontal.getWidth());
					contadorDeErros++;
				}
				
				if(Integer.parseInt(heightFotoAtual) > heightHorizontalEsperado){
					imprimirMensagemDeErroDeUmaTag("height da foto horizontal, na "+(i+1)+"ª posição", heightFotoAtual, CropsDeArticles.listaDeFatosHorizontal.getHeight());
					contadorDeErros++;
				}
				
			}else if(urlFotoAtual.contains(cropVertical)){
				
				if(Integer.parseInt(widthFotoAtual) > widthVerticallEsperado){
					imprimirMensagemDeErroDeUmaTag("width da foto vertical, na "+(i+1)+"ª posição", widthFotoAtual, CropsDeArticles.listaDeFatosVertical.getWidth());
					contadorDeErros++;
				}
				
				if(Integer.parseInt(heightFotoAtual) > heightVerticalEsperado){
					imprimirMensagemDeErroDeUmaTag("height da foto vertical, na "+(i+1)+"ª posição", heightFotoAtual, CropsDeArticles.listaDeFatosVertical.getHeight());
					contadorDeErros++;
				}
				
			}else{
				
				imprimirMensagemDeErroGenerica("Não exibiu crop vertical nem o crop horizontal.");
				contadorDeErros++;
			}
			
			/*Validação da legenda da foto*/
			
			if(!corLegendaAtual.equals(corLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Cor da legenda", corLegendaEsperada, corLegendaAtual);
				contadorDeErros++;
			}
			
			if(!fonteLegendaAtual.equals(fonteLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Fonte da legenda", fonteLegendaEsperada, fonteLegendaAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoLegendaAtual.equals(tamanhoLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Tamanho da fonte da legenda", tamanhoLegendaEsperada, tamanhoLegendaAtual);
				contadorDeErros++;
			}
			
			if(!alinhamentoLegendaAtual.equals(alinhamentoLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Alinhamento da fonte da legenda", alinhamentoLegendaAtual, alinhamentoLegendaEsperada);
				contadorDeErros++;
			}
			
			if(!estiloLegendaAtual.equals(estiloLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Estilo da fonte da legenda", estiloLegendaEsperada, estiloLegendaAtual);
				contadorDeErros++;
			}
			
			if( i < quantidadeDeVezesAPaginar){
				esperaCarregar(1);
				clicarNoProximoItem();
			}
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuPaginacaoDaUltimoFatoDeFormaCorreta() throws InterruptedException {
		esperaCarregar(1);
		int contadorDeErros = 0;
		
		String classeDesabilitadaEsperada = "next disabled";
		String classeHabilitadaEsperada = "prev";
		
		List<WebElement> paginacao = acessaPaginaçao().findElements(By.tagName("a"));
		WebElement acessaSetaDaEsquerda = paginacao.get(0);
		WebElement acessaSetaDaDireita = paginacao.get(1);
		
		if(!(acessaSetaDaEsquerda.isDisplayed()) ||  !(acessaSetaDaEsquerda.getAttribute("class").equals(classeHabilitadaEsperada))){
			imprimirMensagemDeErroGenerica("Não exibiu paginação para a esquerda de forma correta. ");
			contadorDeErros++;
		}
		
		if(!(acessaSetaDaDireita.isDisplayed()) ||  !(acessaSetaDaDireita.getAttribute("class").equals(classeDesabilitadaEsperada))){
			imprimirMensagemDeErroGenerica("Não exibiu paginação para a direita de forma correta.");
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuTituloDescricaoTotalDeFotosELegendaParaCadaFato() throws InterruptedException {
		
		int contadorDeErros=0;
		int quantidadeMaximaDeCaracteresParaDescricao = 0;
		
		try {
			listaComFatos().get(0).findElement(By.tagName("figure")).isDisplayed();
			quantidadeMaximaDeCaracteresParaDescricao = 350;
		} catch (Exception e) {
			quantidadeMaximaDeCaracteresParaDescricao = 700;
		}
			
		String backgroundEsperado = "rgba(243, 243, 243, 1)";
		
		String fonteTituloEsperada = "OgloboCondensed, Arial, sans-serif";
		String corTituloEsperado = "rgba(0, 0, 0, 1)";
		String tamanhoTituloEsperada = "28.7999992370605px"; 
		
		String fonteDescricaoEsperada = "Georgia, sans-serif";
		String corDescricaoEsperada = "rgba(107, 107, 107, 1)";
		String tamanhoDescricaoEsperada = "18px";
		
		String fonteTotalDeFotosEsperado = "Georgia, Times, serif";
		String corTotalDeFotosEsperado = "rgba(119, 119, 119, 1)";
		String tamanhoTotalDeFotosEsperado = "15px";
		
		for(int i=quantidadeDeVezesAPaginar; i >= 0; i--){
			
			WebElement acessaFatoAtual = listaComFatos().get(i).findElement(By.tagName("li"));
			WebElement acessaTituloAtual = acessaFatoAtual.findElement(By.tagName("h3"));
			WebElement acessaDescricaoAtual = acessaFatoAtual.findElement(By.tagName("span"));
			WebElement acessaTotalDeFatosAtual = acessaPaginaçao().findElement(By.id("custom-caption"));
			
			String corTituloAtual = acessaTituloAtual.getCssValue("color");
			String fonteTituloAtual = acessaTituloAtual.getCssValue("font-family");
			String tamanhoTituloAtual = acessaTituloAtual.getCssValue("font-size"); 
			
			String corDescricaoAtual = acessaDescricaoAtual.getCssValue("color");
			String fonteDescricaoAtual = acessaDescricaoAtual.getCssValue("font-family");
			String tamanhoDescricaoAtual = acessaDescricaoAtual.getCssValue("font-size"); 
			int quantidadeDeCaracteresDescricaoAtual = acessaDescricaoAtual.getText().length();
			
			String corTotalDeFotosAtual = acessaTotalDeFatosAtual.getCssValue("color");
			String tamanhoTotalDeFotosAtual = acessaTotalDeFatosAtual.getCssValue("font-size");
			String fonteTotalDeFotosAtual = acessaTotalDeFatosAtual.getCssValue("font-family");
			
			String backgroundAtual = acessaFatoAtual.getCssValue("background-color");
			
			String totalDeFatosPosicaoAtual = acessaPaginaçao().findElement(By.id("custom-caption")).getText();
			String totalDeFatosEsperadoParaAPosicao = ""+(i+1)+" de "+(quantidadeDeFatos())+"";
			
			esperaCarregar(1);
			
			/*Validação do título*/
			
			if(!corTituloAtual.equals(corTituloEsperado)){
				imprimirMensagemDeErroDeUmaTag("Cor do título no "+(i+1)+"º fato.", corTituloEsperado, corTituloAtual);
				contadorDeErros++;
			}
			
			if(!fonteTituloAtual.equals(fonteTituloEsperada)){
				imprimirMensagemDeErroDeUmaTag("Fonte do título no "+(i+1)+"º fato.", fonteTituloEsperada, fonteTituloAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoTituloAtual.equals(tamanhoTituloEsperada)){
				imprimirMensagemDeErroDeUmaTag("Tamanho da fonte do título no "+(i+1)+"º fato.", corTituloEsperado, corTituloAtual);
				contadorDeErros++;
			}
			
			/*Validação da descrição*/
			
			if(!corDescricaoAtual.equals(corDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("Cor da descrição no "+(i+1)+"º fato.", corDescricaoEsperada, corDescricaoAtual);
				contadorDeErros++;
			}
			
			if(!fonteDescricaoAtual.equals(fonteDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("Fonte da descrição no "+(i+1)+"º fato.", fonteDescricaoEsperada, fonteDescricaoAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoDescricaoAtual.equals(tamanhoDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("Tamanho da fonte da descrição no "+(i+1)+"º fato.", tamanhoDescricaoEsperada, tamanhoDescricaoAtual);
				contadorDeErros++;
			}
			
			if(quantidadeDeCaracteresDescricaoAtual > quantidadeMaximaDeCaracteresParaDescricao){
				imprimirMensagemDeErroDeUmaTag("Quantidades máxima de caractares no "+(i+1)+"º fato.", Integer.toString(quantidadeMaximaDeCaracteresParaDescricao), Integer.toString(quantidadeDeCaracteresDescricaoAtual));
				contadorDeErros++;
			}
			
			/*Validação do contador de fotos*/
			
			if(!corTotalDeFotosAtual.equals(corTotalDeFotosEsperado)){
				imprimirMensagemDeErroDeUmaTag("Cor do contador de fatos no "+(i+1)+"º fato.", corTotalDeFotosEsperado, corTotalDeFotosAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoTotalDeFotosAtual.equals(tamanhoTotalDeFotosEsperado)){
				imprimirMensagemDeErroDeUmaTag("Tamanho da fonte do contador no "+(i+1)+"º fato.", tamanhoTotalDeFotosEsperado, tamanhoTotalDeFotosAtual);
				contadorDeErros++;
			}
			
			if(!fonteTotalDeFotosAtual.equals(fonteTotalDeFotosEsperado)){
				imprimirMensagemDeErroDeUmaTag("Fonte do contador de fatos no "+(i+1)+"º fato.", fonteTotalDeFotosEsperado, fonteTotalDeFotosAtual);
				contadorDeErros++;
			}
			
			if(!totalDeFatosPosicaoAtual.equals(totalDeFatosEsperadoParaAPosicao)){
				imprimirMensagemDeErroDeUmaTag("total de fotos no "+(i+1)+"º fato.", totalDeFatosEsperadoParaAPosicao, totalDeFatosPosicaoAtual);
				contadorDeErros++;
			}
			
			if(!backgroundEsperado.equals(backgroundAtual)){
				imprimirMensagemDeErroDeUmaTag("background do box no "+(i+1)+"º fato.", backgroundEsperado, backgroundAtual);
				contadorDeErros++;
			}
			
			if(i <= quantidadeDeVezesAPaginar && i != Integer.parseInt("0")){
				clicarNoItemAnterior();
				esperaCarregar(1);
			}
			
		}	
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuUmVideoParaCadaUmDosFatos() throws InterruptedException {
		
		int contadorDeErros = 0;
				
		String widthVideoEsperado = "350";
		String heightVideoEsperado = "197";
		
		String fonteLegendaEsperada = "Georgia, serif";
		String corLegendaEsperada = "rgba(153, 153, 153, 1)";
		String tamanhoLegendaEsperada = "11px";
		String alinhamentoLegendaEsperada = "right";
		String estiloLegendaEsperada = "italic";
		
		for(int i=0; i < quantidadeDeFatos(); i++){
			
			WebElement acessaFatoAtual = listaComFatos().get(i).findElement(By.tagName("li"));
			WebElement acessaLegendaAtual = acessaFatoAtual.findElement(By.tagName("figure")).findElement(By.tagName("figcaption"));
			
			String idVideoAtual = "video"+i+"";
			WebElement videoFatoAtual = acessaFatoAtual.findElement(By.id(idVideoAtual)); 
			
			String corLegendaAtual = acessaLegendaAtual.getCssValue("color");
			String fonteLegendaAtual = acessaLegendaAtual.getCssValue("font-family");
			String tamanhoLegendaAtual = acessaLegendaAtual.getCssValue("font-size");
			String alinhamentoLegendaAtual = acessaLegendaAtual.getCssValue("text-align");
			String estiloLegendaAtual = acessaLegendaAtual.getCssValue("font-style");
			
			/*Validação do vídeo*/
			
			if(!videoFatoAtual.isDisplayed()){
				imprimirMensagemDeErroGenerica("Não exibiu vídeo no "+(i+1)+"º fato.");
				contadorDeErros++;
			}
			
			try {
				if(videoFatoAtual.findElement(By.tagName("iframe")).isDisplayed()){
					
					if(!videoFatoAtual.findElement(By.tagName("iframe")).getAttribute("width").equals(widthVideoEsperado)){
						imprimirMensagemDeErroDeUmaTag("width do vídeo "+(i+1)+"º fato" , widthVideoEsperado, videoFatoAtual.findElement(By.tagName("iframe")).getAttribute("width"));
						contadorDeErros++;
					}
					
					if(!videoFatoAtual.findElement(By.tagName("iframe")).getAttribute("height").equals(heightVideoEsperado)){
						imprimirMensagemDeErroDeUmaTag("height do vídeo "+(i+1)+"º fato" , heightVideoEsperado, videoFatoAtual.findElement(By.tagName("iframe")).getAttribute("height"));
						contadorDeErros++;
					}
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			/*Validação da legenda da foto*/
			
			if(!corLegendaAtual.equals(corLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Cor da legenda no "+(i+1)+"º fato.", corLegendaEsperada, corLegendaAtual);
				contadorDeErros++;
			}
			
			if(!fonteLegendaAtual.equals(fonteLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Fonte da legenda no "+(i+1)+"º fato.", fonteLegendaEsperada, fonteLegendaAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoLegendaAtual.equals(tamanhoLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Tamanho da fonte da legenda no "+(i+1)+"º fato.", tamanhoLegendaEsperada, tamanhoLegendaAtual);
				contadorDeErros++;
			}
			
			if(!alinhamentoLegendaAtual.equals(alinhamentoLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Alinhamento da fonte da legenda no "+(i+1)+"º fato.", alinhamentoLegendaAtual, alinhamentoLegendaEsperada);
				contadorDeErros++;
			}
			
			if(!estiloLegendaAtual.equals(estiloLegendaEsperada)){
				imprimirMensagemDeErroDeUmaTag("Estilo da fonte da legenda no "+(i+1)+"º fato.", estiloLegendaEsperada, estiloLegendaAtual);
				contadorDeErros++;
			}
			
			if( i < quantidadeDeVezesAPaginar){
				esperaCarregar(1);
				clicarNoProximoItem();
			}
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuTituloDescricaoTotalDeFotosParaCadaFato() throws InterruptedException {
		
		int contadorDeErros=0;
		int quantidadeMaximaDeCaracteresParaDescricao = 700; 
				
		String backgroundEsperado = "rgba(243, 243, 243, 1)";
		
		String fonteTituloEsperada = "OgloboCondensed, Arial, sans-serif";
		String corTituloEsperado = "rgba(0, 0, 0, 1)";
		String tamanhoTituloEsperada = "28.7999992370605px"; 
		
		String fonteDescricaoEsperada = "Georgia, sans-serif";
		String corDescricaoEsperada = "rgba(107, 107, 107, 1)";
		String tamanhoDescricaoEsperada = "18px";
		
		String fonteTotalDeFotosEsperado = "Georgia, Times, serif";
		String corTotalDeFotosEsperado = "rgba(119, 119, 119, 1)";
		String tamanhoTotalDeFotosEsperado = "15px";
		
		for(int i=0; i < quantidadeDeFatos(); i++){
			
			WebElement acessaFatoAtual = listaComFatos().get(i).findElement(By.tagName("li"));
			WebElement acessaTituloAtual = acessaFatoAtual.findElement(By.tagName("h3"));
			WebElement acessaDescricaoAtual = acessaFatoAtual.findElement(By.tagName("span"));
			WebElement acessaTotalDeFatosAtual = acessaPaginaçao().findElement(By.id("custom-caption"));
			
			String corTituloAtual = acessaTituloAtual.getCssValue("color");
			String fonteTituloAtual = acessaTituloAtual.getCssValue("font-family");
			String tamanhoTituloAtual = acessaTituloAtual.getCssValue("font-size"); 
			
			String corDescricaoAtual = acessaDescricaoAtual.getCssValue("color");
			String fonteDescricaoAtual = acessaDescricaoAtual.getCssValue("font-family");
			String tamanhoDescricaoAtual = acessaDescricaoAtual.getCssValue("font-size"); 
			int quantidadeDeCaracteresDescricaoAtual = acessaDescricaoAtual.getText().length();
			
			String corTotalDeFotosAtual = acessaTotalDeFatosAtual.getCssValue("color");
			String tamanhoTotalDeFotosAtual = acessaTotalDeFatosAtual.getCssValue("font-size");
			String fonteTotalDeFotosAtual = acessaTotalDeFatosAtual.getCssValue("font-family");
			
			String backgroundAtual = acessaFatoAtual.getCssValue("background-color");
			
			String totalDeFatosPosicaoAtual = acessaPaginaçao().findElement(By.id("custom-caption")).getText();
			String totalDeFatosEsperadoParaAPosicao = ""+(i+1)+" de "+(quantidadeDeFatos())+"";
			
			esperaCarregar(1);
			
			/*Validação do título*/
			
			if(!corTituloAtual.equals(corTituloEsperado)){
				imprimirMensagemDeErroDeUmaTag("Cor do título no "+(i+1)+"º fato.", corTituloEsperado, corTituloAtual);
				contadorDeErros++;
			}
			
			if(!fonteTituloAtual.equals(fonteTituloEsperada)){
				imprimirMensagemDeErroDeUmaTag("Fonte do título no "+(i+1)+"º fato.", fonteTituloEsperada, fonteTituloAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoTituloAtual.equals(tamanhoTituloEsperada)){
				imprimirMensagemDeErroDeUmaTag("Tamanho da fonte do título no "+(i+1)+"º fato.", corTituloEsperado, corTituloAtual);
				contadorDeErros++;
			}
			
			/*Validação da descrição*/
			
			if(!corDescricaoAtual.equals(corDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("Cor da descrição no "+(i+1)+"º fato.", corDescricaoEsperada, corDescricaoAtual);
				contadorDeErros++;
			}
			
			if(!fonteDescricaoAtual.equals(fonteDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("Fonte da descrição no "+(i+1)+"º fato.", fonteDescricaoEsperada, fonteDescricaoAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoDescricaoAtual.equals(tamanhoDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("Tamanho da fonte da descrição no "+(i+1)+"º fato.", tamanhoDescricaoEsperada, tamanhoDescricaoAtual);
				contadorDeErros++;
			}
			
			if(quantidadeDeCaracteresDescricaoAtual > quantidadeMaximaDeCaracteresParaDescricao){
				imprimirMensagemDeErroDeUmaTag("Quantidades máxima de caractares no "+(i+1)+"º fato.", Integer.toString(quantidadeMaximaDeCaracteresParaDescricao), Integer.toString(quantidadeDeCaracteresDescricaoAtual));
				contadorDeErros++;
			}
			
			/*Validação do contador de fatos*/
			
			if(!corTotalDeFotosAtual.equals(corTotalDeFotosEsperado)){
				imprimirMensagemDeErroDeUmaTag("Cor do contador de fatos no "+(i+1)+"º fato.", corTotalDeFotosEsperado, corTotalDeFotosAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoTotalDeFotosAtual.equals(tamanhoTotalDeFotosEsperado)){
				imprimirMensagemDeErroDeUmaTag("Tamanho da fonte do contador no "+(i+1)+"º fato.", tamanhoTotalDeFotosEsperado, tamanhoTotalDeFotosAtual);
				contadorDeErros++;
			}
			
			if(!fonteTotalDeFotosAtual.equals(fonteTotalDeFotosEsperado)){
				imprimirMensagemDeErroDeUmaTag("Fonte do contador de fatos no "+(i+1)+"º fato.", fonteTotalDeFotosEsperado, fonteTotalDeFotosAtual);
				contadorDeErros++;
			}
			
			if(!totalDeFatosPosicaoAtual.equals(totalDeFatosEsperadoParaAPosicao)){
				imprimirMensagemDeErroDeUmaTag("total de fotos no "+(i+1)+"º fato.", totalDeFatosEsperadoParaAPosicao, totalDeFatosPosicaoAtual);
				contadorDeErros++;
			}
			
			if(!backgroundEsperado.equals(backgroundAtual)){
				imprimirMensagemDeErroDeUmaTag("background do box no "+(i+1)+"º fato.", backgroundEsperado, backgroundAtual);
				contadorDeErros++;
			}
			
			if(i <= quantidadeDeVezesAPaginar){
				clicarNoProximoItem();
				esperaCarregar(1);
			}
			
		}	
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuOMesmoConteudoTextoParaConteudoInlineEConteudoArticle() throws Exception{
		
		int contadorDeErros=0;
		
		WebElement acessaFatoAtual = listaComFatos().get(0).findElement(By.tagName("li"));
		WebElement acessaDescricaoAtual = acessaFatoAtual.findElement(By.className("textos")).findElement(By.tagName("span"));
		
		String textoDoPrimeroFatoInline = acessaDescricaoAtual.getText();
		int quantidadeDeCaracteresFato = textoDoPrimeroFatoInline.length();
		
		acessaTituloDaListaDeFatosInline().click();
		esperaCarregar(5);
		 
		List<WebElement> listaComFatosDaNovaJanela = getDriver().findElement(By.className("itens-container")).findElements(By.tagName("li"));
		
		WebElement acessaFatoDaNovaJanela = listaComFatosDaNovaJanela.get(0);
		WebElement acessaDescricaoDaNovaJanela = acessaFatoDaNovaJanela.findElement(By.className("subtitulo-foto"));
		
		String textoDoPrimeroFatoInlineDaNovaJanela = acessaDescricaoDaNovaJanela.getText();
		int quantidadeDeCaracteresFatoNovaJanela = textoDoPrimeroFatoInlineDaNovaJanela.length();
		
		if(!textoDoPrimeroFatoInline.equals(textoDoPrimeroFatoInlineDaNovaJanela)){
			imprimirMensagemDeErroGenerica("URL atual: "+getUrlPaginaAtual()+"");
			imprimirMensagemDeErroGenerica(textoDoPrimeroFatoInline);
			imprimirMensagemDeErroDeUmaTag("texto do fato", textoDoPrimeroFatoInline, textoDoPrimeroFatoInlineDaNovaJanela);
			contadorDeErros++;
		}
		
		if(quantidadeDeCaracteresFato != quantidadeDeCaracteresFatoNovaJanela){
			imprimirMensagemDeErroGenerica("URL atual: "+getUrlPaginaAtual()+"");
			imprimirMensagemDeErroGenerica(textoDoPrimeroFatoInlineDaNovaJanela);
			imprimirMensagemDeErroDeUmaTag("quantidade de caracteres dos fato", Integer.toString(quantidadeDeCaracteresFato), Integer.toString(quantidadeDeCaracteresFatoNovaJanela));
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
}