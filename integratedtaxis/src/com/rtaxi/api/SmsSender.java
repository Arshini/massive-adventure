package com.rtaxi.api;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Message;
 
public class SmsSender {
 
    /* Find your sid and token at twilio.com/user/account */
    public static final String ACCOUNT_SID = "AC06a84569599e00190dd205c2d1aac618";
    public static final String AUTH_TOKEN = "8dfc8f3696488d26becd87769b6f6130";
 
    public void sendSms(String strBody) throws TwilioRestException {
 
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 
        Account account = client.getAccount();
        
 
        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+917702076133")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("From", "+14849714041")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("Body", strBody));
        Message sms = messageFactory.create(params);
        System.out.println("sms.getErrorMessage()"+sms.getErrorMessage());
    }
}