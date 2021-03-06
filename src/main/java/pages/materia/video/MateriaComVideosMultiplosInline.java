package pages.materia.video;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class MateriaComVideosMultiplosInline extends AceitacaoAbstractTest {
	
	public MateriaComVideosMultiplosInline() throws Exception {
		super();
	}

	public WebElement getClassCorpo(){
		return getDriver().findElement(By.className("corpo"));
	}
	
	public List<WebElement> listaTotalDeVideos(){
		return getClassCorpo().findElements(By.className("artigo-video"));
	}
	
	public boolean getVideoVevo(){
		return listaTotalDeVideos().get(0).findElement(By.tagName("div")).findElement(By.tagName("iframe")).getAttribute("src").contains("vevo");
	}
	
	public boolean getVideoGlobo(){
		return listaTotalDeVideos().get(1).findElement(By.tagName("div")).findElement(By.tagName("script")).isDisplayed();
	}
	
	public boolean getVideoYoutube(){
		return listaTotalDeVideos().get(2).findElement(By.tagName("div")).findElement(By.tagName("iframe")).getAttribute("src").contains("youtube");
	}
	
	public boolean getVideoVimeo(){
		return listaTotalDeVideos().get(3).findElement(By.tagName("div")).findElement(By.tagName("iframe")).getAttribute("src").contains("vimeo");
	}
	
	public boolean getVideoUstream(){
		return listaTotalDeVideos().get(4).findElement(By.tagName("div")).findElement(By.tagName("iframe")).getAttribute("src").contains("ustream");
	}
	
	public boolean getVideoLivestream(){
		return listaTotalDeVideos().get(5).findElement(By.tagName("div")).findElement(By.tagName("iframe")).getAttribute("src").contains("livestream");
	}
}
