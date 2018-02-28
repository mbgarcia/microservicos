package com.thoughtmechanix.licenses.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.services.LicenseService;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
    private static final Logger logger = LoggerFactory.getLogger(LicenseServiceController.class);
	
    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<License> getLicenses( @PathVariable("organizationId") String organizationId) {
    	logger.debug("Entering the license-service-controller:getLicenses:organizationId  ");
        return licenseService.getLicensesByOrg(organizationId);
    }
    
    @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
    public License getLicenses( @PathVariable("organizationId") String organizationId,
                                @PathVariable("licenseId") String licenseId) {
    	logger.debug("Entering the license-service-controller:getLicenses:organizationId:licenseId  ");

        return licenseService.getLicense(organizationId, licenseId);

    }

    @RequestMapping(value="/{licenseId}/{clientType}",method = RequestMethod.GET)
    public License getLicensesWithClient( @PathVariable("organizationId") String organizationId,
                                          @PathVariable("licenseId") String licenseId,
                                          @PathVariable("clientType") String clientType) {
    	logger.debug("Entering the license-service-controller:getLicensesWithClient  ");

        return licenseService.getLicense(organizationId,licenseId, clientType);
    }
    
    @RequestMapping(value="{licenseId}",method = RequestMethod.PUT)
    public String updateLicenses( @PathVariable("licenseId") String licenseId) {
        return String.format("This is the put");
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.POST)
    public String saveLicenses( @PathVariable("licenseId") String licenseId) {
        return String.format("This is the post");
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteLicenses( @PathVariable("licenseId") String licenseId) {
        return String.format("This is the Delete");
    }
}
