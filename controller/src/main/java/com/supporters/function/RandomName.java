package com.supporters.function;

import java.util.UUID;

public class RandomName {

	public static String getRandomName(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
	
	public static String getRandomPw() {
	        String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다. 
	        uuid = uuid.substring(0, 10); //uuid를 앞에서부터 10자리 잘라줌. 
	   return uuid;
	}
}
