package com.mengxuegu.springcloud.entities;

import java.io.Serializable;

/**
 * @Auther: 梦学谷
 */
public class Product implements Serializable {

    private Long  pid;   //主键

    private String  productName;   //产品名称

    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String  dbSource;

    public Product() {
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(Long pid, String productName, String dbSource) {
        this.pid = pid;
        this.productName = productName;
        this.dbSource = dbSource;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
