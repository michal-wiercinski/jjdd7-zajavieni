<#include "navbar.ftlh">
<a class="p-2 text-dark" href="/admin/upload">Admin</a>

<div>
<ul class="list-group"
<#list users as user>
    <li class="list-group-item d-flex justify-content-between align-items-center">
        <p>${user.name}</p>
    </li>
</#list>
    </ul>
    </div>