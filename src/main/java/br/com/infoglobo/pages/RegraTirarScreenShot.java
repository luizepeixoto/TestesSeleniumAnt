package br.com.infoglobo.pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class RegraTirarScreenShot extends TestWatcher {
	
	private WebDriver driver;
	
	public RegraTirarScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	protected void failed(Throwable e, Description description) {
		String nomeClasse = description.getTestClass().getSimpleName();
		String nomeTeste = description.getMethodName();
		
		tiraScreenshot(nomeClasse, nomeTeste);
   }
	
	public void tiraScreenshot(String nomeClasse, String nomeTeste) {
		try {
			String diretorioNoServidor = "test/";
			String nomeProjeto = "OGlobo/";
			
			String dia = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/";
			String hora = new SimpleDateFormat("HH-mm").format(new Date());
			
			String nomeDiretorio = diretorioNoServidor + nomeProjeto + dia  + nomeClasse + "/";
			
			//Cria um diretório dentro de "test/OGlobo" usando
			//a data (ano-mês-dia) e um subdiretório com o nome da classe de teste
			new File(nomeDiretorio).mkdirs();
			
			//Obtém um screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			//Cria um arquivo dentro do diretório contendo no nome:
			//a hora da execução daquele teste
			//e o nome do método de teste
			//Exemplo: "15-56 verificaSeCadaEventoDaListaPossuiUmaFoto.png"
			
			FileUtils.copyFile(screenshot, new File(nomeDiretorio + hora + " " + nomeTeste + ".png"));
			
		} catch(Exception e) {
			
		}
	}
}