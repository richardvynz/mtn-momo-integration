package com.richardvinz.momo_api_implementation.service;


import com.richardvinz.momo_api_implementation.clients.MomoAuthApiClient;
import com.richardvinz.momo_api_implementation.props.MomoApiConfigProps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccessTokenProvider {

    private final MomoAuthApiClient momoAuthApiClient;
    private final MomoApiConfigProps props;


    public String getAccessToken( ){
        String header = Base64.getEncoder().encodeToString(
                String.format("%s:%s",props.getApiUserId(),
                        props.getApiKey()).getBytes()
        );

        var authResponse = momoAuthApiClient.getAccessToken("Basic "+header, props.getOcpApimSubcriptionKey());
        log.info("Access token: {}", authResponse.accessToken());
        return authResponse.accessToken();
    }
}
