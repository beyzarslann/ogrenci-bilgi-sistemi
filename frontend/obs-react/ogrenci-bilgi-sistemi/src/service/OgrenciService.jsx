import axios from "axios";

const REST_API_ANA_URL = "http://localhost:8080/api/ogrenciler";
export const ogrenciListesi = () => axios.get(REST_API_ANA_URL);
export const ogrenciEkle = (ogrenci) => axios.post(REST_API_ANA_URL, ogrenci);
