package testes.materia.widget;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.widget.BoxFotogaleriaInline;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class BoxFotoGaleriaInlineTest {
	
	private static BoxFotogaleriaInline materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxFotogaleriaInline(Navegador.CHROME);
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.obterBoxDeFotogaleriaInline());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void verificaSeOBoxDeFotogaleriaInlineEstaSendoExibido(){
		assertTrue(materia.exibiuBoxDeFotogaleriaInline());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void verificaSeOBoxDeFotogaleriaInlinePossuiNoMinimoUmaFoto(){
		assertTrue(materia.exibiuNoMinimoUmaFotoNoBoxDeFotogaleriaInline());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void verificaSeOContadorAtualEhIgualAUm(){
		assertTrue(materia.exibiuOContadorAtualIgualAUm());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void verificaSeOContadorTotalEhIgualAoTotalDeFotosDoBox() {
		assertTrue(materia.exibiuOContadorTotalIgualAoTotalDeFotosDoBox());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void verificaSeASetaDeNavegacaoParaAEsquerdaEstaSendoExibida(){
		assertTrue(materia.exibiuSetaDeNavegacaoParaAEsquerda());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void verificaSeASetaDeNavegacaoParaADireitaEstaSendoExibida(){
		assertTrue(materia.exibiuSetaDeNavegacaoParaADireita());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void verificaSeASetaDeNavegacaoParaAEsquerdaEstaSendoExibidaDesabilitadaPorPadrao(){
		assertTrue(materia.exibiuASetaDeNavegacaoParaAEsquerdaDesabilitadaPorPadrao());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void verificaSeAoAvancarAsFotosOContadorAtualEhAtualizadoEAsImagensAsLegendasEOAutorExibidos() throws InterruptedException{
		assertTrue(materia.exibiuOContadorAtualSendoAtualizadoEAsImagensAsLegendasEOAutorAoAvancarAsFotos());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void verificaSeASetaDeNavegacaoParaADireitaEstaSendoExibidaDesabilitadaNaUltimaFoto() {
		assertTrue(materia.exibiuASetaDeNavegacaoParaADireitaDesabilitadaNaUltimaFoto());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void verificaSeOContadorAtualEhAtualizadoAoVoltarAsFotos() throws InterruptedException {
		assertTrue(materia.exibiuOContadorAtualSendoAtualizadoAoVoltarAsFotos());
	}
}