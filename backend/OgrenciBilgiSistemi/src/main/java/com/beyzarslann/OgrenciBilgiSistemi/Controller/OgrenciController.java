package com.beyzarslann.OgrenciBilgiSistemi.Controller;

import com.beyzarslann.OgrenciBilgiSistemi.Dto.OgrenciDto;
import com.beyzarslann.OgrenciBilgiSistemi.Service.OgrenciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ogrenciler")
public class OgrenciController {
    private OgrenciService ogrenciService;

    public OgrenciController(OgrenciService ogrenciService) {
        this.ogrenciService = ogrenciService;
    }

    @PostMapping
    public ResponseEntity<OgrenciDto> ogrenciOlustur(@RequestBody OgrenciDto ogrenciDto){
        OgrenciDto kayitliOgrenciDto = ogrenciService.ogrenciOlustur(ogrenciDto);
        return new ResponseEntity<>(kayitliOgrenciDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OgrenciDto> getById(@PathVariable("id") Long id){
        OgrenciDto getByIdDto = ogrenciService.getById(id);
        return new ResponseEntity<>(getByIdDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OgrenciDto>> butunOgrenciler(){
        List<OgrenciDto> butunOgrencilerDto = ogrenciService.butunOgrenciler();
        return new ResponseEntity<>(butunOgrencilerDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<OgrenciDto> ogrenciGuncelle(@PathVariable("id") Long id, @RequestBody OgrenciDto guncelOgrenciDto){
        OgrenciDto ogrenciGuncelleDto = ogrenciService.ogrenciGuncelle(id, guncelOgrenciDto);
        return new ResponseEntity<>(guncelOgrenciDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> ogrenciSil(@PathVariable("id") Long id){
        ogrenciService.ogrenciSil(id);
        return new ResponseEntity<>("Öğrenci başarılı bir şekilde silinmiştir.", HttpStatus.OK);
    }

    public OgrenciService getOgrenciService() {
        return ogrenciService;
    }

    public void setOgrenciService(OgrenciService ogrenciService) {
        this.ogrenciService = ogrenciService;
    }
}
