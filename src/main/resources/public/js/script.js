console.log("in js file");

var ctx = document.getElementById("myChart");
console.log(ctx);

// The loading of a .json file from harddisk is an asynchronous operation and thus it needs to specify
// a callback function to execute after the file is loaded.
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
                        label: "My tested function",
                        borderColor: "#3e95cd"
                    }
                ]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        },
                        scaleLabel: {
                            display: true,
                            labelString: 'Median times'
                        }
                    }],
                    xAxes: [{
                        ticks: {
                            beginAtZero: false
                        },
                        scaleLabel: {
                            display: true,
                            labelString: 'Tested array size'
                        }
                    }]
                }
            }
        });
    })


}

init();

