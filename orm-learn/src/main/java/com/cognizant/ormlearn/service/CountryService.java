package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	@Autowired
	CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries() {
		List<Country> countries = countryRepository.findAll();
		return countries;
	}
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country Not Found");
		}
		Country country = result.get();
		return country;
	}
	
	@Transactional
	public Country updateCountry(String countryCode,String name) throws CountryNotFoundException{
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country Not Found");
		}
		Country country = result.get();
		country.setName(name);
		countryRepository.save(country);
		return country;
	}
	
	@Transactional
	public void deleteCountry(String countryCode){
		countryRepository.deleteById(countryCode);
	}
	
	@Transactional
	public List<Country> findBySubString(String s){
		return countryRepository.findBySubString(s);
	}
	@Transactional
	public List<Country> findByAlphabetService(String s){
		return countryRepository.findByAlphabet(s);
	}
}
