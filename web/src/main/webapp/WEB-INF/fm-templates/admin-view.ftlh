<#include "navbar.ftlh">
<a class="btn-lg btn-primary" href="/admin/upload">Upload danych</a>
<br><br>

<div>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">User name</th>
      <th scope="col">Email</th>
      <th scope="col">Status uprawnień</th>
      <th scope="col">Zarządzaj</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
      <th scope="row">${user.id}</th>
      <td>${user.name}</td>
      <td>${user.email}</td>
      <td>${user.userType}</td>
      <td>
        <div class="btn-group" role="group" aria-label="Basic example">
          <button type="button" data-id="${user.id}" class="btn btn-outline-success give">Daj uprawnienia Admina</button>
          <button type="button" data-id="${user.id}" class="btn btn-outline-danger revoke">Odbierz uprawnienia Admina</button>
        </div>
      </td>
    </tr>
    </#list>
    </tbody>
  </table>
</div>