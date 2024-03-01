import L from "leaflet";
import { createControlComponent } from "@react-leaflet/core";
import "leaflet-routing-machine";
import 'leaflet-routing-machine/dist/leaflet-routing-machine.css'

const createRoutineMachineLayer = (props) => {
  const instance = L.Routing.control({
    position: 'topleft',
    waypoints: [
      L.latLng(props.startLat, props.startLog),
      L.latLng(props.endLat, props.endLog)
      
    ],
    lineOptions: {
      styles: [
        {
          color: '#D22B2B',
        },
      ],
    },
  });

  return instance;
};

// Pass our createRoutingMachineLayer to the createControlHook:
const RoutingMachine = createControlComponent(createRoutineMachineLayer);

// Export
export default RoutingMachine;