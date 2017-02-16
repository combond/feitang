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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.feitang.constant.ReturnCode;
import com.feitang.dto.ReturnItemDto;
import com.feitang.dto.ReturnItemListDto;
import com.feitang.exception.LmsException;
import com.feitang.orm.domain.City;
import com.feitang.orm.domain.CityExample;
import com.feitang.orm.domain.Country;
import com.feitang.orm.domain.CountryExample;
import com.feitang.service.CountryService;
import com.github.pagehelper.PageInfo;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@RestController
@RequestMapping("/countries")
public class CountryController extends BaseController{

    @Autowired
    private CountryService countryService;

    @RequestMapping
    public ReturnItemListDto<Country> getAll() {
    	try{
    		CountryExample example = new CountryExample();
        	List<Country> countryList = countryService.getAll(example);
            
            return new ReturnItemListDto<Country>(ReturnCode.N_APP, countryList);
    	}catch(LmsException e){
    		return new ReturnItemListDto<Country>(e);
    	}catch(Exception e){
    		return new ReturnItemListDto<Country>(ReturnCode.E_CONTROLLER, e);
    	}
    }

    @RequestMapping(value = "/add")
    public ReturnItemDto<String> add() {
    	try{
    		Country country = new Country();
    		countryService.save(country);
            return new ReturnItemDto<String>(ReturnCode.N_APP, StringUtils.EMPTY,StringUtils.EMPTY);
    	}catch(LmsException e){
    		return new ReturnItemDto<String>(e);
    	}catch(Exception e){
    		return new ReturnItemDto<String>(ReturnCode.E_CONTROLLER, e);
    	}
    }

    @RequestMapping(value = "/view/{id}")
    public ReturnItemDto<Country> view(@PathVariable Integer id) {
    	try{
    		Country country = countryService.getById(id);
            return new ReturnItemDto<Country>(ReturnCode.N_APP, country);
    	}catch(LmsException e){
    		return new ReturnItemDto<Country>(e);
    	}catch(Exception e){
    		return new ReturnItemDto<Country>(ReturnCode.E_CONTROLLER, e);
    	}
    }

    @RequestMapping(value = "/delete/{id}")
    public ReturnItemDto<String> delete(@PathVariable Integer id) {
    	try{
    		countryService.deleteById(id);
            return new ReturnItemDto<String>(ReturnCode.N_APP, StringUtils.EMPTY, StringUtils.EMPTY);
    	}catch(LmsException e){
    		return new ReturnItemDto<String>(e);
    	}catch(Exception e){
    		return new ReturnItemDto<String>(ReturnCode.E_CONTROLLER, e);
    	}
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ReturnItemDto<String> save(Country country) {
    	try{
    		countryService.save(country);
            return new ReturnItemDto<String>(ReturnCode.N_APP, StringUtils.EMPTY, StringUtils.EMPTY);
    	}catch(LmsException e){
    		return new ReturnItemDto<String>(e);
    	}catch(Exception e){
    		return new ReturnItemDto<String>(ReturnCode.E_CONTROLLER, e);
    	}
    }
}
