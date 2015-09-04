package pages.materia.capitulo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.compartilhamento.CompartilhamentoInlinePadrao;

import br.com.infoglobo.pages.Navegador;

public class MenuLateralSemAutor extends CompartilhamentoInlinePadrao {
	
	public MenuLateralSemAutor() throws Exception {
		super();
	}
	
	public MenuLateralSemAutor(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuMateriaEmCapitulos() {
		return getDriver().findElement(By.className("materia-capitulos"));
	}
	
	public List<WebElement> listaTotalDeMaterias() {
		return exibiuMateriaEmCapitulos().findElements(By.className("capituloPage"));
	}
	
	public boolean exibiuUmAutorParaCadaCapitulo() {
		for(int i=0; i<listaTotalDeMaterias().size(); i++){
			List<WebElement> possuiAutorNaPosicao = listaTotalDeMaterias().get(i).findElements(By.className("autor"));
			if(possuiAutorNaPosicao.size() > 0){
				if(listaTotalDeMaterias().get(i).findElement(By.className("autor")).getText().equals("O Globo")){
					return false;
				}
			}
		}
		return true;
	}
}