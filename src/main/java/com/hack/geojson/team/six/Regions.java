package com.hack.geojson.team.six;


public enum Regions {
    NORTH_WEST("North West"),
    NORTH_EAST("North East"),
    EAST_MIDLANDS("East Midlands"),
    EASTERN("Eastern"),
    LONDON("London"),
    WEST_MIDLANDS("West Midlands"),
    SCOTLAND("Scotland"),
    SOUTH_EAST("South East"),
    SOUTH_WEST("South West"),
    WALES("Wales"),
    YORKSHIRE_AND_THE_HUMBER("Yorkshire And The Hamber");

    String regionName;

    Regions(String regionName) {
        this.regionName = regionName;
    }

    public static Regions findByRegionName(String regionName){
        for(Regions r : values()){
            if( r.regionName.equals(regionName)){
                return r;
            }
        }
        return null;
    }


}
