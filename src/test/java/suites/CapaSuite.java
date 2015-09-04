package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.capa.CabecalhoBarrinhaTest;
import testes.capa.CabecalhoBuscaTest;
import testes.capa.CabecalhoCentralTest;
import testes.capa.CabecalhoEditoriasTest;
import testes.capa.CabecalhoPublicidadeTest;
import testes.capa.CabecalhoTopicosTest;

@RunWith(Suite.class)
@SuiteClasses( {
	
	CabecalhoBarrinhaTest.class,
	CabecalhoBuscaTest.class,
	CabecalhoCentralTest.class,
	CabecalhoEditoriasTest.class,
	CabecalhoPublicidadeTest.class,
	CabecalhoTopicosTest.class
	
})

public class CapaSuite {
	
}