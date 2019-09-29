google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
  // var dataset1 = [
  //   {"eventName": "Taniec", "quantity": 45},
  //   {"eventName": "Muzyka", "quantity": 24},
  //   {"eventName": "PeepShow", "quantity": 17},
  //   {"eventName": "Kabaret", "quantity": 5},
  //   {"eventName": "Kino", "quantity": 5}
  // ];

  $.getJSON('/api/statistics/events', function(dataset1) {

    var eventNamesAndQuantitiesArrayChart1 = [['Event name', 'Quantity',],];

    for (var i = 0; i < dataset1.length; i++) {
      var pairEventNameQuantity = dataset1[i];
      var eventNameAndQuantityArray = [pairEventNameQuantity.eventName,
        pairEventNameQuantity.quantity,
        'color: #' + Math.floor(Math.random() * 16777215).toString(16)];
      eventNamesAndQuantitiesArrayChart1.push(eventNameAndQuantityArray);
    }

    var dataChart1 = google.visualization.arrayToDataTable(
        eventNamesAndQuantitiesArrayChart1);

    var optionsChart1 = {
      title: 'Wydarzenia najczęściej odwiedzane',
      legend: {position: "none"}
    };

    var chart1 = new google.visualization.ColumnChart(
        document.getElementById('columnchart1'));

    chart1.draw(dataChart1, optionsChart1);
  });


  $.getJSON('/api/statistics/organizers', function(dataset2) {

    // var dataset2 = [
    //   {"organizerName": "Gdańsk", "quantity": 45},
    //   {"organizerName": "Gdynia", "quantity": 24},
    //   {"organizerName": "Sopot", "quantity": 17},
    //   {"organizerName": "Rumia", "quantity": 5},
    //   {"organizerName": "Tczew", "quantity": 5}
    // ];

    var organizerNamesAndQuantitiesArrayChart2 = [['Organizer name',
      'Quantity',],];

    for (var i = 0; i < dataset2.length; i++) {
      var pairOrganizerNameQuantity = dataset2[i];
      var organizerNameAndQuantityArray = [pairOrganizerNameQuantity.organizerName,
        pairOrganizerNameQuantity.quantity,
        'color: #' + Math.floor(Math.random() * 16777215).toString(16)];
      organizerNamesAndQuantitiesArrayChart2.push(
          organizerNameAndQuantityArray);
    }

    var dataChart2 = google.visualization.arrayToDataTable(
        organizerNamesAndQuantitiesArrayChart2);

    var optionsChart2 = {
      title: 'Popularność organizatorów',
      legend: {position: "none"}
    };

    var chart2 = new google.visualization.ColumnChart(
        document.getElementById('columnchart2'));

    chart2.draw(dataChart2, optionsChart2);
  });


  $.getJSON('/api/statistics/favouriteEvents', function(dataset3) {

    // var dataset3 = [
    //   {"favouriteEventName": "Taniec", "quantity": 45},
    //   {"favouriteEventName": "Muzyka", "quantity": 24},
    //   {"favouriteEventName": "PeepShow", "quantity": 17},
    //   {"favouriteEventName": "Kabaret", "quantity": 5},
    //   {"favouriteEventName": "Kino", "quantity": 5}
    // ];

    var favouriteEventNamesAndQuantitiesArrayChart3 = [['Favourite event name',
      'Quantity',],];

    for (var i = 0; i < dataset3.length; i++) {
      var pairFavouriteEventNameQuantity = dataset3[i];
      var favouriteEventNamesAndQuantityArray = [pairFavouriteEventNameQuantity.favouriteEventName,
        pairFavouriteEventNameQuantity.quantity,
        'color: #' + Math.floor(Math.random() * 16777215).toString(16)];
      favouriteEventNamesAndQuantitiesArrayChart3.push(
          favouriteEventNamesAndQuantityArray);
    }

    var dataChart3 = google.visualization.arrayToDataTable(
        favouriteEventNamesAndQuantitiesArrayChart3);

    var optionsChart3 = {
      title: 'Wydarzenia najczęściej dodawane do ulubionych',
      legend: {position: "none"}
    };

    var chart3 = new google.visualization.ColumnChart(
        document.getElementById('columnchart3'));

    chart3.draw(dataChart3, optionsChart3);
  });
}