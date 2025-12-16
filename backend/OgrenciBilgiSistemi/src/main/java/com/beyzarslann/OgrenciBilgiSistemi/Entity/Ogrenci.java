package com.beyzarslann.OgrenciBilgiSistemi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ogrenci")
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

    private String soyad;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String bolum;

    public Ogrenci() {
    }

    public Ogrenci(Long id, String ad, String soyad, String email, String bolum) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.bolum = bolum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }
}
