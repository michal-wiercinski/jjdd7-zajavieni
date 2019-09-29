$(function () {

  $(document).ready(function () {

    $(".make-booking").click(function () {

      $.ajax({
        url: '/api/booking/make-booking/eventId/' + $(this).attr(
            'data-id-event')
            + '/userId/' + $(this).attr('data-id-user'),
        type: 'POST',
        success: function (result) {
          location.reload();
        },
        error: function (error) {
          alert('Przepraszamy, nie ma już biletów na to wydarzenie. :(');
          location.reload();
        }
      });
    });

  });
});

$(function(){
  $('[data-toggle="popover"]').popover()
});

$(function () {

  $(document).ready(function () {

    $(".cancel-booking").click(function () {

      $.ajax({
        url: '/api/booking/cancel-booking/eventId/' + $(this).attr(
            'data-id-event')
            + '/userId/' + $(this).attr('data-id-user'),
        type: 'DELETE',
        success: function (result) {
          location.reload();
        },
        error: function (error) {
          alert('Nie ma takiego już wydarzenia.');
          location.reload();
        }
      });
    });

  });
});