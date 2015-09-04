package pages.ultimas;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.Navegador;

public class UltimasDeTopicos extends UltimasDaCapa {
	
	public UltimasDeTopicos(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuOTituloDoTopico() {
		return acessaTituloDeUltimas().isDisplayed();
	}
	
	public boolean exibiuEditoriaParaAsUltimasDeTopicos() {
		
		for(int i=1; i < quantidadeAValidar; i++){
			
			try {
				if(listaTotalDeUltimas().get(i).findElement(By.className("editoria")).isDisplayed()){
					imprimirMensagemDeErroGenerica("Exibiu Editoria na chamada para a "+(i+1)+"ª posição.");
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return true;
	}
}
