package com.tongxue.footballguessing.exception;

public class AssertUtil {
	public static void isNotEmpty(Object... params) throws Exception {
		for (Object param : params) {
			if (param == null) {
				throw  new Exception("参数为空！");
			}

		}
	}
}
