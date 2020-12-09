package org.academiadecodigo.hackaton.persistence.model.entertainment;

import javax.persistence.Entity;

@Entity
public class Nature extends Entertainment {

    @Override
    public EntertainmentType getEntertainmentType() {
        return EntertainmentType.NATURE;
    }
}
