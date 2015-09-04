package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.agenda.AgendaEventosTest;

@RunWith(Suite.class)
@SuiteClasses( {
	
	AgendaEventosTest.class,
	
})

public class AgendaSuite {
	
}