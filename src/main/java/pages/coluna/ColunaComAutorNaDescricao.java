package pages.coluna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ColunaComAutorNaDescricao extends AceitacaoAbstractTest {

	public ColunaComAutorNaDescricao(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuCabecalhoDaColuna() {
		return getDriver().findElement(By.className("header-coluna")).findElement(By.className("columns"));
	}

	public String exibiuOTituloColuna() {
		return exibiuCabecalhoDaColuna().findElement(By.className("sub-editoria")).getText();
	}

	public boolean exibiuOTituloDaColuna() {
		return !exibiuCabecalhoDaColuna().findElement(By.className("autor")).getText().isEmpty();
	}
	
	public boolean exibiuOAutorDaColunaNaDescricao() {
		return !exibiuCabecalhoDaColuna().findElement(By.className("slogan")).findElement(By.tagName("strong")).getText().isEmpty();
	}
	
	public boolean exibiuADescricaoDaColuna() {
		return !exibiuCabecalhoDaColuna().findElement(By.className("slogan")).getText().isEmpty();
	}
	
	public WebElement exibiuClasseCorpoLarge16Columns() {
		return getDriver().findElement(By.tagName("article")).findElement(By.className("corpo"));
	}
	
	public boolean exibiuAFotoDoColunista() {
		return exibiuClasseCorpoLarge16Columns().findElement(By.className("user")).findElement(By.tagName("img")).isDisplayed();
	}

	public String exibiuWidth() {
		return exibiuClasseCorpoLarge16Columns().findElement(By.tagName("a")).getAttribute("width");
	}

	public String exibiuHeight() {
		return exibiuClasseCorpoLarge16Columns().findElement(By.tagName("a")).getAttribute("height");
	}

	public WebElement exibiuCorpoDaColuna() {
		return exibiuClasseCorpoLarge16Columns().findElement(By.className("corpo-coluna"));
	}

	public boolean exibiuAData() {
		return !exibiuCorpoDaColuna().findElement(By.className("data-cadastro")).findElement(By.tagName("time")).getText().isEmpty();
	}

	public boolean exibiuOTitulo() {
		return !exibiuCorpoDaColuna().findElement(By.tagName("h1")).getText().isEmpty();
	}

	public boolean exibiuOTexto() {
		List<WebElement> resultadoEsperado = exibiuCorpoDaColuna().findElements(By.tagName("p"));
		for(int i=0; i<resultadoEsperado.size();i++){
			if(resultadoEsperado.get(i).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
}