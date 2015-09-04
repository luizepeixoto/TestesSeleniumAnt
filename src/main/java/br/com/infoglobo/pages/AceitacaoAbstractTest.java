package br.com.infoglobo.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public abstract class AceitacaoAbstractTest {
	private final Navegador NAVEGADOR_PADRAO = Navegador.HTMLUNIT;

	private WebDriver driver;
	private ConfiguracoesTeste configuracoes;
	private Navegador navegador;
	private Device device;
	private String urlAmbienteTestado;

	public AceitacaoAbstractTest() throws Exception {
		this.navegador = NAVEGADOR_PADRAO;
		this.prepararAmbienteDeTeste();
	}

	public AceitacaoAbstractTest(Navegador navegador) throws Exception {
		this.navegador = navegador;
		this.prepararAmbienteDeTeste();
	}
	
	public AceitacaoAbstractTest(Navegador navegador, Device device) throws Exception {
		this.navegador = navegador;
		this.device = device;
		this.prepararAmbienteDeTeste();
	}
	
	public AceitacaoAbstractTest(WebDriver driver) {
		this.driver = driver;
		driver.manage().deleteAllCookies();		
	}

	private void prepararAmbienteDeTeste() throws Exception {
		this.configuracoes = new ConfiguracoesTeste();
		this.carregarHtmlUnitDriver();
		this.abrirUrlPageObject();
	}

	private void carregarHtmlUnitDriver() throws Exception {
		int doisSegundos = 5;

		switch (this.navegador) {
		
		case HTMLUNIT:
			this.driver = new HtmlUnitDriver(ConfiguracoesProxy.getDesiredCapabilitiesForProxy());
			((HtmlUnitDriver) this.driver).setJavascriptEnabled(false);
			break;
			
		case FIREFOX:
			this.driver = new FirefoxDriver(ConfiguracoesProxy.getDesiredCapabilitiesForProxy());
			break;
			
		case CHROME:
			this.driver = new ChromeDriver(ConfiguracoesProxy.getDesiredCapabilitiesForAChrome());
			break;
			
		case PHANTOM:
			this.driver = new PhantomJSDriver(ConfiguracoesProxy.getDesiredCapabilitiesForPhantom());
			break;
			
		case CHROME_EMULADO:
			driver = new ChromeDriver(ConfiguracoesProxy.getDesiredCapabilitiesForAChromeEmulated(device));
			break;
			
		default:
			throw new Exception("A implentação para o navegador escolhido não foi feita.");
		}
		
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(doisSegundos, TimeUnit.SECONDS);

	}

	private void abrirUrlPageObject() throws Exception {
		System.out.println("\nAbrindo URL do PageObject");
		this.driver.get(this.obterUrlPageObject());
	}

	private String obterUrlPageObject() throws Exception {
		String nomePagina = this.getClass().getSimpleName();
		String caminhoPagina = configuracoes.getCaminhoPagina(nomePagina);
		System.out.println("PageObject utilizado: " + this.getClass().getSimpleName());
		if (caminhoPagina == null) {
			String mensagemErro = "Não existe o path do PageObject '" + nomePagina + "' no arquivo de properties.";
			System.out.println(mensagemErro);
			throw new Exception(mensagemErro);
		}
		if (caminhoPagina.startsWith("http")) {
			System.out.println("Url: " + caminhoPagina+"\n");
			return caminhoPagina;
		}
		String ambiente = configuracoes.getUrlAmbiente();
		System.out.println("Url: " + ambiente + caminhoPagina+"\n");
		return ambiente + caminhoPagina;
	}

	public String getAmbiente() throws Exception {
		return configuracoes.getAmbiente();
	}

	public String getDominio() throws Exception {
		return configuracoes.getUrlAmbiente();
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public String getUrlPaginaAtual() {
		return this.getDriver().getCurrentUrl();
	}

	public String getCodigoFonte() {
		return this.getDriver().getPageSource();
	}

	public void fechar() {
		this.getDriver().quit();
		System.out.println("Fechando Browser");
	}

	public String getUrlAmbienteTestado() {
		return urlAmbienteTestado;
	}

	public String getTitulo() {
		return this.getDriver().getTitle();
	}

	public void navegarParaURL(String urlDestino) {
		String urlFinal = getUrlAmbienteTestado() + urlDestino;
		System.out.println("Navegando para a URL: " + urlFinal);
		getDriver().navigate().to(urlFinal);
	}

	public void voltarPaginaAnterior() {
		System.out.println("Voltando para a página anterior");
		getDriver().navigate().back();
		System.out.println("Página carregada:" + getDriver().getCurrentUrl());
	}

	public void preencherCampoTexto(WebElement campo, String valorPreencher) {
		campo.clear();
		campo.sendKeys(valorPreencher);
	}
	
	private void executarComandoJavaScript(String comando) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(comando);
	}

	public void executarScroll(String coordenadas) {
		executarComandoJavaScript("scroll" + coordenadas);
	}
	
	public void executarScroll(Point coordenadas) {
		executarComandoJavaScript("scroll" + coordenadas);
	}
	
	public void executaScrollParaAparecerOTituloDeUmaPosicao(WebElement posicao){
		//Executa o scroll e volta um pouco//
		Integer posicaoAtual = posicao.getLocation().y;
		Point novaPosicao = new Point(0, posicaoAtual-100);
		executarScroll(novaPosicao);
	}
	
	public void esperaCarregarMeioSegundo() throws InterruptedException {
		Thread.sleep(500);
	}
	
	public void esperaCarregar1Segundo() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	public void esperaCarregar2Segundos() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public void esperaCarregar3Segundos() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	private int obterAlturaSuperLeaderBoard() {
		try {
			String teste = getDriver().findElement(By.className("super-leaderboard")).getCssValue("height");
			int altura = Integer.valueOf(teste.substring(0, teste.indexOf("px")));
			return altura;
		} catch (Exception e) {
			return 0;
		}
	}

	public void esperaSuperLeaderboardVoltarAoTamanhoNormal(int alturaEsperada) throws InterruptedException {
		esperaCarregar(1);
		try {
			while (obterAlturaSuperLeaderBoard() > alturaEsperada) {
				if (obterAlturaSuperLeaderBoard() <= alturaEsperada) {
					break;
				}
			}
		} catch (Exception e) {
			
		}
	}
	
	public void esperaBannerFlashFechar() throws InterruptedException {
		esperaCarregar(1);
		try {
			WebElement bannerFlash = getDriver().findElement(By.xpath("//div[contains(@id, 'admFlashContainer')]"));
			System.out.println("Aguardando banner flash fechar.");
			while (bannerFlash.isDisplayed()) {
				if (! bannerFlash.isDisplayed()) {
					break;
				}
			}
		} catch (Exception e) {
			
		}
	}
	
	public void executarMouseOver(WebElement elemento) {
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(elemento).perform();
	}
	
	public void imprimirMensagemDeErroDeImagem(int posicaoAtual, String tamanhoAtual, String tamanhoEsperado){
		System.out.println("Erro na imagem na posição [" + (posicaoAtual+1) + "] com o tamanho: [" + tamanhoAtual + "].\nTamanho esperado: [" + tamanhoEsperado + "]\n");
	}
	
	public void imprimirMensagemDeErroDeImagem(String tamanhoAtual, String tamanhoEsperado){
		System.out.println("Imagem sendo exibida com o tamanho ou Crop: [" + tamanhoAtual + "].\nTamanho esperado: [" + tamanhoEsperado + "]\n");
	}
	
	public void imprimirMensagemDeErro(String tagDesejada, int posicaoAtual){
		System.out.println("Não está exibindo o/a [" + tagDesejada + "] na posição [" + (posicaoAtual+1) + "]\n");
	}
	
	public void imprimirMensagemDeErroDeUmaTag(String tagDesejada, String tamanhoEsperado, String tamanhoAtual){
		System.out.println("A/O " +tagDesejada+ " não está sendo exibida/o como esperada/o.\n" +tagDesejada+ " esperado/a: [" + tamanhoEsperado + "].\n"+tagDesejada+ " atual: [" + tamanhoAtual + "]\n");
	}
	
	public void imprimirMensagemDeErroGenerica(String textoDesejado){
		System.out.println("" + textoDesejado + "\n");
	}
	
	public String dataSimples(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void esperaCarregar(int tempoEmSegundos) throws InterruptedException{
		Thread.sleep(tempoEmSegundos * 1000);
	}
	
	public boolean validacaoDeErros(int totalDeErrosEncontrados){
		//verifica se o método possui erros. É necessário criar uma variável para contar os erros e não mais utilizar o false.
		if(totalDeErrosEncontrados == Integer.parseInt("0")){
			return true;
		}else 
		if(totalDeErrosEncontrados == Integer.parseInt("1")){ 
			imprimirMensagemDeErroGenerica("Foi encontrado "+totalDeErrosEncontrados+" erro.");
			return false;
		}else{
			imprimirMensagemDeErroGenerica("Foram encontrados "+totalDeErrosEncontrados+" erros.");
			return false;
		}
	}
}