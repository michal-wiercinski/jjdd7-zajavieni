<div class="container-fluid row">
    <#list events as event>
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top " style="max-height: 250px; min-height: 250px"
                     src="${(event.attachments[0].fileName)!"/img/plug.jpg"}" alt="" onerror="this.src='/img/plug.jpg';">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
                        ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
                    <p class="card-text">${event.name!"n/a"}</p>
                    <p class="card-text">${(event.addressCity)!"n/a"}</p>
                    <p>${(event.addressName)!"n/a"}</p>
                </div>
                <div class="card-footer">
                    <#if type != "GUEST">
                        <button type="button" data-id-event="${event.id?c}" data-id-user="${userId}" class="btn btn-primary make-booking">Zarezerwuj bilet</button>
                        <button type="button" data-id-event="${event.id?c}" data-id-user="${userId}" class="btn btn-outline-danger cancel-booking">Odwołaj rezerwację</button>
                    <#else>
                        <a href="/login" class="btn btn-primary">Zarezerwuj bilet</a>
                    </#if>
                    <a href="/event-view?id=${event.id?c}"
                       class="btn btn-primary show-event" <#--data-id="${event.id}"-->>Szczegóły</a>

                </div>
            </div>
        </div>
    </#list>
</div>