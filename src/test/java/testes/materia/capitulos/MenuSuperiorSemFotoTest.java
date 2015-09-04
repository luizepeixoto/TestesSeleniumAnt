package testes.materia.capitulos;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.capitulo.MenuSuperiorSemFoto;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class MenuSuperiorSemFotoTest {
	
	private static MenuSuperiorSemFoto materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuSuperiorSemFoto(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*CONFIGURAÇÃO DA MATÉRIA*/
	/*Matéria Principal Sem foto no Topo, autor e conteudo texto
	Materia com 12 capitulos
	Todos os capitulos obrigatoriamente sem foto
	Todas as matérias com autor
	Menu obrigatoriamente no topo*/ 
	
	@Test
	public void verificaSeOAntitituloEstaSendoExibidoNoTopoDaMateriaPrincipal() {
		assertTrue(materia.exibiuUmAntitituloNoTopo());
	}
	
	@Test
	public void verificaSeOAntitituloEstaSendoExibidoComAlinhamentoAoCentro() {
		assertTrue(materia.exibiuUmAntitituloAlinhadoAoCentro());
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
	public void verificaSeCadaCapituloEstaEstaExibindoOTituloDaMateria() {
		assertTrue(materia.exibiuUmAntiTituloParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloEstaEstaExibindoOSubtituloDaMateria() {
		assertTrue(materia.exibiuUmTituloParaCadaCapitulo());
	}
	
	@Test
	public void verificaSeCadaCapituloEstaEstaExibindoOAutorDaMateria() {
		assertTrue(materia.exibiuUmAutorParaCadaCapitulo());
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
	public void verificaSeAChamadaDaMateriaPrinciaplEstaExibindoBannerArroba() {
		assertTrue(materia.exibiuBannerArrobaParaAMateriaPrincipal());
	}
}