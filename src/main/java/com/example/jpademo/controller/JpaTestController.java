package com.example.jpademo.controller;
//
//import com.example.jpademo.entity.Member;
//import com.example.jpademo.service.JpaTestService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;

import com.example.jpademo.entity.Member;

/**
 * @author yaohongbin
 * @date 2022/1/9
 * @desc
 */
//@RequiredArgsConstructor
//@RestController
//@Slf4j
public class JpaTestController {

//    private final JpaTestService jpaTestService;

//    @GetMapping("/testTransaction")
//    public void testTransaction() {
//        log.info("testTransaction3");
//        testPrivateInvokeTransaction();
//    }
//
//    private void testPrivateInvokeTransaction() {
//        List<Member> memberList = new ArrayList<>();
//        int i = 0;
//        while (true) {
//            i++;
////            Member member = new Member();
//            memberList.add(new Member());
//        }
//        // System.gc();
//        //memberList.forEach(System.out::println);
//    }

    public static void main(String[] args) {
        Member[] a = new Member[2];
        Object[] b = a;
        a[0] = new Member();
        b[1] = Integer.valueOf("11");

//        Long l1 = 1L;
//        Object l2 = l1;
//        Integer i3 = (Integer) l2;
    }

}
