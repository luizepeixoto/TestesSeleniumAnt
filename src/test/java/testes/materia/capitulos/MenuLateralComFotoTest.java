package testes.materia.capitulos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.capitulo.MenuLateralComFoto;


public class MenuLateralComFotoTest {
	
	private static MenuLateralComFoto materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuLateralComFoto();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*CONFIGURAÇÃO DA MATÉRIA*/
	/*Materia com 12 capitulos
	Todas as matérias com autor
	As Matérias devem possuir fotos inline
	Menu obrigatoriamente no lateral*/ 
	
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
	
	/*Inicio da materia principal*/
	
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
	public void verificaSeALegendaDaMateriaPrincipalNaoEstaExibindoLegenda() {
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
	
	@Test
	public void verificaSeOHRNoFimDaMateriaPrincipalEstaExibindo() {
		assertTrue(materia.exibiuHRNoFimDaMateriaPrincipal());
	}
	
	/*Inicio da validação dos capitulos*/
	
	@Test
	public void verificaSeEstaSendoExibidoUmaListaDeDozeMaterias() {
		assertTrue(materia.exibiuUmaListaDeDozeMaterias());
	}
	
	@Test
	public void verificaSeCadaMateriaEstaExibindoONumeroDoCapitulo() {
		assertTrue(materia.exibiuONumeroEmAlgumCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloEstaEstaExibindoOTituloDaMateria() {
		assertTrue(materia.exibiuUmAntiTituloParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloNaoEstaEstaExibindoOSubtituloDaMateria() {
		assertTrue(materia.exibiuUmTituloParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloEstaEstaExibindoOAutorDaMateria() {
		assertTrue(materia.exibiuUmAutorParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloNaoEstaExibindoUmaFotoNaAberturaDaMateria() {
		assertTrue(materia.exibiuUmaFotoParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeEmCadaCapituloEstaExibindoUmTexto() {
		assertTrue(materia.exibiuUmTextoEmCadaUmDosCapitulos());
	}
	
	@Test
	public void verificaSeAsFotosInlineDentroDaMateriaDeCadaCapituloEstaSendoExibidaComOWidthCorreto() {
		assertTrue(materia.exibiuAsFotosInlineDosCapitulosComWidthCorreto());
	}
	
	@Test
	public void verificaSeAsFotosInlineDentroDaMateriaDeCadaCapituloEstaSendoExibidaComOHeightCorreto() {
		assertTrue(materia.exibiuAsFotosInlineDosCapitulosComHeightCorreto());
	}
	
	/*Validação do widget de navegação*/
	
	@Test
	public void verificaSeNoFimDaPaginaEstaNaoEstaSendoExibidoANavegacao() {
		assertTrue(materia.exibiuNavegacaoEntreMateriasNoFimDaPagina());
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