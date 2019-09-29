<#include "navbar.ftlh">
<#include "favourite-beam.ftlh">
<div class="alert alert-dark text-center" role="alert">
  <h1>
    <strong>Twoje ulubione wydarzenia</strong>
  </h1>
</div>
<div class="container-fluid row">
    <#if favouriteEvents?size == 0>
      <div class="container-fluid">
        <h5 class="text-center ">Brak wydarzeń na liście ulubionych</h5>
      </div>
    <#else>
        <#list favouriteEvents as event>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="/event-view?id=${event.id?c}"><img class="card-img-top " style="max-height: 250px"
                   src="${(event.attachments[0].fileName)!"/img/plug.jpg"}" alt=""></a>
              <div class="card-body d-flex flex-column">
                <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
                    ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
                <p class="card-text">${event.name}</p>
                <p class="card-text">${(event.addressCity)!"n/a"}</p>
                <p>${(event.addressName)!"n/a"}</p>
              </div>
              <div class="card-footer">
                  <#if event.bookedForUser == false >
                    <button type="button"
                            data-toggle="popover" data-id-event="${event.id?c}" data-id-user="${userId}" class="btn btn-primary make-booking"
                            data-content="Zarezerwowałeś wydarzenie">Zarezerwuj bilet</button>
                  <#else>
                    <button type="button"
                            data-toggle="popover" data-id-event="${event.id?c}" data-id-user="${userId}" class="btn btn-outline-danger cancel-booking"
                            data-content="Odwołałeś rezerwację">Odwołaj rezerwację</button>
                  </#if>
                <a href="/event-view?id=${event.id?c}"
                   class="btn btn-primary show-event" <#--data-id="${event.id}"-->>Szczegóły</a>
              </div>
            </div>
          </div>
        </#list>
    </#if>
</div>

<#include "footer.ftlh">