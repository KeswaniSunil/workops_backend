package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Component;

public interface ComponentService {

	List<Component> getAllComponents();
	Optional<Component> getComponentById(String componentId)throws Exception;
	Component createComponent(Component component) throws Exception;
	Component updateComponent(Component component) ;
	void deleteComponentById(String componentid) throws Exception;
}
