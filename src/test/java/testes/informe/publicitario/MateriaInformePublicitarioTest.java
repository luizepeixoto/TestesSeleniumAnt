package testes.informe.publicitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.MateriaInformePublicitario;


public class MateriaInformePublicitarioTest {
	
	private static MateriaInformePublicitario materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaInformePublicitario();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeAMateriaEhDoTipoInformePublicitario(){
		assertNotNull(materia.exibiuMateriaDoTipoInformePublicitario());
	}
	
	@Test
	public void verificaSeOTituloDeInformePublicitarioEstaSendoExibidoNoTopoDaPagina(){
		assertTrue(materia.exibiuTituloDeInformePublicitario());
	}
	
	@Test
	public void verificaSeOTituloDeInformePublicitarioPossuiUmLink(){
		assertTrue(materia.exibiuTituloDeInformePublicitarioComLink());
	}
	
	@Test
	public void verificaSeOTituloDeInformePublicitarioPossuiUmLinkValido(){
		assertTrue(materia.exibiuTituloDeInformePublicitarioComLinkValido());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEstaSendoExibidoEmItalico(){
		assertTrue(materia.exibiuTituloDaMateriaEmItalico());
	}
	
	@Test
	public void verificaSeOAutorPatrocinadoEstaSendoExibido(){
		assertNotNull(materia.exibiuBoxDeAutorPatrocinado());
	}
	
	@Test
	public void verificaSeAImagemDoPatrocinadorEstaSendoExibido(){
		assertTrue(materia.exibiuImagemDoPatrocinador());
	}
	
	@Test
	public void verificaSeONomeDoAutorPatrocinadorEstaSendoExibido(){
		assertTrue(materia.exibiuNomePatrocinador());
	}
	
	@Test
	public void verificaSeAPalavraPorEstaSendoExibidaAntesDoNomeDoAutorPatrocinador(){
		assertTrue(materia.exibiuAPalavraPorAntesDoNomePatrocinador());
	}
	
	@Test
	public void verificaSeAFraseDeResponsabilidadeEstaSendoExibida(){
		String resultadoEsperado = "Conteúdo de responsabilidade do anunciante";
		assertEquals(resultadoEsperado.toLowerCase(), materia.exibiuFraseDeResponsabilidadeDoPatrocinador());
	}
	
	@Test
	public void verificaSeOBoxDePaginacaoDeMateriasNaoEstaSendoExibido(){
		assertTrue(materia.exibiuBoxDePaginacao());
	}
}