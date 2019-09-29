$(function () {

  $(document).ready(function () {

    $(".make-booking").click(function () {

      $.ajax({
        url: '/api/booking/make-booking/eventId/' + $(this).attr('data-id-event')
            + '/userId/' + $(this).attr('data-id-user'),
        type: 'POST',
        success: function (result) {
          alert("Zarezerwowałeś bilet na to wydarzenie.")
          location.reload();
          document.getElementsByClassName("make-booking").style.visibility = 'hidden';
          document.getElementsByClassName("cancel-booking").style.visibility = 'visible';
        },
        error: function (error) {
          alert('Przepraszamy, nie ma już biletów na to wydarzenie. :(');
          location.reload();
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
          location.reload();
          document.getElementsByClassName("make-booking").style.visibility = 'visible';
          document.getElementsByClassName("cancel-booking").style.visibility = 'hidden';

        },
        error: function (error) {
          alert('Nie ma takiego już wydarzenia.');
          location.reload();
        }
      });
    });

  });
});