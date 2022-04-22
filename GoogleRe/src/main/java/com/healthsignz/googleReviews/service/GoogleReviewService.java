package com.healthsignz.googleReviews.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Service("googleReviewService")
public class GoogleReviewService {

	public String goolgeRatings(String placeId) throws IOException {
		String res = "";
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			Request request = new Request.Builder()
					.url("https://maps.googleapis.com/maps/api/plac + placeId
							+ "&key")
					.method("GET", null).build();
			Response response = client.newCall(request).execute();
			// System.out.println(response.body().string());
			res = response.body().string();
		} catch (Exception e) {
			System.out.println("Exception occured while fecthing google reviews" + e);
		}
		return res;
	}
}
