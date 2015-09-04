package pages.plantao;

import org.openqa.selenium.By;

public class PlantaoDoVaiRio extends Plantao {

	public PlantaoDoVaiRio() throws Exception{
		super();
	}

	public boolean exibiuPaginaDePlantao() {
		return getDriver().findElement(By.className("plantao")).findElement(By.className("texteira")).isDisplayed();
	}
}
