package com.github.sansarch.freelance_adm_platform.project.domain.entity;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.project.domain.enums.ProjectStatus;
import com.github.sansarch.freelance_adm_platform.project.domain.exception.InvalidProjectException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void shouldCreateProject() {
        Project project = Project.builder()
                .title("Test Project")
                .description("This is a test project")
                .dueDate(LocalDateTime.now().plusDays(30))
                .budget(BigDecimal.valueOf(1000))
                .customerId(CustomerId.generate())
                .build();

        assertNotNull(project);
        assertNotNull(project.getId());
        assertEquals("Test Project", project.getTitle());
        assertEquals("This is a test project", project.getDescription());
        assertEquals(ProjectStatus.WAITING_PROPOSAL, project.getStatus());
        assertNotNull(project.getDeadLine());
        assertEquals(BigDecimal.valueOf(1000), project.getBudget());
    }

    @Test
    void shouldThrowExceptionWhenTitleIsEmpty() {
        Exception exception = assertThrows(InvalidProjectException.class, () -> {
            Project.builder()
                    .title("")
                    .description("This is a test project")
                    .dueDate(LocalDateTime.now().plusDays(30))
                    .budget(BigDecimal.valueOf(1000))
                    .customerId(CustomerId.generate())
                    .build();
        });

        String expectedMessage = "Project name cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}