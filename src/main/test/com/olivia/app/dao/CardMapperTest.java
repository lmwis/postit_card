package com.olivia.app.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Random;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2022/1/2 4:20 下午
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CardMapperTest {
    @Autowired
    CardMapper cardMapper;
    final int number = 406;

    @Test
    public void selectById(){
        Card card = cardMapper.selectById(0);
        System.out.println(card);
    }
    @Test
    public void batchInsertByNumber(){

        Long aLong = cardMapper.selectCount(null);
        if (aLong>350){
            return;
        }
        char[] chars = "abcdefjhigklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < number; i++) {
            Card card = new Card();
            int len1 = RandomUtils.nextInt(1,100);
            card.setBody(RandomStringUtils.random(len1,chars));
            int len2 = RandomUtils.nextInt(8,40);
            card.setTitle(RandomStringUtils.random(len2,chars));
            card.setPublicationDate(new Date(new java.util.Date().getTime()));
            card.setExpirationDate(new Date(new java.util.Date().getTime()));
            card.setIsVisible(RandomUtils.nextInt(0,1));

            cardMapper.insert(card);
        }
    }
}
