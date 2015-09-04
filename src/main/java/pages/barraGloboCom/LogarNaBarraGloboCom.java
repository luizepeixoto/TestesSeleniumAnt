package pages.barraGloboCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import pages.barreira.Degustacao;

import assistente.Assistente;
import br.com.infoglobo.pages.Navegador;

public class LogarNaBarraGloboCom extends Degustacao{
	
	public LogarNaBarraGloboCom(Navegador navegador) throws Exception{
		super(navegador);
	}

	public Cookie obterNomeCookie(String nomeDoCookie) throws InterruptedException {
		Assistente assistente = new Assistente();
		return assistente.obterNomeCookie(nomeDoCookie, getDriver());
	}	

	public boolean verificaSeExisteOCookieGlbid() throws InterruptedException {
		String cookieUtilizado = "GLBID";
		Cookie cookieGLBID = obterNomeCookie(cookieUtilizado);
			
		try {
			
			if (cookieGLBID.toString().contains(cookieUtilizado)){
				System.out.println("O cookie " + cookieUtilizado + " existe!");
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("O cookie " + cookieUtilizado + " não existe!");
		}
		
		return false;
	}
	
	public boolean verificaSeExisteOCookieInfgCadun() throws InterruptedException {
		String cookieUtilizado = "INFGCADUN";
		Cookie cookieINFGCADUN = obterNomeCookie(cookieUtilizado);
			
		try {
			
			if (cookieINFGCADUN.toString().contains(cookieUtilizado)){
				System.out.println("O cookie " + cookieUtilizado + " existe!");
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("O cookie " + cookieUtilizado + " não existe!");
		}
		
		return false;
	}
	
	public List<WebElement> listaDeMateriasDaCapa() {
		List<WebElement> materiaComComentario = getDriver().findElement(By.className("col-left")).findElements(By.className("editorias"));
		
		return materiaComComentario;		
	}

	public void localizarEClicarEmMateriaComComentario() {
		int qtde = listaDeMateriasDaCapa().size();
		
		for(int i=0; i<=qtde; i++){
			executarScroll(listaDeMateriasDaCapa().get(i).getLocation());
			try {
				listaDeMateriasDaCapa().get(i).findElement(By.className("comments")).click();
				break;
			} catch (Exception e) {
				System.out.println("Não contém matéria com comentário aberto");
			}
		}
			
	}

	public void clicarNoBotaoComentar() {
		getDriver().findElement(By.className("comentarios")).findElement(By.className("btn")).findElement(By.tagName("a")).click();
	}

	public void deslogarNaBarraDaGloboCom() throws InterruptedException {
		executarScroll(getDriver().findElement(By.id("barra-globocom")).getLocation());
		
		esperaBannerFlashFechar();
		
		WebElement usuarioLogadoNaBarraDaGloboCom = getDriver().findElement(By.id("barra-auth-area")).findElement(By.className("barra-user-area")).findElement(By.tagName("a"));
		
		usuarioLogadoNaBarraDaGloboCom.click();
		
		WebElement clicarNoBotaoSair = getDriver().findElement(By.className("barra-user-area")).findElement(By.className("right")).findElement(By.tagName("a"));
		
		clicarNoBotaoSair.click();
	}
}