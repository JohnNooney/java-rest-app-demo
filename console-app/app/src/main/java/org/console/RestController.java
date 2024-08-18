package org.console;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class RestController {
    private HttpClient httpClient;
    private String hostURI;

    public RestController(String hostURI) {
        httpClient = HttpClientBuilder.create().build();
        this.hostURI = hostURI;
    }

    public void post(String endpoint,String jsonBody) {
        StringEntity requestEntity = new StringEntity(
                jsonBody,
                ContentType.APPLICATION_JSON);

        HttpPost postMethod = new HttpPost(hostURI + endpoint);
        postMethod.setEntity(requestEntity);

        try {
            HttpResponse rawResponse = httpClient.execute(postMethod);
            System.out.println("POST Response: " + rawResponse.toString());
        } catch (Exception ex) {
            System.out.println("POST Exception: " + ex.getMessage());
        }
    }

    public void getById(String endpoint, Integer id) {
        HttpGet getMethod = new HttpGet(hostURI + endpoint + id.toString());

        try {
            HttpResponse rawResponse = httpClient.execute(getMethod);
            System.out.println("GET Response: " + rawResponse.toString());
        } catch (Exception ex) {
            System.out.println("GET Exception: " + ex.getMessage());
        }
    }
}
