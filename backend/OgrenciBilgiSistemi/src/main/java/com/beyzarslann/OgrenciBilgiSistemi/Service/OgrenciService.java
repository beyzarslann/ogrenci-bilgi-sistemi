package com.beyzarslann.OgrenciBilgiSistemi.Service;

import com.beyzarslann.OgrenciBilgiSistemi.Dto.OgrenciDto;

import java.util.List;

public interface OgrenciService {

    OgrenciDto ogrenciOlustur(OgrenciDto ogrenciDto);

    OgrenciDto getById(Long ogrenciId);

    List<OgrenciDto> butunOgrenciler();

    OgrenciDto ogrenciGuncelle(Long id, OgrenciDto guncelOgrenciDto);

    void ogrenciSil(Long id);
}