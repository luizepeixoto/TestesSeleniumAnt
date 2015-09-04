package pages.materia.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxFotogaleriaInline extends AceitacaoAbstractTest {

	public BoxFotogaleriaInline() throws Exception {
		super();
	}
	
	public BoxFotogaleriaInline(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement obterBoxDeFotogaleriaInline() {
		return getDriver().findElement(By.className("fotogaleriasmateriaCapitulos"));
	}
	
	public boolean exibiuBoxDeFotogaleriaInline() {
		return obterBoxDeFotogaleriaInline().isDisplayed();
	}
	
	public List<WebElement> obterListaDeFotos(){
		return obterBoxDeFotogaleriaInline().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	private int obterQuantidadeDeFotosDoBox() {
		return obterListaDeFotos().size();
	}
	
	public boolean exibiuNoMinimoUmaFotoNoBoxDeFotogaleriaInline() {
		return obterQuantidadeDeFotosDoBox() > 0;
	}
	
	private WebElement obterContadorAtualDoBoxDeFotogaleriaInline() {
		return obterBoxDeFotogaleriaInline().findElement(By.className("atual"));
	}
	
	public boolean exibiuOContadorAtualIgualAUm() {
		if (! obterContadorAtualDoBoxDeFotogaleriaInline().isDisplayed()) {
			System.out.println("O contador atual do box de fotogaleria não está sendo exibido.");
			return false;
		}
		if (! obterContadorAtualDoBoxDeFotogaleriaInline().getText().equals("1")) {
			System.out.println("O contador atual do box de fotogaleria não sendo exibindo o número 1 inicialmente.");
			return false;
		}
		return true;
	}
	
	private WebElement obterContadorTotalDoBoxDeFotogaleriaInline() {
		return obterBoxDeFotogaleriaInline().findElement(By.className("total"));
	}
	
	public boolean exibiuOContadorTotalIgualAoTotalDeFotosDoBox() {
		return (obterQuantidadeDeFotosDoBox() == Integer.valueOf(obterContadorTotalDoBoxDeFotogaleriaInline().getText()));
	}
	
	private WebElement obterSetaDeNavegacaoParaAEsquerda() {
		return obterBoxDeFotogaleriaInline().findElement(By.className("nav")).findElement(By.className("anterior"));
	}

	public boolean exibiuSetaDeNavegacaoParaAEsquerda() {
		return obterSetaDeNavegacaoParaAEsquerda().isDisplayed();
	}
	
	private WebElement obterSetaDeNavegacaoParaADireita() {
		return obterBoxDeFotogaleriaInline().findElement(By.className("nav")).findElement(By.className("proxima"));
	}
	
	public boolean exibiuSetaDeNavegacaoParaADireita() {
		return obterSetaDeNavegacaoParaADireita().isDisplayed();
	}
	
	public boolean exibiuASetaDeNavegacaoParaAEsquerdaDesabilitadaPorPadrao() {
		return obterSetaDeNavegacaoParaAEsquerda().getAttribute("class").equals("anterior disabled");
	}
	
	private WebElement obterImagemDeAcordoComAPosicao(int posicao) {
		return obterListaDeFotos().get(posicao).findElement(By.className("fotoIten")).findElement(By.tagName("img"));
	}
	
	private WebElement obterLegendaDeAcordoComAPosicao(int posicao) {
		return obterListaDeFotos().get(posicao).findElement(By.className("legenda")).findElement(By.tagName("h3"));
	}
	
	private WebElement obterAutorDeAcordoComAPosicao(int posicao) {
		return obterListaDeFotos().get(posicao).findElement(By.className("legenda")).findElement(By.tagName("span"));
	}
	
	public boolean exibiuOContadorAtualSendoAtualizadoEAsImagensAsLegendasEOAutorAoAvancarAsFotos() throws InterruptedException {
		int qtde = obterQuantidadeDeFotosDoBox();
		int qtdeCliques = qtde - 1;
		
		String cropFotosEsperado = CropsDeArticles.fotogaleriaInline.cropProporcional();
		
		for (int i = 0; i < qtde; i++) {
			//Contador Atual
			int esperado = i + 1;
			if (! obterContadorAtualDoBoxDeFotogaleriaInline().getText().equals( Integer.toString(esperado)) ) {
				System.out.println("O contador atual não foi atualizado na imagem " + (i + 1) + ".");
				return false;
			}
			//Imagem
			if (! obterImagemDeAcordoComAPosicao(i).isDisplayed() ) {
				System.out.println("A imagem " + (i + 1) + " não está sendo exibida.");
				return false;
			}
			//Crop Imagem
			if (! obterImagemDeAcordoComAPosicao(i).getAttribute("src").contains(cropFotosEsperado) ) {
				System.out.println("A imagem " + (i + 1) + " não está exibindo o crop esperado.");
				return false;
			}
			//Legenda Imagem
			if (obterLegendaDeAcordoComAPosicao(i).getText().isEmpty() ) {
				System.out.println("A imagem " + (i + 1) + " não está exibindo a legenda.");
				return false;
			}
			//Autor Imagem
			if (obterAutorDeAcordoComAPosicao(i).getText().isEmpty() ) {
				System.out.println("A imagem " + (i + 1) + " não está exibindo o autor.");
				return false;
			}
			
			//Avançar proxima foto
			if (qtdeCliques > i ) {
				obterSetaDeNavegacaoParaADireita().click();
				esperaCarregar(1);
			}
		}
		return true;
	}
	
	public boolean exibiuASetaDeNavegacaoParaADireitaDesabilitadaNaUltimaFoto() {
		return obterSetaDeNavegacaoParaADireita().getAttribute("class").equals("proxima disabled");
	}
	
	public boolean exibiuOContadorAtualSendoAtualizadoAoVoltarAsFotos() throws InterruptedException {
		int qtde = obterQuantidadeDeFotosDoBox();
		int qtdeCliques = qtde - 1;
		int cliquesEfetuados = 0;
		int esperado = qtde;
		
		for (int i = qtde; i != 0; i--) {
			if (! obterContadorAtualDoBoxDeFotogaleriaInline().getText().equals( Integer.toString(esperado)) ) {
				System.out.println("O contador atual não foi atualizado na imagem " + (i + 1) + ".");
				return false;
			}
			if (qtdeCliques > cliquesEfetuados ) {
				obterSetaDeNavegacaoParaAEsquerda().click();
				cliquesEfetuados++;
				esperaCarregar(1);
			}
			esperado--;
		}
		return true;
	}
}