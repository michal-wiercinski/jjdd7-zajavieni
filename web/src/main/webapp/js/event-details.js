function fetchEventDetails(event, that) {
    event.preventDefault();
    $.ajax({
        url: '/api/v1.0/id/' + that.modal_event_id.value,
        type: 'GET',
        success: function (data) {
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#dupa").first().text(data.id);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#name").first().text(data.name);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#addressName").first().text(data.addressName);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#addressCity").first().text(data.addressCity);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#addressStreet").first().text(data.addressStreet);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#addressZipCode").first().text(data.addressZipCode);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#descShort").first().text(data.descShort);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#descLong").first().text(data.descLong);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#wwwAddress").first().text(data.wwwAddress);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#fbSite").first().text(data.fbSite);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#websiteWithTickets").first().text(data.websiteWithTickets);
            $("#event_modal_" + that.modal_event_id.value + " .modal-body .card-text#organizerName").first().text(data.organizerName);
        }
    });
    return false;
};

