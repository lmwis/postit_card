package com.olivia.app.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: TODO
 * @Author: olivia
 * @Data: 2022/1/2 1:30 下午
 * @Version: 1.0
 */
@TableName("card")
@Data
@ToString
public class Card {

    @TableId(type = IdType.AUTO)
    Long id;

    String title;

    String body;

    Date publicationDate;

    Date expirationDate;

    /**
     * 1-可见
     * 0-不可见
     */
    Integer isVisible;

}
