<div class="text-center">
    <!--<a class="btn btn-outline-primary" a href="#modalLRForm">Zaloguj</a>-->
    <a href="" class="btn btn-outline-primary my-3 waves-effect waves-light" data-toggle="modal"
       data-target="#modalLRForm">Zaloguj</a>
</div>
<!--Modal: Login / Register Form-->
<div class="modal fade" id="modalLRForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog cascading-modal" role="document">
        <!--Content-->
        <div class="modal-content">

            <!--Modal cascading tabs-->
            <div class="modal-c-tabs">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs md-tabs tabs-2 light-blue darken-3" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#panel7" role="tab"><i
                                    class="fas fa-user mr-1"></i>
                            Zaloguj</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#panel8" role="tab"><i
                                    class="fas fa-user-plus mr-1"></i>
                            Rejestracja</a>
                    </li>
                </ul>

                <!-- Tab panels -->
                <div class="tab-content">
                    <!--Panel 7-->
                    <div class="tab-pane fade in show active" id="panel7" role="tabpanel">

                        <!--Body-->
                        <div class="modal-body mb-1">
                            <div class="md-form form-sm mb-5">
                                <i class="fas fa-envelope prefix"></i>
                                <input type="email" id="modalLRInput10"
                                       class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput10">Twój
                                    email</label>
                            </div>

                            <div class="md-form form-sm mb-4">
                                <i class="fas fa-lock prefix"></i>
                                <input type="password" id="modalLRInput11"
                                       class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput11">Twoje
                                    hasło</label>
                            </div>
                            <div class="text-center mt-2">
                                <button class="btn btn-info">Zaloguj się<i class="fas fa-sign-in ml-1"></i></button>
                            </div>
                        </div>
                        <!--Footer-->
                        <div class="modal-footer">
                            <div class="options text-center text-md-right mt-1">
                                <p>Nie masz konta? <a href="#panel8" class="blue-text">Zarejestruj się</a></p>
                                <p>Zapomniałeś <a href="#" class="blue-text">hasła?</a></p>
                            </div>
                            <button type="button" class="btn btn-outline-info waves-effect ml-auto"
                                    data-dismiss="modal">Zamknij
                            </button>
                        </div>

                    </div>
                    <!--/.Panel 7-->

                    <!--Panel 8-->
                    <div class="tab-pane fade" id="panel8" role="tabpanel">

                        <!--Body-->
                        <div class="modal-body">
                            <div class="md-form form-sm mb-5">
                                <i class="fas fa-envelope prefix"></i>
                                <input type="email" id="modalLRInput12"
                                       class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput12">Twój
                                    email</label>
                            </div>

                            <div class="md-form form-sm mb-5">
                                <i class="fas fa-lock prefix"></i>
                                <input type="password" id="modalLRInput13"
                                       class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput13">Twoje
                                    hasło</label>
                            </div>

                            <div class="md-form form-sm mb-4">
                                <i class="fas fa-lock prefix"></i>
                                <input type="password" id="modalLRInput14"
                                       class="form-control form-control-sm validate">
                                <label data-error="wrong" data-success="right" for="modalLRInput14">Powtórz
                                    hasło</label>
                            </div>

                            <div class="text-center form-sm mt-2">
                                <button class="btn btn-info">Zarejestruj się <i class="fas fa-sign-in ml-1"></i>
                                </button>
                            </div>

                        </div>
                        <!--Footer-->
                        <div class="modal-footer">
                            <div class="options text-right">
                                <p class="pt-1">Posiadasz już konto? <a href="#panel7" class="blue-text">Zaloguj
                                        się</a>
                                </p>
                            </div>
                            <button type="button" class="btn btn-outline-info waves-effect ml-auto"
                                    data-dismiss="modal">Zamknij
                            </button>
                        </div>
                    </div>
                    <!--/.Panel 8-->
                </div>

            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
<!--Modal: Login / Register Form-->
</div>