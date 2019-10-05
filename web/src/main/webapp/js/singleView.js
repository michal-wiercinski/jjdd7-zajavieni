$(function () {

  $(document).ready(function () {

    $(".show-event").click(function () {

      $.ajax({
        url: '/api/event/' + $(this).attr(
            'data-id-event'),
        type: 'GET',
        success: function (result) {
          /*location.reload();*/
        },
        error: function (error) {
          location.reload();
        }
      });
    });

  });
});