import './App.css';
import CustomerMap from './components/customer/CustomerMap';
import LandingPage from './components/LandingPage';
import Footer from './components/Footer';
import Header from './components/Header';
import UserLogin from './components/UserLogin';
import CustomerSignup from './components/customer/CustomerSignup';
import AdminDashboard from './components/admin/AdminDashboard';
import AddNewGarage from './components/admin/AddNewGarage';
import AddNewPart from './components/admin/AddNewPart';
import AddNewService from './components/admin/AddNewService';
import CustomerDashboard from './components/customer/CustomerDashboard';
import Adminroute from './components/admin/Adminroute';
import Customerroute from './components/customer/Customerroute';
import Garageroute from './components/garage/Garageroute';
import GarageDashboard from './components/garage/GarageDashboard';
import RegisterProblem from './components/customer/RegisterProblem';
import PriviousServiceList from './components/customer/PriviousServiceList';
import FindServiceRequests from './components/garage/FindServiceRequests';
import GarageMap from './components/garage/GarageMap';


import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <>

      <BrowserRouter>
      <Header title='Bike Point'/>
        <Routes>

          <Route path="/" element={<LandingPage />} />
          <Route path="/userLogin" element={<UserLogin/>}/>
          <Route path="/signup" element={<CustomerSignup/>}/>          

          <Route path='/customer' element={<Customerroute/>}>
          <Route path="dashboard" element={<CustomerDashboard/>}/>
          <Route path="addproblem" element={<RegisterProblem/>}/>
          <Route path="service-list" element={<PriviousServiceList/>}/>
          <Route path="map" element={<CustomerMap />} />
          
          </Route>

          <Route path='/garage' element={<Garageroute/>}>
          <Route path="dashboard" element={<GarageDashboard/>}/>
          <Route path="find-requests" element={<FindServiceRequests/>}/>
          <Route path="map" element={<GarageMap/>} />
          </Route>


          <Route path='/admin' element={<Adminroute/>}>
          <Route path="dashboard" element={<AdminDashboard/>}/>
          <Route path="add-new-garage" element={<AddNewGarage/>}/>
          <Route path="add-new-part" element={<AddNewPart/>}/>
          <Route path="add-new-service" element={<AddNewService/>}/>
          </Route>
        </Routes>
        <Footer />
      </BrowserRouter>

    </>
  );
}

export default App;
