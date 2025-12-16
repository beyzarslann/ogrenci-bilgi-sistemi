import React, { useState } from "react";
import { ogrenciEkle } from "../service/OgrenciService";
import { useNavigate } from "react-router-dom";

const OgrenciEkle = () => {
  const [ad, setAd] = useState("");
  const [soyad, setSoyad] = useState("");
  const [email, setEmail] = useState("");
  const [bolum, setBolum] = useState("");
  const [hata, setHata] = useState({
    ad: "",
    soyad: "",
    email: "",
    bolum: "",
  });

  const navigator = useNavigate();

  const dogrula = () => {
    let validation = true;
    const hataKopyasi = {};

    if (!ad.trim()) {
      hataKopyasi.ad = "Ad alanını doldurmanız gerekmektedir!";
      validation = false;
    }

    if (!soyad.trim()) {
      hataKopyasi.soyad = "Soyad alanını doldurmanız gerekmektedir!";
      validation = false;
    }

    if (!email.trim()) {
      hataKopyasi.email = "E-posta alanını doldurmanız gerekmektedir!";
      validation = false;
    }

    setHata(hataKopyasi);
    return validation;
  };

  function ogrenciKaydet(e) {
    e.preventDefault();
    if (dogrula()) {
      const ogrenci = { ad, soyad, email, bolum };
      ogrenciEkle(ogrenci).then((response) => {
        console.log(response.data);
        navigator("/ogrenciler");
      });
    }
  }

  return (
    <div className="container">
      <br />
      <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h1 className="text-center"> Öğrenci Ekleme Formu </h1>
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Öğrenci Adı:</label>
                <input
                  type="text"
                  className={`form-control ${hata.ad ? "is-invalid" : ""}`}
                  placeholder="Ad"
                  name="adGir"
                  value={ad}
                  onChange={(e) => setAd(e.target.value)}
                />
                {hata.ad && <div className="invalid-feedback">{hata.ad}</div>}
              </div>
            </form>
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Öğrenci Soyadı:</label>
                <input
                  type="text"
                  className={`form-control ${hata.soyad ? "is-invalid" : ""}`}
                  placeholder="Soyad"
                  name="soyadGir"
                  value={soyad}
                  onChange={(e) => setSoyad(e.target.value)}
                />
                {hata.soyad && (
                  <div className="invalid-feedback">{hata.soyad}</div>
                )}
              </div>
            </form>
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Email :</label>
                <input
                  type="text"
                  className={`form-control ${hata.email ? "is-invalid" : ""}`}
                  placeholder="Email"
                  name="emailGir"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
                {hata.email && (
                  <div className="invalid-feedback">{hata.email}</div>
                )}
              </div>
            </form>
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Bölüm :</label>
                <input
                  type="text"
                  className={`form-control ${hata.bolum ? "is-invalid" : ""}`}
                  placeholder="Bolum"
                  name="bolumGir"
                  value={bolum}
                  onChange={(e) => setBolum(e.target.value)}
                />
                {hata.bolum && (
                  <div className="invalid-feedback">{hata.bolum}</div>
                )}
              </div>
              <button className="btn btn-success" onClick={ogrenciKaydet}>
                Kaydet
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default OgrenciEkle;
