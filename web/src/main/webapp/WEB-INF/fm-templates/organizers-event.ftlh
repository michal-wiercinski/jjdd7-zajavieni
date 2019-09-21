<#include "navbar.ftlh">

<#include "alpha-pager.ftlh">

<#include "cards-of-events.ftlh">
<#if events?has_content><#include "pagination.ftlh">
<#else><div class="alert alert-secondary text-center font-weight-bold text-lg-center" role="alert">
     Nie znaleziono wydarzeń dla wybranego organizatora.
</div>
</#if>

