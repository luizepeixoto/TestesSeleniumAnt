package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.barraGloboCom.LogarNaBarraGloboComTest;
import testes.barreira.BarreiraLoginPaywallTest;
import testes.barreira.UsuarioStatusAutorizadoTest;
import testes.barreira.UsuarioStatusCanceladoTest;
import testes.barreira.UsuarioStatusDuplicadoTest;
import testes.barreira.UsuarioStatusEncerradoTest;
import testes.barreira.UsuarioStatusInexistenteTest;
import testes.barreira.UsuarioStatusUpgradeTest;

@RunWith(Suite.class)
@SuiteClasses( {
	
	/*testes.barraGloboCom*/
	LogarNaBarraGloboComTest.class,
	
	/*testes.barreira*/
	BarreiraLoginPaywallTest.class,
	UsuarioStatusAutorizadoTest.class,
	UsuarioStatusCanceladoTest.class,
	UsuarioStatusDuplicadoTest.class,
	UsuarioStatusEncerradoTest.class,
	UsuarioStatusInexistenteTest.class,
	UsuarioStatusUpgradeTest.class
	
})

public class BarreiraSuite {
	
}