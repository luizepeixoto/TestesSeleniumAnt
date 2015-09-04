package pages.tabelas.copaAmerica;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class CopaAmericaPadrao extends CopaAmericaFases {	
	
	public CopaAmericaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement acessaFaseDeGrupo(){
		return getDriver().findElement(By.className("fase-de-grupos"));
	}
	
	public List<WebElement> listaComTodasOsGrupos(){
		return acessaFaseDeGrupo().findElements(By.className("jogos-tabela"));
	}
	
	public WebElement acessaOPrimeiroGrupo(int posicaoDoGrupo){
		return listaComTodasOsGrupos().get(posicaoDoGrupo);
	}
	
	public void ScrollAteOTitulo(int posicaoDoGrupo) throws InterruptedException{
		WebElement acessaTitulo = acessaOPrimeiroGrupo(posicaoDoGrupo).findElement(By.tagName("h3"));
		executarScroll(acessaTitulo.getLocation());
		esperaCarregar2Segundos();
	}
	
	public boolean exibiuTituloDoGrupoCorretamente(int posicaoDoGrupo, String tituloDoGrupoEsperado) {
		
		WebElement acessaTitulo = acessaOPrimeiroGrupo(posicaoDoGrupo).findElement(By.tagName("div")).findElement(By.tagName("h3"));
		
		String tituloAtual = acessaTitulo.getText();
		
		String fonteTituloEsperado = "OgloboCondensed, Arial, sans-serif";
		String fonteTituloAtual = acessaTitulo.getCssValue("font-family");
		
		String tamanhoFonteDoTituloEsperado = "28px";
		String tamanhoFonteDoTituloAtual = acessaTitulo.getCssValue("font-size");
		
		String corTituloEsperado = "rgba(31, 43, 61, 1)";
		String corTituloEAtual = acessaTitulo.getCssValue("color");
		
		if(!tituloAtual.equals(tituloDoGrupoEsperado)){
			imprimirMensagemDeErroDeUmaTag("título do grupo", tituloDoGrupoEsperado, tituloAtual);
			return false;
		}
		
		if(!fonteTituloEsperado.equals(fonteTituloAtual)){
			imprimirMensagemDeErroDeUmaTag("fonte do titulo", fonteTituloEsperado, fonteTituloAtual);
			return false;
		}
		
		if(!tamanhoFonteDoTituloEsperado.equals(tamanhoFonteDoTituloAtual)){
			imprimirMensagemDeErroDeUmaTag("tamaho da fonte do titulo", tamanhoFonteDoTituloEsperado, tamanhoFonteDoTituloAtual);
			return false;
		}
		
		if(!corTituloEsperado.equals(corTituloEAtual)){
			imprimirMensagemDeErroDeUmaTag("cor da fonte do titulo", corTituloEsperado, corTituloEAtual);
			return false;
		}
		
		return true;
	}
	
	public WebElement acessaTabelaDeClassificacaoDoGrupoA(int posicaoDoGrupo){
		return acessaOPrimeiroGrupo(posicaoDoGrupo).findElement(By.className("classificacao-jogos"));
	}
	
	public boolean exibiuTabelaDeClassificacaoDoGrupoSelecionado(int posicaoDoGrupo){
		return acessaTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).isDisplayed();
	}
	
	public List<WebElement> acessaCabecalhoDeClassificacaoDoGrupoA(int posicaoDoGrupo){
		return acessaTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).findElement(By.tagName("table")).findElement(By.tagName("thead")).findElements(By.tagName("th"));
	}
	
	public boolean exibiuTituloDasColunasDasTabelaDeClassificacaoDoGrupoSelecionado(int posicaoDoGrupo){
		
		String posicao1Esperada = "CLASSIFICAÇÃO";
		String posicao2Esperada = "P";
		String posicao3Esperada = "J";
		String posicao4Esperada = "V";
		String posicao5Esperada = "E";
		String posicao6Esperada = "D";
		String posicao7Esperada = "GP";
		String posicao8Esperada = "GC";
		String posicao9Esperada = "SG";
		String posicao10Esperada = "%";
		
		String posicao1Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(0).getText();
		String posicao2Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(1).getText();
		String posicao3Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(2).getText();
		String posicao4Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(3).getText();
		String posicao5Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(4).getText();
		String posicao6Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(5).getText();
		String posicao7Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(6).getText();
		String posicao8Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(7).getText();
		String posicao9Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(8).getText();
		String posicao10Atual = acessaCabecalhoDeClassificacaoDoGrupoA(posicaoDoGrupo).get(9).getText();
		
		if(!posicao1Esperada.equals(posicao1Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 1", posicao1Esperada, posicao1Atual);
			return false;
		}
		
		if(!posicao2Esperada.equals(posicao2Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 2", posicao2Esperada, posicao2Atual);
			return false;
		}
		
		if(!posicao3Esperada.equals(posicao3Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 3", posicao3Esperada, posicao3Atual);
			return false;
		}
		
		if(!posicao4Esperada.equals(posicao4Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 4", posicao4Esperada, posicao4Atual);
			return false;
		}
		
		if(!posicao5Esperada.equals(posicao5Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 5", posicao5Esperada, posicao5Atual);
			return false;
		}
		
		if(!posicao6Esperada.equals(posicao6Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 6", posicao6Esperada, posicao6Atual);
			return false;
		}
		
		if(!posicao7Esperada.equals(posicao7Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 7", posicao7Esperada, posicao7Atual);
			return false;
		}
		
		if(!posicao8Esperada.equals(posicao8Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 8", posicao8Esperada, posicao8Atual);
			return false;
		}
		
		if(!posicao9Esperada.equals(posicao9Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 9", posicao9Esperada, posicao9Atual);
			return false;
		}
		
		if(!posicao10Esperada.equals(posicao10Atual)){
			imprimirMensagemDeErroDeUmaTag("cabeçalho posição 10", posicao10Esperada, posicao10Atual);
			return false;
		}
		
		return true;
		
	}
	
	public List<WebElement> acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(int posicaoDoGrupo){
		return acessaTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}
	
	public int TotalDeLinhasDoGrupoA(int posicaoDoGrupo){
		return acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).size();
	}
	
	public List<WebElement> acessaQuantidadeDeColunasTabelaDeClassificacaoDoGrupoA(int posicaoDoGrupo){
		return acessaTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElement(By.tagName("tr")).findElements(By.tagName("td"));
	}
	
	public int TotalDeColunasDoGrupoA(int posicaoDoGrupo){
		return acessaQuantidadeDeColunasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).size();
	}
	
	public boolean exibiuConteudoValidoParaCadaUmaDasColunasDasTabelaDeClassificacaoDoGrupoSelecionado(int posicaoDoGrupo){
		
		for(int i=0; i < TotalDeLinhasDoGrupoA(posicaoDoGrupo); i++){
			
			WebElement linhaAtual = acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(i);
			List<WebElement> totalDeColunasDaTabela = linhaAtual.findElements(By.tagName("td"));
			
			for(int y=0; y < totalDeColunasDaTabela.size(); y++){
				
				if(totalDeColunasDaTabela.get(y).getText().isEmpty()){
					System.out.println("Linha ["+ i+1 +"] coluna ["+ (y+1) +"] não está exibindo informação.");
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean exibiuUmaTarjaVerdeParaOsDoisPrimeirosTimesDoGrupoSelecionado(int posicaoDoGrupo){
		
		WebElement acessaAPrimeiraLinha = acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(0);
		WebElement acessaASegundaLinha = acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(1);
		
		String corVerdeEsperada = "rgba(0, 128, 0, 1)";;
		
		String corDaPrimeiraLinha = acessaAPrimeiraLinha.getCssValue("border-left-color");
		String corDaSegundaLinha = acessaASegundaLinha.getCssValue("border-left-color");
		
		if(!corDaPrimeiraLinha.equals(corVerdeEsperada)){
			imprimirMensagemDeErroDeUmaTag("primeira posição sem marcação de classificado", corVerdeEsperada, corDaPrimeiraLinha);
			return false;
		}
		
		if(!corDaSegundaLinha.equals(corVerdeEsperada)){
			imprimirMensagemDeErroDeUmaTag("segunda posição sem marcação de classificado", corVerdeEsperada, corDaSegundaLinha);
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuUmaTarjaAzulParaOTerceiroTimeDoGrupoSelecionado(int posicaoDoGrupo){
		
		WebElement acessaATerceiraLinha = acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(2);
		
		String corAzulEsperada = "rgba(0, 0, 255, 1)";;
		String corDaTerceiraLinha = acessaATerceiraLinha.getCssValue("border-left-color");
		
		if(!corDaTerceiraLinha.equals(corAzulEsperada) || !acessaATerceiraLinha.getAttribute("class").contains("melhor2")){
			imprimirMensagemDeErroDeUmaTag("terceira posição sem marcação azul", corAzulEsperada, corDaTerceiraLinha);
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuOQuartoTimeDoGrupoSelecionadoSemTarja(int posicaoDoGrupo){
		
		WebElement acessaAQuartaLinha = acessaQuantidadeDeLinhasTabelaDeClassificacaoDoGrupoA(posicaoDoGrupo).get(3);
		
		String corEsperada = "rgba(255, 255, 255, 1)";
		String corDaTerceiraLinha = acessaAQuartaLinha.getCssValue("border-left-color");
		
		if(!corDaTerceiraLinha.equals(corEsperada)){
			imprimirMensagemDeErroDeUmaTag("quarta posição com marcação", corEsperada, corDaTerceiraLinha);
			return false;
		}
		
		return true;
	}

	public boolean exibiuLinhasDaTabelaDoGrupoSelecionadoEmDegrade(int posicaoDoGrupo) {
		
		String linhaParCorCinza = "rgba(249, 249, 249, 1)";
		String linhaImparCorBranca = "rgba(0, 0, 0, 0)";
		
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
	
	public WebElement acessaTabelaDeRodadasDoGrupoA(int posicaoDoGrupo){
		return acessaOPrimeiroGrupo(posicaoDoGrupo).findElement(By.className("jogos-rodada"));
	}
	
	public boolean exibiuTabelaDeRodadasDoGrupoSelecionado(int posicaoDoGrupo){
		return acessaTabelaDeRodadasDoGrupoA(posicaoDoGrupo).isDisplayed();
	}
	
	public List<WebElement> listaComAsRodadasDoGrupoDesejado(int posicaoDoGrupo){
		return acessaTabelaDeRodadasDoGrupoA(posicaoDoGrupo).findElement(By.tagName("div")).findElements(By.xpath("dl[contains(@class, 'cycle-slide')][not(contains(@class, 'cycle-sentinel'))]"));
	}
	
	public int totalDeRodadasDoGrupoA(int posicaoDoGrupo){
		return listaComAsRodadasDoGrupoDesejado(posicaoDoGrupo).size();
	}
	
	public void executaPaginacao(String paginacaoBoxAtual){
		getDriver().findElement(By.cssSelector(paginacaoBoxAtual)).click();
	}
	
	public boolean exibiuOInformacoesDasRodadasDoGrupoSelecionado(int posicaoDoGrupo, String paginacaoBoxAtual) throws InterruptedException{
		
		String estiloDaFonteEsperado = "uppercase";
		String tamanhoDaFonteDaPartidaEsperado = "18px";
		String fonteEsperada = "OgloboCondensed, Arial, sans-serif";
		String widthHeightDaBandeiraEsperado = "40px";
		String tamanhoDaFonteDoPlacarEsperado = "27px";
		List<String> alinhamentoBandeiraEsperado = Arrays.asList("left", "right");
		
		int quantidadeDeVezesAPaginar = totalDeRodadasDoGrupoA(posicaoDoGrupo) - Integer.parseInt("1");
		int totalDePaginacoes = 0;
		
		for(int i=0; i < totalDeRodadasDoGrupoA(posicaoDoGrupo); i++){
			
			List<WebElement> listaComJogosDaRodada = listaComAsRodadasDoGrupoDesejado(posicaoDoGrupo).get(i).findElements(By.tagName("dd"));
			
			String tituloEsperado = ""+(i+1)+"ª RODADA";
			
			String tituloNaPosicaoAtual = listaComAsRodadasDoGrupoDesejado(posicaoDoGrupo).get(i).findElement(By.tagName("dt")).getText();
			
			if(!tituloNaPosicaoAtual.equals(tituloEsperado)){
				imprimirMensagemDeErroDeUmaTag("título rodadas", tituloEsperado, tituloNaPosicaoAtual);
				return false;
			}
			
			/*Validação das tags DD que guardam as informações dos jogos - Classe Serviço*/
			for(int h=0; h < listaComJogosDaRodada.size(); h++){
				
				WebElement informacaoDoJogoNaPosicaoAtual = listaComJogosDaRodada.get(h).findElement(By.className("servico"));
				
				String dataDoJogo = informacaoDoJogoNaPosicaoAtual.findElement(By.className("data")).getText();
				String estadioDoJogo = informacaoDoJogoNaPosicaoAtual.findElement(By.className("estadio")).getText();
				String horaDoJogo = informacaoDoJogoNaPosicaoAtual.findElement(By.className("hora")).getText();
				
				if(dataDoJogo.isEmpty()){
					imprimirMensagemDeErro("data do jogo", i);
					return false;
				}
				
				if(estadioDoJogo.isEmpty()){
					imprimirMensagemDeErro("estádio do jogo", i);
					return false;
				}
				
				if(horaDoJogo.isEmpty()){
					imprimirMensagemDeErro("hora do jogo", i);
					return false;
				}
			}
			
			/*Validação das tags DD que guardam as informações dos jogos - Classe confronto*/
			for(int y=0; y < listaComJogosDaRodada.size(); y++){
				
				WebElement acessaTimeAtual = listaComJogosDaRodada.get(y).findElement(By.className("confronto"));
				
				List<WebElement> listaComTimesDeCadaJogo = acessaTimeAtual.findElements(By.className("times"));
				List<WebElement> listaDeGolsDeCadaJogo = acessaTimeAtual.findElement(By.className("vs")).findElements(By.tagName("span"));
				
				for(int j=0; j < listaComTimesDeCadaJogo.size(); j++){

					WebElement bandeirinhaPosicaoAtual = listaComTimesDeCadaJogo.get(j).findElement(By.tagName("img"));
					WebElement timePosicaoAtual = listaComTimesDeCadaJogo.get(j).findElement(By.className("sigla"));
					
					String estiloDaFonteDaPartidaAtual = timePosicaoAtual.getCssValue("text-transform");
					String tamanhoDaFonteDaPartidaAtual = timePosicaoAtual.getCssValue("font-size");
					String fonteDaPartidaAtual = timePosicaoAtual.getCssValue("font-family");
					String widthDaBandeiraAtual = bandeirinhaPosicaoAtual.getCssValue("width");
					String heightDaBandeiraAtual = bandeirinhaPosicaoAtual.getCssValue("height");
					String alinhamentoBandeiraAtual = bandeirinhaPosicaoAtual.getCssValue("float");
					
					if(!estiloDaFonteDaPartidaAtual.equals(estiloDaFonteEsperado)){
						imprimirMensagemDeErroDeUmaTag("fonte em uppercase", estiloDaFonteEsperado, estiloDaFonteDaPartidaAtual);
						return false;
					}
					
					if(!tamanhoDaFonteDaPartidaAtual.equals(tamanhoDaFonteDaPartidaEsperado)){
						imprimirMensagemDeErroDeUmaTag("tamanho da fonte", tamanhoDaFonteDaPartidaEsperado, tamanhoDaFonteDaPartidaAtual);
						return false;
					}
					
					if(!fonteDaPartidaAtual.equals(fonteEsperada)){
						imprimirMensagemDeErroDeUmaTag("fonte da partida", fonteEsperada, fonteDaPartidaAtual);
						return false;
					}
					
					if(!bandeirinhaPosicaoAtual.isDisplayed()){
						imprimirMensagemDeErro("bandeirinha", j);
						return false;
					}
					
					if(!widthDaBandeiraAtual.equals(widthHeightDaBandeiraEsperado)){
						imprimirMensagemDeErroDeUmaTag("width do ícone da bandeira", widthHeightDaBandeiraEsperado, widthDaBandeiraAtual);
						return false;
					}
					
					if(!heightDaBandeiraAtual.equals(widthHeightDaBandeiraEsperado)){
						imprimirMensagemDeErroDeUmaTag("height do ícone da bandeira", widthHeightDaBandeiraEsperado, heightDaBandeiraAtual);
						return false;
					}
					
					if( (!alinhamentoBandeiraEsperado.get(0).contains(alinhamentoBandeiraAtual)) &&  (!alinhamentoBandeiraEsperado.get(1).contains(alinhamentoBandeiraAtual)) ){
						imprimirMensagemDeErroGenerica("Valor de alinhamento do ícone da bandeira incorreto. \nPossíveis Valores: "+alinhamentoBandeiraEsperado+" \nValor Atual: "+alinhamentoBandeiraAtual+"");
						return false;
					}
				}
				
				for(int w=0; w < listaDeGolsDeCadaJogo.size(); w++){
					
					WebElement golPosicaoAtual = listaDeGolsDeCadaJogo.get(w);
					
					String estiloDaFonteDaPlacarAtual = golPosicaoAtual.getCssValue("text-transform");
					String fonteDoPlacarAtual = golPosicaoAtual.getCssValue("font-family");
					String tamanhoDaFonteDoPlacarAtual = golPosicaoAtual.getCssValue("font-size");
				
					if(golPosicaoAtual.getText().isEmpty()){
						imprimirMensagemDeErro("gol", w);
						return false;
					}
					
					if(!estiloDaFonteDaPlacarAtual.equals(estiloDaFonteEsperado)){
						imprimirMensagemDeErroDeUmaTag("fonte em uppercase do placar", estiloDaFonteEsperado, estiloDaFonteDaPlacarAtual);
						return false;
					}
					
					if(!fonteDoPlacarAtual.equals(fonteEsperada)){
						imprimirMensagemDeErroDeUmaTag("fonte do placar", fonteEsperada, fonteDoPlacarAtual);
						return false;
					}
					
					if(!tamanhoDaFonteDoPlacarAtual.equals(tamanhoDaFonteDoPlacarEsperado)){
						imprimirMensagemDeErroDeUmaTag("tamanho da fonte do placar", tamanhoDaFonteDoPlacarEsperado, tamanhoDaFonteDoPlacarAtual);
						return false;
					}
				}
				
			}
			
			if(totalDePaginacoes < quantidadeDeVezesAPaginar){
				totalDePaginacoes++;
				executaPaginacao(paginacaoBoxAtual);
				esperaCarregar(1);
			}
			
		}
		
		return true;
	}
}