package com.test.service2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class ResourceCaller {
	
	@Autowired
    private EurekaClient eurekaClient;
	
	
    private RestTemplate restTemplate=new RestTemplate() ;
	
	
	@GetMapping("/rest/service")
	public String display() {
		Application application = eurekaClient.getApplication("config-client");
	       InstanceInfo instanceInfo = application.getInstances().get(0);
	       String url = "http://"+instanceInfo.getIPAddr()+ ":"+instanceInfo.getPort()+"/"+"message";
		return restTemplate.getForObject(url, String.class);
	}
}
