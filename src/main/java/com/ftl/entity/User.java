package com.ftl.entity;
 
import java.io.Serializable;

import lombok.Data;
/**
 * User实体类
 *
 */
@Data
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
    private String passWord;
    private String age;
    private String addr;
    private String realName;
    
}