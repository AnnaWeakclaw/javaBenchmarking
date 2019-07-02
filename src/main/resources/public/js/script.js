console.log("in js file");

// Our labels along the x-axis
var years = [1500,1600,1700,1750,1800,1850,1900,1950,1999,2050];
// For drawing the lines
var africa = [86,114,106,106,107,111,133,221,783,2478];

var ctx = document.getElementById("myChart");
console.log(ctx);


function loadJSON(callback) {
    var xobj = new XMLHttpRequest();
    xobj.overrideMimeType("application/json");
    xobj.open('GET', "js/mymap.json", true);
    xobj.onreadystatechange = function () {
        if (xobj.readyState == 4 && xobj.status == '200') {
            callback(xobj.responseText);
        }
    };
    xobj.send(null);
}

function init() {
    loadJSON(function (response) {
        var myData = JSON.parse(response);
        console.log(Object.keys(myData));
        console.log(Object.values(myData));
        console.log(myData);

        var sizes = Object.keys(myData);
        var times = Object.values(myData);

        var myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: sizes,
                datasets: [
                    {
                        data: times,
                        label: "Median times",
                        borderColor: "#3e95cd"
                    }
                ]
            }
        });
    })


}

init();

