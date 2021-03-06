package pages.tabelas.brasileiro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabelaSerieARodadas  extends AceitacaoAbstractTest {	
	
	public TabelaSerieARodadas(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement acessaRodadas(){
		return getDriver().findElement(By.className("jogos-rodada"));
	}
	
	public boolean exibiuTabelaDeRodadas() {
		return acessaRodadas().isDisplayed();
	}
	
	public List<WebElement> listaComTodasAsRodadas(){
		return getDriver().findElements(By.xpath("//dl[contains(@class, 'cycle-slide')][not(contains(@class, 'sentinel'))]"));
	}
	
	public int quantidadeTotalDeRodadas(){
		return listaComTodasAsRodadas().size();
	}
	
	public boolean exibiuOTotalEsperadoDeRodadas(){
		int quantidadeEsperadaDeRodadas = 38;
		return quantidadeTotalDeRodadas() == quantidadeEsperadaDeRodadas;
	}

	public WebElement acessaNavegacao(){
		return acessaRodadas().findElement(By.className("navTabelas"));
	}
	
	public boolean exibiuBoxDeNavegacao() {
		
		if(!acessaNavegacao().findElement(By.className("prev")).isDisplayed() || 
				acessaNavegacao().findElement(By.className("prev")).getAttribute("href").isEmpty()){
			System.out.println("Não exibiu corretamente a navegação para a esquerda.");
			return false;
		}
		
		if(!acessaNavegacao().findElement(By.className("next")).isDisplayed() ||
				acessaNavegacao().findElement(By.className("next")).getAttribute("href").isEmpty()){
			System.out.println("Não exibiu corretamente a navegação para a direita.");
			return false;
		}
		
		return true;
	}
	
	public int procuraRodadaAtual(){
		
		int posicaoInicialDaTabela = 0;
		
		for(int i=0; i < quantidadeTotalDeRodadas(); i++){
			
			if(listaComTodasAsRodadas().get(i).getAttribute("class").contains("cycle-slide-active")){
				posicaoInicialDaTabela = i;
				return posicaoInicialDaTabela;
			}
		}
		
		return -1;
	}
	
	public void clicaParaProximaRodada(){
		getDriver().findElement(By.cssSelector("a.next")).click();
	}
	
	public boolean exibiuTituloEInformacoesDosJogosDeCadaRodada () throws InterruptedException {
		
		int novoTotal = procuraRodadaAtual() + 1; //Para paginar a rodada atual + 1
		
		if(procuraRodadaAtual() == -1){
			System.out.println("Não foi possível descobrir a posição atual da tabela.");
			return false;
		}
		
		if(procuraRodadaAtual() == quantidadeTotalDeRodadas()){
			novoTotal = quantidadeTotalDeRodadas();
		}
		
		for(int i = procuraRodadaAtual(); i<= novoTotal; i++){ //quantidadeTotalDeRodadas()
			
			WebElement rodadaAtual = listaComTodasAsRodadas().get(i); 
			List<WebElement> jogosDaRodadaAtual = rodadaAtual.findElements(By.tagName("dd"));
			
			for(int rodadas = 0; rodadas < jogosDaRodadaAtual.size(); rodadas++){
				
				WebElement jogoTimes = jogosDaRodadaAtual.get(rodadas).findElement(By.className("rodada")).findElement(By.className("confronto"));
				WebElement jogoDataHora = jogosDaRodadaAtual.get(rodadas).findElement(By.className("rodada")).findElement(By.className("servico"));
				
				String timeDaCasaNaPosicaoAtual = jogoTimes.findElement(By.className("time-casa")).findElement(By.className("sigla")).getAttribute("innerHTML");
				String timeDeForaNaPosicaoAtual = jogoTimes.findElement(By.className("time-fora")).findElement(By.className("sigla")).getAttribute("innerHTML");
				
				String placarFinal = jogoTimes.findElement(By.className("vs")).getText();
				
				if(!jogoTimes.findElement(By.className("time-casa")).findElement(By.tagName("img")).isDisplayed()){
					imprimirMensagemDeErro("escudo do time da casa (lado direito)["+timeDaCasaNaPosicaoAtual+"]", i);
					return false;
				}
				
				if(timeDaCasaNaPosicaoAtual.isEmpty()){
					imprimirMensagemDeErro("nome do time da casa (lado direito)", i);
					return false;
				}
				
				if(!jogoTimes.findElement(By.className("vs")).findElement(By.className("gols-casa")).isDisplayed()){
					imprimirMensagemDeErro("placar do time da casa (lado direito)["+timeDaCasaNaPosicaoAtual+"]", i);
					return false;
				}
				
				if(!placarFinal.contains("x")){
					imprimirMensagemDeErro("o X no meio do placar)", i);
					return false;
				}
				
				if(!jogoTimes.findElement(By.className("vs")).findElement(By.className("gols-fora")).isDisplayed()){
					imprimirMensagemDeErro("placar do time de fora (lado esquerdo)["+timeDeForaNaPosicaoAtual+"]", i);
					return false;
				}
				
				if(!jogoTimes.findElement(By.className("time-fora")).findElement(By.tagName("img")).isDisplayed()){
					imprimirMensagemDeErro("escudo do time de fora (lado esquerdo)["+timeDeForaNaPosicaoAtual+"]", i);
					return false;
				}
				
				if(timeDeForaNaPosicaoAtual.isEmpty()){
					imprimirMensagemDeErro("nome do time de fora (lado esquerdo)", i);
					return false;
				}
			
				if(jogoDataHora.findElement(By.className("dia")).getText().isEmpty()){
					imprimirMensagemDeErro("dia do jogo", i);
					return false;
				}
				
				if(jogoDataHora.findElement(By.className("estadio")).getText().isEmpty()){
					imprimirMensagemDeErro("estádio do jogo", i);
					return false;
				}
				
				if(jogoDataHora.findElement(By.className("dia")).getText().isEmpty()){
					imprimirMensagemDeErro("horário do jogo", i);
					return false;
				}
				
			}
			
			esperaCarregar(1);
			clicaParaProximaRodada();
			esperaCarregar(1);
			
		}
		return true;
	}
	
} 