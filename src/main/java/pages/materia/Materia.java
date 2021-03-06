package pages.materia;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.compartilhamento.CompartilhamentoInlinePadrao;

import br.com.infoglobo.pages.Navegador;

public class Materia extends CompartilhamentoInlinePadrao {
	
	public Materia() throws Exception {
		super();
	}
	
	public Materia(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement getBoxRow(){
		return getDriver().findElement(By.className("row"));
	}
	
	public WebElement getBreadcrumb(){
		return getDriver().findElement(By.className("sub-editoria"));
	}
	
	public boolean exibiuTituloDamateria(){
		return !acessaClasseHeadMateria().findElement(By.tagName("h1")).getText().isEmpty();
	}
	
	public WebElement acessaDescricaoDaMateria(){
		return acessaClasseHeadMateria().findElement(By.tagName("h2"));
	}
	
	public boolean exibiuDescricaoDaMateria(){
		return !acessaDescricaoDaMateria().getText().isEmpty();
	}
	
	public boolean exibiuAutorDaMateria(){
		return !acessaClasseHeadMateria().findElement(By.className("autor")).getText().isEmpty();
	}
	
	public boolean exibiuDataDaMateria(){
		return !acessaClasseHeadMateria().findElement(By.className("data-cadastro")).findElement(By.tagName("time")).getText().isEmpty();
	}
	
	public boolean exibiuDataDeAtualizacaoDamateria(){
		return !acessaClasseHeadMateria().findElement(By.className("data-atualizacao")).findElement(By.tagName("time")).getText().isEmpty();
	}
	
	public boolean exibiuTestoDaMateria(){
		return !acessaCorpoDamateria().findElement(By.tagName("p")).getText().isEmpty();
	}
	
	public List<WebElement> getMateriaLista(){
		return acessaCorpoDamateria().findElements(By.tagName("p"));
	}
	
	public WebElement exibiuBoxDeLinksPatrocinados(){
		return getDriver().findElement(By.className("publicidade-materia"));
	}
	
	public boolean exibiuConteudoDeLinksPatrocinados(){
		return getDriver().findElement(By.className("publicidade-materia")).findElement(By.id("sponsored-links")).isDisplayed();
	}
}