package ua.entity.dto;

public class GroupShortDTO {
    protected String nameGroup;
    protected int idMusic;
    protected int id;

    public String getNameGroup() {
        return nameGroup;
    }

    public GroupShortDTO setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
        return this;
    }

    public int getIdMusic() {
        return idMusic;
    }

    public GroupShortDTO setIdMusic(int idMusic) {
        this.idMusic = idMusic;
        return this;
    }

    public int getId() {
        return id;
    }

    public GroupShortDTO setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "GroupShortDTO{" +
                "nameGroup='" + nameGroup + '\'' +
                ", idMusic=" + idMusic +
                ", id=" + id +
                '}';
    }
}
