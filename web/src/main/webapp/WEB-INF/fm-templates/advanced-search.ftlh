<#include "navbar.ftlh">
<#include "favourite-beam.ftlh">

<div>
  <h2> Wyszukiwanie </h2>

  <div class="container-fluid row">

    <form class="form-inline" action="/advanced-search" method="get">

      <label class="sr-only" for="inputCategorySearch">Wyszukuj w</label>
      <select id="inputCategorySearch" class="form-control mb-2 mr-sm-2" name="categorySearch">
        <option selected> Nazwa wydarzenia</option>
        <option> Nazwa organizatora</option>
      </select>

      <label class="sr-only" for="inlineFormInputName2">Nazwa</label>
      <input type="text" class="form-control mb-2 mr-sm-2" id="inlineFormInputName2"
             placeholder="Wyszukiwana fraza" name="name">

      <label class="sr-only" for="inlineFormInputName2">Data początkowa</label>
      <input type="date" class="form-control mb-2 mr-sm-2" id="inlineFormInputDate"
             name="startDate">

      <label class="sr-only" for="inlineFormInputName2">Data końcowa</label>
      <input type="date" class="form-control mb-2 mr-sm-2" id="inlineFormInputDate2" name="endDate">

      <button class="btn btn-outline-primary btn-rounded btn-sm my-0 waves-effect waves-light"
              type="submit">
        Szukaj
      </button>

    </form>

  </div>

</div>

<#include "footer.ftlh">