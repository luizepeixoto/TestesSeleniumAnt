package pages.materia;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class Materia2Niveis extends AceitacaoAbstractTest {
	
	public Materia2Niveis() throws Exception {
		super();
	}

	public boolean exibiuEditoria() {
		return !getDriver().findElement(By.id("bt-editoria")).getText().isEmpty();
	}

	public boolean exibiuSubEditoria() {
		return !getDriver().findElement(By.className("titulo-subeditorias")).findElement(By.tagName("h1")).getText().isEmpty();
	}

	public boolean exibiuCorretamenteEditoriaESubEditoria() {
		String editoriaEsperada = getDriver().findElement(By.id("bt-editoria")).getText();
		String subEditoriaEsperada = getDriver().findElement(By.className("titulo-subeditorias")).findElement(By.tagName("h1")).getText();
		
		if(editoriaEsperada.equals(subEditoriaEsperada)){
			return false;
		}
		return true;
	}

}
