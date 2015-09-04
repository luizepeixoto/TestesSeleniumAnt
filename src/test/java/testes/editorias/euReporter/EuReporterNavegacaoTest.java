package testes.editorias.euReporter;

import static org.junit.Assert.*;
import login.LoginComentario;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.editoria.EuReporterWidget;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class EuReporterNavegacaoTest {
	
	private static EuReporterWidget colunaDaDireita;
	private static LoginComentario login;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new EuReporterWidget(Navegador.CHROME);
		colunaDaDireita.esperaCarregar(5);
		colunaDaDireita.executarScroll(colunaDaDireita.getDriver().findElement(By.className("col-right")).findElement(By.className("arroba")).getLocation());
		login = new LoginComentario(colunaDaDireita.getDriver());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDoEuReporterEstaSendoExibido() throws InterruptedException{
		colunaDaDireita.clicarNoBotaoDeEnviar();
		login.efetuarLoginCadum();
		colunaDaDireita.esperaCarregar(12);
		assertTrue(colunaDaDireita.exibiuPaginaDeUploadDoEuReporter());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOHeaderDaPaginaDoEuReporterEstaSendoExibidoOTituloEuReporter() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuNoHeaderOTituloEuReporter());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOHeaderDaPaginaDoEuReporterEstaSendoExibidoOTituloComoParticipar() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuNoHeaderOBotaoDeComoParticipar());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOBotaoDeComoParticiparEstaSendoExibindoOTituloCorretamente() throws InterruptedException{
		String tituloEsperado = "COMO PARTICIPAR";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuNoBotaoDeComoParticiparOTituloCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAoClicarNoBotaoDeComoParticiparORegulamentoEstaSendoExibido() throws InterruptedException{
		colunaDaDireita.clicarNoBotaoComoParticipar();
		colunaDaDireita.esperaCarregar(1);
		assertTrue(colunaDaDireita.exibiuORegulamentoCorretamente());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeOTituloDoCampoNomeEstaSendoExibido() throws InterruptedException{
		String tituloEsperado = "NOME";
		colunaDaDireita.clicarParaFecharORegulamento();
		assertEquals(tituloEsperado, colunaDaDireita.exibiuOTituloNome());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeOCampoNomeDoFormularioEstaSendoAutomaticamentePreenchido() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuONomePreenchido());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeOTituloDoCampoEmailEstaSendoExibido() throws InterruptedException{
		String tituloEsperado = "E-MAIL";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuOTituloEmail());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeOCampoEmailDoFormularioEstaSendoAutomaticamentePreenchido() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuOEmailPreenchido());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeOTituloDoCampoTelefoneEstaSendoExibido() throws InterruptedException{
		String tituloEsperado = "TELEFONE";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuOTituloTelefone());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOCampoTelefoneDoFormularioEstaSendoExibidoEmBranco() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuCampoDDDDoTelefoneEmBranco());
		assertTrue(colunaDaDireita.exibiuCampoDoTelefoneEmBranco());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeOTituloDoCampoMinhaNoticiaEstaSendoExibido() throws InterruptedException{
		String tituloEsperado = "MINHA NOTÍCIA";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuOTituloMinhaNoticia());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOCampoMinhaNoticiaDoFormularioEstaSendoExibidoEmBranco() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuCampoMinhaNoticiaEmBranco());
	}
	
 	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOTituloDoCaptchaEstaSendoExibido() throws InterruptedException{
		String tituloEsperado = "DIGITE O TEXTO DA IMAGEM:";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuOTituloDoCaptcha());
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeAImagemDeCaptchaEstaSendoExibida() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuImagemDoCaptcha());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeOCampoDeCaptchaEstaSendoExibido() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuCampoCampoDeCaptcha());
	}
	
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void verificaSeOLinkDeGerarOutroCaptchaEstaSendoExibido() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuLinkDeGerarCaptcha());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeOTituloDosPossiveisArquivosASeremEnviadosEstaoSendoExibidos() throws InterruptedException{
		String tituloEsperado = "MINHA FOTO, MEU VÍDEO OU MEU ÁUDIO";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuOTituloDosArquivos());
	}
	
	@OrdemExecucaoTeste(Ordem=19)
	@Test
	public void verificaSeEstaoSendoExibidosCincoPossiveisEntradasDeArquivosParaOFormulario() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuCincoInputsDeArquivos());
	}
	
	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeOBotaoDeRemoverArquivosEstaSendoExibido() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuBotaoDeRemoverArquivos());
	}
	
	@OrdemExecucaoTeste(Ordem=21)
	@Test
	public void verificaSeOBotaoDeRemoverArquivosEstaExibindoOTituloCorretamente() throws InterruptedException{
		String tituloEsperado = "Remover arquivos";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuTituloDeRemoverArquivos());
	}
	
	@OrdemExecucaoTeste(Ordem=22)
	@Test
	public void verificaSeOTituloDosTermosDeUsoEstaoSendoExibidosCorretamente() throws InterruptedException{
		String tituloEsperado = "Termos de Uso dos Serviços de Interatividade";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuTituloDeTermosDeUso());
	}
	
	@OrdemExecucaoTeste(Ordem=23)
	@Test
	public void verificaSeORegulamentoEstaSendoExibidoCorretamente() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuOBoxDeRegulamento());
	}
	
	@OrdemExecucaoTeste(Ordem=24)
	@Test
	public void verificaSeOCheckBoxDeTermosDeCompromissoEstaSendoExibidoCorretamente() throws InterruptedException{
		colunaDaDireita.executarScroll(colunaDaDireita.getDriver().findElement(By.className("form-estudante")).getLocation());
		colunaDaDireita.esperaCarregar(3);
		assertTrue(colunaDaDireita.exibiuOCheckBoxDeTermosDeCompromisso());
	}
	
	@OrdemExecucaoTeste(Ordem=25)
	@Test
	public void verificaSeOTituloDeTermosDeCompromissoEstaSendoExibidoCorretamente() throws InterruptedException{
		String tituloEsperado = "Aceito o termo de compromisso e cessão de direitos autorais";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuOTituloDosTermosDeCompromisso());
	}
	
	@OrdemExecucaoTeste(Ordem=26)
	@Test
	public void verificaSeOBotaoDeEnviarEstaSendoExibidoNoFimDaPagina() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuOBotaoDeEnviarNoFimDaPagina());
	}
}