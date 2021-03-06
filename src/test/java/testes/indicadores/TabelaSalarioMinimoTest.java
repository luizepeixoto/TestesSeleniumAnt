package testes.indicadores;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.indicadores.Indicadores;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class TabelaSalarioMinimoTest {
	
	private static Indicadores salarioMinimo;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(salarioMinimo.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		salarioMinimo = new Indicadores(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		salarioMinimo.fechar();
	}
	
	@Test
	public void exibiuTabelaDeSalarioMinimo(){
		assertNotNull(salarioMinimo.exibiuTabelaDoSalarioMinimo());
	}
	
	@Test
	public void exibiuTituloDeSalarioMinimo(){
		String tituloEsperado="SALÁRIO MÍNIMO";
		assertEquals(tituloEsperado, salarioMinimo.exibiuTituloDoSalarioMinimo());
	}
	
	@Ignore
	@Test
	public void verificaSeAPrimeiraLinhaDaTabelaDeSalarioMinimoEstaExibindoInformacoesValidas(){
		assertTrue("Não exibiu primeira linha da coluna De Salario Minimo", salarioMinimo.exibiuPrimeiraLinhaDaColunaDescricaoDoSalarioMinimo());
		assertTrue("Não exibiu primeira linha da coluna Valor De Salario Minimo", salarioMinimo.exibiuPrimeiraLinhaDaColunaValorDoSalarioMinimo());
	}
	
	@Test
	public void exibiuOBoxDeObservacao(){
		String textoEsperadoNoPrimeiroParagrafo="* Piso para empregado doméstico, servente, contínuo, mensageiro, auxiliar de serviços gerais e funcionário do comércio não especializado, entre outros.";
		assertEquals(textoEsperadoNoPrimeiroParagrafo, salarioMinimo.exibiuPrimeiroParagrafoDeObservacaoDoSalarioMinimo());
	}
}