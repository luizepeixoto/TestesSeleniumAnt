package pages.barreira;

import java.util.ArrayList;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import assistente.Assistente;
import br.com.infoglobo.pages.Navegador;

public class Degustacao extends BarreiraWhiteList{
	
	private String mensagemDeErroNaAssinaturaEsperado = "Identificamos um problema na sua assinatura. Entre em contato pelo telefone (21) 2534-4335 ou pelo email assinaturadigital@oglobo.com.br";
	private String mensagemDeSucessoAoAtingir20Cliques = "Você completou os 20 cliques.\nObrigado por assinar O Globo.\nBoa leitura.";
	
	public Degustacao(Navegador navegador) throws Exception{
		super(navegador);
	}

	public void navegarPorOnzeMateriasDiferentes() throws Exception{
		
		Assistente assistente = new Assistente();
		ArrayList<String> urlsDeNavegacao = new ArrayList<String>();
		
		urlsDeNavegacao = assistente.obterOnzeUrls(getAmbiente(), getDominio());

		for (int i = 0; i < urlsDeNavegacao.size(); i++) {
			getDriver().navigate().to(urlsDeNavegacao.get(i));
			System.out.println("Matéria nº "+ (i+1) + ": " + getDriver().getCurrentUrl());
			esperaCarregar(2);
		}	
	}
	
	public void navegarPor10MateriasDiferentes() throws Exception{
		
		Assistente assistente = new Assistente();
		ArrayList<String> urlsDeNavegacao = new ArrayList<String>();

		urlsDeNavegacao = assistente.obterVinteUrls(getAmbiente(), getDominio());

		for (int i = 0; i < urlsDeNavegacao.size(); i++) {
			getDriver().navigate().to(urlsDeNavegacao.get(i));
			System.out.println("Matéria nº "+ (i+11) + ": " + getDriver().getCurrentUrl());
			esperaCarregar(2);;
		}
	}

	public void navegarPor11MateriasDiferentesComCompartilhamentoWhiteList(String compartilhamentoDesejado) throws Exception{
		
		Assistente assistente = new Assistente();
		ArrayList<String> urlsDeNavegacao = new ArrayList<String>();

		urlsDeNavegacao = assistente.obterOnzeUrlsSendoAUltimaComWhiteList(getAmbiente(), getDominio(), compartilhamentoDesejado);

		for (int i = 0; i < urlsDeNavegacao.size(); i++) {
			getDriver().navigate().to(urlsDeNavegacao.get(i));
			System.out.println("Matéria nº "+ (i+11) + ": " + getDriver().getCurrentUrl());
			esperaCarregar(2);
			
		}
	}

	public void clicarNoBotaoAcessarMais10Materias() throws InterruptedException {
		getDriver().findElement(By.id("LinkButtonContinuarLendo")).click();	
	}

	public void clicarNoLinkEntre() throws InterruptedException {
		esperaCarregar(1);
		getDriver().findElement(By.className("welcome-link")).findElement(By.tagName("a")).click();
	}

	public void clicarNoBotaoEntrar() throws InterruptedException {
		getDriver().findElement(By.className("button")).click();	
	}

	public String obterCookie(String nomeDoCookie) throws InterruptedException {
		Assistente assistente = new Assistente();
		return assistente.obterCookie(nomeDoCookie, getDriver());
	}	
	
	public String obterUrlAtual() throws InterruptedException {
		esperaCarregar(3);
		return getUrlPaginaAtual().replaceAll("(http://|http://www\\.|www\\.)","");
	}

	public boolean redirecionouOUsuarioParaAUltimaURLAcessada() throws InterruptedException{
		
		String cookieINFGPAGANTERIOR = "infgPagAnterior";
		String ultimaPaginaAcessadaAntesDeCairNaDegustacao = obterCookie(cookieINFGPAGANTERIOR);
		String primeiraUrlAcessadaAposEfetuarLogin = obterUrlAtual();
		
		if(!ultimaPaginaAcessadaAntesDeCairNaDegustacao.equals(primeiraUrlAcessadaAposEfetuarLogin)){
			
			if(primeiraUrlAcessadaAposEfetuarLogin.contains("beta") || ultimaPaginaAcessadaAntesDeCairNaDegustacao.contains("beta")){
				imprimirMensagemDeErroGenerica("\nVerificar possível erro de Cross-domain");
				imprimirMensagemDeErroGenerica("\nVerificar no console se foram criados dois cookies: ["+cookieINFGPAGANTERIOR+"]");
			}
			
			String cookieUtilizado = "infgw";
			String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
			System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"+\n+");
			
			imprimirMensagemDeErroDeUmaTag("URL atual", primeiraUrlAcessadaAposEfetuarLogin, ultimaPaginaAcessadaAntesDeCairNaDegustacao);
			return false;
		
		}
		
		return true;
	}
	
	public boolean exibiuOStatusDoCookiedoRegisterWallComoAutorizado() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String statusRegisterEsperadoNoCookie = "AUTORIZADO";
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String statusRegisterWallAtual = arqJSON.getJSONObject("eventos").getJSONObject("RegisterWall").get("motivo").toString();	
			
			if(!statusRegisterWallAtual.equals(statusRegisterEsperadoNoCookie)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"+\n+");
				imprimirMensagemDeErroDeUmaTag("status do register", statusRegisterEsperadoNoCookie, statusRegisterWallAtual);
				imprimirMensagemDeErroGenerica("Verificar status do usuário utilizado.");
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean exibiuADataDoCookiedoRegisterWallAutorizada() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String dataEsperadaNoCookieDoRegister = dataSimples();
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String dataExecRegisterWallAtual = arqJSON.getJSONObject("eventos").getJSONObject("RegisterWall").get("dtExec").toString();	
			String dataConvRegisterWallAtual = arqJSON.getJSONObject("eventos").getJSONObject("RegisterWall").get("dtConv").toString();
			
			if(!dataExecRegisterWallAtual.contains(dataEsperadaNoCookieDoRegister)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("\nData de execução do register", dataEsperadaNoCookieDoRegister, dataExecRegisterWallAtual);
				return false;
				
			}
			
			if(!dataConvRegisterWallAtual.contains(dataEsperadaNoCookieDoRegister)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("\nData de conversão do register", dataEsperadaNoCookieDoRegister, dataConvRegisterWallAtual);
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}

	public boolean exibiuOStatusDoCookiedoPaywallComoAutorizado() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String statusPaywallEsperadoNoCookie = "AUTORIZADO";
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String statusPaywallAtual = arqJSON.getJSONObject("eventos").getJSONObject("Paywall").get("motivo").toString();	
			
			if(!statusPaywallAtual.equals(statusPaywallEsperadoNoCookie)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("status do paywall", statusPaywallEsperadoNoCookie, statusPaywallAtual);
				imprimirMensagemDeErroGenerica("Verificar status do usuário utilizado.");
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean exibiuOStatusDoCookiedoPaywallComoAutorizadoComRessalva() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String statusPaywallEsperadoNoCookie = "AUTORIZADO_COM_RESSALVA";
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String statusPaywallAtual = arqJSON.getJSONObject("eventos").getJSONObject("Paywall").get("motivo").toString();	
			
			if(!statusPaywallAtual.equals(statusPaywallEsperadoNoCookie)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("status do paywall", statusPaywallEsperadoNoCookie, statusPaywallAtual);
				imprimirMensagemDeErroGenerica("Verificar status do usuário utilizado.");
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public String mensagemDeAtingiu20Materias(){
		return getDriver().findElement(By.className("msg-paywall")).findElement(By.tagName("p")).getText();
	}
	
	public boolean exibiuMensagemDeAcessou20MateriasComSucessoNoPaywall() throws InterruptedException{
		esperaCarregar(2);
		if(!mensagemDeSucessoAoAtingir20Cliques.equals(mensagemDeAtingiu20Materias())){
			imprimirMensagemDeErroDeUmaTag("mensagem de assinatura", mensagemDeSucessoAoAtingir20Cliques, mensagemDeAtingiu20Materias());
			return false;
		}
		
		return true;
	}
	
	public String mensagemDeErroMostradaNaPagina(){
		return getDriver().findElement(By.className("alertPaywall")).findElement(By.className("sub")).getText();
	}
	
	public boolean exibiuMensagemDeEntrarEmContatoParaAssinaturaDigitalComProblema() throws InterruptedException{
		esperaCarregar(1);
		if(!mensagemDeErroNaAssinaturaEsperado.equals(mensagemDeErroMostradaNaPagina())){
			imprimirMensagemDeErroDeUmaTag("mensagem de assinatura", mensagemDeErroNaAssinaturaEsperado, mensagemDeErroMostradaNaPagina());
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuOStatusDoCookiedoPaywallComoEncerrado() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String statusPaywallEsperadoNoCookie = "ENCERRADO";
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String statusPaywallAtual = arqJSON.getJSONObject("eventos").getJSONObject("Paywall").get("motivo").toString();	
			
			if(!statusPaywallAtual.equals(statusPaywallEsperadoNoCookie)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("status do paywall", statusPaywallEsperadoNoCookie, statusPaywallAtual);
				imprimirMensagemDeErroGenerica("Verificar status do usuário utilizado.");
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean redirecionouParaLoja() throws InterruptedException {
		
		esperaCarregar(1);
		String urlLoja = "https://assinatura.globostg.globoi.com/";
		String urlAtual = getUrlPaginaAtual();
		
		if(!urlAtual.contains(urlLoja)){
			imprimirMensagemDeErroDeUmaTag("URL da loja", urlLoja, urlAtual);
			return false;
		}
		
		return true;
			
	}
	
	public boolean exibiuOStatusDoCookiedoPaywallComoCancelado() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String statusPaywallEsperadoNoCookie = "CANCELADO";
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String statusPaywallAtual = arqJSON.getJSONObject("eventos").getJSONObject("Paywall").get("motivo").toString();	
			
			if(!statusPaywallAtual.equals(statusPaywallEsperadoNoCookie)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("status do paywall", statusPaywallEsperadoNoCookie, statusPaywallAtual);
				imprimirMensagemDeErroGenerica("Verificar status do usuário utilizado.");
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}

	public boolean exibiuMensagemContaInativaEParaEntrarEmContatoParaAssinaturaDigitalComProblema(){
		
		String titulomensagemDeErroEsperado = "Informação";
		String titulomensagemDeErroAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.className("title")).getText();
		
		String mensagemDeErroNaAssinaturaEsperado = "Seu acesso foi inativado. Entre em contato pelo telefone (21) 2534-4335 ou pelo email assinaturadigital@oglobo.com.br";
		String mensagemDeErroNaAssinaturaAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.className("sub")).getText();
		
		if(!titulomensagemDeErroEsperado.equals(titulomensagemDeErroAtual)){
			imprimirMensagemDeErroDeUmaTag("título da assinatura com problema", titulomensagemDeErroEsperado, titulomensagemDeErroAtual);
			return false;
		}
		
		if(!mensagemDeErroNaAssinaturaEsperado.equals(mensagemDeErroNaAssinaturaAtual)){
			imprimirMensagemDeErroDeUmaTag("mensagem de assinatura com problema", mensagemDeErroNaAssinaturaEsperado, mensagemDeErroMostradaNaPagina());
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuFonteCorDaFonteEPopUpComOsLayoutsEsperados(){
		
		String fonteDoTituloEsperada = "OgloboCondensedMedium";
		String fonteDoTituloAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.className("title")).getCssValue("font-family");
		
		String corDoTituloEsperada = "rgba(25, 50, 77, 1)";
		String corDoTituloAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.className("title")).getCssValue("color");
		
		String tamanhoDoTituloEsperado = "41px";
		String tamanhoDoTituloAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.className("title")).getCssValue("font-size");
		
		String fonteDaDescricaoEsperada = "OgloboCondensedMedium";
		String fonteDaDescricaoAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.className("sub")).getCssValue("font-family");
		
		String corDaDescricaoEsperada = "rgba(25, 50, 77, 1)";
		String corDaDescricaoAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.className("sub")).getCssValue("color");
		
		String tamanhoDaDescricaoEsperada = "23px";
		String tamanhoDaDescricaoAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.className("sub")).getCssValue("font-size");
		
		String corDoLightBoxEsperado = "rgba(255, 255, 255, 1)";
		String corDoLightBoxAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.tagName("div")).getCssValue("background-color");
		
		String widhtDoLightBoxEsperado = "500px";
		String widthDoLightBoxAtual = getDriver().findElement(By.className("alertPaywall")).findElement(By.tagName("div")).getCssValue("width");
		
		String corDoFundoDoLightBoxNaPaginaEsperado = "rgba(0, 0, 0, 0.701961)";
		String corDoFundoDoLightBoxNaPaginaAtual = getDriver().findElement(By.className("alertPaywall")).getCssValue("background-color");
		
		if(!fonteDoTituloEsperada.equals(fonteDoTituloAtual)){
			imprimirMensagemDeErroDeUmaTag("Fonte do título", fonteDoTituloEsperada, fonteDoTituloAtual);
			return false;
		}
		
		if(!corDoTituloEsperada.equals(corDoTituloAtual)){
			imprimirMensagemDeErroDeUmaTag("Cor da fonte do título", corDoTituloEsperada, corDoTituloAtual);
			return false;
		}
		
		if(!tamanhoDoTituloEsperado.equals(tamanhoDoTituloAtual)){
			imprimirMensagemDeErroDeUmaTag("Tamanho da fonte do título", tamanhoDoTituloEsperado, tamanhoDoTituloAtual);
			return false;
		}
		
		if(!fonteDaDescricaoEsperada.equals(fonteDaDescricaoAtual)){
			imprimirMensagemDeErroDeUmaTag("Fonte da descrição", fonteDaDescricaoEsperada, fonteDaDescricaoAtual);
			return false;
		}
		
		if(!corDaDescricaoEsperada.equals(corDaDescricaoAtual)){
			imprimirMensagemDeErroDeUmaTag("Fonte do descrição", corDaDescricaoEsperada, corDaDescricaoAtual);
			return false;
		}
		
		if(!tamanhoDaDescricaoEsperada.equals(tamanhoDaDescricaoAtual)){
			imprimirMensagemDeErroDeUmaTag("Fonte do descrição", tamanhoDaDescricaoEsperada, tamanhoDaDescricaoAtual);
			return false;
		}
		
		if(!corDoLightBoxEsperado.equals(corDoLightBoxAtual)){
			imprimirMensagemDeErroDeUmaTag("cor de fundo do lightbox", corDoLightBoxEsperado, corDoLightBoxAtual);
			return false;
		}
		
		if(!widhtDoLightBoxEsperado.equals(widthDoLightBoxAtual)){
			imprimirMensagemDeErroDeUmaTag("Tamanho (width) do LightBox", widhtDoLightBoxEsperado, widthDoLightBoxAtual);
			return false;
		}
		
		if(!corDoFundoDoLightBoxNaPaginaEsperado.equals(corDoFundoDoLightBoxNaPaginaAtual)){
			imprimirMensagemDeErroDeUmaTag("cor da página com lightBox", corDoFundoDoLightBoxNaPaginaEsperado, corDoFundoDoLightBoxNaPaginaAtual);
			return false;
		}
		
		return true;
	}
	
	
	public void clicarParaFecharOLightBox(){
		getDriver().findElement(By.cssSelector("p.close > a")).click();
	}
	
	public boolean fechouOLightboxCorretamente() throws InterruptedException{
		clicarParaFecharOLightBox();
		esperaCarregar(1);
		
		try {
			if(getDriver().findElement(By.className("alertPaywall")).isDisplayed()){
				imprimirMensagemDeErroGenerica("Não fechou o lightbox.");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean redirecionouOUsuarioParaAHomeDoSite() throws Exception{
		
		esperaCarregar(2);
		
		String dominioEsperado = getDominio();
		String paginaAtual = getUrlPaginaAtual();
		
		if(!dominioEsperado.equals(paginaAtual)){
			imprimirMensagemDeErroDeUmaTag("url incorreta", dominioEsperado, paginaAtual);
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuOStatusDoCookiedoPaywallComoDuplicado() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String statusPaywallEsperadoNoCookie = "PN_DUPLICADO";
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String statusPaywallAtual = arqJSON.getJSONObject("eventos").getJSONObject("Paywall").get("motivo").toString();	
			
			if(!statusPaywallAtual.equals(statusPaywallEsperadoNoCookie)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("status do paywall", statusPaywallEsperadoNoCookie, statusPaywallAtual);
				imprimirMensagemDeErroGenerica("Verificar status do usuário utilizado.");
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean exibiuOStatusDoCookiedoPaywallComoInexistente() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String statusPaywallEsperadoNoCookie = "INEXISTENTE";
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String statusPaywallAtual = arqJSON.getJSONObject("eventos").getJSONObject("Paywall").get("motivo").toString();	
			
			if(!statusPaywallAtual.equals(statusPaywallEsperadoNoCookie)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("status do paywall", statusPaywallEsperadoNoCookie, statusPaywallAtual);
				imprimirMensagemDeErroGenerica("Verificar status do usuário utilizado.");
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean exibiuOStatusDoCookiedoPaywallComoUpgrade() throws InterruptedException{
		
		String cookieUtilizado = "infgw";
		String statusPaywallEsperadoNoCookie = "UPGRADE";
		String conteudoDoCookieINFGW = obterCookie(cookieUtilizado);
		
		try {
			
			JSONObject arqJSON = new JSONObject(conteudoDoCookieINFGW);
			
			String statusPaywallAtual = arqJSON.getJSONObject("eventos").getJSONObject("Paywall").get("motivo").toString();	
			
			if(!statusPaywallAtual.equals(statusPaywallEsperadoNoCookie)){				
				
				System.out.println("\nCookie Utilizado " +cookieUtilizado+ ":" + conteudoDoCookieINFGW+"\n");
				imprimirMensagemDeErroDeUmaTag("status do paywall", statusPaywallEsperadoNoCookie, statusPaywallAtual);
				imprimirMensagemDeErroGenerica("Verificar status do usuário utilizado.");
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	
	public void logarNaBarraGloboPontoCom() throws Exception {
		
		esperaCarregar(3);
		
		WebElement botaoEntrarDaBarraDaGloboCom = getDriver().findElement(By.xpath("//*[@id=\"barra-item-login\"]/div[1]"));
		WebElement iframeLogin = getDriver().findElement(By.id("login-popin-iframe"));
		
		if(!botaoEntrarDaBarraDaGloboCom.isDisplayed()){
			imprimirMensagemDeErroGenerica("O botão de login da Globo.com no topo da home não está sendo exibido.");
		}
		
		botaoEntrarDaBarraDaGloboCom.click();
		
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(iframeLogin);
		
	}
}