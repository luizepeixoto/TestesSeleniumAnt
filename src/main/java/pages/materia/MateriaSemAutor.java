package pages.materia;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaSemAutor extends AceitacaoAbstractTest {
	
	public MateriaSemAutor(Navegador navegador) throws Exception {
		super(navegador);
	}

	public String exibiuAutorComoOGlobo(){
		return getDriver().findElement(By.className("autor")).getText();
	}
}
