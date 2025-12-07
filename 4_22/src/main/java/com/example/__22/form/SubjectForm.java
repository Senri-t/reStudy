package com.example.__22.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class SubjectForm {
	 /**
	  */
	 private Integer id;
	  /**
	  */
	 @NotEmpty(message = "タイトルを入力してください")
	 @Size(max = 50, message = "タイトルは100文字以内で入力してください")
	 private String title;
	 private String name;
}
