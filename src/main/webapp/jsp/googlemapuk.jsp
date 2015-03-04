<!DOCTYPE html>
<html>
<head>
    <title>Data Layer: Simple</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/mapstyles.css">
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>


    <%
        String fromdate = request.getParameter("fromdate");
        String todate = request.getParameter("todate");
        if(fromdate == null || todate == null){

            out.print("<script src='../script'></script>");

        }else{

            out.print("<script src='../script?fromdate" + fromdate +"&todate="+todate+"'></script>");

        }
    %>

    <script>

        var map;
        var infowindow = new google.maps.InfoWindow();


        function initialize() {
            // Create a simple map.
            map = new google.maps.Map(document.getElementById('map-canvas'), {
                zoom: 6,
                center: {lat: 54.97139, lng: -2.742777}
            });

            google.maps.event.addListener(map, 'mouseovers', function () {
                infowindow.close();
            });

            map.data.addGeoJson(data);

            map.data.setStyle(function (feature) {
                var color = feature.getProperty('fillColor');
                return {
                    fillColor: color, strokeWeight: 0
                };
            });

            // Set event listener for each feature.
            map.data.addListener('mouseover', function (event) {
                infowindow.setContent(event.feature.getProperty('name') + "<br>" + event.feature.getProperty('description'));
                infowindow.setPosition(event.latLng);
                infowindow.setOptions({pixelOffset: new google.maps.Size(0, -34)});
                infowindow.open(map);
            });
        }

        google.maps.event.addDomListener(window, 'load', initialize);

    </script>
</head>
<body>

<div id="wrapper">
    <div class="left" id="data-container">
        <form action="googlemapuk.jsp" method="post">
            Enter a from date:
            <input type="date" value="2015-02-25" name="fromdate"><br>
            Enter a to date:
            <input type="date" value="2015-03-04" name="todate"><br>
            <button type="submit">Submit</button>
        </form>

        <br>
        Legend: <br>
        <textarea rows="1" cols="20" style="background:red">1-50 transactions</textarea><br>
        <textarea rows="1" cols="20" style="background:orange">50-150 transactions</textarea><br>
        <textarea rows="1" cols="20" style="background:yellow">150-450 transactions</textarea><br>
        <textarea rows="1" cols="20" style="background:blue">450-750 transactions</textarea><br>
        <textarea rows="1" cols="20" style="background:green">750-1000 transactions</textarea><br>
    </div>

    <!--here goes the map-->
    <div class="right" id="map-container">
        <div id="map-canvas"></div>
    </div>
</div>
</body>
</html>