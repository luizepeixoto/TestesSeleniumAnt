package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapa;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ChamadaPrincipal extends AceitacaoAbstractTest {
	
	public ChamadaPrincipal() throws Exception {
		super();
	}
	
	public ChamadaPrincipal(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	//Matéria na primeira posição. Contendo:
	//	- Chamada Nenhum contendo: titulo, descrição e comentários sendo exibidos
	//	- Chamada secundária contendo: exibindo foto, descrição, autor e comentários
	//	- Duas Chamadas de opinião ou entrevista contendo: Foto, tipo do box, Autor, Descrição 
	
	public WebElement acessaChamadaPrincipal(){
		return getDriver().findElement(By.className("col-left")).findElement(By.className("principal"));
	}
	
	public boolean exibiuChamadaPrincipal(){
		return acessaChamadaPrincipal().isDisplayed();
	}
	
	public WebElement acessaEditoriaDaChamadaPrincipal() {
		return acessaChamadaPrincipal().findElement(By.tagName("h2"));
	}
	
	public boolean exibiuEditoriaNaChamadaPrincipal() {
		return !acessaEditoriaDaChamadaPrincipal().getText().isEmpty();
	}
	
	public boolean exibiuLinkNaEditoriaDaChamadaPrincipal() {
		return acessaChamadaPrincipal().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean getBoxChamadaPrincipalEditoriaLinkValido() {
		return !acessaChamadaPrincipal().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public WebElement acessaImagemPrincipal(){
		return acessaChamadaPrincipal().findElement(By.className("animado-scale")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuImagemNaChamadaPrincipal(){
		return acessaImagemPrincipal().isDisplayed();
	}
	
	public boolean exibiuWidthHeightECropCorretoParaAImagemNaMateriaDaChamadaPrincipal(){
		
		int contadorDeErros = 0;
		
		String urlAtual = acessaImagemPrincipal().getAttribute("src");
		int widthAtual = Integer.parseInt(acessaImagemPrincipal().getAttribute("width"));
		int heightAtual = Integer.parseInt(acessaImagemPrincipal().getAttribute("height"));
		
		int widthEsperado = Integer.parseInt(CropsCapa.capaDaEsquerdaDestaque.getWidth());
		int heightEsperado = Integer.parseInt(CropsCapa.capaDaEsquerdaDestaque.getHeight());
		String cropEsperado = CropsCapa.capaDaEsquerdaDestaque.getCropProporcional();
		
		if(!urlAtual.contains(cropEsperado)){
			imprimirMensagemDeErroDeUmaTag("crop da imagem", cropEsperado, urlAtual);
			contadorDeErros++;
		}
		
		if(widthAtual > widthEsperado){
			imprimirMensagemDeErroDeUmaTag("width da imagem", Integer.toString(widthEsperado), Integer.toString(widthAtual));
			contadorDeErros++;
		}
		
		if(heightAtual > heightEsperado){
			imprimirMensagemDeErroDeUmaTag("height da imagem", Integer.toString(heightEsperado), Integer.toString(heightAtual));
			contadorDeErros++;
		}
		
		return validacaoDeErros(contadorDeErros);
	}
	
	public WebElement acessaTituloDaMateriaChamadaPrincipal() {
		return acessaChamadaPrincipal().findElement(By.tagName("h3"));
	}
	
	public boolean exibiuTituloDaChamadaPrincipal() {
		return !acessaTituloDaMateriaChamadaPrincipal().getText().isEmpty();
	}
	
	public boolean exibiuTituloDaChamadaPrincipalComUmLink() {
		return acessaChamadaPrincipal().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean getBoxChamadaPrincipalTituloLinkValido() {
		return !acessaChamadaPrincipal().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public WebElement acessaAutorDaChamada(){
		return acessaChamadaPrincipal().findElement(By.tagName("span")).findElement(By.tagName("b"));
	}
	
	public boolean exibiuAutorDaChamadaPrincipal() {
		List<WebElement> exibiuAutor = acessaChamadaPrincipal().findElement(By.tagName("span")).findElements(By.tagName("b"));
		if(exibiuAutor.size()>0){
			if(acessaChamadaPrincipal().findElement(By.tagName("span")).findElement(By.tagName("b")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuDescricaoDaMateriaChamadaPrincipal() {
		return !acessaChamadaPrincipal().findElement(By.tagName("span")).getText().isEmpty();
	}

	public WebElement acessaComentarioDaChamadaPrincipal(){
		return acessaChamadaPrincipal().findElement(By.tagName("span")).findElement(By.className("comments"));
	}
	
	public boolean exibiuComentariosParaAChamadaPrincipal() {
		List<WebElement> possuiComentarios = acessaChamadaPrincipal().findElement(By.tagName("span")).findElements(By.className("comments"));
		return !possuiComentarios.get(0).getText().isEmpty();
	}

	public List<WebElement> listaComTodosOsBoxDeOpiniao() {
		return getDriver().findElement(By.className("web-chamada")).findElements(By.tagName("div"));
	}
	
	public int totalDeBoxDeOpiniao() {
		return listaComTodosOsBoxDeOpiniao().size();
	}
	
	//Novos métodos a serem substituidos//
	
	public boolean exibiuLinkNoBoxDeOpiniao() {
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			if(!listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("a")).isDisplayed()){
				imprimirMensagemDeErroGenerica("Não exibiu link para o "+(i+1)+"º box");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuBackgroundParaCadaUmDosBoxDeOpiniao() {
		
		String backgroundEsperado = "rgba(243, 243, 243, 1)";
		
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			String backgroundAtual = listaComTodosOsBoxDeOpiniao().get(i).getCssValue("background-color");
			if(!backgroundAtual.equals(backgroundEsperado)){
				imprimirMensagemDeErroDeUmaTag("background do "+(i+1)+"º box", backgroundEsperado, backgroundAtual);
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagemParaCadaUmDosBoxDeOpiniao() {
		
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			if(!listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("img")).isDisplayed()){
				imprimirMensagemDeErroGenerica("Não exibiu imagem para o "+(i+1)+"º box");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuWidthCorretoParaAsImagemParaCadaUmDosBoxDeOpiniao() {
		
		String widthEsperado = CropsCapa.boxOpiniao.getWidth();
		
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			String widthAtual = listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("width"); 
				if(!widthAtual.equals(widthEsperado)){
				imprimirMensagemDeErroDeUmaTag("width da imagem do "+(i+1)+"º box", widthEsperado, widthAtual); 
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuHeightCorretoParaAsImagemParaCadaUmDosBoxDeOpiniao() {
		
		String widthEsperado = CropsCapa.boxOpiniao.getHeight();
		
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			String widthAtual = listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("height"); 
				if(!widthAtual.equals(widthEsperado)){
				imprimirMensagemDeErroDeUmaTag("height da imagem do "+(i+1)+"º box", widthEsperado, widthAtual); 
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuCropCorretoParaAsImagemParaCadaUmDosBoxDeOpiniao() {
		
		String cropEsperado = CropsCapa.boxOpiniao.getCropProporcional();
		
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			String urlAtual = listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("src"); 
				if(!urlAtual.contains(cropEsperado)){
				imprimirMensagemDeErroDeUmaTag("crop da imagem do "+(i+1)+"º box", cropEsperado, urlAtual); 
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuAntitituloParaCadaUmDosBoxDeOpiniao() {
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			String antiTituloPosicaoAtual = listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("h4")).getText(); 
				if(antiTituloPosicaoAtual.isEmpty()){
				imprimirMensagemDeErroGenerica("Não exibiu antitítulo para o "+(i+1)+"º box");
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuAutorParaCadaUmDosBoxDeOpiniao() {
		for(int i=0; i < totalDeBoxDeOpiniao(); i++){
			String autorPosicaoAtual = listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("h5")).getText(); 
				if(autorPosicaoAtual.isEmpty()){
				imprimirMensagemDeErroGenerica("Não exibiu autor para o "+(i+1)+"º box");
				return false;
			}
		}
		return true;
	}
	
	//Fim métodos a serem substituidos//
	
	
	
	
	
	
	
	//remover
	public boolean getBoxWebChamadaLinkValido() {
		for(int i=0;i<listaComTodosOsBoxDeOpiniao().size();i++){
			if(listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaFotoParaOPrimeiroBox() {
		List<WebElement> exibiuFoto = listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("a")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaPrimeiraFotoLinkAnimado() {
		List<WebElement> exibiuFoto = listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("a")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			List<WebElement> exibiuClasseAnimada = listaComTodosOsBoxDeOpiniao().get(0).findElements(By.className("animado"));
			if(exibiuClasseAnimada.size()>0){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaSegundaFotoLinkAnimado() {
		List<WebElement> exibiuFoto = listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("a")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			List<WebElement> exibiuClasseAnimada = listaComTodosOsBoxDeOpiniao().get(1).findElements(By.className("animado"));
			if(exibiuClasseAnimada.size()>0){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaFotoParaOSegundoBox() {
		List<WebElement> exibiuFoto = listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("a")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaDoPrimeiroBoxComFotoWidth() {
		List<WebElement> exibiuFoto = listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("a")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("width").equals("60")){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaDoSegundoBoxComFotoWidth() {
		List<WebElement> exibiuFoto = listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("a")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("width").equals("60")){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaDoPrimeiroBoxComFotoHeight() {
		List<WebElement> exibiuFoto = listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("a")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("height").equals("60")){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaDoSegundoBoxComFotoHeight() {
		List<WebElement> exibiuFoto = listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("a")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("height").equals("60")){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getBoxWebChamadaTituloPrimeiroBox() {
		List<WebElement> exibiuTitulo = listaComTodosOsBoxDeOpiniao().get(0).findElements(By.tagName("h4"));
		if(exibiuTitulo.size()>0){
			if(listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("h4")).getText().isEmpty()){
				return false;
			}
		}	
		return true;
	}
	//remover
	public boolean getBoxWebChamadaTituloSegundoBox() {
		List<WebElement> exibiuTitulo = listaComTodosOsBoxDeOpiniao().get(1).findElements(By.tagName("h4"));
		if(exibiuTitulo.size()>0){
			if(listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("h4")).getText().isEmpty()){
				return false;
			}
		}	
		return true;
	}
	//remover
	public boolean getWebChamadaAutorPrimeiroBox() {
		List<WebElement> exibiuTitulo = listaComTodosOsBoxDeOpiniao().get(0).findElements(By.tagName("h5"));
		if(exibiuTitulo.size()>0){
			if(listaComTodosOsBoxDeOpiniao().get(0).findElement(By.tagName("h5")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	//remover
	public boolean getWebChamadaAutorSegundoBox() {
		List<WebElement> exibiuTitulo = listaComTodosOsBoxDeOpiniao().get(1).findElements(By.tagName("h5"));
		if(exibiuTitulo.size()>0){
			if(listaComTodosOsBoxDeOpiniao().get(1).findElement(By.tagName("h5")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	
	
	
	
	public boolean getBoxWebChamadaDescricao() {
		for(int i=0;i<listaComTodosOsBoxDeOpiniao().size();i++){
			if(listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean getBoxWebChamadaTitulosBoxMaximoCaracteres() {
		for(int i=0;i<listaComTodosOsBoxDeOpiniao().size();i++){
			if(listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("span")).getText().length()>44){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTamanhoDoTituloCorreto() {
		for(int i=0; i<listaComTodosOsBoxDeOpiniao().size();i++){
			if(listaComTodosOsBoxDeOpiniao().get(i).findElement(By.tagName("span")).getText().length()>80){
				return false;
			}
		}
		return true;
	}
	
	public WebElement acessaChamadaSecundaria() {
		return acessaChamadaPrincipal().findElement(By.className("materia-relacionada"));
	}
	
	public boolean exibiuChamadaSecundaria() {
		return acessaChamadaSecundaria().isDisplayed();
	}

	public boolean exibiuUmaFotoNaChamadaSecundaria() {
		return acessaChamadaSecundaria().findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuClasseAnimadaParaAImagemDaChamadaSecundaria() {
		try {
			if(acessaChamadaSecundaria().findElement(By.tagName("a")).getAttribute("class").equals("animado")){
				imprimirMensagemDeErroGenerica("Exibiu incorretamente classe animada para a imagem");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean exibiuImagemDaChamadaSecundariaComWidthCorreto() {
		
		String witdhEsperado = CropsCapa.chamadaSecundaria.getWidth();
		String widthAtual =  acessaChamadaSecundaria().findElement(By.tagName("img")).getAttribute("width");
		
		if(!widthAtual.equals(witdhEsperado)){
			imprimirMensagemDeErroDeUmaTag("width da imagem secundária", witdhEsperado, widthAtual);
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuImagemDaChamadaSecundariaComHeightCorreto() {

		String heightEsperado = CropsCapa.chamadaSecundaria.getHeight();
		String heightAtual =  acessaChamadaSecundaria().findElement(By.tagName("img")).getAttribute("height");
		
		if(!heightAtual.equals(heightEsperado)){
			imprimirMensagemDeErroDeUmaTag("height da imagem secundária", heightEsperado, heightAtual);
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuImagemDaChamadaSecundariaComCropCorreto() {

		String cropEsperado = CropsCapa.chamadaSecundaria.getCropProporcional();
		String urlImagemAtual =  acessaChamadaSecundaria().findElement(By.tagName("img")).getAttribute("src");
		
		if(!urlImagemAtual.contains(cropEsperado)){
			imprimirMensagemDeErroDeUmaTag("crop da imagem secundária", cropEsperado, urlImagemAtual);
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuTituloParaAChamadaSecundaria() {
		return !acessaChamadaSecundaria().findElement(By.tagName("h3")).getText().isEmpty();
	}
	
	public boolean exibiuUmTituloComLinkParaAChamadaSecundaria() {
		return acessaChamadaSecundaria().findElement(By.className("clearfix")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean getBoxMateriaRelacionadaLinkValido() {
		return !acessaChamadaSecundaria().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public WebElement acessaAutorDaChamadaSecundaria(){
		return acessaChamadaSecundaria().findElement(By.tagName("span")).findElement(By.tagName("b"));
	}
	
	public boolean exibiuAutorParaAChamadaSecundaria() {
		List<WebElement> exibiuAutor = acessaChamadaSecundaria().findElement(By.tagName("span")).findElements(By.tagName("b"));
		if(exibiuAutor.size()>0){
			if(acessaChamadaSecundaria().findElement(By.tagName("span")).findElement(By.tagName("b")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoParaAChamadaSecundaria() {
		return !acessaChamadaSecundaria().findElement(By.className("clearfix")).findElement(By.tagName("span")).getText().isEmpty();
	}
	
	public WebElement acessaComentarioDaChamadaSecundaria() {
		return acessaChamadaSecundaria().findElement(By.tagName("span")).findElement(By.className("comments"));
	}
	
	public boolean getBoxMateriaRelacionadaComentarios() {
		List<WebElement> exibiuComentarios = acessaChamadaSecundaria().findElement(By.tagName("span")).findElements(By.className("comments"));
		if(exibiuComentarios.size()>0){
			if(exibiuComentarios.get(0).getText().isEmpty()){
				return false;
			}
		}
			return true;
	}
}