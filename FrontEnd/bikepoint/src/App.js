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


import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <>

      <BrowserRouter>
      <Header title='Bike Point'/>
        <Routes>
          <Route exact path="/" element={<LandingPage />} />
          <Route exact path="/map" element={<CustomerMap />} />
          <Route exact path="/userLogin" element={<UserLogin/>}/>
          <Route exact path="/customerSignup" element={<CustomerSignup/>}/>
          <Route exact path="/adminDashboard" element={<AdminDashboard/>}/>
          <Route exact path="/add-new-garage" element={<AddNewGarage/>}/>
          <Route exact path="/add-new-part" element={<AddNewPart/>}/>
          <Route exact path="/add-new-service" element={<AddNewService/>}/>
        </Routes>
        <Footer />
      </BrowserRouter>

    </>
  );
}

export default App;
