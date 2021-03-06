package pages.materia;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaSemBoxNavegacao extends AceitacaoAbstractTest {
	
	public MateriaSemBoxNavegacao(Navegador navegador) throws Exception {
		super(navegador);
	}

	public boolean exibiuBoxDeNavegacao(){
		List<WebElement> totalDeBoxDeNavegacao = getDriver().findElement(By.className("corpo")).findElements(By.className("navegacao"));
		return totalDeBoxDeNavegacao.size() == Integer.parseInt("0");
	}
}
