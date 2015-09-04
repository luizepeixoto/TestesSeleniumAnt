package pages.temporeal;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class PlacarDoJogo extends AceitacaoAbstractTest {
		
		public PlacarDoJogo(Navegador navegador) throws Exception{
			super(navegador);
		}

		public boolean exibiuNomeDoPrimeiroTime() throws InterruptedException {
			Thread.sleep(4000);
			return !getDriver().findElement(By.xpath("//div[@class='placar-partida']/p")).getText().isEmpty();
		}
		
		public boolean exibiuNomeDoSegundoTime() {
			return !getDriver().findElement(By.xpath("//div[@class='placar-partida']/p[5]")).getText().isEmpty();
		}

		public boolean exibiuEscudoDoPrimeiroTime() {
			return getDriver().findElement(By.xpath("//div[@class='placar-partida']/img")).isDisplayed();
		}

		public boolean exibiuEscudoDoSegundoTime() {
			return getDriver().findElement(By.xpath("//div[@class='placar-partida']/img[2]")).isDisplayed();
		}

		public boolean exibiuNumeroDeGolsDoPrimeiroTime() {
			return !getDriver().findElement(By.xpath("//div[@class='placar-partida']/p[2]")).getText().isEmpty();
		}
		
		public boolean exibiuNumeroDeGolsDoSegundoTime() {
			return !getDriver().findElement(By.xpath("//div[@class='placar-partida']/p[4]")).getText().isEmpty();
		}

		public boolean exibiuImagemBackground() {
			return getDriver().findElement(By.xpath("//div[@class='page-temporeal']/div")).isDisplayed();
		}
}
