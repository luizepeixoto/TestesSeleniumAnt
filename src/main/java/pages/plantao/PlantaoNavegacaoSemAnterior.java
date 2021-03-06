package pages.plantao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class PlantaoNavegacaoSemAnterior extends AceitacaoAbstractTest {
	
	public PlantaoNavegacaoSemAnterior(Navegador navegador) throws Exception {
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
	
	public WebElement exibiuBoxDeNavegacaoAnterior(){
		return exibiuBoxDeNavegacao().findElement(By.className("mais-antiga"));
	}
	
	public boolean exibiuUmLinkNoBoxDePaginacaoAnterior(){
		List<WebElement> link = exibiuBoxDeNavegacaoAnterior().findElements(By.tagName("a"));
		return link.size() == Integer.parseInt("0");
	}
	
	public String exibiuTitulodaMateriaNoBoxPaginacaoMaisAntiga(){
		return exibiuBoxDeNavegacaoAnterior().findElement(By.className("base")).findElement(By.tagName("span")).getText();
	}
	
	public boolean exibiuTituloDaMateriaAnteriorEmNegrito(){
		return exibiuBoxDeNavegacaoAnterior().findElement(By.className("base")).findElement(By.tagName("strong")).isDisplayed();
	}
	
	public boolean exibiuOTituloDoBoxAnteriorIgualAoTituloDaMateria(){
		String materiaTitulo = getDriver().findElement(By.className("texteira")).findElement(By.tagName("h1")).getText();
		String materiaBox = exibiuBoxDeNavegacaoAnterior().findElement(By.className("base")).findElement(By.tagName("strong")).getText();

		return materiaTitulo.equals(materiaBox);
	}
	
	public boolean exibiuBoxDeAnteriorDesativado(){
		return exibiuBoxDeNavegacaoAnterior().findElement(By.tagName("b")).isDisplayed();
	}
}
