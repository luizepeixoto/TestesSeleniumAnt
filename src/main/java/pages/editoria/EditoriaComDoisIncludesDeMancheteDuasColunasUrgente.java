package pages.editoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class EditoriaComDoisIncludesDeMancheteDuasColunasUrgente extends AceitacaoAbstractTest {
	
	public EditoriaComDoisIncludesDeMancheteDuasColunasUrgente() throws Exception{
		super();
	}
	
	//DE2327 Conteúdo é duplicado ao adicionar duas includes sections diferentes numa mesma lista de conteúdos de uma editoria
	
	public List<WebElement> totalDeDestaques2Colunas() {
		return getDriver().findElements(By.className("destaques-2-colunas"));
	}
	
	public boolean exibiuDoisDestaques() {
		return totalDeDestaques2Colunas().size() == 2;
	}

	public boolean exibiuDoisIncludesDiferentes() {
		String tituloDaPrimeiraMateriaDoPrimeiroInclude = totalDeDestaques2Colunas().get(0).findElement(By.className("principal")).findElement(By.className("large-16")).findElement(By.tagName("h3")).getText();
		String tituloDaPrimeiraMateriaDoSegundoInclude = totalDeDestaques2Colunas().get(1).findElement(By.className("principal")).findElement(By.className("large-16")).findElement(By.tagName("h3")).getText();
		
		if(tituloDaPrimeiraMateriaDoPrimeiroInclude.equals(tituloDaPrimeiraMateriaDoSegundoInclude)){
			return false;
		}
		return true;
	}
}