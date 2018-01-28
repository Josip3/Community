package ua.entity.dto;

public class GanreMusicShortDTO {

    protected int id;

    protected String nameGanre;

    public int getId() {
        return id;
    }

    public GanreMusicShortDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getNameGanre() {
        return nameGanre;
    }

    public GanreMusicShortDTO setNameGanre(String nameGanre) {
        this.nameGanre = nameGanre;
        return this;
    }

    @Override
    public String toString() {
        return "GanreMusicShortDTO{" +
                "id=" + id +
                ", nameGanre='" + nameGanre + '\'' +
                '}';
    }
}

