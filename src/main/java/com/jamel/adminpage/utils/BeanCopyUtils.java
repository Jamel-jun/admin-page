package com.jamel.adminpage.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.function.Supplier;

/**
 * java bean copy工具类
 * 作用于：集合内属性互转
 * @Author GaoJun
 * @Date 15:45 2020/3/24
 * <pre>{@code List互转:
 *       List<User> users = Arrays.asList(new User(1, "name1", "user1"), new User(2, "name2", "user2"), new User(3, "name3", "user3"));
 *       List<UserVo> userVoList = BeanCopyUtils.copyListProperties(users,UserVo::new,(user,userVO) -> {
 *             userVO.setNameVo(user.getUserName());
 *       });
 *       sout:
 *          UserVo{id=1, name='name1', nameVo='user1'}
 *          UserVo{id=2, name='name2', nameVo='user2'}
 *          UserVo{id=3, name='name3', nameVo='user3'}
 * }</pre>
 * <pre>{@code Map互转:
 *       List<User> users = Arrays.asList(new User(1, "name1", "user1"), new User(2, "name2", "user2"), new User(3, "name3", "user3"));
 *       Map<String,List<User>> map = new HashMap<>();
 *          map.put("1",users);
 *       List<User> users1 = Arrays.asList(new User(11, "name11", "user11"), new User(22, "name22", "user22"), new User(33, "name33", "user33"));
 *         map.put("2",users1);
 *       Map<String, List<UserVo>> map1 = Utils.copyMapProperties(map, UserVo::new, (user,userVo) -> {
 *           userVo.setNameVo(user.getUserName());
 *       });
 *       sout:
 *       1: UserVo{id=1, name='name1', nameVo='user1'}
 *          UserVo{id=2, name='name2', nameVo='user2'}
 *          UserVo{id=3, name='name3', nameVo='user3'}
 *       2: UserVo{id=11, name='name11', nameVo='user11'}
 *          UserVo{id=22, name='name22', nameVo='user22'}
 *          UserVo{id=33, name='name33', nameVo='user33'}
 * }</pre>
 */
public class BeanCopyUtils extends BeanUtils {
    /**
     * List数据的拷贝
     * @param sources: 数据源类
     * @param target:  目标类::new(eg: UserVO::new)
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }

    /**
     * Map数据的拷贝
     * @param sources: 数据源类
     * @param target:  目标类::new(eg: UserVO::new)
     * @return
     */
    public static  <K, S, T> Map<K, List<T>> copyMapProperties(Map<K, List<S>> sources, Supplier<T> target){
        return copyMapProperties(sources, target, null);
    }

    /**
     * 带回调函数的List数据的拷贝（可自定义字段拷贝规则）
     *
     * @param sources:  数据源类
     * @param target:   目标类::new(eg: UserVO::new)
     * @param callBack: 回调函数
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t,getNullPropertyNames(source));
            list.add(t);
            if (callBack != null) {
                // 回调
                callBack.callBack(source, t);
            }
        }
        return list;
    }

    /**
     * 带回调函数的Map数据的拷贝（可自定义字段拷贝规则）
     * @param sources:  数据源类
     * @param target:   目标类::new(eg: UserVO::new)
     * @param callBack: 回调函数
     * @return
     */
    public static <K, S, T> Map<K, List<T>> copyMapProperties(Map<K, List<S>> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack){
        Map<K, List<T>> map = new HashMap<>(sources.size());
        for (Map.Entry<K, List<S>> source : sources.entrySet()) {
            List<T> ts = copyListProperties(source.getValue(), target, callBack);
            map.put(source.getKey(),ts);
        }
        return map;
    }

    /**
     * 获取需要忽略的属性
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            // 此处判断可根据需求修改
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


    /**
     * 忽略空值的java bean copy
     * @Author GaoJun
     * @Date 16:07 2020/3/25
     */
    public static void copyProperties(Object source, Object target) throws BeansException {
        BeanUtils.copyProperties(source,target,getNullPropertyNames(source));
    }

    /**
     * 忽略空值的java bean copy，支持自定义字段
     * @Author GaoJun
     * @Date 16:07 2020/3/25
     */
    public static <S, T> void copyProperties(S source, T target,BeanCopyUtilCallBack<S, T> callBack) throws BeansException {
        BeanUtils.copyProperties(source,target,getNullPropertyNames(source));
        callBack.callBack(source,target);
    }
}
