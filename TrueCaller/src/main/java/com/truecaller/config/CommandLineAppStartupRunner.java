package com.truecaller.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.truecaller.model.ContactJsonModel;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner{
    
	@Autowired
	private ContactJsonModelData data; 
	
	@Override
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<ContactJsonModel>> typeReference = new TypeReference<List<ContactJsonModel>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/static/contact.json");
		try {
			List<ContactJsonModel> jsonData = mapper.readValue(inputStream,typeReference);
			System.out.println("Users Saved!");
			data.setContactJsonModelList(jsonData);
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
		}
	}

}
