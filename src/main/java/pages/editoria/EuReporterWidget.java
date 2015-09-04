package pages.editoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EuReporterWidget extends AceitacaoAbstractTest {

	public EuReporterWidget(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement exibiuBoxEuReporter() {
		return getDriver().findElement(By.className("col-right")).findElement(By.className("euReporter"));
	}

	public String exibiuOTitulo() {
		return exibiuBoxEuReporter().findElement(By.tagName("h3")).getText();
	}

	public boolean exibiuFotoNoBoxEuReporter() {
		return exibiuBoxEuReporter().findElement(By.className("bg")).isDisplayed();
	}
	
	public boolean exibiuIconeNaFoto() {
		return exibiuBoxEuReporter().findElement(By.className("bg")).findElement(By.className("ico-eu")).isDisplayed();
	}
	
	public String exibiuTextoNoBoxEuReporter() {
		return exibiuBoxEuReporter().findElements(By.tagName("span")).get(1).getText();
	}
	
	public List<WebElement> listaDeBotoes() {
		return exibiuBoxEuReporter().findElement(By.className("botoes")).findElements(By.tagName("a"));
	}
	
	public boolean exibiuDoisBotoes() {
		return listaDeBotoes().size() == Integer.parseInt("2");
	}

	public boolean exibiuBotaoSaibaComoEnviar() {
		return listaDeBotoes().get(0).getText().equals("SAIBA COMO ENVIAR");
	}

	public boolean exibiuBotaoEnviarSuaNoticia() {
		return listaDeBotoes().get(1).getText().equals("ENVIAR SUA NOTÍCIA");
	}

	public boolean exibiuUmLinkConfiguradoNoBotaoSaibaComoEnviar() {
		return !listaDeBotoes().get(0).getAttribute("href").isEmpty();
	}
	
	public boolean exibiuUmLinkConfiguradoCorretamenteNoBotaoEnviarSuaNoticia() {
		String urlEsperada = "participe/Default.asp?cache=false";
		String urlAtual = listaDeBotoes().get(1).getAttribute("href");
		return urlAtual.contains(urlEsperada);
	}
	
	public void clicarNoBotaoDeEnviar() {
		getDriver().findElement(By.linkText("ENVIAR SUA NOTÍCIA")).click();
	}
	
	public WebElement exibiuHeaderDoFormulario() {
		return getDriver().findElement(By.className("body")).findElement(By.className("header"));
	}
	
	public WebElement exibiuFormulario() {
		return getDriver().findElement(By.className("body")).findElement(By.className("form-estudante"));
	}
	
	public boolean exibiuPaginaDeUploadDoEuReporter() {
		return exibiuFormulario().isDisplayed();
	}
	
	public boolean exibiuNoHeaderOTituloEuReporter() {
		return exibiuHeaderDoFormulario().findElement(By.className("title")).isDisplayed();
	}

	public boolean exibiuNoHeaderOBotaoDeComoParticipar() {
		return exibiuHeaderDoFormulario().findElement(By.className("participe")).findElement(By.id("participe-text-link")).isDisplayed();
	}

	public String exibiuNoBotaoDeComoParticiparOTituloCorreto() {
		return exibiuHeaderDoFormulario().findElement(By.className("participe")).findElement(By.id("participe-text-link")).getText();
	}

	public void clicarNoBotaoComoParticipar() {
		exibiuHeaderDoFormulario().findElement(By.id("participe-text-link")).click();
	}

	public boolean exibiuORegulamentoCorretamente() {
		return getDriver().findElement(By.className("lBox")).findElement(By.id("participe-text")).isDisplayed();
	}

	public void clicarParaFecharORegulamento() {
		getDriver().findElement(By.cssSelector("a.closeBox")).click();
	}
	
	public List<WebElement> listaDeLabelDeInfoUser() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElements(By.className("field"));
	}
	
	public String exibiuOTituloNome() {
		return listaDeLabelDeInfoUser().get(0).findElement(By.tagName("label")).getText();
	}

	public boolean exibiuONomePreenchido() {
		return !listaDeLabelDeInfoUser().get(0).findElement(By.id("nome")).getAttribute("value").isEmpty();
	}

	public String exibiuOTituloEmail() {
		return listaDeLabelDeInfoUser().get(1).findElement(By.tagName("label")).getText();
	}

	public boolean exibiuOEmailPreenchido() {
		return !listaDeLabelDeInfoUser().get(1).findElement(By.id("email")).getAttribute("value").isEmpty();
	}

	public String exibiuOTituloTelefone() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("fieldPhone")).findElement(By.tagName("label")).getText();
	}

	public boolean exibiuCampoDDDDoTelefoneEmBranco() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("fieldPhone")).findElement(By.id("ddd")).getAttribute("value").isEmpty();
	}

	public boolean exibiuCampoDoTelefoneEmBranco() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("fieldPhone")).findElement(By.id("telefone")).getAttribute("value").isEmpty();
	}

	public Object exibiuOTituloMinhaNoticia() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("fieldFull")).findElement(By.tagName("label")).getText();
	}

	public boolean exibiuCampoMinhaNoticiaEmBranco() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("fieldFull")).findElement(By.id("pergunta")).getAttribute("value").isEmpty();
	}

	public String exibiuOTituloDoCaptcha() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("captcha")).findElement(By.tagName("label")).getText();
	}

	public boolean exibiuImagemDoCaptcha() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("captcha")).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuCampoCampoDeCaptcha() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("captcha")).findElement(By.tagName("input")).isDisplayed();
	}

	public boolean exibiuLinkDeGerarCaptcha() {
		return exibiuFormulario().findElement(By.className("infoUser")).findElement(By.className("captcha")).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuOTituloDosArquivos() {
		return exibiuFormulario().findElement(By.className("filesUser")).findElement(By.tagName("label")).getText();
	}
	
	public List<WebElement> listaDeInputsDeArquivosPelaClasseMidia() {
		return exibiuFormulario().findElement(By.className("filesUser")).findElements(By.className("midia"));
	}
	
	public boolean exibiuCincoInputsDeArquivos() {
		return listaDeInputsDeArquivosPelaClasseMidia().size() == Integer.parseInt("5");
	}
	
	public List<WebElement> listaDeInputsDeArquivos() {
		return exibiuFormulario().findElement(By.className("filesUser")).findElements(By.tagName("input"));
	}
	
	public boolean exibiuBotaoDeRemoverArquivos() {
		return listaDeInputsDeArquivos().get(listaDeInputsDeArquivos().size() - 1).isDisplayed();
	}

	public String exibiuTituloDeRemoverArquivos() {
		return listaDeInputsDeArquivos().get(listaDeInputsDeArquivos().size() - 1).getAttribute("value");
	}

	public String exibiuTituloDeTermosDeUso() {
		return exibiuFormulario().findElement(By.className("terms")).findElement(By.tagName("span")).getText();
	}

	public boolean exibiuOBoxDeRegulamento() {
		return !exibiuFormulario().findElement(By.className("terms")).findElement(By.className("regulamento")).getText().isEmpty();
	}
	
	public List<WebElement> listaDeSpanDentroDeRegulamento() {
		return exibiuFormulario().findElement(By.className("terms")).findElements(By.tagName("span"));
	}
	
	public boolean exibiuOCheckBoxDeTermosDeCompromisso() {
		return listaDeSpanDentroDeRegulamento().get(1).findElement(By.tagName("input")).getAttribute("type").equals("checkbox");
	}

	public String exibiuOTituloDosTermosDeCompromisso() {
		return listaDeSpanDentroDeRegulamento().get(1).getText();
	}

	public boolean exibiuOBotaoDeEnviarNoFimDaPagina() {
		return exibiuFormulario().findElement(By.className("send")).findElement(By.tagName("input")).getAttribute("type").equals("submit");
	}
}