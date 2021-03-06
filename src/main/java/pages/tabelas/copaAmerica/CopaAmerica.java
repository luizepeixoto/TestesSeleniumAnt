package pages.tabelas.copaAmerica;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class CopaAmerica extends CopaAmericaPadrao {	
	
	public CopaAmerica(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement obterTabela(){	
		return getDriver().findElement(By.className("page-copa-america2015"));
	}
	
	public boolean exibiuTituloDaTabela(){
		return !obterTabela().findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText().isEmpty();
	}
	
	private WebElement obterOMenuDaTabela() {
		return obterTabela().findElement(By.className("menu-camp"));
	}
	
	public boolean exibiuOMenuDaTabela() {
		return obterOMenuDaTabela().isDisplayed();
	}
	
	private List<WebElement> obterListaDeOpcoesDoMenu() {
		return obterOMenuDaTabela().findElements(By.tagName("li"));
	}
	
	protected WebElement obterBotaoPrimeiraFase() {
		return obterListaDeOpcoesDoMenu().get(0);
	}
	
	public boolean exibiuOpcaoDePrimeiraFase() {
		return obterBotaoPrimeiraFase().isDisplayed();
	}
	
	protected WebElement obterBotaoDasQuartasDeFinal() {
		return obterListaDeOpcoesDoMenu().get(1);
	}
	
	public boolean exibiuOpcaoDaFaseQuartasDeFinal() {
		return obterBotaoDasQuartasDeFinal().isDisplayed();
	}
	
	protected WebElement obterBotaoDaFaseSemifinal() {
		return obterListaDeOpcoesDoMenu().get(2);
	}
	
	public boolean exibiuOpcaoDaFaseSemifinal() {
		return obterBotaoDaFaseSemifinal().isDisplayed();
	}
	
	protected WebElement obterBotaoDaFaseFinal() {
		return obterListaDeOpcoesDoMenu().get(3);
	}
	
	public boolean exibiuOpcaoDaFaseFinal() {
		return obterBotaoDaFaseFinal().isDisplayed();
	}
	
	public String exibiuTituloDaPrimeiraFaseNoMenu() {
		return obterBotaoPrimeiraFase().getText();
	}
	
	public String exibiuTituloDasQuartasDeFinalNoMenu() {
		return obterBotaoDasQuartasDeFinal().getText();
	}
	
	public String exibiuTituloDaSemifinalNoMenu() {
		return obterBotaoDaFaseSemifinal().getText();
	}
	
	public String exibiuTituloDaFinalNoMenu() {
		return obterBotaoDaFaseFinal().getText();
	}
	
	private WebElement obterFaseAtual() {
		return obterTabela().findElement(By.xpath("//li[contains(@class, 'active')]"));
	}

	public boolean exibiuAFaseAtualAberta() {
		if(!obterFaseAtual().isDisplayed()){
			imprimirMensagemDeErroGenerica("Não está exibindo a fase mais atual aberta.");
			return false;
		}
		
		return true;
	}
	
	public boolean acessaAFaseDesejada(int faseDesejada){
		
		String faseMaisAtual = obterFaseAtual().findElement(By.tagName("a")).getText();
		String faseEsperada = obterListaDeOpcoesDoMenu().get(faseDesejada).getText();
		
		if(!faseMaisAtual.equals(faseEsperada)){
			obterListaDeOpcoesDoMenu().get(faseDesejada).findElement(By.tagName("a")).click();
		}
		
		return true;
	}
	
	public WebElement acessaLegendaDaTabela(){
		return obterTabela().findElement(By.className("legendas"));
	}
	
	public boolean exibiuALegendaNoFimDaPagina(){
		return acessaLegendaDaTabela().isDisplayed();
	}
	
	public boolean exibiuALegendaDeClassificadosCorretamente(){
		
		WebElement acessaClasseClassificados = acessaLegendaDaTabela().findElement(By.className("classificados"));
		String corVerdeEsperada = "rgba(0, 128, 0, 1)";
		String corAtual = acessaClasseClassificados.findElement(By.tagName("span")).getCssValue("background-color");
		String legendaEsperada = "Classificados";
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
	
	public boolean exibiuALegendaDeDoisMelhoresClassificadosCorretamente(){
		
		WebElement acessaClasseRebaixados = acessaLegendaDaTabela().findElement(By.className("melhor2"));
		String corAzulEsperada = "rgba(0, 0, 255, 1)";
		String corAtual = acessaClasseRebaixados.findElement(By.tagName("span")).getCssValue("background-color");
		String legendaEsperada = "Classificados (2 Melhores)";
		String legendaAtual = acessaClasseRebaixados.getText();
		String tamanhoAtualDaFonteDaLegenda = "12px";
		String tamanhoEsperadoDaFonteDaLegenda = acessaClasseRebaixados.findElement(By.tagName("span")).getCssValue("font-size");
		
		if(!corAtual.equals(corAzulEsperada)){
			System.out.println("Não exibiu cor correta para o quadrado da legenda de 2 melhores classificados. Esperado: ["+corAzulEsperada+"] Exibido: ["+corAtual+"]");
			return false;
		}
		
		if(!legendaAtual.equals(legendaEsperada)){
			System.out.println("Não exibiu o texto correto para a legenda de 2 melhores classificados. Texto esperado: ["+legendaEsperada+"] - Texto exibido: ["+legendaAtual+"]");
			return false;
		}
		
		if(!tamanhoAtualDaFonteDaLegenda.equals(tamanhoEsperadoDaFonteDaLegenda)){
			System.out.println("Não exibiu o tamanho correto para na fonte da legenda de 2 melhores classificados. Texto esperado: ["+tamanhoEsperadoDaFonteDaLegenda+"] - Texto exibido: ["+tamanhoAtualDaFonteDaLegenda+"]");
			return false;
		}
		
		return true;
	}
	
	public WebElement acessaBotaoDeRegulamento(){
		return acessaLegendaDaTabela().findElement(By.className("button"));
	}
	
	public boolean exibiuBotaoDeRegulamento() {
		return acessaBotaoDeRegulamento().isDisplayed();
	}
	
	public boolean escondeuOBotaoDeRegulamento() {
		
		try {
			if(acessaBotaoDeRegulamento().isDisplayed()){
				imprimirMensagemDeErroGenerica("Exibiu o botão de Regulamento para o tempo real.");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
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
	
	public boolean exibiuTextoDoRegulamentoCorreto(){
		String textoDoRegulamentoSerieAEsperado = "As 12 seleções da Copa América se dividem em três grupos na 1ª fase, cada um com quatro equipes. Dentro das chaves as seleções jogam entre si, em turno único. As duas primeiras colocadas de cada grupo, além dos dois melhores terceiros colocados, avançam às quartas de final. Em caso de empate na pontuação, são critérios de desempate:\n1) Saldo de gols\n2) Gols pró\n3) Confronto direto\n4) Sorteio\nA partir das quartas de final, o sistema passa a ser de mata-mata, em partida única. Em caso de empate no tempo regulamentar nas quartas, na semifinal e na disputa do terceiro lugar, a decisão será na cobrança de pênaltis. Na final, se houver igualdade nos 90 minutos, haverá prorrogação de 30 minutos. Se persistir o empate, o título é então decidido nos pênaltis.";
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