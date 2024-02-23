import React from 'react'
import '../UserLogin.css'

export default function AddNewPart() {
    return (
        <>
            {/* <!----------------------- Main Container --------------------------> */}
            <div class="container d-flex justify-content-center align-items-center min-vh-100 w-50 ">
                {/* <!----------------------- Login Container --------------------------> */}
                <div class="row border rounded-5 p-5 bg-white shadow box-area">
                    <form>
                        <div class="row align-items-center">
                            <div class="header-text mb-4">
                                <h2>Add Parts Here!</h2>
                            </div>
                            <div class="row">

                                <div class="row mb-3">
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="partName" placeholder="" />
                                            <label for="partName">Part Name </label>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="partCost" placeholder="" />
                                            <label for="partCost">Part Cost </label>
                                        </div>
                                    </div>
                                    <div class="input-group ">
                                        <select class="form-select mb-3">
                                            <option value="1" selected>Vehicle Company</option>
                                            <option value="2">Royal Enfield</option>
                                            <option value="3">Hero</option>
                                            <option value="4">Honda</option>
                                            <option value="5">Bajaj </option>
                                        </select>
                                        <div class="input-group">
                                            <button class="btn btn-lg btn-danger w-100 fs-6">Save</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </>
    )
}
