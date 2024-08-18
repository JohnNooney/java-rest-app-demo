package org.console;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RestController {
    private String hostURI;

    public RestController(String hostURI) {
        this.hostURI = hostURI;
    }

    public void post(String endpoint,String jsonBody) {
        StringEntity requestEntity = new StringEntity(
                jsonBody,
                ContentType.APPLICATION_JSON);

        HttpPost postMethod = new HttpPost(hostURI + endpoint);
        postMethod.setEntity(requestEntity);

        executeRequest(postMethod);
    }

    public void getById(String endpoint, Integer id) {
        HttpGet getMethod = new HttpGet(hostURI + endpoint + id.toString());

        executeRequest(getMethod);
    }

    private void executeRequest(HttpRequestBase request) {
        try(CloseableHttpClient client = HttpClients.createDefault()) {
            HttpResponse rawResponse = client.execute(request);
            int statusCode = rawResponse.getStatusLine().getStatusCode();

            if (statusCode >= 200 && statusCode < 300) {
                HttpEntity entity = rawResponse.getEntity();
                System.out.println(request.getMethod() + " Response: " + EntityUtils.toString(entity));

            } else {
                throw new RuntimeException(request.getMethod() + " request failed with status code: " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println(request.getMethod() + " Exception: " + ex.getMessage());
        }
    }
}
