package com.tongxue.footballguessing.exception;

public class CommErrorCode extends ErrorCode {
	//DB
	public static  ErrorCode DB_SHOULD_ONE_BUT_FOUND_MORE = new CommErrorCode("DB_SHOULD_ONE_BUT_FOUND_MORE","应该是一个，但是查出来多个");
	//SYS
	//BIZ

	CommErrorCode(String should_one_but_found_more, String s) {
	}
}
