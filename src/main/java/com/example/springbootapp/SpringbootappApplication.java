package com.example.springbootapp;

import com.example.springbootapp.enumeration.SORT_TYPE;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringbootappApplication {

	@Bean
	public Map<SORT_TYPE, Sort> getSortMap() {
		Map<SORT_TYPE, Sort> sortMap = new HashMap<>();
		sortMap.put(SORT_TYPE.NAME_ASC, new Sort(Sort.Direction.ASC, "name"));
		sortMap.put(SORT_TYPE.NAME_DESC, new Sort(Sort.Direction.DESC, "name"));
		sortMap.put(SORT_TYPE.YEAR_ASC, new Sort(Sort.Direction.ASC, "year"));
		sortMap.put(SORT_TYPE.YEAR_DESC, new Sort(Sort.Direction.DESC, "year"));
		sortMap.put(SORT_TYPE.RATING_ASC, new Sort(Sort.Direction.ASC, "rating"));
		sortMap.put(SORT_TYPE.RATING_DESC, new Sort(Sort.Direction.DESC, "rating"));
		sortMap.put(SORT_TYPE.LASTNAME_ASC, new Sort(Sort.Direction.ASC, "lastName"));
		sortMap.put(SORT_TYPE.LASTNAME_DESC, new Sort(Sort.Direction.DESC, "lastName"));
		return sortMap;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
	}

}

