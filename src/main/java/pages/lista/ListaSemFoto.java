package pages.lista;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ListaSemFoto extends AceitacaoAbstractTest {
	
	public ListaSemFoto() throws Exception {
		super();
	}
	
	public ListaSemFoto(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuGaleria() {
		return getDriver().findElement(By.className("galeria"));
	}
	
	public boolean exibiuTitulo() {
		return !exibiuGaleria().findElement(By.className("titulo-galeria")).getText().isEmpty();
	}
	
	public WebElement exibiuClasseDezMais() {
		return getDriver().findElement(By.className("dez-mais-lista"));
	}
	
	public List<WebElement> listaDeMaterias() {
		return exibiuClasseDezMais().findElement(By.className("itens-lista")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuListaDeMaterias() {
		return listaDeMaterias().size() > 1;
	}

	public boolean exibiuTituloDaMateria() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(listaDeMaterias().get(i).findElement(By.className("titulo-foto")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuDescricaoDaMateria() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(listaDeMaterias().get(i).findElement(By.className("subtitulo-foto")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuDescricaoSemFotoCom1300Caracteres() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(listaDeMaterias().get(i).findElement(By.className("subtitulo-foto")).getText().length() > 1303){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTotalDeFatos() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(listaDeMaterias().get(i).findElement(By.className("counter")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuImagem() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiFotoNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("figure"));
			if(possuiFotoNaPosicao.size() > 0){
					return false;
				}
			}
		return true;
	}
	
	public boolean exibiuImagemComWidthCorreto() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiFotoNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("figure"));
			if(possuiFotoNaPosicao.size() > 0){
				if(!(listaDeMaterias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).getAttribute("width").equals("704") || 
						listaDeMaterias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).getAttribute("width").equals("260"))){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuImagemComHeightCorreto() {
		for(int i=0;i<listaDeMaterias().size();i++){
			List<WebElement> possuiFotoNaPosicao = listaDeMaterias().get(i).findElements(By.tagName("figure"));
			if(possuiFotoNaPosicao.size() > 0){
				if(listaDeMaterias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).getAttribute("height").equals("432")){
					return false;
				}
			}
		}
		return true;
	}

	public WebElement exibiuNavegacao() {
		return exibiuGaleria().findElement(By.className("nav-container"));
	}

	public boolean exibiuSetaDesabilitada() {
		return exibiuNavegacao().findElements(By.tagName("a")).get(0).getAttribute("class").contains("anterior disabled");
	}

	public boolean exibiuSetaParaADireita() {
		return exibiuNavegacao().findElements(By.tagName("a")).get(1).getAttribute("class").contains("proxima");
	}
	
	public boolean exibiuUmLinkValidoNaSetaParaADireita() {
		return !exibiuNavegacao().findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty();
	}

	public boolean exibiuTotalDeFotosAtualizado() {
		String primeiroTotalRetornado = listaDeMaterias().get(0).findElement(By.className("counter")).getText();
		exibiuGaleria().findElement(By.xpath("/html/body/div[7]/div/div/div/div/div/a[2]")).click();
		return !primeiroTotalRetornado.equals(listaDeMaterias().get(1).findElement(By.className("counter")).getText());
	}

	public WebElement exibiuBoxDeMaisGalerias() {
		return getDriver().findElement(By.className("mais-galerias"));
	}

	public List<WebElement> ListaDeOutrasGalerias() {
		return exibiuBoxDeMaisGalerias().findElement(By.className("mais-galerias-container")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuListaDeOutrasGalerias() {
		return ListaDeOutrasGalerias().size() > 1;
	}

	public boolean exibiuImagemParaOsItensDaListaDeOutrasGalerias() {
		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
			if(!ListaDeOutrasGalerias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagemComWidthCorretoParaOsItensDaListaDeOutrasGalerias() {
		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
			if(!ListaDeOutrasGalerias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).getAttribute("width").equals("234")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagemComHeightCorretoParaOsItensDaListaDeOutrasGalerias() {
		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
			if(!ListaDeOutrasGalerias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).getAttribute("height").equals("140")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkNaImagemDosItensDaListaDeOutrasGalerias() {
		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
			if(!ListaDeOutrasGalerias().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloParaOsItensDaListaDeOutrasGalerias() {
		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
			if(ListaDeOutrasGalerias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("figcaption")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuSetaDaEsquerdaDeMaisListasDesabilitada() {
		return exibiuBoxDeMaisGalerias().findElement(By.className("nav-container")).findElements(By.tagName("a")).get(0).getAttribute("class").contains("anterior disabled");
	}
	
	public boolean exibiuSetaParaADireitaDeMaisListas() {
		return exibiuBoxDeMaisGalerias().findElement(By.className("nav-container")).findElements(By.tagName("a")).get(1).isDisplayed();
	}
	
	public boolean exibiuUmLinkValidoNaSetaParaADireitaDeMaisListas() {
		return !exibiuBoxDeMaisGalerias().findElement(By.className("nav-container")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty();
	}
	
	public List<WebElement> listaDeMaisGalerias() {
		return getDriver().findElements(By.className("mais-galerias"));
	}
	
	public boolean exibiuMaisListas() {
		return listaDeMaisGalerias().size() > 1;
	}

	public boolean exibiuLinkDeAbrirGaleria() {
		return listaDeMaisGalerias().get(1).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuLinkValidoDeAbrirGaleria() {
		return !listaDeMaisGalerias().get(1).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public List<WebElement> listaDeItensDeMaisGalerias() {
		return listaDeMaisGalerias().get(1).findElement(By.className("closed")).findElement(By.className("mais-galerias-container")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuImagemParaOsItensDeMaisGalerias() throws InterruptedException {
		getDriver().findElement(By.xpath("/html/body/div[10]/div[1]/a")).click();
		Thread.sleep(1000);
		for(int i=0;i<listaDeItensDeMaisGalerias().size();i++){
			if(!listaDeItensDeMaisGalerias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
//	public boolean exibiuImagemComWidthCorretoParaOsItensDaListaDeOutrasGalerias() {
//		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
//			if(!ListaDeOutrasGalerias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).getAttribute("width").equals("234")){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean exibiuImagemComHeightCorretoParaOsItensDaListaDeOutrasGalerias() {
//		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
//			if(!ListaDeOutrasGalerias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("img")).getAttribute("height").equals("140")){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean exibiuLinkNaImagemDosItensDaListaDeOutrasGalerias() {
//		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
//			if(!ListaDeOutrasGalerias().get(i).findElement(By.tagName("a")).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean exibiuTituloParaOsItensDaListaDeOutrasGalerias() {
//		for(int i=0;i<ListaDeOutrasGalerias().size();i++){
//			if(ListaDeOutrasGalerias().get(i).findElement(By.tagName("figure")).findElement(By.tagName("figcaption")).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
}
