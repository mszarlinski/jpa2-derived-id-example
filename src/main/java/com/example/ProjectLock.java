package com.example;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mszarlinski@cyfrowypolsat.pl on 2016-02-03.
 */
@Entity
public class ProjectLock implements Serializable {

    @Id
    @OneToOne
    private Project project;

    private boolean active;

    public ProjectLock() {
    }

    public ProjectLock(final Project project) {
        this.project = project;
        this.active = true;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
