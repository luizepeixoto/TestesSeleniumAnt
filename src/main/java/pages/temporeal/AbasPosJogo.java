package pages.temporeal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.tealium.MarcacoesDoTealium;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class AbasPosJogo extends MarcacoesDoTealium {

	public AbasPosJogo() throws Exception {
		super();
	}

	public AbasPosJogo(Navegador navegador) throws Exception {
		super(navegador);
	}

	public void aguardar2Segundos() throws InterruptedException {
		Thread.sleep(2000);
	}

	public int exibiuCincoAbas() {
		return getDriver().findElements(By.xpath("//div[@class='contain-to-grid']/nav/ul/li")).size();
	}

	public boolean exibiuTituloImagensOuImagem() {
		return !getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/nav/ul/li[1]")).getText().isEmpty();
	}

	public String exibiuTituloAtuações() {
		return getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/nav/ul/li[2]")).getText();
	}

	public String exibiuTituloEstatisticas() {
		return getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/nav/ul/li[3]")).getText();
	}

	public String exibiuTituloJogadas() {
		return getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/nav/ul/li[4]")).getText();
	}

	public String exibiuTituloDestaques() {
		return getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/nav/ul/li[5]")).getText();
	}

	public boolean exibiuConteudoDaAbaImagens() {
		return getDriver().findElement(By.xpath("//*[@id='carrossel']")).isDisplayed();
	}

	public boolean exibiuConteudoDaAbaAtuacoes() {
		return getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/div/div[2]")).isDisplayed();
	}

	public boolean exibiuConteudoDaAbaEstatisticas() {
		return getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/div/div[3]")).isDisplayed();
	}

	public boolean exibiuConteudoDaAbaJogadas() {
		return getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/div/div[4]")).isDisplayed();
	}

	public boolean exibiuConteudoDaAbaDestaques() {
		return getDriver().findElement(By.xpath("//div[@class='contain-to-grid']/div/div[5]")).isDisplayed();
	}

	public void clicouNaAbaAtuacoes() throws InterruptedException {
		aguardar2Segundos();
		getDriver().findElement(By.id("atuacoes-cabecalho")).click();
	}

	public void clicouNaAbaEstatisticas() throws InterruptedException {
		aguardar2Segundos();
		getDriver().findElement(By.id("estatisticas-cabecalho")).click();
	}

	public void clicouNaAbaJogadas() throws InterruptedException {
		aguardar2Segundos();
		getDriver().findElement(By.id("jogadas-cabecalho")).click();
	}

	public void clicouNaAbaDestaques() throws InterruptedException {
		aguardar2Segundos();
		getDriver().findElement(By.id("destaques-cabecalho")).click();
	}

	/* Navegação Da Fotogaleria Na Primeira Aba */

	public WebElement exibiuFotogaleria() {
		return getDriver().findElement(By.className("fotogaleria-cabecalho"));
	}

	public List<WebElement> listaDeFotosDeFotogaleria() {
		return exibiuFotogaleria().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}

	public boolean exibiuUmalistaDeFotosParaAFotogaleria() {
		for (int i = 0; i < listaDeFotosDeFotogaleria().size(); i++) {
			if (!listaDeFotosDeFotogaleria().get(i).findElement(By.tagName("img")).isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmaLegendaParaCadaFoto() {
		for (int i = 0; i < listaDeFotosDeFotogaleria().size(); i++) {
			if (listaDeFotosDeFotogaleria().get(i).findElement(By.tagName("orbit-caption")).findElement(By.tagName("p")).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmBoxDeCompartilhamentoParaCadaFoto() {
		for (int i = 0; i < listaDeFotosDeFotogaleria().size(); i++) {
			if (!listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOCompartilhamentoDoFacebookParaCadaFoto() {
		for(int i=0; i<listaDeFotosDeFotogaleria().size(); i++){
			if(!listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-facebook")).isDisplayed() 
					&& listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-facebook")).getAttribute("href").isEmpty()
					&& !listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-facebook")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOCompartilhamentoDoTwitterParaCadaFoto() {
		for (int i = 0; i < listaDeFotosDeFotogaleria().size(); i++) {
			if (!listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-twitter")).isDisplayed() 
					&& listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-twitter")).getAttribute("href").isEmpty()
					&& !listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-twitter")).findElement(By.tagName("img")).isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOCompartilhamentoDoGooglePlusParaCadaFoto() {
		for (int i = 0; i < listaDeFotosDeFotogaleria().size(); i++) {
			if (!listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-gplus")).isDisplayed()
					&& listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-gplus")).getAttribute("href").isEmpty()
					&& !listaDeFotosDeFotogaleria().get(i).findElement(By.className("orbit-caption")).findElement(By.className("compartilhamento")).findElement(By.className("cabecalho-gplus")).findElement(By.tagName("img")).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuNavegacaoDaFotogaleriaParaEsquerda() {
		return getDriver().findElement(By.cssSelector("a.orbit-prev.prev-extremity")).isDisplayed();
	}
	
	public void clicarNaProximaFoto() {
		getDriver().findElement(By.cssSelector("a.orbit-next")).click();
	}
	
	public boolean exibiuNavegacaoDaFotogaleriaParaDireita() {
		return getDriver().findElement(By.cssSelector("a.orbit-next")).isDisplayed();
	}
	
	public boolean exibiuOTotalDeFotos() {
		return getDriver().findElement(By.cssSelector("div.orbit-slide-number")).isDisplayed();
	}

	public boolean exibiuAPrimeiraLegenda() {
		return !getDriver().findElement(By.cssSelector("div.orbit-caption > p")).getText().isEmpty();
	}
	
	public boolean exibiuALegendaDaFotoAtual() {
		return !getDriver().findElement(By.cssSelector("li.active > div.orbit-caption > p")).getText().isEmpty();
	}
	
	public boolean exibiuAFotoAtual() {
		return getDriver().findElement(By.cssSelector("#carrossel > li.active > img")).isDisplayed();
	}
}
