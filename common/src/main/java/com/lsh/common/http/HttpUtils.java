package com.lsh.common.http;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.LinkedHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HttpUtils {
    private static ApiService apiService;

    private HttpUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_HOST)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private static class Holder {
        private static HttpUtils INSTANCE = new HttpUtils();
    }

    public static HttpUtils getInstance() {
        return Holder.INSTANCE;
    }

    public <T extends ResultEntity> void get(String apiUrl, LinkedHashMap<String, Object> map, final ApiCallBack<T> apiCallBack) {
        Call<String> call = apiService.get(apiUrl);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response) {
                handleResponse(response, apiCallBack);
            }

            @Override
            public void onFailure(@NotNull Call<String> call, @NotNull Throwable t) {
                handleFailure(apiCallBack);
            }
        });
    }

    public <T extends ResultEntity> void post(String apiUrl, LinkedHashMap<String, Object> map, final ApiCallBack<T> apiCallBack) {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        RequestBody body = RequestBody.create(mapToJson(handleMap(map)), okhttp3.MediaType.parse("application/json; charset=utf-8"));
        Call<String> call = apiService.post(apiUrl, body);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response) {
                handleResponse(response, apiCallBack);
            }

            @Override
            public void onFailure(@NotNull Call<String> call, @NotNull Throwable t) {
                handleFailure(apiCallBack);
            }
        });
    }

    private static String mapToJson(LinkedHashMap<String, Object> map) {
        JSONObject object = new JSONObject(map);
        return object.toString();
    }

    private static LinkedHashMap<String, Object> handleMap(LinkedHashMap<String, Object> map) {
        //添加上公共参数

        return map;
    }

    private static <T extends ResultEntity> void handleResponse(Response<String> response, ApiCallBack<T> apiCallBack) {
        if (response.isSuccessful()) {
            T resultEntity = new Gson().fromJson(response.body(), apiCallBack.getType());
            if (resultEntity != null) {
                if (resultEntity.getErrcode() == 0) {
                    apiCallBack.onSuccess(resultEntity);
                } else {
                    apiCallBack.onFailure(resultEntity.getErrcode(), resultEntity.getErrmsg(), resultEntity);
                }
            } else {
                apiCallBack.onFailure(ApiService.ERROR_CODE_NO_DATA, ApiService.KEY_ERROR_CODE_NO_DATA, null);
            }

        } else {
            apiCallBack.onFailure(ApiService.ERROR_CODE_NET_FAUILE, ApiService.KEY_ERROR_CODE_NET_FAUILE, null);
        }
    }

    private static <T> void handleFailure(ApiCallBack<T> apiCallBack) {
        apiCallBack.onFailure(ApiService.ERROR_CODE_NET_FAUILE, ApiService.KEY_ERROR_CODE_NET_FAUILE, null);
    }
}
