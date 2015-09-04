package pages.newsletter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class NewsletterRodapePaginaPadrao extends NewsletterPaginaPadrao {
	
	public NewsletterRodapePaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterOpcaoReceberNewsletterDiaria() {
		return getDriver().findElement(By.className("newsOptin"));
	}

	public boolean naoExibiuAOpcaoReceberNewsletter() {
//		//Elemento
//		if(! obterOpcaoReceberNewsletterDiaria().isDisplayed()) {
//			System.out.println("O elemento receber newsletter diaria não está sendo exibido.");
//			return false;
//		}
//		//Valor elemento
//		String textoEsperado = "Receba a Newsletter Diária";
//		if(! obterOpcaoReceberNewsletterDiaria().getText().equalsIgnoreCase(textoEsperado)) {
//			System.out.println("O valor do elemento receber newsletter diaria não está conforme o esperado.");
//			return false;
//		}
//		return true;
		
		//o bloco acima refere-se ao teste que verifica a existência da opção (será implementada após a página de cardápio)
		try {
			obterOpcaoReceberNewsletterDiaria();
			return false;
		} catch (Exception e) {
			return true;
		}
	}
	
	private WebElement obterIconeDaOpcaoReceberNewsletterDiaria() {
		return obterOpcaoReceberNewsletterDiaria().findElement(By.tagName("img"));
	}

	public boolean exibiuUmIconeDeLinkExternoNaOpcaoReceberNewsletterDiaria() {
		//Elemento
		if (! obterIconeDaOpcaoReceberNewsletterDiaria().isDisplayed()) {
			System.out.println("O elemento icone de receber newsletter diaria não está sendo exibido.");
			return false;
		}
		//Valor Elemento
		if (obterIconeDaOpcaoReceberNewsletterDiaria().getAttribute("src").isEmpty()) {
			System.out.println("O valor do elemento icone de receber newsletter diaria não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuOIconeDeLinkExternoDaOpcaoReceberNewsletterDiariaSemBorda() {
		return naoExibiuBordaNaImagem(obterIconeDaOpcaoReceberNewsletterDiaria());
	}
	
	protected WebElement obterBanner() {
		return getDriver().findElement(By.className("newsAd"));
	}

	public boolean exibiuOBanner() {
		//Elemento
		if(! obterBanner().isDisplayed()) {
			System.out.println("O elemento banner não está sendo exibido.");
			return false;
		}
		//Valor elemento
		if(obterBanner().findElement(By.tagName("img")).getAttribute("src").isEmpty()) {
			System.out.println("A url do banner não está sendo exibida.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuOBannerComOEstiloCorreto() {
		String estiloEsperado = "display: block; width: 100%; border: 0px; outline: 0px;";
		return obterBanner().findElement(By.tagName("img")).getAttribute("style").equals(estiloEsperado);
	}
	
	private WebElement obterLinkDoBanner() {
		return obterBanner().findElement(By.tagName("a"));
	}
	
	public boolean exibiuUmLinkNoBanner() {
		if (obterLinkDoBanner().getAttribute("href").isEmpty()) {
			System.out.println("A url do link está vazia.");
			return false;
		}
		
		if (! obterLinkDoBanner().getAttribute("href").contains("assinatura")) {
			System.out.println("A url do link não contém a palavra \"assinatura\".");
			return false;
		}
		return true;
	}
	
	public boolean exibiuOBannerSemBorda() {
		return naoExibiuBordaNaImagem(obterBanner().findElement(By.tagName("img")));
	}
	
	private WebElement obterLogoDoOGloboNoRodape() {
		return obterRodape().findElement(By.xpath("tbody/tr[1]/td/table/tbody/tr/td[1]"));
	}

	public boolean exibiuOLogoDoOGloboNoRodape() {
		//Elemento
		if (! obterLogoDoOGloboNoRodape().isDisplayed()) {
			System.out.println("O elemento logo do rodapé não está sendo exibido.");
			return false;
		}
		//Valor Elemento
		if (obterLogoDoOGloboNoRodape().findElement(By.tagName("img")).getAttribute("src").isEmpty()) {
			System.out.println("O valor do elemento logo do rodapé não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuUmLinkNoLogoDoOGloboNoRodape() {
		return ! obterLogoDoOGloboNoRodape().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public boolean exibiuOLogoDoOGloboNoRodapeSemBorda() {
		return naoExibiuBordaNaImagem(obterLogoDoOGloboNoRodape().findElement(By.tagName("img")));
	}
	
	private List<WebElement> obterListaDeRedesSociaisDoOGloboNoRodape() {
		return obterRodape().findElement(By.xpath("tbody/tr[1]/td/table/tbody/tr/td[2]")).findElements(By.tagName("td"));
	}

	public boolean exibiuAsRedesSociaisDoOGloboNoRodape() {
		int qtde = obterListaDeRedesSociaisDoOGloboNoRodape().size();
		
		if (qtde != 3) {
			System.out.println("Não foram exibidas 3 redes sociais no rodapé.");
			return false;
		}
		
		for (int i = 0; i < qtde; i++) {
			if (! obterListaDeRedesSociaisDoOGloboNoRodape().get(i).isDisplayed()) {
				System.out.println("A rede social " + (i+1) + " não está sendo exibida no rodapé.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaRedeSocialDoRodapeAImagemEOLinkCorretamente() {
		int qtde = obterListaDeRedesSociaisDoOGloboNoRodape().size();
		
		for (int i = 0; i < qtde; i++) {
			//Imagem
			if (obterListaDeRedesSociaisDoOGloboNoRodape().get(i).findElement(By.tagName("img")).getAttribute("src").isEmpty()) {
				System.out.println("A imagem da rede social " + (i+1) + " não está sendo exibida no rodapé.");
				return false;
			}
			//Link
			if (obterListaDeRedesSociaisDoOGloboNoRodape().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()) {
				System.out.println("O link da rede social " + (i+1) + " não está sendo exibido no rodapé.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaRedeSocialDoRodapeAImagemSemBorda() {
		int qtde = obterListaDeRedesSociaisDoOGloboNoRodape().size();
		
		for (int i = 0; i < qtde; i++) {
			if (! naoExibiuBordaNaImagem(obterListaDeRedesSociaisDoOGloboNoRodape().get(i).findElement(By.tagName("img")))) {
				System.out.println("A imagem da rede social " + (i+1) + " está exibindo uma borda no cabeçalho.");
				return false;
			}
		}
		return true;
	}
	
	private WebElement obterFooter() {
		return obterRodape().findElement(By.xpath("tbody/tr[2]"));
	}
	
	public boolean exibiuOFooter() {
		//Elemento
		if (! obterFooter().isDisplayed()) {
			System.out.println("O elemento footer não está sendo exibido.");
			return false;
		}
		//Valor Elemento
		String textoEsperado = "Portal do Assinante\n" +
							   "(21) 4002-5300 - Capitais e grandes cidades\n" +
							   "0800 021 8453 - Demais localidades\n\n" +
							   "2ª a 6ª feira, das 6h30 às 19h\n" +
							   "Sábados, domingos e feriados, das 7h às 12h";
		if (! obterFooter().getText().equals(textoEsperado)) {
			System.out.println("O valor do elemento footer não está sendo exibido conforme o esperado.");
			return false;
		}
		return true;
	}
}