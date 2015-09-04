package pages.fotogaleria;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class FotogaleriaCompartilhamento extends Fotogaleria{
	
	public FotogaleriaCompartilhamento(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement acessaTitulo = getDriver().findElement(By.className("details")).findElement(By.className("title"));
	
	public boolean exibiuRedesSociais() throws InterruptedException {
		
		String corIconeFacebook = "rgba(58, 87, 149, 1)";
		String corIconeTwitter = "rgba(85, 172, 238, 1)";
		String corIconeGooglePlus = "rgba(211, 72, 54, 1)";
		String corIconePinterest = "rgba(227, 38, 46, 1)";
		
		for(int i=1; i < totalDeFotosDaFotogaleria().size(); i++){

			WebElement facebookDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-facebook"));
			WebElement twitterFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-twitter"));
			WebElement googlePlusDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-plus"));
			WebElement pinterestDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-pinterest"));
			
			WebElement linkCompartilhamentoFacebookAtual = facebookDaFotoAtual.findElement(By.tagName("a"));
			WebElement linkCompartilhamentoTwitterAtual = twitterFotoAtual.findElement(By.tagName("a"));
			WebElement linkCompartilhamentoGooglePlusAtual = googlePlusDaFotoAtual.findElement(By.tagName("a"));
			WebElement linkCompartilhamentoPinterestAtual = pinterestDaFotoAtual.findElement(By.tagName("a"));
			
			String linkdoFacebookNaFotoAtual = linkCompartilhamentoFacebookAtual.getAttribute("href");
			String linkdoTwitterNaFotoAtual = linkCompartilhamentoTwitterAtual.getAttribute("href");
			String linkdoGooglePlusNaFotoAtual = linkCompartilhamentoGooglePlusAtual.getAttribute("href");
			String linkdoPinterestNaFotoAtual = linkCompartilhamentoPinterestAtual.getAttribute("href");
			
			String facebookValorTargetDaFotoAtual = linkCompartilhamentoFacebookAtual.getAttribute("target");
			String twitterValorTargetDaFotoAtual = linkCompartilhamentoTwitterAtual.getAttribute("target");
			String googlePlusValorTargetDaFotoAtual = linkCompartilhamentoGooglePlusAtual.getAttribute("target");
			String pinterestValorTargetDaFotoAtual = linkCompartilhamentoPinterestAtual.getAttribute("target");
			
			if(!facebookDaFotoAtual.isDisplayed()){
				System.out.println(" Rede Social Facebook não está sendo exibida na imagem " + i);
				return false;
			}
			
			if(!twitterFotoAtual.isDisplayed()){
				System.out.println(" Rede Social Twitter não está sendo exibida na imagem " + i);
				return false;
			}
			
			if(!googlePlusDaFotoAtual.isDisplayed()){
				System.out.println(" Rede Social Google+ não está sendo exibida na imagem " + i);
				return false;
			}
			
			if(!pinterestDaFotoAtual.isDisplayed()){
				System.out.println(" Rede Social Pinterest não está sendo exibida na imagem " + i);
				return false;
			}
			
			if(linkdoFacebookNaFotoAtual.isEmpty()){
				System.out.println(" Não possui um link válido para a Rede Social Facebook na imagem " + i);
				return false;
			}
			
			if(linkdoTwitterNaFotoAtual.isEmpty()){
				System.out.println(" Não possui um link válido para a Rede Social Twitter na imagem " + i);
				return false;
			}
			
			if(linkdoGooglePlusNaFotoAtual.isEmpty()){
				System.out.println(" Não possui um link válido para a Rede Social Google+ na imagem " + i);
				return false;
			}
			
			if(linkdoPinterestNaFotoAtual.isEmpty()){
				System.out.println(" Não possui um link válido para a Rede Social Pinterest na imagem " + i);
				return false;
			}
			
			if(!facebookValorTargetDaFotoAtual.equals("blank")){
				System.out.println(" Não possui target blank para a Rede Social Facebook na imagem " + i);
				return false;
			}
			
			if(!twitterValorTargetDaFotoAtual.equals("blank")){
				System.out.println(" Não possui target blank para a Rede Social Twitter na imagem " + i);
				return false;
			}
			
			if(!googlePlusValorTargetDaFotoAtual.equals("blank")){
				System.out.println(" Não possui target blank para a Rede Social Google+ na imagem " + i);
				return false;
			}
			
			if(!pinterestValorTargetDaFotoAtual.equals("blank")){
				System.out.println(" Não possui target blank para a Rede Social Pinterest na imagem " + i);
				return false;
			}
			
			esperaCarregar(2);
			executarMouseOver(facebookDaFotoAtual.findElement(By.tagName("i")));
			esperaCarregar(3);
			String corIconeFacebookFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-facebook")).getCssValue("color"); 
//					facebookDaFotoAtual.findElement(By.className("fa-facebook")).getCssValue("color");
			
			if(!corIconeFacebookFotoAtual.equals(corIconeFacebook)){
				imprimirMensagemDeErroDeUmaTag("cor do ícone do facebook na foto nº "+i+"", corIconeFacebook, corIconeFacebookFotoAtual);
				return false;
			}
			
			esperaCarregar(2);
			executarMouseOver(twitterFotoAtual.findElement(By.tagName("i")));
			esperaCarregar(3);
			String corIconeTwitterFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-twitter")).getCssValue("color"); 
//					twitterFotoAtual.findElement(By.className("fa-twitter")).getCssValue("color");
			
			if(!corIconeTwitterFotoAtual.equals(corIconeTwitter)){
				imprimirMensagemDeErroDeUmaTag("cor do ícone do twitter na foto nº "+i+"", corIconeTwitter, corIconeTwitterFotoAtual);
				return false;
			}
			
			esperaCarregar(2);
			executarMouseOver(googlePlusDaFotoAtual.findElement(By.tagName("i")));
			esperaCarregar(3);
			String corIconeGooglePlusFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-google-plus")).getCssValue("color");
//					googlePlusDaFotoAtual.findElement(By.className("fa-google-plus")).getCssValue("color");
			
			if(!corIconeGooglePlusFotoAtual.equals(corIconeGooglePlus)){
				imprimirMensagemDeErroDeUmaTag("cor do ícone do Google Plus na foto nº "+i+"", corIconeGooglePlus, corIconeGooglePlusFotoAtual);
				return false;
			}
			
			esperaCarregar(2);
			executarMouseOver(pinterestDaFotoAtual.findElement(By.tagName("i")));
			esperaCarregar(3);
			String corIconePinterestFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-pinterest")).getCssValue("color");
//					pinterestDaFotoAtual.findElement(By.className("fa-pinterest")).getCssValue("color");
			
			if(!corIconePinterestFotoAtual.equals(corIconePinterest)){
				imprimirMensagemDeErroDeUmaTag("cor do ícone do Pinterest na foto nº "+i+"", corIconePinterest, corIconePinterestFotoAtual);
				return false;
			}
			
			clicarNaProximaFoto();
			esperaCarregar(1);
		}

		return true;
	}
	
	
//	public boolean exibiuACorDasRedesSociais() throws InterruptedException {
//
//		for(int i=1; i<totalDeFotosDaFotogaleria().size(); i++){
//			
//			executarMouseOver(totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-facebook")));
//			esperaCarregar(1);
//			String facebookDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-facebook")).getCssValue("color");
//			if(!facebookDaFotoAtual.equals("rgba(58, 87, 149, 1)")){
//				imprimirMensagemDeErroDeCorRedeSocial("Facebook", i, facebookDaFotoAtual);
//				return false;
//			}
//			
//			executarMouseOver(totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-twitter")));
//			esperaCarregar(1);
//			String twitterFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-twitter")).getCssValue("color");
//			
//			if(!twitterFotoAtual.equals("rgba(85, 172, 238, 1)")){
//				imprimirMensagemDeErroDeCorRedeSocial("Twitter", i, twitterFotoAtual);
//				return false;
//			}
//			
//			executarMouseOver(totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-google-plus")));
//			esperaCarregar(1);
//			String googlePlusDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-google-plus")).getCssValue("color");
//			if(!googlePlusDaFotoAtual.equals("rgba(211, 72, 54, 1)")){
//				imprimirMensagemDeErroDeCorRedeSocial("Google Plus", i, googlePlusDaFotoAtual);
//				return false;
//			}
//			
//			executarMouseOver(totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-pinterest")));
//			esperaCarregar(1);
//			String pinterestDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("fa-pinterest")).getCssValue("color");
//			if(!pinterestDaFotoAtual.equals("rgba(227, 38, 46, 1)")){
//				imprimirMensagemDeErroDeCorRedeSocial("Pinterest", i, googlePlusDaFotoAtual);
//				return false;
//			}
//
//
//			clicarNaProximaFoto();
//			esperaCarregar(1);
//		}
//
//		return true;
//	}

//	public boolean exibiuLinkValido() throws InterruptedException {
//		
//		for(int i=1; i<totalDeFotosDaFotogaleria().size(); i++){
//
//			boolean facebookDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-facebook")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
//			boolean twitterFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-twitter")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
//			boolean googlePlusDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-plus")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
//			boolean pinterestDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-pinterest")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
//
//			if(facebookDaFotoAtual){
//				System.out.println(" Não possui um link válido para a Rede Social Facebook na imagem " + i);
//				return false;
//			}
//			
//			if(twitterFotoAtual){
//				System.out.println(" Não possui um link válido para a Rede Social Twitter na imagem " + i);
//				return false;
//			}
//			
//			if(googlePlusDaFotoAtual){
//				System.out.println(" Não possui um link válido para a Rede Social Google+ na imagem " + i);
//				return false;
//			}
//			
//			if(pinterestDaFotoAtual){
//				System.out.println(" Não possui um link válido para a Rede Social Pinterest na imagem " + i);
//				return false;
//			}
//
//			clicarNaProximaFoto();
//			esperaCarregar(1);
//		}
//
//		return true;
//	}
//
//	public boolean contemLinkComTargetBlank() throws InterruptedException {
//
//		for(int i=1; i<totalDeFotosDaFotogaleria().size(); i++){
//
//			boolean facebookDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-facebook")).findElement(By.tagName("a")).getAttribute("target").contains("blank");
//			boolean twitterFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-twitter")).findElement(By.tagName("a")).getAttribute("target").contains("blank");
//			boolean googlePlusDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-plus")).findElement(By.tagName("a")).getAttribute("target").contains("blank");
//			boolean pinterestDaFotoAtual = totalDeFotosDaFotogaleria().get(i).findElement(By.className("icon-pinterest")).findElement(By.tagName("a")).getAttribute("target").contains("blank");
//
//			if(!facebookDaFotoAtual){
//				System.out.println(" Não possui target blank para a Rede Social Facebook na imagem " + i);
//				return false;
//			}
//			
//			if(!twitterFotoAtual){
//				System.out.println(" Não possui target blank para a Rede Social Twitter na imagem " + i);
//				return false;
//			}
//			
//			if(!googlePlusDaFotoAtual){
//				System.out.println(" Não possui target blank para a Rede Social Google+ na imagem " + i);
//				return false;
//			}
//			
//			if(!pinterestDaFotoAtual){
//				System.out.println(" Não possui target blank para a Rede Social Pinterest na imagem " + i);
//				return false;
//			}
//
//			clicarNaProximaFoto();
//			esperaCarregar(1);
//		}
//
//		return true;
//	}
}