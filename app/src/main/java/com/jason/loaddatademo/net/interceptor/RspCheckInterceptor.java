package com.jason.loaddatademo.net.interceptor;


import com.jason.loaddatademo.util.InterceptorUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author zjh
 * @date 2016/8/31
 */
public class RspCheckInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        String results = "";
            try {
                ResponseBody rspBody = response.body();
                JSONObject jsonObject = new JSONObject(InterceptorUtils.getRspData(rspBody));
                boolean isError = jsonObject.getBoolean("error");
                if (isError){
                    throw new IOException("error");
                }else {
                    results = jsonObject.getString("results");
                }
            } catch (JSONException e) {
                e.printStackTrace();
                throw new IOException("parase data error");
            }catch (Exception e){
                if (e instanceof IOException){
                    throw (IOException)e;
                }
            }
        MediaType contentType = response.body().contentType();
        ResponseBody body = ResponseBody.create(contentType,results);
        return response.newBuilder().body(body).build();
    }



}
