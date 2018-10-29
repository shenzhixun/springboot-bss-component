package com.ejet.bss.userrights;


import java.util.Date;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: Test
 * Author:   ShenYijie
 * CreateDate:     2018-10-26 14:44
 * Description:
 * History:
 * Version: 1.0
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String startTimeStr = "20180102";
        String endTimeStr = "20181109";
        // java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
        // java.util.Date currentDay = new java.util.Date();
        // currentDay = formatter.parse(startTimeStr);
        // java.util.Calendar tempCal = formatter.getCalendar();
        // tempCal.add(java.util.Calendar.DATE, -1);
        // String beforeTime = formatter.format(tempCal.getTime());

        //var startTimeStr = parent_job.getVariable("startTime");
        //var endTimeStr = parent_job.getVariable("endTime");


        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
        Date nextDay = formatter.parse(startTimeStr); // trans to Date
        java.util.Calendar tempCal = formatter.getCalendar();
        tempCal.add(java.util.Calendar.DATE, -2); //next day

        String currentTime = formatter.format(tempCal.getTime());

        // parent_job.setVariable("currentTime", formatter.parse(currentTime));
        // parent_job.setVariable("endTime", formatter.parse(endTimeStr));
        // parent_job.setVariable("startTime", formatter.parse(startTimeStr));
        //
        // true

        System.out.println(currentTime);
        System.out.println(formatter.parse(currentTime));
    }

}
