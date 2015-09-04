package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxCotacoesFinanceiras extends AceitacaoAbstractTest {
	
	public BoxCotacoesFinanceiras() throws Exception {
		super();
	}

	public String tituloIndicadores() {
		return getDriver().findElement(By.xpath("//div[@class='indicadores clearfix']/p")).getText();
	}

	public String tituloIbovespa() {
		return getDriver().findElement(By.xpath("//b[text()='Ibovespa']")).getText();
	}

	public String tituloMoedas() {
		return getDriver().findElement(By.xpath("//b[text()='Moedas']")).getText();
	}
	
	public String tituloCompra() {
		return getDriver().findElement(By.xpath("//b[text()='Compra']")).getText();
	}

	public boolean variacaoIbovespa() {
		return !getDriver().findElement(By.xpath("//div[@class='indicadores clearfix']/div/ul/li[1]/span")).getText().isEmpty();
	}

	public String tituloDolar() {
		return getDriver().findElement(By.xpath("//div[@class='indicadores clearfix']/div/ul/li[2]/span[1]")).getText();
	}

	public String tituloEuro() {
		return getDriver().findElement(By.xpath("//div[@class='indicadores clearfix']/div/ul/li[2]/span[2]")).getText();
	}

	public boolean valorMoedaDolar() {
		return !getDriver().findElement(By.xpath("//div[@class='indicadores clearfix']/div/ul/li[3]/span[1]")).getText().isEmpty();
	}

	public boolean valorMoedaEuro() {
		return !getDriver().findElement(By.xpath("//div[@class='indicadores clearfix']/div/ul/li[3]/span[2]")).getText().isEmpty();
	}
}