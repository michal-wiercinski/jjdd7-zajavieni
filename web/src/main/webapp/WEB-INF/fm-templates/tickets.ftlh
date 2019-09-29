<#include "navbar.ftlh">


<div>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nazwa</th>
      <th scope="col">Data</th>
      <th scope="col">Więcej</th>
      <th scope="col">Zarządzaj</th>
    </tr>
    </thead>
    <tbody>
    <#list events as event>
      <tr>
        <th scope="row">1</th>
        <td>${event.name!"n/a"}</td>
        <td>${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
            ${event.endDate?string('dd.MM.yyyy (HH:mm)')}</td>
        <td><a class="btn btn-primary"
               href="/event-view?id=${event.id?c}">Szczegóły</a></td>
        <td>
          <div class="btn-group" role="group" aria-label="Basic example">
            <button type="button" data-id-event="${event.id?c}" data-id-user="${userId}" class="btn btn-outline-danger cancel-booking">Odwołaj rezerwację</button>
          </div>
        </td>
      </tr>
    </#list>
    </tbody>
  </table>
</div>

