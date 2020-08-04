package com.taiyi.websiate.taiyiweb.utils;
/**
 * @program: saas-code
 * @description:
 * @author: wjun
 * @create: 2020-03-18 15:41
 **/
@FunctionalInterface
public interface BeanCopyUtilCallBack<S, T> {
    /**
     * 定义默认回调方法
     * @param t
     * @param s
     */
    void callBack(S t, T s);
}
