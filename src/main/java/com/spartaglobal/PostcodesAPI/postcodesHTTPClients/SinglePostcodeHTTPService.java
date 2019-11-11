package com.spartaglobal.PostcodesAPI.postcodesHTTPClients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


public class SinglePostcodeHTTPService {
    // API URL ,amagement
    private String baseURL = "https://api.postcodes.io";
    private String singlePostcodesEndpoint = "/postcodes/";
    // API URL management end **

    // manage constructor postcode data
    private String postcode;
    // End ***

    // Capture full response from get request
    private CloseableHttpResponse singlePostcodeFullResponse;
    // END ***

    //accessing the body of the http response
    private String singlePostcodeResponseBody;
    // End ***


    public SinglePostcodeHTTPService(String postcode) {
        this.postcode = postcode;
    }

    // Making the full request and sending the response to the ClosableHttpResponse
    public void singlePostcodeGetRequest(){
        // create the HTTP client
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        // create get request i.e set up the get reuqest object
        HttpGet getSinglePostcode = new HttpGet(baseURL + singlePostcodesEndpoint + postcode);
        //execute the call
        try {
            //executing closablehttpclient with the uri in get single postcode
            singlePostcodeFullResponse = closeableHttpClient.execute(getSinglePostcode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSinglePostCodeResponseBody();
    }

    // Set the body variable wit the JSON details as string
    private void setSinglePostCodeResponseBody(){
        try {
            // EntityUtils provide tools to be able to access HTTP body message  from responses
            // We have set the body to String - we need to plan how to transfer this to JSON
            singlePostcodeResponseBody = EntityUtils.toString(singlePostcodeFullResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSinglePostcodeResponseBody(){
        return singlePostcodeResponseBody;
    }

    public void headers(){
        System.out.println(singlePostcodeFullResponse.getAllHeaders());
    }

    public void getResponse(){
        System.out.println(singlePostcodeFullResponse.getStatusLine());
    }
}
