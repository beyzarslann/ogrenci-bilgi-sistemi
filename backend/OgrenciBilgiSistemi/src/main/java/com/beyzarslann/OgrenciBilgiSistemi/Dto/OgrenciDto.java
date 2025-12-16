package com.beyzarslann.OgrenciBilgiSistemi.Dto;

import jakarta.persistence.Column;

public class OgrenciDto {
    private Long id;

    private String ad;

    private String soyad;

    private String email;

    private String bolum;

    public OgrenciDto() {
    }

    public OgrenciDto(Long id, String ad, String soyad, String email, String bolum) {
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
