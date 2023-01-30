package org.weather;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class WeatherForecastApp {
    public static void main(String[] args) {
        try{
            callWeatherForecastApi();
        }
        catch (Exception e){
            System.out.println("Exception occurred.."+ e);
        }
    }

    public static String getLocation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the location");
        String location = sc.nextLine();
        return  location;
    }

    public static void callWeatherForecastApi() throws URISyntaxException, IOException {
//        String location = getLocation();
        String location = "thanabhawan";
        // do some research about uribuilder
        URIBuilder builder = new URIBuilder(  "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast");
        builder.setParameter( "aggregateHours",  "24");
        builder.setParameter( "contentType",  "json");
        builder.setParameter( "unitGroup",  "metric");
        builder.setParameter("locationMode",  "single");
        builder.setParameter(  "key",  "1PYNQ6AWUDJE9AFERDCHJHSXK");
        builder.setParameter("location", location);

        // build the url
        URI url = builder.build();

        // create a closable client that will make the request on the above url
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // now declare the method (get) which we are going to call
        HttpGet getMethod = new HttpGet(url);

        // now client will the method and will get the response
        HttpResponse response =  httpClient.execute(getMethod);

        if(response.getStatusLine().getStatusCode() != 200){
            System.out.println("Something went wrong");
            return;
        }
        // get data from the response
        HttpEntity responseData = response.getEntity();

        // stringify the data
        String data = EntityUtils.toString(responseData);

        // close the client
        httpClient.close();

        JSONObject jsonData = new JSONObject(data);
        JSONObject locationObj = jsonData.getJSONObject("location");
        JSONArray values = locationObj.getJSONArray("values");

        System.out.println("date Time str \t\t\t\t mint \t\t maxt \t\t visibility  humidity");

        for(int i = 0; i < values.length(); i++){
            JSONObject value = values.getJSONObject(i);
            String dateTime = value.getString("datetimeStr");
            double minTemp = value.getDouble("mint");
            double maxTemp = value.getDouble("maxt");
            double humidity = value.getDouble("humidity");
            double visiblity = value.getDouble("visibility");

            System.out.printf("%s \t %f \t %f \t %f \t %f  \n", dateTime,minTemp,maxTemp,humidity,visiblity);

        }
    }
}