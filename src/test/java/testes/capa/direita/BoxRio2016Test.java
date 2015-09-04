package testes.capa.direita;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxRio2016;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxRio2016Test {
	
	private static BoxRio2016 capaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(capaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception{
		capaDaDireita = new BoxRio2016(Navegador.CHROME);
		capaDaDireita.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		capaDaDireita.executaScrollParaAparecerOTituloDeUmaPosicao(capaDaDireita.acessaBoxRio2016());
	}
	
	@AfterClass
	public static void depoisDeCadaTeste(){
		capaDaDireita.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxRio2016EstaSendoExibidonaPagina() throws InterruptedException{
		assertTrue(capaDaDireita.exibiuBoxRio2016());
	}	
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOBoxEstaExibindoUmaImagemComCropWidthEHeightCorretos() throws InterruptedException{
		assertTrue(capaDaDireita.exibiuImagemCropWidthHeightCorretamente());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOBoxComAsInformacoesDaMateriaEstaComBackgroundTransparente() {
		assertTrue(capaDaDireita.exibiuOBoxComBackgroundCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAImagemDoRio2016EstaSendoExibido() {
		assertTrue(capaDaDireita.exibiuImagemDoRio2016Corretamente());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAEditoriaDaMateriaEstaSendoExibido() {
		assertTrue(capaDaDireita.exibiuUmaEditoriaNoBox());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeOTituloDaMateriaEstaSendoExibido() {
		assertTrue(capaDaDireita.exibiuUmTituloNoBox());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeOBotaoDeAcessarOConteudoEmDestaqueEstaSendoExibido() {
		assertTrue(capaDaDireita.exibiuUmBotaoNoBox());
	}
}