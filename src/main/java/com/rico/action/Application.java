package com.rico.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rico.entity.Category;
import com.rico.service.ClientCategoryService;

import chok.devwork.BaseController;

@SpringBootApplication
@ComponentScan("com.rico")
@Controller
@RequestMapping("/client")
public class Application  extends BaseController<Category>
{
	@Autowired
	private ClientCategoryService service;

	@RequestMapping("/query")
	public void query()
	{
		List list = service.query();
		printJson(list);
	}

    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class, args);
    }
}
