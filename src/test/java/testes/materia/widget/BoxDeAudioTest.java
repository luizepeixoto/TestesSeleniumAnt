package testes.materia.widget;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.widget.BoxDeAudio;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxDeAudioTest {
	
	private static BoxDeAudio materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxDeAudio(Navegador.CHROME);
		materia.esperaCarregar1Segundo();
		materia.executarScroll(materia.boxDoAudio().getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxDoAudio(){
		assertTrue(materia.exibiuBoxDoAudio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuPlayDoAudio(){
		assertTrue(materia.exibiuPlayDoAudio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuNomeDoArquivoDoAudio(){
		assertTrue(materia.exibiuNomeDoArquivoDoAudio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuBarraDeProgressoDoAudio(){
		assertTrue(materia.exibiuBarraDeProgressoDoAudio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuVolumeDoAudio(){
		assertTrue(materia.exibiuVolumeDoAudio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuBotaoDeMudoDoAudio(){
		assertTrue(materia.exibiuBotaoDeMudoDoAudio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuBarraDeVolumeDoAudio(){
		assertTrue(materia.exibiuBarraDeVolumeDoAudio());
	}
		
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void verificaSeOAudioPossuiUmaUrl(){
		assertTrue(materia.verificaSeOAudioPossuiUmaUrl());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void exibiuProgressTimeDoAudio() throws InterruptedException{
		assertTrue(materia.exibiuProgressTimeDoAudio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void exibiuTotalTimeDoAudio() throws InterruptedException{
		assertTrue(materia.exibiuTotalTimeDoAudio());
	}
}