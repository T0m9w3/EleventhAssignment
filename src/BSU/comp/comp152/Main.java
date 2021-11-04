package BSU.comp.comp152;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main{

    public static void main(String[] args){
        var dataGrabber = HttpClient.newHttpClient();
        var requestBuilder = HttpRequest.newBuilder();
        var webURI = URI.create("http://universities.hippolabs.com/search?name=Young");
        var webRequest = requestBuilder.uri(webURI).build();
        HttpResponse<String> response = null;
        try{
            response = dataGrabber.send(webRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch(IOException exceptionObject){
            System.out.println("Error connecting to site or network is down");
        }
        catch(InterruptedException e){
            System.out.println("Connection went wrong getting data from the network");
        }
        if(response == null){
            System.out.println("Something went wrong getting data from the network");
            System.exit(-1);
        }
        var usefulData = response.body();
        System.out.println(usefulData);
    }
}
