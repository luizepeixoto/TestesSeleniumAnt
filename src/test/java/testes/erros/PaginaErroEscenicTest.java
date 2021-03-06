package testes.erros;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.erros.PaginaErroEscenic;


public class PaginaErroEscenicTest {
	
	private static PaginaErroEscenic pagina;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		pagina = new PaginaErroEscenic();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		pagina.fechar();
	}
	
	@Test
	public void exibiuOTituloSiteEmManutencao(){
		String tituloEsperado="Site temporariamente em manutenção. Voltaremos em breve.";
		assertEquals(tituloEsperado, pagina.exibiuOTituloNaPagina());
	}
	
	@Test
	public void exibiuOTituloOGlobo(){
		assertTrue(pagina.exibiuOTituloOGlobo());
	}
	
	@Test
	public void exibiuAData(){
		assertTrue(pagina.exibiuAData());
	}
	
	@Test
	public void exibiuAPrimeiraMateriaComoDestaque(){
		assertTrue(pagina.exibiuAPrimeiraMateriaComoDestaque());
	}
	
	@Test
	public void exibiuUmaListaDeUltimasMateriasPublicadas(){
		assertTrue(pagina.exibiuAPrimeiraMateriaComoDestaque());
	}
	
	@Test
	public void exibiuTituloParaAsMateriasDasUltimasPublicadas(){
		assertTrue(pagina.exibiuTituloParaAsMaterias());
	}
	
	@Test
	public void exibiuDescricaoParaAsMateriasDasUltimasPublicadas(){
		assertTrue(pagina.exibiuDescricaoParaAsMaterias());
	}
	
	@Test
	public void exibiuORodapeNaPagina(){
		String tituloEsperado="© 1996 - 2014. Todos os direitos reservados a Infoglobo Comunicação e Participações S.A. Este material não pode ser publicado, transmitido por broadcast, reescrito ou redistribuição sem autorização.";
		assertEquals(tituloEsperado, pagina.exibiuRodape());
	}
}