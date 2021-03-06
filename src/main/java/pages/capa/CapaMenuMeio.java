package pages.capa;
//package br.com.infoglobo.pages.capa;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import br.com.infoglobo.AceitacaoAbstractTest;
//
//public class CapaMenuMeio extends AceitacaoAbstractTest {
//	
//	public CapaMenuMeio() throws Exception {
//		super();
//	}
//	
//	public List<WebElement> listaDePrincipais(){
//		return getDriver().findElement(By.className("main-home")).findElements(By.className("lista-materias"));
//	}
//	
//	//Início Manchete Horizontal - Duas colunas e três destaques abaixo
//	public WebElement getBoxMancheteHorizontal(){
//		return listaDePrincipais().get(1);
//	}
//
//	public boolean getMancheteHorizontalEditoria() {
//		if(getBoxMancheteHorizontal().findElement(By.className("editoria")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//	
//	public WebElement getBoxMancheteHorizontalSuperior(){
//		return listaDePrincipais().get(1).findElement(By.className("superior"));
//	}
//	
//	public WebElement getBoxMancheteHorizontalInferior(){
//		return listaDePrincipais().get(1).findElement(By.className("inferior"));
//	}
//	
//	public boolean exibiuLinkNaImagemDaMancheteHorizontal() {
//		List<WebElement> exibiuFoto = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(exibiuFoto.size()>0){
//			if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("a")).isDisplayed()){
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public boolean exibiuLinkValidoNaImagemDaMancheteHorizontal() {
//		List<WebElement> exibiuFoto = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(exibiuFoto.size()>0){
//			if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean exibiuLinkAnimadoNaImagemDaMancheteHorizontal() {
//		List<WebElement> exibiuFoto = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(exibiuFoto.size()>0){
//			if(!getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("class").contains("animado-scale")){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean getMancheteHorizontalImagem() {
//		List<WebElement> exibiuFoto = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(exibiuFoto.size()>0){
//			if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed()){
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public boolean getMancheteHorizontalImagemWidth() {
//		List<WebElement> exibiuFoto = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(exibiuFoto.size()>0){
//			if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width").equals("460")){
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public boolean getMancheteHorizontalImagemHeight() {
//		List<WebElement> exibiuFoto = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(exibiuFoto.size()>0){
//			if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height").equals("200")){
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public boolean getMancheteHorizontalSubEditoria() {
//		List<WebElement> exibiuEditoria = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("h2"));
//		if(exibiuEditoria.size()>0){
//			if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h2")).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalTitulo() {
//		if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty()){
//			return false;
//		}
//		return true;
//	}
//	
//	public boolean exibiuTituloMancheteHorizontalComMaximoDeCaracteres() {
//		if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().length()>59){
//			return false;
//		}
//		return true;
//	}
//	
//
//	public boolean getMancheteHorizontalTituloLink() {
//		if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
//			return true;
//		}
//		return false;	
//	}
//
//	public boolean getMancheteHorizontalTituloLinkValido() {
//		if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
//			return false;
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalComentarios() {
//		List<WebElement> resultadoEsperado = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElements(By.className("comments"));
//		if(resultadoEsperado.size()>0){
//			if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.className("comments")).getText().isEmpty()){
//				return false;
//			}
//			return true;
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalComentariosLink() {
//		List<WebElement> resultadoEsperado = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a"));
//		if(resultadoEsperado.size()>0){
//			if(!resultadoEsperado.get(1).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalComentariosLinkValido() {
//		List<WebElement> resultadoEsperado = getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a"));
//		if(resultadoEsperado.size()>0){
//			if(resultadoEsperado.get(1).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public List<WebElement> getMancheteHorizontalBoxInferiorLista() {
//		return getBoxMancheteHorizontal().findElement(By.className("inferior")).findElements(By.className("materia"));
//	}
//
//	public boolean getMancheteHorizontalBoxInferiorTamanho() {
//		if(getMancheteHorizontalBoxInferiorLista().size() > 0){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteHorizontalBoxInferiorEditoria() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			if(getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalBoxInferiorTitulo() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			if(getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean exibiuTotalMaximoDeCaracteres() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			if(getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().length()>58){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean getMancheteHorizontalBoxInferiorTituloLink() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			if(!getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalBoxInferiorTituloLinkValido() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			if(getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalBoxInferiorComentario() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			List<WebElement> resultadoEsperado = getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
//			if(resultadoEsperado.size()>1){
//				if(resultadoEsperado.get(1).getText().isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalBoxInferiorComentarioLink() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			List<WebElement> resultadoEsperado = getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
//			if(resultadoEsperado.size()>1){
//				if(!resultadoEsperado.get(1).isDisplayed()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteHorizontalBoxInferiorComentarioLinkValido() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			List<WebElement> resultadoEsperado = getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
//			if(resultadoEsperado.size()>1){
//				if(resultadoEsperado.get(1).getAttribute("href").isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	//Fim Manchete Horizontal - Duas colunas e três destaques abaixo
//	
//	//Início Duas Colunas e uma Manchete - Uma coluna, com foto horizontal e quatro destaques
//	
//	public WebElement getBoxMancheteDuasColunasUmaManchete(){
//		return listaDePrincipais().get(2);
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteEditoria() {
//		if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("editoria")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//	
//	public WebElement getBoxMancheteDuasColunasUmaMancheteEsquerda(){
//		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("left"));
//	}
//	
//	public WebElement getBoxMancheteDuasColunasUmaMancheteDireita(){
//		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("right"));
//	}
//	
//	public boolean exibiuLinkNaImagemDaMancheteDuasColunasUmaManchete() {
//		List<WebElement> possuiFoto = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(possuiFoto.size()>0){
//			if(!getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("a")).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean exibiuLinkValidoNaImagemDaMancheteDuasColunasUmaManchete() {
//		List<WebElement> possuiFoto = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(possuiFoto.size()>0){
//			if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean exibiuLinkAnimadoNaImagemDaMancheteDuasColunasUmaManchete() {
//		List<WebElement> possuiFoto = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.tagName("img"));
//		if(possuiFoto.size()>0){
//			if(!getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("class").contains("animado-scale")){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean getMancheteDuasColunasUmaMancheteImagem() {
//		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed();
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteImagemWidth() {
//		if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width").equals("300")){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteImagemHeight() {
//		if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height").equals("180")){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteSubEditoria() {
//		if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h2")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteTitulo() {
//		if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//	
//	public boolean exibiuTituloDuasColunasUmaMancheteComMaximoDeCaracteres() {
//		if(getBoxMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().length()>59){
//			return false;
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteTituloLink() {
//		if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteTituloLinkValido() {
//		if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComentarios() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.className("comments"));
//		
//		if(resultadoEsperado.size()>0){
//			if(resultadoEsperado.get(0).getText().isEmpty()){
//				return false;
//			}else{
//				return true;
//			}
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComentariosLink() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.tagName("a"));
//		
//		if(resultadoEsperado.size()>1){
//			if(resultadoEsperado.get(1).isDisplayed()){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComentariosLinkValido() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.tagName("a"));
//		
//		if(resultadoEsperado.size()>1){
//			if(resultadoEsperado.get(1).getAttribute("href").contains("#comments")){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			return true;
//		}
//	}
//	
//
//	public List<WebElement> getMancheteDuasColunasUmaMancheteBoxDireitaLista() {
//		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("right")).findElements(By.className("materia"));
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaTamanho() {
//		if(getMancheteDuasColunasUmaMancheteBoxDireitaLista().size() > 0){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaEditoria() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaTitulo() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaTituloMaximoDeCaracteres() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().length()>59){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaTituloLink() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteBoxDireitaLista().size();i++){
//			if(!getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaTituloLinkValido() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaComentario() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			List<WebElement> possuiComentarioNaPosicao = getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
//			if(possuiComentarioNaPosicao.size()>0){
//				if(getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElement(By.className("comments")).getText().isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaComentarioLink() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			List<WebElement> possuiComentarioNaPosicao = getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
//			if(possuiComentarioNaPosicao.size()>0){
//				if(getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getText().isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaComentarioLinkValido() {
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			List<WebElement> possuiComentarioNaPosicao = getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
//			if(possuiComentarioNaPosicao.size()>0){
//				if(getMancheteDuasColunasUmaMancheteBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.className("a")).get(1).getAttribute("href").isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	
//	//Fim Duas Colunas e uma Manchete - Uma coluna, com foto (vertical ou horizontal) e até quatro destaques ao lado	
//	
//	//Início Duas Colunas e uma Manchete - Uma coluna com foto vertical e quatro destaques com foto
//	
//	public WebElement getBoxMancheteDuasColunasUmaMancheteComFoto(){
//		return listaDePrincipais().get(3);
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoEditoria() {
//		return !getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("editoria")).getText().isEmpty();
//	}
//					  	
//	public WebElement getBoxMancheteDuasColunasUmaMancheteComFotoEsquerda(){
//		return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("left"));
//	}
//	
//	public WebElement getBoxMancheteDuasColunasUmaMancheteComFotoDireita(){
//		return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("right"));
//	}
//	
//	public boolean getMancheteDuasColunasUmaMancheteComFotoImagem() {
//		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed()){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoImagemWidth() {
//		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width").equals("300")){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoImagemHeight() {
//		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height").equals("500")){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoSubEditoria() {
//		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("h2")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoTitulo() {
//		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoTituloLink() {
//		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoTituloLinkValido() {
//		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoComentarios() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.className("comments"));
//		
//		if(resultadoEsperado.size()>0){
//			if(resultadoEsperado.get(0).getText().isEmpty()){
//				return false;
//			}else{
//				return true;
//			}
//		}else{
//			return true;
//		}
////		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.className("comments")).getText().isEmpty()){
////			return false;
////		}else{
////			return true;
////		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoComentariosLink() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("a"));
//		
//		if(resultadoEsperado.size()>1){
//			if(resultadoEsperado.get(1).isDisplayed()){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			return true;
//		}
////		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("a")).get(1).isDisplayed()){
////			return true;
////		}else{
////			return false;
////		}
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoComentariosLinkValido() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("a"));
//		
//		if(resultadoEsperado.size()>1){
//			if(resultadoEsperado.get(1).getAttribute("href").contains("#comments")){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			return true;
//		}
////		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("a")).get(1).getAttribute("href").contains("#comments")){
////			return true;
////		}else{
////			return false;
////		}
//	}
//	
//
//	public List<WebElement> getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista() {
//		return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("right")).findElements(By.className("materia"));
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaTamanho() {
//		if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size() > 0){
//			return true;
//		}else{
//			return false;
//		}
//	}
//	
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaFoto() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
//			if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("img")).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaFotoWidth() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
//			if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("img")).getAttribute("width").equals("140")){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaFotoHeight() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
//			if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("img")).getAttribute("height").equals("84")){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaEditoria() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaTitulo() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaTituloLink() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
//			if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaTituloLinkValido() {
//		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaComentario() {
//		
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			
//			List<WebElement> resultadoEsperado = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
//			
//			if(resultadoEsperado.size()>1){
//				if(resultadoEsperado.get(1).getText().isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//		
//		
////		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
////			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getText().isEmpty()){
////				return false;
////			}
////		}
////		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaComentarioLink() {
//		
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			
//			List<WebElement> resultadoEsperado = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
//			
//			if(resultadoEsperado.size()>1){
//				if(!resultadoEsperado.get(1).isDisplayed()){
//					return false;
//				}
//			}
//		}
//		return true;
////		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
////			if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).isDisplayed()){
////				return false;
////			}
////		}
////		return true;
//	}
//
//	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaComentarioLinkValido() {
//		
//		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
//			
//			List<WebElement> resultadoEsperado = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
//			
//			if(resultadoEsperado.size()>1){
//				if(resultadoEsperado.get(1).getAttribute("href").isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
////		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
////			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
////				return false;
////			}
////		}
////		return true;
//	}
//	
//	//Fim Duas Colunas e uma Manchete - Uma coluna com foto vertical e quatro destaques com foto
//	
//	//Início Duas Colunas e duas Manchetes - Duas manchetes em uma coluna com quatro destaques
//	
//	public WebElement getBoxMancheteDuasColunasDuasManchetes(){
//		return listaDePrincipais().get(0);
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesEditoria() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("editoria")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//	
//	public WebElement getBoxMancheteDuasColunasDuasManchetesEsquerda(){
//		return getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("left"));
//	}
//	
//	public WebElement getBoxMancheteDuasColunasDuasManchetesDireita(){
//		return getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("right"));
//	}
//	
//	public boolean getMancheteDuasColunasDuasManchetesImagem() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed()){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesImagemWidth() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width").equals("300")){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesImagemHeight() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height").equals("180")){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesSubEditoria() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h2")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesTitulo() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesTituloLink() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesTituloLinkValido() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesComentarios() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.className("comments"));
//		
//		if(resultadoEsperado.size()>0){
//			if(resultadoEsperado.get(0).getText().isEmpty()){
//				return false;
//			}else{
//				return true;
//			}
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesComentariosLink() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.tagName("a"));
//		
//		if(resultadoEsperado.size()>1){
//			if(resultadoEsperado.get(1).isDisplayed()){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesComentariosLinkValido() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.tagName("a"));
//		
//		if(resultadoEsperado.size()>1){
//			if(resultadoEsperado.get(1).getAttribute("href").contains("#comments")){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			return true;
//		}
//	}
//	
//	public boolean getMancheteSubDestaqueDuasColunasDuasManchetesSubEditoria() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h2")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteSubDestaqueDuasColunasDuasManchetesTitulo() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteSubDestaqueDuasColunasDuasManchetesTituloLink() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteSubDestaqueDuasColunasDuasManchetesTituloLinkValido() {
//		if(getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
//			return false;
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteSubDestaqueDuasColunasDuasManchetesComentarios() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElements(By.className("comments"));
//		
//		if(resultadoEsperado.size()>0){
//			if(resultadoEsperado.get(0).getText().isEmpty()){
//				return false;
//			}else{
//				return true;
//			}
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteSubDestaqueDuasColunasDuasManchetesComentariosLink() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElements(By.tagName("a"));
//		
//		if(resultadoEsperado.size()>1){
//			if(resultadoEsperado.get(1).isDisplayed()){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			return true;
//		}
//	}
//
//	public boolean getMancheteSubDestaqueDuasColunasDuasManchetesComentariosLinkValido() {
//		
//		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElements(By.tagName("a"));
//		
//		if(resultadoEsperado.size()>1){
//			if(resultadoEsperado.get(1).getAttribute("href").contains("#comments")){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			return true;
//		}
//	}
//	
//	public List<WebElement> getMancheteDuasColunasDuasManchetesBoxDireitaLista() {
//		return getBoxMancheteDuasColunasDuasManchetes().findElement(By.className("right")).findElements(By.className("materia"));
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesBoxDireitaTamanho() {
//		if(getMancheteDuasColunasDuasManchetesBoxDireitaLista().size() > 0){
//			return true;
//		}else{
//			return false;
//		}
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesBoxDireitaEditoria() {
//		for(int i=0;i<getMancheteDuasColunasDuasManchetesBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasDuasManchetesBoxDireitaLista().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesBoxDireitaTitulo() {
//		for(int i=0;i<getMancheteDuasColunasDuasManchetesBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasDuasManchetesBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesBoxDireitaTituloLink() {
//		for(int i=0;i<getMancheteDuasColunasDuasManchetesBoxDireitaLista().size();i++){
//			if(!getMancheteDuasColunasDuasManchetesBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesBoxDireitaTituloLinkValido() {
//		for(int i=0;i<getMancheteDuasColunasDuasManchetesBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasDuasManchetesBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesBoxDireitaComentario() {
//		
//		
//		for(int i=0;i<getMancheteDuasColunasDuasManchetesBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasDuasManchetesBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getText().isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesBoxDireitaComentarioLink() {
//		for(int i=0;i<getMancheteDuasColunasDuasManchetesBoxDireitaLista().size();i++){
//			if(!getMancheteDuasColunasDuasManchetesBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean getMancheteDuasColunasDuasManchetesBoxDireitaComentarioLinkValido() {
//		for(int i=0;i<getMancheteDuasColunasDuasManchetesBoxDireitaLista().size();i++){
//			if(getMancheteDuasColunasDuasManchetesBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	//Fim Duas Colunas e duas Manchetes - Duas manchetes em uma coluna com até quatro destaques ao lado.
//
//	public WebElement getBoxDeVideosDaCapa() {
//		return getDriver().findElement(By.className("galeria-videos"));
//	}
//	
//	public List<WebElement> getListaVideosSecundariosDoBoxDeVideosDaCapa() {
//		WebElement galeriaVideos = getBoxDeVideosDaCapa();
//		if (galeriaVideos != null) {
//			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.className("outros-videos")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
//		} else {
//			return new ArrayList<WebElement>();
//		}
//	}
//	
//	public boolean getBoxDeVideosEstaSendoExibido() {
//		return getBoxDeVideosDaCapa() != null;
//	}
//
//	public boolean getTituloDoBoxDeVideos() {
//		WebElement galeriaVideos = getBoxDeVideosDaCapa();
//		if(galeriaVideos != null) {
//			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.className("title")) != null;
//		}
//		
//		return false;
//	}
//
//	public boolean getLinkParaTodosOsVideosDoBoxDeVideosEstaSendoExibido() {
//		WebElement galeriaVideos = getBoxDeVideosDaCapa();
//		if(galeriaVideos != null) {
//			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.className("mais-videos")) != null;
//		}
//		
//		return false;
//	}
//
//	public boolean getVideoEmDestaqueDoBoxDeVideosEstaSendoExibido() {
//		WebElement galeriaVideos = getBoxDeVideosDaCapa();
//		if(galeriaVideos != null) {
//			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.tagName("div")).findElement(By.id("play")) != null;
//		}
//		
//		return false;
//	}
//
//	public boolean getAntitituloDoVideoEmDestaqueDoBoxDeVideosEstaSendoExibido() {
//		WebElement galeriaVideos = getBoxDeVideosDaCapa();
//		if(galeriaVideos != null) {
//			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.tagName("div")).findElement(By.className("editoria")) != null;
//		}
//		
//		return false;
//	}
//
//	public boolean getTituloDoVideoEmDestaqueDoBoxDeVideosEstaSendoExibido() {
//		WebElement galeriaVideos = getBoxDeVideosDaCapa();
//		if(galeriaVideos != null) {
//			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.tagName("div")).findElement(By.className("titulo")) != null;
//		}
//		
//		return false;
//	}
//
//	public boolean getAreaDeOutrosVideosDoBoxDeVideosEstaSendoExibida() {
//		WebElement galeriaVideos = getBoxDeVideosDaCapa();
//		if(galeriaVideos != null) {
//			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.className("outros-videos")) != null;
//		}
//		
//		return false;
//	}
//
//	public boolean getAreaDeOutrosVideosDoBoxDeVideosEstaExibindoQuatroVideos() {
//		WebElement galeriaVideos = getBoxDeVideosDaCapa();
//		if(galeriaVideos != null) {
//			return getListaVideosSecundariosDoBoxDeVideosDaCapa().size() == 4;
//		}
//		return false;
//	}
//
//	public boolean getVideoQueEstaEmDestaqueEstaCobertoPeloQuadroAssistindoNoBoxDeVideos() {
//		return false;
//	}
//
//	public boolean getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(0).findElement(By.tagName("a")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(0).findElement(By.tagName("a")).findElement(By.tagName("img")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(0).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("editoria")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(0).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("titulo")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(1).findElement(By.tagName("a")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(1).findElement(By.tagName("a")).findElement(By.tagName("img")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(1).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("editoria")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(1).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("titulo")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//	
//	public boolean getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(2).findElement(By.tagName("a")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(2).findElement(By.tagName("a")).findElement(By.tagName("img")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(2).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("editoria")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(2).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("titulo")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//	
//	public boolean getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(3).findElement(By.tagName("a")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(3).findElement(By.tagName("a")).findElement(By.tagName("img")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(3).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("editoria")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public boolean getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo() {
//		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
//		try {
//			return (listaVideosSecundarios.get(3).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("titulo")) != null);
//		} catch (IndexOutOfBoundsException e) {
//			return false;
//		}
//	}
//
//	public List<WebElement> getDivColunaMeio() {
//		return getDriver().findElement(By.className("main-home")).findElements(By.className("publicidade"));
//	}
//	
//	public boolean oBoxDePublicidadeEstaSendoExibido() {
//		for(int i=0;i<getDivColunaMeio().size();i++){
//			if(!getDivColunaMeio().get(i).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean oBoxDePublicidadeEstaExibidoUmaPublicidade() {
//		for(int i=0;i<getDivColunaMeio().size();i++){
//			if(!getDivColunaMeio().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("script")).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean oTituloPublicidadeEstaSendoExibido() {
//		for(int i=0;i<getDivColunaMeio().size();i++){
//			if(!getDivColunaMeio().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).getText().contains("Publicidade")){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public WebElement exibiuOBoxDeOpiniaoDoGlobo() {
//		return getDriver().findElement(By.className("main-home")).findElement(By.className("opiniao"));
//	}
//
//	public String exibiuOTituloOpiniaoDoGlobo() {
//		return exibiuOBoxDeOpiniaoDoGlobo().findElement(By.tagName("p")).getText();
//	}
//
//	public boolean exibiuUmLinkParaOTituloDeOpinioes() {
//		return exibiuOBoxDeOpiniaoDoGlobo().findElement(By.tagName("a")).isDisplayed();
//	}
//
//	public boolean oLinkNoTituloDeOpinioesEstaCorreto() {
//		return !exibiuOBoxDeOpiniaoDoGlobo().findElement(By.tagName("a")).getAttribute("href").isEmpty();
//	}
//	
//	public List<WebElement> listaDeOpinioes() {
//		return exibiuOBoxDeOpiniaoDoGlobo().findElements(By.tagName("li"));
//	}
//	
//	public boolean exibiuAsOpinioes() {
//		if(listaDeOpinioes().size() == 3){
//			return true;
//		}
//		return false;
//	}
//
//	public boolean exibiuOLinkNasOpinioes() {
//		for(int i=0;i<listaDeOpinioes().size();i++){
//			if(!listaDeOpinioes().get(i).findElement(By.className("texto")).findElement(By.tagName("a")).isDisplayed()){
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean oLinkDaOpiniaoEhValido() {
//		for(int i=0;i<listaDeOpinioes().size();i++){
//			if(listaDeOpinioes().get(i).findElement(By.className("texto")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean exibiuOsAntititulosDasOpinioes() {
//		for(int i=0;i<listaDeOpinioes().size();i++){
//			List<WebElement> possuiAutorNaPosicaoDesejada = listaDeOpinioes().get(i).findElements(By.className("titulo"));
//			if(possuiAutorNaPosicaoDesejada.size()>0){
//				if(listaDeOpinioes().get(i).findElement(By.className("titulo")).getText().isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	public boolean exibiuOsTextoDasOpinioes() {
//		for(int i=0;i<listaDeOpinioes().size();i++){
//			List<WebElement> possuiAutorNaPosicaoDesejada = listaDeOpinioes().get(i).findElements(By.className("texto"));
//			if(possuiAutorNaPosicaoDesejada.size()>0){
//				if(listaDeOpinioes().get(i).findElement(By.className("texto")).getText().isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	public boolean exibiuOsAutoresDasOpinioes() {
//		for(int i=0;i<listaDeOpinioes().size();i++){
//			List<WebElement> possuiAutorNaPosicaoDesejada = listaDeOpinioes().get(i).findElements(By.className("autor"));
//			if(possuiAutorNaPosicaoDesejada.size()>0){
//				if(listaDeOpinioes().get(i).findElement(By.className("autor")).getText().isEmpty()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	public boolean exibiuLinkParaOsAntititulos() {
//		List<WebElement> resultadoEsperado = exibiuOBoxDeOpiniaoDoGlobo().findElement(By.className("titulo")).findElements(By.tagName("a"));
//		if(resultadoEsperado.size()>0){
//			return false;
//		}
//		return true;
//	}
//	
//	
////Início do Box de Humor
//	
//	public WebElement exibiuBoxDeHumor() {
//		return getDriver().findElement(By.className("humor"));
//	}
//
//	public String exibiuOTituloHumor() {
//		return exibiuBoxDeHumor().findElement(By.className("editoria")).getText();
//	}
//
//	public boolean exibiuFoto() {
//		return exibiuBoxDeHumor().findElement(By.tagName("img")).isDisplayed();
//	}
//
//	public String getWidthDaFoto() {
//		return exibiuBoxDeHumor().findElement(By.tagName("img")).getAttribute("width");
//	}
//
//	public String getHeightDaFoto() {
//		return exibiuBoxDeHumor().findElement(By.tagName("img")).getAttribute("height");
//	}
//
//	public boolean exibiuLinkNaFoto() {
//		return exibiuBoxDeHumor().findElement(By.tagName("a")).isDisplayed();
//	}
//
//	public boolean exibiuLinkvalidoNaFoto() {
//		return !exibiuBoxDeHumor().findElement(By.tagName("a")).getAttribute("href").isEmpty();
//	}
//
////Fim do Box de Humor
//	
//	
//	
//	
//	
//	
//	
//}
