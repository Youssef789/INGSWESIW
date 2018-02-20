<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">

<style type="text/css">

html,body,#map{
height: 100%;
width:100%;
margin: 0px;
padding: 0px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="map">
</div>
 <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 39.3047949, lng:16.2172892},
          zoom: 15
        });
        var request={
        		location:center,
        		radius: 500,
                type: ['food'],
        };
        var service = new google.maps.places.PlacesService(map);
        service.nearbySearch(request,callback);
      }
      function callback(results, status) {
          if (status === google.maps.places.PlacesServiceStatus.OK) {
            for (var i = 0; i < results.length; i++) {
              createMarker(results[i]);
            }
          }
      }
      
      function createMarker(place){
    	  var placeloc = place.geometry.location;
    	  var marker = new google.maps.Marker({
    		 map:map,
    		 position: place.geometry.location
    	  });
      }
    </script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyBECPJx_2oKER3IIid9ThmZThmhHMM9-lg&callback=initMap"></script>
    
</body>
</html>