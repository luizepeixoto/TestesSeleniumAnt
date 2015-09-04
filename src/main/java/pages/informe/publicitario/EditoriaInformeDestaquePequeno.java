package pages.informe.publicitario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EditoriaInformeDestaquePequeno extends AceitacaoAbstractTest {
	
	public EditoriaInformeDestaquePequeno() throws Exception {
		super();
	}
	
	public EditoriaInformeDestaquePequeno(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuClasseEspecialPublicitario() {
		return getDriver().findElement(By.className("capa"));
	}

	public WebElement exibiuChamadaDeEspecialPublicitario() {
		return exibiuClasseEspecialPublicitario().findElement(By.className("sub-editoria")).findElement(By.tagName("span"));
	}
	
	public String exibiuTituloEspecialPublicitario() {
		return exibiuClasseEspecialPublicitario().findElement(By.className("sub-editoria")).findElement(By.tagName("span")).getText();
	}

	public WebElement exibiuDestaque() {
		return exibiuClasseEspecialPublicitario().findElement(By.className("destaque-horizontal")); 
	}

	public boolean exibiuFotoDoDestaque() {
		return exibiuDestaque().findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuFotoDoDestaqueComLink() {
		return exibiuDestaque().findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuFotoDoDestaqueComUmLinkValido() {
		return !exibiuDestaque().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public String getHeightDestaquePrincipal() {
		return exibiuDestaque().findElement(By.tagName("img")).getAttribute("height");
	}

	public String getWidthDestaquePrincipal() {
		return exibiuDestaque().findElement(By.tagName("img")).getAttribute("width");
	}

	public boolean exibiuTituloNoDestaque() {
		return !exibiuDestaque().findElement(By.className("titulo")).getText().isEmpty();
	}

	public boolean exibiuTituloComOMaximo99Caracteres() {
		return exibiuDestaque().findElement(By.className("titulo")).getText().length() <= 99;
	}

	public boolean exibiuLinkNoTituloDoDestaque() {
		return exibiuDestaque().findElement(By.className("titulo")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoTituloDoDestaque() {
		return !exibiuDestaque().findElement(By.className("titulo")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuDescricaoDoDestaque() {
		return !exibiuDestaque().findElement(By.className("subtitulo")).getText().isEmpty();
	}
	
	public boolean exibiuSubtituloDoDestaqueComnoMaximo143Caracteres() {
		return exibiuDestaque().findElement(By.className("subtitulo")).getText().length() <= 143;
	}

	public WebElement exibiuClasseDestaquesLista() {
		return getDriver().findElement(By.className("destaques-editaveis")).findElement(By.className("destaques-lista"));
	}
	
	public List<WebElement> listaTotalDeDestaquesSecundarios() {
		return exibiuClasseDestaquesLista().findElements(By.className("inner-border"));
	}
	
	public boolean exibiuListaDeDestaquesSecundarios() {
		return listaTotalDeDestaquesSecundarios().size() > 0;
	}

	public boolean exibiuDestaquesSecundariosComFoto() {
		for(int i=0; i<listaTotalDeDestaquesSecundarios().size(); i++){
			if(!listaTotalDeDestaquesSecundarios().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuWidthDosDestaquesSecundariosCorreto() {
		for(int i=0; i<listaTotalDeDestaquesSecundarios().size(); i++){
			if(!listaTotalDeDestaquesSecundarios().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("width").equals("234")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuHeightDosDestaquesSecundariosCorreto() {
		for(int i=0; i<listaTotalDeDestaquesSecundarios().size(); i++){
			if(!listaTotalDeDestaquesSecundarios().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("height").equals("140")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNaFotoDosDestaquesSecundarios() {
		for(int i=0; i<listaTotalDeDestaquesSecundarios().size(); i++){
			if(!listaTotalDeDestaquesSecundarios().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloNosDestaquesSecundarios() {
		for(int i=0; i<listaTotalDeDestaquesSecundarios().size(); i++){
			if(listaTotalDeDestaquesSecundarios().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloDosDestaquesSecundariosComOMaximoDeCaracteres() {
		for(int i=0; i<listaTotalDeDestaquesSecundarios().size(); i++){
			if(listaTotalDeDestaquesSecundarios().get(i).findElement(By.tagName("h2")).getText().length() >= 66){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloMaisSobreAEditoria() {
		return !getDriver().findElement(By.className("mais-sobre-titulo")).getText().isEmpty();
	}
	
	public List<WebElement> listaDeMaterias() {
		return getDriver().findElement(By.id("ultimasNoticias")).findElements(By.tagName("li"));
	}

	public boolean exibiuListaDeOutrasMaterias() {
		return listaDeMaterias().size() > 0;
	}

	public boolean exibiuFotoOuDescricaoParaAsMaterias() {
		for(int i=0; i<listaDeMaterias().size(); i++){
			List<WebElement> possuiFotoNaPosicaoAtual = listaDeMaterias().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicaoAtual.size() > 0){
				if(!listaDeMaterias().get(i).findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed()){
					return false;
				}
			}else{
				if(listaDeMaterias().get(i).findElement(By.tagName("span")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuTituloParaAsMaterias() {
		for(int i=0; i<listaDeMaterias().size(); i++){
			if(listaDeMaterias().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTempoDePostagemParaAsMaterias() {
		for(int i=0; i<listaDeMaterias().size(); i++){
			if(listaDeMaterias().get(i).findElement(By.className("tempo")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuBannerSuperLeaderboardDoInformePublicitarioNoTopoDaPagina() {
		List<WebElement> exibiuSuperLeaderBoard = exibiuClasseEspecialPublicitario().findElements(By.className("super-leaderboard"));
		return exibiuSuperLeaderBoard.size() > Integer.parseInt("0");
	}
	
	public boolean exibiuBannerDoInformePublicitarioNoFimDaPagina() {
		List<WebElement> exibiuBannerPatrocinado = exibiuClasseEspecialPublicitario().findElements(By.className("pub-materia-patrocinada"));
		return exibiuBannerPatrocinado.size() == Integer.parseInt("1");
	}

	public boolean exibiuBannerDoGloboShoppingNoFimDaPagina() {
		List<WebElement> exibiuGloboShopping = exibiuClasseEspecialPublicitario().findElements(By.className("globosh"));
		return exibiuGloboShopping.size() == Integer.parseInt("0");
	}
	
}
