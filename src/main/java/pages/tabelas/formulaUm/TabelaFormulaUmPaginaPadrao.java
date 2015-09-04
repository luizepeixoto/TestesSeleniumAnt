package pages.tabelas.formulaUm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabelaFormulaUmPaginaPadrao extends AceitacaoAbstractTest {	
	
	public TabelaFormulaUmPaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement obterTabela(){
		return getDriver().findElement(By.className("page-formula1-2015"));
	}
	
	protected WebElement obterOMenuDaTabela() {
		return obterTabela().findElement(By.className("menu-camp"));
	}
	
	private List<WebElement> obterListaDeBotoesDoMenu() {
		return obterOMenuDaTabela().findElements(By.tagName("li"));
	}
	
	protected WebElement obterBotaoDaAbaCalendario() {
		return obterListaDeBotoesDoMenu().get(0);
	}
	
	protected WebElement obterBotaoDaAbaResultadoPorPiloto() {
		return obterListaDeBotoesDoMenu().get(1);
	}
	
	protected WebElement obterBotaoDaAbaResultadoPorEquipe() {
		return obterListaDeBotoesDoMenu().get(2);
	}
	
	protected WebElement obterBotaoDaAbaResultadoPorCorrida() {
		return obterListaDeBotoesDoMenu().get(3);
	}
}