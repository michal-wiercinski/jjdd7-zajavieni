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
          <a href="/api/admin/give/${user.id}" class="btn btn-success">Daj uprawnienia Admina</a>
            <a href="/api/admin/revoke/${user.id}" class="btn btn-danger">Odbierz uprawnienia Admina</a>
        </div>
      </td>
    </tr>
    </#list>
    </tbody>
  </table>
</div>