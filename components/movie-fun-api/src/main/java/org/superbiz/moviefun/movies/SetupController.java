package org.superbiz.moviefun.movies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.superbiz.moviefun.movies.albumsapi.AlbumFixtures;
import org.superbiz.moviefun.movies.albumsapi.AlbumInfo;
import org.superbiz.moviefun.movies.albumsapi.AlbumsClient;
import org.superbiz.moviefun.movies.moviesapi.MovieFixtures;
import org.superbiz.moviefun.movies.moviesapi.MovieInfo;
import org.superbiz.moviefun.movies.moviesapi.MoviesClient;


import java.util.Map;

@Controller
@RequestMapping("/setup")
public class SetupController {

    private final MoviesClient moviesClient;
    private final AlbumsClient albumsClient;
    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

    public SetupController(MoviesClient moviesClient, AlbumsClient albumsClient, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
        this.moviesClient = moviesClient;
        this.albumsClient = albumsClient;
        this.movieFixtures = movieFixtures;
        this.albumFixtures = albumFixtures;
    }

    @GetMapping
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesClient.addMovie(movie);
        }

        for (AlbumInfo album : albumFixtures.load()) {
            albumsClient.addAlbum(album);
        }

        model.put("movies", moviesClient.getMovies());
        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }
}
