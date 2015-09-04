package pages.materia.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxTwitterEmbed extends AceitacaoAbstractTest {
	
	public BoxTwitterEmbed(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement getBoxTwitter(){
		return getDriver().findElement(By.className("artigo-twitter"));
	}
	
	public WebElement getBoxIframe(){
		return getBoxTwitter().findElement(By.tagName("div")).findElement(By.className("twitter-tweet"));
	}
	
	public boolean getBoxTwitterInformacao(){
		if(getBoxIframe().isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
}
