package testes.ultimas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.ultimas.UltimasDaCapa;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class UltimasDaCapaTest {
	
	private static UltimasDaCapa ultimasNoticias;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ultimasNoticias = new UltimasDaCapa(Navegador.CHROME);
		ultimasNoticias.executaScrollParaAparecerOTituloDeUmaPosicao(ultimasNoticias.acessaDestaquePrincipal());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ultimasNoticias.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOTituloDeUltimasNoticiasEstaSendoExibido(){
		String tituloEsperado = "ÚLTIMAS NOTÍCIAS";
		assertEquals(tituloEsperado, ultimasNoticias.exibiuOTituloDeUltimas());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOLayoutTituloDeUltimasNoticiasDoElaEstaSendoExibido(){
		assertTrue(ultimasNoticias.exibiuOLayoutCorretoDoTituloDeUltimas());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeoBoxDeUltimasNoticiasEstaExibindoUmaChamadaComoDestaquePrincipal(){
		assertTrue(ultimasNoticias.exibiuDestaquePrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeoBoxDeUltimasNoticiasEstaExibindoApenasUmaChamadaComoDestaquePrincipal(){
		assertTrue(ultimasNoticias.exibiuApenasUmDestaquePrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAFotoEmDestaquePossuiOCropWidthEHeightEsperados(){
		assertTrue(ultimasNoticias.exibiuCropWidthEHeightCorretosParaAFotoEmDestaque());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAFotoEmDestaquePossuiUmLink(){
		assertTrue(ultimasNoticias.exibiuLinkNaFotoDaMateriaEmDestaque());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeOTituloEmDestaquePossuiNoMaximo120Caracteres(){
		assertTrue(ultimasNoticias.exibiuTituloEmDestaqueComNoMaximo120Caracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void exibiuODestaqueEsquerdaSuperior(){
		assertTrue(ultimasNoticias.exibiuDestaqueEsquerdaSuperior());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void exibiuODestaqueDireitaSuperior(){
		assertTrue(ultimasNoticias.exibiuDestaqueEsquerdaInferior());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeAsMateriasDeUltimasPossuemUmaFotoOuUmaDescricao(){
		assertTrue(ultimasNoticias.exibiuUmaImagemOuUmaDescricaoParaAsMaterias());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void exibiuLinkNasImagensDasMateriasDeUltimasCasoExista(){
		assertTrue(ultimasNoticias.exibiuLinkNasImagensDasMaterias());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeAFotoDeCadaUmaDasChamadasPossuiOCropWidthEHeightEsperados(){
		assertTrue(ultimasNoticias.exibiuCropHeightEWidthCorretosParaAsChamadas());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeAEditoriaDasChamadasDeUltimasEstaSendoExibida(){
		assertTrue(ultimasNoticias.exibiuEditoriaParaAsMateriasDeUltimas());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOLayoutDaEditoriaDasChamadasDeUltimasDoElaEstaoSendoExibidasCorretamente(){
		assertTrue(ultimasNoticias.exibiuLayoutCorretoParaAsEditoriaDasMateriasDeUltimas());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOTituloDasChamadasDeUltimasEstaoSendoExibidos(){
		assertTrue(ultimasNoticias.exibiuTituloParaAsMateriasDeUltimas());
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeOLayoutDosTituloDasChamadasDeUltimasEstaoSendoExibidosCorretamente(){
		assertTrue(ultimasNoticias.exibiuLayoutCorretoParaOTituloDasMateriasDeUltimas());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeOsTitulosDasChamadasDasMateriasPossuemNoMaximo100Caracteres(){
		assertTrue(ultimasNoticias.exibiuTituloDasChamadasComNoMaximo100DeCaracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void verificaSeOTempoDePostagemDasChamadasDasMateriasEstaoSendoExibidosCorretamente(){
		assertTrue(ultimasNoticias.exibiuTempoPostadoParaAsMateriasDeUltimas());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeOsTitulosDasChamadasDasMateriasPossuemUmLink(){
		assertTrue(ultimasNoticias.exibiuUmLinkNoTituloDasChamadasDeUltimasNoticias());
	}
}