package com.eteration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by memojja on 04/07/2017.
 */

@Entity
public class Vote {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int point;

    public Vote(){}
    public Vote(int point) {
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
