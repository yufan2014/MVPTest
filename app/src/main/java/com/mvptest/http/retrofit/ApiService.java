package com.mvptest.http.retrofit;

import com.mvptest.bean.IndexContents;
import com.mvptest.bean.UpdateAppInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/17.
 */

public interface ApiService {

    @GET("http://pic.sogou.com/pics?reqType=ajax&reqFrom=result")
    Observable<String> getMM(@Query("query") String word, @Query("start") int start_num);
    @GET("http://test-server.zdoer.net/IndexInfo/getIndexContent")
    Observable<IndexContents> getIndex();

    @GET("http://test-server.zdoer.net/IndexInfo/getIndexContent")
    Observable<UpdateAppInfo> checkVersion();
}
