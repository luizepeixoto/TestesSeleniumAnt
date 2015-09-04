package pages.materia.capitulo;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuSuperiorComAncora extends AceitacaoAbstractTest {
	
	public MenuSuperiorComAncora(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean  exibiuAClasseDaAncoraComoAtiva() throws InterruptedException {
		esperaCarregar1Segundo();
		String posicaoComClasseAtiva = getDriver().findElement(By.cssSelector("a.tipsy-left.active")).getText();
		return posicaoComClasseAtiva.equals("3");
	}
}