package pages.lista;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ListaBoxDeMaisGalerias extends AceitacaoAbstractTest {
	
	public ListaBoxDeMaisGalerias() throws Exception {
		super();
	}
	
	public ListaBoxDeMaisGalerias(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement obterContadorInicial() {
		return getDriver().findElement(By.className("counter"));
	}
	
	public WebElement acessaultimaPosicaoDaLista() {
		return getDriver().findElement(By.className("abrir-galeria"));
	}
	
	public void clicarParaAbrirOBox() {
		getDriver().findElement(By.cssSelector("div.abrir-galeria > a")).click();
	}
	
	public boolean exibiuOBoxDeMaisGaleriasFechado() {
		return getDriver().findElement(By.className("abrir-galeria")).findElement(By.tagName("a")).getAttribute("class").isEmpty();
	}
	
	public WebElement exibiuBoxDeMaisGalerias() {
		return getDriver().findElement(By.className("mais-galerias"));
	}
	
	public boolean exibiuOBoxAberto() {
		return getDriver().findElement(By.className("abrir-galeria")).findElement(By.tagName("a")).getAttribute("class").equals("opened");
	}
	
	public WebElement acessaPaginacaoDoBox() {
		return exibiuBoxDeMaisGalerias().findElement(By.className("nav-container"));
	}
	
	public boolean exibiuSetaDaEsquerdaDesabilitadaEDireitaHabilitada() {
		
		WebElement paginacaoParaAEsquerda = acessaPaginacaoDoBox().findElements(By.tagName("a")).get(0); 
		WebElement paginacaoParaADireita = acessaPaginacaoDoBox().findElements(By.tagName("a")).get(1);
		
		if(!paginacaoParaAEsquerda.isDisplayed() || !paginacaoParaAEsquerda.getAttribute("class").contains("disabled")){
			imprimirMensagemDeErroGenerica("Não exibiu a paginação para esquerda corretamente");
			return false;
		}
		
		if(!paginacaoParaADireita.isDisplayed() || !paginacaoParaADireita.getAttribute("class").equals("proxima")){
			imprimirMensagemDeErroGenerica("Não exibiu a paginação para direita corretamente");
			return false;
		}
		
		return true;
	}
	
	public List<WebElement> listaComTodasAsListasDeFatos() {
		return exibiuBoxDeMaisGalerias().findElement(By.className("mais-galerias-container")).findElements(By.tagName("li"));
	}

	public int totalDeItensDaLista() {
		return listaComTodasAsListasDeFatos().size();
	}
	
	public boolean exibiuListaDeOutrasGalerias() {
		
		if(totalDeItensDaLista() <= Integer.parseInt("1")){
			imprimirMensagemDeErroGenerica("O box de mais listas está vazio.");
			return false;
		}
		
		return true;
	}
	
	public void clicarNaPaginacaoParaDireita(){
		getDriver().findElement(By.cssSelector("div.row.closed > div.nav-container.clearfix > a.proxima")).click();
	}

	public boolean exibiuLinkTituloCropWidthHeightCorretosParaAsImagens() throws InterruptedException {
		
		String cropEsperado = CropsDeArticles.listaDeFatosMaisGalerias.cropProporcional();
		int widthEsperado = Integer.parseInt(CropsDeArticles.listaDeFatosMaisGalerias.getWidth());
		int heightEsperado = Integer.parseInt(CropsDeArticles.listaDeFatosMaisGalerias.getHeight());
		
		String fonteTituloEsperado = "OgloboCondensed, Arial, sans-serif";
		String tamanhoTituloEsperado = "20px";
		String corTituloEsperado = "rgba(51, 51, 51, 1)";
		
		int numerosDeListasValidadas = 0;
		int totalDeVezesJaPaginado = 0;
		double valorTotalPorQuatro = totalDeItensDaLista() / 4;
		int ehMultiploDeQuatro = totalDeItensDaLista() % 4;
		int quantidadeDeVezesAPaginar = (int) Math.floor(valorTotalPorQuatro);
		
		if(ehMultiploDeQuatro == Integer.parseInt("0")){
			quantidadeDeVezesAPaginar--;
		}
		
		for(int i=0; i < totalDeItensDaLista(); i++){
			
			String urlDaImagemAtual = listaComTodasAsListasDeFatos().get(i).findElement(By.tagName("img")).getAttribute("src");
			String widthAtualNaPosicao = listaComTodasAsListasDeFatos().get(i).findElement(By.tagName("img")).getAttribute("width");
			String heightAtualNaPosicao = listaComTodasAsListasDeFatos().get(i).findElement(By.tagName("img")).getAttribute("height");
			
			WebElement linkListaAtual = listaComTodasAsListasDeFatos().get(i).findElement(By.tagName("a"));
			
			WebElement tituloPosicaoAtual = listaComTodasAsListasDeFatos().get(i).findElement(By.tagName("figcaption"));
			String conteudoTituloPosicaoAtual = tituloPosicaoAtual.getText();
			String fonteTituloAtual = listaComTodasAsListasDeFatos().get(i).findElement(By.tagName("figcaption")).getCssValue("font-family");
			String tamanhoTituloAtual = listaComTodasAsListasDeFatos().get(i).findElement(By.tagName("figcaption")).getCssValue("font-size");
			String corTituloAtual = listaComTodasAsListasDeFatos().get(i).findElement(By.tagName("figcaption")).getCssValue("color");
			
			if(!urlDaImagemAtual.contains(cropEsperado)){
				imprimirMensagemDeErro("crop correto ", i);
				return false;
			}
			
			if(Integer.parseInt(widthAtualNaPosicao) > widthEsperado){
				imprimirMensagemDeErroDeImagem(i, widthAtualNaPosicao, CropsDeArticles.listaDeFatosMaisGalerias.getWidth());
				return false;
			}
			
			if(Integer.parseInt(heightAtualNaPosicao) > heightEsperado){
				imprimirMensagemDeErroDeImagem(i, heightAtualNaPosicao, CropsDeArticles.listaDeFatosMaisGalerias.getHeight());
				return false;
			}
			
			if(!linkListaAtual.isDisplayed()){
				imprimirMensagemDeErro("link na imagem", i);
				return false;
			}
			
			if(conteudoTituloPosicaoAtual.isEmpty() || !tituloPosicaoAtual.isDisplayed()){
				imprimirMensagemDeErro("título corretamente", i);
				return false;
			}
			
			if(!fonteTituloAtual.equals(fonteTituloEsperado)){
				imprimirMensagemDeErroDeUmaTag("título", fonteTituloAtual, fonteTituloEsperado);
				return false;
			}
			
			if(!tamanhoTituloAtual.equals(tamanhoTituloEsperado)){
				imprimirMensagemDeErroDeUmaTag("título", tamanhoTituloAtual, tamanhoTituloEsperado);
				return false;
			}
			
			if(!corTituloAtual.equals(corTituloEsperado)){
				imprimirMensagemDeErroDeUmaTag("título", corTituloAtual, corTituloEsperado);
				return false;
			}
			
			numerosDeListasValidadas++;
			
			if(numerosDeListasValidadas == 4){
				
				if(totalDeVezesJaPaginado < quantidadeDeVezesAPaginar){
					
					esperaCarregar1Segundo();
					clicarNaPaginacaoParaDireita();
					numerosDeListasValidadas = 0;
					totalDeVezesJaPaginado++;

				}
				
			}
		}
		
		return true;
		
	}
}