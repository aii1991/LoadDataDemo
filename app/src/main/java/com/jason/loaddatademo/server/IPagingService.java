package com.jason.loaddatademo.server;

import java.util.List;

import rx.Observer;

/**
 * @author zjh
 * @date 2016/9/18
 */
public interface IPagingService<T extends List> {
    /**
     * 加载分页数据
     * @param page 加载第几页
     * @param limit 1页加载多少条
     */
    void getData(int page,int limit, Observer<T> observer);
}
