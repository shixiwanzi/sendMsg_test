package com.sms.test;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 中国网建短信通发送短信示例
 * http://www.smschinese.cn/api.shtml
 * @author AS
 *
 */
public class Test {

    public static void main(String[] args) throws Exception {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn"); 
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        //Uid:账号, Key:账号相关的key, smsMob:短信接收者手机号, smsText:短信内容
        NameValuePair[] data ={ new NameValuePair("Uid", "heshixi"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob","18273990730"),new NameValuePair("smsText",
                "亲爱的楚妹，今天是一个大喜的日子!愿你在有车的日子里，平安、幸福、快乐!请移步至微信，我发了个红包给你，聊表心意!")};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
        System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
        System.out.println(result); //打印返回消息状态


        post.releaseConnection();
    }

}
