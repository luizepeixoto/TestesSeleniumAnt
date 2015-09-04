package pages.newsletter.urgente;

import org.openqa.selenium.By;

import pages.newsletter.NewsletterTagueamentoPaginaPadrao;

import br.com.infoglobo.pages.Navegador;

public class UrgenteTagueamento extends NewsletterTagueamentoPaginaPadrao {
	
	public UrgenteTagueamento(Navegador navegador) throws Exception {
		super(navegador, "newsurgente");
	}
	
	public boolean exibiuOTagueamentoNaOpcaoContinuarLendoDaMateriaPrincipal() {
		return elementoPossuiTagueamento(obterOpcaoContinuarLendoDaMateriaPrincipalDaNewsletterUrgente().findElement(By.tagName("a")));
	}	
}