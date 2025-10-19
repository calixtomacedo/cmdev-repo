package br.com.cmdev.tasks.config;

import br.com.cmdev.tasks.client.TokenJwtApiClient;
import br.com.cmdev.tasks.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class TokenJwtApiConfiguration {

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory () {
        WebClient webClient = WebClient.builder().baseUrl(Constants.BASE_URL).build();
        return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
    }

    @Bean
    public TokenJwtApiClient jwtApiClient(HttpServiceProxyFactory factory) {
        return factory.createClient(TokenJwtApiClient.class);
    }

}
