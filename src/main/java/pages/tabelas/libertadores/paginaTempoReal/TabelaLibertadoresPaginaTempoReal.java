package pages.tabelas.libertadores.paginaTempoReal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.tabelas.libertadores.TabelaLibertadoresPaginaPadrao;

import br.com.infoglobo.pages.Navegador;

public class TabelaLibertadoresPaginaTempoReal extends TabelaLibertadoresPaginaPadrao {	
	
	public TabelaLibertadoresPaginaTempoReal(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterBoxDeCabecalho() {
		return getDriver().findElement(By.className("page-temporeal")).findElements(By.className("row")).get(1);
	}

	public boolean exibiuALarguraDaTabelaIgualALarguraDoBoxDeCabecalho() {
		int larguraTabela = obterTabela().getSize().width;
		int larguraCabecalho = obterBoxDeCabecalho().getSize().width;
		return larguraTabela == larguraCabecalho;
	}
}