package pages.destaques;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaqueSemManchete extends AceitacaoAbstractTest {
	
	public DestaqueSemManchete(Navegador navegador) throws Exception{
		super(navegador);
	}

	public boolean validarMenuEditoria() {
		executarMouseOver(getDriver().findElement(By.id("bt-editoria")));
		return !getDriver().findElement(By.xpath("//*[@id='menu-editoria']/div[1]/div/div/div[2]/div")).getText().isEmpty();
	}

	public boolean validarMenuHome() {
		executarMouseOver(getDriver().findElement(By.xpath("/html/body/header/div[2]/div/div/nav/ul/li[10]/a")));
		return !getDriver().findElement(By.xpath("/html/body/header/div[2]/div/div/nav/ul/li[10]/div/div[1]/div/div/div[2]/div")).getText().isEmpty();
	}

	public void clicouNoLogoOGlobo() {
		getDriver().findElement(By.xpath("//*[@id='sticker']/div/div/div/div/div/div[2]/a")).click();
		
	}
}
