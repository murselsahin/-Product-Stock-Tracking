package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.session.Session;

public class NavigationFilter implements Filter {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
		HttpServletRequest req  = (HttpServletRequest)request;
		HttpServletResponse hsr = (HttpServletResponse)response;
		
		if(req.getRequestURI().endsWith("admin_giris.jsp") || req.getRequestURI().endsWith("kullanici_ekle.jsp")
			 || req.getRequestURI().endsWith("urun_ekle.jsp")
			|| req.getRequestURI().endsWith("urun_guncelle.jsp")
			|| req.getRequestURI().endsWith("urun_tarihi.jsp"))
		{
			if(!Session.admin_giris)
				hsr.sendRedirect("anasayfa.jsp");
			
		}
		if(req.getRequestURI().endsWith("normal_giris.jsp"))
		{
			if(!Session.normal_giris)
				hsr.sendRedirect("anasayfa.jsp");
		}
		if(req.getRequestURI().endsWith("fatura_goruntule.jsp") || req.getRequestURI().endsWith("satis_yap.jsp")
				|| req.getRequestURI().endsWith("musteri_ekle.jsp"))
		{
			if(!Session.normal_giris && !Session.admin_giris)
				hsr.sendRedirect("anasayfa.jsp");
		}
		
		filter.doFilter(request, response);
		
	}

	
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
