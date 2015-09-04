package crops;

public enum CropsCapaColunaDaDireita {
	
	boxRio2016("/FT460B/300/", "300", "300");
	
private  final String cropProporcional;  
private  final String width;
private  final String height;

CropsCapaColunaDaDireita (String cropProporcional, String width, String height) {
    this.cropProporcional = cropProporcional;
    this.width = width;
    this.height = height;
}

public String getCropProporcional() { return cropProporcional; }
public String getWidth() { return width; }
public String getHeight() { return height; }

}