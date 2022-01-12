package com.olivia.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fehead.lang.controller.BaseController;
import com.fehead.lang.error.BusinessException;
import com.fehead.lang.error.EmBusinessError;
import com.fehead.lang.response.CommonReturnType;
import com.fehead.lang.response.FeheadResponse;
import com.olivia.app.dao.Card;
import com.olivia.app.dao.CardMapper;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author: olivia
 * @Data: 2022/1/2 4:07 下午
 * @Version: 1.0
 */
@RestController
@RequestMapping("/card")
@AllArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CardController extends BaseController {

    final CardMapper cardMapper;

    @GetMapping("/{id}")
    public FeheadResponse getById(@PathVariable int id) throws BusinessException {
        Card card = cardMapper.selectById(id);
        if (card!=null){
            return CommonReturnType.create(card);
        }
        throw new BusinessException(EmBusinessError.USER_NOT_EXIST,"该id不存在");
    }
    @GetMapping("/search")
    public FeheadResponse searchByPage(String key,int size,int current) throws BusinessException {

        if(!validateNull(key,size,current)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        QueryWrapper<Card> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title",key)
                .or().like("body",key);

        IPage<Card> page = new Page<>(current,size);
        IPage<Card> cardIPage = cardMapper.selectPage(page, queryWrapper);

        return CommonReturnType.create(cardIPage);

    }
    @GetMapping("/page")
    public FeheadResponse getByPage(int size,int current) {
        IPage<Card> page = new Page<>(current,size);
        IPage<Card> cardIPage = cardMapper.selectPage(page, new QueryWrapper<>());
        return CommonReturnType.create(cardIPage);
    }

    /**
     * 新增
     * @param title
     * @param body
     * @param expirationDate
     * @return
     * @throws BusinessException
     */
    @PostMapping("")
    public FeheadResponse insertCard(String title,String body,String expirationDate,int isVisible) throws BusinessException {
        if (!validateNull(title,body,expirationDate)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"参数不完整");
        }
        Card card = new Card();
        card.setTitle(title);
        card.setBody(body);
        card.setIsVisible(isVisible);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(expirationDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        card.setExpirationDate(date);
        card.setPublicationDate(new Date(new java.util.Date().getTime()));
        int insert = cardMapper.insert(card);
        return CommonReturnType.create(insert);
    }

    @PutMapping("/{id}")
    public FeheadResponse updateCard(@PathVariable int id,String title,String body,int isVisible) throws BusinessException {
        if (!validateNull(body,title)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"参数不完整");
        }
        Card card = cardMapper.selectById(id);
        if (card==null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST,"id不存在");
        }
        card.setTitle(title);
        card.setBody(body);
        card.setIsVisible(isVisible);
        cardMapper.updateById(card);
        return CommonReturnType.create(card);
    }

    @DeleteMapping("/{id}")
    public FeheadResponse deleteById(@PathVariable int id) throws BusinessException {
        Card card = cardMapper.selectById(id);
        if (card==null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST,"该id不存在");
        }
        cardMapper.deleteById(card);
        return CommonReturnType.create(card);

    }



}
