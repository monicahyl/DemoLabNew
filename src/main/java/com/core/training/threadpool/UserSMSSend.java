package com.core.training.threadpool;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.apache.commons.collections4.MapUtils;
import org.springframework.http.HttpHeaders;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @Author huangyulu
 * @Date 2025/12/12 17:57
 * @Description
 */
@Data
public class UserSMSSend implements Callable<String> {

    public UserSMSInfo userSMSInfo;

    public UserSMSSend() {

    }

    public UserSMSSend(UserSMSInfo userSMSInfo) {
        this.userSMSInfo = userSMSInfo;
    }


    @Override
    public String call() throws Exception {

        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            String url = "http://127.0.0.1:";
//            httpHeaders.set("Signature", sign.trim());

            String body = JSONUtil.toJsonStr(userSMSInfo);
            System.out.println(body);

//            HttpResponse httpResponse = HttpRequest
//                    .post(url)
//                    .header(httpHeaders)
//                    .body(body)
//                    .timeout(20000).execute();

//            System.out.println(httpResponse.body());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return userSMSInfo.phoneNumber + " send ok";
    }

}
