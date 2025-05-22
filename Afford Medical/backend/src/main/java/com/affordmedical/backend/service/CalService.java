package com.affordmedical.backend.service;

import java.util.List;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.affordmedical.backend.model.NumbersResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class CalService {

     @Autowired
     private final RestTemplate restTemplate;

    public CalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double primes(){
        String accessKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzQ3ODk1ODM0LCJpYXQiOjE3NDc4OTU1MzQsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjMxYjYzZjExLWIxNjctNGQzNi04MzBjLTdjZWFkNmM0YjU2OCIsInN1YiI6IjIyMDAwMzE5MjFjc2VoQGdtYWlsLmNvbSJ9LCJlbWFpbCI6IjIyMDAwMzE5MjFjc2VoQGdtYWlsLmNvbSIsIm5hbWUiOiJ5YXJyYW1zZXR0aSBzaXZhIHNhbmthcmEgdmFyYSBwcmFzZCIsInJvbGxObyI6IjIyMDAwMzE5MjEiLCJhY2Nlc3NDb2RlIjoiYmVUSmpKIiwiY2xpZW50SUQiOiIzMWI2M2YxMS1iMTY3LTRkMzYtODMwYy03Y2VhZDZjNGI1NjgiLCJjbGllbnRTZWNyZXQiOiJHWlJ1VlhWTVNFcnVHblBWIn0.Egq1VIa3o94m7HaIwx3ZVQWuyFXAaiwq2wtzinTsWfI";
        String url = "http://20.244.56.144/evaluation-service/primes";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);
          HttpEntity<String> entity = new HttpEntity<>(headers);

        
        ResponseEntity<NumbersResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            NumbersResponse.class
        );

        
        List<Integer> numbers = response.getBody().getNumbers();
        
       OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();

        return average.orElseThrow(() -> new IllegalStateException("Could not calculate the average"));
    }

    public double even(){
        String accessKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzQ3ODk2NjExLCJpYXQiOjE3NDc4OTYzMTEsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjMxYjYzZjExLWIxNjctNGQzNi04MzBjLTdjZWFkNmM0YjU2OCIsInN1YiI6IjIyMDAwMzE5MjFjc2VoQGdtYWlsLmNvbSJ9LCJlbWFpbCI6IjIyMDAwMzE5MjFjc2VoQGdtYWlsLmNvbSIsIm5hbWUiOiJ5YXJyYW1zZXR0aSBzaXZhIHNhbmthcmEgdmFyYSBwcmFzZCIsInJvbGxObyI6IjIyMDAwMzE5MjEiLCJhY2Nlc3NDb2RlIjoiYmVUSmpKIiwiY2xpZW50SUQiOiIzMWI2M2YxMS1iMTY3LTRkMzYtODMwYy03Y2VhZDZjNGI1NjgiLCJjbGllbnRTZWNyZXQiOiJHWlJ1VlhWTVNFcnVHblBWIn0.s8qnMqZucGrLLJNQGhXzsq7ZSCZ1u1q-C6zHigsca6U";
        String url = "http://20.244.56.144/evaluation-service/even";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);
          HttpEntity<String> entity = new HttpEntity<>(headers);

     
        ResponseEntity<NumbersResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            NumbersResponse.class
        );

     
        List<Integer> numbers = response.getBody().getNumbers();
        
       OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();

        return average.orElseThrow(() -> new IllegalStateException("Could not calculate the average"));
    }

    public double fib(){
        String accessKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzQ3ODk2NzUyLCJpYXQiOjE3NDc4OTY0NTIsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjMxYjYzZjExLWIxNjctNGQzNi04MzBjLTdjZWFkNmM0YjU2OCIsInN1YiI6IjIyMDAwMzE5MjFjc2VoQGdtYWlsLmNvbSJ9LCJlbWFpbCI6IjIyMDAwMzE5MjFjc2VoQGdtYWlsLmNvbSIsIm5hbWUiOiJ5YXJyYW1zZXR0aSBzaXZhIHNhbmthcmEgdmFyYSBwcmFzZCIsInJvbGxObyI6IjIyMDAwMzE5MjEiLCJhY2Nlc3NDb2RlIjoiYmVUSmpKIiwiY2xpZW50SUQiOiIzMWI2M2YxMS1iMTY3LTRkMzYtODMwYy03Y2VhZDZjNGI1NjgiLCJjbGllbnRTZWNyZXQiOiJHWlJ1VlhWTVNFcnVHblBWIn0.gpTxHBjj7HJKNxkw3QwvCP1MXe0ZSXZymL418bD4gOYU";
        String url = "http://20.244.56.144/evaluation-service/fibo";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);
          HttpEntity<String> entity = new HttpEntity<>(headers);

        
        ResponseEntity<NumbersResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            NumbersResponse.class
        );

        
         
        List<Integer> numbers = response.getBody().getNumbers();
        
       OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();

        return average.orElseThrow(() -> new IllegalStateException("Could not calculate the average"));
    }


    public double rand(){
        String accessKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzQ3ODk1ODM0LCJpYXQiOjE3NDc4OTU1MzQsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjMxYjYzZjExLWIxNjctNGQzNi04MzBjLTdjZWFkNmM0YjU2OCIsInN1YiI6IjIyMDAwMzE5MjFjc2VoQGdtYWlsLmNvbSJ9LCJlbWFpbCI6IjIyMDAwMzE5MjFjc2VoQGdtYWlsLmNvbSIsIm5hbWUiOiJ5YXJyYW1zZXR0aSBzaXZhIHNhbmthcmEgdmFyYSBwcmFzZCIsInJvbGxObyI6IjIyMDAwMzE5MjEiLCJhY2Nlc3NDb2RlIjoiYmVUSmpKIiwiY2xpZW50SUQiOiIzMWI2M2YxMS1iMTY3LTRkMzYtODMwYy03Y2VhZDZjNGI1NjgiLCJjbGllbnRTZWNyZXQiOiJHWlJ1VlhWTVNFcnVHblBWIn0.Egq1VIa3o94m7HaIwx3ZVQWuyFXAaiwq2wtzinTsWfI";
        String url = "http://20.244.56.144/evaluation-service/rand";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);
          HttpEntity<String> entity = new HttpEntity<>(headers);

        
        ResponseEntity<NumbersResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            NumbersResponse.class
        );

        // Extract numbers from the response body
        List<Integer> numbers = response.getBody().getNumbers();
        
       OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();

        return average.orElseThrow(() -> new IllegalStateException("Could not calculate the average"));
    }

}
