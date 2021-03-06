package pages.ela.capa.esquerda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.capa.esquerda.ChamadaPrincipal;

import br.com.infoglobo.pages.Navegador;

public class ElaCapaDaEsquerda extends ChamadaPrincipal {
	
	public ElaCapaDaEsquerda(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuLayoutCorretoParaAEditoriaDoEla(){
		
		int contadorDeErros = 0;
		
		String fonteEsperada = "OgloboXCondensed, Arial, sans-serif";
		String tamanhoFonteEsperada = "20px";
		String corFonteEsperada = "rgba(255, 25, 41, 1)";
		String textTransformEsperado = "uppercase";
		
		String fonteAtual = acessaEditoriaDaChamadaPrincipal().getCssValue("font-family");
		String tamanhoFonteAtual = acessaEditoriaDaChamadaPrincipal().getCssValue("font-size");
		String corFonteAtual = acessaEditoriaDaChamadaPrincipal().getCssValue("color");
		String textTransformAtual = acessaEditoriaDaChamadaPrincipal().getCssValue("text-transform");
		
		if(!fonteEsperada.equals(fonteAtual)){
			imprimirMensagemDeErroDeUmaTag("fonte do título", fonteEsperada, fonteAtual);
			contadorDeErros++;
		}
		
		if(!tamanhoFonteEsperada.equals(tamanhoFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título", tamanhoFonteEsperada, tamanhoFonteAtual);
			contadorDeErros++;
		}
		
		if(!corFonteEsperada.equals(corFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("cor da fonte do título", corFonteEsperada, corFonteAtual);
			contadorDeErros++;
		}
		
		if(!textTransformEsperado.equals(textTransformAtual)){
			imprimirMensagemDeErroDeUmaTag("text transform da fonte do título", textTransformEsperado, textTransformAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuTituloDaChamadaPrincipalComLayoutCorretoDoEla(){
		
		int contadorDeErros = 0;
		
		String fonteEsperada = "OgloboXCondensed, Arial, sans-serif";
		String tamanhoFonteEsperada = "40px";
		String corFonteEsperada = "rgba(0, 0, 0, 1)";
		String textTransformEsperado = "uppercase";
		
		String fonteAtual = acessaTituloDaMateriaChamadaPrincipal().getCssValue("font-family");
		String tamanhoFonteAtual = acessaTituloDaMateriaChamadaPrincipal().getCssValue("font-size");
		String corFonteAtual = acessaTituloDaMateriaChamadaPrincipal().getCssValue("color");
		String textTransformAtual = acessaTituloDaMateriaChamadaPrincipal().getCssValue("text-transform");
		
		if(!fonteEsperada.equals(fonteAtual)){
			imprimirMensagemDeErroDeUmaTag("fonte do título", fonteEsperada, fonteAtual);
			contadorDeErros++;
		}
		
		if(!tamanhoFonteEsperada.equals(tamanhoFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título", tamanhoFonteEsperada, tamanhoFonteAtual);
			contadorDeErros++;
		}
		
		if(!corFonteEsperada.equals(corFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("cor da fonte do título", corFonteEsperada, corFonteAtual);
			contadorDeErros++;
		}
		
		if(!textTransformEsperado.equals(textTransformAtual)){
			imprimirMensagemDeErroDeUmaTag("text transform da fonte do título", textTransformEsperado, textTransformAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuLayoutCorretoParaOAutorDaChamadaPrincipalDoEla(){
		
		int contadorDeErros = 0;
		
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String tamanhoFonteEsperada = "19px";
		String corFonteEsperada = "rgba(51, 51, 51, 1)";
		
		String fonteAtual = acessaAutorDaChamada().getCssValue("font-family");
		String tamanhoFonteAtual = acessaAutorDaChamada().getCssValue("font-size");
		String corFonteAtual = acessaAutorDaChamada().getCssValue("color");
		
		if(!fonteEsperada.equals(fonteAtual)){
			imprimirMensagemDeErroDeUmaTag("fonte do título", fonteEsperada, fonteAtual);
			contadorDeErros++;
		}
		
		if(!tamanhoFonteEsperada.equals(tamanhoFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título", tamanhoFonteEsperada, tamanhoFonteAtual);
			contadorDeErros++;
		}
		
		if(!corFonteEsperada.equals(corFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("cor da fonte do título", corFonteEsperada, corFonteAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuLayoutCorretoParaOBalaoDeComentariosDoEla(WebElement posicaoDesejada){
		
		int contadorDeErros = 0; //acessaComentarioDaChamada()
		
		String fonteEsperada = "Helvetica, Arial, sans-serif";
		String tamanhoFonteEsperada = "14px";
		String corFonteEsperada = "rgba(0, 0, 0, 1)";
		String backgroundEsperado = "rgba(0, 0, 0, 0)"; //"transparent";
		String backgroundImageEsperado = "sprite-home.png";
		
		String fonteAtual = posicaoDesejada.getCssValue("font-family");
		String tamanhoFonteAtual = posicaoDesejada.getCssValue("font-size");
		String corFonteAtual = posicaoDesejada.getCssValue("color");
		String backgroundAtual = posicaoDesejada.getCssValue("background-color");
		String backgroundImageAtual = posicaoDesejada.getCssValue("background-image");
		
		if(!fonteEsperada.equals(fonteAtual)){
			imprimirMensagemDeErroDeUmaTag("fonte do título", fonteEsperada, fonteAtual);
			contadorDeErros++;
		}
		
		if(!tamanhoFonteEsperada.equals(tamanhoFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título", tamanhoFonteEsperada, tamanhoFonteAtual);
			contadorDeErros++;
		}
		
		if(!corFonteEsperada.equals(corFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("cor da fonte do título", corFonteEsperada, corFonteAtual);
			contadorDeErros++;
		}
		
		if(!backgroundEsperado.equals(backgroundAtual)){
			imprimirMensagemDeErroDeUmaTag("background", backgroundEsperado, backgroundAtual);
			contadorDeErros++;
		}
		
		if(!backgroundImageAtual.contains(backgroundImageEsperado)){
			imprimirMensagemDeErroDeUmaTag("imagem de background", backgroundImageEsperado, backgroundImageAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuAntitituloDosBoxDeOpiniaoComLayoutCorreto() {
		
		int contadorDeErros = 0; 
		
		String fonteEsperada = "OgloboXCondensed, sans-serif";
		String tamanhoFonteEsperada = "16px";
		String corFonteEsperada = "rgba(255, 31, 45, 1)";
		String textTransformEsperado = "uppercase";
		
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			
			WebElement antitituloBoxAtual = listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("h4"));
			
			String fonteAtual = antitituloBoxAtual.getCssValue("font-family");
			String tamanhoFonteAtual = antitituloBoxAtual.getCssValue("font-size");
			String corFonteAtual = antitituloBoxAtual.getCssValue("color");
			String textTransformAtual = antitituloBoxAtual.getCssValue("text-transform");
			
			if(!fonteEsperada.equals(fonteAtual)){
				imprimirMensagemDeErroDeUmaTag("fonte do AntiTitulo para o "+(i+1)+"º box", fonteEsperada, fonteAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoFonteEsperada.equals(tamanhoFonteAtual)){
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte do AntiTitulo para o "+(i+1)+"º box", tamanhoFonteEsperada, tamanhoFonteAtual);
				contadorDeErros++;
			}
			
			if(!corFonteEsperada.equals(corFonteAtual)){
				imprimirMensagemDeErroDeUmaTag("cor da fonte do AntiTitulo para o "+(i+1)+"º box", corFonteEsperada, corFonteAtual);
				contadorDeErros++;
			}
			
			if(!textTransformEsperado.equals(textTransformAtual)){
				imprimirMensagemDeErroDeUmaTag("text transform fonte do AntiTitulo para o "+(i+1)+"º box", textTransformEsperado, textTransformAtual);
				contadorDeErros++;
			}
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public boolean exibiuAutorDosBoxDeOpiniaoComLayoutCorreto() {
		
		int contadorDeErros = 0; 
		
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String tamanhoFonteEsperada = "16px";
		String corFonteEsperada = "rgba(0, 0, 0, 1)";
		String textTransformEsperado = "uppercase";
		
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			
			WebElement autorBoxAtual = listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("h5"));
			
			String fonteAtual = autorBoxAtual.getCssValue("font-family");
			String tamanhoFonteAtual = autorBoxAtual.getCssValue("font-size");
			String corFonteAtual = autorBoxAtual.getCssValue("color");
			String textTransformAtual = autorBoxAtual.getCssValue("text-transform");
			
			if(!fonteEsperada.equals(fonteAtual)){
				imprimirMensagemDeErroDeUmaTag("fonte do autor para o "+(i+1)+"º box", fonteEsperada, fonteAtual);
				contadorDeErros++;
			}
			
			if(!tamanhoFonteEsperada.equals(tamanhoFonteAtual)){
				imprimirMensagemDeErroDeUmaTag("tamanho da fonte do autor para o "+(i+1)+"º box", tamanhoFonteEsperada, tamanhoFonteAtual);
				contadorDeErros++;
			}
			
			if(!corFonteEsperada.equals(corFonteAtual)){
				imprimirMensagemDeErroDeUmaTag("cor da fonte do autor para o "+(i+1)+"º box", corFonteEsperada, corFonteAtual);
				contadorDeErros++;
			}
			
			if(!textTransformEsperado.equals(textTransformAtual)){
				imprimirMensagemDeErroDeUmaTag("text transform fonte do autor para o "+(i+1)+"º box", textTransformEsperado, textTransformAtual);
				contadorDeErros++;
			}
		}
		
		return validacaoDeErros(contadorDeErros);
		
	}
	
	public boolean exibiuLayoutCorretoParaOAutorNaAChamadaSecundariaDoEla(){
		
		int contadorDeErros = 0;
		
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String tamanhoFonteEsperada = "19px";
		String corFonteEsperada = "rgba(51, 51, 51, 1)";
		
		String fonteAtual = acessaAutorDaChamadaSecundaria().getCssValue("font-family");
		String tamanhoFonteAtual = acessaAutorDaChamadaSecundaria().getCssValue("font-size");
		String corFonteAtual = acessaAutorDaChamadaSecundaria().getCssValue("color");
		
		if(!fonteEsperada.equals(fonteAtual)){
			imprimirMensagemDeErroDeUmaTag("fonte do título", fonteEsperada, fonteAtual);
			contadorDeErros++;
		}
		
		if(!tamanhoFonteEsperada.equals(tamanhoFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("tamanho da fonte do título", tamanhoFonteEsperada, tamanhoFonteAtual);
			contadorDeErros++;
		}
		
		if(!corFonteEsperada.equals(corFonteAtual)){
			imprimirMensagemDeErroDeUmaTag("cor da fonte do título", corFonteEsperada, corFonteAtual);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
}