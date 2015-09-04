package pages.capa.direita;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxRioShow extends AceitacaoAbstractTest {
	
	public BoxRioShow(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuBoxDoRioShow() {
		return getDriver().findElement(By.className("col-right")).findElement(By.className("boxRioShowCapa"));
	}
	
	public List<WebElement> listaDeConteudosDoRioShow() {
		return exibiuBoxDoRioShow().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaListaDeConteudos() {
		return listaDeConteudosDoRioShow().size() > Integer.parseInt("1");
	}
	
	public boolean exibiuBoxDeNavegacaoDosConteudos(){
		return exibiuBoxDoRioShow().findElement(By.className("nav-container")).isDisplayed();
	}
	
	public boolean exibiuBoxDeNavegacaoParaADireita(){
		return exibiuBoxDoRioShow().findElement(By.className("nav-container")).findElement(By.className("proxima")).isDisplayed();
	}
	
	public boolean exibiuBoxDeNavegacaoParaAEsquerda(){
		return exibiuBoxDoRioShow().findElement(By.className("nav-container")).findElement(By.className("anterior")).isDisplayed();
	}
	
	public boolean exibiuAlgumaDasPaginacoesComoDesabilitada(){
		try {
			exibiuBoxDoRioShow().findElement(By.className("nav-container")).findElement(By.className("disabled")).isDisplayed();
			System.out.println("O Box não está sendo exibido como uma lista circular.");
			return false;
		} catch (Exception e) {
			return true;
		}
	}
	
	public void clicarNoProximoConteudo() throws InterruptedException{
		esperaCarregar(1);
		exibiuBoxDoRioShow().findElement(By.className("nav-container")).findElement(By.className("proxima")).click();
	}
	
	public void clicarNoConteudoAnterior() throws InterruptedException{
		esperaCarregar(1);
		exibiuBoxDoRioShow().findElement(By.className("nav-container")).findElement(By.className("anterior")).click();
	}
	
	public boolean exibiuTituloParaCadaUmDosConteudos() throws InterruptedException {
		for(int i=1; i< listaDeConteudosDoRioShow().size(); i++){
			if(i < listaDeConteudosDoRioShow().size() - Integer.parseInt("1")){
				if(listaDeConteudosDoRioShow().get(i).findElement(By.className("sobre")).findElement(By.tagName("em")).getAttribute("innerHTML").isEmpty()
						&& !(listaDeConteudosDoRioShow().get(i).findElement(By.className("sobre")).findElement(By.tagName("a")).isDisplayed())){
					return false;
				}
				clicarNoProximoConteudo();
			}
		}
		return true;
	}
	
	public boolean exibiuTituloParaCadaUmDosConteudosComNoMaximo90Caracteres() throws InterruptedException {
		for(int i=0; i< listaDeConteudosDoRioShow().size(); i++){
			if(i < listaDeConteudosDoRioShow().size() - Integer.parseInt("2")){
				if(listaDeConteudosDoRioShow().get(i).findElement(By.className("sobre")).findElement(By.className("materia")).findElement(By.tagName("a")).getAttribute("innerHTML").length() >= Integer.parseInt("93")){
					return false;
				}
				clicarNoConteudoAnterior();
			}
		}
		return true;
	}
	
	public boolean exibiuDescricaoParaCadaUmDosConteudos() throws InterruptedException {
		for(int i=0; i< listaDeConteudosDoRioShow().size(); i++){
			if(i < listaDeConteudosDoRioShow().size() - Integer.parseInt("2")){
				if(listaDeConteudosDoRioShow().get(i).findElement(By.className("sobre")).findElement(By.className("materia")).getAttribute("innerHTML").isEmpty()
						&& !(listaDeConteudosDoRioShow().get(i).findElement(By.className("sobre")).findElement(By.className("materia")).findElement(By.tagName("a")).isDisplayed())){
					return false;
				}
				clicarNoProximoConteudo();
			}
		}
		return true;
	}
}