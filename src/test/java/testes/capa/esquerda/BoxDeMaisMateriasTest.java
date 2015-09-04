package testes.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.BoxDeMaisMaterias;


public class BoxDeMaisMateriasTest {
	
	private static BoxDeMaisMaterias ultimasChamadas;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ultimasChamadas = new BoxDeMaisMaterias();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ultimasChamadas.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeUltimasChamadasEstaSendoExibido(){
		assertNotNull(ultimasChamadas.getBoxDeUltimasChamadas());
	}
	
	@Test
	public void verificaSeOTituloDeUltimasChamadasEstaSendoExibido(){
		assertTrue(ultimasChamadas.oTituloEstaSendoExibido());
	}
	
	@Test
	public void verificaSeOTituloDaEditoriaDeUltimasChamadasEstaSendoExibidoEmMaiusculo(){
		assertTrue(ultimasChamadas.oTituloEstaSendoExibidoEmMaiusculo());
	}
	
	@Test
	public void verificaSeAListaDeUltimasChamadasEhMaiorQueZero(){
		assertTrue(ultimasChamadas.aListaDeMateriasEhMaiorQueZero());
	}
	
	@Test
	public void verificaSeAsMateriasDaListaDeUltimasChamadasEstaoExibindoUmTitulo(){
		assertTrue(ultimasChamadas.osItensDaListaDeMateriasPossuemUmTitulo());
	}
	
	@Test
	public void verificaSeAsMateriasDaListaDeUltimasChamadasEstaoExibindoUmLinkNoTitulo(){
		assertTrue(ultimasChamadas.osItensDaListaDeMateriasPossuemUmLinkNoTitulo());
	}
	
	@Test
	public void verificaSeAsURLsDasMateriasDaListaDeUltimasChamadasSaoValidas(){
		assertTrue(ultimasChamadas.osLinksDaListaDeMateriasSaoValidos());
	}
}