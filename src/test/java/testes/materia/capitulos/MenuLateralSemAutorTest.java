package testes.materia.capitulos;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.capitulo.MenuLateralSemAutor;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class MenuLateralSemAutorTest {
	
	private static MenuLateralSemAutor materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuLateralSemAutor(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*CONFIGURAÇÃO DA MATÉRIA*/
	/*Todos os capitulos sem autor*/ 
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOsCapitulosConfiguradosSemAutorNaoEstaoExibindoOAutor() {
		assertTrue(materia.exibiuUmAutorParaCadaCapitulo());
	}
}