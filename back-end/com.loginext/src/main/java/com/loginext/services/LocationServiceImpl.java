package com.loginext.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginext.dto.LocationDto;
import com.loginext.models.Location;
import com.loginext.repositories.LocationRepository;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public void saveLocation(LocationDto locationDto) {
		
		Location location = new Location();
		location.setLatitude(locationDto.getLatitude());
		location.setLongitude(locationDto.getLongitude());
		locationRepository.save(location);
	}

	@Override
	public List<Location> getLocations() {
		
		List<Location> locations = (List<Location>) locationRepository.findAll();
		return locations;
	}

	
}
