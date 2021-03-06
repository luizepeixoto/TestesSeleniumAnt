package pages.newsletter.urgente;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.newsletter.NewsletterCorpoPaginaPadrao;

import br.com.infoglobo.pages.Navegador;

public class UrgenteCorpo extends NewsletterCorpoPaginaPadrao {
	
	public UrgenteCorpo(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuOTituloDaMateriaUrgenteComOTamanhoDaFonteCorreto() {
		return obterTituloDaMateriaPrincipal().findElement(By.tagName("a")).getCssValue("font-size").equals("44.9599990844727px");
	}
	
	public boolean exibiuAOpcaoContinuarLendoDaMateriaPrincipal() {
		//Elemento continuar lendo da materia principal
		if (! obterOpcaoContinuarLendoDaMateriaPrincipalDaNewsletterUrgente().isDisplayed()) {
			System.out.println("O elemento continuar lendo da materia principal não está sendo exibido.");
			return false;
		}
		//Valor elemento continuar lendo da materia principal
		if (obterOpcaoContinuarLendoDaMateriaPrincipalDaNewsletterUrgente().getText().isEmpty()) {
			System.out.println("O valor do elemento continuar lendo da materia principal não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	private WebElement obterLinkDaOpcaoContinuarLendoDaMateriaPrincipal() {
		return obterOpcaoContinuarLendoDaMateriaPrincipalDaNewsletterUrgente().findElement(By.tagName("a"));
	}

	public boolean exibiuOMesmoLinkNaEditoriaNoTituloENaOpcaoContinuarLendoDaMateriaPrincipal() {
		String editoria = obterLinkDaEditoriaDaMateriaPrincipal().getAttribute("href");
		String titulo = obterLinkDoTituloDaMateriaPrincipal().getAttribute("href");
		String opContinuar = obterLinkDaOpcaoContinuarLendoDaMateriaPrincipal().getAttribute("href");
		
		if (! editoria.equals(titulo)) {
			System.out.println("Os links exibidos na editoria e no título da matéria principal estão diferentes.");
			return false;
		}
		if (! editoria.equals(opContinuar)) {
			System.out.println("Os links exibidos na editoria e na opção continuar lendo da matéria principal estão diferentes.");
			return false;
		}
		if (! titulo.equals(opContinuar)) {
			System.out.println("Os links exibidos no título e na opção continuar lendo da matéria principal estão diferentes.");
			return false;
		}
		return true;
	}
}