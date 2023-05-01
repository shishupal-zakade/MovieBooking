package com.threatre.customer.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;

	@Bean
	public WebClient theatreWebClient() {
		return WebClient.builder().baseUrl("http://theatre-partner-service").filter(filterFunction).build();
	}
	
	@Bean
	public TheatreClient theatreClient() {
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(theatreWebClient())).build();
		return factory.createClient(TheatreClient.class);
	}
	@Bean
	public WebClient showWebClient() {
		return WebClient.builder().baseUrl("http://theatre-show-service").filter(filterFunction).build();
	}
	
	@Bean
	public ShowClient showClient() {
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(showWebClient())).build();
		return factory.createClient(ShowClient.class);
	}
}
