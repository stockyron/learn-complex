package com.rg.lock.test;

import com.ogwls.bo.req.OnlinePayManageBO;
import com.ogwls.domain.po.OnlinePayManagePO;

import java.lang.reflect.Method;
import java.util.List;

public class Test {
    /**
     *
     * 将po和bo之间的属性互相转换,bo中属性一般为String等基本类型,
     *
     * 但是po中可能有复合主键等复杂类型,需要注意同名问题
     *
     * @param src
     *
     * @param target
     */

    public static Object populate(Object src, Object target) {

        Method[] srcMethods = src.getClass().getMethods();

        Method[] targetMethods = target.getClass().getMethods();

        for (Method m : srcMethods) {

            String srcName = m.getName();

            if (srcName.startsWith("get")) {

                try {

                    Object result = m.invoke(src);

                    for (Method mm : targetMethods) {

                        String targetName = mm.getName();

                        if (targetName.startsWith("set") && targetName.substring(3, targetName.length()).equals(srcName.substring(3, srcName.length()))) {

                            mm.invoke(target, result);

                        }

                    }

                } catch (Exception e) {

                }

            }

        }

        return target;

    }

    /**
     *
     * bo集合和实体类集合间的互相属性映射
     *
     * @param src
     *
     * @param target
     *
     * @param targetClass
     *
     * @return
     */

    @SuppressWarnings("unchecked")
    public static <S, T> List<T> populateList(List<S> src, List<T> target,
                                              Class<?> targetClass) {

        for (int i = 0; i < src.size(); i++) {

            try {

                Object object = targetClass.newInstance();

                target.add((T) object);

                populate(src.get(i), object);

            } catch (Exception e) {

                continue;// 某个方法反射异常

            }

        }

        return target;

    }

    public static void main(String[] args) {

        OnlinePayManageBO onlinePayManageBO = new OnlinePayManageBO();
        onlinePayManageBO.setUseType("goku123");
        onlinePayManageBO.setThirdPartyPayerId(1);
        OnlinePayManagePO onlinePayManagePO = new OnlinePayManagePO();

        onlinePayManagePO = (OnlinePayManagePO) Test.populate(onlinePayManageBO,onlinePayManagePO);
        System.out.println(onlinePayManagePO.getUseType());

    }
}
