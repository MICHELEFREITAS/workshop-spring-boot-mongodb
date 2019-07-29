package com.michelefreitas.workshopmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
	//método para converter a data. Se ocorrer falha na conversão do String textDate , vai usar o valor Date default...
	public static Date convertDate(String textDate, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defaultValue;
		}
		
		
	}

}
