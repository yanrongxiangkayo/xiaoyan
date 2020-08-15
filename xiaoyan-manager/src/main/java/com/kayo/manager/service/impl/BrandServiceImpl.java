package com.kayo.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kayo.io.Brand;
import com.kayo.io.PageResult;
import com.kayo.manager.BrandService;
import com.kayo.manager.mapper.BrandMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanrx
 * @version 1.0
 * @date 2020/8/15 14:13
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public boolean save(Brand brand) {
        int i = brandMapper.save(brand);
        return i > 0;
    }

    @Override
    public boolean update(Brand brand) {
        int i = brandMapper.update(brand);
        return i > 0;
    }

    @Override
    public PageResult findByPage(Brand brand, int page, int rows) {
        try {
            //开始分页
            PageInfo<Brand> pageInfo = PageHelper.startPage(page, rows).doSelectPageInfo(() -> {
                brandMapper.findAll(brand);
            });
            LOGGER.info("查询到的结果：" + pageInfo);
            return new PageResult(pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            brandMapper.delete(id);
        }
    }
}
