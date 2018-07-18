package com.kool.test;

import org.junit.Test;

import com.alibaba.druid.filter.config.ConfigTools;

public class DaoTest {
	@Test
	public void test() throws Exception {
		String pwd = ConfigTools.decrypt("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAM2hlD4mw8Gu7cwa+54YWqbUaXJVZBzwF5GwBUKRJouQplcKkOvE7xvV4HfTpNif8tuX3MLWISPiDT6PATdFCPECAwEAAQ==", "GleXWDh0LacuaVEicnqJeZP74UN0iypL9EpJNVguL3/pZEeSsIGu6zN0b6VY4dSWsNeWzUJKTF3ZzFFu796H6w==");
		System.out.println(pwd);
	}
}
