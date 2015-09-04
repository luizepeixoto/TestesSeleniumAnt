package testes.paginasEstaticas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.paginasEstaticas.FaleConosco;


public class FaleConoscoTest {
	
	private static FaleConosco formulario;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		formulario = new FaleConosco();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		formulario.fechar();
	}
	
	@Ignore
	@Test
	public void exibiuPublicidadeNoTopoDaPagina(){
		assertNotNull(formulario.exibiuPublicidade());
	}
	
	@Test
	public void exibiuBoxDoFormulario(){
		assertNotNull(formulario.exibiuFormulario());
	}
	
	@Test
	public void exibiuTextoDoFormulario(){
		assertTrue(formulario.exibiuTexto());
	}
	
	@Test
	public void exibiuLabelNome(){
		assertTrue(formulario.exibiuLabelNome());
	}
	
	@Test
	public void exibiuTextBoxParaNome(){
		assertTrue(formulario.exibiuTextBoxParaNome());
	}
	
	@Test
	public void exibiuLabelEmail(){
		assertTrue(formulario.exibiuLabelEmail());
	}
	
	@Test
	public void exibiuTextBoxParaEmail(){
		assertTrue(formulario.exibiuTextBoxParaEmail());
	}
	
	@Test
	public void exibiuLabelDeOndeAcessa(){
		assertTrue(formulario.exibiuLabelDeOndeAcessa());
	}
	
	@Test
	public void exibiuComboDeOndeAcessa(){
		assertTrue(formulario.exibiuComboDeOndeAcessa());
	}
	
	@Test
	public void exibiuOpcoesParaOComboDeOndeAcessa(){
		assertTrue(formulario.exibiuOpcoesParaOComboDeOndeAcessa());
		assertTrue(formulario.exibiuValueOpcoesParaOComboDeOndeAcessa());
	}
	
	@Test
	public void exibiuLabelAssunto(){
		assertTrue(formulario.exibiuLabelAssunto());
	}
	
	@Test
	public void exibiuComboAssunto(){
		assertTrue(formulario.exibiuComboAssunto());
	}
	
	@Test
	public void exibiuOpcoesParaOComboAssunto(){
		assertTrue(formulario.exibiuOpcoesParaOComboAssunto());
		assertTrue(formulario.exibiuValueOpcoesParaOComboAssunto());
	}
	
	@Test
	public void exibiuLabelSuaMensagem(){
		assertTrue(formulario.exibiuLabelSuaMensagem());
	}
	
	@Test
	public void exibiuTextAreaSuaMensagem(){
		assertTrue(formulario.exibiuComboSuaMensagem());
	}
	
	@Test
	public void exibiuTextoDoCaptcha(){
		String textoEsperado="Digite o texto da imagem ao lado:";
		assertEquals(textoEsperado, formulario.exibiuTextoCaptcha());
	}
	
	@Test
	public void exibiuTextBoxDoCaptcha(){
		assertTrue(formulario.exibiuTextBoxDoCaptcha());
	}
	
	@Test
	public void exibiuImagemDoCaptcha(){
		assertTrue(formulario.exibiuImagemDoCaptcha());
	}
	
	@Test
	public void exibiuBotaoDeLimpar(){
		assertTrue(formulario.exibiuBotaoDeLimpar());
	}
	
	@Test
	public void exibiuTextoLimparDoBotaoLimpar(){
		assertTrue(formulario.exibiuTextoLimparDoBotaoLimpar());
	}
	
	@Test
	public void exibiuBotaoDeEnviar(){
		assertTrue(formulario.exibiuBotaoDeEnviar());
	}
	
	@Test
	public void exibiuTextoEnviarDoBotaoLimpar(){
		assertTrue(formulario.exibiuTextoEnviarDoBotaoLimpar());
	}
	
	@Ignore
	@Test
	public void exibiuTextoNoFimDoBox(){
		String textoEsperado="Se preferir, ligue para o Serviço de Atendimento ao Leitor do Globo, no telefone (21) 2534-5200 de 2ª a 6ª feira, das 6h30 às 19h, e aos sábados, domingos e feriados, das 7h às 12h";
		assertEquals(textoEsperado, formulario.exibiuTextoNoFimDoBox());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaNaoEstaSendoExibido(){
		assertTrue("O Banner está sendo exibido. Verifique se está configurado.", formulario.exibiuBannerDeAssinatura());
	}
}