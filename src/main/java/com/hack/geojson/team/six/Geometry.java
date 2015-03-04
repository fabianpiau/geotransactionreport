package com.hack.geojson.team.six;

public class Geometry {

    private String coordinates;

    static final String MULTI_POLIGON = "MultiPolygon";



    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "\"geometry\": {\n" +
                "                \"type\": \""+MULTI_POLIGON+"\",\n" +
                "                \"coordinates\": \n" +coordinates+"\n" +
                "            }";
    }
}
