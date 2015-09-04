package crops;

public enum CropsCapa {
	
	capaDaEsquerdaDestaque("/FT1500A/200/", "460", "200"),
	boxOpiniao("/FT460B/60/", "60", "60"),
	chamadaSecundaria("/FT1086A/84/", "140", "85"), //140x84
	
	boxPageNotFound("/FT1086A/84/", "140", "84"),
	boxFotogalerias("/FT1086A/565/", "940", "565"),
	boxSelecaoOGlobo("/FT1086A/143/", "193", "143"),
	
	boxDestaquesBlogsEla("FT1086A/180/", "307", "185"), //300x180
	
	ultimasNoticiasDestaquePrincipal("/FT1086A/421/", "704", "421"),
	ultimasNoticias("/FT1086A/140/", "234", "140");
	
private  final String cropProporcional;  
private  final String width;
private  final String height;

CropsCapa (String cropProporcional, String width, String height) {
    this.cropProporcional = cropProporcional;
    this.width = width;
    this.height = height;
}

public String getCropProporcional() { return cropProporcional; }
public String getWidth() { return width; }
public String getHeight() { return height; }

}