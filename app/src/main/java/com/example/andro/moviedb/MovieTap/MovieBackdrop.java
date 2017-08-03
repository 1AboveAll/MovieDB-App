package com.example.andro.moviedb.MovieTap;

import java.io.Serializable;

/**
 * Created by andro on 28-07-2017.
 */

public class MovieBackdrop implements Serializable{


    private String file_path;

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
