package com.yh.controller;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yh.dto.AdminInfo;
import com.yh.service.AdminService;
import com.yh.util.ImageUtil;
import com.yh.util.ResponseUtil;

@Controller
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource(name="adminService")
	private AdminService adminService;
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping("/identify")
	public void identify(HttpServletRequest request , HttpServletResponse response){
		logger.info("enter into identify code...");
		request.getSession().removeAttribute("yzm");
		response.setContentType("image/jpeg");
		Object[] objects = ImageUtil.createImage();
		String yzm = (String) objects[0];
		BufferedImage image = (BufferedImage) objects[1];
		request.getSession().setAttribute("yzm", yzm);
		try {
			ImageIO.write(image, "jpeg", response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取验证码错误...");
		}
	}
	/**
	 * 登陆方法
	 */
	@RequestMapping("/login")
	public String login( HttpServletRequest request , HttpServletResponse response ){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("request.setCharacterEncoding...utf-8...失败...");
			e.printStackTrace();
		}
		String yzm = request.getParameter("yzm");
		//先校验验证码
		if ( yzm == "" || yzm == null ) {
			ResponseUtil.readerLoginMsg("验证码为空", response, "1");
			return null;
		}
		if( yzm.length() != 4 ){
			ResponseUtil.readerLoginMsg("验证码长度错误", response, "1");
			return null;
		}
		String yzmn = (String) request.getSession().getAttribute("yzm");
		if (yzmn == "" || yzmn == null ) {
			logger.error("后台验证码生成失败》》》》》》");
			return null;
		}
		if( !yzm.equalsIgnoreCase(yzmn)){
			ResponseUtil.readerLoginMsg("验证码错误", response, "1");
			return null;
		}
		//校验账户和密码
		String adminCode = request.getParameter("admin");
		if (adminCode == "" || adminCode == null ) {
			ResponseUtil.readerLoginMsg("账户为空", response, "1");
			return null;
		}
		if( adminCode.length() > 30 ){
			ResponseUtil.readerLoginMsg("账户长度大于30", response, "1");
			return null;
		}
		String password = request.getParameter("password");
		if (password == "" || password == null ) {
			ResponseUtil.readerLoginMsg("密码为空", response, "1");
			return null;
		}
		if( password.length() > 20 ){
			ResponseUtil.readerLoginMsg("密码长度大于20", response, "1");
			return null;
		}
		try {
			//根据用户名查询密码
			AdminInfo adminInfo = null;
			adminInfo = adminService.queryByAdminCode(adminCode);
			if( adminInfo == null ){
				ResponseUtil.readerLoginMsg("用户不存在", response, "1");
				return null;
			}
			if( adminInfo.getPassword() == "" || !adminInfo.getPassword().equals(password) ){
				ResponseUtil.readerLoginMsg("密码错误", response, "1");
			}
			request.getSession().removeAttribute("yzm");
			request.getSession().setAttribute("adminCode", adminCode);
			request.getSession().setAttribute("adminInfo", adminInfo);
			ResponseUtil.readerLoginMsg("登陆成功", response, "0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 跳转到主页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/index")
	public String index( HttpServletRequest request , HttpServletResponse response ){
		logger.info("Entry into index.jsp 》》》》》》》》》》》》》》");
		AdminInfo adminInfo = (AdminInfo) request.getSession().getAttribute("adminInfo");
		if( adminInfo == null ){
			return "login";
		}
		return "index";
	}
	/**
	 * 校验验证码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/validateYzm")
	public String validateYzm( HttpServletRequest request , HttpServletResponse response ){
		logger.info("Entry into validateYzm(校验验证码) 》》》》》》》》》》》》》》");
		
		String yzm = request.getParameter("yzm");
		if (yzm == "" ) {
			ResponseUtil.readerLoginMsg("验证码为空", response, "1");
			return null;
		}
		String yzmn = (String) request.getSession().getAttribute("yzm");
		if ( ! yzm.equalsIgnoreCase(yzmn) ) {
			ResponseUtil.readerLoginMsg("验证码错误", response, "1");
			return null;
		}
		ResponseUtil.readerLoginMsg("验证码正确", response, "0");
		
		return null;
	}
	
}






