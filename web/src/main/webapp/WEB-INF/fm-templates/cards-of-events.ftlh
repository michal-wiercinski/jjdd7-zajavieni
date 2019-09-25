<div class="container-fluid row">
    <#list events as event>
    <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
            <img class="card-img-top " style="max-height: 250px"
                 src="${(event.attachments[0].fileName)!"/img/plug.jpg"}" alt="">
            <div class="card-body d-flex flex-column">
                <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
                    ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
                <p class="card-text">${event.name}</p>
                <p class="card-text">${(event.addressCity)!"n/a"}</p>
                <p>${(event.addressName)!"n/a"}</p>
            </div>
            <div class="card-footer">
                <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
                <a href="/event-view?id=${event.id?c}"
                   class="btn btn-primary show-event" <#--data-id="${event.id}"-->>Szczegóły</a>

                <form class="modal_event_details_form" onsubmit="fetchEventDetails(event, this)">
                    <input type="hidden" id="modal_event_id" name="event_id" value="${event.id?c}">
                    <!-- Button trigger modal -->
                    <button type="submit" class="btn btn-primary" data-toggle="modal"
                            data-target="#event_modal_${event.id?c}">
                        Szczegółyv2
                    </button>
                </form>

                <!-- Modal -->
                <#--<div class="modal fade" id="event_modal_${event.id?c}" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLongTitle" aria-hidden="true">-->
                <#--<div class="modal-dialog" role="document">-->
                    <div class="modal fade bd-example-modal-lg" id="event_modal_${event.id?c}" tabindex="-1"
                         role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <#--<div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">
                                        <p id="name" class="card-text"></p>
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>-->
                                <div class="modal-body">
                                    <#include "event-details-modal.ftlh">
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </#list>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="/js/event-details.js"></script>
    </div>