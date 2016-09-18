package com.jason.loaddatademo.server;

import com.jason.loaddatademo.api.GankIo;
import com.jason.loaddatademo.entity.WelfareEntity;
import com.jason.loaddatademo.net.RetrofitManager;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author zjh
 * @date 2016/9/18
 */
public class WelfareServer implements IPagingService<List<WelfareEntity>>{
    @Override
    public void getData(int page, int limit, Observer<List<WelfareEntity>> observer) {
        RetrofitManager.getInstance().createReq(GankIo.class)
                .getWelfareImg(limit, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
