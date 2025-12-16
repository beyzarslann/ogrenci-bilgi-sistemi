package com.beyzarslann.OgrenciBilgiSistemi.Mapper;

import com.beyzarslann.OgrenciBilgiSistemi.Dto.OgrenciDto;
import com.beyzarslann.OgrenciBilgiSistemi.Entity.Ogrenci;

public class OgrenciMap {

    public static OgrenciDto entityToDto(Ogrenci ogrenci){
        String bolum = ogrenci.getBolum() != null
                ? ogrenci.getBolum()
                : "";

        return new OgrenciDto(
                ogrenci.getId(),
                ogrenci.getAd(),
                ogrenci.getSoyad(),
                ogrenci.getEmail(),
                ogrenci.getBolum()
        );
    }

    public static Ogrenci dtoToEntity(OgrenciDto ogrenciDto){
        return new Ogrenci(
                ogrenciDto.getId(),
                ogrenciDto.getAd(),
                ogrenciDto.getSoyad(),
                ogrenciDto.getEmail(),
                ogrenciDto.getBolum()
        );
    }
}
