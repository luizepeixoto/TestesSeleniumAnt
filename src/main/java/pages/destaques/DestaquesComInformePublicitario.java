package pages.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDestaques;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaquesComInformePublicitario extends AceitacaoAbstractTest {
	
	public DestaquesComInformePublicitario() throws Exception {
		super();
	}

	public DestaquesComInformePublicitario(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement exibiuClasseDestaques() {
		return getDriver().findElement(By.className("destaques-lista"));
	}
			
	public boolean exibiuChamadaDeInformePublicitarioNosDestaques() {
		return exibiuClasseDestaques().findElement(By.className("retranca-esp-pub")).isDisplayed();
	}
	
	public String exibiuTextoDeEspecialPublicitarioNosDestaques() {
		return exibiuClasseDestaques().findElement(By.className("retranca-esp-pub")).getText().toLowerCase();
	}
	
	public boolean exibiuTituloDaMateria() {
		return !exibiuClasseDestaques().findElement(By.className("tag-esp-pub")).getText().isEmpty();
	}

	public boolean exibiuTituloDaMateriaComLink() {
		return exibiuClasseDestaques().findElement(By.className("tag-esp-pub")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloDaMateriaComLinkValido() {
		return !exibiuClasseDestaques().findElement(By.className("tag-esp-pub")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloComNoMaximo70Caracteres() {
		return exibiuClasseDestaques().findElement(By.className("tag-esp-pub")).getText().length() < 70;
	}
	
	public List<WebElement> totalDeDestaques() {
		return exibiuClasseDestaques().findElements(By.className("inner-border"));
	}
	
	public boolean exibiuCropCorretoParaAImagem() {
		String urlDaImagemDoInformePublicitario = totalDeDestaques().get(3).findElement(By.tagName("img")).getAttribute("src");
		return urlDaImagemDoInformePublicitario.contains(CropsDestaques.semiAutomaticoMateria.cropProporcional());
	}
	
	public boolean exibiuImagem() {
		return totalDeDestaques().get(3).findElement(By.tagName("img")).isDisplayed();
	}

	public String exibiuWidthImagem() {
		return totalDeDestaques().get(3).findElement(By.tagName("img")).getAttribute("width");
	}

	public String exibiuHeightImagem() {
		return totalDeDestaques().get(3).findElement(By.tagName("img")).getAttribute("height");
	}

}
