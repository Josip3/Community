package ua.entity.dto;

public class ContentTypeShortDTO {

    protected int id;

    protected String nameCategory;

    public int getId() {
        return id;
    }

    public ContentTypeShortDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public ContentTypeShortDTO setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
        return this;
    }

    @Override
    public String toString() {
        return "ContentTypeShortDTO{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
