package com.example.picpaydesafiobackend.service;

import com.example.picpaydesafiobackend.domain.user.User;
import com.example.picpaydesafiobackend.dto.NotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDto notificationRequest = new NotificationDto(email, message);

        ResponseEntity<String> notificationResponse  = restTemplate.postForEntity(
                "https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6",
                notificationRequest,
                String.class);

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            throw new Exception("Serviço de notificação indisponível");
        }
    }
}
