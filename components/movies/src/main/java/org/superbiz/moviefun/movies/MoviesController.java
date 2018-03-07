package org.superbiz.moviefun.movies;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private MoviesBean moviesRepo;

    public MoviesController(MoviesBean moviesRepository) {
        this.moviesRepo = moviesRepository;
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        moviesRepo.addMovie(movie);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovieId(@PathVariable Long movieId) {
        moviesRepo.deleteMovieId(movieId);
    }

    @GetMapping("/count")
    public int count(
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "key", required = false) String key
    ) {
        if (field != null && key != null) {
            return moviesRepo.count(field, key);
        } else {
            return moviesRepo.countAll();
        }
    }

    @GetMapping
    public List<Movie> find(
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "key", required = false) String key,
            @RequestParam(name = "start", required = false) Integer start,
            @RequestParam(name = "pageSize", required = false) Integer pageSize
    ) {
        if (field != null && key != null) {
            return moviesRepo.findRange(field, key, start, pageSize);
        } else if (start != null && pageSize != null) {
            return moviesRepo.findAll(start, pageSize);
        } else {
            return moviesRepo.getMovies();
        }
    }
}