<#include "navbar.ftlh">

<#include "favourite-beam.ftlh">

<div>
    <h2> Formularz </h2>

    <div class="container-fluid row">

        <form method="post" action="/admin/upload" enctype="multipart/form-data">

            <div class="custom-file ">
                <input type="file" class="custom-file-input" id="dataFile1" name="eventFile">
                <label class="custom-file-label" for="dataFile1">Plik z wydarzeniami</label>
            </div>

            <div class="custom-file ">
                <input type="file" class="custom-file-input" id="dataFile2" name="placeFile">
                <label class="custom-file-label" for="dataFile2">Plik z miejscami</label>
            </div>

            <div class="custom-file ">
                <input type="file" class="custom-file-input" id="dataFile3" name="organizerFile">
                <label class="custom-file-label" for="dataFile3">Plik z organizatorami</label>
            </div>

            <div class="form-group row">
                <div class="col-sm-5">
                    <button type="submit" class="btn btn-primary">Zatwierdź</button>
                </div>
            </div>
        </form>
    </div>

</div>

<#include "footer.ftlh">
