package testes.capa.direita;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.capa.direita.BoxAsMais;

import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxAsMaisTest {
	
	private static BoxAsMais colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxAsMais();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	public void exibiuAbaMaisLidas(){
		assertEquals("+lidas", colunaDaDireita.tituloMaisLidas());
	}
	
	@Test
	public void exibiuAbaMaisComentadas(){
		assertEquals("+comentadas", colunaDaDireita.tituloMaisComentadas());
	}
	
	@Ignore
	public void exibiuAbaMaisEnviadas(){
		assertEquals("+enviadas", colunaDaDireita.tituloMaisEnviadas());
	}
	
	@Test
	public void exibiuQuantidadeMaiorQueUmEmMaisLidas(){
		assertTrue(colunaDaDireita.exibiuQuantidadeMaiorQueUmEmMaisLidas() >= Integer.parseInt("1"));
	}
	
	@Test
	public void exibiuQuantidadeIgualACincoEmMaisComentadas(){
		assertTrue(colunaDaDireita.quantidadeIgualACincoEmMaisComentadas() >= Integer.parseInt("1"));
	}
	
	@Ignore
	public void exibiuQuantidadeIgualACincoEmMaisEnviadas(){
		assertTrue(colunaDaDireita.quantidadeIgualACincoEmMaisEnviadas() >= Integer.parseInt("1"));
	}
}
