package pages.newsletter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class NewsletterCardapio extends AceitacaoAbstractTest {
	
	public NewsletterCardapio(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement acessaClasseHeadNewsLetter(){
		return getDriver().findElement(By.className("head-newsletter"));
	}

	public boolean exibiuOTituloEDescricaoNoTopoDaPagina() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}