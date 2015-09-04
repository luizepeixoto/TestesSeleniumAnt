package pages.materia.comentario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class MateriaSemComentarioHabilitado extends AceitacaoAbstractTest {

	public MateriaSemComentarioHabilitado() throws Exception {
		super();
	}
	
	public void esperaCaixaDeComentarioCarregar(){
		while(! getDriver().findElement(By.className("comentarios")).isDisplayed()){
			if(getDriver().findElement(By.className("comentarios")).isDisplayed()){
				break;
			}
		}
	}
	
	public boolean exibiuBalaoDeComentarios() {
		List<WebElement> possuiBalaoDeComentarios = getDriver().findElement(By.className("menu-interacao")).findElements(By.id("comentar"));
		return !(possuiBalaoDeComentarios.size() > Integer.parseInt("0"));
	}

	public boolean exibiuTituloComentarios() {
		List<WebElement> possuiTituloComentarios = getDriver().findElements(By.className("comentarios"));
		return !(possuiTituloComentarios.size() > Integer.parseInt("0"));
	}
}