package com.yh.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yh.dto.AdminInfo;
import com.yh.service.AdminService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource(name="adminService")
	private AdminService adminService;
	
	@RequestMapping("/queryRoleList.do")
	public ModelAndView queryRoleList(HttpServletRequest request, HttpServletResponse response) {
		try {
			AdminInfo adminInfo = (AdminInfo) request.getSession().getAttribute("adminInfo");
			if (adminInfo == null) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("role/roleList");
	}
	
	
}
