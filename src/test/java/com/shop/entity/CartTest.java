package com.shop.entity;

import com.shop.dto.MemberFormDto;
import com.shop.repository.CartRepository;
import com.shop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CartTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PersistenceContext
    EntityManager em;

    public Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setName("anthony");
        memberFormDto.setEmail("anthony.son@kakaoent.com");
        memberFormDto.setPassword("sy1115!!");
        memberFormDto.setAddress("seoul");
        Member member = Member.createMember(memberFormDto, passwordEncoder);
        return member;
    }

//    @Test
//    @DisplayName("회원 엔티티 조회 테스트")
//    void findCartAndMember() {
//        Member member = createMember();
//        memberRepository.save(member);
//        Cart cart = new Cart();
//        cart.setMember(member);
//        cartRepository.save(cart);
//        em.flush();
//        em.clear();
//
//        Cart findCart = cartRepository.findById(cart.getId()).get();
//        Member findMember = findCart.getMember();
//
//        assertEquals(member.getId(), findMember.getId());
//        assertEquals(member.getName(), findMember.getName());
//        assertEquals(member.getEmail(), findMember.getEmail());
//        assertEquals(member.getAddress(), findMember.getAddress());
//        assertEquals(member.getRole(), findMember.getRole());
//        assertEquals(member.getPassword(), findMember.getPassword());

        
//    }


}