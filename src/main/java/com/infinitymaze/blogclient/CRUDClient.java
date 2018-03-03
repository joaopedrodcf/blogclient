package com.infinitymaze.blogclient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class CRUDClient<T> {

	public String restServiceUrl;

	private Class<T> typeParameterClass;

	private Class<T[]> typeParameterArrayClass;
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	private static final Logger logger = LogManager.getLogger(CRUDClient.class);
	
	public CRUDClient(String restServiceUrl, Class<T> typeParameterClass, Class<T[]> typeParameterArrayClass){
		this.restServiceUrl=restServiceUrl;
		this.typeParameterClass = typeParameterClass;
		this.typeParameterArrayClass = typeParameterArrayClass;
	}

	public void getAll() {
		ResponseEntity<T[]> response = restTemplate.getForEntity(restServiceUrl, typeParameterArrayClass);

		logger.info(response.getStatusCodeValue());
		for (T t : response.getBody()) {
			logger.info(t);
		}
	}

	public void deleteAll() {
		restTemplate.delete(restServiceUrl);
	}

	public void delete(long id) {
		try {
			restTemplate.delete(restServiceUrl + id);
		} catch (final HttpClientErrorException e) {
			logger.info(e.getStatusCode());
		}
	}

	public void get(long id) {
		ResponseEntity<T> response = restTemplate.getForEntity(restServiceUrl + id, typeParameterClass);
		logger.info(response.getBody());
		logger.info(response.getStatusCodeValue());

	}

	public void create(T t) {
		ResponseEntity<Void> response = restTemplate.postForEntity(restServiceUrl, t, Void.class);
		logger.info(response.getStatusCodeValue());
	}

	public void update(long id, T t) {
		try {
			restTemplate.put(restServiceUrl + id, t);
		} catch (final HttpClientErrorException e) {
			logger.info(e.getStatusCode());
		}
	}
}
