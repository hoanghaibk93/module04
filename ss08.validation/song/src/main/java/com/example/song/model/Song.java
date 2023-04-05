package com.example.song.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "\\w+", message = "Bài hát không chưa ký tự đặc biệt")
    @Size(max = 800, message = "Độ dài bài hát không vượt quá 800 ký tự")
    private String name;
    @NotBlank(message = "không được để trống")
    @Size(max = 300, message = "Độ dài tên ca sỉ không vượt quá 300 ký tự")
    @Pattern(regexp = "\\w+", message = "Tên ca sĩ không chưa ký tự đặc biệt")

    private String singer;
    @NotBlank(message = "không được để trống")
    @Size(max = 1000, message = "Thể loại âm nhạc không vượt quá 1000 ký tự")
    @Pattern(regexp = "[\\w,]+", message = "Tên ca sĩ không chưa ký tự đặc biệt")

    private String type;

    public Song() {
    }

    public Song(Integer id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Song(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
