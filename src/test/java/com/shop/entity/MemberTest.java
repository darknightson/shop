package com.shop.entity;

import com.shop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

//    @Test
//    @DisplayName("Auditing 테스트")
//    @WithMockUser(username = "anthony.son", roles = "USER")
//    void auditingTest() {
//        Member member = new Member();
//        memberRepository.save(member);
//
//        em.flush();
//        em.clear();
//
//        Member findMember = memberRepository.findById(member.getId()).orElseThrow(EntityNotFoundException::new);
//
//        System.out.println("findMember.getCreateBy() = " + findMember.getCreateBy());
//        System.out.println("findMember.getModifiedBy() = " + findMember.getModifiedBy());
//        System.out.println("findMember.getRegTime() = " + findMember.getRegTime());
//        System.out.println("findMember.getUpdateTime() = " + findMember.getUpdateTime());
//
//    }

}