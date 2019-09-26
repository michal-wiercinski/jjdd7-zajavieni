<#include "navbar.ftlh">
<#include "favourite-beam.ftlh">
<div class="card text-center">
  <div class="card-header">
    <h2 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
        ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h2>
  </div>
  </br>
  <h2 class="card-title">${event.name}</h2>
  <p class="card-text">${event.descLong!event.descShort}</p>

  <div class="card-body text-center">
    <div class="container-fluid">
      <div class="row">
        <div class="col-4 float-left ">
          <img class="card-img-top img-fluid" style="max-height: 700px; max-width: 550px"
               src="${(event.attachments[0].fileName)!"/img/plug.jpg"}" alt="">
        </div>
        <div class="col-4 text-center">
            <#if event.addressName??>
              <h3><span class="badge badge-secondary">Miejsce</span></h3>
              <p class="card-text">${event.addressName}</p>
            </#if>

          <h3><span class="badge badge-secondary">Organizator</span></h3>
          <p class="card-text">${event.organizerName}</p>

          <h3><span class="badge badge-secondary">Adres</span></h3>
            <#if event.addressStreet??>
              <p class="card-text">${event.addressStreet}</p>
            </#if>
            <#if event.addressCity??>
              <p class="card-text">${event.addressCity}</p>
            </#if>
            <#if event.addressZipCode??>
              <p class="card-text">${event.addressZipCode}</p>
            </#if>

          <h3><span class="badge badge-secondary">Linki</span></h3>
            <#if event.wwwAddress?has_content>
              <p class="card-text"><a href="${event.wwwAddress}"> Strona WWW </a></p>
            </#if>
            <#if event.fbSite?has_content>
              <p class="card-text"><a href="${event.fbSite}"> Facebook </a></p>
            </#if>
            <#if event.websiteWithTickets?has_content>
              <p class="card-text"><a href="${event.websiteWithTickets}"> Strona z
                  biletami</a></p>
            </#if>
        </div>
      </div>
    </div>
    </br></br></br>
  </div>
  <div class="card-footer d-inline">

      <#if type != "QUEST">
         <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
        <button type="button"
                class="${isFavourite?then('btn btn-outline-danger','btn btn-outline-success')}"
                id='${isFavourite?then('deleteE','addE')}'
                data-id='${event.id?c}'>
            ${isFavourite?then('Usuń z ulubionych ❌', 'Dodaj do ulubionych ✅')}
        </button>
      </#if>
  </div>
</div>
<script src="/js/favourite.js"></script>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<#include "footer.ftlh">