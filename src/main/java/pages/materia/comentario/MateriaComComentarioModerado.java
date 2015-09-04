package pages.materia.comentario;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.Navegador;

public class MateriaComComentarioModerado extends ComentarioInvalido {

	public MateriaComComentarioModerado(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public String exibiuDeComentarioModerado(){
		return getDriver().findElement(By.cssSelector("p.msg")).getAttribute("textContent");
	}
}