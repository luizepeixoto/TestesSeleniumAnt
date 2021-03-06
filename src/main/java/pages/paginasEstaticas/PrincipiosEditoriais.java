package pages.paginasEstaticas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class PrincipiosEditoriais extends AceitacaoAbstractTest{

	public PrincipiosEditoriais() throws Exception {
		super();
	}

	public WebElement exibiuClassePrincipiosEditoriais() {
		return getDriver().findElement(By.className("principios-editoriais"));
	}
	
	public boolean exibiuOTitulo() {
		return !exibiuClassePrincipiosEditoriais().findElement(By.className("page-title")).getText().isEmpty();
	}
	
	public boolean exibiuBannerDeAssinatura() {
		return getDriver().findElements(By.className("subscriptionFooter")).size()==0;
	}

	public boolean exibiuIndice() {
		return exibiuClassePrincipiosEditoriais().findElement(By.className("title")).getText().contains("Índice");
	}
}