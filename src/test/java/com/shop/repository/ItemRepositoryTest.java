package com.shop.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import com.shop.entity.QItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @PersistenceContext
    EntityManager em;

    void createItemList2() {
        for ( int i=1; i<=5; i++ ) {
            final Item item = new Item();
            item.setItemName("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item);
        }

        for ( int i=6; i<=10; i++ ) {
            final Item item = new Item();
            item.setItemName("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
            item.setStockNumber(0);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item);
        }
    }

//    @Test
//    @DisplayName("상품 Querydsl 조회 테스트2")
//    void queryDslTest2() {
//        this.createItemList2();
//        final BooleanBuilder booleanBuilder = new BooleanBuilder();
//        final QItem item = QItem.item;
//        String itemDetail = "테스트 상품 상세 설명";
//        int price = 10003;
//        String itemSellStat = "SELL";
//
//        booleanBuilder.and(item.itemDetail.like("%" + itemDetail + "%"));
//        booleanBuilder.and(item.price.gt(price));
//
//        if (StringUtils.equals(itemSellStat, ItemSellStatus.SELL)) {
//            booleanBuilder.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
//        }
//
//        Pageable pageable = PageRequest.of(0,5);
//        final Page<Item> itemPagingResult = itemRepository.findAll(booleanBuilder, pageable);
//
//        System.out.println("itemPagingResult.getTotalElements() = " + itemPagingResult.getTotalElements());
//        final List<Item> resultItemList = itemPagingResult.getContent();
//
//        for (Item item1 : resultItemList) {
//            System.out.println("item1 = " + item1.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("상품 QueryDsl 조회 테스트1")
//    void queryDslTest() {
//        this.createItemTest();
//        final JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        QItem qItem = QItem.item;
//        final JPAQuery<Item> query = queryFactory.selectFrom(qItem)
//                .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
//                .where(qItem.itemDetail.like("%" + "테스트 상품" + "%"))
//                .orderBy(qItem.price.desc());
//        final List<Item> itemList = query.fetch();
//
//        for (Item item : itemList) {
//
//            System.out.println("item = " + item.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("상품 저장 테스트")
//    void createItemTest() {
//        for (int i=0; i<10; i++ ) {
//            Item item = new Item();
//            item.setItemName("테스트 상품" + i);
//            item.setPrice(10000 + i);
//            item.setItemDetail("테스트 상품 상세 설명" + i);
//            item.setItemSellStatus(ItemSellStatus.SELL);
//            item.setStockNumber(100);
//            item.setRegTime(LocalDateTime.now());
//            item.setUpdateTime(LocalDateTime.now());
//            final Item saveItem = itemRepository.save(item);
//        }
//    }
//
//    @Test
//    @DisplayName("상품조회 테스트")
//    void findByItemList() {
//        this.createItemTest();
//        final List<Item> itemList = itemRepository.findByItemName("테스트 상품1");
//        for (Item item : itemList) {
//            System.out.println("item = " + item.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("상품명, 상품상세설명 or 테스트")
//    void findByItemNameOrItemDetailTest() {
//        this.createItemTest();
//        final List<Item> byItemNameOrItemDetail = itemRepository.findByItemNameOrItemDetail("테스트상품명", "테스트 상품 상세 설명2");
//        for (Item item : byItemNameOrItemDetail) {
//            System.out.println("item = " + item.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("가격 LessThan 테스트")
//    void findByPriceLessThan() {
//        this.createItemTest();
//        final List<Item> byPriceLessThan = itemRepository.findByPriceLessThan(10005);
//        for (Item item : byPriceLessThan) {
//            System.out.println("item = " + item.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("가격 내림차순 정렬 테스트")
//    void findByPriceLessThanOrderByPriceDesc() {
//        this.createItemTest();
//        final List<Item> byPriceLessThanOrderByPriceDesc = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
//        byPriceLessThanOrderByPriceDesc.forEach(item -> {
//            System.out.println("item = " + item.toString());
//        });
//    }
//
//    @Test
//    @DisplayName("@Query를 이용한 상품 조회 테스트")
//    void findByItemDetail() {
//        this.createItemTest();
//        final List<Item> findItemDetail = itemRepository.findByItemDetail("테스트 상품");
//        for (Item item : findItemDetail) {
//            System.out.println("item = " + item.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("native query test")
//    void findByItemDetailNative() {
//        this.createItemTest();
//        final List<Item> itemList = itemRepository.findByItemDetailNative("테스트 상품");
//        for (Item item : itemList) {
//            System.out.println("item = " + item.toString());
//        }
//    }
}