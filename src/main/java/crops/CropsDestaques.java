package crops;

public enum CropsDestaques {
	
	tresColunasUmaFoto("/FT1500A/400/", "920", "400"),
	tresColunasDuasFotos("/FT1086A/400/", "667", "400"),
	tresColunasFotoDestaqueSecundario("/FT1086A/84/", "140", "84"),
	
	duasColunasFotoDestaquePrincial("/FT1500A/410/", "903", "410"),
	duasColunasChamadaComFotoGrande("/FT1500A/190/", "440", "190"),
	duasColunasChamadaComFotoPequena("/FT1086A/84/", "140", "84"),
	duasColunasFotoDestaqueSecundario("/FT1086A/84/", "140", "84"),
	duasColunasFotoBoxDeOpiniao("/FT460B/60/", "60", "60"),
	
	especialFotoPrincial("/FT1500A/550/", "1260", "550"),
	especialFotoChamadaSecundaria("/FT1086A/140/", "234", "140"),
	especialFotoBoxDeOpiniao("/FT460B/60/", "60", "60"),
	
	semiAutomaticoQuatroDestaquesAoLado("/FT1086A/281/", "470", "281"),
	semiAutomaticoQuatroDestaquesAbaixo("/FT1086A/400/", "960", "560"),//900x400
	semiAutomaticoSeisDestaques("/FT1086A/420/", "700", "420"),
	semiAutomaticoBoxDeBlogs("/FT460B/60/", "60", "60"),
	semiAutomaticoMateria("/FT1086A/140/", "234", "140"),
	
	boxDeCriticas("/FT1086A/140/", "234", "140"),
	
	boxDestaqueCapaElaPequeno("/FT460B/", "308", "308"), //460x460
	boxDestaqueCapaElaGrande("/FT460A/500/", "360", "604"),//298x500
	
	newsletterDestaquePrincipal("/FT1500A/400/", "570", "248"),
	newsletterDestaqueSecundario("/FT1086A/84/", "148", "89");
	
private  final String cropProporcional;  
private  final String width;
private  final String height;

CropsDestaques (String cropProporcional, String width, String height) {
    this.cropProporcional = cropProporcional;
    this.width = width;
    this.height = height;
}

public String cropProporcional() { return cropProporcional; }
public String getWidth() { return width; }
public String getHeight() { return height; }

}