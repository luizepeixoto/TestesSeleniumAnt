package pages.editoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxDeCriticasComPaginacao extends AceitacaoAbstractTest {
	
	public BoxDeCriticasComPaginacao(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement exibiuBoxDeCriticas() {
		return getDriver().findElement(By.className("criticas-carrossel"));
	}
	
	public WebElement exibiuClasseCriticasCarrossel() {
		return exibiuBoxDeCriticas().findElement(By.className("criticas-carrossel-top"));
	}
	
	public List<WebElement> listaDeConteudos(){
		return exibiuBoxDeCriticas().findElement(By.className("slider-container")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaListaValida() {
		return listaDeConteudos().size() >= Integer.parseInt("5");
	}

	public WebElement exibiuBoxDePaginacao() {
		return exibiuClasseCriticasCarrossel().findElement(By.className("nav"));
	}

	public boolean exibiuSetasDePaginacaoParaEsquerdaDesabilitada() {
		return exibiuBoxDePaginacao().findElements(By.tagName("a")).get(0).getAttribute("class").contains("disabled");
	}

	public boolean exibiuSetasDePaginacaoParaDireitaHabilitada() {
		return exibiuBoxDePaginacao().findElements(By.tagName("a")).get(1).getAttribute("class").equals("proxima");
	}
	
	public void clicarNaPaginacaoDaDireita() throws InterruptedException {
		//exibiuBoxDePaginacao().findElements(By.tagName("a")).get(1).click();
		Thread.sleep(2000);
		getDriver().findElement(By.cssSelector("a.proxima")).click();
	}

	public boolean exibiuSetaParaEsquerdaHabilitada() {
		return !exibiuBoxDePaginacao().findElements(By.tagName("a")).get(0).getAttribute("class").contains("disabled");
	}

	public boolean exibiuSetaParaADireitaDesabilitada() {
		return exibiuBoxDePaginacao().findElements(By.tagName("a")).get(1).getAttribute("class").contains("disabled");
	}
}
