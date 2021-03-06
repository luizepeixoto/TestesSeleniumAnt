package pages.editoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxDeUltimasNoticiasDeUmTopico extends AceitacaoAbstractTest {
	
	public BoxDeUltimasNoticiasDeUmTopico() throws Exception{
		super();
	}
	
	public BoxDeUltimasNoticiasDeUmTopico(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public boolean exibiuEditoria() {
		return !getDriver().findElement(By.className("titulo-subeditorias")).findElement(By.tagName("h1")).getText().isEmpty();
	}
	
	public WebElement exibiuOIframe() {
		return getDriver().findElement(By.className("large-12")).findElement(By.tagName("iframe"));
	}

	public boolean exibiuInformacoesDoColegio24Hrs() {
		return exibiuOIframe().getAttribute("src").contains("http://www.colegio24horas.com.br/");
	}
	
	public String getIframeWidth() {
		return exibiuOIframe().getAttribute("width");
	}
	
	public String getIframeHeight() {
		return exibiuOIframe().getAttribute("height");
	}
	
	public WebElement exibiuColunaDaDireita() {
		return getDriver().findElement(By.className("col-right"));
	}
	
	public boolean exibiuBannerArroba() {
		return exibiuColunaDaDireita().findElement(By.className("arroba")).isDisplayed();
	}
	
	public boolean exibiuTituloPublicidade() {
		return exibiuColunaDaDireita().findElement(By.className("arroba")).findElement(By.tagName("p")).getText().equals("Publicidade");
	}
	
	public WebElement exibiuBoxUltimasNoticias() {
		return getDriver().findElement(By.className("ultimas-noticias"));
	}

	public boolean exibiuTituloDoBox() {
		return !exibiuBoxUltimasNoticias().getText().isEmpty();
	}

	public boolean exibiuUmLinkNoTituloDoBox() {
		return exibiuBoxUltimasNoticias().findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuUmLinkValidoNoTituloDoBox() {
		return !exibiuBoxUltimasNoticias().findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	
	public List<WebElement> listaDeMaterias() {
		return exibiuBoxUltimasNoticias().findElement(By.tagName("div")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuQuantidadeMaiorQueUm() {
		return listaDeMaterias().size() > 1;
	}

	public boolean exibiuHoraParaAsMaterias() {
		for(int i=0; i< listaDeMaterias().size(); i++){
			if(listaDeMaterias().get(i).findElement(By.tagName("span")).findElements(By.tagName("b")).get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public String exibiuHoraNoFormatoHHMM() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/div/ul/li[1]/span/b[1]")).getText();			
	}
	
	public boolean exibiuDataParaAsMaterias() {
		for(int i=0; i< listaDeMaterias().size(); i++){
			if(listaDeMaterias().get(i).findElement(By.tagName("span")).findElements(By.tagName("b")).get(1).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public String exibiuDataNoFormatoDDMM() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/div/ul/li[1]/span/b[2]")).getText();
	}
	
	public boolean exibiuEditoriaParaAsMaterias() {
		for(int i=0; i< listaDeMaterias().size(); i++){
			if(listaDeMaterias().get(i).findElements(By.tagName("span")).get(1).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloDaMateria() {
		for(int i=0; i< listaDeMaterias().size(); i++){
			if(listaDeMaterias().get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public String exibiuTituloVerTodasAsMateriasDoSite() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/a")).getText();
	}

	public boolean exibiuLinkNoTituloVerMaisNoticias() {
		return getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/a")).isDisplayed();
	}

	public boolean exibiuLinkValidoNoTituloVerMaisNoticias() {
		return !getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/a")).getAttribute("href").isEmpty();
	}
	
	public boolean exibiuEditoriaCorretaNoLinkDeVerMaisNoticias() {
		String editoriaEsperada = listaDeMaterias().get(0).findElements(By.tagName("span")).get(1).getText();
		String linkDeUltimasEsperado = getDriver().findElement(By.xpath("//div[@class='ultimas-noticias clearfix']/a")).getAttribute("href");
		return linkDeUltimasEsperado.contains(editoriaEsperada.toLowerCase());
	}
}
