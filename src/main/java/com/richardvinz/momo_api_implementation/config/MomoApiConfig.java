package com.richardvinz.momo_api_implementation.config;

import com.richardvinz.momo_api_implementation.props.MomoApiConfigProps;
import com.richardvinz.momo_api_implementation.service.AccessTokenProvider;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;


@RequiredArgsConstructor
public class MomoApiConfig {

    private final AccessTokenProvider accessTokenProvider;
    private final MomoApiConfigProps props;
    @Bean
    RequestInterceptor requestInterceptor(){
        return requestTemplate -> requestTemplate
                .header("Authorization", "Bearer " + accessTokenProvider.getAccessToken())
                .header("X-Target-Environment", props.getTargetEnvironment())
                .header("Ocp-Apim-Subscription-Key", props.getOcpApimSubcriptionKey());
    }
}
