package com.administrative.painel.repository;

import com.administrative.painel.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {}
