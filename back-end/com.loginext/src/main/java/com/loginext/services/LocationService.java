package com.loginext.services;

import java.util.List;

import com.loginext.dto.LocationDto;
import com.loginext.models.Location;

public interface LocationService {

	public void saveLocation(LocationDto locationDto);
	public List<Location> getLocations();
	
}
