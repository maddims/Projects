package com.hcl.db.nace.repository;

import com.hcl.db.nace.bean.Nace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository extends JpaRepository<Nace, Long> {
    Nace findByNaceCode(String naceCode);
}
