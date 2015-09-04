package testes.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.capa.esquerda.BoxDeMaisMaterias;

@Ignore
public class BoxDeMaisMateriasComTarjaTest {
	
	private static BoxDeMaisMaterias ultimasChamadasComTarja;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ultimasChamadasComTarja = new BoxDeMaisMaterias();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ultimasChamadasComTarja.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeUltimasChamadasEstaSendoExibido(){
		assertNotNull(ultimasChamadasComTarja.getBoxDeUltimasChamadasComTarja());
	}
	
	@Test
	public void verificaSeOTituloDeUltimasChamadasEstaSendoExibido(){
		assertTrue(ultimasChamadasComTarja.oTituloDoBoxComTarjaEstaSendoExibido());
	}
	
	@Test
	public void verificaSeOTituloDaEditoriaDeUltimasChamadasEstaSendoExibidoEmMaiusculo(){
		assertTrue(ultimasChamadasComTarja.oTituloDaEditoriaDoBoxComTarjaEstaSendoExibidoEmMaiusculo());
	}
	
	@Test
	public void verificaSeAListaDeUltimasChamadasEhMaiorQueZero(){
		assertTrue(ultimasChamadasComTarja.aListaDeMateriasDoBoxComTarjaEhMaiorQueZero());
	}
	
	@Test
	public void verificaSeAsMateriasDaListaDeUltimasChamadasEstaoExibindoUmaTarja(){
		assertTrue(ultimasChamadasComTarja.osItensDaListaDeMateriasDoBoxComTarjaPossuemUmaTarja());
	}
	
	@Test
	public void verificaSeAsMateriasDaListaDeUltimasChamadasEstaoExibindoUmTitulo(){
		assertTrue(ultimasChamadasComTarja.osItensDaListaDeMateriasDoBoxComTarjaPossuemUmTitulo());
	}
	
	@Test
	public void verificaSeAsMateriasDaListaDeUltimasChamadasEstaoExibindoUmLinkNoTitulo(){
		assertTrue(ultimasChamadasComTarja.osItensDaListaDeMateriasDoBoxComTarjaPossuemUmLinkNoTitulo());
	}
	
	@Test
	public void verificaSeAsURLsDasMateriasDaListaDeUltimasChamadasSaoValidas(){
		assertTrue(ultimasChamadasComTarja.osLinksDaListaDeMateriasDoBoxComTarjaSaoValidos());
	}
}