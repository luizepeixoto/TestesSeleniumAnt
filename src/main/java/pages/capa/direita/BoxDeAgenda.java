package pages.capa.direita;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxDeAgenda extends AceitacaoAbstractTest {
	
	public BoxDeAgenda(Navegador navegador) throws Exception{
		super(navegador);
	}

	public boolean exibiuOBoxDeAgendaNaHome() {
		return obterBoxDeAgenda().isDisplayed();
	}

	public boolean exibiuOTituloDaAgendaNaHome() {
		return ! obterTituloDaAgenda().getText().isEmpty();
	}

	public boolean exibiuOCalendarioDaAgendaNaHome() {
		return obterBoxDoCalendario().isDisplayed();
	}

	public boolean exibiuOMesNoCalendarioIgualAoMesAtual() {
		Locale pais = new Locale("pt","BR");
		DateFormat formatoData = new SimpleDateFormat("MMMM", pais);
		String mesAtual = formatoData.format(new Date());
		return obterMesAtualDaAgenda().getText().equalsIgnoreCase(mesAtual);
	}

	public boolean exibiuOAnoNoCalendarioIgualAoAnoAtual() {
		DateFormat formatoData = new SimpleDateFormat("yyyy");
		String anoAtual = formatoData.format(new Date());
		return obterAnoAtualDaAgenda().getText().equalsIgnoreCase(anoAtual);
	}

	public boolean exibiuOBotaoAnteriorNoCalendario() {
		return obterBotaoAnterior().isDisplayed();
	}

	public boolean exibiuOTitleDoBotaoAnteriorNoCalendario() {
		String titleEsperado = "Anterior";
		return obterBotaoAnterior().getAttribute("title").equalsIgnoreCase(titleEsperado);
	}

	public boolean exibiuOBotaoProximoNoCalendario() {
		return obterBotaoProximo().isDisplayed();
	}

	public boolean exibiuOTitleDoBotaoProximoNoCalendario() {
		String titleEsperado = "Próximo";
		return obterBotaoProximo().getAttribute("title").equalsIgnoreCase(titleEsperado);
	}

	public boolean exibiuOsSetesDiasDaSemana() {
		return obterListaDosDiasDaSemana().size() == 7;
	}
	
	public boolean exibiuASiglaDosDiasDaSemana() {
		int qtdeDias = obterListaDosDiasDaSemana().size();
		
		for (int i = 0; i < qtdeDias; i++) {
			if (obterListaDosDiasDaSemana().get(i).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOsDiasDoMes() {
		int qtdeDias = obterListaDosDiasDoMes().size();
		
		for (int i = 0; i < qtdeDias; i++) {
			if (obterListaDosDiasDoMes().get(i).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public boolean exibiuODiaAtualCorretamente() {
		DateFormat formatoData = new SimpleDateFormat("d");
		String hoje = formatoData.format(new Date());
		
		return obterDiaAtual().getText().equals(hoje);
	}
	
	public boolean exibiuODiaAtualMarcadoComACorPadrao() {
		String padraoDeMarcacao = "rgba(30, 150, 200, 1)";
		return obterDiaAtual().findElement(By.tagName("a")).getCssValue("background-color").equals(padraoDeMarcacao);
	}

	public boolean exibiuOsDiasAnterioresAoDiaAtualDesabilitados() {
		int qtde = obterListaDosDiasDoMes().size();
		
		for (int i = 0; i < qtde; i++) {
			if (obterListaDosDiasDoMes().get(i).getAttribute("class").contains("datepicker-current-day")) {
				break;
			} else {
				if (! obterListaDosDiasDoMes().get(i).getAttribute("class").contains("ui-datepicker-unselectable")) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuOEventoDeUmDiaNoBoxDeAgenda() {
		clicarEmUmDiaAleatorioNoCalendario();
		return ! obterEventoExibido().getText().isEmpty();
	}
	
	public boolean exibiuOTituloDoEvento() {
		return ! obterEventoExibido().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuADataDoEventoIgualAoDiaSelecionado() {
		String textoEvento = obterEventoExibido().findElement(By.tagName("p")).getText();
		String diaDoEventoExibido = textoEvento.substring(0, textoEvento.indexOf("/"));
		String diaSelecionado = obterDiaSelecionado().getText();
		return diaDoEventoExibido.equals(diaSelecionado);
	}

	public boolean exibiuOLinkParaAAgenda() {
		return ! obterLink().getAttribute("href").isEmpty();
	}
	
	protected WebElement obterBoxDeAgenda() {
		return getDriver().findElement(By.className("agenda"));
	}
	
	protected WebElement obterTituloDaAgenda() {
		return obterBoxDeAgenda().findElement(By.className("legenda"));
	}
	
	protected WebElement obterBoxDoCalendario() {
		return obterBoxDeAgenda().findElement(By.id("datepicker"));
	}
	
	protected WebElement obterMesAtualDaAgenda() {
		return obterBoxDoCalendario().findElement(By.className("ui-datepicker-month"));
	}
	
	protected WebElement obterAnoAtualDaAgenda() {
		return obterBoxDoCalendario().findElement(By.className("ui-datepicker-year"));
	}
	
	protected WebElement obterBotaoAnterior() {
		return obterBoxDoCalendario().findElement(By.className("ui-datepicker-prev"));
	}
	
	protected WebElement obterBotaoProximo() {
		return obterBoxDoCalendario().findElement(By.className("ui-datepicker-next"));
	}
	
	protected WebElement obterCalendario() {
		return obterBoxDoCalendario().findElement(By.className("ui-datepicker-calendar"));
	}
	
	protected List<WebElement> obterListaDosDiasDaSemana() {
		return obterCalendario().findElement(By.tagName("thead")).findElements(By.tagName("th"));
	}
	
	protected List<WebElement> obterListaDosDiasDoMes() {
		return obterCalendario().findElement(By.tagName("tbody")).findElements(By.xpath("//td[contains(@data-handler,'selectDay')]"));
	}
	
	protected WebElement obterDiaAtual() {
		return obterCalendario().findElement(By.tagName("tbody")).findElement(By.className("ui-datepicker-today"));
	}
	
	protected List<WebElement> obterListaDosDiasDoMesQuePodemSerClicadosExcetoODiaJaSelecionado() {
		return obterCalendario().findElement(By.tagName("tbody")).findElements(By.xpath("//td[contains(@data-handler,'selectDay')][not(contains(@class, 'ui-datepicker-unselectable'))][not(contains(@class, 'ui-datepicker-current-day'))]"));
	}
	
	protected void clicarEmUmDiaAleatorioNoCalendario() {
		int qtde = obterListaDosDiasDoMesQuePodemSerClicadosExcetoODiaJaSelecionado().size();
		int numeroAleatorio = new Random().nextInt(qtde);
		executarScroll(obterBoxDeAgenda().getLocation().toString());
		obterListaDosDiasDoMesQuePodemSerClicadosExcetoODiaJaSelecionado().get(numeroAleatorio).click();
	}
	
	protected WebElement obterEventoExibido() {
		return obterBoxDeAgenda().findElement(By.xpath("div[contains(@class, 'item')][not(contains(@style, 'display'))]"));
	}
	
	protected WebElement obterDiaSelecionado() {
		return obterCalendario().findElement(By.tagName("tbody")).findElement(By.className("ui-datepicker-current-day"));
	}
	
	protected WebElement obterLink() {
		return obterBoxDeAgenda().findElement(By.className("listaCompletaEventos"));
	}
}