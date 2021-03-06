package pages.materia.menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuTopicoVazio extends AceitacaoAbstractTest {
	
	public MenuTopicoVazio() throws Exception {
		super();
	}
	
	public MenuTopicoVazio(Navegador navegador) throws Exception {
		super(navegador);
	}

	public List<WebElement> listaComTodosOsTopicos() {
		return getDriver().findElements(By.className("artigo-topicos"));
	}
	
	public boolean aListaDeTopicosEstaAparecendo() {
		return listaComTodosOsTopicos().size() == 0;
	}
}
