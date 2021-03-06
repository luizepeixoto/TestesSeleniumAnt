package pages.editoria;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

import org.openqa.selenium.support.ui.Select;

public class BarraDeBuscaRioGastronomia extends AceitacaoAbstractTest {
	private String urlDaPagina;
	private String urlAposClicar;
	
	public BarraDeBuscaRioGastronomia(Navegador navegador) throws Exception{
		super(navegador);
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public boolean exibiuABarraDeBuscaRioGastronomia() {
		return getDriver().findElement(By.id("busca")).isDisplayed();
	}

	public boolean exibiuCampoEspecialidade() {
		return getDriver().findElement(By.xpath("//div[@class='especialidade']")).isDisplayed();
	}

	public boolean exibiuCampoBairro() {
		return getDriver().findElement(By.xpath("//div[@class='bairro']")).isDisplayed();
	}

	public boolean exibiuCampoPreco() {
		return getDriver().findElement(By.xpath("//div[@class='preco']")).isDisplayed();
	}

	public boolean exibiuCheckBoxRestaurantesOrganicos() {
		return getDriver().findElement(By.xpath("//div[@class='checks organicos']")).isDisplayed();
	}

	public boolean exibiuCheckBoxRestaurantesPremiados() {
		return getDriver().findElement(By.xpath("//div[@class='checks premiados']")).isDisplayed();
	}

	public boolean exibiuBotaoEscolher() {
		return getDriver().findElement(By.xpath("//div[@class='btEscolher']")).isDisplayed();
	}

	public boolean exibiuCampoBuscarRestaurante() {
		return getDriver().findElement(By.xpath("//form[@class='busca']/div/input")).isDisplayed();
	}

	public boolean exibiuBotaoOk() {
		return getDriver().findElement(By.xpath("//form[@class='busca']/div[2]/input")).isDisplayed();
	}

	public void escolheuUmaEspecialidade() {
		new Select(getDriver().findElement(By.xpath("//div[@class='especialidade']/select"))).selectByIndex(2);
	}

	public void clicouNoBotaoEscolher() {
		getDriver().findElement(By.xpath("//div[@class='btEscolher']")).click();	
	}

	public boolean redirecionouParaPaginaComResultadoDaBusca() {
	 return this.urlDaPagina != this.urlAposClicar;
	}

	public void escolheuUmBairro() {
		new Select(getDriver().findElement(By.xpath("//div[@class='bairro']/select"))).selectByIndex(2);
	}

	public void escolheuUmPreco() {
		new Select(getDriver().findElement(By.xpath("//div[@class='preco']/select"))).selectByIndex(2);	
	}

	public void marcouCheckBoxRestaurantesOrganicos() {
		//getDriver().findElement(By.xpath("//input[@id='menu_organico']")).click();	
		//getDriver().findElement(By.cssSelector("#menu_organico")).click();
		getDriver().findElement(By.name("menu_organico_possui")).click();
	}

	public void marcouCheckBoxRestaurantesPremiados() {
		getDriver().findElement(By.xpath("//*[@id='busca']/div/form[1]/div[4]/div[2]/label")).click();
	}

	public void digitouNomeDeUmRestaurante() {
		getDriver().findElement(By.xpath("//form[@class='busca']/div/input")).sendKeys("Bom Grill");	
	}

	public void clicouNoBotaoOk() {
		getDriver().findElement(By.xpath("//form[@class='busca']/div[2]/input")).click();
		
	}

}
