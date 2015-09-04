package testes.editorias;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;

import pages.editoria.BarraDeBuscaRioGastronomia;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BarraDeBuscaRioGastronomiaTest {
	
	private static BarraDeBuscaRioGastronomia editoria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(editoria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new BarraDeBuscaRioGastronomia(Navegador.FIREFOX);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuABarraDeBuscaRioGastronomia() {
		assertTrue(editoria.exibiuABarraDeBuscaRioGastronomia());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuCampoEspecialidade(){
		assertTrue(editoria.exibiuCampoEspecialidade());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuCampoBairro(){
		assertTrue(editoria.exibiuCampoBairro());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuCampoPreco(){
		assertTrue(editoria.exibiuCampoPreco());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuCheckBoxRestaurantesOrganicos(){
		assertTrue(editoria.exibiuCheckBoxRestaurantesOrganicos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuCheckBoxRestaurantesPremiados(){
		assertTrue(editoria.exibiuCheckBoxRestaurantesPremiados());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuBotaoEscolher(){
		assertTrue(editoria.exibiuBotaoEscolher());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuCampoBuscarRestaurante(){
		assertTrue(editoria.exibiuCampoBuscarRestaurante());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void exibiuBotaoOk(){
		assertTrue(editoria.exibiuBotaoOk());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void escolheuUmaEspecialidadeEClicouNoBotaoEscolher(){
		editoria.escolheuUmaEspecialidade();
		editoria.clicouNoBotaoEscolher();
		assertTrue(editoria.redirecionouParaPaginaComResultadoDaBusca());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void escolheuUmaEspecialidadeEUmBairroEClicouNoBotaoEscolher(){
		editoria.voltarPaginaAnterior();
		editoria.escolheuUmaEspecialidade();
		editoria.escolheuUmBairro();
		editoria.clicouNoBotaoEscolher();
		assertTrue(editoria.redirecionouParaPaginaComResultadoDaBusca());
		editoria.voltarPaginaAnterior();
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 12)
	public void escolheuUmaEspecialidadeEUmBairroEUmPrecoEClicouNoBotaoEscolher(){
		editoria.escolheuUmaEspecialidade();
		editoria.escolheuUmBairro();
		editoria.escolheuUmPreco();
		editoria.clicouNoBotaoEscolher();
		assertTrue(editoria.redirecionouParaPaginaComResultadoDaBusca());
		editoria.voltarPaginaAnterior();
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 13)
	public void escolheuUmaEspecialidadeEUmBairroEUmPrecoEMarcouCheckBoxRestaurantesOrganicosEClicouNoBotaoEscolher(){
		editoria.escolheuUmaEspecialidade();
		editoria.escolheuUmBairro();
		editoria.escolheuUmPreco();
		editoria.marcouCheckBoxRestaurantesOrganicos();
		editoria.clicouNoBotaoEscolher();
		assertTrue(editoria.redirecionouParaPaginaComResultadoDaBusca());
		editoria.voltarPaginaAnterior();
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 14)
	public void escolheuUmaEspecialidadeEUmBairroEUmPrecoEMarcouCheckBoxRestaurantesPremiadosEClicouNoBotaoEscolher(){
		editoria.escolheuUmaEspecialidade();
		editoria.escolheuUmBairro();
		editoria.escolheuUmPreco();
		editoria.marcouCheckBoxRestaurantesPremiados();
		editoria.clicouNoBotaoEscolher();
		assertTrue(editoria.redirecionouParaPaginaComResultadoDaBusca());
		editoria.voltarPaginaAnterior();
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 15)
	public void DigitouNomeDeUmRestauranteEClicouNoBotaoOkERetornouUmResultado(){
		editoria.digitouNomeDeUmRestaurante();
		editoria.clicouNoBotaoOk();
		assertTrue(editoria.redirecionouParaPaginaComResultadoDaBusca());
	}
}
