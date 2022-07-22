package com.example.NasaRequest;


import java.io.File;
import java.net.URL;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class Main {
    public static final String REMOTE_SERVICE_URI = "https://api.nasa.gov/planetary/apod?api_key=hSuGLHXw5dfdBpbbtxX6RtC5exysNlNDM6WAxhIa";
    public static final ObjectMapper mapper = new ObjectMapper();



    public static void main(String[] args) throws IOException {


        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
        CloseableHttpResponse response = httpClient.execute(request);
//        Arrays.stream(response.getAllHeaders())
//               .forEach(System.out::println);

        Nasa nasa = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<>() {});
        System.out.println(nasa);

        URL url = new URL("https://apod.nasa.gov/apod/image/2207/JWST_NGC628_Robert_Eder_V2.jpg");
        String filename = FilenameUtils.getName(url.getPath());// вытаскиваем имя файла с ссылки
        File destination = new File("E://",filename); // даем местоположение для сохранения
        System.out.printf("Файл %s сохраняется по адресу %s", destination, filename);
        FileUtils.copyURLToFile(url, destination); // скачиваем файл с ссылки

        //  String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);  System.out.println(body);
    }
}
