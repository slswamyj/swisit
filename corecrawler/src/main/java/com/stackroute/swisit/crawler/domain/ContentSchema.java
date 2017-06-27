package com.stackroute.swisit.crawler.domain;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class ContentSchema {

	/*-------------private variables of bean class------------*/
	
	@JsonProperty("word")
	@NotNull
	private String word;

	@JsonProperty("intensity")
	@NotNull
	private String intensity;


	/*--------------- No args constructor-------------*/

	public ContentSchema() {
		super();
	}


	/*-------------- Constructor with fields ------------*/

	public ContentSchema(String word, String intensity) {
		super();
		this.word = word;
		this.intensity = intensity;
	}

	/*------------- Getters and setters for fields -----------*/

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
}
