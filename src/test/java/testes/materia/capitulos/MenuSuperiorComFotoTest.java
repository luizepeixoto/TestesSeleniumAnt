package testes.materia.capitulos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.capitulo.MenuSuperiorComFoto;


public class MenuSuperiorComFotoTest {
	
	private static MenuSuperiorComFoto materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuSuperiorComFoto();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*CONFIGURAÇÃO DA MATÉRIA*/
	/*Materia com 12 capitulos
	Todos os capitulos obrigatoriamente com foto
	Todas as matérias com autor
	Menu obrigatoriamente no topo*/ 
	
	/*Inicio da materia principal*/
	
	@Test
	public void verificaSeOAntitituloEstaSendoExibidoNoTopoDaMateriaPrincipal() {
		assertTrue(materia.exibiuUmAntitituloNoTopo());
	}
	
	@Test
	public void verificaSeOAntitituloEstaSendoExibidoComAlinhamentoAEsquerda() {
		assertTrue(materia.exibiuUmAntitituloAlinhadoAEsquerda());
	}
	
	@Test
	public void verificaSeOAntitituloEstaSendoExibidoComNoMaximo50Caracteres() {
		assertTrue(materia.exibiuUmAntitituloComNoMaximo50Caracteres());
	}
	
	@Test
	public void verificaSeAMateriaEmCapitulosEstaSendoExibidoNaPagina() {
		assertNotNull(materia.exibiuMateriaEmCapitulos());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalEstaSendoExibida() {
		assertNotNull(materia.exibiuFotoDoCabecalhoDaMateriaEmCapitulos());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalPossuiOWidthDe1500Px() {
		assertTrue(materia.exibiuFotoDaMateriaPrincipalComWidthCorreto());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalPossuiOHeightDe650Px() {
		assertTrue(materia.exibiuFotoDaMateriaPrincipalComHeightCorreto());
	}
	
	@Test
	public void verificaSeALegendaDaMateriaPrincipalNaoEstaSendoExibida() {
		assertTrue(materia.exibiuLegendaParaAFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAMateriaPrincipalEstaExibindoTitulo() {
		assertTrue(materia.exibiuTituloParaAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOSubtituloDaMateriaPrincipalEstaExibindo() {
		assertTrue(materia.exibiuSubtituloParaAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOAutorDaMateriaPrincipalEstaExibindo() {
		assertTrue(materia.exibiuAutorParaAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeADataDeCriacaoDaMateriaPrincipalEstaExibinda() {
		assertTrue(materia.exibiuDataParaAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeTextoDaMateriaPrincipalEstaExibindo() {
		assertTrue(materia.exibiuTextoParaAMateriaPrincipal());
	}
	
	/*Inicio da validação dos capitulos*/
	@Test
	public void verificaSeEstaSendoExibidoUmaListaDeDozeMaterias() {
		assertTrue(materia.exibiuUmaListaDeDozeMaterias());
	}
	
	@Test
	public void verificaSeCadaMateriaEstaExibindoONumeroDoCapitulo() {
		assertTrue(materia.exibiuONumeroDeCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaMateriaEstaExibindoONumeroCorretoDoCapitulo() {
		assertTrue(materia.exibiuONumeroCorretoParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloEstaEstaExibindoOAntiTituloDaMateria() {
		assertTrue(materia.exibiuUmAntiTituloParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloEstaEstaExibindoOTituloDaMateria() {
		assertTrue(materia.exibiuUmTituloParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloEstaEstaExibindoOAutorDaMateria() {
		assertTrue(materia.exibiuUmAutorParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloEstaExibindoUmaFotoNaAberturaDaMateria() {
		assertTrue(materia.exibiuUmaFotoParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaFotoNaAberturaDoCapituloEstaExibindoAClasseAnimadaParallax() {
		assertTrue(materia.exibiuAnimacaoParallaxUmaFotoNaAberturaDosCapitulo());
	}
	
	@Test
	public void verificaSeCadaFotoNaAberturaDoCapituloEstaExibindoUmaLegenda() {
		assertTrue(materia.exibiuLegendaParaAsFotosNaAberturaDosCapitulos());
	}
	
	@Test
	public void verificaSeCadaFotoNaAberturaDoCapituloEstaExibindoOAutorNaLegenda() {
		assertTrue(materia.exibiuAutorNasLegendasDasFotosNaAberturaDosCapitulos());
	}
	
	@Test
	public void verificaSeEmCadaCapituloEstaExibindoUmTexto() {
		assertTrue(materia.exibiuUmTextoEmCadaUmDosCapitulos());
	}
	
	/*Validação de banner arroba*/
	
	@Test
	public void verificaSeAMateriaEmCapituloPossuiApenasUmBannerArroba() {
		assertTrue(materia.exibiuBannerArroba());
	}
	
	@Test
	public void verificaSeOPrimeiroCapituloEstaExibindoOBannerArroba() {
		assertTrue(materia.exibiuBannerArrobaParaOPrimeiroCapitulo());
	}
	
	@Test
	public void verificaSeAlgumCapituloForaOPrimeiroEstaExibindoUmBannerArroba() {
		assertTrue(materia.exibiuBannerArrobaParaAlgumCapitulo());
	}
	
	@Test
	public void verificaSeAChamadaDaMateriaPrincipalEstaExibindoBannerArroba() {
		assertTrue(materia.exibiuBannerArrobaParaAMateriaPrincipal());
	}
}