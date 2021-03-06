package pages.coluna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ColunaComFoto extends AceitacaoAbstractTest {

	public ColunaComFoto(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuCabecalhoDaColuna() {
		return getDriver().findElement(By.className("header-coluna")).findElement(By.className("columns"));
	}

	public String exibiuOTituloColuna() {
		return exibiuCabecalhoDaColuna().findElement(By.className("sub-editoria")).getText();
	}

	public boolean exibiuOTituloComOAutorDaColuna() {
		return !exibiuCabecalhoDaColuna().findElement(By.className("autor")).getText().isEmpty();
	}

	public boolean exibiuADescricaoDaColuna() {
		return !exibiuCabecalhoDaColuna().findElement(By.className("slogan")).getText().isEmpty();
	}
	
	public WebElement exibiuClasseCorpoLarge16Columns() {
		return getDriver().findElement(By.tagName("article")).findElement(By.className("corpo"));
	}
	
	public boolean exibiuAFotoDoColunista() {
		return exibiuClasseCorpoLarge16Columns().findElement(By.className("user")).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuAFotoDoColunistaComOCropCorreto() {
		String urlDaFoto = exibiuClasseCorpoLarge16Columns().findElement(By.className("user")).findElement(By.tagName("img")).getAttribute("src");
		return urlDaFoto.contains(CropsDeArticles.colunaFotoDoAutor.cropProporcional());
	}
	
	public boolean exibiuAFotoDoColunistaComOWidthCorreto() {
		String tamanhoDoWidth = getDriver().findElement(By.className("user")).findElement(By.tagName("img")).getAttribute("width");
		return Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.colunaFotoDoAutor.getWidth());
	}
	
	public boolean exibiuAFotoDoColunistaComOHeightCorreto() {
		String tamanhoDoHeight = getDriver().findElement(By.className("user")).findElement(By.tagName("img")).getAttribute("height");
		return Integer.parseInt(tamanhoDoHeight) <= Integer.parseInt(CropsDeArticles.colunaFotoDoAutor.getHeight());
	}
	
	public WebElement exibiuBoxColuna() {
		return getDriver().findElement(By.className("corpo-coluna"));
	}
	
	public WebElement exibiuCorpoDaColuna() {
		return exibiuClasseCorpoLarge16Columns().findElement(By.className("corpo-coluna"));
	}

	public boolean exibiuAData() {
		return !exibiuCorpoDaColuna().findElement(By.className("data-cadastro")).findElement(By.tagName("time")).getText().isEmpty();
	}

	public boolean exibiuOTitulo() {
		return !exibiuCorpoDaColuna().findElement(By.tagName("h1")).getText().isEmpty();
	}

	public boolean exibiuFotoNaPrimeiraPosicao() {
		return exibiuCorpoDaColuna().findElement(By.className("foto")).findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuCropCorretoNaFotoInline() {
		String urlDaImagem = exibiuCorpoDaColuna().findElement(By.className("foto")).findElement(By.tagName("img")).getAttribute("src");
		return urlDaImagem.contains(CropsDeArticles.colunaFotoInline.cropProporcional());
	}
	

	public boolean exibiuWidthDaPrimeiraPosicao() {
		String widthDaImagem = exibiuCorpoDaColuna().findElement(By.className("foto")).findElement(By.tagName("img")).getAttribute("width");
		return Integer.parseInt(widthDaImagem) <= Integer.parseInt(CropsDeArticles.colunaFotoInline.getWidth());
	}

	public boolean exibiuHeightDaPrimeiraPosicao() {
		String heightDaImagem = exibiuCorpoDaColuna().findElement(By.className("foto")).findElement(By.tagName("img")).getAttribute("height");
		return Integer.parseInt(heightDaImagem) <= Integer.parseInt(CropsDeArticles.colunaFotoInline.getHeight());
	}
	
	public boolean exibiuLegendaDaFoto() {
		return !exibiuCorpoDaColuna().findElement(By.className("foto")).findElement(By.tagName("figcaption")).getText().isEmpty();
	}
	
	public boolean exibiuOAutorDaFoto() {
		return !exibiuCorpoDaColuna().findElement(By.className("foto")).findElement(By.tagName("figcaption")).findElement(By.tagName("b")).getText().isEmpty();
	}
	
	public List<WebElement> totalDeTagsP(){
		return exibiuCorpoDaColuna().findElements(By.tagName("p"));
	}
	
	public boolean exibiuOTexto() {
		for(int i=0; i<totalDeTagsP().size(); i++){
			if(totalDeTagsP().get(i).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public String exibiuOTituloNoFimDaPaginaLeiaTodasAsColunas() {
		return getDriver().findElement(By.className("todas")).getText();
	}
	
	public boolean exibiuUmLinkEmLeiatodasAsColunas() {
		return totalDeTagsP().get(totalDeTagsP().size()-1).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoEmLeiatodasAsColunas() {
		return !totalDeTagsP().get(totalDeTagsP().size()-1).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
}