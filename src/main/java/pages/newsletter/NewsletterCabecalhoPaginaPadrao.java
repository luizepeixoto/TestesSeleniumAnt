package pages.newsletter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class NewsletterCabecalhoPaginaPadrao extends NewsletterPaginaPadrao {
	
	public NewsletterCabecalhoPaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterLogoDoOGloboNoCabecalho() {
		return obterCabecalho().findElement(By.xpath("tbody/tr[3]/td/table/tbody/tr/td[1]"));
	}
	
	public boolean exibiuOLogoDoOGloboNoCabecalho() {
		//Elemento
		if (! obterLogoDoOGloboNoCabecalho().isDisplayed()) {
			System.out.println("O elemento logo do cabeçalho não está sendo exibido.");
			return false;
		}
		//Valor Elemento
		if (obterLogoDoOGloboNoCabecalho().findElement(By.tagName("img")).getAttribute("src").isEmpty()) {
			System.out.println("O valor do elemento logo do cabeçalho não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuUmLinkNoLogoDoOGloboNoCabecalho() {
		return ! obterLogoDoOGloboNoCabecalho().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public boolean exibiuOLogoDoOGloboNoCabecalhoSemBorda() {
		return naoExibiuBordaNaImagem(obterLogoDoOGloboNoCabecalho().findElement(By.tagName("img")));
	}
	
	private List<WebElement> obterListaDeRedesSociaisDoOGloboNoCabecalho() {
		return obterCabecalho().findElement(By.xpath("tbody/tr[3]/td/table/tbody/tr/td[3]")).findElements(By.tagName("td"));
	}
	
	private int obterQuantidadeDeRedesSociaisDoOGloboNoCabecalho() {
		return obterListaDeRedesSociaisDoOGloboNoCabecalho().size();
	}
	
	public boolean exibiuAsRedesSociaisDoOGloboNoCabecalho() {
		int qtde = obterQuantidadeDeRedesSociaisDoOGloboNoCabecalho();
		
		if (qtde != 3) {
			System.out.println("Não foram exibidas 3 redes sociais no cabeçalho.");
			return false;
		}
		
		for (int i = 0; i < qtde; i++) {
			if (! obterListaDeRedesSociaisDoOGloboNoCabecalho().get(i).isDisplayed()) {
				System.out.println("A rede social " + (i+1) + " não está sendo exibida no cabeçalho.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaRedeSocialAImagemEOLinkCorretamente() {
		int qtde = obterQuantidadeDeRedesSociaisDoOGloboNoCabecalho();
		
		for (int i = 0; i < qtde; i++) {
			//Imagem
			if (obterListaDeRedesSociaisDoOGloboNoCabecalho().get(i).findElement(By.tagName("img")).getAttribute("src").isEmpty()) {
				System.out.println("A imagem da rede social " + (i+1) + " não está sendo exibida no cabeçalho.");
				return false;
			}
			//Link
			if (obterListaDeRedesSociaisDoOGloboNoCabecalho().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()) {
				System.out.println("O link da rede social " + (i+1) + " não está sendo exibido no cabeçalho.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaRedeSocialDoRodapeAImagemSemBorda() {
		int qtde = obterQuantidadeDeRedesSociaisDoOGloboNoCabecalho();
		
		for (int i = 0; i < qtde; i++) {
			if (! naoExibiuBordaNaImagem(obterListaDeRedesSociaisDoOGloboNoCabecalho().get(i).findElement(By.tagName("img")))) {
				System.out.println("A imagem da rede social " + (i+1) + " está exibindo uma borda no cabeçalho.");
				return false;
			}
		}
		return true;
	}
	
	protected WebElement obterTitulo() {
		return obterHeader().findElement(By.tagName("span"));
	}
	
	private WebElement obterData() {
		return obterHeader().findElement(By.xpath("//span[2]"));
	}

	public boolean exibiuAData() {
		//Elemento data
		if (! obterData().isDisplayed()) {
			System.out.println("O elemento data não está sendo exibido.");
			return false;
		}
		//Valor elemento data
		String dataEsperada = new SimpleDateFormat("EEEE, dd 'de' MMMM',' yyyy", new Locale("pt", "br")).format(new Date());
		if (! obterData().getText().equals(dataEsperada)) {
			System.out.println("O valor do elemento data não está sendo exibido conforme o esperado.");
			return false;
		}
		return true;
	}
}