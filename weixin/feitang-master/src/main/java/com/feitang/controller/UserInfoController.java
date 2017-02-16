/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.feitang.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feitang.constant.ReturnCode;
import com.feitang.dto.ReturnItemDto;
import com.feitang.dto.ReturnItemListDto;
import com.feitang.exception.LmsException;
import com.feitang.orm.domain.UserInfo;
import com.feitang.orm.domain.UserInfoExample;
import com.feitang.service.UserInfoService;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping
    public ReturnItemListDto<UserInfo> getAll() {
    	try{
    		UserInfoExample example = new UserInfoExample();
            List<UserInfo> userInfoList = userInfoService.getAll(example);
            
            return new ReturnItemListDto<UserInfo>(ReturnCode.N_APP, userInfoList);
    	}catch(LmsException e){
    		return new ReturnItemListDto<UserInfo>(e);
    	}catch(Exception e){
    		return new ReturnItemListDto<UserInfo>(ReturnCode.E_CONTROLLER, e);
    	}
    }

    @RequestMapping(value = "/add")
    public ReturnItemDto<String> add() {
    	try{
    		UserInfo userInfo = new UserInfo();
    		userInfoService.save(userInfo);
            return new ReturnItemDto<String>(ReturnCode.N_APP, StringUtils.EMPTY,StringUtils.EMPTY);
    	}catch(LmsException e){
    		return new ReturnItemDto<String>(e);
    	}catch(Exception e){
    		return new ReturnItemDto<String>(ReturnCode.E_CONTROLLER, e);
    	}
    }

    @RequestMapping(value = "/view/{id}")
    public ReturnItemDto<UserInfo> view(@PathVariable Integer id) {
    	try{
    		UserInfo userInfo = userInfoService.getById(id);
            return new ReturnItemDto<UserInfo>(ReturnCode.N_APP, userInfo);
    	}catch(LmsException e){
    		return new ReturnItemDto<UserInfo>(e);
    	}catch(Exception e){
    		return new ReturnItemDto<UserInfo>(ReturnCode.E_CONTROLLER, e);
    	}
    }

    @RequestMapping(value = "/delete/{id}")
    public ReturnItemDto<String> delete(@PathVariable Integer id) {
    	try{
    		userInfoService.deleteById(id);
            return new ReturnItemDto<String>(ReturnCode.N_APP, StringUtils.EMPTY,StringUtils.EMPTY);
    	}catch(LmsException e){
    		return new ReturnItemDto<String>(e);
    	}catch(Exception e){
    		return new ReturnItemDto<String>(ReturnCode.E_CONTROLLER, e);
    	}
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ReturnItemDto<String> save() {
    	try{
    		UserInfo userInfo = new UserInfo();
    		userInfoService.save(userInfo);
            return new ReturnItemDto<String>(ReturnCode.N_APP, StringUtils.EMPTY,StringUtils.EMPTY);
    	}catch(LmsException e){
    		return new ReturnItemDto<String>(e);
    	}catch(Exception e){
    		return new ReturnItemDto<String>(ReturnCode.E_CONTROLLER, e);
    	}
    }
}
