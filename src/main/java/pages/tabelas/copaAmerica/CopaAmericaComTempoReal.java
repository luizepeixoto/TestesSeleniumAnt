package pages.tabelas.copaAmerica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class CopaAmericaComTempoReal extends CopaAmerica {	
	
	public CopaAmericaComTempoReal(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void scrollAteATabela(String classeDesejada) throws InterruptedException{
		WebElement posicaoTabela = getDriver().findElement(By.className(classeDesejada));
		executarScroll(posicaoTabela.getLocation());
		esperaCarregar(2);
	} 
	
	public boolean exibiuLinhasDaTabelaDoGrupoSelecionadoDoTempoRealEmDegrade(int posicaoDoGrupo) {
		
		String linhaParCorCinza = "rgba(249, 249, 249, 1)";
		String linhaImparCorBranca = "rgba(255, 255, 255, 1)";
		
		for(int i=0; i < TotalDeLinhasDoGrupoA(posicaoDoGrupo); i++){
			
			if(i%2 == 0){
				 if(!acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(i).getCssValue("background-color").equals(linhaParCorCinza)){
					imprimirMensagemDeErroDeUmaTag("cor da linha", linhaParCorCinza, acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(i).getCssValue("background-color"));
					 return false;
				 }
			}else{
				if(!acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(i).getCssValue("background-color").equals(linhaImparCorBranca)){
					imprimirMensagemDeErroDeUmaTag("cor da linha", linhaImparCorBranca, acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(i).getCssValue("background-color"));
					return false;
				 }
			}
		}
		
		return true;
	}
	
	public boolean exibiuOQuartoTimeDoGrupoSelecionadoNoTempoRealSemTarja(int posicaoDoGrupo){
		
		WebElement acessaAQuartaLinha = acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(3);
		
		String corEsperada = "rgba(85, 85, 85, 1)";
		String corDaTerceiraLinha = acessaAQuartaLinha.getCssValue("border-left-color");
		
		if(!corDaTerceiraLinha.equals(corEsperada)){
			imprimirMensagemDeErroDeUmaTag("quarta posição com marcação", corEsperada, corDaTerceiraLinha);
			return false;
		}
		
		return true;
	}
}