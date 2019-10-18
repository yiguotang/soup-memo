package com.soup.memo.common.compare;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserComparaor implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        int compareReuslt = 0;
        String compareType = "";
        if (!StringUtils.equals(user1.getName(), user2.getName())) {
            compareReuslt = user1.getName().compareTo(user2.getName());
            compareType = "user.getName";
        } else if (!StringUtils.equals(user1.getCity(), user2.getCity())) {
            compareReuslt = user1.getCity().compareTo(user2.getCity());
            compareType = "user.getCity";
        } else if (!user1.getAge().equals(user2.getAge())) {
            compareReuslt = user1.getAge().compareTo(user2.getAge());
            compareType = "user.getAge";
        }

        if (compareReuslt != 0) {
            user2.setCompareReason(compareType);
        }

        return compareReuslt;
    }
}
