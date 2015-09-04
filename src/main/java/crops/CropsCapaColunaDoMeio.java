package crops;

public enum CropsCapaColunaDoMeio {
	
	boxEspecialChamadaPrincipal("/FT1086A/276/", "460", "276"),
	boxEspecialChamadaSecundaria("/FT1086A/84/", "140", "84"), 
	boxEspecialOpiniao("/FT460B/60/", "60", "60"),
	boxColunistas("/FT460B/100/", "100", "100"),
	boxVideos("/FT1086A/140", "234", "140"),
	boxCarrossel("/FT1086A/275/", "460", "275"),
	boxHumor("/FT460B/", "460", "460"),
	boxDuasColunasDuasManchetes("/FT1086A/180/", "300", "180"),
	boxDuasColunasUmaMancheteHorizontal("/FT1086A/180/", "300", "180"),
	boxDuasColunasUmaMancheteVertical("/FT460A/500/", "300", "500"),
	boxMancheteHorizontal("/FT1500A/200/", "460", "200");
	
private  final String cropProporcional;  
private  final String width;
private  final String height;

CropsCapaColunaDoMeio (String cropProporcional, String width, String height) {
    this.cropProporcional = cropProporcional;
    this.width = width;
    this.height = height;
}

public String cropProporcional() { return cropProporcional; }
public String getWidth() { return width; }
public String getHeight() { return height; }

}