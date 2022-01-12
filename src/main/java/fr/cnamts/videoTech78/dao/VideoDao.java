package fr.cnamts.videoTech78.dao;

import fr.cnamts.videoTech78.domaine.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoDao implements IDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Video getVideoById(int id) {
	return (Video) jdbcTemplate.queryForObject("SELECT * FROM video WHERE id="+id, (resultSet, rowNum) -> {
		return new Video(resultSet.getInt("id"), resultSet.getString("titre"), resultSet.getString("genre"),
				resultSet.getString("durree"), resultSet.getString("dateSortie"));
		});
    }

    public void createVideo(Video video) {

        String insertRequest = "INSERT INTO video(titre, genre, durree, dateSortie) VALUES(?, ?, ?, ?)";

        jdbcTemplate.update(insertRequest, video.getTitre(), video.getGenre(), video.getDurree(), video.getDateSortie() );

        System.out.println("Video : " + video.getTitre() + "à été créer avec succès ! ");
    }

    public Video updateVideo(Video video) {
        
        String insertRequest = "Update video SET titre = ?, genre= ?, durree = ?, dateSortie = ?, where video.id = ? ";

        jdbcTemplate.update(insertRequest, video.getTitre(), video.getGenre(), video.getDurree(), video.getDateSortie(), video.getId() );

        System.out.println("Video : " + video.getTitre() + " à été modifier avec succès ! ");

        return video;
        
    }

    public void deleteVideo(Video video) {

        String insertRequest = "Update video SET titre = ?, genre= ?, durree = ?, dateSortie = ?, where video.id = ? ";

        jdbcTemplate.update(insertRequest, video.getTitre(), video.getGenre(), video.getDurree(), video.getDateSortie(), video.getId() );

        System.out.println("Video : " + video.getTitre() + " à été supprimé avec succès ! ");

    }

    public List<Video> getAllVideo() {
        /*String query = "select titre from video";
        return jdbcTemplate.queryForList(query, Video.class);*/
        System.out.println("DAO: récupération de tous les video");

        return jdbcTemplate.query("SELECT * FROM video", (resultSet, rowNum) -> {
            return new Video(resultSet.getInt("id"), resultSet.getString("titre"), resultSet.getString("genre"),
                    resultSet.getString("durree"), resultSet.getString("dateSortie"));
        });
    }


    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }


}
