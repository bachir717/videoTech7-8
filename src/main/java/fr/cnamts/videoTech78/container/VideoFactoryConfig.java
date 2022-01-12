package fr.cnamts.videoTech78.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.cnamts.videoTech78.dao.VideoDao;
import fr.cnamts.videoTech78.service.VideoService;

@Configuration
@ComponentScan(basePackages = {"fr.cnamts.videoTech78"} )
public class VideoFactoryConfig {


   /* @Autowired
    VideoDao videoDao;
    @Bean
    public VideoService videoService() {
        return new VideoService(videoDao);
    }*/
  
}