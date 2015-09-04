package testes.materia.capitulos;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.capitulo.MenuLateralComElementosInline;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class MenuLateralComElementosInlineTest {
	
	private static MenuLateralComElementosInline materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuLateralComElementosInline(Navegador.CHROME);
		materia.esperaCarregar(5);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*CONFIGURAÇÃO DA MATÉRIA*/
	/*Materia com 8 capitulos
	 * Layout Menu Lateral *
	1º Capitulo - Fotos Inline nesta ordem: Foto Centro Grande, Esquerda Vertical, Esquerda Grande e Esquerda Pequena (Todas as fotos terão o mesmo tamanho)
	2º Capitulo - Box Veja Também
	3º Capitulo - Box Citação
	4º Capitulo - Box Twitter Embed
	5º Capitulo - Vídeos Inline nesta ordem: Globo.com, Youtube, Vimeo e Vevo
	6º Capítulo - Box de Música a esquerda
	7º Capítulo - Box de Música a centralizado
	8º Capítulo - Fotogaleria Inline
	9º Capítulo - Lista de Fatos Inline Com Foto*/ 
	
	/*Validação da materia principal*/
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandeDaMateriaPrincipalPossuiAFonteArial(){
		assertTrue(materia.exibiuAFonteArialParaALegendaDaFotoInlineCentroGrandeDaMateriaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandeDaMateriaPrincipalPossuiOTamanhoDe13px(){
		assertTrue(materia.exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrandeDaMateriaPrincipal());
	}
	
	/*Inicio da validação dos capitulos*/
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeEstaSendoExibidoUmaListaDeMaterias() throws InterruptedException {
		materia.executarScroll(materia.acessaMenuLateral().getLocation());
		materia.esperaCarregar(3);
		assertTrue(materia.exibiuUmaListaDeMaterias());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAsFotosDoPrimeiroCapitulodaMateriaPossuemOWidthDe700Px() {
		assertTrue(materia.exibiuWidthCorretoParaAsFotosDoPrimeiroCapitulo());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAsFotosDoPrimeiroCapitulodaMateriaPossuemOHeightDe420Px() {
		assertTrue(materia.exibiuHeightCorretoParaAsFotosDoPrimeiroCapitulo());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeALegendaDasFotosDoPrimeiroCapituloPossuiAFonteArial(){
		assertTrue(materia.exibiuAFonteArialParaALegendaDasFotosDoPrimeiroCapitulo());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeALegendaDasFotosDoPrimeiroCapituloPossuiOTamanhoDe13px(){
		assertTrue(materia.exibiuOTamanhoDe13pxParaALegendaDasFotosDoPrimeiroCapitulo());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeOSegundoCapitulodaMateriaEstaExibindoOBoxDeConteudoRelacionado() {
		assertTrue(materia.exibiuNoSegundoCapituloUmBoxDeConteudoRelacionado());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeOTerceiroCapitulodaMateriaEstaExibindoOBoxDeCitacao() {
		assertTrue(materia.exibiuNoTerceiroCapituloUmBoxDeCitacao());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeOQuartoCapitulodaMateriaEstaExibindoUmTweeterEmbed() {
		assertTrue(materia.exibiuNoQuartoCapituloUmBoxDeTweeterEmbed());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDaGloboCom() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDaGloboCom());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoYoutube() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoYoutube());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoVimeo() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoVimeo());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoVevo() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoVevo());
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoLiveStream() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoLiveStream());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeOQuintoCapituloDaMateriaEstaExibindoUmVideoDoUsStream() {
		assertTrue(materia.exibiuNoQuintoCapituloUmVideoDoUsStream());
	}
	
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void verificaSeOSextoCapituloDaMateriaEstaExibindoOBoxDeMusicaVertical() {
		assertTrue(materia.exibiuNoSextoCapituloUmBoxDeMusicaVertical());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeOSetimoCapituloDaMateriaEstaExibindoOBoxDeMusicaHorizontal() {
		assertTrue(materia.exibiuNoSetimoCapituloUmBoxDeMusicaHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=19)
	@Test
	public void verificaSeOOitavoCapituloDaMateriaEstaExibindoUmaFotogaleriaInline() {
		assertTrue(materia.exibiuNoOitavoCapituloUmaFotogaleriaInline());
	}
	
	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeOBoxDeListaDeFatosInlineEstaSendoExibido() throws InterruptedException{
		materia.clicaNoCapituloDesejado(8);
		materia.esperaCarregar(4);
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.acessaBoxDeListaDeFatosInline());
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