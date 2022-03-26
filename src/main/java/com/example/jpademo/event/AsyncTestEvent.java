package com.example.jpademo.event;

import lombok.Data;
import lombok.ToString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yaohongbin
 * @date 2022/2/9
 * @desc
 */
@Data
@ToString
public class AsyncTestEvent {

    public static void main(String[] args) {
        String url = "/api/user/call/actions/{id}/{name}";
//        String pattern = "/\\w*/\\w*";
//        Matcher matcher  = Pattern.compile(pattern).matcher(url);
//        // System.out.println(matcher.lookingAt());
//        String pre = matcher.group(0);
//
//        Matcher domainsMatchers = Pattern.compile(pre + "/\\w*").matcher(url);
//        domainsMatchers.lookingAt();
//        String[] domainsSplitResult = domainsMatchers.group(0).split("/");
//        // System.out.println(domainsSplitResult[domainsSplitResult.length - 1]);
//
//        // System.out.println(matcher.group(0));

        String pathParamPattern = "\\{.*?\\}";
        Matcher pathParamMatcher = Pattern.compile(pathParamPattern).matcher(url);
        boolean b = pathParamMatcher.find();
        System.out.println(b);
        System.out.println(pathParamMatcher.group(0));
        System.out.println(pathParamMatcher.find());
        System.out.println(pathParamMatcher.group(0));

    }

}
