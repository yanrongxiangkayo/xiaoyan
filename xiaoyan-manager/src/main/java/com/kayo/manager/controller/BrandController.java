package com.kayo.manager.controller;

import com.kayo.io.Brand;
import com.kayo.io.PageResult;
import com.kayo.manager.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/save")
    public boolean save(@RequestBody Brand brand) {
        try {
            return brandService.save(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("/update")
    public boolean update(@RequestBody Brand brand) {
        try {
            return brandService.update(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //分页查询
    @GetMapping("/findByPage")
    public PageResult findByPage(Brand brand, int page, @RequestParam(defaultValue = "10") int rows) {
        return brandService.findByPage(brand, page, rows);
    }

    //删除品牌
    @GetMapping("/delete")
    public boolean delete(@RequestParam(name = "ids") long[] ids) {
        try {
            brandService.delete(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
