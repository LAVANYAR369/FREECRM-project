package com.crm.FreeCRMTest.JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public String getSystemDate()
	{
		Date dobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dobj);
		return date;
	}
	public String particularDate(int days)
	{ Date d = new Date();
	 SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd"); 
	 sim.format(d);
		//SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String pdate=sim.format(cal.getTime());
		return pdate;
		
	}
	public int getRandomnum()
	{
		Random r=new Random();
		int randomnum = r.nextInt(1000);
		return randomnum;
	}


}
