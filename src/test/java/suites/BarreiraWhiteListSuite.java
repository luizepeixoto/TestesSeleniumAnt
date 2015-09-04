package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.barreira.WhiteList.BarreiraEspecialPublicitarioTest;
import testes.barreira.WhiteList.PaywallWhiteListFacebookTest;
import testes.barreira.WhiteList.PaywallWhiteListTwitterTest;
import testes.barreira.WhiteList.PaywallWhiteListWhatsAppTest;
import testes.barreira.WhiteList.RegisterWhiteListFacebookTest;
import testes.barreira.WhiteList.RegisterWhiteListTwitterTest;
import testes.barreira.WhiteList.RegisterWhiteListWhatsAppTest;

@RunWith(Suite.class)
@SuiteClasses( {
	
	BarreiraEspecialPublicitarioTest.class,
	PaywallWhiteListFacebookTest.class,
	PaywallWhiteListTwitterTest.class,
	PaywallWhiteListWhatsAppTest.class,
	RegisterWhiteListFacebookTest.class,
	RegisterWhiteListTwitterTest.class,
	RegisterWhiteListWhatsAppTest.class
	
})

public class BarreiraWhiteListSuite {
	
}