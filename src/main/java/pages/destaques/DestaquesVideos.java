package pages.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaquesVideos extends AceitacaoAbstractTest {
	
	public DestaquesVideos(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement obterBoxDeVideos() {
		return getDriver().findElement(By.className("video-carrossel"));
	}

	public boolean exibiuOBoxDeVideos() {
		return obterBoxDeVideos().isDisplayed();
	}
	
	private WebElement obterTituloDoBoxDeVideos() {
		return obterBoxDeVideos().findElement(By.className("video-title"));
	}

	public boolean exibiuOTituloDoBoxDeVideos() {
		if (! obterTituloDoBoxDeVideos().isDisplayed()) {
			System.out.println("O titulo do box de vídeos não está sendo exibido.");
			return false;
		}
		if (obterTituloDoBoxDeVideos().getText().isEmpty()) {
			System.out.println("O titulo do box de vídeos não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	private WebElement obterContadorAtualDoBoxDeVideos() {
		return obterBoxDeVideos().findElement(By.className("atual"));
	}

	public boolean exibiuOContadorAtualIgualAUm() {
		if (! obterContadorAtualDoBoxDeVideos().isDisplayed()) {
			System.out.println("O contador atual do box de vídeos não está sendo exibido.");
			return false;
		}
		if (! obterContadorAtualDoBoxDeVideos().getText().equals("1")) {
			System.out.println("O contador atual do box de vídeos não sendo exibindo o número 1 inicialmente.");
			return false;
		}
		return true;
	}
	
	private List<WebElement> obterListaDeVideosDoBox() {
		return obterBoxDeVideos().findElements(By.tagName("li"));
	}
	
	private int obterQuantidadeDeVideosDoBox() {
		return obterListaDeVideosDoBox().size();
	}
	
	private WebElement obterContadorTotalDoBoxDeVideos() {
		return obterBoxDeVideos().findElement(By.className("total"));
	}

	public boolean exibiuOContadorTotalIgualAoTotalDeVideosDoBox() {
		return (obterQuantidadeDeVideosDoBox() == Integer.valueOf(obterContadorTotalDoBoxDeVideos().getText()));
	}
	
	private WebElement obterSetaAnteriorDoBoxDeVideos() {
		return obterBoxDeVideos().findElement(By.className("anterior"));
	}

	public boolean exibiuASetaAnterior() {
		return obterSetaAnteriorDoBoxDeVideos().isDisplayed();
	}
	
	private WebElement obterSetaPosteriorDoBoxDeVideos() {
		return obterBoxDeVideos().findElement(By.className("proxima"));
	}

	public boolean exibiuASetaPosterior() {
		return obterSetaPosteriorDoBoxDeVideos().isDisplayed();
	}

	public boolean exibiuASetaAnteriorDesabilitadaPorPadrao() {
		return obterSetaAnteriorDoBoxDeVideos().getAttribute("class").equals("anterior disabled");
	}
	
	public boolean exibiuNoMinimoUmVideo() {
		return obterQuantidadeDeVideosDoBox() > 0;
	}

	public boolean exibiuOContadorAtualSendoAtualizadoAoAvancarOsVideos() throws InterruptedException {
		int qtde = obterQuantidadeDeVideosDoBox();
		int qtdeCliques = qtde - 1;
		
		for (int i = 0; i < qtde; i++) {
			int esperado = i + 1;
			
			if (! obterContadorAtualDoBoxDeVideos().getText().equals( Integer.toString(esperado)) ) {
				System.out.println("O contador atual não foi atualizado no video " + (i + 1) + ".");
				return false;
			}
			if (qtdeCliques > i ) {
				obterSetaPosteriorDoBoxDeVideos().click();
				esperaCarregar(1);
			}
		}
		return true;
	}

	public boolean exibiuASetaPosteriorDesabilitadaNoUltimoVideo() {
		return obterSetaPosteriorDoBoxDeVideos().getAttribute("class").equals("proxima disabled");
	}

	public boolean exibiuOContadorAtualSendoAtualizadoAoVoltarOsVideos() throws InterruptedException {
		int qtde = obterQuantidadeDeVideosDoBox();
		int qtdeCliques = qtde - 1;
		int cliquesEfetuados = 0;
		int esperado = qtde;
		
		for (int i = qtde; i != 0; i--) {
			if (! obterContadorAtualDoBoxDeVideos().getText().equals( Integer.toString(esperado)) ) {
				System.out.println("O contador atual não foi atualizado no video " + (i + 1) + ".");
				return false;
			}
			if (qtdeCliques > cliquesEfetuados ) {
				obterSetaAnteriorDoBoxDeVideos().click();
				cliquesEfetuados++;
				esperaCarregar(1);
			}
			esperado--;
		}
		return true;
	}
}