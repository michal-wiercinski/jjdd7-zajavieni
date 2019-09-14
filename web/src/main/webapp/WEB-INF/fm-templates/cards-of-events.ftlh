<div class="container-fluid row">
    <#list events as event>
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top " src="${event.attachmentFileName}" alt="">
                <div class="card-body">
                    <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
                        ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
                    <p class="card-text">${event.name}</p>
                    <p class="card-text">${(event.addressCity)!"n/a"}</p>
                    <p>${(event.addressName)!"n/a"}</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
                </div>
            </div>
        </div>
    </#list>
</div>