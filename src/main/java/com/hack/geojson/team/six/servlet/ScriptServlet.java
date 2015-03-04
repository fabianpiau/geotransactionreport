package com.hack.geojson.team.six.servlet;

import com.google.gson.Gson;
import com.hack.geojson.team.six.RegionBuilder;
import com.hack.geojson.team.six.RestData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;


public class ScriptServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        RestData[] externalData = getExternalData(req, out);

        RegionBuilder regionBuilder = new RegionBuilder();
        String scriptData = regionBuilder.buildRegionGeoData(new HashSet<RestData>(Arrays.asList(externalData)));

        out.write(scriptData);
    }

    private RestData[] getExternalData(HttpServletRequest req, PrintWriter out) throws IOException {
        Gson gson = new Gson();

        String fromDate = req.getParameter("from_date");
        String toDate = req.getParameter("to_date");

        if (fromDate == null) {
            fromDate = "2014-02-01";
        }
        if (toDate == null) {
            toDate = "2015-03-04";
        }
        String jsonResponse;
        jsonResponse = NetClientGet.getJsonResponse("http://localhost:8090/api/aggregate?from=" + fromDate + "&to=" + toDate);
//            jsonResponse = "[{\"region\":\"Wales\",\"totalAmount\":420530.28,\"nbTransactions\":138},{\"region\":\"London\",\"totalAmount\":4170204.40,\"nbTransactions\":417},{\"region\":\"North West\",\"totalAmount\":3345868.44,\"nbTransactions\":365},{\"region\":\"Scotland\",\"totalAmount\":2417655.68,\"nbTransactions\":960},{\"region\":\"South West\",\"totalAmount\":1478510.16,\"nbTransactions\":253},{\"region\":\"South East\",\"totalAmount\":573851.36,\"nbTransactions\":141},{\"region\":\"Yorkshire And The Hamber\",\"totalAmount\":490358.89,\"nbTransactions\":134},{\"region\":\"North East\",\"totalAmount\":206924.45,\"nbTransactions\":81},{\"region\":\"West Midlands\",\"totalAmount\":879381.18,\"nbTransactions\":186},{\"region\":\"Northern Ireland\",\"totalAmount\":14403.72,\"nbTransactions\":25},{\"region\":\"East Midlands\",\"totalAmount\":134498.12,\"nbTransactions\":80}]";

        BufferedReader br = new BufferedReader(new StringReader(jsonResponse));

        //convert the json string back to object
        RestData[] restData = gson.fromJson(br, RestData[].class);
        RegionBuilder regionBuilder = new RegionBuilder();
        regionBuilder.buildRegionGeoData(new HashSet<RestData>());

        return restData;
    }
}
