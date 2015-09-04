package testes.materia.capitulos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.capitulo.MenuLateralNavegacao;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class MenuLateralNavegacaoTest {
	
	private static MenuLateralNavegacao materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuLateralNavegacao(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOMenuEstaSendoChamandoNaLateralDaPagina() {
		assertNotNull(materia.exibiuMenuNaLateral());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOMenuLateralEstaTrazendoOsDozeCapitulosDasMaterias() {
		assertTrue(materia.exibiuUmaListaDe12Capitulos());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOMenuEstaTrazendoOTituloDeCadaMateria() throws InterruptedException {
		assertTrue(materia.exibiuTituloDeCadaMateriaNaChamadaDoMenuLateral());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeCadaTituloDosCapitulosNoMenuLateralCorrespondeAosTitulosDasMaterias() throws InterruptedException {
		assertTrue(materia.exibiuOTituloCorretoNoMenuLateralParaCadaCapituloDoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeCadaTituloDosCapitulosNoMenuLateralPossuiUmLink() throws InterruptedException {
		assertTrue(materia.exibiuUmLinkNoMenuLateralParaCadaUmDosCapitulos());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeOMenuEstaRedirecionandoOUsuarioAoClicarNosCapitulos() throws InterruptedException {
		assertTrue(materia.executaNavegacaoPeloMenu());
	}
}