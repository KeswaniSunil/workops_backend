package com.workops.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workops.dao.ComponentDao;
import com.workops.dao.ProjectDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Component;

@Service
@Transactional
public class ComponentServiceImpl implements ComponentService {

	@Autowired
	ComponentDao componentdao;
	
	@Autowired
	ProjectDao projectdao;
	@Override
	public List<Component> getAllComponents() {
		return componentdao.findAll();
	}

	@Override
	public Optional<Component> getComponentById(String componentId) throws Exception {
	
		try
		{
		Optional<Component> com=componentdao.findById(componentId);
		if(!com.isPresent())
		{
			throw  new ErrorDetails("Not Found Component With Given Id");
		}
		return com;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Component createComponent(Component component) throws Exception {
		try
		{
		
//			ObjectMapper mapper = new ObjectMapper();
//		      //Converting the Object to JSONString
//		      String jsonString = mapper.writeValueAsString(component);
//		      System.out.println(jsonString);
//			return null;
		Optional<Component> com=componentdao.findByName(component.getName());
		if(!com.isPresent())
		{
			component.setId(UUID.randomUUID().toString().substring(0,32));
			return componentdao.save(component);
		}
		throw new ErrorDetails("Component Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage()+" =?"+component.getDescription());
		}
	}

	@Override
	public Component updateComponent(Component component) {
		return componentdao.save(component);
	}

	@Override
	public void deleteComponentById(String componentid) throws Exception {
		try
		{
		Optional<Component> com=componentdao.findById(componentid);
		if(!com.isPresent())
		{

			throw new ErrorDetails("No Project Exists With this Id");
		}
		componentdao.deleteById(componentid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
		
	}

	
}
