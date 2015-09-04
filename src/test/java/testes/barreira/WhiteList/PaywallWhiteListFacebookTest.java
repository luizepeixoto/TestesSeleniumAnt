package testes.barreira.WhiteList;

import static org.junit.Assert.assertTrue;
import login.LoginDegustacao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.barreira.Degustacao;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class PaywallWhiteListFacebookTest {

	private static Degustacao barreira;
	private static LoginDegustacao login;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(barreira.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		barreira = new Degustacao(Navegador.CHROME);
 		login = new LoginDegustacao(barreira.getDriver());
	}
		
	@AfterClass
	public static void depoisDeCadaTeste() {
		barreira.fechar();
	}
	
	public void fluxoNavegacaoRegisterWall() throws Exception{
		barreira.navegarPorOnzeMateriasDiferentes();
		barreira.clicarNoBotaoAcessarMais10Materias();
		barreira.clicarNoLinkEntre();
		login.efetuarLoginEncerrado();
		barreira.clicarNoBotaoEntrar();
	}
	
	public void fluxoDoPaywallComCompartilhamentoWhiteList() throws Exception{
		barreira.navegarPor11MateriasDiferentesComCompartilhamentoWhiteList("Facebook");
	}

	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOUsuarioFoiRedirecionadoParaAUltimaURLAcessadaAntesDeCairNaPaginaDeDegustacao() throws Exception{
		fluxoNavegacaoRegisterWall();
		fluxoDoPaywallComCompartilhamentoWhiteList();
		assertTrue(barreira.exibiuMateriaSemApresentarBarreira());		
    }
}