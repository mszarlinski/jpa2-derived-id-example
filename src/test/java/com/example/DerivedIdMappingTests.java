package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Jpa2DerivedIdExampleApplication.class)
public class DerivedIdMappingTests {

    @Autowired
    private ProjectLockRepository projectLockRepository;

	@Test
	public void shouldSaveActiveProjectLock() {
	    // given
        final Project project = new Project();
        project.setName("Example project");

        final ProjectLock projectLock = new ProjectLock(project);
        // when
        final ProjectLock savedLock = projectLockRepository.save(projectLock);
        // then
        assertThat(savedLock.getProject().getId()).isEqualTo(project.getId());

        // when
        final ProjectLock activeLock = projectLockRepository.findActiveByProjectId(project.getId());
        assertThat(activeLock.isActive()).isTrue();

	}
}
