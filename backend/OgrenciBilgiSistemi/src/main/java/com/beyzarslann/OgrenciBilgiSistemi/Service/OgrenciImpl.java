package com.beyzarslann.OgrenciBilgiSistemi.Service;

import com.beyzarslann.OgrenciBilgiSistemi.Dto.OgrenciDto;
import com.beyzarslann.OgrenciBilgiSistemi.Entity.Ogrenci;
import com.beyzarslann.OgrenciBilgiSistemi.Exception.ResourceNotFoundException;
import com.beyzarslann.OgrenciBilgiSistemi.Mapper.OgrenciMap;
import com.beyzarslann.OgrenciBilgiSistemi.Repository.OgrenciRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OgrenciImpl implements OgrenciService{

    private OgrenciRepo ogrenciRepo;

    public OgrenciImpl(OgrenciRepo ogrenciRepo) {
        this.ogrenciRepo = ogrenciRepo;
    }

    @Override
    public OgrenciDto ogrenciOlustur(OgrenciDto ogrenciDto){
        Ogrenci ogrenci = OgrenciMap.dtoToEntity(ogrenciDto);
        Ogrenci kayitliOgrenci = ogrenciRepo.save(ogrenci);
        OgrenciDto yeniOgrenciDto = OgrenciMap.entityToDto(kayitliOgrenci);
        return yeniOgrenciDto;
    }

    @Override
    public OgrenciDto getById(Long ogrenciId){
        Ogrenci ogrenci = ogrenciRepo.findById(ogrenciId)
                .orElseThrow(() -> new ResourceNotFoundException("Bu id'ye sahip öğrenci bulunamadı." + ogrenciId));
                return OgrenciMap.entityToDto(ogrenci);
    }

    @Override
    public List<OgrenciDto> butunOgrenciler(){
        List<Ogrenci> ogrenciler = ogrenciRepo.findAll();
        return ogrenciler.stream().map(ogrenci -> OgrenciMap.entityToDto(ogrenci)).collect(Collectors.toList());
    }

    @Override
    public OgrenciDto ogrenciGuncelle(Long id, OgrenciDto guncelOgrenciDto) {
        Ogrenci ogrenci = ogrenciRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bu id'ye sahip öğrenci bulunamadı." + id));
        ogrenci.setAd(guncelOgrenciDto.getAd());
        ogrenci.setSoyad(guncelOgrenciDto.getSoyad());
        ogrenci.setEmail(guncelOgrenciDto.getEmail());
        ogrenci.setBolum(guncelOgrenciDto.getBolum());
        return OgrenciMap.entityToDto(ogrenci);
    }

    @Override
    public void ogrenciSil(Long id){
        Ogrenci ogrenci = ogrenciRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bu id'ye sahip öğrenci bulunanamdı." + id));
        ogrenciRepo.deleteById(id);
    }

    public OgrenciRepo getOgrenciRepo() {
        return ogrenciRepo;
    }

    public void setOgrenciRepo(OgrenciRepo ogrenciRepo) {
        this.ogrenciRepo = ogrenciRepo;
    }
}
