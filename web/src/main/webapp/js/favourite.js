$(function () {
    $('#addE').click(function (event) {
      var buttonId = $(event.target).attr('data-id');
      $.ajax({
        url: "/favourite-events",
        method: "POST",
        data: {id: buttonId},
        success: function () {
          location.reload();
        },
        error: function (error) {
          alert('Nie można dodać wydarzenia do ulubionych. Maksymalna liczba wydarzeń ulubionych wynosi 3');
        }
      });
    });
});

$(function () {
  $('#deleteE').click(function (event) {
    var buttonId = $(event.target).attr('data-id');
    $.ajax({
      url: "/favourite-events",
      method: "DELETE",
      data: {id: buttonId},
      success: function () {
        location.reload();
      }
    });
  });
});

$(function () {
  $('#close').click(function () {
    $.ajax({
      url: "/favourite-events",
      method: "PUT",
      success: function () {
        location.reload();
      }
    });
  });
});

$(function () {
  $('#deleteEvent').click(function (event) {
    var buttonId = $(event.target).attr('data-id');
    $.ajax({
      url: "/event-view",
      method: "DELETE",
      data: {id: buttonId},
      success: function () {
        location.replace("/upcoming-events?pageNo=1");
      }
    });
  });
});