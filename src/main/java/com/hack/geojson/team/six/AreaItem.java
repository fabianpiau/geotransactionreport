package com.hack.geojson.team.six;


public class AreaItem {

    private String name;
    private String color;
    private String description;

    private Geometry geometry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }


    @Override
    public String toString() {
        return "{\n" +
                "            \"type\": \"Feature\",\n" +
                "            \"properties\": {\n" +
                "                \"fillColor\": \""+color+"\",\n" +
                "                \"name\": \""+name+"\",\n" +
                "                \"description\": \""+description+"\"\n" +
                "            },\n" +
                "            "+ geometry.toString()+"\n"+
                "        }";
    }
}
