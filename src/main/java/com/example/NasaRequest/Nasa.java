package com.example.NasaRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.net.URL;

public class Nasa {

    private final String copyright;
    private final String date;
    private final String explanation;
    private final URL hdurl;
    private final String media_type;
    private final String service_version;
    private final String title;
    private final URL url;

    public Nasa(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") URL hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") URL url
    ){
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }
    public String getCopyright(){return  copyright;}
    public String getDate(){return date;}
    public String getExplanation(){return explanation;}
    public URL getHdurl() {return hdurl;}
    public String getMedia_type(){return  media_type;}
    public String getTitle(){return title;}
    public URL getUrl(){return url;}

    @Override
    public String toString(){
        return "copyright: " + copyright+
                "\ndate: "+ date+
                "\n explanation: " + explanation +
                "\n hdurl: " + hdurl+
                "\n media_type: "+ media_type+
                "\n title: " + title +
                "\n url: " + url;

    }

}
