package testes.paginasEstaticas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.paginasEstaticas.FaleConosco;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class FaleConoscoMensagensDeErroTest {
	
	private static FaleConosco formulario;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		formulario = new FaleConosco(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		formulario.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void exibiuMensagemDeErroParaNomeEmBranco(){
		assertTrue(formulario.exibiuValidacaoParaNome());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void exibiuMensagemDeErroParaEmailmBranco(){
		assertTrue(formulario.exibiuValidacaoParaEmail());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void exibiuMensagemDeErroParaAssunto(){
		assertTrue(formulario.exibiuValidacaoParaAssunto());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void exibiuMensagemDeErroParaSuaMensagem(){
		assertTrue(formulario.exibiuValidacaoParaSuaMensagem());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void exibiuMensagemDeErroParaCaptcha(){
		assertTrue(formulario.exibiuValidacaoParaCaptcha());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void exibiuMensagemDeErroParaNomeAposPreenchimento(){
		assertTrue(formulario.exibiuValidacaoParaNomeAposPreenchimento());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void exibiuMensagemDeErroParaEmailAposPreenchimento(){
		assertTrue(formulario.exibiuValidacaoParaEmailAposPreenchimento());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void exibiuMensagemDeErroParaAssuntoAposPreenchimento(){
		assertTrue(formulario.exibiuValidacaoParaAssuntoAposPreenchimento());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void exibiuMensagemDeErroParaAposPreenchimento(){
		assertTrue(formulario.exibiuValidacaoParaSuaCaptchaAposPreenchimento());
	}
}