package com.kayo.manager.mapper;


import com.kayo.io.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrandMapper {

    @Select("<script>" +
            "select * from tb_brand" +
            " where 1 = 1" +
            "<if test ='name != null and name != \"\"'>" +
            " and name like concat('%', #{name},'%')" +
            "</if>" +
            "<if test ='firstChar != null and firstChar != \"\"'>" +
            " and first_char = #{firstChar}" +
            "</if>" +
            " order by id asc" +
            "</script>"
    )
    @Results(id = "brandMap",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "first_char", property = "firstChar")
            })
    List<Brand> findAll(Brand brand);

    @Insert("INSERT into tb_brand (name,first_char) VALUES (#{name},#{firstChar});")
    int save(Brand brand);

    @Update("UPDATE tb_brand SET name = #{name},first_char = #{firstChar} WHERE id = #{id}")
    int update(Brand brand);

    @Delete("DELETE from tb_brand WHERE id = #{id}")
    void delete(long id);
}
