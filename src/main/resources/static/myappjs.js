$(document).ready(function() {

	// alert("page loading started...");
	$("#mychartId").click(function(){
		drawPieChart();	
	});

});

drawPieChart = function() {
	// Load google charts
	google.charts.load('current', {'packages' : [ 'corechart' ]});
	google.charts.setOnLoadCallback(draw);
}

function draw() {
	//calling ajax- and setting data to google pie chart.
	$.get("/test/chart/list", function(data, status) {
		var data = google.visualization.arrayToDataTable(data);
		// Optional; add a title and set the width and height of the chart
		var options = {
			'title' : 'My Average Day',
			'width' : 550,
			'height' : 500
		};
		// Display the chart inside the <div> element with id="piechart"
		var chart = new google.visualization.PieChart(document
				.getElementById('piechart'));
		chart.draw(data, options);
	});

	
}