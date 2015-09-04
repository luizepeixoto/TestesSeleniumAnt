package pages.fotogaleria;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.banners.BannerArrobaPadrao;

import br.com.infoglobo.pages.Navegador;

public class BoxFotogaleriaBanner extends BannerArrobaPadrao {
	
	public BoxFotogaleriaBanner(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement acessaBoxDeUltimasFotogalerias = getDriver().findElement(By.id("lastFrom"));
}