package com.jamel.adminpage.utils;


/**
 * @Author GaoJun
 * @Date 16:05 2020/3/25
 */
@FunctionalInterface
public interface BeanCopyUtilCallBack<S, T> {

    /**
     * 定义默认回调方法
     * @param t
     * @param s
     */
    void callBack(S t, T s);
}
