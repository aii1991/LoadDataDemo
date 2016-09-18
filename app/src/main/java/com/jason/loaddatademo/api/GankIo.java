package com.jason.loaddatademo.api;


import com.jason.loaddatademo.entity.WelfareEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author zjh
 * @date 2016/9/18
 */
public interface GankIo {
    @GET("福利/{pageSize}/{currentPage}")
    Observable<List<WelfareEntity>> getWelfareImg(@Path("pageSize") int pageSize,@Path("currentPage") int currentPage);
}
