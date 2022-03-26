package com.example.jpademo.service;

import com.example.jpademo.dao.MemberRepository;
import com.example.jpademo.entity.Member;
import com.example.jpademo.event.AsyncTestEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author yaohongbin
 * @date 2022/1/9
 * @desc
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class JpaTestServiceImpl implements JpaTestService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTransaction() {
        List<Member> memberList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Member member = Member.builder()
                    .id(UUID.randomUUID())
                    .build();
            memberList.add(member);
        }

        memberList.forEach(member -> memberRepository.save(member));
    }

    @EventListener
    @Async("remoteThread")
    public void onAsyncTestEvent(AsyncTestEvent asyncTestEvent) {
        log.info("onAsyncTestEvent, data: {}", asyncTestEvent);
    }
}
