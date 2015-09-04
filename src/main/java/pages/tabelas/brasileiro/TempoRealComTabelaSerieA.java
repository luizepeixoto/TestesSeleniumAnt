package pages.tabelas.brasileiro;

import br.com.infoglobo.pages.Navegador;

public class TempoRealComTabelaSerieA  extends TabelaSerieA {	
	
	public TempoRealComTabelaSerieA(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuLinhaSimELinhaNaoComDegradeParaOTempoReal() throws InterruptedException{
		
		String linhaParCorCinza = "rgba(249, 249, 249, 1)";
		String linhaImparCorBranca = "rgba(255, 255, 255, 1)";
		
		for(int i=0; i< totalDeLinhasHorizontaisDaTabela(); i++){
			
			String linhaDaLinhaAtual = listaComAsLinhasDaTabela().get(i).getCssValue("background-color");
			
			if(i%2 == 0){
				if(!linhaDaLinhaAtual.equals(linhaParCorCinza)){
					imprimirMensagemDeErro("linha cor cinza. Cor atual: ["+linhaDaLinhaAtual+"]", i);
					return false;
				}
			}else{
				if(!listaComAsLinhasDaTabela().get(i).getCssValue("background-color").equals(linhaImparCorBranca)){
					imprimirMensagemDeErro("linha cor branca. Cor atual: ["+linhaDaLinhaAtual+"]", i);
					return false;
				}
			}
			
			esperaCarregar1Segundo();
		}
		
		return true;
	}
}