package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	@Query("select country from Country country where country.name Like %?1% order by 2")
	public List<Country> findBySubString(String s);
	
	@Query("select country from Country country where country.name Like ?1%")
	public List<Country> findByAlphabet(String s);
	
	
}