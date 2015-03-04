package com.hack.geojson.team.six;


import java.util.HashSet;
import java.util.Set;

public class AreaMap {

    private Set<AreaItem> mapItemsSet = new HashSet<AreaItem>();

    public void addAreaItem(AreaItem areaItem){
        mapItemsSet.add(areaItem);

    }

    @Override
    public String toString() {
        return "var data = {\n" +
                "    \"type\": \"FeatureCollection\",\n" +
                "    \"crs\": {\n" +
                "        \"type\": \"name\",\n" +
                "        \"properties\": {\n" +
                "            \"name\": \"urn:ogc:def:crs:OGC:1.3:CRS84\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"features\": "+mapItemsSet+
                "};";
    }
}
