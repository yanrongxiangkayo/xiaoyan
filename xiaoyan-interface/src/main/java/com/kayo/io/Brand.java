package com.kayo.io;

/**
 * 品牌
 * @author yanrx
 * @since 2020-05-31
 */
public class Brand {
    //品牌id
    private long id;
    //品牌名称
    private String name;
    //品牌首字母
    private String firstChar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstChar='" + firstChar + '\'' +
                '}';
    }
}
