package org.random.joke;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class RandomJokeGeneratorApp {
    public static void main(String[] args) {

        try {
            System.out.println("*********** Joke is *************");
            System.out.println(GetRandomJokes());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String GetRandomJokes () throws URISyntaxException, IOException {

        // build url
        URIBuilder builder  = new URIBuilder("https://api.chucknorris.io/jokes/random");
        URI url = builder.build();

        // create client -> used to make requests
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // declare request method
        HttpGet getMethod = new HttpGet(url);

        // get response and close client
        HttpResponse response = httpClient.execute(getMethod);


        if(response.getStatusLine().getStatusCode() != 200) {
            System.out.println("Something went wrong");
            httpClient.close();
            return "" ;
        }


        // format the response
        HttpEntity respObj = response.getEntity();
        String data  = EntityUtils.toString(respObj);

        // get the value from json response
        JSONObject dataObj = new JSONObject(data);
        String result = dataObj.getString("value");

        httpClient.close();
        return result;
    }
}