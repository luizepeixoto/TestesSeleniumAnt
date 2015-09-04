package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioMancheteInformePublicitario extends AceitacaoAbstractTest {
	
	public CapaMeioMancheteInformePublicitario() throws Exception {
		super();
	}
	
	public List<WebElement> listaDeMateriasNaCapaDoMeio(){
		return getDriver().findElement(By.className("main-home")).findElements(By.className("retranca-esp-pub-home"));
	}
	
	public boolean exibiuInformePublicitarioNaColunaDoMeio() {
		return listaDeMateriasNaCapaDoMeio().size() > Integer.parseInt("0");
	}
	
	public boolean exibiuTituloEspecialPublicitarioNasChamadasDaColunaDoMeio() {
		for(int i=0; i<listaDeMateriasNaCapaDoMeio().size(); i++){
			if(!listaDeMateriasNaCapaDoMeio().get(i).findElement(By.tagName("b")).getText().equals("Especial Publicitário")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloDaMateriaEmItalico() {
		List<WebElement> listaComTodosOsTitulos = getDriver().findElement(By.className("main-home")).findElements(By.className("tag-esp-pub"));
				
		for(int i=0; i<listaComTodosOsTitulos.size(); i++){
			if(listaComTodosOsTitulos.get(i).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public List<WebElement> totalDeChamadasDeColunaDMeio(){
		return getDriver().findElement(By.className("main-home")).findElements(By.className("lista-materias"));
	}
	
	public boolean exibiuMateriaRelacionadaSemTarjaDeEspecialPublicitario() {
		//Matéria relacionada 2 colunas 2 matérias
		List<WebElement> totalDeMateriasEspecialPublicitarioDaColunaDaDireita = totalDeChamadasDeColunaDMeio().get(0).findElement(By.className("right")).findElements(By.className("retranca-esp-pub-home"));
		return totalDeMateriasEspecialPublicitarioDaColunaDaDireita.size() == Integer.parseInt("0");
	}
	
	public boolean exibiuMateriaRelacionadaSemTarjaDeEspecialPublicitarioParaAsmateriasDoSegundoBloco() {
		//Matéria relacionada 2 colunas 1 matéria
		List<WebElement> totalDeMateriasEspecialPublicitarioDaColunaDaDireita = totalDeChamadasDeColunaDMeio().get(1).findElement(By.className("right")).findElements(By.className("retranca-esp-pub-home"));
		return totalDeMateriasEspecialPublicitarioDaColunaDaDireita.size() == Integer.parseInt("0");
	}
	
	public boolean exibiuMateriaRelacionadaSemTarjaDeEspecialPublicitarioParaAsmateriasDoTerceiroBloco() {
		//Matéria relacionada horizontal
		List<WebElement> totalDeMateriasEspecialPublicitarioDaColunaDaDireita = totalDeChamadasDeColunaDMeio().get(2).findElement(By.className("inferior")).findElements(By.className("retranca-esp-pub-home"));
		return totalDeMateriasEspecialPublicitarioDaColunaDaDireita.size() == Integer.parseInt("0");
	}
}
