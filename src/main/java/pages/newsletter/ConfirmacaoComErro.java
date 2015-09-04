package pages.newsletter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class ConfirmacaoComErro extends ConfirmacaoPaginaPadrao {
	
	public ConfirmacaoComErro(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterTextoDeErro() {
		return obterHead().findElement(By.className("validation-error"));
	}

	public boolean exibiuOTextoDeErroDeInscricao() {
		//Elemento
		if (! obterTextoDeErro().isDisplayed()) {
			System.out.println("O texto de confirmação não está sendo exibido.");
			return false;
		}
		//Valor do Elemento
		String textoEsperado = "Ocorreu um erro.\n"
							 + "Tente novamente mais tarde";
		if (! obterTextoDeErro().getText().equals(textoEsperado)) {
			System.out.println("O texto de confirmação não está sendo exibido conforme o esperado.");
			return false;
		}
		//Cor do elemento
		String corEsperada = "rgba(206, 0, 0, 1)";
		if (! obterTextoDeErro().getCssValue("color").equals(corEsperada)) {
			System.out.println("O texto de confirmação não está exibindo a cor esperada.");
			return false;
		}
		//Tamanho do elemento
		String tamanhoEsperado = "20px";
		if (! obterTextoDeErro().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("O texto de confirmação não está com o tamanho esperado.");
			return false;
		}
		return true;
	}
}