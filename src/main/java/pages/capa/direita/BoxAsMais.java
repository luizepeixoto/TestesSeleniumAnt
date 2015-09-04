package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxAsMais extends AceitacaoAbstractTest {

	public BoxAsMais() throws Exception {
		super();
	}

	public String tituloMaisLidas() {
		return getDriver().findElement(By.xpath("//div[@class='materias-mais']/div/ul/li[1]/a")).getText();
	}

	public String tituloMaisComentadas() {
		return getDriver().findElement(By.xpath("//div[@class='materias-mais']/div/ul/li[2]/a")).getText();
	}

	public String tituloMaisEnviadas() {
		return getDriver().findElement(By.xpath("//div[@class='materias-mais']/div/ul/li[3]/a")).getText();
	}

	public int exibiuQuantidadeMaiorQueUmEmMaisLidas() {
		return getDriver().findElement(By.id("lidas")).findElement(By.tagName("ul")).findElements(By.tagName("li")).size();
	}

	public int quantidadeIgualACincoEmMaisComentadas() {
		return getDriver().findElement(By.id("comentadas")).findElement(By.tagName("ul")).findElements(By.tagName("li")).size();
	}

	public int quantidadeIgualACincoEmMaisEnviadas() {
		return getDriver().findElement(By.id("enviadas")).findElement(By.tagName("ul")).findElements(By.tagName("li")).size();
	}
}