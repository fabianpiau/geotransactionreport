package com.hack.geojson.team.six;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by boyce on 03/03/2015.
 */
public class RegionBuilder {

    static final String PATH_TO_COORDINATE_FILES = "C:\\Users\\boyce\\IdeaProjects\\GoogleGeoJsonBuild\\src\\com\\hack\\geojson\\team\\six\\";

    String color = "green";
    String amount = "234.543";

    public String buildRegionGeoData() throws IOException {
        AreaMap areaMap = new AreaMap();

        for (Regions region : Regions.values()) {


            AreaItem areaItem = new AreaItem();
            areaItem.setColor(color);
            areaItem.setName(region.regionName);
            areaItem.setDescription("Amount: " + amount);

            Geometry geometry = new Geometry();
            geometry.setCoordinates(readFile(RegionBuilder.PATH_TO_COORDINATE_FILES + region + ".txt"));
            areaItem.setGeometry(geometry);

            areaMap.addAreaItem(areaItem);

        }
        return areaMap.toString();
    }


    String readFile(String path)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}
