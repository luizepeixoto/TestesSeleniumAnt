package pages.materia.widget;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaComBoxDeMusicaAEsquerda extends AceitacaoAbstractTest {

	public MateriaComBoxDeMusicaAEsquerda(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public void scrollAteOBox(){
		executaScrollParaAparecerOTituloDeUmaPosicao(getDriver().findElement(By.xpath("//div[@class='box box-musica ng-scope']")));
	}
	
	public boolean exibiuBoxDeMusicaAEsquerda() {
		return getDriver().findElement(By.xpath("//div[@class='box box-musica ng-scope']")).isDisplayed();
	}

	public String exibiutituloTopMusicas() {
		return getDriver().findElement(By.xpath("//div[@class='box box-musica ng-scope']/h6")).getText();
	}

	public boolean exibiuFotoDoArtista() {
		return getDriver().findElement(By.xpath("//div[@class='loadingBox']/div/img")).isDisplayed();
	}

	public boolean exibiuNomeDoArtista() {
		return !getDriver().findElement(By.xpath("//div[@class='loadingBox']/div/div/span[1]")).getText().isEmpty();
	}

	public String exibiuTextoNoMusicaComBr() {
		return getDriver().findElement(By.xpath("//div[@class='loadingBox']/div/div/span[2]")).getText();
	}

	public boolean exibiuNumeroMaisTextoMusicas() {
		return getDriver().findElement(By.xpath("//div[@class='loadingBox']/div/div/span[2]/b[1]")).getText().isEmpty();		 
	}

	public boolean exibiuNumeroMaisTextoFas() {
		return getDriver().findElement(By.xpath("//div[@class='loadingBox']/div/div/span[2]/b[2]")).getText().isEmpty();
	}

	public boolean exibiuBotaoOuvirPlaylist() {
		return getDriver().findElement(By.xpath("//div[@class='loadingBox']/div/div/a")).isDisplayed();
	}

	public boolean exibiuListaDeMusicas() {
		return !getDriver().findElements(By.xpath("//div[@class='loadingBox']/ol")).isEmpty();
	}

	public boolean exibiuLogoMusicaComBr() {
		return getDriver().findElement(By.xpath("//div[@class='mais-musica']/a/img")).isDisplayed();
	}

	public String exibiuLinkMaisLetrasTraducoesEClipes() {
		return getDriver().findElement(By.xpath("//div[@class='mais-musica']/a/span")).getText();
	}


	
}
