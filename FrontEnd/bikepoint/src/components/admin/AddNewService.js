import React from 'react'

export default function AddNewService() {

    return (
        <>
            <form>
                {/* <!----------------------- Main Container --------------------------> */}
                <div class="container d-flex justify-content-center align-items-center min-vh-100 w-50 ">
                    {/* <!----------------------- Form Container --------------------------> */}
                    <div class="row border rounded-5 p-5 bg-white shadow box-area">
                        <form>
                            <div class="row">
                            <div class="header-text mb-2">
                                <h2>Add New Service Here!</h2>
                            </div>
                                <div class="row mb-3">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="serviceType" placeholder="" />
                                        <label for="serviceType">Service Name </label>
                                    </div>
                                </div>
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="serviceCost" placeholder="" />
                                            <label for="serviceCost">Service Cost </label>
                                        </div>
                                    </div>

                                    <div class="input-group">
                                        <button class="btn btn-lg btn-danger w-100 fs-6">Save</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </form>
        </>
    )
}
