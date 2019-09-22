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