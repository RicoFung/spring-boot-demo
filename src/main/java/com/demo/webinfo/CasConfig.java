package com.demo.webinfo;

import java.util.Arrays;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chok.cas.client.filter.CasAccessFilter;
import chok.cas.client.filter.CasLogoutFilter;
import chok.cas.client.filter.CasPasswordFilter;

//@Configuration
public class CasConfig
{
	@Bean
	public FilterRegistrationBean httpServletRequestWrapperFilter()
	{
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new HttpServletRequestWrapperFilter());
		filterRegBean.setName("CAS HttpServletRequest Wrapper Filter");
		filterRegBean.setUrlPatterns(Arrays.asList("/*"));
		filterRegBean.setOrder(1);
		return filterRegBean;
	}

	@Bean
	public FilterRegistrationBean authenticationFilter()
	{
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new AuthenticationFilter());
		filterRegBean.setUrlPatterns(Arrays.asList("/*"));
		filterRegBean.addInitParameter("casServerLoginUrl", "https://localhost:18443/cas/login");
		filterRegBean.addInitParameter("serverName", "http://localhost:9090/client/query");
		filterRegBean.setOrder(2);
		return filterRegBean;
	}

	@Bean
	public FilterRegistrationBean cas30ProxyReceivingTicketValidationFilter()
	{
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new Cas30ProxyReceivingTicketValidationFilter());
		filterRegBean.setUrlPatterns(Arrays.asList("/*"));
		filterRegBean.addInitParameter("casServerUrlPrefix", "https://localhost:18443/cas");
		filterRegBean.addInitParameter("serverName", "http://localhost:9090/client/query");
		filterRegBean.setOrder(3);
		return filterRegBean;
	}
	
	@Bean
	public FilterRegistrationBean singleSignOutFilter()
	{
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new SingleSignOutFilter());
		filterRegBean.setUrlPatterns(Arrays.asList("/*"));
		filterRegBean.addInitParameter("casServerUrlPrefix", "https://localhost:18443/cas");
		filterRegBean.setOrder(4);
		return filterRegBean;
	}
	
	@Bean
	public FilterRegistrationBean casLogoutFilter()
	{
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new CasLogoutFilter());
		filterRegBean.setUrlPatterns(Arrays.asList("/cas/logout.action"));
		filterRegBean.addInitParameter("logoutURL", "https://localhost:18443/cas/logout.action?service=http://www.baidu.com");
		filterRegBean.setOrder(5);
		return filterRegBean;
	}
	
	@Bean
	public FilterRegistrationBean casPasswordFilter()
	{
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new CasPasswordFilter());
		filterRegBean.setUrlPatterns(Arrays.asList("/cas/password.action"));
		filterRegBean.addInitParameter("passwordURL", "http://localhost:8585/cps/password.action");
		filterRegBean.setOrder(6);
		return filterRegBean;
	}
	
	@Bean
	public FilterRegistrationBean casAccessFilter()
	{
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new CasAccessFilter());
		filterRegBean.setUrlPatterns(Arrays.asList("/client/*"));
		filterRegBean.addInitParameter("apiURL", "http://localhost:8585/api");
		filterRegBean.addInitParameter("ignoreURL", "/client/query2,/client/addDone");
		filterRegBean.addInitParameter("appId", "3");
		filterRegBean.addInitParameter("isNeedChkAct", "1");
		filterRegBean.setOrder(7);
		return filterRegBean;
	}

	@Bean
	public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> registerCustomListener()
	{
		return new ServletListenerRegistrationBean<SingleSignOutHttpSessionListener>(new SingleSignOutHttpSessionListener());
	}
}
