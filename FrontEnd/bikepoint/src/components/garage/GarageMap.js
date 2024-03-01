import React, { useEffect, useState } from "react";
import {
  TileLayer,
  MapContainer,
  LayersControl
} from "react-leaflet";

import RoutingControl from './RoutingControl'
import { findProblemById } from "../../service/garageservice";

const maps = {
  base: "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
};

export default function GarageMap() {
    const [map, setMap] = useState(null);
    const [start, setStart] = useState({ latitude: null, longitude: null });
    const [end, setEnd] = useState({ latitude: null, longitude: null });

    const id=sessionStorage.getItem("problemId");

  useEffect(() => {
    if ("geolocation" in navigator) {
      navigator.geolocation.getCurrentPosition(function (position) {
        setStart({
          latitude: position.coords.latitude,
          longitude: position.coords.longitude,
        });
      });

      findProblemById(id).then((resp)=>{
        console.log(resp);
        setEnd({
          latitude: resp.latitude,
          longitude: resp.longitude,
        });
        console.log("Sucess");
      }).catch(err=>{
        console.log(err);
        console.log("Error");
      })
     
    } else {
      console.log("Geolocation is not available in your browser.");
    }
  }, []);


  console.log(start.latitude+'  '+start.longitude)
  console.log(end.latitude+'  '+end.longitude)
  return (
    <>
     <div className="container"style={{ position: 'fixed', top: '8vh',right: '0', minWidth: '100%',zIndex: '-2'}}>
      {(start.latitude && start.longitude && end.latitude && end.longitude) ? (
        <MapContainer
        center={[(start.latitude+end.latitude)/2, (start.longitude+end.longitude)/2]}
        zoom={12}
        zoomControl={false}
        style={{ height: "100vh", width: "100%", padding: 0 }}
        whenCreated={map => setMap(map) }
      >
        {/* *************** */}
        {/* {setStart([18.625331, 73.780429])}
        {setEnd([18.765720, 73.689050])}  */}
        {/* *************** */}
        <RoutingControl 
          startLat={start.latitude} 
          startLog={start.longitude} 
          endLat={end.latitude} 
          endLog={end.longitude}
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
      ) : (
        <p>Loading...</p>
      )}
    </div>
      
    </>
  );
}
