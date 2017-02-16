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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feitang.constant.ReturnCode;
import com.feitang.exception.LmsException;
import com.feitang.orm.domain.City;
import com.feitang.orm.domain.CityExample;
import com.feitang.orm.persistence.CityMapper;


/**
 * @author liuzh
 * @since 2015-12-19 11:09
 */
@Service
public class CityService {
	private static final Logger logger =LoggerFactory.getLogger(CityService.class);
    @Autowired
    private CityMapper cityMapper;

    public List<City> getAll(CityExample example) throws LmsException{
    	try{
    		logger.info("Invoke CityService.getAll method...");
    		List<City> list = cityMapper.selectByExample(example);
    		return list;
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
    }

    public City getById(Long id) throws LmsException{
    	try{
    		return cityMapper.selectByPrimaryKey(id);
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }

    public void deleteById(Long id) throws LmsException{
    	try{
    		cityMapper.deleteByPrimaryKey(id);
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }

    public City save(City city) throws LmsException{
    	try{
    		if (city.getId() != null) {
                cityMapper.updateByPrimaryKey(city);
            } else {
                cityMapper.insert(city);
            }
    		city = cityMapper.selectByPrimaryKey(city.getId());
    		return city;
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }
}
