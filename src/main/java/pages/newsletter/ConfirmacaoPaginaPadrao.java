package pages.newsletter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ConfirmacaoPaginaPadrao extends AceitacaoAbstractTest {
	
	public ConfirmacaoPaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}

	public boolean exibiuABarraDaGloboCom() {
		return getDriver().findElement(By.id("barra-globocom")).isDisplayed();
	}

	public boolean exibiuOMenuDoOGlobo() {
		return getDriver().findElement(By.className("top-header")).isDisplayed();
	}
	
	protected WebElement obterHead() {
		return getDriver().findElement(By.className("head-newsletter"));
	}
	
	private WebElement obterTitulo() {
		return obterHead().findElement(By.tagName("h1"));
	}

	public boolean exibiuOTituloNewsLetterOGlobo() {
		String tituloEsperado = "Newsletter O Globo";
		return obterTitulo().getText().equalsIgnoreCase(tituloEsperado);
	}
	
	public boolean exibiuUmaBarraInferiorNaClasseHead() {
		return obterHead().getCssValue("border-bottom").equals("1px solid rgb(204, 204, 204)");
	}
	
	protected WebElement obterFooter() {
		return getDriver().findElement(By.className("footer-newsletter"));
	}
	
	private WebElement obterTextosInformativos() {
		return obterFooter().findElement(By.tagName("ul"));
	}
	
	public boolean exibiuOsTextosInformativos() {
		int qtde = obterTextosInformativos().findElements(By.tagName("li")).size();
		//Elemento
		if (qtde != 3) {
			System.out.println("A quantidade de textos informativos exibidos não está conforme o esperado.\nEsperado: 3 | Exibidos: " + qtde);
			return false;
		}
		//Valor do Elemento
		String textoEsperado = "Nós não iremos divulgar o seu endereço de e-mail.\n"
							 + "Você pode desfazer sua inscrição a qualquer momento através do link na parte inferior da newsletter recebida.\n"
							 + "Ao inscrever-se para as newsletters você concorda com nossos termos de serviço.";
		if (! obterTextosInformativos().getText().equals(textoEsperado)) {
			System.out.println("Os textos informativos não estão sendo exibidos conforme o esperado.");
			return false;
		}
		//Cor do elemento
		String corEsperada = "rgba(28, 49, 77, 1)";
		if (! obterTextosInformativos().getCssValue("color").equals(corEsperada)) {
			System.out.println("Os textos informativos não estão exibindo a cor esperada.");
			return false;
		}
		//Tamanho do elemento
		String tamanhoEsperado = "20px";
		if (! obterTextosInformativos().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("Os textos informativos não estão com o tamanho esperado.");
			return false;
		}
		return true;
	}
	
	private WebElement obterTextoDePrecisaDeAjuda() {
		return obterFooter().findElement(By.tagName("p"));
	}

	public boolean exibiuOTextoDePrecisaDeAjuda() {
		//Elemento
		if (! obterTextoDePrecisaDeAjuda().isDisplayed()) {
			System.out.println("O texto de precisa de ajuda não está sendo exibido.");
			return false;
		}
		//Valor do Elemento
		if (obterTextoDePrecisaDeAjuda().getText().isEmpty()) {
			System.out.println("O texto de precisa de ajuda não está sendo exibido conforme o esperado.");
			return false;
		}
		//Cor do elemento
		String corEsperada = "rgba(28, 49, 77, 1)";
		if (! obterTextoDePrecisaDeAjuda().getCssValue("color").equals(corEsperada)) {
			System.out.println("O texto de precisa de ajuda não está exibindo a cor esperada.");
			return false;
		}
		//Tamanho do elemento
		String tamanhoEsperado = "20px";
		if (! obterTextoDePrecisaDeAjuda().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("O texto de precisa de ajuda não está com o tamanho esperado.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuApenasATagANoTextoDePrecisaDeAjuda() {
		List<WebElement> listaDeTags = obterTextoDePrecisaDeAjuda().findElements(By.xpath("child::*"));
		int qtdeTags = listaDeTags.size();
		for (int i = 0; i < qtdeTags; i++) {
			if (! listaDeTags.get(i).getTagName().equals("a")) {
				System.out.println("O texto de precisa de ajuda está exibindo a tag \"" + (listaDeTags.get(i).getTagName()) + "\". Esta tag não é permitida neste elemento.");
				return false;
			}
		}
		return true;
	}
	
	private WebElement obterBannerDeAssinatura() {
		return obterFooter().findElement(By.className("newsletter-banner"));
	}

	public boolean exibiuOBannerDeAssinatura() {
		//Elemento
		if (! obterBannerDeAssinatura().isDisplayed()) {
			System.out.println("O banner de assinatura não está sendo exibido.");
			return false;
		}
		//Url do Elemento
		if (obterBannerDeAssinatura().findElement(By.tagName("img")).getAttribute("src").isEmpty()) {
			System.out.println("A url do banner de assinatura não está sendo exibida.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuUmLinkNoBannerDeAssinatura() {
		return ! obterBannerDeAssinatura().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuORodapeDoOGlobo() {
		return getDriver().findElement(By.tagName("footer")).isDisplayed();
	}
	
	public boolean naoExibiuAOfertaDeRodape() {
		try {
			getDriver().findElement(By.id("subscriptionFooter"));
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}