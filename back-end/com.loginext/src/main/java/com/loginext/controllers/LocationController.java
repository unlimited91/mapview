package com.loginext.controllers;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loginext.dto.LocationDto;
import com.loginext.models.Location;
import com.loginext.services.LocationService;
import com.loginext.utils.ResponseWrapper;


@RestController
@CrossOrigin
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value="/getLocations", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseWrapper<List<Location>> getLocations() {
		
		List<Location> locations = locationService.getLocations();
		ResponseWrapper<List<Location>> responseWrapper = new ResponseWrapper<List<Location>>();
		responseWrapper.setCode(200);
		responseWrapper.setStatus("SUCCESS");
		responseWrapper.setData(locations);
		return responseWrapper;
		
		
	}
	
	@RequestMapping(value="/postLocation", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,String> insertLocation(@RequestBody @NotNull LocationDto locationDto) {
		
		Map<String,String> successMessage = new HashMap<String,String> ();
		Map<String,String> errorMessage = new HashMap<String,String> ();
		successMessage.put("code", "200");
		successMessage.put("status", "SUCCESS");
		errorMessage.put("code", "400");
		errorMessage.put("status", "SUCCESS");
		if(locationDto == null){
			return errorMessage;
		}
		else if(locationDto.getLatitude().isNaN() || locationDto.getLongitude().isNaN() || locationDto.getLatitude() == 0.0D || locationDto.getLongitude() == 0.0D){
			return errorMessage;
		}
		else{
			locationService.saveLocation(locationDto);
			return successMessage;
		}
		
		
	}
	
}


