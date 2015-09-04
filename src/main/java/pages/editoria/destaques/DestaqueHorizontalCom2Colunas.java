package pages.editoria.destaques;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDestaques;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class DestaqueHorizontalCom2Colunas extends AceitacaoAbstractTest {
	
	public DestaqueHorizontalCom2Colunas() throws Exception{
		super();
	}
	
	public DestaqueHorizontalCom2Colunas(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuDestaque() {
		return getDriver().findElement(By.className("centraliza"));
	}

	public boolean exibiuEditoriaEmDestaque() {
		return !exibiuDestaque().findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuLinkEditoriaEmDestaque() {
		return exibiuDestaque().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkValido() {
		return !exibiuDestaque().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloEmDestaque() {
		return !exibiuDestaque().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuLinkNoTitulo() {
		return exibiuDestaque().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkValidoNoTitulo() {
		return !exibiuDestaque().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuDescricaoEmDestaque() {
		return !exibiuDestaque().findElement(By.className("subtitulo")).getText().isEmpty();
	}

	public boolean exibiuBalaoDeComentariosEmDestaque() {
		return !exibiuDestaque().findElement(By.className("subtitulo")).findElement(By.className("comments")).getText().isEmpty();
	}

	public boolean exibiuLinkNoBalaoDeComentarios() {
		return exibiuDestaque().findElement(By.className("subtitulo")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkValidoNoBalaoDeComentarios() {
		return !exibiuDestaque().findElement(By.className("subtitulo")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuImagemNoDestaque() {
		return exibiuDestaque().findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuImagemNoDestaqueComCropCorreto() {
		String urlDaImagemPrincipal = exibiuDestaque().findElement(By.tagName("img")).getAttribute("src");
		return urlDaImagemPrincipal.contains(CropsDestaques.duasColunasFotoDestaquePrincial.cropProporcional());
	}
	
	public boolean exibiuImagemComLinkAnimado() {
		return exibiuDestaque().findElement(By.className("animado-scale")).isDisplayed();
	}
	
	public String exibiuWidthDoDestaque() {
		return exibiuDestaque().findElement(By.tagName("img")).getAttribute("width");
	}

	public String exibiuHeightDoDestaque() {
		return exibiuDestaque().findElement(By.tagName("img")).getAttribute("height");
	}

	public WebElement exibiuClasseListaDestaques() {
		return getDriver().findElement(By.className("destaques-copa")).findElement(By.className("lista-destaques"));
	}
	
	/*Início da validação da lista de matérias secundárias*/
	
	public List<WebElement> listaComTodosOsDestaquesSecundarios() {
		return exibiuClasseListaDestaques().findElements(By.tagName("li"));
	}
	
	
	public boolean exibiuUmaListaDeMateriasSecundarias() {
		return listaComTodosOsDestaquesSecundarios().size() > 0;
	}
	
	public int totalDeMateriasSecundarias() {
		return listaComTodosOsDestaquesSecundarios().size();
	}
	
	public boolean exibiuImagemParaAsMateriasSecundarias() {
		for(int i=0; i < totalDeMateriasSecundarias(); i++){
			if(!listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("imagem para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuImagemParaAsMateriasSecundariasComAClasseOpacity() {
		for(int i=0; i < totalDeMateriasSecundarias(); i++){
			if(!listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("a")).getAttribute("class").contains("animado-opacity")){
				imprimirMensagemDeErro("imagem sem animação para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuCropCorretoParaAsImagensDasMateriasSecundarias() {
		for(int i=0; i<listaComTodosOsDestaquesSecundarios().size(); i++){
			
			String urlFotoAtual = listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("img")).getAttribute("src");
			
			if(!urlFotoAtual.contains(CropsDestaques.duasColunasFotoDestaqueSecundario.cropProporcional())){
				imprimirMensagemDeErro("crop correto", i);
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuWidthCorretoParaMateriasSecundarias() {
		for(int i=0;i<listaComTodosOsDestaquesSecundarios().size();i++){
			String widthDaFotoAtual = listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("img")).getAttribute("width");
			
			if(!widthDaFotoAtual.equals(CropsDestaques.duasColunasFotoDestaqueSecundario.getWidth())){
				imprimirMensagemDeErroDeImagem(i, widthDaFotoAtual, CropsDestaques.duasColunasFotoDestaqueSecundario.getWidth());
				return false;
			}
		}
		return true;
	}

	public boolean exibiuHeightCorretoParaMateriasSecundarias() {
		for(int i=0; i < listaComTodosOsDestaquesSecundarios().size(); i++){
			String heightDaFotoAtual = listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("img")).getAttribute("height");
			
			if(!heightDaFotoAtual.equals(CropsDestaques.duasColunasFotoDestaqueSecundario.getHeight())){
				imprimirMensagemDeErroDeImagem(i, heightDaFotoAtual, CropsDestaques.duasColunasFotoDestaqueSecundario.getHeight());
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmTituloParaAsMateriasSecundarias() {
		for(int i=0; i < listaComTodosOsDestaquesSecundarios().size(); i++){
			if(listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				imprimirMensagemDeErro("titulo vazio para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNoTituloDasMateriasSecundarias() {
		for(int i=0; i < listaComTodosOsDestaquesSecundarios().size(); i++){
			if(!listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				imprimirMensagemDeErro("link titulo para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNoTituloParaDasMateriasSecundarias() {
		for(int i=0; i < listaComTodosOsDestaquesSecundarios().size(); i++){
			if(listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				imprimirMensagemDeErro("titulo com link para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmaDescricaoParaAsMateriasSecundarias() {
		for(int i=0; i < listaComTodosOsDestaquesSecundarios().size(); i++){
			if(listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				imprimirMensagemDeErro("descrição da matéria para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuBalaoDeComentariosParaAsMateriasSecundarias() {
		for(int i=0; i < listaComTodosOsDestaquesSecundarios().size(); i++){
			if(!listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("span")).findElement(By.className("comments")).isDisplayed()){
				imprimirMensagemDeErro("balão de comentários para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNoBalaoDeComentariosParaAsMateriasSecundarias() {
		for(int i=0; i < listaComTodosOsDestaquesSecundarios().size(); i++){
			if(listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("span")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				imprimirMensagemDeErro("link no balão de comentários para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNoBalaoDeComentariosDasMateriasSecundarias() {
		for(int i=0; i < listaComTodosOsDestaquesSecundarios().size(); i++){
			if(listaComTodosOsDestaquesSecundarios().get(i).findElement(By.tagName("span")).findElement(By.tagName("a")).getText().isEmpty()){
				imprimirMensagemDeErro("link valido no balão de comentários para o destaque secundário", i);
				return false;
			}
		}
		return true;
	}
	
	/*Início da validação da lista de box de opinião*/
	
	public WebElement exibiuBoxOpiniao() {
		return getDriver().findElement(By.className("destaques-copa")).findElement(By.className("opiniao-copa"));
	}
	
	public List<WebElement> listaOpinioes() {
		return exibiuBoxOpiniao().findElements(By.tagName("li"));
	}

	public boolean exibiuListaDeOpiniao() {
		return listaOpinioes().size()>0;
	}

	public boolean exibiuFotoParaAsOpinioes() {
		for(int i=0; i < listaOpinioes().size(); i++){
			if(!listaOpinioes().get(i).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErro("foto para opinião", i);
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuFotoComCropCorretoParaAsOpinioes() {
		for(int i=0; i < listaOpinioes().size(); i++){
			String urlDaFotoAtual = listaOpinioes().get(i).findElement(By.tagName("img")).getAttribute("src");
			if(!urlDaFotoAtual.contains(CropsDestaques.duasColunasFotoBoxDeOpiniao.cropProporcional())){
				imprimirMensagemDeErro("crop incorreto", i);
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloParaOpinioes() {
		for(int i=0;i<listaOpinioes().size();i++){
			List<WebElement> possuiTituloNestaPosicao = listaOpinioes().get(i).findElements(By.tagName("h4"));
			if(possuiTituloNestaPosicao.size()>0){
				if(listaOpinioes().get(i).findElement(By.tagName("h5")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuAutorParaOpinioes() {
		for(int i=0;i<listaOpinioes().size();i++){
			List<WebElement> possuiTituloNestaPosicao = listaOpinioes().get(i).findElements(By.tagName("h5"));
			if(possuiTituloNestaPosicao.size()>0){
				if(listaOpinioes().get(i).findElement(By.tagName("h5")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuDescricaoParaOpinioes() {
		for(int i=0;i<listaOpinioes().size();i++){
			if(listaOpinioes().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoParaOpinioesComLink() {
		for(int i=0;i<listaOpinioes().size();i++){
			if(!listaOpinioes().get(i).findElement(By.tagName("span")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoParaOpinioesComUmLinkValido() {
		for(int i=0;i<listaOpinioes().size();i++){
			if(listaOpinioes().get(i).findElement(By.tagName("span")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoComMaximoDe55Caracteres() {
		for(int i=0;i<listaOpinioes().size();i++){
			if(listaOpinioes().get(i).findElement(By.tagName("span")).findElement(By.tagName("a")).getText().length()>55){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAutorNaChamadaPrincipal() {
		return !exibiuDestaque().findElement(By.xpath("//div[@class='large-16 columns']/p/b")).getText().isEmpty();
	}

	public boolean exibiuAutorNaChamadaSecundaria() {
		return !exibiuDestaque().findElement(By.xpath("//div[@class='large-16 columns']/div/div/ul[1]/li[3]/span/b")).getText().isEmpty();
	}

//	***** CHAMADA COM FOTO GRANDE *****
	
	public WebElement chamadaComFotoGrande(){
		return getDriver().findElement(By.className("box2ColDuplo"));
	}
	
	public boolean exibiuChamadaComFotoGrande() {
		return chamadaComFotoGrande().isDisplayed();
	}

	public boolean exibiuTituloDaChamadaComFotoGrande() {
		return !chamadaComFotoGrande().findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean exibiuAutorDaChamadaComFotoGrande() {
		return !chamadaComFotoGrande().findElement(By.xpath("//div[@class='subtitulo']/span/b")).getText().isEmpty();
	}

	public boolean exibiuSubtituloDaChamadaComFotoGrande() {
		return !chamadaComFotoGrande().findElement(By.xpath("//div[@class='subtitulo']/span")).getText().isEmpty();
	}

	public boolean exibiuUmLinkValidoNoTituloDaChamadaComFotoGrande() {
		return !chamadaComFotoGrande().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuImagemDaChamadaComFotoGrande() {
		return chamadaComFotoGrande().findElement(By.className("link animado-opacity")).findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuUmLinkValidoNaImagemDaChamadaComFotoGrande() {
		return !chamadaComFotoGrande().findElement(By.className("link animado-opacity")).getAttribute("href").isEmpty();
	}

	public boolean naoExibiuImagemDaChamadaComFotoGrande() {
		try {
			getDriver().findElement(By.xpath("//div[@class='row materia-principal-2col']")).findElement(By.xpath("div[3]")).findElement(By.xpath("a"));
			return false;
		} catch (Exception e) {
			return true;
		}
		
	}

//	***** CHAMADA COM FOTO PEQUENA *****
	
	public WebElement chamadaComFotoPequena(){
		return getDriver().findElement(By.className("box2Col"));
	}
	
	public boolean exibiuChamadaComFotoPequena() {
		return chamadaComFotoPequena().isDisplayed();
	}

	public boolean exibiuTituloDaChamadaComFotoPequena() {
		return !chamadaComFotoPequena().findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean exibiuAutorDaChamadaComFotoPequena() {
		return !chamadaComFotoPequena().findElement(By.xpath("//div[@class='subtitulo']/span/b")).getText().isEmpty();
	}

	public boolean exibiuSubtituloDaChamadaComFotoPequena() {
		return !chamadaComFotoPequena().findElement(By.xpath("//div[@class='subtitulo']/span")).getText().isEmpty();
	}

	public boolean exibiuUmLinkValidoNoTituloDaChamadaComFotoPequena() {
		return !chamadaComFotoPequena().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuImagemDaChamadaComFotoPequena() {
		return chamadaComFotoPequena().findElement(By.xpath("//div[@class='subtitulo']/a/img")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNaImagemDaChamadaComFotoPequena() {
		return !chamadaComFotoPequena().findElement(By.xpath("//div[@class='subtitulo']/a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuImagemDaChamadaComFotoPequenaComAClasseOpacity() {
		return chamadaComFotoPequena().findElement(By.xpath("//div[@class='subtitulo']/a")).getAttribute("class").contains("link animado-opacity");
	}

	public boolean naoExibiuImagemDaChamadaComFotoPequena() {
		try {
			getDriver().findElement(By.xpath("//div[@class='row materia-principal-2col']")).findElement(By.xpath("//div[6]/div[@class='subtitulo']/a"));
			return false;
		} catch (Exception e) {
			return true;
		}
		
	}

	
}
