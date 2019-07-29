package com.michelefreitas.workshopmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	//método estático para não precisar instanciar obj URL
	public static String decodeParam(String text) {
		//retorna string decodificado
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			//ou retorna lista vazia caso problema
			return "";
		}
	}

}
