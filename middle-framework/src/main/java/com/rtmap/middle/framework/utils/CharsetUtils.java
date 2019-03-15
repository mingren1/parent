/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

/*
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.rtmap.middle.framework.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CharsetUtils
 *
 * @author Muarine<maoyun       @       rtmap.com>
 * @date 2016 16/7/25 23:25
 * @since 0.1
 */
public class CharsetUtils extends StringUtils {

    /**
     * 检测字符串数组是否为空
     *
     * @return boolean
     */
    public static boolean isNotBlank(String... strs) {
        boolean b = true;

        for (int i = 0; i < strs.length; i++) {
            if (isBlank(strs[i])) {
                b = false;
                break;
            }
        }
        return b;
    }

    /**
     * 验证图片类型
     *
     * @param fileName
     * @return
     */
    public static boolean validateImgFileType(String fileName) {
        boolean flag = false;
        if ((null != fileName) && (!"".equals(fileName))) {
            int index = fileName.lastIndexOf(".");
            if (index > 0) {
                String type = fileName.substring(index + 1);
                if ("jpg".equalsIgnoreCase(type) ||
                        "jpeg".equalsIgnoreCase(type) ||
                        "png".equalsIgnoreCase(type) ||
                        "gif".equalsIgnoreCase(type)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 生成UUID
     * <pre>无中划线：af9b6ac1593b483db37688471edfda14</pre>
     *
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * <pre>
     *  url 进行 encoder 转码
     * </pre>
     * 默认字符集：UTF-8
     */
    public static String encode(String url) {
        String tmp = url;
        try {
            if (!StringUtils.isBlank(url)) {
                tmp = URLEncoder.encode(tmp, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    /**
     * <pre>
     *  url 进行 encoder 解码
     * </pre>
     * 默认字符集：UTF-8
     */
    public static String decode(String url) {
        String tmp = url;
        try {
            tmp = URLDecoder.decode(tmp, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    /**
     * 生成任务编号(两位随机 + 从2000-01-01 00:00:00 到现在的秒数+微秒+用户ID%1000)，长度=2位 + 10位 + 3位 + 3位 = 18位 1000个用户同一微秒提交，重复机率为1/100
     *
     * @return string
     */
    public static String genOutTradeNo(Long userId) {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long millis = System.currentTimeMillis();
        String preThree = String.format("%03d", checkLong(userId % 1000 + "", 3));
        String middle = String.format("%010d", checkLong((millis / 1000 - 946656000) + "", 10));
        String lastThree = String.format("%03d", checkLong(millis % 1000 + "", 3));
        return preThree + middle + lastThree;
    }

    /**
     * @param str 字符串
     * @param len 长度
     * @return
     * @des 验证字符串长度过长截取
     */
    private static int checkLong(String str, Integer len) {
        return Integer.parseInt(str.length() > len ? str.substring(0, len) : str);
    }

    /**
     * 过滤HTML标签
     *
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr) {
        //定义script的正则表达式
        String regexScript = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        //定义style的正则表达式
        String regexStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        //定义HTML标签的正则表达式
        String regexHtml = "<[^>]+>";

        Pattern pScript = Pattern.compile(regexScript, Pattern.CASE_INSENSITIVE);
        Matcher mScript = pScript.matcher(htmlStr);
        //过滤script标签
        htmlStr = mScript.replaceAll("");

        Pattern pStyle = Pattern.compile(regexStyle, Pattern.CASE_INSENSITIVE);
        Matcher mStyle = pStyle.matcher(htmlStr);
        //过滤style标签
        htmlStr = mStyle.replaceAll("");

        Pattern pHtml = Pattern.compile(regexHtml, Pattern.CASE_INSENSITIVE);
        Matcher mHtml = pHtml.matcher(htmlStr);
        //过滤html标签
        htmlStr = mHtml.replaceAll("");
        //返回文本字符串
        return htmlStr.trim();
    }

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String randomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        final StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            buffer.append(base.charAt(number));
        }
        return buffer.toString();
    }

    /**
     * Object转String
     *
     * @param obj
     * @return
     */
    public static String objToString(Object obj) {
        String result = "";
        if (obj != null) {
            result = String.valueOf(obj);
        }
        return result;
    }

    /**
     * Object转Long
     *
     * @param obj
     * @return
     */
    public static Long objToLong(Object obj) {
        Long result = null;
        if (obj != null) {
            result = Long.valueOf(objToString(obj));
        }
        return result;
    }

    /**
     * Object转Date
     * 默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @param obj
     * @return
     */
    public static Date objToDate(Object obj, String... patterns) {
        Date result = null;
        if (obj != null) {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            if (patterns != null && patterns.length > 0) {
                pattern = patterns[0];
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                result = sdf.parse(objToString(obj));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String specialCharFilter(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        str = str.replaceAll("\\\\", "\\\\\\\\");
        str = str.replaceAll("%", "\\\\%");
        str = str.replaceAll("_", "\\\\_");
        return str;
    }

    public static void main(String[] args) throws InterruptedException {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            String serialNo = CharsetUtils.genOutTradeNo(21L);
            Thread.sleep(1L);
            set.add(serialNo);
        }
        System.out.println("订单号个数" + set.size());
        for (String s : set) {
            System.out.println(s);
        }
    }
}
