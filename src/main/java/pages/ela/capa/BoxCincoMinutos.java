package pages.ela.capa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class BoxCincoMinutos extends CapaElaDestaques {
	
	public BoxCincoMinutos(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement acessaColunaDaDireita(){
		return getDriver().findElement(By.className("col-right"));
	}
	
	public WebElement acessaBoxCincoMinutos() {
		return acessaColunaDaDireita().findElement(By.className("box-5-minutos"));
	}

	public boolean exibiuBoxDeCincoMinutos() {
		return acessaBoxCincoMinutos().isDisplayed();
	}

	public boolean 	exibiuInformacoesCorretasNoBoxDeCincoMinutos() {
		
		WebElement iframeCincoMinutos = acessaBoxCincoMinutos().findElement(By.tagName("iframe")); 
		
		if(!iframeCincoMinutos.getAttribute("src").contains("meus5minutos.globo.com")){
			imprimirMensagemDeErroGenerica("Não está exibindo iframe correto para o box cinco minutos.");
			return false;
		}
		
		if(!iframeCincoMinutos.getAttribute("width").equals("310")){
			imprimirMensagemDeErroGenerica("Não está exibindo width correto para o iframe do box cinco minutos.");
			return false;
		}
		
		if(!iframeCincoMinutos.getAttribute("height").equals("411")){
			imprimirMensagemDeErroGenerica("Não está exibindo height correto para o iframe do box cinco minutos.");
			return false;
		}
		
		return true;
	}
}