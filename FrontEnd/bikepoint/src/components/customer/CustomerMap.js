import React, { useEffect, useState } from "react";
import {
  TileLayer,
  MapContainer,
  LayersControl
} from "react-leaflet";

import RoutingControl from './RoutingControl'
import { findGarageByProblem, findProblemById } from "../../service/garageservice";

const maps = {
  base: "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
};

export default function CustomerMap() {
  const [map, setMap] = useState(null);
  const [start, setStart] = useState({ latitude: null, longitude: null });

  const [garageData, setGarageData] = useState({
    email: '',
    password: '',
    garageName: '',
    mobileNo: '',
    latitude: null,
    longitude: null,
    address: ''
  });

  const problemId = sessionStorage.getItem("problemId");

  useEffect(() => {
    if ("geolocation" in navigator) {
      navigator.geolocation.getCurrentPosition(function (position) {
        setStart({
          latitude: position.coords.latitude,
          longitude: position.coords.longitude,
        });
      });

      const interval = setInterval(() => {
        findProblemById(problemId).then(resp => {
          
          if (resp.status === "Under Repair") {
            findGarageByProblem(problemId).then(data => {
              setGarageData({
                email: data.email,
                password: data.password,
                garageName: data.garageName,
                mobileNo: data.mobileNo,
                latitude: data.latitude,
                longitude: data.longitude,
                address: data.address
              })

            }).catch(err => {
              console.log(err)
              console.log("error in garage")
            })

          }
        }).catch(err => {
          console.log(err)
          console.log("error in problem")
        })
      }, 10000);

      setTimeout(() => {
        clearInterval(interval)
      }, 60000);

    } else {
      console.log("Geolocation is not available in your browser.");
    }


  }, []);


  return (
    <>


      {(start.latitude && start.longitude && garageData.latitude != null && garageData.longitude != null) ? (
        <>
          <div className="card shadow" style={{width: "25%", position: 'fixed', top: '67vh', left: '3vh' }}>
            <h5 className="card-header bg-danger">{garageData.garageName}</h5>
            <div className="card-body">
            <p className="card-text-sm">Mechanic is reaching to your location shortly...</p>
              {/* <h6 className="card-title">call Mechanic on +91 {garageData.mobileNo}</h6> */}
             
              <a href={`tel:+91${garageData.mobileNo}`} class="btn btn-danger">Call</a>
            </div>
          </div>
          <div className="container" style={{ position: 'fixed', top: '8vh', right: '0', minWidth: '100%', zIndex: '-2' }}>
            <MapContainer
              center={[(start.latitude + garageData.latitude) / 2, (start.longitude + garageData.longitude) / 2]}
              zoom={12}
              zoomControl={false}
              style={{ height: "100vh", width: "100%", padding: 0 }}
              whenCreated={map => setMap(map)}
            >
              {/* *************** */}
              {/* {setStart([18.625331, 73.780429])}
                    {setEnd([18.765720, 73.689050])}  */}
              {/* *************** */}
              <RoutingControl
                startLat={start.latitude}
                startLog={start.longitude}
                endLat={garageData.latitude}
                endLog={garageData.longitude}
              />
              <LayersControl position="topright">
                <LayersControl.BaseLayer checked name="Map">
                  <TileLayer
                    attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                    url={maps.base}
                  />
                </LayersControl.BaseLayer>
              </LayersControl>
            </MapContainer>
            </div>
        </>) : (
          <p>Loading...</p>
        )}
        

    </>
  );
}
