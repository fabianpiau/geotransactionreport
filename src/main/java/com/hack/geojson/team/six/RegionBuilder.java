package com.hack.geojson.team.six;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;


public class RegionBuilder {

    static final String PATH_TO_COORDINATE_FILES = "C:\\Users\\Fabian\\workspace-hackathon\\geotransactionreport\\src\\main\\resources\\";

    String color = "green";
    String amount = "234.543";

    public String buildRegionGeoData(Set<RestData> restDataSet) throws IOException {
        AreaMap areaMap = new AreaMap();

        for (RestData restData : restDataSet) {

            Regions region = Regions.findByRegionName(restData.getRegion());

            if (region == null) {
                continue;
            }

            AreaItem areaItem = new AreaItem();
            areaItem.setColor(color);
            areaItem.setName(region.regionName);
            areaItem.setDescription("Amount: " + restData.getTotalAmount());

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
