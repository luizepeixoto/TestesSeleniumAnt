package pages.tabelas.carioca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaCampeonatoCarioca extends TabelaCampeonatoCariocaPaginaPadrao {

	public TabelaCampeonatoCarioca(Navegador navegador) throws Exception {
		super(navegador);
	}

	public boolean exibiuONomeDoCampeonato() {
		return !obterTabela().findElement(By.className("head-materia")).getText().isEmpty();
	}

	public boolean exibiuOTextoAbrirRegulamentoNoBotaoDeRegulamento() {
		String textoEsperado = "Abrir Regulamento";
		return obterBotaoDeRegulamento().getText().equalsIgnoreCase(textoEsperado);
	}

	private WebElement obterRegulamento() {
		return obterTabela().findElement(By.className("regulamento"));
	}

	public boolean exibiuORegulamentoAposClicarNoBotaoDeRegulamento() throws InterruptedException {
		int ultimoJogo = obterQuantidadeDeJogosDaRodadaAtual() - 1;
		executarScroll(obterListaDeJogosDaRodadaAtual().get(ultimoJogo).getLocation().toString());
		obterBotaoDeRegulamento().click();
		return obterRegulamento().isDisplayed();
	}

	public boolean exibiuOTextoFecharRegulamentoAposClicarNoBotaoDeRegulamento() {
		String textoEsperado = "Fechar Regulamento";
		return obterBotaoDeRegulamento().getText().equalsIgnoreCase(textoEsperado);
	}
}