/**
 * Created by Sarah on 7/17/2015.
 */
(function(){
    function initialize() {
    var mapCanvas = document.getElementById('map-canvas');
    var myLatlng = new google.maps.LatLng(40.7577, -73.9857);
    var mapOptions = {
        zoom: 14,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var map = new google.maps.Map(mapCanvas, mapOptions);
    var marker = new google.maps.Marker({
        position: myLatlng,
        map: map,
        title: 'Meal Ticket!'
    });

// To add the marker to the map, call setMap();
    marker.setMap(map);
    google.maps.event.addListener(marker, 'click', function() {
        window.location.href = marker.url;
    });
}
google.maps.event.addDomListener(window, 'load', initialize);


function addReservationRow(){
    var table = document.getElementById("rsvnTable");
    var row = table.insertRow(-1);

    var cell1 = row.insertCell(0);
    cell1.innerHTML("");
    cell1.contenteditable="true";
    var cell2 = row.insertCell(1);
    cell2.innerHTML("");
    cell1.contenteditable="true";
    var cell3 = row.insertCell(2);
    cell3.innerHTML("");
    cell1.contenteditable="true";
    var cell4 = row.insertCell(3);
    cell4.innerHTML("");
    cell1.contenteditable="true";
    var cell5 = row.insertCell(4);
    cell5.innerHTML("");
    cell1.contenteditable="true";
    var cell6 = row.insertCell(5);
    cell6.innerHTML("");
    cell1.contenteditable="true";

    //buttons
    var cell7 = row.insertCell(6);
    var button1 = document.createElement(input);
    button1.type("button");
    button1.addClass("btn");
    button1.addClass("btn-default");
    button1.value ="Save";
    cell7.appendChild(button1);


    var button2 = document.createElement(input);
    button1.type("button");
    button1.addClass("btn");
    button1.addClass("btn-default");
    button1.value ="Cancel";
    cell7.appendChild(button21);

    var cell8 = row.insertCell(7);
    var button3 = document.createElement(input);
    button1.type("button");
    button1.addClass("btn");
    button1.addClass("btn-default");
    button1.value ="Send email";
    cell8.appendChild(button3);

    var cell9 = row.insertCell(8);
    var button4 = document.createElement(input);
    button1.type("button");
    button1.addClass("btn");
    button1.addClass("btn-default");
    button1.value ="Delete";
    cell7.appendChild(button4);



}
function delReservationRow(){
    var rowNum = this.parentNode.parentNode.rowIndex;
    alert(rowNum);
}
function retrieveRsvnDetails(){
    document.getElementById(confnum).setAttribute(display,"none");
    document.getElementById(rsvnupdate).setAttribute(display,"block");
}
})();