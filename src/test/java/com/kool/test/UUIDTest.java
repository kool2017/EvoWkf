/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午3:08:56
 * @AUTHOR LUYU
 */
package com.kool.test;

import com.kool.core.util.StringUtils;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午3:08:56
 *
 */
public class UUIDTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(StringUtils.getUUID());
		}
	}
}
