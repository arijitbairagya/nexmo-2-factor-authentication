package com.mce.authentication.sms.nexmo;

import java.io.IOException;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import com.nexmo.client.verify.VerifyResult;


//@Service
public class SmsSenderService {
	private static final String API_KEY = "b9b3a26b";
	private static final String API_SECRET = "fe9ade2586a480f7";
	private static final String FROM_NUMBER = "NEXMO";
	private static final String TO_NUMBER = "85265816501";

	
	public static void main(String[] args) {
//		sendSms();
		verify();
	}

	public static void sendSms() {
		AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
		NexmoClient client = new NexmoClient(auth);
		System.out.println(FROM_NUMBER);

		SmsSubmissionResult[] responses;
		try {
			responses = client.getSmsClient().submitMessage(new TextMessage(
			        FROM_NUMBER,
			        TO_NUMBER,
			        "Hello from Nexmo Arijit!"));
			
			for (SmsSubmissionResult response : responses) {
			    System.out.println(response);
			}
		} catch (IOException | NexmoClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void verify() {
		AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
		NexmoClient client = new NexmoClient(auth);
		try {
			VerifyResult verify = client.getVerifyClient().verify(TO_NUMBER, "NEXMO");
			System.out.println(verify);
		} catch (IOException | NexmoClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		verify.
	}
}
