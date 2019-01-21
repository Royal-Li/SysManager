package com.system.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.system.entity.SysUser;

/**
 * shiro g工具类
 * @class ShiroUtils
 * @author Jason
 * @description
 * @date Jan 10, 2019 6:00:48 PM
 */
public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static SysUser getUserEntity() {
		return (SysUser)SecurityUtils.getSubject().getPrincipal();
	}

	public static Integer getUserId() {
		return getUserEntity().getUserId();
	}
	public static String getUserName() {
		return getUserEntity().getUserName();
	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
	
	public static String getKaptcha(String key) {
		String kaptcha = getSessionAttribute(key).toString();
		getSession().removeAttribute(key);
		return kaptcha;
	}

}
