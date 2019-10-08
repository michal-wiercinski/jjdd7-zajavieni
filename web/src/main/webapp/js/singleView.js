$(function () {

  $(document).ready(function () {

    $(".show-event").click(function () {

      $.ajax({
        url: '/api/event/' + $(this).attr(
            'data-id-event'),
        type: 'GET',
        success: function (data) {

          /*location.reload();*/
        },
        error: function (error) {
          location.reload();
        }
      }).done(function (data) {
        $('#name').val(data.name);
        $('#startDate').val(data.startDate);
        $('#endDate').val(data.startDate);
        $('#addressCity').val(data.addressCity);
        $('#addressName').val(data.addressName);
      });
    });
  });
});