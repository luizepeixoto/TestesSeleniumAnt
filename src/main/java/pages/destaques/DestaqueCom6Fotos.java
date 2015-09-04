package pages.destaques;

import crops.CropsDestaques;
import br.com.infoglobo.pages.Navegador;

public class DestaqueCom6Fotos extends DestaqueComPadrao {
	
	public DestaqueCom6Fotos(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuHeightWidthCropCorretoParaODestaqueHorizontal() {
		
		int contadorDeErros = 0;
		
		String cropEsperado = CropsDestaques.semiAutomaticoSeisDestaques.cropProporcional();
		String widthEsperado = CropsDestaques.semiAutomaticoSeisDestaques.getWidth();
		String heightEsperado = CropsDestaques.semiAutomaticoSeisDestaques.getHeight();
		
		String urlFotoAtual = acessaFotoDestaqueHorizontal().getAttribute("src");
		String widthFotoAtual = acessaFotoDestaqueHorizontal().getAttribute("width");
		String heightFotoAtual = acessaFotoDestaqueHorizontal().getAttribute("height"); 
		
		if(!urlFotoAtual.contains(cropEsperado)){
			imprimirMensagemDeErroDeUmaTag("crop incorreto", widthFotoAtual, widthEsperado);
			contadorDeErros++;
		}
		
		if(Integer.parseInt(widthFotoAtual) > Integer.parseInt(widthEsperado)){
			imprimirMensagemDeErroDeUmaTag("width da foto horizontal", widthFotoAtual, widthEsperado);
			contadorDeErros++;
		}
		
		if(Integer.parseInt(heightFotoAtual) > Integer.parseInt(heightEsperado)){
			imprimirMensagemDeErroDeUmaTag("height da foto horizontal", heightFotoAtual, heightEsperado);
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}

}