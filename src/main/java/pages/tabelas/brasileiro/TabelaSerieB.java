package pages.tabelas.brasileiro;

import br.com.infoglobo.pages.Navegador;

public class TabelaSerieB  extends TabelaSerieA {	
	
	public TabelaSerieB(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuTextoDoRegulamentoSerieBCorreto(){
		String textoDoRegulamentoSerieBEsperado = "A Série B é disputada por 20 clubes em dois turnos. Em cada turno, os times jogam entre si uma única vez. Os jogos do segundo turno são realizados na mesma ordem do primeiro, apenas com o mando de campo invertido. Será declarado campeão aquele time que obtiver o maior número de pontos após a disputa das 38 rodadas. Os quatro primeiros colocados garantem vaga na Série A de 2016. Os quatro últimos são rebaixados para a Série C no ano seguinte.\nEm caso de empate por pontos entre dois clubes, os critérios de desempates são adotados na seguinte ordem: número de vitórias, saldo de gols, gols pró, confronto direto, menor número de cartões vermelhos, menor número de cartões amarelos e sorteio.";
		String textoDoRegulamentoSerieBAtual = acessaRegulamento().getText();
	
		if(!textoDoRegulamentoSerieBEsperado.equals(textoDoRegulamentoSerieBAtual)){
			System.out.println("O texto esperado está diferente. \nTexto esperado ["+textoDoRegulamentoSerieBEsperado+"]. \nTexto atual: ["+textoDoRegulamentoSerieBAtual+"]");
			return false;
		}
		
		return true;
	}
}