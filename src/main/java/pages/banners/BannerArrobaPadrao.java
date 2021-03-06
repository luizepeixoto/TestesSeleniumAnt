package pages.banners;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BannerArrobaPadrao extends AceitacaoAbstractTest {
	
	public BannerArrobaPadrao(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public void executaScrollAteAPosicaoDesejada(WebElement posicaoWebElementDesejado) throws InterruptedException{
		esperaCarregar(2);
		executarScroll(posicaoWebElementDesejado.getLocation());
	}
	
	public void executaScrollParaAparecerOTituloPublicidade(WebElement posicao){
		Integer posicaoAtual = posicao.getLocation().y;
		Point novaPosicao = new Point(0, posicaoAtual-100);
		executarScroll(novaPosicao);
	}
	
	public WebElement acessaBannerArroba(WebElement caminhoDaPosicaoDesejada){
		return caminhoDaPosicaoDesejada.findElement(By.className("arroba"));
	}
	
	public String exibiuTituloPublicidade(WebElement caminho) {
		return acessaBannerArroba(caminho).findElement(By.tagName("p")).getText();
	}
	
	public boolean exibiuLinkNoTituloPublicidade(WebElement caminho) {
		return acessaBannerArroba(caminho).findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuOLinkNoTituloPublicidadeComTargetBlank(WebElement caminho) {
		return acessaBannerArroba(caminho).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("target").equals("_blank");
	}

	public WebElement validarScriptPublicidade(WebElement caminho) {
		return acessaBannerArroba(caminho).findElement(By.tagName("script"));
	}
}