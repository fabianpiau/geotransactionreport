package com.hack.geojson.team.six.servlet;

import com.hack.geojson.team.six.RegionBuilder;
import com.hack.geojson.team.six.RestData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;


public class ScriptServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        // hit the  to other pairs app
        // process the response



        // construct the script using region builder

        RegionBuilder regionBuilder = new RegionBuilder();
        regionBuilder.buildRegionGeoData(new HashSet<RestData>());


        String username = req.getParameter("username");
        if (username != null && username.length() > 0) {
            out.println("<h2>Hello, " + username + "!</h2>");
        }
    }
}
