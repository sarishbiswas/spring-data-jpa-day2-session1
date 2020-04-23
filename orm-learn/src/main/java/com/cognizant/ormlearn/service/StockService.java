package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	StockRepository repository;
	
	@Transactional
	public List<Stock> getAllstocks() {
		List<Stock> stocks = repository.findAll();
		return stocks;
	}
	@Transactional
	public List<Stock> getStockBetweenDate(){
		return repository.findStockBetweenDate();
	}
	
	@Transactional
	public List<Stock> getStockGreaterPrice(){
		return repository.findStockGreaterPrice();
	}
	@Transactional
	public List<Stock> getStockHighestVolume(){
		return repository.findStockHighestVolume();
	}
	@Transactional
	public List<Stock> getLowestNetflix(){
		return repository.findLowestNetflix();
	}
}
