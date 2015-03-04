<!DOCTYPE html>
<html>
<head>
    <title>Data Layer: Simple</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/mapstyles.css">
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
    <script src="../script"></script>

    <script>

            var map;
            var infowindow = new google.maps.InfoWindow();



            function initialize() {
              // Create a simple map.
              map = new google.maps.Map(document.getElementById('map-canvas'), {
                zoom: 6,
                center: {lat: 54.97139, lng: -2.742777}
              });

             google.maps.event.addListener(map, 'mouseovers', function() {
                  infowindow.close();
                });

              map.data.addGeoJson(data);

              map.data.setStyle(function(feature) {
                var color = feature.getProperty('fillColor');
                return {
                  fillColor: color, strokeWeight: 0
                };
            });

                  // Set event listener for each feature.
                 map.data.addListener('mouseover', function(event) {
                 infowindow.setContent(event.feature.getProperty('name')+"<br>"+event.feature.getProperty('description'));
                 infowindow.setPosition(event.latLng);
                 infowindow.setOptions({pixelOffset: new google.maps.Size(0,-34)});
                 infowindow.open(map);
              });
            }

            google.maps.event.addDomListener(window, 'load', initialize);

    </script>
</head>
<body>

<div id="wrapper">
    <div class="left" id="data-container">
        <form action="googlemapuk.jsp" method="get">
            Enter a from date:
            <input type="date" value="2015-02-25" name="from_date"><br>
            Enter a to date:
            <input type="date" value="2015-03-04" name="to_date"><br>
            <button type="submit">Submit</button>
        </form>
    </div>

    <!--here goes the map-->
    <div class="right" id="map-container">
       <div id="map-canvas"></div>
    </div>
</div>
</body>
</html>