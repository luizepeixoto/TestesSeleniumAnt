package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.Materia;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class MateriaSemFotoTest {
	
	private static Materia materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new Materia(Navegador.CHROME);
		materia.esperaCarregar(3);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxHeaderDaMateriaEstaSendoExibidoNaPagina(){
		assertNotNull(materia.acessaClasseHeadMateria());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOTituloDaMateriaEstaSendoExibido(){
		assertTrue(materia.exibiuTituloDamateria());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeADescricaoDaMateriaEstaSendoExibida(){
		assertTrue(materia.exibiuDescricaoDaMateria());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOAutorDaMateriaEstaSendoExibido(){
		assertTrue(materia.exibiuAutorDaMateria());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeODataDaMateriaEstaSendoExibida(){
		assertTrue(materia.exibiuDataDaMateria());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeODataDeAtualizacaoDeUmaMateriaEstaSendoExibida(){
		assertTrue(materia.exibiuDataDeAtualizacaoDamateria());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeOTextoDeUmaMateriaEstaSendoExibido(){
		assertTrue(materia.exibiuTestoDaMateria());
	}
}