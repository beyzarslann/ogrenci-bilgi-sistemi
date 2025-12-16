import React, { useEffect, useState } from "react";
import { ogrenciListesi } from "../service/OgrenciService";
import { useNavigate } from "react-router-dom";

const OgrenciListesi = () => {
  const [ogrenci, setOgrenci] = useState([]);
  const navigator = useNavigate();

  useEffect(() => {
    ogrenciListesi()
      .then((response) => {
        setOgrenci(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  function yeniOgrenciEkle() {
    navigator("/yeniOgrenci");
  }

  return (
    <div className="container">
      <h1 className="text-center">OgrenciListesi</h1>
      <button className="btn btn-dark" onClick={yeniOgrenciEkle}>
        {" "}
        Öğrenci Ekle{" "}
      </button>
      <table className="table table-striped table-hover">
        <thead>
          <tr>
            <th>Id</th>
            <th>Ad</th>
            <th>Soyad</th>
            <th>Email</th>
            <th>Bölüm</th>
          </tr>
        </thead>
        <tbody>
          {ogrenci.map((deger) => (
            <tr key={deger.id}>
              <td>{deger.id} </td>
              <td>{deger.ad} </td>
              <td>{deger.soyad} </td>
              <td>{deger.email} </td>
              <td>{deger.bolum} </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default OgrenciListesi;
