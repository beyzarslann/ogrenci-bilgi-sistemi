import { useState } from "react";
import "./App.css";
import OgrenciListesi from "./bilesenler/OgrenciListesi";
import Navbar from "./bilesenler/Navbar";
import { Routes, Route } from "react-router-dom";
import OgrenciEkle from "./bilesenler/OgrenciEkle";

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<OgrenciListesi />}></Route>
        <Route path="/ogrenciler" element={<OgrenciListesi />}></Route>
        <Route path="/yeniOgrenci" element={<OgrenciEkle />}></Route>
      </Routes>
    </>
  );
}

export default App;
