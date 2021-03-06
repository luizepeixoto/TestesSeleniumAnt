package pages.editoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class Editorias extends AceitacaoAbstractTest {

	public Editorias() throws Exception{
		super();	
	}
	
	public boolean exibiuOComentariosNaCapaDeEditoria() {
		List<WebElement> resultadoEsperado = getDriver().findElement(By.className("menu-interacao")).findElements(By.id("comentar"));
		return resultadoEsperado.size() == 0;
	}
}
