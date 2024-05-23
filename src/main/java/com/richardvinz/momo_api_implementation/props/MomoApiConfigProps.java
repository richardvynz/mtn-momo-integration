package com.richardvinz.momo_api_implementation.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("my.mtn.momo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MomoApiConfigProps {
    private String targetEnvironment;
    private String ocpApimSubcriptionKey;
    private String apiKey;
    private String apiUserId;

}
