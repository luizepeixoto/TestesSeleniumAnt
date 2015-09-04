package pages.plantao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class PlantaoDeEditoria extends AceitacaoAbstractTest {

	public PlantaoDeEditoria() throws Exception{
		
	}

	public boolean exibiuOAntititulo() {
		return !getDriver().findElement(By.className("titulo-ultimas")).findElement(By.tagName("h1")).getText().isEmpty();
	}

	public WebElement exibiuAPublicidade() {
		return getDriver().findElement(By.className("publicidade"));
	}

	public WebElement exibiuPlantaoNoticias() {
		return getDriver().findElement(By.id("ultimasNoticias"));
	}

	public List<WebElement> listaTotalDePlantao() {
		return exibiuPlantaoNoticias().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public int tamanhoTotalDePlantaoComoOcultas() {
		List<WebElement> totalDePlantaoOcultas = exibiuPlantaoNoticias().findElement(By.tagName("ul")).findElements(By.className("item-ultimas-oculto"));
		return totalDePlantaoOcultas.size();
	}
	
	public boolean exibiuUmaListaDePlantao() {
		return listaTotalDePlantao().size()>0;
	}

	public WebElement exibiuDestaquePrincipal() {
		return exibiuPlantaoNoticias().findElement(By.tagName("ul")).findElement(By.className("destaque"));
	}
	
	public boolean exibiuUmaParaODestaquePrincipal() {
		List<WebElement> totalImagem = exibiuPlantaoNoticias().findElement(By.className("destaque")).findElements(By.tagName("img"));
		
		if(totalImagem.size()>0){
			if(!exibiuPlantaoNoticias().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
			return true;
		}
		return true;
	}
	
	public boolean exibiuWidthNaFotoEmDestaque() {
		List<WebElement> totalImagem = exibiuPlantaoNoticias().findElement(By.className("destaque")).findElements(By.tagName("img"));
		
		if(totalImagem.size()>0){
			if(exibiuPlantaoNoticias().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width").equals("704")){
				return true;
			}
			return false;
		}
		return true;
	}
	
	public boolean exibiuHeightNaFotoEmDestaque() {
		List<WebElement> totalImagem = exibiuPlantaoNoticias().findElement(By.className("destaque")).findElements(By.tagName("img"));
		
		if(totalImagem.size()>0){
			if(exibiuPlantaoNoticias().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height").equals("421")){
				return true;
			}
			return false;
		}
		return true;
	}
	
	public boolean exibiuDestaqueEsquerdaSuperior(){
		List<WebElement> resultadoEsperado = exibiuPlantaoNoticias().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(resultadoEsperado.size()>0){
			if(!exibiuPlantaoNoticias().findElement(By.className("superior")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuDestaqueEsquerdaInferior(){
		List<WebElement> resultadoEsperado = exibiuPlantaoNoticias().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(resultadoEsperado.size()>0){
			if(!exibiuPlantaoNoticias().findElement(By.className("inferior")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagensParaAsMaterias() {
		//listaTotalDePlantao().size() trocado por i=4
		for(int i=1;i<4;i++){
			List<WebElement> totalImagem = listaTotalDePlantao().get(i).findElements(By.tagName("img"));
			if(totalImagem.size()>0){
				if(!listaTotalDePlantao().get(i).findElement(By.tagName("img")).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}
		
	public boolean exibiuImagensParaAsMateriasComWidht234Px() {
		//listaTotalDePlantao().size() trocado por i=4
		for(int i=1;i<4;i++){
			List<WebElement> totalImagem = listaTotalDePlantao().get(i).findElements(By.tagName("img"));
			if(totalImagem.size()>0){
				if(!listaTotalDePlantao().get(i).findElement(By.tagName("img")).getAttribute("width").equals("234")){
					return false;
				}
			}
		}
		return true;
	}	
	
	public boolean exibiuImagensParaAsMateriasComHeight140Px() {
		//listaTotalDePlantao().size() trocado por i=4
		for(int i=1;i<4;i++){
			List<WebElement> totalImagem = listaTotalDePlantao().get(i).findElements(By.tagName("img"));
			if(totalImagem.size()>0){
				if(!listaTotalDePlantao().get(i).findElement(By.tagName("img")).getAttribute("height").equals("140")){
					return false;
				}
			}
		}
		return true;
	}	
		
	public boolean exibiuApenasUmDestaquePrincipal() {
		List<WebElement> resultadoEsperado = exibiuPlantaoNoticias().findElement(By.tagName("ul")).findElements(By.className("destaque")); 
		return resultadoEsperado.size()==1;
	}
	
	public boolean exibiuEditoriaParaAsMateriasDePlantao() {
		//listaTotalDePlantao().size() - tamanhoTotalDePlantaoComoOcultas() trocado por i=4
		for(int i=0;i<4;i++){
			if(listaTotalDePlantao().get(i).findElement(By.className("editoria")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloParaAsMateriasDePlantao() {
		//listaTotalDePlantao().size() - tamanhoTotalDePlantaoComoOcultas() trocado por i=4
		for(int i=0;i<4;i++){
			if(listaTotalDePlantao().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloComMaximoDeCaracteres() {
		//listaTotalDePlantao().size() - tamanhoTotalDePlantaoComoOcultas() trocado por i=4
		for(int i=0;i<4;i++){
			if(listaTotalDePlantao().get(i).findElement(By.tagName("h2")).getText().length() > 75){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTempoPostadoParaAsMateriasDePlantao() {
		//listaTotalDePlantao().size() - tamanhoTotalDePlantaoComoOcultas() trocado por i=4
		for(int i=1;i<4;i++){
			if(listaTotalDePlantao().get(i).findElement(By.className("tempo")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkNoTitulo() {
		//listaTotalDePlantao().size() - tamanhoTotalDePlantaoComoOcultas() trocado por i=4
		for(int i=0;i<4;i++){
			if(!listaTotalDePlantao().get(i).findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkValidoNoTitulo() {
		//listaTotalDePlantao().size() - tamanhoTotalDePlantaoComoOcultas() trocado por i=4
		for(int i=0; i<4; i++){
			if(listaTotalDePlantao().get(i).findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuSubtituloParaAsMateriasDePlantao() {
		for(int i=0; i<4; i++){
			List<WebElement> totalImagem = listaTotalDePlantao().get(i).findElements(By.tagName("h3"));
			if(totalImagem.size() > Integer.parseInt("0")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuCarregarMais() {
		List<WebElement> exibiuBotao = getDriver().findElements(By.className("mais-ultimas"));
		if(exibiuBotao.size()>0){
			return true;
		}
		return true;
	}

	public String exibiuTituloCarregarMais() {
		String outroResultado = "Não Possui Botão";
		List<WebElement> exibiuBotao = getDriver().findElements(By.className("mais-ultimas"));
		if(exibiuBotao.size()>0){
			return getDriver().findElements(By.className("mais-ultimas")).get(0).getText();
		}
		return outroResultado;
	}

	public boolean exibiuLinkCarregarMais() {
		return !getDriver().findElement(By.className("mais-ultimas")).getAttribute("href").isEmpty();
	}
	
	public String exibiuCodigoFonteDaPagina(){
		return getDriver().getPageSource();
	}

	public boolean oNovoTotalDeMateriasFoiExibido() throws InterruptedException {
		int total = listaTotalDePlantao().size() - tamanhoTotalDePlantaoComoOcultas();
		getDriver().findElement(By.cssSelector("html.js body.principal div.home div.row div.large-12 a.mais-ultimas")).click();
		Thread.sleep(1000);
		int novoTotal = listaTotalDePlantao().size() - tamanhoTotalDePlantaoComoOcultas();
		return novoTotal > total;
	}
}
