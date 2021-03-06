package pages.newsletter;

import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class NewsletterTagueamentoPaginaPadrao extends NewsletterCorpoPaginaPadrao {
	
	private String tagComum = "?utm_source=newsletter&utm_medium=email&utm_content=";
	private String tagDoTipo = "";
	
	public NewsletterTagueamentoPaginaPadrao(Navegador navegador, String tagueamentoNewsletter) throws Exception {
		super(navegador);
		this.tagDoTipo = "&utm_campaign=" + tagueamentoNewsletter;
	}
	
	protected boolean elementoPossuiTagueamento(WebElement elemento) {
		return (elemento.getAttribute("href").contains(tagComum)) && (elemento.getAttribute("href").contains(tagDoTipo));
	}
	
	public boolean exibiuOTagueamentoNaEditoriaDaMateriaPrincipal() {
		//Link elemento editoria da materia principal
		if (! elementoPossuiTagueamento(obterLinkDaEditoriaDaMateriaPrincipal()) ) {
			System.out.println("O link do elemento editoria da matéria principal não está com o tagueamento esperado.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuOTagueamentoNoTituloDaMateriaPrincipal() {
		//Link elemento titulo da materia principal
		if (! elementoPossuiTagueamento(obterLinkDoTituloDaMateriaPrincipal()) ) {
			System.out.println("O link do elemento titulo da matéria principal não está com o tagueamento esperado.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuOTagueamentoNaFotoDaMateriaPrincipal() {
		//Link elemento foto da materia principal
		if (! elementoPossuiTagueamento(obterLinkDaFotoDaMateriaPrincipal()) ) {
			System.out.println("O link do elemento foto da matéria principal não está com o tagueamento esperado.");
			return false;
		}
		return true;
	}
	
	private boolean exibiuParaCadaMateriaSecundariaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendoDeAcordoComALista(List<WebElement> lista, String nomeLista) {
		int qtde = lista.size();
		
		for (int i = 0; i < qtde; i++) {
			//Link elemento foto
			if (! elementoPossuiTagueamento(obterLinkDaFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i)) ) {
				System.out.println("O link do elemento foto não está com o tagueamento esperado na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			
			//Link elemento editoria
			if (! elementoPossuiTagueamento(obterLinkDaEditoriaDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i)) ) {
				System.out.println("O link do elemento editoria não está com o tagueamento esperado na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			
			//Link elemento titulo
			if (! elementoPossuiTagueamento(obterLinkDoTituloDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i)) ) {
				System.out.println("O link do elemento titulo não está com o tagueamento esperado na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			
			//Link elemento continuar lendo
			if (! elementoPossuiTagueamento(obterLinkDaOpcaoContinuarLendoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i)) ) {
				System.out.println("O link do elemento continuar lendo não está com o tagueamento esperado na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaPrimeiraListaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo() {
		return exibiuParaCadaMateriaSecundariaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendoDeAcordoComALista(primeiraLista, "primeira");
	}
	
	public boolean exibiuParaCadaBlogOTagueamentoNaFotoNoNomeENoTituloDoUltimoPost() {
		int qtde = obterQuantidadeDeBlogs();
		
		for (int i = 0; i < qtde; i++) {
			//Link elemento foto
			if (! elementoPossuiTagueamento(obterLinkDaFotoDeUmBlogDeAcordoComAPosicao(i)) ) {
				System.out.println("O link do elemento foto não está com o tagueamento esperado no blog " + (i + 1) + ".");
				return false;
			}
			
			//Link elemento nome
			if (! elementoPossuiTagueamento(obterLinkDoNomeDeUmBlogDeAcordoComAPosicao(i)) ) {
				System.out.println("O link do elemento nome não está com o tagueamento esperado no blog " + (i + 1) + ".");
				return false;
			}
			
			//Link elemento titulo do ultimo post
			if (! elementoPossuiTagueamento(obterLinkDoTituloDoUltimoPostDeUmBlogDeAcordoComAPosicao(i)) ) {
				System.out.println("O link do elemento titulo do ultimo post não está com o tagueamento esperado no blog " + (i + 1) + ".");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaSegundaListaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo() {
		return exibiuParaCadaMateriaSecundariaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendoDeAcordoComALista(segundaLista, "segunda");
	}
}