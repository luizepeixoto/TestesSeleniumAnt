package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.capa.meio.BoxDeColunistasEBlogueirosTest;
import testes.capa.meio.BoxHumorTest;
import testes.capa.meio.BoxMateriaEspecialTest;
import testes.capa.meio.BoxOpinicaoDoGloboTest;
import testes.capa.meio.BoxVideosTest;
import testes.capa.meio.MancheteDuasColunasDuasManchetesComVideoTest;
import testes.capa.meio.MancheteDuasColunasDuasManchetesTest;
import testes.capa.meio.MancheteDuasColunasUmaMancheteComVideoHorizontalTest;
import testes.capa.meio.MancheteDuasColunasUmaMancheteFotoHorizontalTest;
import testes.capa.meio.MancheteDuasColunasUmaMancheteFotoVerticalTest;
import testes.capa.meio.MancheteHorizontalComVideoTest;
import testes.capa.meio.MancheteHorizontalTest;
import testes.capa.meio.MancheteInformePublicitarioComLinkExternoTest;
import testes.capa.meio.MancheteInformePublicitarioTest;
import testes.capa.meio.PublicidadeTest;
import testes.capa.meio.BoxCarrosselMancheteHorizontalTest;

@RunWith(Suite.class)
@SuiteClasses( {
	
	BoxCarrosselMancheteHorizontalTest.class,
	BoxDeColunistasEBlogueirosTest.class,
	BoxHumorTest.class,
	BoxMateriaEspecialTest.class,
	BoxOpinicaoDoGloboTest.class,
	BoxVideosTest.class,
	MancheteDuasColunasDuasManchetesComVideoTest.class,
	MancheteDuasColunasDuasManchetesTest.class,
	MancheteDuasColunasUmaMancheteComVideoHorizontalTest.class,
	MancheteDuasColunasUmaMancheteFotoHorizontalTest.class,
	MancheteDuasColunasUmaMancheteFotoVerticalTest.class,
	MancheteHorizontalComVideoTest.class,
	MancheteHorizontalTest.class,
	MancheteInformePublicitarioComLinkExternoTest.class,
	MancheteInformePublicitarioTest.class,
	PublicidadeTest.class
	
})

public class CapaColunaDoMeioSuite {
	
}