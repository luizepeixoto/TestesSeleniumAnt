package pages.tealium;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Device;
import br.com.infoglobo.pages.Navegador;

public class MarcacoesDoTealium extends AceitacaoAbstractTest {
	
	public MarcacoesDoTealium() throws Exception{
		super();
	}
	
	public MarcacoesDoTealium(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public MarcacoesDoTealium(Navegador navegador, Device device) throws Exception {
		super(navegador, device);
	}

	public String obterNomeDaEditoria() {
		return getDriver().findElement(By.id("bt-editoria")).getText();
	}
	
	public boolean exibiuaEditoria() {
		return getDriver().findElement(By.className("title")).isDisplayed();
	}
	
	public String obterNomeDaSubEditoria() {
		return getDriver().findElement(By.className("titulo-ultimas")).findElement(By.tagName("h1")).getText();
	}

	public boolean carregouJSNoModoAssincrono() throws InterruptedException {
		esperaCarregar(1);
		try {
			getDriver().findElement(By.xpath("//script[contains(@src, 'utag.js')][contains(@async, '')]"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}	
}