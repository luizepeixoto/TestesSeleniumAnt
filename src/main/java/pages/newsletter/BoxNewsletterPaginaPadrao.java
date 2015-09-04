package pages.newsletter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxNewsletterPaginaPadrao extends AceitacaoAbstractTest {
	
	private static final String EMAIL_VALIDO = "oglobonewsletter@yahoo.com.br";
	private static final String EMAIL_INVALIDO = "infoglobo";
	private static final String EMAIL_ATIVADO = "testecadun@hotmail.com";

	public BoxNewsletterPaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}

	protected WebElement obterBoxDeNewsletter() {
		return getDriver().findElement(By.className("newsletters"));
	}
	
	public boolean exibiuOBoxDeNewsletter() {
		return obterBoxDeNewsletter().isDisplayed();
	}
	
	private WebElement obterTituloDoBoxDeNewsletter() {
		return obterBoxDeNewsletter().findElement(By.tagName("h3"));
	}
	
	public boolean exibiuOTituloDoBoxDeNewsletter() {
		if (! obterTituloDoBoxDeNewsletter().isDisplayed()) {
			System.out.println("O elemento título do box não está sendo exibido.");
			return false;
		}
		
		if (! obterTituloDoBoxDeNewsletter().getText().equalsIgnoreCase("Newsletters")) {
			System.out.println("O valor do elemento título do box não está sendo exibido conforme esperado.");
			return false;
		}
		return true;
	}
	
	private WebElement obterFormDoBoxDeNewsletter() {
		return obterBoxDeNewsletter().findElement(By.className("form"));
	}
	
	private WebElement obterInputDoBoxDeNewsletter() {
		return obterFormDoBoxDeNewsletter().findElement(By.tagName("input"));
	}
	
	public boolean exibiuOInputDoBoxDeNewsletter() {
		return obterInputDoBoxDeNewsletter().isDisplayed();
	}
	
	private void limparInputDoBoxDeNewsletter() {
		obterInputDoBoxDeNewsletter().clear();
	}
	
	protected void preencherInputDoBoxDeNewsletter(String email) {
		obterInputDoBoxDeNewsletter().sendKeys(email);
	}
	
	private String obterPlaceHolderDoInputDoBoxDeNewsletter() {
		return obterInputDoBoxDeNewsletter().getAttribute("placeholder");
	}
	
	public boolean exibiuOPlaceHolderDoIntputDoBoxDeNewsletter() {
		return ! obterPlaceHolderDoInputDoBoxDeNewsletter().isEmpty();
	}
	
	private WebElement obterBotaoReceberDoBoxDeNewsletter() {
		return obterFormDoBoxDeNewsletter().findElement(By.tagName("button"));
	}
	
	public boolean exibiuOBotaoReceberDoBoxDeNewsletter() {
		return obterInputDoBoxDeNewsletter().isDisplayed();
	}
	
	private void clicarNoBotaoReceberDoBoxDeNewsletter() throws InterruptedException {
		obterBotaoReceberDoBoxDeNewsletter().click();
	}
	
	private WebElement obterAreaDeErroNoEmailDoBoxDeNewsletter() {
		return obterBoxDeNewsletter().findElement(By.xpath("span[contains(@data-ng-class, '!erroEmail')]"));
	}
	
	public boolean exibiuMensagemDeErroAoNaoInformarUmEmail() throws InterruptedException {
		clicarNoBotaoReceberDoBoxDeNewsletter();
		//Elemento area de erro
		if (! obterAreaDeErroNoEmailDoBoxDeNewsletter().isDisplayed()) {
			System.out.println("O elemento area de erro não está sendo exibido.");
			return false;
		}
		//Valor Elemento area de erro
		if (! obterAreaDeErroNoEmailDoBoxDeNewsletter().getText().equals("Email inválido.")) {
			System.out.println("O valor do elemento area de erro não esta sendo exibido conforme o esperado.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuMensagemDeErroAoInformarEmailInvalido() throws InterruptedException {
		preencherInputDoBoxDeNewsletter(EMAIL_INVALIDO);
		clicarNoBotaoReceberDoBoxDeNewsletter();
		//Elemento area de erro
		if (! obterAreaDeErroNoEmailDoBoxDeNewsletter().isDisplayed()) {
			System.out.println("O elemento area de erro não está sendo exibido.");
			return false;
		}
		//Valor Elemento area de erro
		if (! obterAreaDeErroNoEmailDoBoxDeNewsletter().getText().equals("Email inválido.")) {
			System.out.println("O valor do elemento area de erro não esta sendo exibido conforme o esperado.");
			return false;
		}
		return true;
	}
	
	public boolean exibiuUmIconeDeLoadingNoBotaoReceber() throws InterruptedException {
		limparInputDoBoxDeNewsletter();
		preencherInputDoBoxDeNewsletter(EMAIL_ATIVADO);
		clicarNoBotaoReceberDoBoxDeNewsletter();
		return obterBotaoReceberDoBoxDeNewsletter().getAttribute("class").equals("btn_load");
	}
	
	private void esperaAcabarOLoadingDoBotaoReceber() {
		while (obterBotaoReceberDoBoxDeNewsletter().getAttribute("class").equals("btn_load")) {
			
		}
	}
	
	private WebElement obterAreaDeErroDeRequisicaoDoBoxDeNewsletter() {
		return obterBoxDeNewsletter().findElement(By.xpath("span[contains(@data-ng-class, '!erroRequisicao')]"));
	}
	
	public boolean exibiuMensagemDeErroAoInformarEmailAtivado() throws InterruptedException {
		esperaAcabarOLoadingDoBotaoReceber();
		//Elemento area de erro
		if (! obterAreaDeErroDeRequisicaoDoBoxDeNewsletter().isDisplayed()) {
			System.out.println("O elemento area de erro não está sendo exibido.");
			return false;
		}
		//Valor Elemento area de erro
		if (! obterAreaDeErroDeRequisicaoDoBoxDeNewsletter().getText().equals("Ocorreu um erro.\nTente novamente mais tarde.")) {
			System.out.println("O valor do elemento area de erro não esta sendo exibido conforme o esperado.");
			return false;
		}
		return true;
	}
	
	private WebElement obterAreaDeSucessoDoBoxDeNewsletter() {
		return obterBoxDeNewsletter().findElement(By.className("news-options-success"));
	}
	
	public boolean exibiuMensagemDeSucessoAoInformarEmailValido() throws InterruptedException {
		limparInputDoBoxDeNewsletter();
		preencherInputDoBoxDeNewsletter(EMAIL_VALIDO);
		clicarNoBotaoReceberDoBoxDeNewsletter();
		esperaAcabarOLoadingDoBotaoReceber();
		//Elemento area de sucesso
		if (! obterAreaDeSucessoDoBoxDeNewsletter().isDisplayed()) {
			System.out.println("O elemento area de sucesso não está sendo exibido.");
			return false;
		}
		//Valor Elemento area de sucesso
		if (! obterAreaDeSucessoDoBoxDeNewsletter().getText().equals("Quase pronto...\nAcesse sua caixa de e-mail e confirme sua inscrição para\ncomeçar a receber nossa newsletter.")) {
			System.out.println("O valor do elemento area de sucesso não esta sendo exibido conforme o esperado.");
			return false;
		}
//		//Estilo texto quase pronto
//		if (! obterAreaDeSucessoDoBoxDeNewsletter().isDisplayed()) {
//			System.out.println("O elemento area de sucesso não está sendo exibido.");
//			return false;
//		}
//		//Estilo demais texto
//		if (! obterAreaDeSucessoDoBoxDeNewsletter().getText().equals("Quase pronto...\nAcesse sua caixa de e-mail e confirme sua inscrição para\ncomeçar a receber nossa newsletter.")) {
//			System.out.println("O valor do elemento area de sucesso não esta sendo exibido conforme o esperado.");
//			return false;
//		}
		return true;
	}
	
	private WebElement obterSetaVerdeDoBoxDeNewsletter() {
		return obterAreaDeSucessoDoBoxDeNewsletter().findElement(By.className("fa-check"));
	}
	
	public boolean exibiuUmaSetaVerdeAoInformarEmailValido() {
		//Elemento seta verde
		if (! obterSetaVerdeDoBoxDeNewsletter().isDisplayed()) {
			System.out.println("O elemento seta verde não está sendo exibido.");
			return false;
		}
		//Cor Elemento seta verde
		if (! obterSetaVerdeDoBoxDeNewsletter().getCssValue("color").equals("rgba(255, 255, 255, 1)")) {
			System.out.println("A cor do elemento area de sucesso não esta sendo exibido conforme o esperado.");
			return false;
		}
		//Cor de fundo Elemento seta verde
		if (! obterSetaVerdeDoBoxDeNewsletter().getCssValue("background-color").equals("rgba(159, 197, 77, 1)")) {
			System.out.println("A cor de fundo do elemento area de sucesso não esta sendo exibido conforme o esperado.");
			return false;
		}
		//Tamanho Elemento seta verde
		if (! obterSetaVerdeDoBoxDeNewsletter().getCssValue("font-size").equals("20px")) {
			System.out.println("O tamanho do elemento area de sucesso não esta sendo exibido conforme o esperado.");
			return false;
		}
		return true;
	}
	
	private WebElement obterTextoMaiorDoBoxDeNewsletter() {
		return obterAreaDeSucessoDoBoxDeNewsletter().findElement(By.tagName("span"));
	}
	
	public boolean exibiuUmTextoMaiorAoInformarEmailValido() {
		//Cor Elemento texto maior
		if (! obterTextoMaiorDoBoxDeNewsletter().getCssValue("color").equals("rgba(28, 49, 77, 1)")) {
			System.out.println("A cor do elemento texto maior não esta sendo exibido conforme o esperado.");
			return false;
		}
		//Tamanho Elemento texto maior
		if (! obterTextoMaiorDoBoxDeNewsletter().getCssValue("font-size").equals("28px")) {
			System.out.println("O tamanho do elemento texto maior não esta sendo exibido conforme o esperado.");
			return false;
		}
		//Peso Elemento texto maior
		if (! obterTextoMaiorDoBoxDeNewsletter().getCssValue("font-weight").equals("600")) {
			System.out.println("O peso do elemento texto maior não esta sendo exibido conforme o esperado.");
			return false;
		}
		//Margem Elemento texto maior
		if (! obterTextoMaiorDoBoxDeNewsletter().getCssValue("margin").equals("0px 0px 0px 50px")) {
			System.out.println("A margem do elemento texto maior não esta sendo exibido conforme o esperado.");
			return false;
		}
		return true;
	}
	
	private WebElement obterDemaisTextosDoBoxDeNewsletter() {
		return obterAreaDeSucessoDoBoxDeNewsletter().findElement(By.tagName("p"));
	}
	
	public boolean exibiuDemaisTextosAoInformarEmailValido() {
		//Cor Elemento demais textos
		if (! obterDemaisTextosDoBoxDeNewsletter().getCssValue("color").equals("rgba(28, 49, 77, 1)")) {
			System.out.println("A cor do elemento demais textos não esta sendo exibido conforme o esperado.");
			return false;
		}
		//Tamanho Elemento demais textos
		if (! obterDemaisTextosDoBoxDeNewsletter().getCssValue("font-size").equals("19px")) {
			System.out.println("O tamanho do elemento demais textos não esta sendo exibido conforme o esperado.");
			return false;
		}
		//Margem Elemento demais textos
		if (! obterDemaisTextosDoBoxDeNewsletter().getCssValue("margin").equals("0px 0px 10px 50px")) {
			System.out.println("A margem do elemento demais textos não esta sendo exibido conforme o esperado.");
			return false;
		}
		return true;
	}
}