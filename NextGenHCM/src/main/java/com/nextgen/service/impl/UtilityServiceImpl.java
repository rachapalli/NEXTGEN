package com.nextgen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextgen.dao.IBaseDAO;
import com.nextgen.dto.CitiesDTO;
import com.nextgen.dto.CountriesDTO;
import com.nextgen.dto.StatesDTO;
import com.nextgen.model.City;
import com.nextgen.model.Country;
import com.nextgen.model.State;
import com.nextgen.service.UtilityService;

@Service
public class UtilityServiceImpl implements UtilityService {

	@Autowired
	private IBaseDAO<Country> countryDao;
	@Autowired
	private IBaseDAO<State> statesDao;
	@Autowired
	private IBaseDAO<City> citiesDao;

	@Override
	@Transactional
	public List<CountriesDTO> countries() {
		final List<Country> countries = countryDao.findAll(Country.class);
		final List<CountriesDTO> countriesDTOs = new ArrayList<>();
		countries.forEach(country -> {
			final CountriesDTO dto = new CountriesDTO();
			dto.setCountryCode(country.getCountry_code());
			dto.setCountryName(country.getCountry_name());
			dto.setPhoneCode(country.getPhone_code());
			countriesDTOs.add(dto);
		});

		return countriesDTOs;
	}

	@Override
	@Transactional
	public List<StatesDTO> states(final StatesDTO statesDTO) {
		final List<State> states = statesDao.findByColumn(State.class, "country.id", statesDTO.getContryId());
		final List<StatesDTO> statesDTOs = new ArrayList<>();
		states.forEach(state -> {
			final StatesDTO dto = new StatesDTO();
			dto.setId(state.getId());
			dto.setContryId(statesDTO.getContryId());
			dto.setName(state.getName());
			statesDTOs.add(dto);
		});

		return statesDTOs;
	}

	@Override
	@Transactional
	public List<CitiesDTO> cities(final CitiesDTO citiesDTO) {
		final List<City> cities = citiesDao.findByColumn(City.class, "state.id", citiesDTO.getStateId());
		final List<CitiesDTO> citiesDTOs = new ArrayList<>();
		cities.forEach(city -> {
			final CitiesDTO cityDTO = new CitiesDTO();
			cityDTO.setName(city.getName());
			cityDTO.setStateId(citiesDTO.getStateId());
			cityDTO.setId(city.getId());
			citiesDTOs.add(cityDTO);
		});

		return citiesDTOs;
	}

}
