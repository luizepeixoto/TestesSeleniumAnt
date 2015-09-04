package pages.ela.capa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapa;

import br.com.infoglobo.pages.Navegador;

public class CapaElaBlogs extends BoxCincoMinutos {
	
	public CapaElaBlogs(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement acessaClasseBlogsHomeList(){
		return getDriver().findElement(By.className("blogs-home-list"));
	}
	
	public boolean exibiuBoxDeBlogs(){
		return acessaClasseBlogsHomeList().isDisplayed();
	}
	
	public WebElement acessaTitulo(){
		return acessaClasseBlogsHomeList().findElement(By.tagName("h2")).findElement(By.tagName("a"));
	}
	
	public String exibiuTituloBlogs(){
		return acessaTitulo().getText();
	}
	
	public boolean exibiuTituloBlogsComOLayoutCorreto(){
		
		int contadorDeErros = 0; 
		
		String fonteEsperada = "OgloboXCondensed, sans-serif";
		String tamanhoFonteEsperada = "30px";
		String corFonteEsperada = "rgba(0, 0, 0, 1)";
		String estiloFonteEsperada = "normal";
		String textTransformEsperado = "uppercase";
		
		String fonteAtual = acessaTitulo().getCssValue("font-family");
		String tamanhoAtual = acessaTitulo().getCssValue("font-size");
		String corFonteAtual = acessaTitulo().getCssValue("color");
		String estiloFonteAtual = acessaTitulo().getCssValue("font-style");
		String textTransformAtual = acessaTitulo().getCssValue("text-transform");
		
		if(!acessaTitulo().isDisplayed()){
			imprimirMensagemDeErroGenerica("Não exibiu link no título.");
			contadorDeErros++;
		}
		
		if(!fonteAtual.equals(fonteEsperada)){
			imprimirMensagemDeErroDeUmaTag("fonte do título", fonteEsperada, fonteAtual);
			contadorDeErros++;
		}
		
		if(!tamanhoAtual.equals(tamanhoFonteEsperada)){
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título", tamanhoFonteEsperada, tamanhoAtual);
			contadorDeErros++;
		}
		
		if(!corFonteAtual.equals(corFonteEsperada)){
			imprimirMensagemDeErroDeUmaTag("cor da fonte do título", corFonteEsperada, corFonteAtual);
			contadorDeErros++;
		}
		
		if(!estiloFonteAtual.equals(estiloFonteEsperada)){
			imprimirMensagemDeErroDeUmaTag("estilo da fonte do título", estiloFonteEsperada, estiloFonteAtual);
			contadorDeErros++;
		}
		
		if(!textTransformAtual.equals(textTransformEsperado)){
			imprimirMensagemDeErroDeUmaTag("Text Transform do título", textTransformEsperado, textTransformAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public List<WebElement> acessaDeChamadaDeBlogs(){
		return acessaClasseBlogsHomeList().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public int calculaTotalDeBlogsNaLista(){
		return acessaDeChamadaDeBlogs().size();
	}
	
	public boolean exibiuChamadasDosBlogsComAsInformacoesCorretas() throws InterruptedException{
		
		int contadorDeErros = 0; 
		
		String cropEsperado = CropsCapa.boxDestaquesBlogsEla.getCropProporcional();
		int widthFotoEsperado = Integer.parseInt(CropsCapa.boxDestaquesBlogsEla.getWidth());
		int heightFotoEsperado = Integer.parseInt(CropsCapa.boxDestaquesBlogsEla.getHeight());
		
		String fonteTituloEsperada = "OgloboXCondensed, sans-serif";
		String tamanhoFonteTituloEsperada = "20px";
		String corFonteTituloEsperada = "rgba(30, 150, 200, 1)";
		String estiloFonteTituloEsperada = "normal";
		String textTransformTituloEsperado = "uppercase";
		
		String fonteDescricaoEsperada = "OgloboCondensed, sans-serif";
		String tamanhoFonteDescricaoEsperada = "19px";
		String corFonteDescricaoEsperada = "rgba(255, 255, 255, 1)";
		
		for(int i=0; i < calculaTotalDeBlogsNaLista(); i++){
			
			WebElement blogPosicaoAtual = acessaDeChamadaDeBlogs().get(i).findElement(By.tagName("a"));
			WebElement fotoPosicaoAtual = blogPosicaoAtual.findElement(By.tagName("img"));
			WebElement tituloPosicaoAtual = blogPosicaoAtual.findElement(By.className("blog-title"));
			WebElement descricaoPosicaoAtual = blogPosicaoAtual.findElement(By.className("blog-description"));
			
			String caminhoFotoAtual = fotoPosicaoAtual.getAttribute("src");
			int widthFotoAtual =  Integer.parseInt(fotoPosicaoAtual.getAttribute("width"));
			int heightFotoAtual =  Integer.parseInt(fotoPosicaoAtual.getAttribute("height"));
			
			String tituloAtual = tituloPosicaoAtual.getText();
			String fonteTituloAtual = tituloPosicaoAtual.getCssValue("font-family");
			String tamanhoTituloAtual = tituloPosicaoAtual.getCssValue("font-size");
			String corFonteTituloAtual = tituloPosicaoAtual.getCssValue("color");
			String estiloFonteTituloAtual = tituloPosicaoAtual.getCssValue("font-style");
			String textTransformTituloAtual = tituloPosicaoAtual.getCssValue("text-transform");
			
			String descricaoAtual = descricaoPosicaoAtual.getText();
			String fonteDescricaoAtual = descricaoPosicaoAtual.getCssValue("font-family");
			String tamanhoDescricaoAtual = descricaoPosicaoAtual.getCssValue("font-size");
			String corFonteDescricaoAtual = descricaoPosicaoAtual.getCssValue("color");
			
			if(!fotoPosicaoAtual.isDisplayed()){
				imprimirMensagemDeErroGenerica("Não exibiu foto na posição: "+(i+1)+"");
				contadorDeErros++;
			}
			
			if(!caminhoFotoAtual.contains(cropEsperado)){
				imprimirMensagemDeErroDeUmaTag("crop da imagem", cropEsperado, caminhoFotoAtual);
				contadorDeErros++;
			}
			
			if(widthFotoAtual > widthFotoEsperado){
				imprimirMensagemDeErroDeUmaTag("width da imagem", CropsCapa.boxDestaquesBlogsEla.getWidth(), fotoPosicaoAtual.getAttribute("width"));
				contadorDeErros++;
			}
			
			if(heightFotoAtual > heightFotoEsperado){
				imprimirMensagemDeErroDeUmaTag("height da imagem", CropsCapa.boxDestaquesBlogsEla.getHeight(), fotoPosicaoAtual.getAttribute("height"));
				contadorDeErros++;
			}
			
			/*validação do título de cada chamada*/
			if(tituloAtual.isEmpty()){
				imprimirMensagemDeErroGenerica("Não exibiu título na posição: "+(i+1)+"");
				contadorDeErros++;
			}
			
			if(!fonteTituloAtual.equals(fonteTituloEsperada)){
				imprimirMensagemDeErroDeUmaTag("fonte do título posição: "+(i+1)+"", fonteTituloEsperada, fonteTituloAtual);
				imprimirMensagemDeErroGenerica("Título com problema: "+tituloAtual+"");
				contadorDeErros++;
			}
			
			if(!tamanhoTituloAtual.equals(tamanhoFonteTituloEsperada)){
				imprimirMensagemDeErroDeUmaTag("tamanho fonte do título posição: "+(i+1)+"", tamanhoFonteTituloEsperada, tamanhoTituloAtual);
				imprimirMensagemDeErroGenerica("Título com problema: "+tituloAtual+"");
				contadorDeErros++;
			}
			
			if(!corFonteTituloAtual.equals(corFonteTituloEsperada)){
				imprimirMensagemDeErroDeUmaTag("cor fonte do título posição: "+(i+1)+"", corFonteTituloEsperada, corFonteTituloAtual);
				imprimirMensagemDeErroGenerica("Título com problema: "+tituloAtual+"");
				contadorDeErros++;
			}
			
			if(!estiloFonteTituloAtual.equals(estiloFonteTituloEsperada)){
				imprimirMensagemDeErroDeUmaTag("estilo da fonte do título posição: "+(i+1)+"", estiloFonteTituloEsperada, estiloFonteTituloAtual);
				imprimirMensagemDeErroGenerica("Título com problema: "+tituloAtual+"");
				contadorDeErros++;
			}
			
			if(!textTransformTituloAtual.equals(textTransformTituloEsperado)){
				imprimirMensagemDeErroDeUmaTag("text Transform da fonte do título posição: "+(i+1)+"", textTransformTituloEsperado, textTransformTituloAtual);
				imprimirMensagemDeErroGenerica("Título com problema: "+tituloAtual+"");
				contadorDeErros++;
			}
			
			/*validação da descrição de cada chamada*/
			executarMouseOver(fotoPosicaoAtual);
			esperaCarregar(1);
			if(descricaoAtual.isEmpty()){
				imprimirMensagemDeErroGenerica("Não exibiu descrição na posição: "+(i+1)+"");
				contadorDeErros++;
			}
			
			executarMouseOver(fotoPosicaoAtual);
			esperaCarregar(1);
			if(!fonteDescricaoAtual.equals(fonteDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("fonte do descricao posição: "+(i+1)+"", fonteDescricaoEsperada, fonteDescricaoAtual);
				imprimirMensagemDeErroGenerica("Descrição com problema: "+descricaoAtual+"");
				contadorDeErros++;
			}
			
			executarMouseOver(fotoPosicaoAtual);
			esperaCarregar(1);
			if(!tamanhoDescricaoAtual.equals(tamanhoFonteDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("tamanho fonte da descricao posição: "+(i+1)+"", tamanhoFonteDescricaoEsperada, tamanhoDescricaoAtual);
				imprimirMensagemDeErroGenerica("Descrição com problema: "+descricaoAtual+"");
				contadorDeErros++;
			}
			
			executarMouseOver(fotoPosicaoAtual);
			esperaCarregar(1);
			if(!corFonteDescricaoAtual.equals(corFonteDescricaoEsperada)){
				imprimirMensagemDeErroDeUmaTag("cor fonte da descricao posição: "+(i+1)+"", corFonteDescricaoEsperada, corFonteDescricaoAtual);
				imprimirMensagemDeErroGenerica("Descrição com problema: "+descricaoAtual+"");
				contadorDeErros++;
			}
		}
		
		return validacaoDeErros(contadorDeErros);
	}
}