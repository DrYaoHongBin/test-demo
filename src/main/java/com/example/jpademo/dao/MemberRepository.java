package com.example.jpademo.dao;

import com.example.jpademo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yaohongbin
 * @date 2022/1/9
 * @desc
 */
public interface MemberRepository extends JpaRepository<Member, String> {
}
