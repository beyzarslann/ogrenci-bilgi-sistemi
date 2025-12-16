package com.beyzarslann.OgrenciBilgiSistemi.Repository;

import com.beyzarslann.OgrenciBilgiSistemi.Entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OgrenciRepo extends JpaRepository<Ogrenci, Long> {
}
