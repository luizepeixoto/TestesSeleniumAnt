package pages.capa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class Rodape extends AceitacaoAbstractTest {
	
	public Rodape() throws Exception {
		super();
	}
	
	public Rodape(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement exibiuOFooter() {
		return getDriver().findElement(By.className("footer"));
	}

	public WebElement exibiuOLogoNoFooter() {
		return exibiuOFooter().findElement(By.className("logo"));
	}
	
	public boolean exibiuUmLinkNoLogoNoFooter() {
		return exibiuOFooter().findElement(By.tagName("span")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoLogoNoFooter() {
		return exibiuOFooter().findElement(By.tagName("span")).findElement(By.tagName("a")).getAttribute("href").equals(getUrlPaginaAtual());
	}
	
	public WebElement exibiuClasseRedesSociais() {
		return exibiuOFooter().findElement(By.className("social"));
	}

	public WebElement exibiuOIconeFacebook() {
		return exibiuClasseRedesSociais().findElement(By.className("facebook"));
	}

	public boolean exibiuUmLinkNoIconeDoFacebook() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuUmLinkValidoNoIconeDoFacebook() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).getAttribute("href");
	}

	public WebElement exibiuOIconeTwitter() {
		return exibiuClasseRedesSociais().findElement(By.className("twitter"));
	}

	public boolean exibiuUmLinkNoIconeDoTwitter() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(1).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuUmLinkValidoNoIconeDoTwitter() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(1).findElement(By.tagName("a")).getAttribute("href");
	}

	public WebElement exibiuOIconeGooglePlus() {
		return exibiuClasseRedesSociais().findElement(By.className("gplus"));
	}

	public boolean exibiuUmLinkNoIconeDoGooglePlus() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(2).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuUmLinkValidoNoIconeDoGooglePlus() {
		return exibiuClasseRedesSociais().findElements(By.tagName("li")).get(2).findElement(By.tagName("a")).getAttribute("href");
	}
	
	public WebElement exibiuOBannerDeAssinatura() {
		return getDriver().findElement(By.id("banner-assinatura-footer"));
	}

	public boolean exibiuUmLinkNoBannerDeAssinatura() {
		return exibiuOBannerDeAssinatura().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoBannerDeAssinatura() {
		return !exibiuOBannerDeAssinatura().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public WebElement exibiuOsTopicosNoFooter() {
		return exibiuOFooter().findElement(By.className("topicos"));
	}

	public Object exibiuOTituloTopicos() {
		return getDriver().findElement(By.xpath("/html/body/footer/div/div/div/ul[2]/li")).getText();
	}
	
	public List<WebElement> listaTotalDeTopicos() {
		return exibiuOsTopicosNoFooter().findElements(By.tagName("li"));
	}

	public boolean exibiuListaDeTopicos() {
		return listaTotalDeTopicos().size()>0;
	}

	public boolean exibiuTituloParaOsTopicos() {
		for(int i=1;i<listaTotalDeTopicos().size();i++){
			if(listaTotalDeTopicos().get(i).getText().isEmpty()){
				return false;
			}
		}
		return true; 
	}

	public boolean exibiuLinkNoTituloDosTopicos() {
		for(int i=1;i<listaTotalDeTopicos().size();i++){
			if(!listaTotalDeTopicos().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true; 
	}

	public boolean oLinkDosTopicosSaoValidos() {
		for(int i=1;i<listaTotalDeTopicos().size();i++){
			if(listaTotalDeTopicos().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true; 
	}

	public WebElement exibiuOFooterComDasEditorias() {
		return getDriver().findElement(By.tagName("footer")).findElement(By.className("editorias"));
	}

	public WebElement exibiuNoFooterAEditoriaRio() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaRio() {
		return exibiuNoFooterAEditoriaRio().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasRio() {
		return listaDeSubeditoriaRio().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasRioComLink() {
		for(int i=0;i<listaDeSubeditoriaRio().size();i++){
			if(!listaDeSubeditoriaRio().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasRioComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaRio().size();i++){
			if(listaDeSubeditoriaRio().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaSaude() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaSaude() {
		return exibiuNoFooterAEditoriaSaude().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasSaude() {
		return listaDeSubeditoriaSaude().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasSaudeComLink() {
		for(int i=0;i<listaDeSubeditoriaSaude().size();i++){
			if(!listaDeSubeditoriaSaude().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasSaudeComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaSaude().size();i++){
			if(listaDeSubeditoriaSaude().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaBrasil() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaBrasil() {
		return exibiuNoFooterAEditoriaBrasil().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasBrasil() {
		return listaDeSubeditoriaBrasil().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasBrasilComLink() {
		for(int i=0;i<listaDeSubeditoriaBrasil().size();i++){
			if(!listaDeSubeditoriaBrasil().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasBrasilComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaBrasil().size();i++){
			if(listaDeSubeditoriaBrasil().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaCiencia() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaCiencia() {
		return exibiuNoFooterAEditoriaCiencia().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasCiencia() {
		return listaDeSubeditoriaCiencia().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasCienciaComLink() {
		for(int i=0;i<listaDeSubeditoriaCiencia().size();i++){
			if(!listaDeSubeditoriaCiencia().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasCienciaComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaCiencia().size();i++){
			if(listaDeSubeditoriaCiencia().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaMundo() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaMundo() {
		return exibiuNoFooterAEditoriaMundo().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasMundo() {
		return listaDeSubeditoriaMundo().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasMundoComLink() {
		for(int i=0;i<listaDeSubeditoriaMundo().size();i++){
			if(!listaDeSubeditoriaMundo().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasMundoComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaMundo().size();i++){
			if(listaDeSubeditoriaMundo().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaCultura() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaCultura() {
		return exibiuNoFooterAEditoriaCultura().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasCultura() {
		return listaDeSubeditoriaCultura().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasCulturaComLink() {
		for(int i=0;i<listaDeSubeditoriaCultura().size();i++){
			if(!listaDeSubeditoriaCultura().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasCulturaComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaCultura().size();i++){
			if(listaDeSubeditoriaCultura().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaEconomia() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaEconomia() {
		return exibiuNoFooterAEditoriaEconomia().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasEconomia() {
		return listaDeSubeditoriaEconomia().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasEconomiaComLink() {
		for(int i=0;i<listaDeSubeditoriaEconomia().size();i++){
			if(!listaDeSubeditoriaEconomia().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasEconomiaComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaEconomia().size();i++){
			if(listaDeSubeditoriaEconomia().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaEstilo() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaEstilo() {
		return exibiuNoFooterAEditoriaEstilo().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasEstilo() {
		return listaDeSubeditoriaEstilo().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasEstiloComLink() {
		for(int i=0;i<listaDeSubeditoriaEstilo().size();i++){
			if(!listaDeSubeditoriaEstilo().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasEstiloComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaEstilo().size();i++){
			if(listaDeSubeditoriaEstilo().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaSociedade() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaSociedade() {
		return exibiuNoFooterAEditoriaSociedade().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasSociedade() {
		return listaDeSubeditoriaSociedade().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasSociedadeComLink() {
		for(int i=0;i<listaDeSubeditoriaSociedade().size();i++){
			if(!listaDeSubeditoriaSociedade().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasSociedadeComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaSociedade().size();i++){
			if(listaDeSubeditoriaSociedade().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaEsportes() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaEsportes() {
		return exibiuNoFooterAEditoriaEsportes().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasEsportes() {
		return listaDeSubeditoriaEsportes().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasEsportesComLink() {
		for(int i=0;i<listaDeSubeditoriaEsportes().size();i++){
			if(!listaDeSubeditoriaEsportes().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasEsportesComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaEsportes().size();i++){
			if(listaDeSubeditoriaEsportes().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaTecnologia() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaTecnologia() {
		return exibiuNoFooterAEditoriaTecnologia().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasTecnologia() {
		return listaDeSubeditoriaTecnologia().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasTecnologiaComLink() {
		for(int i=0;i<listaDeSubeditoriaTecnologia().size();i++){
			if(!listaDeSubeditoriaTecnologia().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasTecnologiaComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaTecnologia().size();i++){
			if(listaDeSubeditoriaTecnologia().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterAEditoriaMais() {
		return exibiuOFooterComDasEditorias().findElement(By.className("rio"));
	}
	
	public List<WebElement> listaDeSubeditoriaMais() {
		return exibiuNoFooterAEditoriaMais().findElements(By.tagName("li"));
	}
	
	public boolean exibiuNoFooterAsSubEditoriasMais() {
		return listaDeSubeditoriaMais().size()>0;
	}

	public boolean exibiuNoFooterAsSubEditoriasMaisComLink() {
		for(int i=0;i<listaDeSubeditoriaMais().size();i++){
			if(!listaDeSubeditoriaMais().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuNoFooterAsSubEditoriasMaisComLinkValido() {
		for(int i=0;i<listaDeSubeditoriaMais().size();i++){
			if(listaDeSubeditoriaMais().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement exibiuNoFooterOBoxDoCopyright() {
		return getDriver().findElement(By.tagName("footer")).findElement(By.className("copy"));
	}
	
	public boolean exibiuNoFooterOBannerDoCopyright() {
		return exibiuNoFooterOBoxDoCopyright().findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuOBannerDoCopyrightComWidth112Px() {
		return exibiuNoFooterOBoxDoCopyright().findElement(By.tagName("img")).getAttribute("width").equals("112");
	}

	public boolean exibiuOBannerDoCopyrightComHeight60Px() {
		return exibiuNoFooterOBoxDoCopyright().findElement(By.tagName("img")).getAttribute("height").equals("60");
	}
	
	public boolean exibiuOCopyrightComUmLink() {
		return exibiuNoFooterOBoxDoCopyright().findElement(By.tagName("a")).isDisplayed();
	}
	
	public String exibiuOCopyrightComUmLinkValido() {
		return exibiuNoFooterOBoxDoCopyright().findElement(By.tagName("a")).getAttribute("href");
	}

	public String exibiuOTextoDoCopyright() {
		return exibiuNoFooterOBoxDoCopyright().findElement(By.tagName("div")).getText();
	}

	public WebElement exibiuNoFooterOLinksInstitucionais() {
		return getDriver().findElement(By.tagName("footer")).findElement(By.className("links-institucionais"));
	}
	
	public List<WebElement> listaDeLinksInstitucionais() {
		return exibiuNoFooterOLinksInstitucionais().findElements(By.tagName("li"));
	}
	
	
	
	
	public WebElement linkCentralDoAssinante() {
		return listaDeLinksInstitucionais().get(0);
	}
	
	public String exibiuOTextoDeCentralDoAssinante() {
		return linkCentralDoAssinante().getText();
	}

	public boolean exibiuCentralDoAssinanteComUmLink() {
		return linkCentralDoAssinante().findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuCentralDoAssinanteComUmLinkValido() {
		return linkCentralDoAssinante().findElement(By.tagName("a")).getAttribute("href");
	}
	
	
	public WebElement linkClubeSouRio() {
		return listaDeLinksInstitucionais().get(1);
	}
		
	public String exibiuOTextoDeClubeSouRio() {
		return linkClubeSouRio().getText();
	}

	public boolean exibiuClubeSouRioComUmLink() {
		return linkClubeSouRio().findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuClubeSouRioComUmLinkValido() {
		return linkClubeSouRio().findElement(By.tagName("a")).getAttribute("href");
	}
	
	public WebElement linkFacaSuaAssinatura() {
		return listaDeLinksInstitucionais().get(2);
	}
	
	public String exibiuOTextoDeFacaSuaAssinatura() {
		return linkFacaSuaAssinatura().getText();
	}

	public boolean exibiuFacaSuaAssinaturaComUmLink() {
		return linkFacaSuaAssinatura().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuFacaSuaAssinaturaComUmLinkValido() {
		return !linkFacaSuaAssinatura().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public WebElement linkAgenciaOGlobo() {
		return listaDeLinksInstitucionais().get(3);
	}
	
	public String exibiuOTextoDeAgenciaOGlobo() {
		return linkAgenciaOGlobo().getText();
	}

	public boolean exibiuAgenciaOGloboComUmLink() {
		return linkAgenciaOGlobo().findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuAgenciaOGloboComUmLinkValido() {
		return linkAgenciaOGlobo().findElement(By.tagName("a")).getAttribute("href");
	}
	
	public WebElement linkGloboShopping() {
		return listaDeLinksInstitucionais().get(4);
	}
	
	public String exibiuOTextoDeOGloboShopping() {
		return linkGloboShopping().getText();
	}

	public boolean exibiuOGloboShoppingComUmLink() {
		return linkGloboShopping().findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuOGloboShoppingComUmLinkValido() {
		return linkGloboShopping().findElement(By.tagName("a")).getAttribute("href");
	}
	
	
	
	
	
	
	
	
	
	
	public String exibiuOTextoDeFaleConosco() {
		return listaDeLinksInstitucionais().get(5).getText();
	}

	public boolean exibiuFaleConoscoComUmLink() {
		return listaDeLinksInstitucionais().get(5).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuFaleConoscoComUmLinkValido() {
		return listaDeLinksInstitucionais().get(5).findElement(By.tagName("a")).getAttribute("href").contains("fale-conosco");
	}
	
	public String exibiuOTextoDeDefesaDoConsumidor() {
		return listaDeLinksInstitucionais().get(6).getText();
	}

	public boolean exibiuDefesaDoConsumidorComUmLink() {
		return listaDeLinksInstitucionais().get(6).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuDefesaDoConsumidorComUmLinkValido() {
		return listaDeLinksInstitucionais().get(6).findElement(By.tagName("a")).getAttribute("href");
	}
	
	public String exibiuOTextoDeExpediente() {
		return listaDeLinksInstitucionais().get(7).getText();
	}

	public boolean exibiuExpedienteComUmLink() {
		return listaDeLinksInstitucionais().get(7).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuExpedienteComUmLinkValido() {
		return listaDeLinksInstitucionais().get(7).findElement(By.tagName("a")).getAttribute("href").contains("expediente");
	}
	
	public String exibiuOTextoDeAnuncieConosco() {
		return listaDeLinksInstitucionais().get(8).getText();
	}

	public boolean exibiuAnuncieConoscoComUmLink() {
		return listaDeLinksInstitucionais().get(8).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuAnuncieConoscoComUmLinkValido() {
		return !listaDeLinksInstitucionais().get(8).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public String exibiuOTextoDeTrabalheConosco() {
		return listaDeLinksInstitucionais().get(9).getText();
	}

	public boolean exibiuTrabalheConoscoComUmLink() {
		return listaDeLinksInstitucionais().get(9).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuTrabalheConoscoComUmLinkValido() {
		return listaDeLinksInstitucionais().get(9).findElement(By.tagName("a")).getAttribute("href");
	}
	
	public String exibiuOTextoDePoliticaDePrivacidade() {
		return listaDeLinksInstitucionais().get(10).getText();
	}

	public boolean exibiuPoliticaDePrivacidadeComUmLink() {
		return listaDeLinksInstitucionais().get(10).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuPoliticaDePrivacidadeComUmLinkValido() {
		return listaDeLinksInstitucionais().get(10).findElement(By.tagName("a")).getAttribute("href");
	}
	
	public String exibiuOTextoDeTermosDeUso() {
		return listaDeLinksInstitucionais().get(11).getText();
	}

	public boolean exibiuTermosDeUsoComUmLink() {
		return listaDeLinksInstitucionais().get(11).findElement(By.tagName("a")).isDisplayed();
	}

	public String exibiuTermosDeUsoComUmLinkValido() {
		return listaDeLinksInstitucionais().get(11).findElement(By.tagName("a")).getAttribute("href");
	}
}
