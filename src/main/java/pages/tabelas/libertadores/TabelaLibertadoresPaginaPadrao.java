package pages.tabelas.libertadores;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabelaLibertadoresPaginaPadrao extends AceitacaoAbstractTest {	
	
	public TabelaLibertadoresPaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement obterTabela(){
		return getDriver().findElement(By.className("page-libertadores-2015"));
	}
	
	private WebElement obterOMenuDaTabela() {
		return obterTabela().findElement(By.className("menu-camp"));
	}
	
	public boolean exibiuOMenuDaTabela() {
		return obterOMenuDaTabela().isDisplayed();
	}
	
	private List<WebElement> obterListaDeBotaoDoMenu() {
		return obterOMenuDaTabela().findElements(By.tagName("li"));
	}
	
	protected WebElement obterBotaoDaFasePrevia() {
		return obterListaDeBotaoDoMenu().get(0);
	}
	
	public boolean exibiuOpcaoDaFasePrevia() {
		return obterBotaoDaFasePrevia().isDisplayed();
	}
	
	protected WebElement obterBotaoDaFaseDeGrupos() {
		return obterListaDeBotaoDoMenu().get(1);
	}
	
	public boolean exibiuOpcaoDaFaseDeGrupos() {
		return obterBotaoDaFaseDeGrupos().isDisplayed();
	}
	
	protected WebElement obterBotaoDaFaseOitavasDeFinal() {
		return obterListaDeBotaoDoMenu().get(2);
	}
	
	public boolean exibiuOpcaoDaFaseOitavasDeFinal() {
		return obterBotaoDaFaseOitavasDeFinal().isDisplayed();
	}
	
	protected WebElement obterBotaoDaFaseQuartasDeFinal() {
		return obterListaDeBotaoDoMenu().get(3);
	}
	
	public boolean exibiuOpcaoDaFaseQuartasDeFinal() {
		return obterBotaoDaFaseQuartasDeFinal().isDisplayed();
	}
	
	protected WebElement obterBotaoDaFaseSemifinal() {
		return obterListaDeBotaoDoMenu().get(4);
	}
	
	public boolean exibiuOpcaoDaFaseSemifinal() {
		return obterBotaoDaFaseSemifinal().isDisplayed();
	}
	
	protected WebElement obterBotaoDaFaseFinal() {
		return obterListaDeBotaoDoMenu().get(5);
	}
	
	public boolean exibiuOpcaoDaFaseFinal() {
		return obterBotaoDaFaseFinal().isDisplayed();
	}
	
	public boolean exibiuTituloDaFasePreviaNoMenu() {
		return obterBotaoDaFasePrevia().getText().toLowerCase().equals("fase prévia");
	}
	
	public boolean exibiuTituloDaFaseDeGruposNoMenu() {
		return obterBotaoDaFaseDeGrupos().getText().toLowerCase().equals("fase de grupos");
	}
	
	public boolean exibiuTituloDaFaseOitavasDeFinalNoMenu() {
		return obterBotaoDaFaseOitavasDeFinal().getText().toLowerCase().equals("oitavas de final");
	}
	
	public boolean exibiuTituloDaFaseQuartasDeFinalNoMenu() {
		return obterBotaoDaFaseQuartasDeFinal().getText().toLowerCase().equals("quartas de final");
	}
	
	public boolean exibiuTituloDaFaseSemifinalNoMenu() {
		return obterBotaoDaFaseSemifinal().getText().toLowerCase().equals("semifinal");
	}
	
	public boolean exibiuTituloDaFaseFinalNoMenu() {
		return obterBotaoDaFaseFinal().getText().toLowerCase().equals("final");
	}
	
	private WebElement obterFaseAtual() {
		return obterTabela().findElement(By.xpath("//div[contains(@class, 'fases')]"));
	}

	public boolean exibiuAFaseAtual() {
		return obterFaseAtual().isDisplayed();
	}
}