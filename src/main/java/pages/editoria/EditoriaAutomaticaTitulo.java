package pages.editoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EditoriaAutomaticaTitulo extends AceitacaoAbstractTest {
	
	public EditoriaAutomaticaTitulo() throws Exception{
		super();
	}
	
	public EditoriaAutomaticaTitulo(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public List<WebElement> classeTituloUltimas(){
		return getDriver().findElements(By.className("titulo-ultimas"));
	}
	
	public boolean exibiuOTitulo() {
		return classeTituloUltimas().size() == 0;
	}
}