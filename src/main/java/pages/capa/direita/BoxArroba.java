package pages.capa.direita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.banners.BannerArrobaPadrao;

import br.com.infoglobo.pages.Navegador;

public class BoxArroba extends BannerArrobaPadrao {
	
	public BoxArroba(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement acessaCapaDaDireita = getDriver().findElement(By.className("col-right"));
}