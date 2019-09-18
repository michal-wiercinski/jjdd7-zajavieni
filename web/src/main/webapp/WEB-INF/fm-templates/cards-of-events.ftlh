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
                    <!--<a href="/event-view?id=${event.id?c}"
                       class="btn btn-primary show-event" <#--data-id="${event.id}"-->>Szczegóły</a>-->
                    <a<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button></a>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Modal Header</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>Some text in the modal.</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
</div>