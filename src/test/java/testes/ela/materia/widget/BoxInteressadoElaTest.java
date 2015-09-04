package testes.ela.materia.widget;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.materia.widget.BoxInteressadoEmEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxInteressadoElaTest {
	
	private static BoxInteressadoEmEla materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxInteressadoEmEla(Navegador.CHROME);
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.obterBoxInteressadoEm());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxVocePodeEstarInteressadoEmEstaSendoExibido(){
		assertTrue(materia.exibiuOBoxInteressadoEm());
	}
	
	@Test
	public void verificaSeOTituloDoBoxEstaSendoExibido(){
		assertTrue(materia.exibiuTitulo());
	}
	
	@Test
	public void verificaSeEstaoSendoExibidasCincoMateriaNoBox(){
		assertTrue(materia.exibiuCincoMaterias());
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibidaParaAsMateriasDaLista(){
		assertTrue(materia.exibiuEditoria());
	}
	
	@Test
	public void verificaSeAsImagensExibidasPossuemOCropCorretoEUmLink(){
		assertTrue(materia.exibiuOCropCorretoEUmLinkNasImagens());
	}
	
	@Test
	public void verificaSeOTituloEstaSendoExibidoParaAsMateriasDaLista(){
		assertTrue(materia.exibiuOTituloDasMaterias());
	}
	
	@Test
	public void verificaRegraDeExclusaoDasMateriasDentroDoBox(){
		assertTrue(materia.repetiuAlgumaMateriaDoBox());
	}
	
	@Test
	public void verificaRegraDeExclusaoDoBoxEAMateriaExibida(){
		assertTrue(materia.repetiuAMateriaNoBox());
	}
}