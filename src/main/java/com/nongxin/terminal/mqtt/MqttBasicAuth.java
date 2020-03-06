package com.nongxin.terminal.mqtt;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class MqttBasicAuth {

    public String getConnection(String equipmentId) throws Exception{

        String result = null;
        HttpHost target = new HttpHost("47.112.109.92", 8080, "http");
        BasicCredentialsProvider credsProvider =  new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials("b242e42f70e698", "Mjg3OTY5NzU5OTA3MjAzNzIzNTU1NDU4MjYyMzA1OTk2ODA"));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();
        try {
            BasicAuthCache authCache = new BasicAuthCache();
            BasicScheme basicAuth = new BasicScheme();
            authCache.put(target, basicAuth);
            HttpClientContext localContext = HttpClientContext.create();
            localContext.setAuthCache(authCache);

            HttpGet httpget = new HttpGet("http://47.112.109.92:8080/api/v3/connections/"+equipmentId);

            CloseableHttpResponse response = httpclient.execute(target, httpget, localContext);
            try {
                result = EntityUtils.toString(response.getEntity());
            } finally {
                response.close();
            }

        } finally {
            httpclient.close();
        }
        return result;
    }
}
