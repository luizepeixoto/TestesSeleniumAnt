package pages.coluna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ColunaNavegacaoSemProxima extends AceitacaoAbstractTest {
	
	public ColunaNavegacaoSemProxima(Navegador navegador) throws Exception {
		super(navegador);
	}

	public void aguardaBoxDeNavegacaoCarregar(){
		 while(!exibiuBoxDeNavegacao().isDisplayed()){
			 if(exibiuBoxDeNavegacao().isDisplayed()){
				 break;
			 }
		 }
	}
	
	public void executaScrollAteOBoxDePaginacao(){
		 executarScroll(getDriver().findElement(By.className("navegacao")).getLocation());
	}
	
	public WebElement exibiuBoxDeNavegacao(){
		return getDriver().findElement(By.className("navegacao"));
	}
	
	public WebElement getBoxPaginacaoRecente(){
		return exibiuBoxDeNavegacao().findElement(By.className("mais-recente"));
	}
	
	public boolean exibiuBoxDeProximaSemLink(){
		List<WebElement> total = getBoxPaginacaoRecente().findElements(By.tagName("a"));
		
		return (total.size() == Integer.parseInt("0"));
	}
	
	public String getBoxPaginacaoRecenteTitulo(){
		return getBoxPaginacaoRecente().findElement(By.className("base")).findElement(By.tagName("span")).getText();
	}
	
	public boolean exibiuOTituloDoBoxDeProximoEmNegrito(){
		return getBoxPaginacaoRecente().findElement(By.className("base")).findElement(By.tagName("strong")).isDisplayed();
	}
	
	public boolean exibiuOTituloDoBoxProximaIgualAoTituloDaMateria(){
		
		String materiaTitulo = getDriver().findElement(By.className("corpo-coluna")).findElement(By.tagName("h1")).getText();
		String materiaBox = getBoxPaginacaoRecente().findElement(By.className("base")).findElement(By.tagName("strong")).getText();
		
		return (materiaTitulo.equals(materiaBox));
	}
	
	public boolean exibiuBoxDeNavegacaoDeProximaDesativado(){
		return getBoxPaginacaoRecente().findElement(By.tagName("b")).isDisplayed();
	}
}
