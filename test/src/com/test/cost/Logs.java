package com.test.cost;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Logs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -895890199950848465L;

	private static Log log;
	
	static{
		log = LogFactory.getLog(Logs.class);
	}
	
	public static Log getLog(){
		return log;
	}
	
}
