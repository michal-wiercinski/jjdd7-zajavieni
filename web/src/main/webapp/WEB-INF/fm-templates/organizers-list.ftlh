<#include "navbar.ftlh">
<#include "alpha-pager.ftlh">
<div>
<ul class="list-group">
    <#list organizers as organizer>
    <li class="list-group-item d-flex justify-content-between align-items-center">
        <a href="/filter-by-organizer?id=${organizer.id?c}">${organizer.name}</a>
       <#-- <span class="badge badge-primary badge-pill">${(organizer.getEvents()?size)!0}></span>-->
    </li>
    </#list>
</ul>
</div>
<#include "footer.ftlh">