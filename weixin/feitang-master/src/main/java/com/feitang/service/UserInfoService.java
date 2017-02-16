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

package com.feitang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feitang.constant.ReturnCode;
import com.feitang.exception.LmsException;
import com.feitang.orm.domain.UserInfo;
import com.feitang.orm.domain.UserInfoExample;
import com.feitang.orm.persistence.UserInfoMapper;


/**
 * @author liuzh
 * @since 2016-01-31 21:42
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getAll(UserInfoExample example) throws LmsException {
    	try{
    		return userInfoMapper.selectByExample(example);
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }

    public UserInfo getById(Integer id)  throws LmsException{
    	try{
    		return userInfoMapper.selectByPrimaryKey(id);
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }

    public void deleteById(Integer id) throws LmsException {
    	try{
    		userInfoMapper.deleteByPrimaryKey(id);
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }

    public void save(UserInfo country)  throws LmsException{
    	try{
    		if (country.getId() != null) {
                userInfoMapper.updateByPrimaryKey(country);
            } else {
                userInfoMapper.insert(country);
            }
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }
}
