$(function () {

  $(document).ready(function () {

    $(".make-booking").click(function () {

      $.ajax({
        url: '/api/booking/make-booking/eventId/' + $(this).attr('data-id-event')
            + '/userId/' + $(this).attr('data-id-user'),
        type: 'PATCH',
        success: function (result) {
          location.reload();
        }
      });
    });

  });
});