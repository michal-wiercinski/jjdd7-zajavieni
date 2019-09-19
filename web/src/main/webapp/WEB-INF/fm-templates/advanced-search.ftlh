<#include "navbar.ftlh">

<div>
	<h2> Wyszukiwanie </h2>

	<div class="container-fluid row">

		<form action="/advanced-search" method="get">
			<div class="form-row">
				<div class="col">
					<label for="searchText">Nazwa/organizator</label>
					<input type="text" class="form-control" id="searchText" placeholder="nazwa/organizator">
				</div>
				<div class="col">
					<label for="startDate">Data początkowa</label>
					<input type="date" class="form-control" id="startDate" placeholder="Data początkowa">
				</div>
				<div class="col">
					<label for="endDate">Data końcowa</label>
					<input type="date" class="form-control" id="endDate" placeholder="Data końcowa">
				</div>
				<div class="col">
					<div class="col-sm-5">
						<button type="submit" class="btn btn-primary">Szukaj</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<#include "footer.ftlh">
