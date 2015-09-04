package pages.tabelas.copaAmerica;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class CopaAmericaFases extends AceitacaoAbstractTest {	
	
	public CopaAmericaFases(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement acessaAFaseDesejada(String classeDaFaseDesejada){
		return getDriver().findElement(By.className(""+classeDaFaseDesejada+""));
	}
	
	public WebElement acessaHrDivisor(String idDaFaseDesejada){
		return acessaAFaseDesejada(idDaFaseDesejada).findElement(By.className("divisor"));
	}
	
	public boolean exibiuFaseDesejada(String idDaFaseDesejada){
		return acessaAFaseDesejada(idDaFaseDesejada).isDisplayed();
	}
	
	public List<WebElement> listaComTodasAsRodadas(String idDaFaseDesejada){
		return acessaAFaseDesejada(idDaFaseDesejada).findElement(By.className("row")).findElements(By.className("rodada"));
	}
	
	public int totalDeRodadas(String idDaFaseDesejada){
		return listaComTodasAsRodadas(idDaFaseDesejada).size();
	}
	
	public boolean exibiuDiaHoraELocalDoJogo(String idDaFaseDesejada){
		
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String tipoEscritaEsperada = "uppercase";
		String tamanhoTextoChaveEsperado = "16px";
		String tamanhoTextoLocalEDataEsperado = "15px";
		String tamanhoTextoJogosEsperado = "19px";
		String corTextoEsperado = "rgba(170, 170, 170, 1)";
		String corEsperadaParaOPlacar = "rgba(59, 59, 59, 1)";
		String alinhamentoTextoChaveEsperado = "center";
		String dataAlinhamentoEsperado = "left";
		String horaAlinhamentoEsperado = "center";
		String estadioAlinhamentoEsperado = "right";
		
		for(int i=0; i < totalDeRodadas(idDaFaseDesejada); i++){
			
			List<WebElement> listaComQuantidadeDeJogos = listaComTodasAsRodadas(idDaFaseDesejada).get(i).findElements(By.className("jogo"));
			int totalDeJogos = listaComQuantidadeDeJogos.size();
			
			for(int y=0; y < totalDeJogos; y++){
				
				List<WebElement> listaDeSpanComAsInformacoesDeCadaJogo = listaComQuantidadeDeJogos.get(y).findElement(By.className("info")).findElements(By.tagName("span")); /*acessa as informações de hora, local e estádio*/
				List<WebElement> listaDeSpanDentroDaClasseTimes = listaComQuantidadeDeJogos.get(y).findElement(By.className("times")).findElements(By.className("large-5")); /*acessa apenas os times*/
				
				WebElement acessaChave = listaComQuantidadeDeJogos.get(y).findElement(By.className("tip"));
				String textoChaveAtual = acessaChave.getText();
				String corTextoChaveAtual = acessaChave.getCssValue("color");
				String tamanhoTextoChaveAtual = acessaChave.getCssValue("font-size");
				String alinhamentoTextoChaveAtual = acessaChave.getCssValue("text-align");
				
				WebElement informacaoJogoPosicaoAtual = listaComQuantidadeDeJogos.get(i).findElement(By.className("info"));
				WebElement informacaoTimesPosicaoAtual = listaComQuantidadeDeJogos.get(i).findElement(By.className("times")); 
				
				String dataJogoPosicaoAtual = informacaoJogoPosicaoAtual.findElement(By.className("data")).getText();
				String horaJogoPosicaoAtual = informacaoJogoPosicaoAtual.findElement(By.className("hora")).getText();
				String estadioJogoPosicaoAtual = informacaoJogoPosicaoAtual.findElement(By.className("estadio")).getText();
				
				String dataAlinhamentoPosicaoAtual = informacaoJogoPosicaoAtual.findElement(By.className("data")).getCssValue("float");
				String horaAlinhamentoPosicaoAtual = informacaoJogoPosicaoAtual.findElement(By.className("hora")).getCssValue("text-align");
				String estadioAlinhamentoPosicaoAtual = informacaoJogoPosicaoAtual.findElement(By.className("estadio")).getCssValue("text-align");
				
				String timeDaCasaAtual = informacaoTimesPosicaoAtual.findElement(By.className("time-home")).getText();
				String timeDeForaAtual = informacaoTimesPosicaoAtual.findElement(By.className("time-away")).getText();
				WebElement placar = informacaoTimesPosicaoAtual.findElement(By.className("placar"));
				String placarAtual = placar.getText();
				
				WebElement bandeiraTimeDaCasa = placar.findElements(By.tagName("img")).get(0);
				WebElement bandeiraTimeVisitante = placar.findElements(By.tagName("img")).get(1);
				
				if(textoChaveAtual.isEmpty()){
					imprimirMensagemDeErroGenerica("Exibiu o texto chave vazio");
					return false;
				}
				
				if(!tamanhoTextoChaveAtual.equals(tamanhoTextoChaveEsperado)){
					imprimirMensagemDeErroGenerica("Exibiu o texto chave vazio");
					return false;
				}
				
				if(!corTextoChaveAtual.equals(corTextoEsperado)){
					imprimirMensagemDeErroGenerica("Exibiu o texto chave vazio");
					return false;
				}
				
				if(!alinhamentoTextoChaveAtual.equals(alinhamentoTextoChaveEsperado)){
					imprimirMensagemDeErroGenerica("Exibiu o texto chave vazio");
					return false;
				}
				
				if(dataJogoPosicaoAtual.isEmpty()){
					imprimirMensagemDeErroDeUmaTag("data do jogo", "Not Null", dataJogoPosicaoAtual);
					return false;
				}
				
				if(horaJogoPosicaoAtual.isEmpty()){
					imprimirMensagemDeErroDeUmaTag("hora do jogo", "Not Null", horaJogoPosicaoAtual);
					return false;
				}
				
				if(estadioJogoPosicaoAtual.isEmpty()){
					imprimirMensagemDeErroDeUmaTag("estádio do jogo", "Not Null", estadioJogoPosicaoAtual);
					return false;
				}
				
				if(!dataAlinhamentoPosicaoAtual.equals(dataAlinhamentoEsperado)){
					imprimirMensagemDeErroDeUmaTag("alinhamento da data do jogo", dataAlinhamentoEsperado, dataAlinhamentoPosicaoAtual);
					return false;
				}
				
				if(!horaAlinhamentoPosicaoAtual.equals(horaAlinhamentoEsperado)){
					imprimirMensagemDeErroDeUmaTag("alinhamento da hora do jogo", horaAlinhamentoEsperado, horaAlinhamentoPosicaoAtual);
					return false;
				}
				
				if(!estadioAlinhamentoPosicaoAtual.equals(estadioAlinhamentoEsperado)){
					imprimirMensagemDeErroDeUmaTag("alinhamento do estádio do jogo", estadioAlinhamentoEsperado, estadioAlinhamentoPosicaoAtual);
					return false;
				}
				
				for(int w=0; w < listaDeSpanComAsInformacoesDeCadaJogo.size(); w++){
					
					String fonteAtualNasInformacoesDosJogos = listaDeSpanComAsInformacoesDeCadaJogo.get(w).getCssValue("font-family");
					String tamanhoFonteAtualNasInformacoesDosJogos = listaDeSpanComAsInformacoesDeCadaJogo.get(w).getCssValue("font-size");
					String corFonteAtualNasInformacoesDosJogos = listaDeSpanComAsInformacoesDeCadaJogo.get(w).getCssValue("color");
					
					if(!fonteAtualNasInformacoesDosJogos.equals(fonteEsperada)){
						imprimirMensagemDeErroDeUmaTag("fonte para posição "+(i+1)+" "+listaDeSpanComAsInformacoesDeCadaJogo.get(w).getText()+"", fonteEsperada, fonteAtualNasInformacoesDosJogos);
						return false;
					}
					
					if(!tamanhoFonteAtualNasInformacoesDosJogos.equals(tamanhoTextoLocalEDataEsperado)){
						imprimirMensagemDeErroDeUmaTag("tamanho da fonte para posição "+(i+1)+" "+listaDeSpanComAsInformacoesDeCadaJogo.get(w).getText()+"", tamanhoTextoLocalEDataEsperado, tamanhoFonteAtualNasInformacoesDosJogos);
						return false;
					}
					
					if(!corFonteAtualNasInformacoesDosJogos.equals(corTextoEsperado)){
						imprimirMensagemDeErroDeUmaTag("cor da fonte para posição "+(i+1)+" "+listaDeSpanComAsInformacoesDeCadaJogo.get(w).getText()+"", corTextoEsperado, corFonteAtualNasInformacoesDosJogos);
						return false;
					}
				}
				
				if(timeDaCasaAtual.isEmpty()){
					imprimirMensagemDeErroDeUmaTag("time da casa", "Not Null", timeDaCasaAtual);
					return false;
				}
				
				if(timeDeForaAtual.isEmpty()){
					imprimirMensagemDeErroDeUmaTag("time de fora", "Not Null", timeDeForaAtual);
					return false;
				}
				
				if(placarAtual.isEmpty()){
					imprimirMensagemDeErroDeUmaTag("placar", "Not Null", placarAtual);
					return false;
				}
				
				for(int w=0; w < listaDeSpanDentroDaClasseTimes.size(); w++){
					
					String fonteAtualNasInformacoesDosJogos = listaDeSpanDentroDaClasseTimes.get(w).getCssValue("font-family");
					String tipoFonteAtualNasInformacoesDosJogos = listaDeSpanDentroDaClasseTimes.get(w).getCssValue("text-transform");
					String corFonteAtualNasInformacoesDosJogos = listaDeSpanDentroDaClasseTimes.get(w).getCssValue("color");
							
					if(!fonteAtualNasInformacoesDosJogos.equals(fonteEsperada)){
						imprimirMensagemDeErroDeUmaTag("fonte para posição "+(i+1)+" Time: "+listaDeSpanDentroDaClasseTimes.get(i).getText()+"", fonteEsperada, fonteAtualNasInformacoesDosJogos);
						return false;
					}
					
					if(!tipoFonteAtualNasInformacoesDosJogos.equals(tipoEscritaEsperada)){
						imprimirMensagemDeErroDeUmaTag("tamanho da fonte para posição Time: "+(i+1)+" "+listaDeSpanDentroDaClasseTimes.get(i).getText()+"", tamanhoTextoJogosEsperado, tipoFonteAtualNasInformacoesDosJogos);
						return false;
					}
					
					if(!corFonteAtualNasInformacoesDosJogos.equals(corEsperadaParaOPlacar)){
						imprimirMensagemDeErroDeUmaTag("cor da fonte para posição "+(i+1)+" Time: "+listaDeSpanDentroDaClasseTimes.get(i).getText()+"", tamanhoTextoJogosEsperado, corFonteAtualNasInformacoesDosJogos);
						return false;
					}
					
				}
				
				if(!bandeiraTimeDaCasa.isDisplayed()){
					imprimirMensagemDeErroGenerica("Bandeira do time da casa não está sendo exibida. ["+timeDaCasaAtual+"]");
					return false;
				}
				
				if(!bandeiraTimeDaCasa.isDisplayed()){
					imprimirMensagemDeErroGenerica("Bandeira do time visitante não está sendo exibida. ["+bandeiraTimeVisitante+"]");
					return false;
				}
			}
			
		}
		
		return true;
	}
}