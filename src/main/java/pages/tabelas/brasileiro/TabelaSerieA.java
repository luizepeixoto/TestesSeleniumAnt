package pages.tabelas.brasileiro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabelaSerieA  extends AceitacaoAbstractTest {	
	
	public TabelaSerieA(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public String exibiuTituloDaTabela(){
		return getDriver().findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText();
	}
	
	public WebElement acessaTabelaDeClassificacao(){
		return getDriver().findElement(By.className("classificacao-jogos"));
	}
	
	public boolean exibiuATabelaDeClassificacao(){
		return acessaTabelaDeClassificacao().isDisplayed();
	}
	
	private List<WebElement> listaComAsColunasDosTitulosDaTabela() {
		return acessaTabelaDeClassificacao().findElement(By.tagName("thead")).findElements(By.tagName("th"));
	}
	
	public List<WebElement> listaComAsLinhasDaTabela() {
		return acessaTabelaDeClassificacao().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}
	
	public int totalDeColunasDaTabela() {
		return listaComAsColunasDosTitulosDaTabela().size();
	}
	
	public int totalDeLinhasHorizontaisDaTabela() {
		return listaComAsLinhasDaTabela().size();
	}
	
	public boolean exibiuOTituloDasColunasDaTabelaDeClassificacao() {
		
		String colunaPosicao1 = "CLASSIFICAÇÃO";
		String colunaPosicao2 = "P";
		String colunaPosicao3 = "J";
		String colunaPosicao4 = "V";
		String colunaPosicao5 = "E";
		String colunaPosicao6 = "D";
		String colunaPosicao7 = "GP";
		String colunaPosicao8 = "GC";
		String colunaPosicao9 = "SG";
		String colunaPosicao10 = "%";
		
		if(!listaComAsColunasDosTitulosDaTabela().get(0).getText().equals(colunaPosicao1)){
			System.out.println("Não exibiu o título de "+colunaPosicao1+". Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(0).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(1).getText().equals(colunaPosicao2)){
			System.out.println("Não exibiu a coluna "+colunaPosicao2+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(1).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(2).getText().equals(colunaPosicao3)){
			System.out.println("Não exibiu a coluna "+colunaPosicao3+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(2).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(3).getText().equals(colunaPosicao4)){
			System.out.println("Não exibiu a coluna "+colunaPosicao4+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(3).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(4).getText().equals(colunaPosicao5)){
			System.out.println("Não exibiu a coluna "+colunaPosicao5+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(4).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(5).getText().equals(colunaPosicao6)){
			System.out.println("Não exibiu a coluna "+colunaPosicao6+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(5).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(6).getText().equals(colunaPosicao7)){
			System.out.println("Não exibiu a coluna "+colunaPosicao7+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(6).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(7).getText().equals(colunaPosicao8)){
			System.out.println("Não exibiu a coluna "+colunaPosicao8+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(7).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(8).getText().equals(colunaPosicao9)){
			System.out.println("Não exibiu a coluna "+colunaPosicao9+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(8).getText()+"]");
			return false;
		}
		
		if(!listaComAsColunasDosTitulosDaTabela().get(9).getText().equals(colunaPosicao10)){
			System.out.println("Não exibiu a coluna "+colunaPosicao10+" . Exibido: ["+listaComAsColunasDosTitulosDaTabela().get(9).getText()+"]");
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuLinhaSimELinhaNaoComDegrade(){
		
		String linhaParCorCinza = "rgba(249, 249, 249, 1)";
		String linhaImparCorBranca = "rgba(0, 0, 0, 0)";
		
		for(int i=0; i< totalDeLinhasHorizontaisDaTabela(); i++){
			
			String linhaDaLinhaAtual = listaComAsLinhasDaTabela().get(i).getCssValue("background-color");
			
			if(i%2 == 0){
				if(!linhaDaLinhaAtual.equals(linhaParCorCinza)){
					imprimirMensagemDeErro("linha cor cinza. Cor atual: ["+linhaDaLinhaAtual+"]", i);
					return false;
				}
			}else{
				if(!linhaDaLinhaAtual.equals(linhaImparCorBranca)){
					imprimirMensagemDeErro("linha cor branca. Cor atual: ["+linhaDaLinhaAtual+"]", i);
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean exibiuAsColunasDaTabelaDeClassificacao(){
		
		int totalDeLinhasDaTabela = listaComAsLinhasDaTabela().size();
		
		for(int i=0; i < totalDeLinhasDaTabela; i++){
			
			WebElement posicaoAtual = listaComAsLinhasDaTabela().get(i);
			List<WebElement> totalDeColunasDaTabela = posicaoAtual.findElements(By.tagName("td"));
			
			for(int y=0; y < totalDeColunasDaTabela.size(); y++){
				 
				if(totalDeColunasDaTabela.get(y).getText().isEmpty()){
					System.out.println("Linha ["+ i+1 +"] coluna ["+ (y+1) +"] não está exibindo informação.");
					return false;
				}
				
			}
		}
		return true;
	}

	public boolean exibiuUmaTarjaVerdeAoLadoDasQuatroPrimeirasColunas(){
		
		String corVerdeEsperadaLateralDaTabela = "rgba(0, 128, 0, 1)";
		
		for(int i = 0; i<=3; i++){
			
			if(!listaComAsLinhasDaTabela().get(i).getAttribute("class").contains("classificado")){
				imprimirMensagemDeErro("posição sem marcação de classificado", i);
				return false;
			}

			if(!listaComAsLinhasDaTabela().get(i).getCssValue("border-left-color").equals(corVerdeEsperadaLateralDaTabela)){
				imprimirMensagemDeErro("posição sem a cor de classificado", i);
				return false;
			}
		}
		
		return true;
	}
	
	public boolean exibiuUmaTarjaVermelhaAoLadoDasQuatroUltimasColunas(){
		
		int total = listaComAsLinhasDaTabela().size() - 1;
		int posicaoFimRebaxamento = total - 3;
		
		String corVermelhaEsperadaLateralDaTabela = "rgba(255, 0, 0, 1)";
		
		for(int i = total; i >= posicaoFimRebaxamento; i--){
			
			if(!listaComAsLinhasDaTabela().get(i).getAttribute("class").contains("rebaixado")){
				imprimirMensagemDeErro("posição sem marcação de rebaixamento", i);
				return false;
			}

			if(!listaComAsLinhasDaTabela().get(i).getCssValue("border-left-color").equals(corVermelhaEsperadaLateralDaTabela)){
				imprimirMensagemDeErro("posição sem a cor de rebaixamento", i);
				return false;
			}
		}
		
		return true;
	}

	public WebElement acessaLegendaDaFotogaleria(){
		return getDriver().findElement(By.className("legendas"));
	}
	
	public boolean exibiuALegendaNoFimDaPagina(){
		return acessaLegendaDaFotogaleria().isDisplayed();
	}
	
	public boolean exibiuALegendaDeClassificadosCorretamente(){
		
		WebElement acessaClasseClassificados = acessaLegendaDaFotogaleria().findElement(By.className("classificados"));
		String corVerdeEsperada = "rgba(0, 128, 0, 1)";
		String corAtual = acessaClasseClassificados.findElement(By.tagName("span")).getCssValue("background-color");
		String legendaEsperada = "Classificados para libertadores";
		String legendaAtual = acessaClasseClassificados.getText();
		String tamanhoAtualDaFonteDaLegenda = "12px";
		String tamanhoEsperadoDaFonteDaLegenda = acessaClasseClassificados.findElement(By.tagName("span")).getCssValue("font-size");
		
		if(!corAtual.equals(corVerdeEsperada)){
			System.out.println("Não exibiu cor correta para o quadrado da legenda de classificados. Esperado: ["+corVerdeEsperada+"] Exibido: ["+corAtual+"]");
			return false;
		}
		
		if(!legendaAtual.equals(legendaEsperada)){
			System.out.println("Não exibiu o texto correto para a legenda de classificados. Texto esperado: ["+legendaEsperada+"] - Texto exibido: ["+legendaAtual+"]");
			return false;
		}
		
		if(!tamanhoAtualDaFonteDaLegenda.equals(tamanhoEsperadoDaFonteDaLegenda)){
			System.out.println("Não exibiu o tamanho correto para na fonte da legenda de classificados. Texto esperado: ["+tamanhoEsperadoDaFonteDaLegenda+"] - Texto exibido: ["+tamanhoAtualDaFonteDaLegenda+"]");
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuALegendaDeRebaixadosCorretamente(){
		
		WebElement acessaClasseRebaixados = acessaLegendaDaFotogaleria().findElement(By.className("rebaixados"));
		String corVermelhoEsperada = "rgba(255, 0, 0, 1)";
		String corAtual = acessaClasseRebaixados.findElement(By.tagName("span")).getCssValue("background-color");
		String legendaEsperada = "Rebaixados para série B";
		String legendaAtual = acessaClasseRebaixados.getText();
		String tamanhoAtualDaFonteDaLegenda = "12px";
		String tamanhoEsperadoDaFonteDaLegenda = acessaClasseRebaixados.findElement(By.tagName("span")).getCssValue("font-size");
		
		if(!corAtual.equals(corVermelhoEsperada)){
			System.out.println("Não exibiu cor correta para o quadrado da legenda de classificados. Esperado: ["+corVermelhoEsperada+"] Exibido: ["+corAtual+"]");
			return false;
		}
		
		if(!legendaAtual.equals(legendaEsperada)){
			System.out.println("Não exibiu o texto correto para a legenda de classificados. Texto esperado: ["+legendaEsperada+"] - Texto exibido: ["+legendaAtual+"]");
			return false;
		}
		
		if(!tamanhoAtualDaFonteDaLegenda.equals(tamanhoEsperadoDaFonteDaLegenda)){
			System.out.println("Não exibiu o tamanho correto para na fonte da legenda de classificados. Texto esperado: ["+tamanhoEsperadoDaFonteDaLegenda+"] - Texto exibido: ["+tamanhoAtualDaFonteDaLegenda+"]");
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuALegendaDeClassificadosDaSerieBCorretamente(){
		
		WebElement acessaClasseClassificados = acessaLegendaDaFotogaleria().findElement(By.className("classificados"));
		String corVerdeEsperada = "rgba(0, 128, 0, 1)";
		String corAtual = acessaClasseClassificados.findElement(By.tagName("span")).getCssValue("background-color");
		String legendaEsperada = "Classificados para série A";
		String legendaAtual = acessaClasseClassificados.getText();
		String tamanhoAtualDaFonteDaLegenda = "12px";
		String tamanhoEsperadoDaFonteDaLegenda = acessaClasseClassificados.findElement(By.tagName("span")).getCssValue("font-size");
		
		if(!corAtual.equals(corVerdeEsperada)){
			System.out.println("Não exibiu cor correta para o quadrado da legenda de classificados. Esperado: ["+corVerdeEsperada+"] Exibido: ["+corAtual+"]");
			return false;
		}
		
		if(!legendaAtual.equals(legendaEsperada)){
			System.out.println("Não exibiu o texto correto para a legenda de classificados. Texto esperado: ["+legendaEsperada+"] - Texto exibido: ["+legendaAtual+"]");
			return false;
		}
		
		if(!tamanhoAtualDaFonteDaLegenda.equals(tamanhoEsperadoDaFonteDaLegenda)){
			System.out.println("Não exibiu o tamanho correto para na fonte da legenda de classificados. Texto esperado: ["+tamanhoEsperadoDaFonteDaLegenda+"] - Texto exibido: ["+tamanhoAtualDaFonteDaLegenda+"]");
			return false;
		}
		
		return true;
	}

	public boolean exibiuALegendaDeRebaixadosDaSerieBCorretamente(){
	
		WebElement acessaClasseRebaixados = acessaLegendaDaFotogaleria().findElement(By.className("rebaixados"));
		String corVermelhoEsperada = "rgba(255, 0, 0, 1)";
		String corAtual = acessaClasseRebaixados.findElement(By.tagName("span")).getCssValue("background-color");
		String legendaEsperada = "Rebaixados para série C";
		String legendaAtual = acessaClasseRebaixados.getText();
		String tamanhoAtualDaFonteDaLegenda = "12px";
		String tamanhoEsperadoDaFonteDaLegenda = acessaClasseRebaixados.findElement(By.tagName("span")).getCssValue("font-size");
	
		if(!corAtual.equals(corVermelhoEsperada)){
			System.out.println("Não exibiu cor correta para o quadrado da legenda de classificados. Esperado: ["+corVermelhoEsperada+"] Exibido: ["+corAtual+"]");
			return false;
		}
		
		if(!legendaAtual.equals(legendaEsperada)){
			System.out.println("Não exibiu o texto correto para a legenda de classificados. Texto esperado: ["+legendaEsperada+"] - Texto exibido: ["+legendaAtual+"]");
			return false;
		}
		
		if(!tamanhoAtualDaFonteDaLegenda.equals(tamanhoEsperadoDaFonteDaLegenda)){
			System.out.println("Não exibiu o tamanho correto para na fonte da legenda de classificados. Texto esperado: ["+tamanhoEsperadoDaFonteDaLegenda+"] - Texto exibido: ["+tamanhoAtualDaFonteDaLegenda+"]");
			return false;
		}
		
		return true;
	}
	
	public WebElement acessaBotaoDeRegulamento(){
		return getDriver().findElement(By.className("legendas")).findElement(By.className("button"));
	}
	
	public boolean exibiuBotaoDeRegulamento() {
		return acessaBotaoDeRegulamento().isDisplayed();
	}

	public String exibiuTituloDoBotaoDeRegulamento() {
		return acessaBotaoDeRegulamento().findElement(By.tagName("a")).getText();
	}

	public void clicarNoBotaoDeRegulamento() {
		getDriver().findElement(By.linkText("ABRIR REGULAMENTO")).click();
	}
	
	public WebElement acessaRegulamento(){
		return getDriver().findElement(By.className("regulamento")).findElement(By.className("corpo"));
	}
	
	public boolean exibiuTextoDoRegulamento() {
		return !acessaRegulamento().findElement(By.tagName("p")).getText().isEmpty();
	}

	public boolean exibiuCorCinzaParaOBoxComOTextoDoRegulamento() {
		String backgroundDoBoxEsperado = "rgba(249, 249, 249, 1)";
		String backgroundDoBoxAtual = acessaRegulamento().getCssValue("background-color");
		
		if(!backgroundDoBoxEsperado.equals(backgroundDoBoxAtual)){
			System.out.println("Background do box está incorreto. Correto: ["+backgroundDoBoxEsperado+"] - Atual: ["+backgroundDoBoxAtual+"]");
			return false;
		}
		
		return true;
	}

	public boolean exibiuTextoEAFonteDoRegulamentoCorretos() {
		String fonteEsperada = "Georgia, sans-serif";
		String TamanhoFonteEsperada = "18px";
		String fonteAtual = acessaRegulamento().findElement(By.tagName("p")).getCssValue("font-family");
		String TamanhoFonteAtual = acessaRegulamento().findElement(By.tagName("p")).getCssValue("font-size");
		
		if(!fonteEsperada.equals(fonteAtual)){
			System.out.println("A fonte do box está incorreta. Fonte correta: ["+fonteEsperada+"] - Atual: ["+fonteAtual+"]");
			return false;
		}
		
		if(!TamanhoFonteEsperada.equals(TamanhoFonteAtual)){
			System.out.println("O tamanho da fonte está incorreto. Tamanho correto: ["+TamanhoFonteEsperada+"] - Atual: ["+TamanhoFonteAtual+"]");
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuTextoDoRegulamentoSerieACorreto(){
		String textoDoRegulamentoSerieAEsperado = "A Série A é disputada por 20 clubes em dois turnos. Em cada turno, os times jogam entre si uma única vez. Os jogos do segundo turno são realizados na mesma ordem do primeiro, apenas com o mando de campo invertido. Será declarado campeão aquele time que obtiver o maior número de pontos após a disputa das 38 rodadas. Os quatro primeiros colocados garantem vaga na Copa Libertadores de 2016. Os quatro últimos são rebaixados para a Série B no ano seguinte.\nEm caso de empate por pontos entre dois clubes, os critérios de desempates são adotados na seguinte ordem: número de vitórias, saldo de gols, gols pró, confronto direto, menor número de cartões vermelhos, menor número de cartões amarelos e sorteio.";
		String textoDoRegulamentoSerieAAtual = acessaRegulamento().getText();
	
		if(!textoDoRegulamentoSerieAEsperado.equals(textoDoRegulamentoSerieAAtual)){
			System.out.println("O texto esperado está diferente. \nTexto esperado ["+textoDoRegulamentoSerieAEsperado+"]. \nTexto atual: ["+textoDoRegulamentoSerieAAtual+"]");
			return false;
		}
		
		return true;
	}
	
	public void clicarNoBotaoDeFecharRegulamento() {
		getDriver().findElement(By.linkText("FECHAR REGULAMENTO")).click();
	}

	public boolean deixouDeExibirOTextoDoRegulamento() {
			
		try {
			if(acessaRegulamento().isDisplayed()){
				System.out.println("Está exibindo o regulamento após ter clicado em fechar.");
				return false;
			}
		} catch (Exception e) {
		
		}
		
		return true;
	}
}