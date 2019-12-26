package com.lsh.common.http;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import org.jetbrains.annotations.NotNull;

public class HttpManager {
    /*---------------------------------------------------接口----------------------------------------------------------------*/
    public static <T extends ResultEntity> void getArticle(int page, final ApiCallBack<T> apiCallBack) {
        callEnqueue(HttpUtils.getInstance().getService().getArticle(String.valueOf(page)), apiCallBack);
    }
    public static <T extends ResultEntity> void getBanner( final ApiCallBack<T> apiCallBack) {
        callEnqueue(HttpUtils.getInstance().getService().getBanner(), apiCallBack);
    }
    /*---------------------------------------------------结果处理----------------------------------------------------------------*/
    private static <T extends ResultEntity> void callEnqueue(Call<String> call, final ApiCallBack<T> apiCallBack) {
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                handleResponse(response, apiCallBack);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                handleFailure(apiCallBack);
            }
        });
    }


    private static <T extends ResultEntity> void handleResponse(Response<String> response, ApiCallBack<T> apiCallBack) {
        if (response.isSuccessful()) {
            try {
                T resultEntity = new Gson().fromJson(response.body(), apiCallBack.getType());
                if (resultEntity != null) {
                    if (resultEntity.getErrorCode() == 0) {
                        apiCallBack.onSuccess(resultEntity);
                    } else {
                        apiCallBack.onFailure(resultEntity.getErrorCode(), resultEntity.getErrorMsg(), resultEntity);
                    }
                } else {
                    apiCallBack.onFailure(ApiService.ERROR_CODE_NO_DATA, ApiService.KEY_ERROR_CODE_NO_DATA, null);
                }
            } catch (Exception e) {
                apiCallBack.onFailure(ApiService.ERROR_CODE_NET_FAUILE, ApiService.KEY_ERROR_CODE_NET_FAUILE, null);
            }
        } else {
            apiCallBack.onFailure(ApiService.ERROR_CODE_NET_FAUILE, ApiService.KEY_ERROR_CODE_NET_FAUILE, null);
        }
    }

    private static <T> void handleFailure(ApiCallBack<T> apiCallBack) {
        apiCallBack.onFailure(ApiService.ERROR_CODE_NET_FAUILE, ApiService.KEY_ERROR_CODE_NET_FAUILE, null);
    }
}
