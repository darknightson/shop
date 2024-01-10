package com.shop.service;

import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    private Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("anthony.son@kakaoent.com");
        memberFormDto.setName("anthony");
        memberFormDto.setPassword("1115");
        memberFormDto.setAddress("seoul");
        return Member.createMember(memberFormDto, passwordEncoder);
    }

    @Test
    @Rollback(false)
    @DisplayName("회원가입 테스트")
    void save() {
        Member member = createMember();
        Member saveMember = memberService.saveMember(member);

        assertEquals(member.getEmail(), saveMember.getEmail());
        assertEquals(member.getName(), saveMember.getName());
        assertEquals(member.getAddress(), saveMember.getAddress());
        assertEquals(member.getRole(), saveMember.getRole());
        assertEquals(member.getPassword(), saveMember.getPassword());
    }
//
//    @Test
//    @Rollback(false)
//    @DisplayName("중복 회원 가입 테스트")
//    void duplicateMember() {
//        Member member1 = createMember();
//        Member member2 = createMember();
//        memberService.saveMember(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.saveMember(member2));
//
//        assertEquals("이미 존재하는 회원입니다.", e.getMessage());
//    }
}