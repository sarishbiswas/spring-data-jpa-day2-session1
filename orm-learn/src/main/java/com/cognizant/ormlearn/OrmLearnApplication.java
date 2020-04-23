package com.cognizant.ormlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	// private static CountryService countryService;
	private static StockService stockService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		stockService = context.getBean(StockService.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		// countryService = context.getBean(CountryService.class);
		// LOGGER.info("Inside main");
		/*
		 * testAddCountry(new Country("IN", "INDIA")); System.out.println("GetAll");
		 * testGetAllCountries(); System.out.println("Country with Id IN");
		 * testGetCountryById("IN"); System.out.println("Update Country with Id IN");
		 * testUpdateCountry("IN","Sarish"); testGetCountryById("IN");
		 * System.out.println("Delete Country with Id IN"); testDeleteCountry("IN");
		 * testGetCountryById("IN");
		 */
		// testFindBySubString("ou");
		// testFindByAlphabetService("Z");
		// System.out.println(stockService.getAllstocks());
		// System.out.println(stockService.getStockBetweenDate());
		// System.out.println(stockService.getStockGreaterPrice());
		// System.out.println(stockService.getStockHighestVolume());
		//System.out.println(stockService.getLowestNetflix());
		//testGetEmployee();
		//testAddEmployee();
		//testUpdateEmployee();
		//testGetDepartment();
		testAddSkillToEmployee();
		LOGGER.info("Inside main");

	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}
	
	private static void testAddEmployee() {
		Employee employee = new Employee();
		employee.setName("Anindita");
		employee.setDateOfBirth(new Date(23/04/2020));
		employee.setPermanent(true);
		employee.setSalary(450000);
		Department department = departmentService.get(1);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
	}
	
	private static void testUpdateEmployee() {
		Employee employee = employeeService.get(1);
		Department department = departmentService.get(1);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		
	}

	public static void testGetDepartment() {
		Department department = departmentService.get(1);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("DepartmentGetEmployeeList:{}", department.getEmployeeList());
	}

	public static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(3);
		Skill skill = skillService.get(1);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employeeService.save(employee);
		
	}
	
	/*
	 * private static void testGetAllCountries() { LOGGER.info("Start");
	 * List<Country> countries = countryService.getAllCountries();
	 * LOGGER.debug("countries={}", countries); LOGGER.info("End");
	 * 
	 * }
	 * 
	 * private static void testAddCountry(Country country) { LOGGER.info("Start");
	 * countryService.addCountry(country); // LOGGER.debug("countries={}",
	 * countries); LOGGER.info("End"); }
	 * 
	 * private static void testGetCountryById(String countryCode) throws
	 * CountryNotFoundException { LOGGER.info("Start"); Country country =
	 * countryService.findCountryByCode(countryCode); LOGGER.debug("Country:{}",
	 * country); LOGGER.info("End"); }
	 * 
	 * private static void testUpdateCountry(String countryCode,String name) throws
	 * CountryNotFoundException { LOGGER.info("Start"); Country country =
	 * countryService.updateCountry(countryCode, name); LOGGER.debug("Country:{}",
	 * country); LOGGER.info("End"); }
	 * 
	 * private static void testDeleteCountry(String countryCode){
	 * LOGGER.info("Start"); countryService.deleteCountry(countryCode);
	 * LOGGER.info("End"); }
	 * 
	 * private static void testFindBySubString(String s) { LOGGER.info("Start");
	 * System.out.println(countryService.findBySubString(s)); LOGGER.info("Stop"); }
	 * 
	 * private static void testFindByAlphabetService(String s) {
	 * LOGGER.info("Start");
	 * System.out.println(countryService.findByAlphabetService(s));
	 * LOGGER.info("Stop"); }
	 */

}