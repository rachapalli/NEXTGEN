package com.nextgen.service;

import java.util.List;

import com.nextgen.dto.CitiesDTO;
import com.nextgen.dto.CountriesDTO;
import com.nextgen.dto.StatesDTO;

public interface UtilityService {

	public List<CountriesDTO> countries();

	public List<StatesDTO> states(final StatesDTO statesDTO);

	public List<CitiesDTO> cities(final CitiesDTO citiesDTO);
}
