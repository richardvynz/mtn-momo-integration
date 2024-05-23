package com.richardvinz.momo_api_implementation.clients;


import com.richardvinz.momo_api_implementation.dto.AuthenticationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "momo-auth-api-client",
        url = "https://sandbox.momodeveloper.mtn.com/remittance"
)
public interface MomoAuthApiClient {

   @PostMapping("/token/")
    AuthenticationResponseDto getAccessToken( @RequestHeader("Authorization") String authorization,
                                              @RequestHeader("Ocp-Apim-Subscription-Key") String subscriptionKey
                                              );
}







//
//    AuthenticationResponseDto getAccessTokenResponse(@RequestHeader("Authorization") String Authorization,
//                                                     @RequestHeader("Ocp-Apim-Subscription-Key") String subscriptionKey)
//    {
//
//
//}
