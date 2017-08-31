package com.rico.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rico.service.ClientCategoryService;
import com.rico.service.UserService;

@RestController
@RequestMapping("/client")
public class TestAction
{
	@Autowired
	private ClientCategoryService service;
	@Autowired
	private UserService userService;

	@RequestMapping("/query")
	public List query()
	{
		List list = service.query(null);
		return list;
	}
	
	@RequestMapping("/queryUser")
	public List queryUser()
	{
		List list = userService.query(null);
		return list;
	}
}
