package pages.materia.comentario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaComBotaoMaisComentarios extends AceitacaoAbstractTest {
	
	public MateriaComBotaoMaisComentarios() throws Exception {
		super();
	}
	
	public MateriaComBotaoMaisComentarios(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void esperaCaixaDeComentarioCarregar(){
		while(! getDriver().findElement(By.className("comentarios")).isDisplayed()){
			if(getDriver().findElement(By.className("comentarios")).isDisplayed()){
				break;
			}
		}
	}
	
	public WebElement getBoxComentario(){
		return getDriver().findElement(By.className("comentarios"));
	}

	public WebElement getClasseComentario(){
		return getBoxComentario().findElement(By.className("lista-comentarios"));
	}
	
	public List<WebElement> getListaComentario(){
		return getClasseComentario().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public int getClassesRespostasPreenchidas(){
		
		List<WebElement> listaDeClasseResposta = getDriver().findElement(By.className("lista-comentarios")).findElement(By.tagName("ul")).findElements(By.className("respostas"));
		int contadorUl = 0;
		
		for(int i = 0; i < listaDeClasseResposta.size(); i++){
			if(listaDeClasseResposta.get(i).findElements(By.tagName("ul")).size() > 0){
				contadorUl ++;
			}
		}
		return contadorUl;
	}
	
	public int getBoxTotalListaComentario(){
		return getListaComentario().size() - getClassesRespostasPreenchidas();
	}
	
	public boolean exibiu5PrimeirosComentarios(){
		return getBoxTotalListaComentario() == Integer.parseInt("5");
	}
	
	public WebElement exibiuBotaoDeMaisComentario(){
		return getClasseComentario().findElement(By.className("more"));
	}
	
	public String getTextoBotaoMaisComentarios(){
		return getClasseComentario().findElement(By.className("more")).getText().toLowerCase();
	}
	
	
	public boolean getBoxListaComentario10() throws InterruptedException{
		Thread.sleep(5000);
		//getDriver().findElement(By.cssSelector("a.button.mais-comentarios")).click();
		//getDriver().findElement(By.xpath("//a[contains(text(),'Carregar mais comentários')]")).click();
		getDriver().findElement(By.xpath("/html/body/div[3]/article/div[4]/div[1]/div/div[7]/div[2]/p/a")).click();
		List<WebElement> novoResultado = getDriver().findElement(By.className("lista-comentarios")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
		return novoResultado.size() == Integer.parseInt("10");
	}
	
	public boolean getBoxListaComentario15() throws InterruptedException{
		//getDriver().findElement(By.cssSelector("body > div:nth-child(3) > article > div:nth-child(3) > div:nth-child(1) > div > div.comentarios > div.lista-comentarios > p > a")).click();
		Thread.sleep(1000);
		List<WebElement> novoResultado = getDriver().findElement(By.className("lista-comentarios")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
		return novoResultado.size() == 15; 
	}
	
	public boolean getBotaoMaisComentarios() throws InterruptedException{
		Thread.sleep(3000);
		List<WebElement> novoResultado = getDriver().findElements(By.xpath("/html/body/article/div[3]/div/div/div[2]/div[2]/p/a"));
		return novoResultado.size() == 0;
	}
}