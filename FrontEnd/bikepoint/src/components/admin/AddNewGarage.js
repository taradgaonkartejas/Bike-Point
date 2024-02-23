import React, { useEffect, useState } from 'react'
import '../UserLogin.css'

export default function AddNewGarage() {
    const [location, setLocation] = useState({ latitude: null, longitude: null });

    useEffect(() => {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(function (position) {
                setLocation({
                    latitude: position.coords.latitude,
                    longitude: position.coords.longitude,
                });
            });
        } else {
            console.log("Geolocation is not available in your browser.");
        }
    }, []);

    return (
        <>
            {location.latitude && location.longitude ? (
                <>
                    {/* <!----------------------- Main Container --------------------------> */}
                    <div class="container d-flex justify-content-center align-items-center min-vh-100 w-50 ">
                        {/* <!----------------------- Registration Container --------------------------> */}
                        <div class="row border rounded-5 p-3 bg-white shadow box-area">
                            <form>
                                <div class="row align-items-center">

                                    <div class="col-md-12 right-box">
                                        <div class="header-text ">
                                            <h2>Add new Garage Here!</h2>
                                            <p></p>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <div class="form-floating mb-3">
                                                    <input type="text" class="form-control" id="email" placeholder="" />
                                                    <label for="email">Email</label>
                                                </div>
                                            </div>
                                            <div class="col">
                                                <div class="form-floating mb-3">
                                                    <input type="text" class="form-control" id="password" placeholder="" />
                                                    <label for="password">Passsword</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="mobileNo" placeholder="" />
                                                <label for="mobileNo">Mobile No</label>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col">
                                                <div class="form-floating mb-3">
                                                    <textarea class="form-control" id="address" rows="4" placeholder=""></textarea>
                                                    <label for="address">Address</label>
                                                </div>
                                                <p>Latitude: {location.latitude}  Longitude:{location.longitude}</p>
                                                <div class="input-group">
                                                    <button class="btn btn-lg btn-danger w-100 fs-6">Register</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </>
            ) : (
                <p>Loading...</p>
            )}



        </>
    )
}
