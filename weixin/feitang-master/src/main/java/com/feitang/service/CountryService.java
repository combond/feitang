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
import com.feitang.orm.domain.Country;
import com.feitang.orm.domain.CountryExample;
import com.feitang.orm.persistence.CountryMapper;

/**
 * @author liuzh
 * @since 2015-12-19 11:09
 */
@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    public List<Country> getAll(CountryExample example)  throws LmsException{
    	try{
    		return countryMapper.selectByExample(example);
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }

    public Country getById(Integer id)  throws LmsException{
    	try{
    		return countryMapper.selectByPrimaryKey(id);
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }

    public void deleteById(Integer id)  throws LmsException{
    	try{
    		countryMapper.deleteByPrimaryKey(id);
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }

    public void save(Country country)  throws LmsException{
    	try{
    		if (country.getId() != null) {
                countryMapper.updateByPrimaryKey(country);
            } else {
                countryMapper.insert(country);
            }
    	}catch(Exception e){
    		throw new LmsException(ReturnCode.E_SERVICE, e);
    	}
        
    }
}
