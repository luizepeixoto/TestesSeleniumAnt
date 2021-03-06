package pages.barreira;

import java.util.ArrayList;

import org.openqa.selenium.By;

import assistente.AssistenteComWhiteList;
import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BarreiraEspecialPublicitario extends AceitacaoAbstractTest{
	
	public BarreiraEspecialPublicitario(Navegador navegador) throws Exception{
		super(navegador);
	}

	public void navegarPorOnzeMateriasDiferentes() throws Exception{
		
		AssistenteComWhiteList assistenteEspecialPublicitario = new AssistenteComWhiteList();
		ArrayList<String> urlsDeNavegacao = new ArrayList<String>();

		urlsDeNavegacao = assistenteEspecialPublicitario.obterOnzeUrls(getAmbiente(), getDominio());

		for (int i = 0; i < urlsDeNavegacao.size(); i++) {
			getDriver().navigate().to(urlsDeNavegacao.get(i));
			esperaCarregar(2);
			System.out.println("Matéria nº: "+ (i+1) + "-" + getDriver().getCurrentUrl());
		}	
	}

	public String exibiuPaginaDoEspecialPublicitario() {
		return getDriver().findElement(By.className("sub-editoria")).findElement(By.tagName("a")).getText();
	}
}