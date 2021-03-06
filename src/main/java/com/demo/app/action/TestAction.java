package com.demo.app.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.entity.Category;
import com.demo.app.service.ClientCategoryService;
import com.demo.app.service.UserService;

import chok.devwork.BaseController;

@RestController
@RequestMapping("/client")
public class TestAction extends BaseController<Category>
{
	@Autowired
	private ClientCategoryService service;
	@Autowired
	private UserService userService;

	@RequestMapping("/query")
	public List query()
	{
		Map m = req.getParameterValueMap(false, true);
		List list = service.query(m);
		return list;
	}
	
	@RequestMapping("/query2")
	public List query2()
	{
		Map m = req.getParameterValueMap(false, true);
		List list = userService.query(m);
		return list;
	}
	
	@RequestMapping("/addDone")
	public void addDone()
	{
		service.addDone();
	}
}
