package pages.materia.widget;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.materia.widget.generico.BoxGenericoPadrao;

import br.com.infoglobo.pages.Device;
import br.com.infoglobo.pages.Navegador;

public class BoxDeAudio extends BoxGenericoPadrao {
	
	public WebElement acessaHR(){
		return getDriver().findElement(By.className("corpo")).findElement(By.tagName("p"));
	}
	
	public BoxDeAudio(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public BoxDeAudio(Navegador navegador, Device device) throws Exception{
		super(navegador, device);
	}
	
	public WebElement boxDoAudio(){
		return getDriver().findElement(By.className("player"));
	}
	
	public void carregarAudio(){
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public boolean exibiuBoxDoAudio() {
		return boxDoAudio().isDisplayed();
	}

	public boolean exibiuPlayDoAudio() {
		return boxDoAudio().findElement(By.className("play")).findElement(By.className("player-audio")).isDisplayed();
	}

	public boolean exibiuNomeDoArquivoDoAudio() {
		return !boxDoAudio().findElement(By.className("audio-info")).findElement(By.className("nome-arquivo")).getText().isEmpty();
	}

	public boolean exibiuBarraDeProgressoDoAudio() {
		return boxDoAudio().findElement(By.className("progress-bar")).isDisplayed();
	}

	public boolean exibiuProgressTimeDoAudio() throws InterruptedException {
		esperaCarregar(2);
		return boxDoAudio().findElement(By.className("audio-info")).findElement(By.className("progress-time")).isDisplayed();
	}

	public boolean exibiuTotalTimeDoAudio() throws InterruptedException {
		esperaCarregar(2);
		return boxDoAudio().findElement(By.className("audio-info")).findElement(By.className("total-time")).isDisplayed();
	}
	
	public WebElement acessaClasseAudio(){
		return boxDoAudio().findElement(By.className("volume"));
	}

	public boolean exibiuVolumeDoAudio() {
		return acessaClasseAudio().isDisplayed();
	}

	public boolean exibiuBotaoDeMudoDoAudio() {
		return acessaClasseAudio().findElement(By.className("mute")).isDisplayed();
	}

	public boolean exibiuBarraDeVolumeDoAudio() {
		return acessaClasseAudio().findElement(By.className("barras")).isDisplayed();
	}

	public boolean verificaSeOAudioPossuiUmaUrl() {
		return !boxDoAudio().findElement(By.className("player_audio")).findElement(By.tagName("source")).getAttribute("src").isEmpty();
	}

	public boolean naoExibiuVolumeDoAudioParaOIpad(){
		
		try {
			
			if(acessaClasseAudio().isDisplayed()){
				imprimirMensagemDeErroGenerica("No Ipad não pode ser exibido o volume.");
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}

	public boolean naoExibiuBotaoDeMudoDoAudioParaOIpad() {

		try {
			
			if(acessaClasseAudio().findElement(By.className("mute")).isDisplayed()){
				imprimirMensagemDeErroGenerica("No Ipad não pode ser exibido o volume.");
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
		
	}

	public boolean naoExibiuBarraDeVolumeDoAudioParaOIpad() {
		
		try {
			
			if(acessaClasseAudio().findElement(By.className("barras")).isDisplayed()){
				imprimirMensagemDeErroGenerica("No Ipad não pode ser exibido o volume.");
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
		
	}
}