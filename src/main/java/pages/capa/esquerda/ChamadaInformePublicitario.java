package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ChamadaInformePublicitario extends AceitacaoAbstractTest {
	
	//    Chamada na última posição da coluna da esquerda. Contendo:
	//	- Matéria tipo informe publicitario
	//	- Foto e Título
	//
		
	public ChamadaInformePublicitario() throws Exception {
		super();
	}
	
	public WebElement exibiuClasseColLeft() {
		return getDriver().findElement(By.className("col-left"));
	}
	
	public WebElement exibiuChamadaDeInformePublicitario() {
		return exibiuClasseColLeft().findElement(By.className("especial-publicitario"));
	}

	public String exibiuTituloDeEspecialPublicitario() {
		return exibiuChamadaDeInformePublicitario().findElement(By.tagName("h2")).getText();
	}

	public boolean exibiuTituloDeEspecialPublicitarioComLink() {
		return exibiuChamadaDeInformePublicitario().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloDeEspecialPublicitarioComLinkValido() {
		return !exibiuChamadaDeInformePublicitario().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloDaMateria() {
		return !exibiuChamadaDeInformePublicitario().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuTituloDaMateriaComLink() {
		return exibiuChamadaDeInformePublicitario().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloDaMateriaComLinkValido() {
		return !exibiuChamadaDeInformePublicitario().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloComNoMaximo70Caracteres() {
		return exibiuChamadaDeInformePublicitario().findElement(By.tagName("h3")).getText().length() < 70;
	}
	
	public List<WebElement> totalDeTagsA() {
		return exibiuChamadaDeInformePublicitario().findElements(By.tagName("a"));
	}
	
	public boolean exibiuImagem() {
		return totalDeTagsA().get(1).findElement(By.tagName("img")).isDisplayed();
	}

	public String exibiuWidthImagem() {
		return totalDeTagsA().get(1).findElement(By.tagName("img")).getAttribute("width");
	}

	public String exibiuHeightImagem() {
		return totalDeTagsA().get(1).findElement(By.tagName("img")).getAttribute("height");
	}

	public boolean exibiuClasseAnimadaNaImagem() {
		return totalDeTagsA().get(1).getAttribute("class").contains("animado-scale");
	}

	public boolean exibiuAutorOuDescricao() {
		List<WebElement> possuiAutor=exibiuChamadaDeInformePublicitario().findElements(By.tagName("span"));
		return possuiAutor.size() == Integer.parseInt("0");
	}

	public boolean exibiuInformePublicitarioNaChamadaDestaque3Colunas() {
		String tituloEsperado = getDriver().findElement(By.className("col-left")).findElement(By.className("especial-publicitario")).findElement(By.tagName("h3")).getText().substring(0, 30);
		List<WebElement> totalTitulosSecudarias3Colunas = getDriver().findElement(By.className("super-destaque")).findElement(By.className("web-chamadas")).findElements(By.tagName("li"));
		
		for(int i=0;i<totalTitulosSecudarias3Colunas.size();i++){
			if(totalTitulosSecudarias3Colunas.get(i).findElement(By.tagName("h3")).getText().contains(tituloEsperado))
			return false;
		}
		return true;
	}

	public boolean exibiuInformePublicitarioNaChamadaDestaque2Colunas() {
		String tituloEsperado = getDriver().findElement(By.className("col-left")).findElement(By.className("especial-publicitario")).findElement(By.tagName("h3")).getText().substring(0, 30);
		List<WebElement> totalTitulosSecudarias2Colunas = getDriver().findElement(By.className("destaques-copa")).findElement(By.className("lista-destaques")).findElements(By.tagName("li"));
		
		for(int i=0;i<totalTitulosSecudarias2Colunas.size();i++){
			if(totalTitulosSecudarias2Colunas.get(i).findElement(By.tagName("h3")).getText().contains(tituloEsperado))
			return false;
		}
		return true;
	}
}
