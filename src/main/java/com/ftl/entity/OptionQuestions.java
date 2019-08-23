
package com.ftl.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 选择题试题类
 */
@Data
public class OptionQuestions implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9200292678301275536L;
	private String content;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

}