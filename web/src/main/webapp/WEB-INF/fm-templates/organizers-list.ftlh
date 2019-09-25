<#include "navbar.ftlh">
<#include "favourite-beam.ftlh">
<#include "alpha-pager.ftlh">
<div>
<ul class="list-group">
    <#list organizers as organizer>
    <li class="list-group-item d-flex justify-content-between align-items-center">
            <a class="btn btn-outline-primary btn-block" style="font-size: 30px"
               href="/filter-by-organizer?id=${organizer.id?c}&pageNo=0">${organizer.name}</a>
       <#-- <span class="badge badge-primary badge-pill">${(organizer.getEvents()?size)!0}></span>-->
    </li>
    </#list>
</ul>
</div>
<#include "footer.ftlh">