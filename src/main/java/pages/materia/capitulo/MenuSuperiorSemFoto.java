package pages.materia.capitulo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuSuperiorSemFoto extends AceitacaoAbstractTest {
	
	public MenuSuperiorSemFoto() throws Exception {
		super();
	}
	
	public MenuSuperiorSemFoto(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuMateriaEmCapitulos() {
		return getDriver().findElement(By.className("materia-capitulos"));
	}
	
	public WebElement acessaClasseRowDoAntititulo() {
		return exibiuMateriaEmCapitulos().findElement(By.className("inicio")).findElement(By.className("row"));
	}
	
	public boolean exibiuUmAntitituloNoTopo() {
		return !acessaClasseRowDoAntititulo().findElement(By.className("preTitle")).getText().isEmpty();
	}
	
	public boolean exibiuUmAntitituloAlinhadoAoCentro() {
		return acessaClasseRowDoAntititulo().findElement(By.tagName("p")).getAttribute("class").contains("center");
	}
	
	public boolean exibiuUmAntitituloComNoMaximo50Caracteres() {
		return acessaClasseRowDoAntititulo().findElement(By.className("preTitle")).getText().length() <= Integer.parseInt("50");
	}
	
	public WebElement exibiuFotoDoCabecalho() {
		return exibiuMateriaEmCapitulos().findElement(By.className("inicio")).findElement(By.className("foto-principal-capitulo"));
	}
	
//	public WebElement exibiuFotoDoCabecalhoDaMateriaEmCapitulos() {
//		return exibiuFotoDoCabecalho().findElement(By.tagName("figure")).findElement(By.tagName("img"));
//	}
//
//	public boolean exibiuFotoDaMateriaPrincipalComWidthCorreto() {
//		String widthAtual = exibiuFotoDoCabecalhoDaMateriaEmCapitulos().getAttribute("width");
//		return Integer.parseInt(widthAtual) > Integer.parseInt("0");
//	}
//
//	public boolean exibiuFotoDaMateriaPrincipalComHeightCorreto() {
//		String heightAtual = exibiuFotoDoCabecalhoDaMateriaEmCapitulos().getAttribute("height");
//		return Integer.parseInt(heightAtual) > Integer.parseInt("0");
//	}
//
//	public boolean exibiuLegendaParaAFotoDaMateriaPrincipal() {
//		List<WebElement> possuiLegenda = exibiuFotoDoCabecalho().findElement(By.tagName("figure")).findElements(By.tagName("figcaption"));
//		return possuiLegenda.size() == Integer.parseInt("0");
//	}
	
	public WebElement exibiuClasseHeadmateria() {
		return exibiuMateriaEmCapitulos().findElement(By.className("inicio")).findElement(By.className("head-materia"));
	}
	
	public boolean exibiuTituloParaAMateriaPrincipal() {
		return !exibiuClasseHeadmateria().findElement(By.tagName("h1")).getText().isEmpty();
	}

	public boolean exibiuSubtituloParaAMateriaPrincipal() {
		return !exibiuClasseHeadmateria().findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuAutorParaAMateriaPrincipal() {
		return !exibiuClasseHeadmateria().findElement(By.className("meta")).findElement(By.className("autor")).getText().isEmpty();
	}

	public boolean exibiuDataParaAMateriaPrincipal() {
		return !exibiuClasseHeadmateria().findElement(By.className("meta")).findElement(By.className("meta-data")).findElement(By.className("data-cadastro")).getText().isEmpty();
	}

	public boolean exibiuTextoParaAMateriaPrincipal() {
		return !exibiuClasseHeadmateria().findElement(By.className("resumo-capitulos")).findElement(By.tagName("p")).getText().isEmpty();
	}

	/*Inicio da validação dos capitulos*/
	
	public List<WebElement> listaTotalDeMaterias() {
		return exibiuMateriaEmCapitulos().findElements(By.className("capituloPage"));
	}
	
	public boolean exibiuUmaListaDeDozeMaterias() {
		return listaTotalDeMaterias().size() == Integer.parseInt("12");
	}
	
	public boolean exibiuONumeroDeCadaCapitulo() {
		for(int i=0; i<listaTotalDeMaterias().size(); i++){
			if(listaTotalDeMaterias().get(i).findElement(By.className("divisao-capitulos")).findElement(By.className("base-cap")).findElement(By.className("number")).getAttribute("innerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuONumeroCorretoParaCadaCapitulo() {
		for(int i=0; i<listaTotalDeMaterias().size(); i++){
			if(! listaTotalDeMaterias().get(i).findElement(By.className("divisao-capitulos")).findElement(By.className("base-cap")).findElement(By.className("number")).getAttribute("innerHTML").equals(String.valueOf(i+1))){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmAntiTituloParaCadaCapitulo() {
		for(int i=0; i<listaTotalDeMaterias().size(); i++){
			if(listaTotalDeMaterias().get(i).findElement(By.className("divisao-capitulos")).findElement(By.className("base-cap")).findElement(By.className("ante-titulo")).getAttribute("innerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmTituloParaCadaCapitulo() {
		for(int i=0; i<listaTotalDeMaterias().size(); i++){
			if(listaTotalDeMaterias().get(i).findElement(By.className("divisao-capitulos")).findElement(By.className("titulo")).getAttribute("innerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmAutorParaCadaCapitulo() {
		for(int i=0; i<listaTotalDeMaterias().size(); i++){
			if(listaTotalDeMaterias().get(i).findElement(By.className("divisao-capitulos")).findElement(By.className("info")).findElement(By.className("autor")).getAttribute("innerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmTextoEmCadaUmDosCapitulos() {
		for(int i=0; i<listaTotalDeMaterias().size(); i++){
			if(listaTotalDeMaterias().get(i).findElement(By.className("large-16")).findElement(By.className("corpo")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	/*Início da validação do banner arroba*/
	
	public boolean exibiuBannerArroba() {
		List<WebElement> totalDeBannersArroba = getDriver().findElement(By.className("materia-capitulos")).findElements(By.className("arroba"));
		return totalDeBannersArroba.size() == Integer.parseInt("1");
	}

	public boolean exibiuBannerArrobaParaOPrimeiroCapitulo() {
		List<WebElement> totalDeBannersArrobaNoPrimeiroCapitulo = listaTotalDeMaterias().get(0).findElements(By.className("arroba"));
		return totalDeBannersArrobaNoPrimeiroCapitulo.size() == Integer.parseInt("1");
	}

	public boolean exibiuBannerArrobaParaAlgumCapitulo() {
		for(int i=1; i<listaTotalDeMaterias().size(); i++){
			List<WebElement> possuiBannerArrobaNesteCapitulo = listaTotalDeMaterias().get(i).findElements(By.className("arroba"));
			if(possuiBannerArrobaNesteCapitulo.size() > 0){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuBannerArrobaParaAMateriaPrincipal() {
		List<WebElement> totalDeBannersArrobaNoPrimeiroCapitulo = getDriver().findElement(By.className("inicio")).findElements(By.className("arroba"));
		return totalDeBannersArrobaNoPrimeiroCapitulo.size() == Integer.parseInt("0");
	}
}