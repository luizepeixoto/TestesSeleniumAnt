package pages.newsletter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDestaques;

import br.com.infoglobo.pages.Navegador;

public class NewsletterCorpoPaginaPadrao extends NewsletterPaginaPadrao {
	
	protected List<WebElement> primeiraLista = obterPrimeiraListaDeMateriasSecundarias();
	protected List<WebElement> segundaLista = obterSegundaListaDeMateriasSecundarias();
	
	public NewsletterCorpoPaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	protected WebElement obterMateriaPrincipal() {
		return getDriver().findElement(By.className("newsMainArticle"));
	}
	
	public boolean exibiuAMateriaPrincipal() {
		return obterMateriaPrincipal().isDisplayed();
	}
	
	private WebElement obterEditoriaDaMateriaPrincipal() {
		return obterMateriaPrincipal().findElement(By.xpath("td[2]/table/tbody/tr[1]/td"));
	}
	
	protected WebElement obterLinkDaEditoriaDaMateriaPrincipal() {
		return obterEditoriaDaMateriaPrincipal().findElement(By.tagName("a"));
	}

	public boolean exibiuAEditoriaDaMateriaPrincipal() {
		//Elemento editoria da materia principal
		if (! obterEditoriaDaMateriaPrincipal().isDisplayed()) {
			System.out.println("O elemento editoria da matéria principal não está sendo exibido.");
			return false;
		}
		//Valor elemento editoria da materia principal
		if (obterEditoriaDaMateriaPrincipal().getText().isEmpty()) {
			System.out.println("O valor do elemento editoria da matéria principal não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	protected WebElement obterTituloDaMateriaPrincipal() {
		return obterMateriaPrincipal().findElement(By.xpath("td[2]/table/tbody/tr[2]/td"));
	}
	
	protected WebElement obterLinkDoTituloDaMateriaPrincipal() {
		return obterTituloDaMateriaPrincipal().findElement(By.tagName("a"));
	}

	public boolean exibiuOTituloDaMateriaPrincipal() {
		//Elemento titulo da materia principal
		if (! obterTituloDaMateriaPrincipal().isDisplayed()) {
			System.out.println("O elemento titulo da matéria principal não está sendo exibido.");
			return false;
		}
		//Valor elemento titulo da materia principal
		if (obterTituloDaMateriaPrincipal().getText().isEmpty()) {
			System.out.println("O valor do elemento titulo da matéria principal não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuOTituloDaMateriaPrincipalComOTamanhoDaFonteCorreto() {
		return obterTituloDaMateriaPrincipal().findElement(By.tagName("a")).getCssValue("font-size").equals("24px");
	}
	
	private WebElement obterFotoDaMateriaPrincipal() {
		return obterMateriaPrincipal().findElement(By.xpath("td[2]/table/tbody/tr[3]/td"));
	}
	
	protected WebElement obterLinkDaFotoDaMateriaPrincipal() {
		return obterFotoDaMateriaPrincipal().findElement(By.tagName("a"));
	}

	public boolean exibiuAFotoDaMateriaPrincipal() {
		//Elemento foto da materia principal
		if (! obterFotoDaMateriaPrincipal().isDisplayed()) {
			System.out.println("O elemento foto da matéria principal não está sendo exibido.");
			return false;
		}
		//Valor elemento foto da materia principal
		if (obterFotoDaMateriaPrincipal().findElement(By.tagName("img")).getAttribute("src").isEmpty()) {
			System.out.println("O valor do elemento foto da matéria principal não está sendo exibido.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuAFotoDaMateriaPrincipalComOEstiloCorreto() {
		String estiloEsperado = "display: block; width: 100%; max-width: 570px; border: 0px; outline: 0px;";
		return obterFotoDaMateriaPrincipal().findElement(By.tagName("img")).getAttribute("style").equals(estiloEsperado);
	}
	
	public boolean exibiuOMesmoLinkNaEditoriaNoTituloENaFotoDaMateriaPrincipal() {
		String editoria = obterLinkDaEditoriaDaMateriaPrincipal().getAttribute("href");
		String titulo = obterLinkDoTituloDaMateriaPrincipal().getAttribute("href");
		String foto = obterLinkDaFotoDaMateriaPrincipal().getAttribute("href");
		
		if (! editoria.equals(titulo)) {
			System.out.println("Os links exibidos na editoria e no título da matéria principal estão diferentes.");
			return false;
		}
		if (! editoria.equals(foto)) {
			System.out.println("Os links exibidos na editoria e na foto da matéria principal estão diferentes.");
			return false;
		}
		if (! titulo.equals(foto)) {
			System.out.println("Os links exibidos no título e na foto da matéria principal estão diferentes.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuOCropDaFotoDaMateriaPrincipalCorreto() {
		return obterFotoDaMateriaPrincipal().findElement(By.tagName("img")).getAttribute("src").contains(CropsDestaques.newsletterDestaquePrincipal.cropProporcional());
	}
	
	public boolean exibiuOAltDaFotoDaMateriaPrincipal() {
		return ! obterFotoDaMateriaPrincipal().findElement(By.tagName("img")).getAttribute("alt").isEmpty();
	}
	
	public boolean exibiuAFotoDaMateriaPrincipalSemBorda() {
		return naoExibiuBordaNaImagem(obterFotoDaMateriaPrincipal().findElement(By.tagName("img")));
	}
	
	private boolean exibiuBarraNoElemento(WebElement elemento) {
		return elemento.getCssValue("border-bottom").equals("1px solid rgb(220, 220, 220)");
	}
	
	public boolean exibiuABarraAposAMateriaPrincipal() {
		return exibiuBarraNoElemento(obterFotoDaMateriaPrincipal());
	}
	
	private List<WebElement> obterPrimeiraListaDeMateriasSecundarias() {
		return getDriver().findElements(By.className("newsArticle"));
	}
	
	private int obterQuantidadeDeMateriasSecundariasDaPrimeiraLista() {
		return obterPrimeiraListaDeMateriasSecundarias().size();
	}

	public boolean exibiuAPrimeiraListaDeMateriasSecundarias() {
		return obterQuantidadeDeMateriasSecundariasDaPrimeiraLista() > 0;
	}
	
	private WebElement obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return lista.get(posicao).findElement(By.xpath("td[2]")).findElement(By.tagName("img"));
	}
	
	protected WebElement obterLinkDaFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, posicao).findElement(By.xpath(".."));
	}
	
	private WebElement obterEditoriaDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return lista.get(posicao).findElement(By.xpath("td[2]/table/tbody/tr[1]/td[2]"));
	}
	
	protected WebElement obterLinkDaEditoriaDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return obterEditoriaDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, posicao).findElement(By.tagName("a"));
	}
	
	private WebElement obterTituloDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return lista.get(posicao).findElement(By.xpath("td[2]/table/tbody/tr[2]"));
	}
	
	protected WebElement obterLinkDoTituloDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return obterTituloDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, posicao).findElement(By.tagName("a"));
	}
	
	private WebElement obterOpcaoContinuarLendoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return lista.get(posicao).findElement(By.xpath("td[2]/table/tbody/tr[3]"));
	}
	
	protected WebElement obterLinkDaOpcaoContinuarLendoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return obterOpcaoContinuarLendoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, posicao).findElement(By.tagName("a"));
	}
	
	private WebElement obterBarraAposUmaMateriaSecundariaDeAcordoComAListaEAPosicao(List<WebElement> lista, int posicao) {
		return lista.get(posicao).findElement(By.xpath("td[2]"));
	}
	
	private boolean exibiuParaCadaMateriaSecundariaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarraDeAcordoComALista(List<WebElement> lista, String nomeLista) {
		int qtde = lista.size();
		
		for (int i = 0; i < qtde; i++) {
			//Elemento foto
			if (! obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).isDisplayed()) {
				System.out.println("O elemento foto não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Valor elemento foto
			if (obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getAttribute("src").isEmpty()) {
				System.out.println("A url do elemento foto não está sendo exibida na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Crop elemento foto
			if (! obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getAttribute("src").contains(CropsDestaques.newsletterDestaqueSecundario.cropProporcional())) {
				System.out.println("O crop do elemento foto não está correto na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Elemento editoria
			if (! obterEditoriaDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).isDisplayed()) {
				System.out.println("O elemento editoria não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Valor elemento editoria
			if (obterEditoriaDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getText().isEmpty()) {
				System.out.println("O valor do elemento editoria não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Elemento titulo
			if (! obterTituloDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).isDisplayed()) {
				System.out.println("O elemento titulo não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Valor elemento titulo
			if (obterTituloDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getText().isEmpty()) {
				System.out.println("O valor do elemento titulo não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Elemento continuar lendo
			if (! obterOpcaoContinuarLendoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).isDisplayed()) {
				System.out.println("O elemento continuar lendo não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Valor elemento continuar lendo
			if (obterOpcaoContinuarLendoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getText().isEmpty()) {
				System.out.println("O valor do elemento continuar lendo não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
			//Elemento barra
			if (! exibiuBarraNoElemento(obterBarraAposUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i))) {
				System.out.println("O elemento barra não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
		}
		return true;
	}

	public boolean exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarra() {
		return exibiuParaCadaMateriaSecundariaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarraDeAcordoComALista(primeiraLista, "primeira");
	}
	
	private boolean exibiuParaCadaMateriaSecundariaAFotoComOEstiloCorretoDeAcordoComALista(List<WebElement> lista, String nomeLista) {
		int qtde = lista.size();
		String estiloEsperado = "display: block; border: 0px; outline: 0px; width: 148px !important; height: 89px !important;";
		
		for (int i = 0; i < qtde; i++) {
			if (! obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getAttribute("style").equals(estiloEsperado)) {
				System.out.println("O estilo da foto da matéria " + (i + 1) + " da " + nomeLista + " lista esta diferente do esperado.");
				return false;
			}
		}
		return true;
	}	
	
	public boolean exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoComOEstiloCorreto() {
		return exibiuParaCadaMateriaSecundariaAFotoComOEstiloCorretoDeAcordoComALista(primeiraLista, "primeira");
	}
	
	private boolean exibiuParaCadaMateriaSecundariaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendoDeAcordoComALista(List<WebElement> lista, String nomeLista) {
		int qtde = lista.size();
		
		for (int i = 0; i < qtde; i++) {
			String foto = obterLinkDaFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getAttribute("href");
			String editoria = obterLinkDaEditoriaDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getAttribute("href");
			String titulo = obterLinkDoTituloDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getAttribute("href");
			String opContinuar = obterLinkDaOpcaoContinuarLendoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getAttribute("href");
			
			if (! foto.equals(editoria)) {
				System.out.println("Os links exibidos na foto e na editoria da matéria " + (i + 1) + " da " + nomeLista + " estão diferentes.");
				return false;
			}
			if (! foto.equals(titulo)) {
				System.out.println("Os links exibidos na foto e no titulo da matéria " + (i + 1) + " da " + nomeLista + " estão diferentes.");
				return false;
			}
			if (! foto.equals(opContinuar)) {
				System.out.println("Os links exibidos na foto e na opção continuar lendo da matéria " + (i + 1) + " da " + nomeLista + " estão diferentes.");
				return false;
			}
			if (! editoria.equals(titulo)) {
				System.out.println("Os links exibidos na editoria e no titulo da matéria " + (i + 1) + " da " + nomeLista + " estão diferentes.");
				return false;
			}
			if (! editoria.equals(opContinuar)) {
				System.out.println("Os links exibidos na editoria e na opção continuar lendo da matéria " + (i + 1) + " da " + nomeLista + " estão diferentes.");
				return false;
			}
			if (! titulo.equals(opContinuar)) {
				System.out.println("Os links exibidos no título e na opção continuar lendo da matéria " + (i + 1) + " da " + nomeLista + " estão diferentes.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaPrimeiraListaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo() {
		return exibiuParaCadaMateriaSecundariaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendoDeAcordoComALista(primeiraLista, "primeira");
	}
	
	private boolean exibiuParaCadaMateriaSecundariaOAltDaFotoDeAcordoComALista(List<WebElement> lista, String nomeLista) {
		int qtde = lista.size();
		
		for (int i = 0; i < qtde; i++) {
			if (obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(lista, i).getAttribute("alt").isEmpty()) {
				System.out.println("O alt da foto não está sendo exibido na matéria " + (i + 1) + " da " + nomeLista + " lista.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaPrimeiraListaOAltDaFoto() {
		return exibiuParaCadaMateriaSecundariaOAltDaFotoDeAcordoComALista(primeiraLista, "primeira");
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoSemBorda() {
		int qtde = obterQuantidadeDeMateriasSecundariasDaPrimeiraLista();
		
		for (int i = 0; i < qtde; i++) {
			if (! naoExibiuBordaNaImagem(obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(primeiraLista, i))) {
				System.out.println("A borda da foto da matéria " + (i + 1) + " está sendo exibida na primeira lista.");
				return false;
			}
		}
		return true;
	}
	
	private WebElement obterAreaGenteDoGlobo() {
		return getDriver().findElement(By.className("newsBlog"));
	}

	public boolean exibiuAAreaGenteDoGlobo() {
		return obterAreaGenteDoGlobo().isDisplayed();
	}
	
	private List<WebElement> obterListaDeBlogs() {
		return obterAreaGenteDoGlobo().findElement(By.xpath("td[2]")).findElements(By.xpath("table[contains(@style, 'width')]"));
	}
	
	protected int obterQuantidadeDeBlogs() {
		return obterListaDeBlogs().size();
	}

	public boolean exibiuUmaListaDeBlogsNaAreaGenteDoGlobo() {
		return obterQuantidadeDeBlogs() > 0;
	}
	
	private WebElement obterFotoDeUmBlogDeAcordoComAPosicao(int posicao) {
		return obterListaDeBlogs().get(posicao).findElement(By.tagName("img"));
	}
	
	protected WebElement obterLinkDaFotoDeUmBlogDeAcordoComAPosicao(int posicao) {
		return obterFotoDeUmBlogDeAcordoComAPosicao(posicao).findElement(By.xpath(".."));
	}
	
	private WebElement obterNomeDeUmBlogDeAcordoComAPosicao(int posicao) {
		return obterListaDeBlogs().get(posicao).findElement(By.xpath("tbody/tr/td[2]/table/tbody/tr[1]"));
	}
	
	protected WebElement obterLinkDoNomeDeUmBlogDeAcordoComAPosicao(int posicao) {
		return obterNomeDeUmBlogDeAcordoComAPosicao(posicao).findElement(By.tagName("a"));
	}
	
	private WebElement obterTituloDoUltimoPostDeUmBlogDeAcordoComAPosicao(int posicao) {
		return obterListaDeBlogs().get(posicao).findElement(By.xpath("tbody/tr/td[2]/table/tbody/tr[2]"));
	}
	
	protected WebElement obterLinkDoTituloDoUltimoPostDeUmBlogDeAcordoComAPosicao(int posicao) {
		return obterTituloDoUltimoPostDeUmBlogDeAcordoComAPosicao(posicao).findElement(By.tagName("a"));
	}

	public boolean exibiuParaCadaBlogAFotoONomeEOTituloDoUltimoPost() {
		int qtde = obterQuantidadeDeBlogs();
		
		for (int i = 0; i < qtde; i++) {
			//Elemento foto
			if (! obterFotoDeUmBlogDeAcordoComAPosicao(i).isDisplayed()) {
				System.out.println("O elemento foto não está sendo exibido no blog " + (i + 1) + ".");
				return false;
			}
			//Valor elemento foto
			if (obterFotoDeUmBlogDeAcordoComAPosicao(i).getAttribute("src").isEmpty()) {
				System.out.println("A url do elemento foto não está sendo exibida no blog " + (i + 1) + ".");
				return false;
			}
			//Elemento nome
			if (! obterNomeDeUmBlogDeAcordoComAPosicao(i).isDisplayed()) {
				System.out.println("O elemento nome não está sendo exibido no blog " + (i + 1) + ".");
				return false;
			}
			//Valor elemento nome
			if (obterNomeDeUmBlogDeAcordoComAPosicao(i).getText().isEmpty()) {
				System.out.println("O valor do elemento nome não está sendo exibido no blog " + (i + 1) + ".");
				return false;
			}
			//Elemento titulo do ultimo post
			if (! obterTituloDoUltimoPostDeUmBlogDeAcordoComAPosicao(i).isDisplayed()) {
				System.out.println("O elemento titulo do ultimo post não está sendo exibido no blog " + (i + 1) + ".");
				return false;
			}
			//Valor elemento titulo do ultimo post
			if (obterTituloDoUltimoPostDeUmBlogDeAcordoComAPosicao(i).getText().isEmpty()) {
				System.out.println("O valor do elemento titulo do ultimo post não está sendo exibido no blog " + (i + 1) + ".");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaBlogATabelaComOEstiloCorreto() {
		int qtde = obterQuantidadeDeBlogs();
		String estiloEsperado = "min-width: 250px; width: 50%; height: 110px; display: inline-block; float: left;";
		
		for (int i = 0; i < qtde; i++) {
			if (! obterListaDeBlogs().get(i).getAttribute("style").equals(estiloEsperado)) {
				System.out.println("O estilo da tabela do blog " + (i + 1) + " esta diferente do esperado.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaBlogAFotoComOEstiloCorreto() {
		int qtde = obterQuantidadeDeBlogs();
		String estiloEsperado = "width: 70px; display: block; border: 0px; outline: 0px; height: auto !important;";
		
		for (int i = 0; i < qtde; i++) {
			if (! obterFotoDeUmBlogDeAcordoComAPosicao(i).getAttribute("style").equals(estiloEsperado)) {
				System.out.println("O estilo da foto do blog " + (i + 1) + " esta diferente do esperado.");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaBlogOMesmoLinkNaFotoNoNomeENoTituloDoUltimoPost() {
		int qtde = obterQuantidadeDeBlogs();
		
		for (int i = 0; i < qtde; i++) {
			String foto = obterLinkDaFotoDeUmBlogDeAcordoComAPosicao(i).getAttribute("href");
			String nome = obterLinkDoNomeDeUmBlogDeAcordoComAPosicao(i).getAttribute("href");
			String tituloPost = obterLinkDoTituloDoUltimoPostDeUmBlogDeAcordoComAPosicao(i).getAttribute("href");
			
			if (! foto.equals(nome)) {
				System.out.println("Os links exibidos na foto e no nome do blog " + (i + 1) + " estão diferentes.");
				return false;
			}
			if (! foto.equals(tituloPost)) {
				System.out.println("Os links exibidos na foto e no titulo do ultimo post do blog " + (i + 1) + " estão diferentes.");
				return false;
			}
			if (! nome.equals(tituloPost)) {
				System.out.println("Os links exibidos no nome e no titulo do ultimo post do blog " + (i + 1) + " estão diferentes.");
				return false;
			}
		}	
		return true;
	}

	public boolean exibiuParaCadaBlogOAltDaFoto() {
		int qtde = obterQuantidadeDeBlogs();
		
		for (int i = 0; i < qtde; i++) {
			//Elemento foto
			if (obterFotoDeUmBlogDeAcordoComAPosicao(i).getAttribute("alt").isEmpty()) {
				System.out.println("O alt da foto não está sendo exibido no blog " + (i + 1) + ".");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuParaCadaBlogAFotoSemBorda() {
		int qtde = obterQuantidadeDeBlogs();
		
		for (int i = 0; i < qtde; i++) {
			if (! naoExibiuBordaNaImagem(obterFotoDeUmBlogDeAcordoComAPosicao(i))) {
				System.out.println("A borda da foto está sendo exibida no blog " + (i + 1) + ".");
				return false;
			}
		}
		return true;
	}

	public boolean exibiuABarraAposAAreaGenteDoGlobo() {
		return exibiuBarraNoElemento(obterAreaGenteDoGlobo().findElement(By.xpath("td[2]")));
	}
	
	private List<WebElement> obterSegundaListaDeMateriasSecundarias() {
		return getDriver().findElements(By.className("newsSecondArticle"));
	}
	
	private int obterQuantidadeDeMateriasSecundariasDaSegundaLista() {
		return obterSegundaListaDeMateriasSecundarias().size();
	}

	public boolean exibiuASegundaListaDeMateriasSecundarias() {
		return obterQuantidadeDeMateriasSecundariasDaSegundaLista() > 0;
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarra() {
		return exibiuParaCadaMateriaSecundariaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarraDeAcordoComALista(segundaLista, "segunda");
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoComOEstiloCorreto() {
		return exibiuParaCadaMateriaSecundariaAFotoComOEstiloCorretoDeAcordoComALista(segundaLista, "segunda");
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaSegundaListaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo() {
		return exibiuParaCadaMateriaSecundariaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendoDeAcordoComALista(segundaLista, "segunda");
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaSegundaListaOAltDaFoto() {
		return exibiuParaCadaMateriaSecundariaOAltDaFotoDeAcordoComALista(segundaLista, "segunda");
	}
	
	public boolean exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoSemBorda() {
		int qtde = obterQuantidadeDeMateriasSecundariasDaSegundaLista();
		
		for (int i = 0; i < qtde; i++) {
			if (! naoExibiuBordaNaImagem(obterFotoDeUmaMateriaSecundariaDeAcordoComAListaEAPosicao(segundaLista, i))) {
				System.out.println("A borda da foto da matéria " + (i + 1) + " está sendo exibida na segunda lista.");
				return false;
			}
		}
		return true;
	}
	
	protected WebElement obterOpcaoContinuarLendoDaMateriaPrincipalDaNewsletterUrgente() {
		return obterMateriaPrincipal().findElement(By.xpath("td[2]/table/tbody/tr[3]/td"));
	}
}