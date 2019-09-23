$(".fa-google").autocomplete({
  source: function (request, response) {
    $.ajax({
      url: '/user',
      type: 'GET',
      success: function (data) {

        }
      }
    });
  },
  minLength: 3,
  select: function (event, ui) {
    if (ui.item.id === undefined) {
      return;
    } else {
      window.location.href = "/event-view?id=" + ui.item.id;
    }
  }
});