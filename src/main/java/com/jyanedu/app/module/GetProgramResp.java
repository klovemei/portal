package com.jyanedu.app.module;

import com.jyanedu.app.beans.Movie;
import com.jyanedu.app.beans.Program;

import java.util.List;

/**
 * Created by liu_kai on 2018/2/2.
 */
public class GetProgramResp extends BaseResp{
    private Program program;
    private Movie currMovie;
    private List<Movie> movies;

    public Movie getCurrMovie() {
        return currMovie;
    }

    public void setCurrMovie(Movie currMovie) {
        this.currMovie = currMovie;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
