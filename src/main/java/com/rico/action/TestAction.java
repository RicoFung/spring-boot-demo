package com.rico.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rico.entity.Category;
import com.rico.service.ClientCategoryService;

import chok.devwork.BaseController;

@Controller
@RequestMapping("/client")
public class TestAction  extends BaseController<Category>
{
	@Autowired
	private ClientCategoryService service;

	@RequestMapping("/query")
	public void query()
	{
		List list = service.query();
		printJson(list);
	}
}
