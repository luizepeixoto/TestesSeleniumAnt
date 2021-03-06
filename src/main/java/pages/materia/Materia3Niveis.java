package pages.materia;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class Materia3Niveis extends AceitacaoAbstractTest {
	
	public Materia3Niveis() throws Exception {
		super();
	}

	public boolean exibiuEditoria() {
		return !getDriver().findElement(By.id("bt-editoria")).getText().isEmpty();
	}

	public boolean exibiuSubEditoria() {
		return !getDriver().findElement(By.className("titulo-subeditorias")).findElement(By.tagName("h1")).getText().isEmpty();
	}
	
	public boolean exibiuSubEditoriaTerceiroNivel() {
		return !getDriver().findElement(By.className("sub-editoria")).findElement(By.tagName("a")).getText().isEmpty();
	}
	
	public boolean exibiuCorretamenteAEditoriaEAsSubs() {
		String editoriaEsperada = getDriver().findElement(By.id("bt-editoria")).getText();
		String subEditoriaEsperada = getDriver().findElement(By.className("titulo-subeditorias")).findElement(By.tagName("h1")).getText();
		String subEditoria3NivelEsperada = getDriver().findElement(By.className("sub-editoria")).findElement(By.tagName("a")).getText();
		
		if( (editoriaEsperada.equals(subEditoriaEsperada) && (editoriaEsperada.equals(subEditoria3NivelEsperada)) && (subEditoriaEsperada.equals(subEditoria3NivelEsperada)) )){
			return false;
		}
		return true;
	}

}
