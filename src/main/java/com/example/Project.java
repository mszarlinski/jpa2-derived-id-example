package com.example;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mszarlinski on 2016-02-03.
 */
@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    @OneToOne(mappedBy = "project")
    private ProjectLock projectLock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectLock getProjectLock() {
        return projectLock;
    }

    public void setProjectLock(ProjectLock projectLock) {
        this.projectLock = projectLock;
    }
}
