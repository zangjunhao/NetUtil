package com.example.easynetutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * 最简单的网络请求库，省得每次都要重新写
 * 这里面网络请求的数据依旧是json类型，要解析的就自己添加代码进行修改
 * 里面的url 你懂得，自己填写
 */
public  class NetUtil {
    private  String url1;//输入你自己的url

    public void geturl(String url1)
    {
        this.url1=url1;
    }
    public void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                BufferedReader reader;
                try {
                    URL url=new URL(url1);
                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(6000);
                    connection.setReadTimeout(6000);
                    Scanner ip=new Scanner(connection.getInputStream());
                    StringBuilder response=new StringBuilder();
                    while (ip.hasNextLine())
                    {
                        response.append(ip.hasNextLine());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(connection!=null)connection.disconnect();
                }
            }
        }).start();
    }

}
