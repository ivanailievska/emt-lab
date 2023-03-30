package com.example.bookrental.repository;

import com.example.bookrental.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long>{
}
