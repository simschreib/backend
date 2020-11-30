package com.wdagency.atipykhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wdagency.atipykhouse.model.Type;
import com.wdagency.atipykhouse.service.TypeService;

@CrossOrigin
@RestController
@RequestMapping("type")
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	@GetMapping(value="allTypes")
	public List<Type> getTypes() {
		return typeService.getAll();
	}

	@GetMapping(value="{name}")
	public Type getType(@PathVariable String name) {
		return typeService.getType(name);
	}
}
