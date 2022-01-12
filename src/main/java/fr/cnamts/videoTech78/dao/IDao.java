package fr.cnamts.videoTech78.dao;

import fr.cnamts.videoTech78.domaine.Video;

import java.util.List;

public interface IDao {
    Video getVideoById(int id);

    void createVideo(Video video);

    Video updateVideo(Video video);

    void deleteVideo(Video video);

    List<Video> getAllVideo();
}
