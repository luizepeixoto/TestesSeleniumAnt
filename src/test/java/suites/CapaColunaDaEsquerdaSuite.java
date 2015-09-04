package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.capa.esquerda.ChamadaComFotoTest;
import testes.capa.esquerda.ChamadaComWebChamadasComTarjaTest;
import testes.capa.esquerda.ChamadaComWebChamadasTest;
import testes.capa.esquerda.ChamadaConteudoComVideoTest;
import testes.capa.esquerda.ChamadaInformePublicitarioLinkExternoTest;
import testes.capa.esquerda.ChamadaInformePublicitarioTest;
import testes.capa.esquerda.ChamadaMateriaEspecialTest;
import testes.capa.esquerda.ChamadaPrincipalTest;
import testes.capa.esquerda.ChamadaSecundariaComTarjaTest;
import testes.capa.esquerda.ChamadaSemEditoriaTest;
import testes.capa.esquerda.BoxDeMaisMateriasComTarjaTest;
import testes.capa.esquerda.BoxDeMaisMateriasTest;

@RunWith(Suite.class)
@SuiteClasses( {
	
	BoxDeMaisMateriasComTarjaTest.class,
	BoxDeMaisMateriasTest.class,
	ChamadaComFotoTest.class,
	ChamadaComWebChamadasComTarjaTest.class,
	ChamadaComWebChamadasTest.class,
	ChamadaConteudoComVideoTest.class,
	ChamadaInformePublicitarioLinkExternoTest.class,
	ChamadaInformePublicitarioTest.class,
	ChamadaMateriaEspecialTest.class,
	ChamadaPrincipalTest.class,
	ChamadaSecundariaComTarjaTest.class,
	ChamadaSemEditoriaTest.class,
	
})

public class CapaColunaDaEsquerdaSuite {
	
}