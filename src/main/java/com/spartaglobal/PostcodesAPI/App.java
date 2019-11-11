package com.spartaglobal.PostcodesAPI;

import com.spartaglobal.PostcodesAPI.postcodesHTTPClients.SinglePostcodeHTTPService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SinglePostcodeHTTPService singlePostcodeHTTPService = new SinglePostcodeHTTPService("ha39nr");

        singlePostcodeHTTPService.singlePostcodeGetRequest();
        System.out.println(singlePostcodeHTTPService.getSinglePostcodeResponseBody());
        singlePostcodeHTTPService.getResponse();
    }
}
