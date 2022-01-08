package com.in28minutes.pastor.rest.webservices.filtering;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//Dynamic filtering. Return only "name".
	@GetMapping("/filtering")
	public MappingJacksonValue filter() {		 
		BeanToFilter beanToFilter = new BeanToFilter("Patryk", 12, new Date());
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanToFilterFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(beanToFilter);		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filterList() {
		List<BeanToFilter> list = Arrays.asList(new BeanToFilter("Patryk", 32, new Date()), 
				new BeanToFilter("Karolina", 30, new Date()));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value","date");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanToFilterFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);		
		mapping.setFilters(filters);
		
		return mapping;
	}

}
