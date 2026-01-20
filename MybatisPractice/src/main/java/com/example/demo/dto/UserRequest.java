package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
	
	// バリデーションを設定していない。

	/**
	 * 名前
	 */
	@NotEmpty(message = "名前を入力してください")
	private String name;

	/**
	 * 住所
	 */
	@NotEmpty(message = "住所を入力してください")
	private String address;

	/**
	 * 電話番号
	 */
	@NotEmpty(message = "電話番号を入力してください")
	private String phone;
}
