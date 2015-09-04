package pages.editoria.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaqueFimDeSemanaDoisDestaques extends AceitacaoAbstractTest {
	
	public DestaqueFimDeSemanaDoisDestaques() throws Exception{
		super();
	}
	
	public DestaqueFimDeSemanaDoisDestaques(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuDestaqueFimDeSemana() {
		return getDriver().findElement(By.className("manchetes-capa"));
	}

	public WebElement exibiuPrimeiroBoxDoDestaque() {
		return exibiuDestaqueFimDeSemana().findElement(By.className("base")).findElement(By.className("duplo"));
	}

	public boolean exibiuEditoriaDoPrimeiroBoxDoDestaque() {
		return !exibiuPrimeiroBoxDoDestaque().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuLinkNaEditoriaDoPrimeiroBoxDoDestaque() {
		return exibiuPrimeiroBoxDoDestaque().findElement(By.tagName("h3")).findElement(By.tagName("span")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNaEditoriaDoPrimeiroBoxDoDestaque() {
		return !exibiuPrimeiroBoxDoDestaque().findElement(By.tagName("h3")).findElement(By.tagName("span")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloDoPrimeiroBoxDoDestaque() {
		return !exibiuPrimeiroBoxDoDestaque().findElement(By.tagName("h2")).getText().isEmpty();
	}
	
	public boolean exibiuTituloDoPrimeiroBoxDoDestaqueComNoMaximo28Caracteres() {
		return exibiuPrimeiroBoxDoDestaque().findElement(By.tagName("h2")).getText().length() <= Integer.parseInt("28");
	}

	public List<WebElement> listaTotalDeBoxDeMaterias() {
		return exibiuPrimeiroBoxDoDestaque().findElements(By.tagName("div"));
	}

	public boolean exibiuDuasMateriasDentroDoPrimeiroBox() {
		return listaTotalDeBoxDeMaterias().size() == Integer.parseInt("2");
	}

	public boolean exibiuEditoriaParaAsMateriasDoPrimeiroBox() {
		 for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.className("topico")).getText().isEmpty()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuLinkNaEditoriaDasMateriasDoPrimeiroBox() {
		 for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			 if(!listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("a")).isDisplayed()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuLinkValidoNaEditoriaDasMateriasDoPrimeiroBox() {
		 for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.className("topico")).getAttribute("href").isEmpty()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuTituloParaAsMateriasDoPrimeiroBox() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("p")).getText().isEmpty()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuTituloComLinkNasMateriasDoPrimeiroBox() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			 if(!listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed()){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuTituloComLinkValidoNasMateriasDoPrimeiroBox() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				 return false;
			 }
		 }
		 return true;
	}
	
	public boolean exibiuTituloParaAsMateriasDoPrimeiroBoxComNoMaximo60Caracteres() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			 if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("p")).getText().length() > 63){
				 return false;
			 }
		 }
		 return true;
	}

	public boolean exibiuImagemParaAsMateriasDoPrimeiroBox() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			List<WebElement> possuiFotoNaPosicao = listaTotalDeBoxDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size() > 0){
				if(listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("src").isEmpty()){
					 return false;
				 }
			}
			
		 }
		 return true;
	}
	
	public boolean exibiuImagemDoPrimeiroBoxComWidhtCorreto() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			List<WebElement> possuiFotoNaPosicao = listaTotalDeBoxDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size() > 0){
				if(!listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("width").equals("100")){
					 return false;
				 }
			}
			
		 }
		 return true;
	}
	
	public boolean exibiuImagemDoPrimeiroBoxComHeightCorreto() {
		for(int i=0; i<listaTotalDeBoxDeMaterias().size(); i++){
			List<WebElement> possuiFotoNaPosicao = listaTotalDeBoxDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size() > 0){
				if(!listaTotalDeBoxDeMaterias().get(i).findElement(By.tagName("img")).getAttribute("height").equals("100")){
					 return false;
				 }
			}
			
		 }
		 return true;
	}
	
	public int posicaoDaUltimaFoto() {
		 List<WebElement> total = exibiuPrimeiroBoxDoDestaque().findElements(By.tagName("img"));
		 return total.size()-1;
	}
	
	public boolean exibiuImagemEmDestaqueDoPrimeiroBox() {
		return exibiuPrimeiroBoxDoDestaque().findElements(By.tagName("img")).get(posicaoDaUltimaFoto()).isDisplayed();
	}
	
	public boolean exibiuImagemEmDestaqueDoPrimeiroBoxComWidthDe220Px() {
		return exibiuPrimeiroBoxDoDestaque().findElements(By.tagName("img")).get(posicaoDaUltimaFoto()).getAttribute("width").equals("281");
	}
	
	public boolean exibiuImagemEmDestaqueDoPrimeiroBoxComHeightDe280Px() {
		return exibiuPrimeiroBoxDoDestaque().findElements(By.tagName("img")).get(posicaoDaUltimaFoto()).getAttribute("height").equals("189");
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
	
	public boolean exibiuTituloParaSegundoBoxDoDestaqueComNoMaximo50Caracteres() {
		return exibiuSegundoBoxDoDestaque().findElement(By.tagName("p")).getText().length() <= Integer.parseInt("53");
	}
	
	public boolean exibiuImagemEmDestaqueDoSegundoBox() {
		return exibiuSegundoBoxDoDestaque().findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuImagemDoSegundoBoxComWidthDe209Px() {
		return exibiuSegundoBoxDoDestaque().findElement(By.tagName("img")).getAttribute("width").equals("209");
	}

	public boolean exibiuImagemEmDestaqueDoSegundoBoxComHeightDe178Px() {
		return exibiuSegundoBoxDoDestaque().findElement(By.tagName("img")).getAttribute("height").equals("178");
	}
	
	public int posicaoDaUltimaFotoDoSegundoBox() {
		 List<WebElement> total = exibiuSegundoBoxDoDestaque().findElements(By.tagName("a"));
		 return total.size()-1;
	}
	
	public boolean exibiuLinkNaImagemEmDestaqueDoSegundoBox() {
		return exibiuSegundoBoxDoDestaque().findElements(By.tagName("a")).get(posicaoDaUltimaFotoDoSegundoBox()).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNaImagemEmDestaqueDoSegundoBox() {
		return !exibiuSegundoBoxDoDestaque().findElements(By.tagName("a")).get(posicaoDaUltimaFotoDoSegundoBox()).getAttribute("href").isEmpty();
	}
}
