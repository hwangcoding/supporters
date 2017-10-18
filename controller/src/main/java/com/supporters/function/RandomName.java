package com.supporters.function;

import java.util.UUID;

public class RandomName {

	public static String getRandomName(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
