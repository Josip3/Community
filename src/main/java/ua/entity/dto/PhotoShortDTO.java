package ua.entity.dto;

import lombok.Getter;
import lombok.Setter;
import ua.entity.enums.TypePhoto;

import javax.persistence.Enumerated;

public class PhotoShortDTO {

    protected int id;
    protected String photoURL;
    @Enumerated
    protected TypePhoto typePhoto;

    public int getId() {
        return id;
    }

    public PhotoShortDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public PhotoShortDTO setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
        return this;
    }

    public TypePhoto getTypePhoto() {
        return typePhoto;
    }

    public PhotoShortDTO setTypePhoto(TypePhoto typePhoto) {
        this.typePhoto = typePhoto;
        return this;
    }

    @Override
    public String toString() {
        return "PhotoShortDTO{" +
                "id=" + id +
                ", photoURL='" + photoURL + '\'' +
                ", typePhoto=" + typePhoto +
                '}';
    }
}
