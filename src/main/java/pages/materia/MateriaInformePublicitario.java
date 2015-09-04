package pages.materia;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class MateriaInformePublicitario extends AceitacaoAbstractTest {
	
	public MateriaInformePublicitario() throws Exception {
		super();
	}
	
	public WebElement exibiuMateriaDoTipoInformePublicitario() {
		return getDriver().findElement(By.className("materia-patrocinada"));
	}
	
	public WebElement exibiuClasseSubEditoria() {
		return exibiuMateriaDoTipoInformePublicitario().findElement(By.className("head-materia")).findElement(By.className("sub-editoria"));
	}
	
	public boolean exibiuTituloDeInformePublicitario() {
		return exibiuClasseSubEditoria().findElement(By.tagName("a")).getText().toLowerCase().contains("especial publicitário");
	}

	public boolean exibiuTituloDeInformePublicitarioComLink() {
		return exibiuClasseSubEditoria().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloDeInformePublicitarioComLinkValido() {
		return !exibiuClasseSubEditoria().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloDaMateriaEmItalico() {
		return !exibiuMateriaDoTipoInformePublicitario().findElement(By.className("head-materia")).findElement(By.tagName("h1")).getText().isEmpty();
	}

	public WebElement exibiuBoxDeAutorPatrocinado() {
		return exibiuMateriaDoTipoInformePublicitario().findElement(By.className("head-materia")).findElement(By.id("autor-patrocinado"));
	}

	public boolean exibiuImagemDoPatrocinador() {
		return exibiuBoxDeAutorPatrocinado().findElement(By.className("patr")).findElement(By.tagName("script")).isDisplayed();
	}

	public boolean exibiuAPalavraPorAntesDoNomePatrocinador() {
		return exibiuBoxDeAutorPatrocinado().findElement(By.className("base")).getText().toLowerCase().contains("por");
	}
	
	public boolean exibiuNomePatrocinador() {
		return !exibiuBoxDeAutorPatrocinado().findElement(By.className("base")).findElement(By.className("autor")).getText().isEmpty();
	}

	public String exibiuFraseDeResponsabilidadeDoPatrocinador() {
		return exibiuBoxDeAutorPatrocinado().findElement(By.className("base")).findElement(By.className("desc")).getText().toLowerCase();
	}

	public WebElement exibiuBoxDePropagandaDePatrocinada() {
		return getDriver().findElement(By.className("pub-materia-patrocinada"));
	}

	public boolean exibiuTagScriptComAChamadaDoBanner() {
		return exibiuBoxDePropagandaDePatrocinada().findElement(By.tagName("script")).isDisplayed();
	}
	
	public String exibiuFraseDeResponsabilidadeNoBoxDePropaganda() {
		return exibiuBoxDePropagandaDePatrocinada().findElement(By.tagName("span")).getText().toLowerCase();
	}
	
	public List<WebElement> listaDeLinksPatrocinados() {
		return getDriver().findElement(By.className("publicidade-materia")).findElements(By.id("sponsored-links"));
	}
	
	public boolean exibiuGoogleAdsense() {
		return listaDeLinksPatrocinados().size() == Integer.parseInt("0");
	}

	public boolean exibiuBoxDeAgoraEmDestaque() {
		List<WebElement> possuiBoxAgoraEmdestaque = getDriver().findElements(By.className("em-destaque"));
		return possuiBoxAgoraEmdestaque.size() == Integer.parseInt("0");
	}

	public boolean exibiuBoxDaZunit() {
		List<WebElement> possuiBoxZunit = getDriver().findElements(By.className("estou-interessado"));
		return possuiBoxZunit.size() == Integer.parseInt("0");
	}

	public boolean exibiuBoxDeMaisLidasDoSite() {
		List<WebElement> possuiBoxMaisLidas = getDriver().findElements(By.className("mais-lidas"));
		return possuiBoxMaisLidas.size() == Integer.parseInt("0");
	}
	
	public boolean exibiuBoxDePaginacao() {
		List<WebElement> possuiBoxDePaginacao = getDriver().findElement(By.className("corpo")).findElements(By.className("navegacao"));
		return possuiBoxDePaginacao.size() == Integer.parseInt("0");
	}
	
}
