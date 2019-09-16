<div class="card text-center">
    <div class="card-header">
        <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
            ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
    </div>
    <div class="card-body">
        <h5 class="card-title">${event.name}</h5>
        <p class="card-text">Miejsce: ${event.addressName!"n/a"}</p>
        <p class="card-text">Adres: ${event.addressStreet!"n/a"}
            </br> ${event.addressCity!"n/a"}</p>
            </br> ${event.addressZipCode!"n/a"}</p>
        <p class="card-text">${event.descLong!"Brak opisu"}</p>
        <#if event.wwwAddress?has_content><p class="card-text">Miejsce: ${event.addressName}</p></#if>
        <#if event.fbSite?has_content><p class="card-text">Miejsce: ${event.addressName}</p></#if>
        <#if event.websiteWithTickets?has_content><p class="card-text">Miejsce: ${event.addressName}</p></#if>

    </div>
    <div class="card-footer d-inline">
        <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
        <a href="#" class="btn btn-primary">Dodaj do ulubionych</a>
    </div>
</div>