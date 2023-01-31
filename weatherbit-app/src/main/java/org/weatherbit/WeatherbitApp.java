package org.weatherbit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class WeatherbitApp {
    public static void main(String[] args) {
        try {
            System.out.println(getWeatherData());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getLocation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the City");
        return sc.nextLine();
    }


    public static String getWeatherData() throws URISyntaxException, IOException {

        // create url
        URIBuilder builder = new URIBuilder("https://api.weatherbit.io/v2.0/current");
        builder.setParameter("key", "a4e08ded58ba46719fd0d11b9bf8998f");
        builder.setParameter("city", getLocation());

        URI url = builder.build();

        // create client to execute the request
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // define req method on the url
        HttpGet req = new HttpGet(url);

        // execute the request
        HttpResponse response = httpClient.execute(req);
        httpClient.close();
        // get data from response
        HttpEntity respData =  response.getEntity();
        String data = EntityUtils.toString(respData);

        // prettify the json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement js = JsonParser.parseString(data);

        return gson.toJson(js);
    }
}