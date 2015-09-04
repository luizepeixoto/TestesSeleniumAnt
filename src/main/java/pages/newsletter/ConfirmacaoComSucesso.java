package pages.newsletter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class ConfirmacaoComSucesso extends ConfirmacaoPaginaPadrao {
	
	public ConfirmacaoComSucesso(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterSeta() {
		return obterHead().findElement(By.className("fa-check"));
	}
	
	public boolean exibiuASetaVerde() {
		//Elemento
		if (! obterSeta().isDisplayed()) {
			System.out.println("A seta não está sendo exibida.");
			return false;
		}
		//Cor do elemento
		String corEsperada = "rgba(159, 197, 77, 1)";
		if (! obterSeta().getCssValue("background-color").equals(corEsperada)) {
			System.out.println("A seta não está exibindo a cor esperada.");
			return false;
		}
		//Tamanho do elemento
		String tamanhoEsperado = "30px";
		if (! obterSeta().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("A seta não está com o tamanho esperado.");
			return false;
		}
		return true;
	}
	
	private WebElement obterTextoDeConfirmacao() {
		return obterHead().findElement(By.className("head-confirmation"));
	}

	public boolean exibiuOTextoDeConfirmacaoDeInscricao() {
		//Elemento
		if (! obterTextoDeConfirmacao().isDisplayed()) {
			System.out.println("O texto de confirmação não está sendo exibido.");
			return false;
		}
		//Valor do Elemento
		String textoEsperado = "Sua inscrição foi confirmada!";
		if (! obterTextoDeConfirmacao().getText().equals(textoEsperado)) {
			System.out.println("O texto de confirmação não está sendo exibido conforme o esperado.");
			return false;
		}
		//Cor do elemento
		String corEsperada = "rgba(28, 49, 77, 1)";
		if (! obterTextoDeConfirmacao().getCssValue("color").equals(corEsperada)) {
			System.out.println("O texto de confirmação não está exibindo a cor esperada.");
			return false;
		}
		//Tamanho do elemento
		String tamanhoEsperado = "35px";
		if (! obterTextoDeConfirmacao().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("O texto de confirmação não está com o tamanho esperado.");
			return false;
		}
		return true;
	}
	
	private WebElement obterTextoDePrincipaisNoticiasGratuitamente() {
		return obterHead().findElement(By.tagName("p"));
	}

	public boolean exibiuOTextoDePrincipaisNoticiasGratuitamente() {
		//Elemento
		if (! obterTextoDePrincipaisNoticiasGratuitamente().isDisplayed()) {
			System.out.println("O texto de principais notícias gratuitamente não está sendo exibido.");
			return false;
		}
		//Valor do Elemento
		String textoEsperado = "A partir de agora você irá receber gratuitamente as principais notícias do O GLOBO no seu e-mail";
		if (! obterTextoDePrincipaisNoticiasGratuitamente().getText().equals(textoEsperado)) {
			System.out.println("O texto de principais notícias gratuitamente não está sendo exibido conforme o esperado.");
			return false;
		}
		//Cor do elemento
		String corEsperada = "rgba(28, 49, 77, 1)";
		if (! obterTextoDePrincipaisNoticiasGratuitamente().getCssValue("color").equals(corEsperada)) {
			System.out.println("O texto de principais notícias gratuitamente não está exibindo a cor esperada.");
			return false;
		}
		//Tamanho do elemento
		String tamanhoEsperado = "20px";
		if (! obterTextoDePrincipaisNoticiasGratuitamente().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("O texto de principais notícias gratuitamente não está com o tamanho esperado.");
			return false;
		}
		return true;
	}
}