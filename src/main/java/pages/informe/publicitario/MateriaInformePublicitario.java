package pages.informe.publicitario;

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
		return exibiuBoxDeAutorPatrocinado().findElement(By.tagName("img")).isDisplayed();
	}

	public String exibiuWidthCorretoParaAImagemDoPatrocinador() {
		return exibiuBoxDeAutorPatrocinado().findElement(By.tagName("img")).getAttribute("width");
	}

	public String exibiuHeightCorretoParaAImagemDoPatrocinador() {
		return exibiuBoxDeAutorPatrocinado().findElement(By.tagName("img")).getAttribute("height");
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

	public String exibiuFraseDeResponsabilidadeNoBoxDePropaganda() {
		return exibiuBoxDePropagandaDePatrocinada().findElement(By.tagName("span")).getText().toLowerCase();
	}
	
}
