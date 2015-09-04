package pages.materia.comentario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ComentarioComRespostas extends AceitacaoAbstractTest {
	
	public ComentarioComRespostas() throws Exception {
		super();
	}
	
	public ComentarioComRespostas(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement getComentarioMenu(){
		return getDriver().findElement(By.className("lista-comentarios"));
	}
	
	public List<WebElement> getLista(){
		return getDriver().findElement(By.className("respostas")).findElements(By.tagName("li"));
	}
	
	public boolean getTotalRespostas() {
		return getLista().size() > 0;
	}

	public boolean getAutorDasRespostas() {
		for(int i=0; i<getLista().size(); i++){
			if(getLista().get(i).findElement(By.className("autor")).findElement(By.tagName("strong")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean getDataDasRespostas() {
		for(int i=0; i<getLista().size(); i++){
			if(getLista().get(i).findElement(By.className("autor")).findElement(By.tagName("time")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean getBulletEntreAutorEResposta() {
		for(int i=0; i<getLista().size(); i++){
			if(!getLista().get(i).findElement(By.className("autor")).findElement(By.tagName("span")).getText().contains("•")){
				return false;
			}
		}
		return true;
	}
	
	public boolean getTextoDasRespostas() {
		for(int i=0; i<getLista().size(); i++){
			if(getLista().get(i).findElement(By.className("text")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
}