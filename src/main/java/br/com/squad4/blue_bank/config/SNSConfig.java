package br.com.squad4.blue_bank.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class SNSConfig {
    public static final String SECRET_KEY = "jD40S+mj8kHcbinVcpc9yRMGvgknB4yr76f+jQpP";
    public static final String ACCESS_KEY = "AKIA6BZRT7L45VC3AO7L";

    @Primary
    @Bean
    public AmazonSNSClient getSnsClient(){
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
    }
}
