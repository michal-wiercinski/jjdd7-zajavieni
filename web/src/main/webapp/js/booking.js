$(function () {

  $(document).ready(function () {

    $(".make-booking").click(function () {

      $.ajax({
        url: '/api/booking/make-booking/eventId/' + $(this).attr('data-id-event')
            + '/userId/' + $(this).attr('data-id-user'),
        type: 'POST',
        success: function (result) {
          alert("Zarezerwowałeś bilet na to wydarzenie.")
        },
        error: function (error) {
          alert('Przepraszamy, nie ma już biletów na to wydarzenie. :(');
        }
      });
    });

  });
});

$(function () {

  $(document).ready(function () {

    $(".cancel-booking").click(function () {

      $.ajax({
        url: '/api/booking/cancel-booking/eventId/' + $(this).attr('data-id-event')
            + '/userId/' + $(this).attr('data-id-user'),
        type: 'DELETE',
        success: function (result) {
          alert("Odwołałeś rezerwację.")
        },
        error: function (error) {
          alert('Nie ma takiego już wydarzenia.');
        }
      });
    });

  });
});