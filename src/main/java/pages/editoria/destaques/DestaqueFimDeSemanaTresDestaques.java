package pages.editoria.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaqueFimDeSemanaTresDestaques extends AceitacaoAbstractTest {
	
	//Dois destaques grandes com foto: 220x280
	//Box Fixo Azul com matéria título, descrição e sem foto 
	
	public DestaqueFimDeSemanaTresDestaques() throws Exception{
		super();
	}
	
	public DestaqueFimDeSemanaTresDestaques(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuDestaqueFimDeSemana() {
		return getDriver().findElement(By.className("manchetes-capa"));
	}

	public List<WebElement> listaTotalDeBoxDeMaterias() {
		return getDriver().findElement(By.className("base")).findElements(By.tagName("li"));
	}

	public boolean exibiuTresBoxDeMaterias() {
		return listaTotalDeBoxDeMaterias().size() == Integer.parseInt("3");
	}

	public boolean exibiuEditoriaParaAsMateriasDoPrimeiroBox() {
		 for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuLinkNaEditoriaDasMateriasDoPrimeiroBox() {
		 for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			 if(!listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuLinkValidoNaEditoriaDasMateriasDoPrimeiroBox() {
		 for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuTituloParaAsMateriasDoPrimeiroBox() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("p")).getText().isEmpty()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuTituloComLinkNasMateriasDoPrimeiroBox() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			 if(!listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuTituloComLinkValidoNasMateriasDoPrimeiroBox() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				 return false;
			 }
		 }
		 return true;
	}
	
	public boolean exibiuTituloParaAsMateriasDoPrimeiroBoxComNoMaximo68Caracteres() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("p")).getText().length() > Integer.parseInt("68")){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuImagemParaAsMateriasDoPrimeiroBox() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("src").isEmpty()){
				 return false;
			}
			
		 }
		 return true;
	}
	
	public boolean exibiuImagemDoPrimeiroBoxComWidhtCorreto() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			if(!listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("width").equals("281")){
				 return false;
			}
		}
		 return true;
	}
	
	public boolean exibiuImagemDoPrimeiroBoxComHeightCorreto() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size()-1; i++){
			if(!listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("height").equals("189")){
				 return false;
			 }
		 }
		 return true;
	}
	
	public List<WebElement> listaTotalDeWebChamadasDoPrimeiroDestaque() {
		return listaTotalDeBoxDeMaterias().get(0).findElements(By.className("mais"));
	}
	
	public List<WebElement> listaTotalDeWebChamadasDoSegundoDestaque() {
		return listaTotalDeBoxDeMaterias().get(0).findElements(By.className("mais"));
	}
	
	public boolean exibiuUmaListaDeWebChamadasParaCadaUmDosDestaques() {
		return listaTotalDeWebChamadasDoPrimeiroDestaque().size() > Integer.parseInt("0") && listaTotalDeWebChamadasDoSegundoDestaque().size() > Integer.parseInt("0");
	}
	
	public boolean exibiuUmTituloParaCadaWebChamadasDosDestaques() {
		//verifica o primeiro destaque
		for(int i=0; i<listaTotalDeWebChamadasDoSegundoDestaque().size(); i++){
			if(listaTotalDeWebChamadasDoSegundoDestaque().get(i).getText().isEmpty()){
				return false;
			}
		}
		
		//verifica o segundo destaque
		for(int y=0; y<listaTotalDeWebChamadasDoSegundoDestaque().size(); y++){
			if(listaTotalDeWebChamadasDoSegundoDestaque().get(y).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkParaCadaWebChamadasDosDestaques() {
		//verifica o primeiro destaque
		for(int i=0; i<listaTotalDeWebChamadasDoSegundoDestaque().size(); i++){
			if(listaTotalDeWebChamadasDoSegundoDestaque().get(i).getAttribute("href").isEmpty()){
				return false;
			}
		}
		
		//verifica o segundo destaque
		for(int y=0; y<listaTotalDeWebChamadasDoSegundoDestaque().size(); y++){
			if(listaTotalDeWebChamadasDoSegundoDestaque().get(y).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	//Inicio do segundo box (box azul)
	
	public WebElement exibiuSegundoBoxDoDestaque() {
		return exibiuDestaqueFimDeSemana().findElement(By.className("base")).findElement(By.className("fixo"));
	}

	public boolean exibiuEditoriaParaSegundoBoxDoDestaque() {
		return !exibiuSegundoBoxDoDestaque().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuUmLinkNaEditoriaDoSegundoBoxDoDestaque() {
		return exibiuSegundoBoxDoDestaque().findElement(By.tagName("h3")).findElement(By.tagName("span")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNaEditoriaDoSegundoBoxDoDestaque() {
		return !exibiuSegundoBoxDoDestaque().findElement(By.tagName("h3")).findElement(By.tagName("span")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloParaSegundoBoxDoDestaque() {
		return !exibiuSegundoBoxDoDestaque().findElement(By.tagName("p")).getText().isEmpty();
	}

	public boolean exibiuUmLinkNoTituloDoSegundoBoxDoDestaque() {
		return exibiuSegundoBoxDoDestaque().findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoTituloDoSegundoBoxDoDestaque() {
		return !exibiuSegundoBoxDoDestaque().findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public boolean exibiuTituloParaSegundoBoxDoDestaqueComNoMaximo53Caracteres() {
		return exibiuSegundoBoxDoDestaque().findElement(By.tagName("p")).getText().length() <= Integer.parseInt("53");
	}
	
	public boolean exibiuDescricaoDoSegundoBox() {
		return !exibiuSegundoBoxDoDestaque().findElement(By.className("sub-titulo")).getText().isEmpty();
	}

	public boolean exibiuTituloParaSegundoBoxDoDestaqueComNoMaximo60Caracteres() {
		return exibiuSegundoBoxDoDestaque().findElement(By.className("sub-titulo")).getText().length() <= Integer.parseInt("63");
	}

}
