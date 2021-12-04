package br.com.squad4.blue_bank.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNSController {
    @Autowired
    private AmazonSNSClient snsClient;

    String TOPIC_ARN = "arn:aws:sns:us-east-1:965934840569:S4-T2-ProjetoFinal-BlueBank";

    @GetMapping("/addSubscription/{email}")
    public String addSubscription(@PathVariable String email){
        SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
        snsClient.subscribe(request);
        return "Requisição pendente. Para confirmar, verifique seu email:" + email;
    }

    @GetMapping("/sendNotification")
    public String publicMessageToTopic(){
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailbody(), "Notification: Criação de nova conta BlueBank");
        snsClient.publish(publishRequest);
        return "Notificação enviada com sucesso!";
    }

    public String buildEmailbody(){
        return "Prezado cliente, \n" +
                "\n" +
                "\n"+
                "Seja bem-vindo ao BlueBank." +
                "\n"+
                "\n"+
                "Para maiores informações, entre em contato com sua agência.";
    }

}