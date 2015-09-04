package pages.destaques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaquesLista extends AceitacaoAbstractTest {
	
	public DestaquesLista() throws Exception {
		super();
	}

	public DestaquesLista(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement acessaLista() {
		return getDriver().findElement(By.className("destaques-lista"));
	}
			
	public WebElement exibiuChamadaDeLista() {
		return acessaLista().findElement(By.className("list-post"));
	}
	
	public boolean acessaChamadaDeLista() {
		return exibiuChamadaDeLista().isDisplayed();
	}
	
	public boolean exibiuTituloDeListas() {
		return !exibiuChamadaDeLista().findElement(By.className("tipo-conteudo")).getText().isEmpty();
	}

	public boolean exibiuONumeroDaLista() {
		return !exibiuChamadaDeLista().findElement(By.className("numero")).getText().isEmpty();
	}

	public boolean exibiuOTituloDaLista() {
		return !exibiuChamadaDeLista().findElement(By.className("titulo")).getText().isEmpty();
	}
	
	public boolean exibiuOTituloComNoMaximo57Caracteres() {
		return exibiuChamadaDeLista().findElement(By.className("titulo")).getText().length() < 60;
	}
	
	public boolean exibiuADescricaoDaLista() {
		return !exibiuChamadaDeLista().findElement(By.className("subtitulo")).getText().isEmpty();
	}
	
	public boolean exibiuADescricaoComNoMaximo83Caracteres() {
		return exibiuChamadaDeLista().findElement(By.className("subtitulo")).getText().length() < 86;
	}
	
	public boolean exibiuLinkNaLista() {
		return exibiuChamadaDeLista().findElement(By.tagName("a")).findElement(By.className("numero")).isDisplayed();
	}

	public boolean exibiuLinkNoTitulo() {
		return exibiuChamadaDeLista().findElement(By.tagName("a")).findElement(By.className("titulo")).isDisplayed();
	}

	public boolean exibiuLinkValido() {
		return !exibiuChamadaDeLista().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

}
