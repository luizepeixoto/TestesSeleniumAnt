package testes.materia.menu;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.menu.MenuDestaques;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class DestaquesTest {
	
	private static MenuDestaques menuDestaques;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(menuDestaques.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		menuDestaques = new MenuDestaques(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		menuDestaques.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificarExistenciaDoBoxDeDestaquesNoMenu(){
		assertNotNull(menuDestaques.getDestaquesDoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOTituloAssuntosEmDestaqueEstaSendoExibidoNoMenu() throws InterruptedException{
		assertTrue(menuDestaques.oTituloAssuntosEmDestaqueEstaSendoExibidoNoMenu());
	}

	@Test
	@OrdemExecucaoTeste(Ordem=3)
	public void verificaSeOMenuPossuiMateriasEmDestaquesPrincipais(){
		assertTrue(menuDestaques.oMenuPossuiDestaquesPrincipais());
	}

	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeExibiuFotoParaOPrimeiroDestaqueOuSubtituloValido() throws InterruptedException{
		assertNotNull(menuDestaques.aPrimeiraMateriaEmDestaquePossuiFoto());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void seExibiuFotoParaOPrimeiroDestaqueOWidthEhDe380Px() throws InterruptedException{
		assertTrue(menuDestaques.oWidthDaFotoEhDe380Px());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void seExibiuFotoParaOPrimeiroDestaqueOHeightEhDe380Px() throws InterruptedException{
		assertTrue(menuDestaques.oHeightDaFotoEhDe230Px());
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeExibiuFotoParaOSegundoDestaqueOuSubtituloValido() throws InterruptedException{
		assertNotNull(menuDestaques.aSegundaMateriaEmDestaquePossuiFoto());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void seExibiuFotoParaOSegundoDestaqueOWidthEhDe380Px() throws InterruptedException{
		assertTrue(menuDestaques.oWidthDaSegundaFotoEhDe380Px());
	}
	
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void seExibiuFotoParaOSegundoDestaqueOHeightEhDe380Px() throws InterruptedException{
		assertTrue(menuDestaques.oHeightDaSegundaFotoEhDe230Px());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeOsTitulosDasMateriasEmDestaqueEstaoSendoExibidos() throws InterruptedException{
		assertNotNull(menuDestaques.osTitulosDasMateriasEmDestaqueEstaoSendoExibidos());
	}
	
	@OrdemExecucaoTeste(Ordem=19)
	@Test
	public void verificaSeAListaDeMateriasRelacionadasEstaSendoExibida() throws InterruptedException{
		assertTrue(menuDestaques.aListaDeMateriaEmDestaqueEstaSendoExibida());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeAsMateriasRelacionadasPossuemTitulo() throws InterruptedException{
		assertTrue(menuDestaques.asMateriasEmDestaquePossuemTitulo());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=21)
	@Test
	public void verificaSeAsMateriasRelacionadasPossuemUmLink() throws InterruptedException{
		assertFalse(menuDestaques.asMateriasEmDestaquePossuemUmLinkNoTitulo());
	}
	
	@OrdemExecucaoTeste(Ordem=22)
	@Test
	public void verificaSeOsLinksDasMateriasRelacionadasSaoValidos() throws InterruptedException{
		assertTrue(menuDestaques.oLinkNoTituloDasMateriasEmDestaqueEhValido());
	}
	
//	@OrdemExecucaoTeste(Ordem=23)
//	@Test
//	public void verificaSeOTituloAssuntosEmDestaqueEstaSendoExibidoNoMenu() throws InterruptedException{
//		assertTrue(menuDestaques.oTituloAssuntosEmDestaqueEstaSendoExibidoNoMenu());
//	}
}
