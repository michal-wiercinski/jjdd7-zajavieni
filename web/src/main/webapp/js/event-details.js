function fetchEventDetails(event, that) {
    event.preventDefault();
    $.ajax({
        url: '/api/v1.0/id/' + that.modal_event_id.value,
        type: 'GET',
        success: function (data) {
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#dupa").first().text(data.id);
        }
    });
    return false;
};