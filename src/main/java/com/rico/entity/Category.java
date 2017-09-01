package com.rico.entity;

public class Category 
{
	private Long id;
	private String name;
	private String sort;

	public void setSort(String sort)
	{
		this.sort = sort;
	}
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
}
