package com.example.jpademo;

import com.example.jpademo.dao.MemberRepository;
import com.example.jpademo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
import java.util.UUID;

@SpringBootTest
class JpaDemoApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void contextLoads() {

    }

    @Test
    void test1() {
        memberRepository.deleteAll();
        for (int i = 0; i < 10; i++) {
            Member member = Member.builder()
                    .id(UUID.randomUUID())
                    .number(i).build();
            memberRepository.save(member);
        }
        System.out.println("adad");
    }

    @Test
    void test2() {
        System.out.println(Objects.equals(null, null));
    }

}
