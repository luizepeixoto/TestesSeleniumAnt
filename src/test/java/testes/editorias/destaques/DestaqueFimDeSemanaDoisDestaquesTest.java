package testes.editorias.destaques;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.editoria.destaques.DestaqueFimDeSemanaDoisDestaques;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class DestaqueFimDeSemanaDoisDestaquesTest {
	
	private static DestaqueFimDeSemanaDoisDestaques editoria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(editoria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new DestaqueFimDeSemanaDoisDestaques(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	//Destaque Layout 1
	
	@Test
	public void verificaSeODestaqueDoFimDeSemanaEstaSendoExibido(){
		assertNotNull(editoria.exibiuDestaqueFimDeSemana());
	}
	
	//Início do primeiro Box com duas matérias
	
	@Test
	public void verificaSeOPrimeiroBoxDoDestaqueDoFimDeSemanaEstaSendoExibido(){
		assertNotNull(editoria.exibiuPrimeiroBoxDoDestaque());
	}
	
	@Test
	public void verificaSeAEditoriaDoPrimeiroBoxDoDestaqueDoFimDeSemanaEstaSendoExibido(){
		assertTrue(editoria.exibiuEditoriaDoPrimeiroBoxDoDestaque());
	}
	
	@Test
	public void verificaSeAEditoriaDoPrimeiroBoxDoDestaqueDoFimDeSemanaPossuiUmLink(){
		assertTrue(editoria.exibiuLinkNaEditoriaDoPrimeiroBoxDoDestaque());
	}
	
	@Test
	public void verificaSeAEditoriaDoPrimeiroBoxDoDestaqueDoFimDeSemanaPossuiUmLinkValido(){
		assertTrue(editoria.exibiuUmLinkValidoNaEditoriaDoPrimeiroBoxDoDestaque());
	}
	
	@Test
	public void verificaSeOTituloDoPrimeiroBoxDoDestaqueDoFimDeSemanaEstaSendoExibido(){
		assertTrue(editoria.exibiuTituloDoPrimeiroBoxDoDestaque());
	}
	
	@Test
	public void verificaSeOTituloDoPrimeiroBoxDoDestaqueDoFimDeSemanaPossuiOMaximoDeCaracteresPermitidos(){
		assertTrue(editoria.exibiuTituloDoPrimeiroBoxDoDestaqueComNoMaximo28Caracteres());
	}
	
	@Test
	public void verificaSeAsMateriasDoPrimeiroBoxPossuemEditoria(){
		assertTrue(editoria.exibiuEditoriaParaAsMateriasDoPrimeiroBox());
	}
	
	@Test
	public void verificaSeAsEditoriasDasMateriasDoPrimeiroBoxPossuemUmLink(){
		assertTrue(editoria.exibiuLinkNaEditoriaDasMateriasDoPrimeiroBox());
	}
	
	@Test
	public void verificaSeAsEditoriasDasMateriasDoPrimeiroBoxPossuemUmLinkValido(){
		assertTrue(editoria.exibiuLinkValidoNaEditoriaDasMateriasDoPrimeiroBox());
	}
	
	@Test
	public void verificaSeAsMateriasDoPrimeiroBoxPossuemUmTitulo(){
		assertTrue(editoria.exibiuTituloParaAsMateriasDoPrimeiroBox());
	}
	
	@Test
	public void verificaSeOsTitulosDasMateriasDoPrimeiroBoxPossuemUmLink(){
		assertTrue(editoria.exibiuTituloComLinkNasMateriasDoPrimeiroBox());
	}
	
	@Test
	public void verificaSeOsTitulosDasMateriasDoPrimeiroBoxPossuemUmLinkValido(){
		assertTrue(editoria.exibiuTituloComLinkValidoNasMateriasDoPrimeiroBox());
	}
	
	@Test
	public void verificaSeAsMateriasDoPrimeiroBoxPossuemUmTituloComOMaximoDeCaracteresPermitidos(){
		assertTrue(editoria.exibiuTituloParaAsMateriasDoPrimeiroBoxComNoMaximo60Caracteres());
	}
	
	@Test
	public void verificaSeAsMateriasDoPrimeiroBoxPossuemUmaImagem(){
		assertTrue(editoria.exibiuImagemParaAsMateriasDoPrimeiroBox());
	}
	
	@Test
	public void verificaSeAsImagemDoPrimeiroBoxPossuemOWidthDe100Px(){
		assertTrue(editoria.exibiuImagemDoPrimeiroBoxComWidhtCorreto());
	}
	
	@Test
	public void verificaSeAsImagemDoPrimeiroBoxPossuemOHeightDe100Px(){
		assertTrue(editoria.exibiuImagemDoPrimeiroBoxComHeightCorreto());
	}
	
	@Test
	public void verificaSeAImagemEmDestaqueDoLadoDireitoEstaSendoExibida(){
		assertTrue(editoria.exibiuImagemEmDestaqueDoPrimeiroBox());
	}
	
	@Test
	public void verificaSeAImagemEmDestaqueDoLadoDireitoPossuiOWidthCom220Px(){
		assertTrue(editoria.exibiuImagemEmDestaqueDoPrimeiroBoxComWidthDe220Px());
	}
	
	@Test
	public void verificaSeAImagemEmDestaqueDoLadoDireitoPossuiOHeightCom280Px(){
		assertTrue(editoria.exibiuImagemEmDestaqueDoPrimeiroBoxComHeightDe280Px());
	}
	
	//Início do Box Azul com foto
	
	@Test
	public void verificaSeOSegundoBoxDoDestaqueDoFimDeSemanaEstaSendoExibido(){
		assertNotNull(editoria.exibiuSegundoBoxDoDestaque());
	}
	
	@Test
	public void verificaSeOSegundoBoxDoDestaqueDoFimDeSemanaEstaExibindoAEditoria(){
		assertTrue(editoria.exibiuEditoriaParaSegundoBoxDoDestaque());
	}
	
	@Test
	public void verificaSeAEditoriaDoSegundoBoxDoDestaqueDoFimDeSemanaPossuiUmLink(){
		assertTrue(editoria.exibiuUmLinkNaEditoriaDoSegundoBoxDoDestaque());
	}
	
	@Test
	public void verificaSeOLinkNaEditoriaDoSegundoBoxDoDestaqueDoFimDeSemanaEhValido(){
		assertTrue(editoria.exibiuUmLinkValidoNaEditoriaDoSegundoBoxDoDestaque());
	}
	
	@Test
	public void verificaSeOSegundoBoxDoDestaqueDoFimDeSemanaEstaExibindoUmTitulo(){
		assertTrue(editoria.exibiuTituloParaSegundoBoxDoDestaque());
	}
	
	@Test
	public void verificaSeOTituloDoSegundoBoxDoDestaqueDoFimDeSemanaPossuiUmLink(){
		assertTrue(editoria.exibiuUmLinkNoTituloDoSegundoBoxDoDestaque());
	}
	
	@Test
	public void verificaSeOLinkDoTituloDoSegundoBoxDoDestaqueDoFimDeSemanaEhValido(){
		assertTrue(editoria.exibiuUmLinkValidoNoTituloDoSegundoBoxDoDestaque());
	}
	
	@Test
	public void verificaSeOSegundoBoxDoDestaqueDoFimDeSemanaEstaExibindoUmTituloComOMaximoDeCaracteresPermitidos(){
		assertTrue(editoria.exibiuTituloParaSegundoBoxDoDestaqueComNoMaximo50Caracteres());
	}
	
	@Test
	public void verificaSeAImagemDoSegundoBoxEstaSendoExibida(){
		assertTrue(editoria.exibiuImagemEmDestaqueDoSegundoBox());
	}
	
	@Test
	public void verificaSeAImagemEmDestaqueDoSegundoBoxPossuiOWidthCom209Px(){
		assertTrue(editoria.exibiuImagemDoSegundoBoxComWidthDe209Px());
	}
	
	@Test
	public void verificaSeAImagemEmDestaqueDoSegundoBoxPossuiOHeightCom178Px(){
		assertTrue(editoria.exibiuImagemEmDestaqueDoSegundoBoxComHeightDe178Px());
	}
	
	@Test
	public void verificaSeUmLinkNaImagemDoSegundoBox(){
		assertTrue(editoria.exibiuLinkNaImagemEmDestaqueDoSegundoBox());
	}
	
	@Test
	public void verificaSeUmLinkValidoNaImagemDoSegundoBox(){
		assertTrue(editoria.exibiuUmLinkValidoNaImagemEmDestaqueDoSegundoBox());
	}
}
