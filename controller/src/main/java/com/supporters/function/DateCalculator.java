package com.supporters.function;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculator {


	//오늘 날짜 가져오기
	public static String getTodayDate() {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
		
	}
	
	//오늘부터 몇 일 전 날짜 가져오기
	public static String getDateAgo ( int iDay ){
		
		Calendar temp=Calendar.getInstance ( );
		StringBuffer sbDate=new StringBuffer ( );
		 
		temp.add ( Calendar.DAY_OF_MONTH, iDay );
		 
		 
		int nYear = temp.get ( Calendar.YEAR );
		int nMonth = temp.get ( Calendar.MONTH ) + 1;
		int nDay = temp.get ( Calendar.DAY_OF_MONTH );
		 
		
		
		/*나중에수정할것
		1. 4 일 날 - 1일날 어쩌고 저쩌고 하면 판단해야함*/
		
		
		
		 /*문자열에 월 , 일 이 10 보다 작으면 0 추가*/
		sbDate.append ( nYear );
		if ( nMonth < 10 ) {
		sbDate.append ( "-0" );
		sbDate.append ( nMonth );
		}else {
		sbDate.append ( "-"+nMonth );
		}
		if ( nDay < 10 ) {
		sbDate.append ( "-0" );
		sbDate.append ( nDay );
		}else {
		sbDate.append ( "-"+nDay );
		}
		 
		return sbDate.toString ( );
	}

	
}
