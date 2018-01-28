package ua.entity.dto;

public class MusicShortDTO {

    protected int id;
    protected String perfomerName;
    protected String trackName;
    protected String musicFile;

    public int getId() {
        return id;
    }

    public MusicShortDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getPerfomerName() {
        return perfomerName;
    }

    public MusicShortDTO setPerfomerName(String perfomerName) {
        this.perfomerName = perfomerName;
        return this;
    }

    public String getTrackName() {
        return trackName;
    }

    public MusicShortDTO setTrackName(String trackName) {
        this.trackName = trackName;
        return this;
    }

    public String getMusicFile() {
        return musicFile;
    }

    public MusicShortDTO setMusicFile(String musicFile) {
        this.musicFile = musicFile;
        return this;
    }

    @Override
    public String toString() {
        return "MusicShortDTO{" +
                "id=" + id +
                ", perfomerName='" + perfomerName + '\'' +
                ", trackName='" + trackName + '\'' +
                ", musicFile='" + musicFile + '\'' +
                '}';
    }
}
