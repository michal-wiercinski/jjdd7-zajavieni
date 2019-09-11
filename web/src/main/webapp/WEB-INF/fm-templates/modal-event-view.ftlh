<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
    Szczegóły wydarzenia
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">${event.name}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <img class="card-img-top" src=${(event.attachments.fileName)!0} alt="">
                <div class="card-body">
                    <h5 class="card-title">${event.startDate?date}</h5>
                    <p class="card-text">${(event.place.address.city)!"n/a"}</p>
                    <p>${(event.place.name)!"n/a"}</p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary mr-auto" data-dismiss="modal">Zamknij</button>
                <button type="button" class="btn btn-primary">Zarezerwuj bilet</button>
            </div>
        </div>
    </div>
</div>