package pages.tabelas.libertadores;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class TabelaLibertadoresFaseMataMataPaginaPadrao extends TabelaLibertadoresPaginaPadrao {
	
	public TabelaLibertadoresFaseMataMataPaginaPadrao(Navegador navegador, FasesMataMata fase) throws Exception {
		super(navegador);
		faseASerTestada = fase;
	}
	
	public enum FasesMataMata {
		PREVIA, OITAVAS, QUARTAS, SEMIFINAL, FINAL;
	}
	
	private FasesMataMata faseASerTestada;

	private void clicarNoBotaoDaFaseASerTestada() {
		switch (faseASerTestada) {
		case PREVIA:
			obterBotaoDaFasePrevia().click();
			break;
		case OITAVAS:
			obterBotaoDaFaseOitavasDeFinal().click();
			break;
		case QUARTAS:
			obterBotaoDaFaseQuartasDeFinal().click();
			break;
		case SEMIFINAL:
			obterBotaoDaFaseSemifinal().click();
			break;
		case FINAL:
			obterBotaoDaFaseFinal().click();
			break;
		default:
			System.out.println("Fase mata mata não mapeada na classe page.");
			break;
		}
	}
	
	private WebElement obterBoxDosJogosDaFaseASerTestada() {
		switch (faseASerTestada) {
		case PREVIA:
			return obterTabela().findElement(By.className("fase-preliminar"));
		case OITAVAS:
			return obterTabela().findElement(By.className("oitavas"));
		case QUARTAS:
			return obterTabela().findElement(By.className("quartas"));
		case SEMIFINAL:
			return obterTabela().findElement(By.className("semifinais"));
		case FINAL:
			return obterTabela().findElement(By.className("finais"));	
		default:
			System.out.println("Fase mata mata não mapeada na classe page.");
			return null;
		}
	}
		
	public boolean exibiuBoxDosJogosDaFaseAposClicarNoMenu() {
		clicarNoBotaoDaFaseASerTestada();
		return obterBoxDosJogosDaFaseASerTestada().isDisplayed();
	}
	
	private List<WebElement> obterListaDosJogosDaFase() {
		return obterBoxDosJogosDaFaseASerTestada().findElements(By.className("jogo"));
	}
	
	private int obterQuantidadeDosJogosDaFase() {
		return obterListaDosJogosDaFase().size();
	}
	
	public boolean exibiuNoMinimoUmJogoDaFase() {
		return obterQuantidadeDosJogosDaFase() > 0;
	}

	public boolean exibiuAsInformacoesDeDataHoraEstadioNomeDasEquipesEEscudoDasEquipesParaCadaJogoDaFase() {
		int qtde = obterQuantidadeDosJogosDaFase();
		
		for (int i = 0; i < qtde; i++) {
			if (obterListaDosJogosDaFase().get(i).findElement(By.className("data")).getText().isEmpty()) {
				System.out.println("Não foi exibida data para o jogo " + (i+1) + ".");
				return false;
			}
			if (obterListaDosJogosDaFase().get(i).findElement(By.className("hora")).getText().isEmpty()) {
				System.out.println("Não foi exibida hora para o jogo " + (i+1) + ".");
				return false;
			}
			if (obterListaDosJogosDaFase().get(i).findElement(By.className("estadio")).getText().isEmpty()) {
				System.out.println("Não foi exibido estadio para o jogo " + (i+1) + ".");
				return false;
			}
			if (obterListaDosJogosDaFase().get(i).findElement(By.className("time-home")).getText().isEmpty()) {
				System.out.println("Não foi exibido time mandante para o jogo " + (i+1) + ".");
				return false;
			}
			if (obterListaDosJogosDaFase().get(i).findElement(By.className("time-away")).getText().isEmpty()) {
				System.out.println("Não foi exibido time visitante para o jogo " + (i+1) + ".");
				return false;
			}
			if (obterListaDosJogosDaFase().get(i).findElement(By.className("escudo-home")).getAttribute("src").isEmpty()) {
				System.out.println("Não foi exibido escudo do time mandante para o jogo " + (i+1) + ".");
				return false;
			}
			if (obterListaDosJogosDaFase().get(i).findElement(By.className("escudo-away")).getAttribute("src").isEmpty()) {
				System.out.println("Não foi exibido escudo do time visitante para o jogo " + (i+1) + ".");
				return false;
			}
		}
		return true;
	}
}