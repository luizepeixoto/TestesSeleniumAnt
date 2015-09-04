package pages.materia.widget;

import org.openqa.selenium.By;
import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaComBoxDeMusicaCentralizada extends AceitacaoAbstractTest {

	public MateriaComBoxDeMusicaCentralizada(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public void scrollAteOBox(){
		executaScrollParaAparecerOTituloDeUmaPosicao(getDriver().findElement(By.xpath("//div[@class='box-musica-block ng-scope']")));
	}
	
	public boolean exibiuBoxDeMusicaCentralizada() {
		return getDriver().findElement(By.xpath("//div[@class='box-musica-block ng-scope']")).isDisplayed();
	}

	public String exibiutituloTopMusicas() {
		return getDriver().findElement(By.xpath("//div[@class='box-musica-block ng-scope']/h6")).getText();
	}

	public boolean exibiuFotoDoArtista() {
		return getDriver().findElement(By.xpath("//div[@class='loadingOlho']/div/img")).isDisplayed();
	}

	public boolean exibiuNomeDoArtista() {
		return !getDriver().findElement(By.xpath("//div[@class='loadingOlho']/div/div/span[1]")).getText().isEmpty();
	}

	public boolean exibiuNumeroMaisTextoMusicas() {
		return getDriver().findElement(By.xpath("//div[@class='loadingOlho']/div/div/span[2]/b[1]")).getText().isEmpty();	
	}

	public boolean exibiuNumeroMaisTextoFas() {
		return getDriver().findElement(By.xpath("//div[@class='loadingOlho']/div/div/span[2]/b[2]")).getText().isEmpty();
	}

	public boolean exibiuBotaoOuvirPlaylist() {
		return getDriver().findElement(By.xpath("//div[@class='loadingOlho']/div/div/a")).isDisplayed();
	}

	public boolean exibiuListaDeMusicas() {
		return !getDriver().findElements(By.xpath("//div[@class='loadingOlho']/div/ol")).isEmpty();
	}

	public boolean exibiuLogoMusicaComBr() {
		return getDriver().findElement(By.xpath("//div[@class='box-musica-block ng-scope']/div[2]/a/img")).isDisplayed();
	}

	public String exibiuLinkMaisLetrasTraducoesEClipes() {
		return getDriver().findElement(By.xpath("//div[@class='box-musica-block ng-scope']/div[2]/a/span")).getText();
	}

	public String exibiuTextoNoMusicaComBr() {
		return getDriver().findElement(By.xpath("//div[@class='loadingOlho']/div/div/span[2]")).getText();
	}
	
}
