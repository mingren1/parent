package com.rtmap.middle.framework.mvc.filter;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@Slf4j
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private Whitelist whitelist = Whitelist.none();

    /**
     * Constructs a vo object wrapping the given vo.
     *
     * @param request
     * @throws IllegalArgumentException if the vo is null
     */
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null) {
            return null;
        }
        return cleanXSS(value);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value == null) {
            return null;
        }
        return cleanXSS(value);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = cleanXSS(values[i]);
        }
        return encodedValues;
    }

    private String cleanXSS(String value) {
        if (value == null) {
            return value;
        }
        String str = Jsoup.clean(value, whitelist);
        if (str.length() != value.length()) {
            log.info("xss clean {} to {}", value, str);
        }
        return str;
    }
}
