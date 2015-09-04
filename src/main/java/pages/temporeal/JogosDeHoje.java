package pages.temporeal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class JogosDeHoje extends AceitacaoAbstractTest {

	public JogosDeHoje(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement exibiuJogosDeHoje() {
		return getDriver().findElement(By.className("jogos-de-hoje"));
	}
	
	public String exibiuTituloJogosDeHoje() {
		return exibiuJogosDeHoje().findElement(By.tagName("h2")).getText();
	}
	
	public List<WebElement> listaTotalComJogos(){
		return getDriver().findElement(By.className("lista-jogos-hoje")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaListaComOsJogosDehoje() {
		return listaTotalComJogos().size() >= Integer.parseInt("0");
	}

	public boolean exibiuOHorarioDosJogos() {
		for(int i=0; i<listaTotalComJogos().size(); i++){
			if(listaTotalComJogos().get(i).findElement(By.className("tempo-jogo-hoje")).findElement(By.tagName("p")).findElement(By.tagName("b")).getAttribute("innerHTML").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOsEscudosDosTimes() {
		for(int i=0; i<listaTotalComJogos().size(); i++){
			if(!listaTotalComJogos().get(i).findElement(By.className("times-jogos-hoje")).findElement(By.className("time-jogos-hoje-A")).findElement(By.tagName("img")).isDisplayed() 
				&& !listaTotalComJogos().get(i).findElement(By.className("times-jogos-hoje")).findElement(By.className("time-jogos-hoje-B")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOPlacarDosJogos() {
		for(int i=0; i<listaTotalComJogos().size(); i++){
			if(!listaTotalComJogos().get(i).findElement(By.className("times-jogos-hoje")).findElement(By.className("placar-jogos-hoje")).findElement(By.tagName("p")).getAttribute("textContent").equals("0X0")){
				return false;
			}
		}
		return true;
	}
}
