package fr.cnamts.videoTech78.service;

import fr.cnamts.videoTech78.dao.IDao;
import fr.cnamts.videoTech78.domaine.Video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private IDao iDao;

    public VideoService() {
        super();
    }

    public VideoService(IDao iDao) {
        super();
        this.iDao = iDao;
    }

    public Video recuperationVideo(int id) {
        System.out.println("SERVICE: récupération d'une video id=" + id);

        Video videoRetour = iDao.getVideoById(id);
        return videoRetour;
    }

    public void creerVideo(Video video) {
        System.out.println("SERVICE: création d'une video " + video.toString());

        iDao.createVideo(video);
    }

    public Video mettreAJourVideo(Video video) {
        System.out.println("SERVICE: mise à jour d'une video " + video.toString());

        Video videoRetour = iDao.updateVideo(video);
        return videoRetour;
    }

    public void supprimerVideo(Video video) {
        System.out.println("SERVICE: suppression d'une video " + video.toString());

        iDao.deleteVideo(video);
    }

    public List<Video> recuperationVideoListe() {
        System.out.println("SERVICE: récupération de tous les videos");

        List<Video> videoListeRetour = iDao.getAllVideo();
        return videoListeRetour;
    }

    public void comparaisonVideo(Video v1, Video v2) {
        System.out.println("SERVICE: comparaison entre deux video");
    }

    public IDao getiDao() {
        return iDao;
    }

    public void setiDao(IDao iDao) {
        this.iDao = iDao;
    }

    public void initialisation() {
        System.out.println("SERVICE: creation spring");
    }

    public void destruction() {
        System.out.println("SERVICE: destruction spring");
    }

}
