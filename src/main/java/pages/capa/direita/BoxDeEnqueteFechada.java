package pages.capa.direita;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxDeEnqueteFechada extends AceitacaoAbstractTest {
	
	public BoxDeEnqueteFechada(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public boolean exibiuAEnquete() throws InterruptedException {
		esperaCarregar(1);
		executarScroll(getDriver().findElement(By.className("enquete")).getLocation().toString());
		return getDriver().findElement(By.className("enquete")).isDisplayed();
	}

	public String exibiuTituloEnquete() {
		return getDriver().findElement(By.className("enquete")).findElement(By.className("legenda-enquete")).getText();
	}

	public boolean exibiuPerguntaDaEnquete() {
		return !getDriver().findElement(By.className("enquete")).findElement(By.className("titulo-enquete")).getText().isEmpty();
	}
	
	public List<WebElement> listaComTodasAsOpcoesDaEnquete(){
		return getDriver().findElement(By.className("enquete")).findElement(By.className("results")).findElements(By.tagName("li"));
	}

	public boolean exibiuOpcoesDaEnquete() {
		return listaComTodasAsOpcoesDaEnquete().size() > 2;
	}
	
	public boolean exibiuOpcoesDaEnqueteComFoto() {
		for(int i=0; i < listaComTodasAsOpcoesDaEnquete().size(); i++){
			if(!listaComTodasAsOpcoesDaEnquete().get(i).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOpcoesDaEnqueteComTitulo() {
		for(int i=0; i < listaComTodasAsOpcoesDaEnquete().size(); i++){
			if(listaComTodasAsOpcoesDaEnquete().get(i).findElement(By.className("option")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOpcoesDaEnqueteComOTotalPercentual() {
		for(int i=0; i < listaComTodasAsOpcoesDaEnquete().size(); i++){
			if(listaComTodasAsOpcoesDaEnquete().get(i).findElement(By.className("result-percent")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOpcoesDaEnqueteComABarraPercentual() {
		for(int i=0; i < listaComTodasAsOpcoesDaEnquete().size(); i++){
			if(!listaComTodasAsOpcoesDaEnquete().get(i).findElement(By.className("result-bar")).findElement(By.tagName("span")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOTituloComOTotalDeResultados() {
		return getDriver().findElement(By.className("total-votos")).getText().contains("Total de votos:");
	}
}