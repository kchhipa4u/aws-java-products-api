package com.serverless;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.dal.Product;

public class ListProductHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(ListProductHandler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		try {
	        // get all products
	        List<Product> products = new Product().list();

	        // send the response back
	        return ApiGatewayResponse.builder()
	    				.setStatusCode(200)
	    				.setObjectBody(products)
	    				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
	    				.build();
	    } catch (Exception ex) {
	    	LOG.error("Error in listing products: " + ex);

	        // send the error response back
	    	Response responseBody = new Response("Error in saving product: ", input);
			return ApiGatewayResponse.builder()
					.setStatusCode(500)
					.setObjectBody(responseBody)
					.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
					.build();
	    }
	}
}
