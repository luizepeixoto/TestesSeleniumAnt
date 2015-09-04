package pages.editoria.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDestaques;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class DestaqueDuasColunasUrgente extends AceitacaoAbstractTest {
	
	public DestaqueDuasColunasUrgente() throws Exception{
		super();
	}
	
	public WebElement exibiuDestaque2Colunas() {
		return getDriver().findElement(By.className("destaques-2-colunas"));
	}
	
	public WebElement exibiuDestaquePrincipal() {
		return exibiuDestaque2Colunas().findElement(By.className("principal"));
	}
	
	public WebElement exibiuTituloUrgente() {
		return exibiuDestaquePrincipal().findElement(By.tagName("h2")).findElement(By.className("urgente"));
	}
	
	public boolean exibiuTextoUrgente() {
		return exibiuTituloUrgente().getText().equals("URGENTE");
	}

	public boolean exibiuTituloDoDestaque() {
		return !exibiuDestaquePrincipal().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuSubtituloDoDestaque() {
		return !exibiuDestaquePrincipal().findElement(By.tagName("span")).getText().isEmpty();
	}
	
	public boolean exibiuBalaoDeComentarios() {
		return exibiuDestaquePrincipal().findElement(By.xpath("//div[1]/p/a[@class='comments']")).isDisplayed();
	}
	
	public boolean exibiuTotalDeComentarios() {
		return !exibiuDestaquePrincipal().findElement(By.xpath("//div[1]/p/a[@class='comments']")).getText().isEmpty();
	}
	
	public boolean exibiuImagemDoDestaque() {
		return exibiuDestaquePrincipal().findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuCropCorretoParaAImagemDoDestaque() {
		String imagemDoDestaque = exibiuDestaquePrincipal().findElement(By.tagName("img")).getAttribute("src");
		return imagemDoDestaque.contains(CropsDestaques.duasColunasFotoDestaquePrincial.cropProporcional());
	}
	
	public boolean exibiuClasseAnimadoScaleNaImagem() {
		return exibiuDestaquePrincipal().findElement(By.className("animado-scale")).findElement(By.tagName("img")).isDisplayed();
	}
	
	public String exibiuImagemComWidthDe940Px() {
		return exibiuDestaquePrincipal().findElement(By.tagName("img")).getAttribute("width");
	}
	
	public String exibiuImagemComHeightDe410Px() {
		return exibiuDestaquePrincipal().findElement(By.tagName("img")).getAttribute("height");
	}
	
	public List<WebElement> listaDeWebChamadas(){
		return exibiuDestaque2Colunas().findElement(By.className("lista-chamadas")).findElements(By.tagName("li")); 
	}
	
	public boolean exibiuWebChamadasAposDestaque() {
		return listaDeWebChamadas().size() > 0;
	}

	public boolean exibiuTextoParaCadaUmaDasWebChamadas() {
		for(int i=0; i< listaDeWebChamadas().size(); i++){
			if(listaDeWebChamadas().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				imprimirMensagemDeErro("título da web chamadas", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkParaCadaUmaDasWebChamadas() {
		for(int i=0; i< listaDeWebChamadas().size(); i++){
			if(!listaDeWebChamadas().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				imprimirMensagemDeErro("link na web chamada", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoParaCadaUmaDasWebChamadas() {
		for(int i=0; i< listaDeWebChamadas().size(); i++){
			if(listaDeWebChamadas().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				imprimirMensagemDeErro("link válido na web chamada", i);
				return false;
			}
		}
		return true;
	}
	
	public List<WebElement> listaDeChamadasSecundarias() {
		return exibiuDestaque2Colunas().findElement(By.className("lista-destaques")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaListaDeChamadasSecundarias() {
		return listaDeChamadasSecundarias().size() > 0;
	}

	public boolean exibiuUmaImagemParaAsChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			if(!listaDeChamadasSecundarias().get(i).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("imagem", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuCropCorretoParaAsImagemDasChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			String urlDaImagemAtual = listaDeChamadasSecundarias().get(i).findElement(By.tagName("img")).getAttribute("src");
			if(!urlDaImagemAtual.contains(CropsDestaques.duasColunasFotoDestaqueSecundario.cropProporcional())){
				imprimirMensagemDeErro("crop correto", i);
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuAClasseAnimadoOpacityParaAsImagensDaChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			if(!listaDeChamadasSecundarias().get(i).findElement(By.className("animado-opacity")).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("classe animado opacity", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuWidthCorretoParaAsImagensDaChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			String widthDaImagemAtual = listaDeChamadasSecundarias().get(i).findElement(By.tagName("img")).getAttribute("width");
			if(!widthDaImagemAtual.equals(CropsDestaques.duasColunasFotoDestaqueSecundario.getWidth())){
				imprimirMensagemDeErroDeImagem(i, widthDaImagemAtual, CropsDestaques.duasColunasFotoDestaqueSecundario.getWidth());
				return false;
			}
		}
		return true;
	}

	public boolean exibiuHeightCorretoParaAsImagensDaChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			String heightDaImagemAtual = listaDeChamadasSecundarias().get(i).findElement(By.tagName("img")).getAttribute("height");
			if(!heightDaImagemAtual.equals(CropsDestaques.duasColunasFotoDestaqueSecundario.getHeight())){
				imprimirMensagemDeErroDeImagem(i, heightDaImagemAtual, CropsDestaques.duasColunasFotoDestaqueSecundario.getHeight());
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmTitutoParaAsChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				imprimirMensagemDeErro("titulo da chamada secundária", i);
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOTitutoDasChamadasSecundariasComNoMaximo75Caracteres() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.tagName("h3")).getText().length() >= 75){
				imprimirMensagemDeErro("titulo da chamada secundária com o máximo de caracteres", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNoTitutoDasChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			if(!listaDeChamadasSecundarias().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				imprimirMensagemDeErro("o link do titulo da chamada secundária", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNoTitutoDasChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				imprimirMensagemDeErro("o link do titulo da chamada secundária inválido", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmaDescricaoParaAsChamadasSecundarias() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				imprimirMensagemDeErro("descrição", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoDasChamadasSecundariasComNoMaximo75Caracteres() {
		for(int i=0; i< listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.tagName("span")).getText().length() >= 75){
				imprimirMensagemDeErro("descrição da chamada secundária com o máximo de caracteres", i);
				return false;
			}
		}
		return true;
	}
	
	public List<WebElement> listaDeBoxDeOpiniao() {
		return exibiuDestaque2Colunas().findElement(By.className("opiniao-lista")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaListaDeOpinioes() {
		return listaDeBoxDeOpiniao().size() > 0;
	}

	public boolean exibiuUmaImagemParaCadaUmDosBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(!listaDeBoxDeOpiniao().get(i).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("imagem", i);
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOCropCorretoParaAsImagemDoBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			String urlDaImagemAtual = listaDeBoxDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("src");
			if(!urlDaImagemAtual.equals(CropsDestaques.duasColunasFotoBoxDeOpiniao.cropProporcional())){
				imprimirMensagemDeErro("Crop correto", i);
				return false;
			}
		}	
		return true;
	}

	public boolean exibiuUmLinkNaImagemDeCadaUmDosBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(!listaDeBoxDeOpiniao().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("link na imagem do box de opinão", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoNaImagemDeCadaUmDosBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(listaDeBoxDeOpiniao().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				imprimirMensagemDeErro("link válido na imagem do box de opinão", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuWidthCorretoParaAsImagensDoBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			String widthDaImagemAtual = listaDeBoxDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("width");
			if(!widthDaImagemAtual.equals(CropsDestaques.duasColunasFotoBoxDeOpiniao.getWidth())){
				imprimirMensagemDeErro("crop incorreto", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuHeightCorretoParaAsImagensDoBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			String heightDaImagemAtual = listaDeBoxDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("height");
			if(!heightDaImagemAtual.equals(CropsDestaques.duasColunasFotoBoxDeOpiniao.getHeight())){
				imprimirMensagemDeErro("crop incorreto", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmAntiTitutoParaCadaUmDosBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(listaDeBoxDeOpiniao().get(i).findElement(By.tagName("h4")).getText().isEmpty()){
				imprimirMensagemDeErro("antititulo do box de opinião", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOAutorEmCadaUmDosBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(listaDeBoxDeOpiniao().get(i).findElement(By.tagName("h5")).getText().isEmpty()){
				imprimirMensagemDeErro("autor do box de opinião", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmaDescricaoParaCadaUmDosBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(listaDeBoxDeOpiniao().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				imprimirMensagemDeErro("descrição do box de opinião", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAsDescricoesDosBoxDeOpiniaoComNoMaximo65Caracteres() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(listaDeBoxDeOpiniao().get(i).findElement(By.tagName("span")).getText().length() > 65){
				imprimirMensagemDeErro("tamanho correto da descrição do box de opinião", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNaDescricaoDoBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(!listaDeBoxDeOpiniao().get(i).findElement(By.tagName("span")).findElement(By.tagName("a")).isDisplayed()){
				imprimirMensagemDeErro("link na descrição do box de opinião", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNaDescricaoDoBoxDeOpiniao() {
		for(int i=0; i< listaDeBoxDeOpiniao().size(); i++){
			if(listaDeBoxDeOpiniao().get(i).findElement(By.tagName("span")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				imprimirMensagemDeErro("link válido na descrição do box de opinião", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAutorNaChamadaPrincipal() {
		return !exibiuDestaque2Colunas().findElement(By.xpath("//div[@class='principal']/div/p/b")).getText().isEmpty();
	}

	public boolean exibiuAutorNaChamadaSecundaria() {
		return !exibiuDestaque2Colunas().findElement(By.xpath("//div[@class='large-16 columns']/div/div/ul[1]/li[1]/span/b")).getText().isEmpty();
	}
	
	
}
