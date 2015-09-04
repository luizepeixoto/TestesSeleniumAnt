package pages.tabelas.libertadores;

import org.openqa.selenium.By;
import br.com.infoglobo.pages.Navegador;

public class TabelaLibertadores extends TabelaLibertadoresPaginaPadrao {	
	
	public TabelaLibertadores(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuTituloDaTabela() {
		return !obterTabela().findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText().isEmpty();					
	}
}