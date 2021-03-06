package testes.materia.capitulos;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.capitulo.MenuSuperiorElementosInline;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class MenuSuperiorComElementosInlineTest {
	
	private static MenuSuperiorElementosInline materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuSuperiorElementosInline(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*CONFIGURAÇÃO DA MATÉRIA*/
	/*Materia com 8 capitulos
	 * Layout Menu Superior *
	1º Capitulo - Fotos Inline nesta ordem: Foto Centro Grande, Esquerda Vertical, Esquerda Grande e Esquerda Pequena
	2º Capitulo - Box Veja Também
	3º Capitulo - Box Citação
	4º Capitulo - Box Twitter Embed
	5º Capitulo - Vídeos Inline nesta ordem: Globo.com, Youtube, Vimeo e Vevo
	6º Capítulo - Box de Música a esquerda (Layout aparecerá centralizado)
	7º Capítulo - Box de Música a centralizado
	8º Capítulo - Fotogaleria Inline
	9º Capítulo - Box de Lista de fatos inline*/
	
	/*Validação da materia principal*/
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandeDaMateriaPrincipalPossuiAFonteArial(){
		assertTrue(materia.exibiuAFonteArialParaALegendaDaFotoInlineCentroGrandeDaMateriaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandeDaMateriaPrincipalPossuiOTamanhoDe13px(){
		assertTrue(materia.exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrandeDaMateriaPrincipal());
	}
	
	/*Inicio da validação dos capitulos*/

	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeEstaSendoExibidoUmaListaDeMaterias() {
		materia.executarScroll(materia.posicoesDoMenuLateral().get(0).getLocation());
		assertTrue(materia.exibiuUmaListaDeMaterias());
	}

	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeOPrimeiroCapitulodaMateriaEstaExibindoUmaFotoCentroGrande() throws InterruptedException {
		materia.clicaNoCapituloDesejado(0);
		materia.esperaCarregar(4);
		assertTrue(materia.exibiuNoPrimeiroCapituloUmaFotoCentroGrande());
	}

	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandeDoPrimeiroCapituloPossuiAFonteArial(){
		assertTrue(materia.exibiuAFonteArialParaALegendaDaFotoInlineCentroGrandeDoPrimeiroCapitulo());
	}

	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandeDoPrimeiroCapituloPossuiOTamanhoDe13px(){
		assertTrue(materia.exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrandeDoPrimeiroCapitulo());
	}

	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeOPrimeiroCapitulodaMateriaEstaExibindoUmaFotoEsquerdaVertical() {
		assertTrue(materia.exibiuNoPrimeiroCapituloUmaFotoEsquerdaVertical());
	}

	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeOPrimeiroCapitulodaMateriaEstaExibindoUmaFotoEsquerdaGrande() {
		assertTrue(materia.exibiuNoPrimeiroCapituloUmaFotoEsquerdaGrande());
	}

	@OrdemExecucaoTeste(Ordem = 9)
	@Test
	public void verificaSeOPrimeiroCapitulodaMateriaEstaExibindoUmaFotoEsquerdaPequena() {
		assertTrue(materia.exibiuNoPrimeiroCapituloUmaFotoEsquerdaPequena());
	}

	@OrdemExecucaoTeste(Ordem = 10)
	@Test
	public void verificaSeOSegundoCapitulodaMateriaEstaExibindoOBoxDeConteudoRelacionado() throws InterruptedException {
		materia.clicaNoCapituloDesejado(1);
		materia.esperaCarregar(4);
		assertTrue(materia.exibiuNoSegundoCapituloUmBoxDeConteudoRelacionado());
	}

	@OrdemExecucaoTeste(Ordem = 11)
	@Test
	public void verificaSeOTerceiroCapitulodaMateriaEstaExibindoOBoxDeCitacao() throws InterruptedException {
		materia.clicaNoCapituloDesejado(2);
		materia.esperaCarregar(4);
		assertTrue(materia.exibiuNoTerceiroCapituloUmBoxDeCitacao());
	}

	@OrdemExecucaoTeste(Ordem = 12)
	@Test
	public void verificaSeOQuartoCapitulodaMateriaEstaExibindoUmTweeterEmbed() throws InterruptedException {
		materia.clicaNoCapituloDesejado(3);
		materia.esperaCarregar(4);
		assertTrue(materia.exibiuNoQuartoCapituloUmBoxDeTweeterEmbed());
	}

	@OrdemExecucaoTeste(Ordem = 13)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDaGloboCom() throws InterruptedException {
		materia.clicaNoCapituloDesejado(4);
		materia.esperaCarregar(4);
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDaGloboCom());
	}

	@OrdemExecucaoTeste(Ordem = 14)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoYoutube() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoYoutube());
	}

	@OrdemExecucaoTeste(Ordem = 15)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoVimeo() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoVimeo());
	}

	@OrdemExecucaoTeste(Ordem = 16)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoVevo() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoVevo());
	}

	@OrdemExecucaoTeste(Ordem = 17)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoLiveStream() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoLiveStream());
	}

	@OrdemExecucaoTeste(Ordem = 18)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoUsStream() throws InterruptedException {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoUsStream());
	}

	@OrdemExecucaoTeste(Ordem = 19)
	@Test
	public void verificaSeOSextoCapituloDaMateriaEstaExibindoOBoxDeMusicaVertical() throws InterruptedException {
		materia.clicaNoCapituloDesejado(5);
		materia.esperaCarregar(4);
		assertTrue(materia.exibiuNoSextoCapituloUmBoxDeMusicaVertical());
	}

	@OrdemExecucaoTeste(Ordem = 20)
	@Test
	public void verificaSeOSetimoCapituloDaMateriaEstaExibindoOBoxDeMusicaHorizontal() throws InterruptedException {
		materia.clicaNoCapituloDesejado(6);
		materia.esperaCarregar(4);
		assertTrue(materia.exibiuNoSetimoCapituloUmBoxDeMusicaHorizontal());
	}

	@OrdemExecucaoTeste(Ordem = 21)
	@Test
	public void verificaSeOOitavoCapituloDaMateriaEstaExibindoUmaFotogaleriaInline() throws InterruptedException {
		materia.clicaNoCapituloDesejado(7);
		materia.esperaCarregar(4);
		assertTrue(materia.exibiuNoOitavoCapituloUmaFotogaleriaInline());
	}
	
	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeOBoxDeListaDeFatosInlineEstaSendoExibido() throws InterruptedException{
		materia.clicaNoCapituloDesejado(8);
		materia.esperaCarregar(4);
		materia.executarScroll(materia.acessaBoxDeListaDeFatosInline().getLocation());
		assertTrue(materia.exibiuBoxDeListaDeFatosInline());
	}
	
	@OrdemExecucaoTeste(Ordem=21)
	@Test
	public void verificaSeOTituloDaListaDeFatosInlineEstaSendoExibido(){
		assertTrue(materia.exibiuTituloDaListaDeFatosInline());
	}
	
	@OrdemExecucaoTeste(Ordem=22)
	@Test
	public void verificaSeOTituloDaListaDeFatosInlineEstaSendoExibidoComOLayoutCorreto(){
		assertTrue(materia.exibiuLayoutCorretoParaOTituloDaListaDeFatosInline());
	}
	
	@OrdemExecucaoTeste(Ordem=23)
	@Test
	public void verificaSeAPagincaoDaListaDeFatosInlineEstaSendoExibido(){
		assertTrue(materia.exibiuPaginacaoDaListaDeFatosInline());
	}
	
	@OrdemExecucaoTeste(Ordem=24)
	@Test
	public void verificaSeNaPrimeiraFotoAPagincaoDaEsquerdaEstaDesabilitadaEADaDireitaEstaHabilitada(){
		assertTrue(materia.exibiuPaginacaoDoPrimeiroFatoDeFormaCorreta());
	}
	
	@OrdemExecucaoTeste(Ordem=25)
	@Test
	public void verificaSeAsImagensDaListaDeFatosEstaSendoExibidoCorretamente() throws InterruptedException{
		assertTrue(materia.exibiuCropWidthEHeightCorretosParaAsImagensDeCadaFatos());
	}
	
	@OrdemExecucaoTeste(Ordem=26)
	@Test
	public void verificaSeNaUltimaFotoAPagincaoDaEsquerdaEstaHabilitadaEADaDireitaEstaDesabilitada() throws InterruptedException{
		assertTrue(materia.exibiuPaginacaoDaUltimoFatoDeFormaCorreta());
	}
	
	@OrdemExecucaoTeste(Ordem=27)
	@Test
	public void verificaSeCadaFatoDaListaDeFatosEstaExibindoTituloDescricaoTotalDeFatosELegendaCorretamente() throws InterruptedException{
		assertTrue(materia.exibiuTituloDescricaoTotalDeFotosELegendaParaCadaFato());
	}
}