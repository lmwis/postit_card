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
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/page")
    public FeheadResponse getByPage(int size,int current) {
        IPage<Card> page = new Page<>(current,size);
        IPage<Card> cardIPage = cardMapper.selectPage(page, new QueryWrapper<>());
        return CommonReturnType.create(cardIPage);
    }

    @PostMapping("")
    public FeheadResponse insertCard(Card card) throws BusinessException {
        if (!validateNull(card)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"参数不完整");
        }
        int insert = cardMapper.insert(card);
        return CommonReturnType.create(insert);
    }

    @PutMapping("")
    public FeheadResponse updateCard(Card card) throws BusinessException {
        if (!validateNull(card)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"参数不完整");
        }
        int insert = cardMapper.updateById(card);
        return CommonReturnType.create(insert);
    }



}
