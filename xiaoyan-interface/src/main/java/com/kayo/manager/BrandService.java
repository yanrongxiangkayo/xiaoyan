package com.kayo.manager;

import com.kayo.io.Brand;
import com.kayo.io.PageResult;

/**
 * 品牌
 */
public interface BrandService {

    //保存
    boolean save(Brand brand);

    //修改
    boolean update(Brand brand);

    //分页查询
    PageResult findByPage(Brand brand, int page, int rows);

    //删除所有品牌
    void delete(long[] ids);
}
