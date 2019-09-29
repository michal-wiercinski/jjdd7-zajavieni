google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

  $.getJSON('/api/statistics/events', function(dataset1) {

    var eventNamesAndQuantitiesArrayChart1 = [['Event name', 'Quantity',{role: 'style'}] ,];

    for (var i = 0; i < dataset1.length; i++) {
      var pairEventNameQuantity = dataset1[i];
      var eventNameAndQuantityArray = [pairEventNameQuantity.eventName,
        pairEventNameQuantity.quantity,
        'color: orange'];
      eventNamesAndQuantitiesArrayChart1.push(eventNameAndQuantityArray);
    }

    var dataChart1 = google.visualization.arrayToDataTable(
        eventNamesAndQuantitiesArrayChart1);

    var optionsChart1 = {
      title: 'Wydarzenia najczęściej odwiedzane',
      titleTextStyle: {
        color: 'blue',
        italic: true,
        fontSize: 25},
      hAxis: {
        title: 'Wydarzenia',
        textStyle : {
          fontSize: 12 // or the number you want
        },
        titleTextStyle: {
          color: 'red',
          fontSize: 20},
      },
      vAxis: {
        title: 'Liczba wyświetleń',
        textStyle : {
          fontSize: 15 // or the number you want
        },
        titleTextStyle: {
          color: 'red',
          fontSize: 20}
      },
      legend: {position: "none"},
    };

    var chart1 = new google.visualization.ColumnChart(
        document.getElementById('columnchart1'));
    chart1.draw(dataChart1, optionsChart1);
  });

  $.getJSON('/api/statistics/organizers', function(dataset2) {

    var organizerNamesAndQuantitiesArrayChart2 = [['Organizer name',
      'Quantity',{role: 'style'}],];

    for (var i = 0; i < dataset2.length; i++) {
      var pairOrganizerNameQuantity = dataset2[i];
      var organizerNameAndQuantityArray = [pairOrganizerNameQuantity.organizerName,
        pairOrganizerNameQuantity.quantity,
        'color: #DD4477'];
      organizerNamesAndQuantitiesArrayChart2.push(
          organizerNameAndQuantityArray);
    }

    var dataChart2 = google.visualization.arrayToDataTable(
        organizerNamesAndQuantitiesArrayChart2);

    var optionsChart2 = {
      title: 'TOP 10 organizatorów',
      titleTextStyle: {
        color: 'blue',
        italic: true,
        fontSize: 25
      },
      hAxis: {
        title: 'Organizatorzy',
        textStyle : {
          fontSize: 12 // or the number you want
        },
        titleTextStyle: {
          color: 'red',
          fontSize: 20},
      },
      vAxis: {
        title: 'Liczba wyświetleń',
        textStyle : {
          fontSize: 15 // or the number you want
        },
        titleTextStyle: {
          color: 'red',
          fontSize: 20}
      },
      legend: {position: "none"}
    };

    var chart2 = new google.visualization.ColumnChart(
        document.getElementById('columnchart2'));

    chart2.draw(dataChart2, optionsChart2);
  });


  $.getJSON('/api/statistics/favouriteEvents', function(dataset3) {

    var favouriteEventNamesAndQuantitiesArrayChart3 = [['Favourite event name',
      'Quantity',{role: 'style'}],];

    for (var i = 0; i < dataset3.length; i++) {
      var pairFavouriteEventNameQuantity = dataset3[i];
      var favouriteEventNamesAndQuantityArray = [pairFavouriteEventNameQuantity.favouriteEventName,
        pairFavouriteEventNameQuantity.quantity,
        'color: green'];
      favouriteEventNamesAndQuantitiesArrayChart3.push(
          favouriteEventNamesAndQuantityArray);
    }

    var dataChart3 = google.visualization.arrayToDataTable(
        favouriteEventNamesAndQuantitiesArrayChart3);

    var optionsChart3 = {
      title: 'Wydarzenia najczęściej dodawane do ulubionych',
      titleTextStyle: {
        color: 'blue',
        italic: true,
        fontSize: 25
      },
      hAxis: {
        title: 'Wydarzenia',
        textStyle : {
          fontSize: 12 // or the number you want
        },
        titleTextStyle: {
          color: 'red',
          fontSize: 20},
      },
      vAxis: {
        title: 'Liczba wyświetleń',
        textStyle : {
          fontSize: 15 // or the number you want
        },
        titleTextStyle: {
          color: 'red',
          fontSize: 20}
      },
      legend: {position: "none"}
    };

    var chart3 = new google.visualization.ColumnChart(
        document.getElementById('columnchart3'));

    chart3.draw(dataChart3, optionsChart3);
  });
}