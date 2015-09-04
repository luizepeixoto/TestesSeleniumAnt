package pages.materia.widget.generico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Device;
import br.com.infoglobo.pages.Navegador;

public class BoxGenericoPadrao extends AceitacaoAbstractTest {
	
	public BoxGenericoPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public BoxGenericoPadrao(Navegador navegador, Device device) throws Exception {
		super(navegador, device);
	}

	public WebElement acessaClasseEmbedSocial(){
		return getDriver().findElement(By.className("embed-social"));
	}
	
	public WebElement acessaDailyMotion(){
		return getDriver().findElement(By.className("artigo-video"));
	}
	
	public WebElement acessaClasseEmbedComVideo(){
		return getDriver().findElement(By.className("artigo-video"));
	}
	
	public boolean exibiuBoxDoWidgetGenericoComTwitter(WebElement posicaoDesejada) {
		WebElement twitterComVideo = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(twitterComVideo.isDisplayed()) || !(twitterComVideo.getAttribute("class").contains("twitter-tweet"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComInstagram(WebElement posicaoDesejada) {
		WebElement instagram = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(instagram.isDisplayed()) || !(instagram.getAttribute("class").contains("instagram-media"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComInstagramComVideo(WebElement posicaoDesejada) {
		WebElement instagramComVideo = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(instagramComVideo.isDisplayed()) || !(instagramComVideo.getAttribute("class").contains("instagram-media"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComYoutube(WebElement posicaoDesejada) {
		WebElement videoYoutube = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(videoYoutube.isDisplayed()) || !(videoYoutube.getAttribute("src").contains("youtube"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComVine(WebElement posicaoDesejada) {
		WebElement videoVine = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(videoVine.isDisplayed()) || !(videoVine.getAttribute("class").contains("pinged")) || !(videoVine.getAttribute("src").contains("vine"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComVimeo(WebElement posicaoDesejada) {
		WebElement videoVine = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(videoVine.isDisplayed()) || !(videoVine.getAttribute("src").contains("vimeo"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComVevo(WebElement posicaoDesejada) {
		WebElement videoVevo = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(videoVevo.isDisplayed()) || !(videoVevo.getAttribute("src").contains("vevo"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComSoundcloudComPlaylist(WebElement posicaoDesejada) {
		WebElement soundcloudComPlaylist = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(soundcloudComPlaylist.isDisplayed()) || !(soundcloudComPlaylist.getAttribute("src").contains("soundcloud"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComSoundcloud(WebElement posicaoDesejada) {
		WebElement soundcloud = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!(soundcloud.isDisplayed()) || !(soundcloud.getAttribute("src").contains("soundcloud"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComFacebook(WebElement posicaoDesejada) {
		WebElement postFacebook = posicaoDesejada.findElements(By.tagName("div")).get(1);
		if(!(postFacebook.isDisplayed()) || !(postFacebook.getAttribute("class").contains("fb-post"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoDoFacebookComVideo(WebElement posicaoDesejada) {
		WebElement postFacebook = posicaoDesejada.findElements(By.tagName("div")).get(1);
		if(!(postFacebook.isDisplayed()) || !(postFacebook.getAttribute("class").contains("fb-video"))){
			return false;
		}
		
		return true;
	}
	
	public boolean exibiuBoxDoWidgetGenericoComDailymotion(WebElement posicaoDesejada) {
		WebElement videoDailyMotion = posicaoDesejada.findElement(By.tagName("iframe"));
		if(!videoDailyMotion.isDisplayed() || !videoDailyMotion.getAttribute("src").contains("dailymotion")){
			return false;
		}
		
		return true;
	}
}