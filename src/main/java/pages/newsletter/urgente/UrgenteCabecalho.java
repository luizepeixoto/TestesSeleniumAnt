package pages.newsletter.urgente;

import org.openqa.selenium.By;

import pages.newsletter.NewsletterCabecalhoPaginaPadrao;

import br.com.infoglobo.pages.Navegador;

public class UrgenteCabecalho extends NewsletterCabecalhoPaginaPadrao {
	
	public UrgenteCabecalho(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuOTituloSelecaoDosEditores() {
		//Elemento título
		if (! obterTitulo().isDisplayed()) {
			System.out.println("O elemento titulo não está sendo exibido.");
			return false;
		}
		//Valor elemento título
		String tituloEsperado = "Urgente";
		if (! obterTitulo().getText().equalsIgnoreCase(tituloEsperado)) {
			System.out.println("O valor do elemento titulo não está sendo exibido.");
			return false;
		}
		//Tamanho elemento título
		String tamanhoEsperado = "34.8800010681152px";
		if (! obterTitulo().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("O valor do elemento titulo não está sendo exibido.");
			return false;
		}
		//Cor elemento título
		String corEsperada = "rgba(198, 0, 0, 1)";
		if (! obterTitulo().getCssValue("color").equals(corEsperada)) {
			System.out.println("A cor do elemento titulo não está conforme o esperado.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuUmaBarraAposAData() {
		return obterHeader().findElement(By.xpath("td[2]")).getCssValue("border-bottom").equals("1px solid rgb(220, 220, 220)");
	}
}