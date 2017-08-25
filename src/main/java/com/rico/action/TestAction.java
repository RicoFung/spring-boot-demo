package com.rico.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rico.entity.Category;
import com.rico.service.ClientCategoryService;

import chok.devwork.BaseController;

@RestController
@RequestMapping("/client")
public class TestAction  extends BaseController<Category>
{
	@Autowired
	private ClientCategoryService service;

	@RequestMapping("/query")
	public List query()
	{
		List list = service.query();
		return list;
	}
}
