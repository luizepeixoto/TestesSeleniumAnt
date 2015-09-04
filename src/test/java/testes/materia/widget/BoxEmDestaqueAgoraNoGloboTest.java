package testes.materia.widget;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.widget.BoxEmDestaque;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxEmDestaqueAgoraNoGloboTest {
	
	private static BoxEmDestaque materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxEmDestaque(Navegador.CHROME);
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.obterBoxEmDestaque());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxEmDestaqueAgoraNoGloboEstaSendoExibido(){
		assertTrue(materia.exibiuBoxEmDestaque());
	}
	
	@Test
	public void verificaSeOTituloDoBoxEstaSendoExibido(){
		assertTrue(materia.exibiuTitulo());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmaListaDeMateriasIgualACinco(){
		assertTrue(materia.exibiuListaDeMaterias());
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibidaParaAsMateriasDaLista(){
		assertTrue(materia.exibiuEditoria());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmaFotoOuADescricaoDaMateria(){
		assertTrue(materia.exibiuImagemOuDescricao());
	}
	
	@Test
	public void verificaSeOTituloEstaSendoExibidoParaAsMateriasDaLista(){
		assertTrue(materia.exibiuOTituloDasMaterias());
	}
	
	@Test
	public void verificaSeTituloDasMateriasPossuemNoMaximo72Caracteres(){
		assertTrue(materia.exibiuTituloComNoMaximo72Caracteres());
	}
	
	@Test
	public void verificaRegraDeExclusaoDasMateriasDentroDoBox(){
		assertTrue(materia.repetiuAlgumaMateriaDoBox());
	}
	
	@Test
	public void verificaRegraDeExclusaoDoBoxEAMateriaExibida(){
		assertTrue(materia.repetiuAMateriaNoBox());
	}
	
	@Test
	public void verificaSeOBoxEmDestaqueAgoraNoGloboNaoEstaExibindoAlgumaMateriaDeEspecialPublicitario(){
		assertTrue(materia.naoExibiuMateriaDeEspecialPublicitarioNoBoxEmDestaqueAgoraNoGLobo());
	}
}