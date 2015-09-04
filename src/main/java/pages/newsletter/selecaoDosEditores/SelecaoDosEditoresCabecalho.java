package pages.newsletter.selecaoDosEditores;

import org.openqa.selenium.By;

import pages.newsletter.NewsletterCabecalhoPaginaPadrao;

import br.com.infoglobo.pages.Navegador;

public class SelecaoDosEditoresCabecalho extends NewsletterCabecalhoPaginaPadrao {
	
	public SelecaoDosEditoresCabecalho(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuOTituloSelecaoDosEditores() {
		//Elemento título
		if (! obterTitulo().isDisplayed()) {
			System.out.println("O elemento titulo não está sendo exibido.");
			return false;
		}
		//Valor elemento título
		String tituloEsperado = "Seleção dos Editores";
		if (! obterTitulo().getText().equalsIgnoreCase(tituloEsperado)) {
			System.out.println("O valor do elemento titulo não está sendo exibido.");
			return false;
		}
		//Tamanho elemento título
		String tamanhoEsperado = "29.9200000762939px";
		if (! obterTitulo().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("O valor do elemento titulo não está sendo exibido.");
			return false;
		}
		//Cor elemento título
		String corEsperada = "rgba(30, 150, 200, 1)";
		if (! obterTitulo().getCssValue("color").equals(corEsperada)) {
			System.out.println("A cor do elemento titulo não está conforme o esperado.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuACorDeFundoDoHeader() {
		String corEsperada = "rgba(233, 244, 249, 1)";
		return obterHeader().findElement(By.tagName("td")).getCssValue("background-color").equalsIgnoreCase(corEsperada);
	}
}