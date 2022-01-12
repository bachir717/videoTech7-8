package fr.cnamts.videoTech78.launcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.cnamts.videoTech78.container.DataSourceConfig;
import fr.cnamts.videoTech78.domaine.Video;
import fr.cnamts.videoTech78.service.VideoService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Launcher {
	@Autowired
	static
	VideoService videoService;
    public static void main(String[] args) {
        

        

        
        /**/ 
        // 1. Chargement du conteneur  en 4.0.0 Spring
        //ConfigurableApplicationContext applicationContext =

        // 2. Recuperation d'un bean du conteneur
        /**/

		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		VideoService videoService = context.getBean(VideoService.class);

        // 3. Manipulation du bean avec injection de dependances
        Video v1 = new Video("Ville nouvelle 2", "Documentaire 2", "3.8", "20/30/2020");
        //videoService.creerVideo(v1);
        
      Video v2 = videoService.recuperationVideo(3);

        if (v2 != null) {
            System.out.println("LAUNCHER: Récuperation de la video réussie " + v2.toString());
        } else {
            System.out.println("LAUNCHER: Récuperation dela video échouée");
        }
        for (Video videoCourante : videoService.recuperationVideoListe()) {
            System.out.println(videoCourante.toString());
        }
    }
}
