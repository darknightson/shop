package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {

    List<Item> findByItemName(String itemName);

    // OR 조건 검색
    List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);

    // 전달 받은 가격 보다 작은 값
    List<Item> findByPriceLessThan(Integer price);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer Price);

    // JPQL 상품 상세 설명 조회 및 가격 내림차순 조회
    @Query( " select i " +
            "   from Item i " +
            "  where i.itemDetail like %:itemDetail%" +
            "  order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // native query 를 사용하면 기존 데이터베이스 쿼리를 그대로 사용할 수 있다. 하지만 데이터베이스에 종족되어 버려서 객체 쿼리의 장점을 잃어 버린다.

    @Query( value = " select * " +
            "   from item i" +
            "  where i.item_detail like %:itemDetail%" +
            "  order by i.price desc  ", nativeQuery = true)
    List<Item> findByItemDetailNative(@Param("itemDetail") String itemDetail);


}
