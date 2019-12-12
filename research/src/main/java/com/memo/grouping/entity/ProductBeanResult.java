package com.memo.grouping.entity;

import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class ProductBeanResult {

    private String name;

    private Double amount;

    private List<ProductBean> productBeans;
}
