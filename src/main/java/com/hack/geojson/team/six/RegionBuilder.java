package com.hack.geojson.team.six;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;


public class RegionBuilder {

    static final String PATH_TO_COORDINATE_FILES = "C:\\Users\\Fabian\\workspace-hackathon\\geotransactionreport\\src\\main\\resources\\";

    public String buildRegionGeoData(Set<RestData> restDataSet) throws IOException {
        AreaMap areaMap = new AreaMap();

        for (RestData restData : restDataSet) {

            Regions region = Regions.findByRegionName(restData.getRegion());

            if (region == null) {
                continue;
            }

            AreaItem areaItem = new AreaItem();
            areaItem.setColor(defineColor(restData.getNbTransactions()));
            areaItem.setName(region.regionName);
            areaItem.setDescription("Amount: " + restData.getTotalAmount());

            Geometry geometry = new Geometry();
            geometry.setCoordinates(readFile(RegionBuilder.PATH_TO_COORDINATE_FILES + region + ".txt"));
            areaItem.setGeometry(geometry);

            areaMap.addAreaItem(areaItem);

        }
        return areaMap.toString();
    }

    private String defineColor(String nbTransactions) {
        Integer nbTrs = Integer.parseInt(nbTransactions);
        if (nbTrs < 300) {
            return "red";
        }
        if (nbTrs >= 300 && nbTrs < 500 ) {
            return "orange";
        }
        if (nbTrs >= 500 && nbTrs < 700 ) {
            return "yellow";
        }
        if (nbTrs >= 700 && nbTrs < 950 ) {
            return "blue";
        }
        if (nbTrs >= 950 ) {
            return "green";
        }
        return "white";
    }


    String readFile(String path)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}
