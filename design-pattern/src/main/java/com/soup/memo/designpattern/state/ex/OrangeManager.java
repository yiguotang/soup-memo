package com.soup.memo.designpattern.state.ex;

/**
 * 各种橘子管理器
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrangeManager {

    private Orange orange;

    public void setOrange(Orange orange) {
        this.orange = orange;
    }

    public void print() {
        orange.printColor();
    }
}
