package com.da.provideserver.utils;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 全局handler前日期统一处理
 */
@Component
public class DateConverUtil implements Converter<String, Date> {

    private static final List<String> formarts = new ArrayList<>(4);
    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }

  @Override
    public  Date convert(String source) {
        System.out.println("source: "+source);
        String value = source.replace("\"","").trim();
        if ("".equals(value)) {
            return null;
        }
        if(value.matches("^\\d{4}-\\d{1,2}$")){
            return parseDate(value, formarts.get(0));
        }else if(value.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
            return parseDate(value, formarts.get(1));
        }else if(value.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
            return parseDate(value, formarts.get(2));
        }else if(value.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
            return parseDate(value, formarts.get(3));
        }else {
            throw new IllegalArgumentException("Invalid boolean value '" + value + "'");
        }
    }

    /**
     * 格式化日期
     * @param dateStr String 字符型日期
     * @param format String 格式
     * @return Date 日期
     */
    public  static Date parseDate(String dateStr, String format) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {

        }
        return date;
    }

}