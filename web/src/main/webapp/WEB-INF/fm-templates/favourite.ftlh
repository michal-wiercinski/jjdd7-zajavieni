
<#include "navbar.ftlh">
<div class="alert alert-dark text-center" role="alert">
  <h1>
    <strong>Twoje ulubione wydarzenia</strong>
  </h1>
</div>
<#--<h1 class="text-center" style="background-color:cadetblue;">TWOJE ULUBIONE WYDARZENIA</h1>-->
<div class="container-fluid row">
    <#if favouriteEvents?size == 0>
      <div class="container-fluid">
        <h5 class="text-center ">Brak wydarzeń na liście ulubionych</h5>
      </div>
    <#else>
        <#list favouriteEvents as event>
          <div class="col-lg-4 col-md-6 mb-4">
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
              </div>
            </div>
          </div>
        </#list>
    </#if>
</div>

<#include "footer.ftlh">