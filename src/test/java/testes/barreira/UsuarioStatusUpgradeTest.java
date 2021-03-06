package testes.barreira;

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
public class UsuarioStatusUpgradeTest {

	private static Degustacao degustacao;
	private static LoginDegustacao login;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(degustacao.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		degustacao = new Degustacao(Navegador.CHROME);
 		login = new LoginDegustacao(degustacao.getDriver());
	}
		
	@AfterClass
	public static void depoisDeCadaTeste() {
		degustacao.fechar();
	}
	
	public void fluxoNavegacaoPaywall() throws Exception{
		degustacao.navegarPorOnzeMateriasDiferentes();
		degustacao.clicarNoBotaoAcessarMais10Materias();
		degustacao.clicarNoLinkEntre();
		login.efetuarLoginUpgrade();
		degustacao.clicarNoBotaoEntrar();
	}
	
	public void fluxoPaywall() throws Exception{
		degustacao.navegarPor10MateriasDiferentes();
	}

	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOUsuarioFoiRedirecionadoParaAUltimaURLAcessadaAntesDeCairNaPaginaDeDegustacao() throws Exception{
		fluxoNavegacaoPaywall();
		assertTrue(degustacao.redirecionouOUsuarioParaAUltimaURLAcessada());		
    }
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOStatusCookieDoRegisterWallFoiCorretamenteAtualizadoParaAutorizado() throws Exception{
		assertTrue(degustacao.exibiuOStatusDoCookiedoRegisterWallComoAutorizado());		
    }
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeADataDeAtualizacaoDoStatusCookieDoRegisterWallFoiCorretamenteAtualizadoParaDataDeHoje() throws Exception{
		assertTrue(degustacao.exibiuADataDoCookiedoRegisterWallAutorizada());		
    }
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAposNavegarPorMaisDezMateriasOStatusDeAcessoDoPaywallPassaASerUpgrade() throws Exception{
		fluxoPaywall();
		assertTrue(degustacao.exibiuOStatusDoCookiedoPaywallComoUpgrade());		
    }
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeOUsuarioUpgradeFoiRedirecionadoParaALoja() throws Exception{
		assertTrue(degustacao.redirecionouParaLoja());		
    }
}