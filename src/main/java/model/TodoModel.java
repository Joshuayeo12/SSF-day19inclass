package model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TodoModel {

    @NotEmpty (message = "ID cannot be empty")
    @Size(max = 50, message = "Max length is 50 characters")
    private String id;

    @NotEmpty (message = "Name cannot be empty")
    @Size(min = 10, max = 50, message = "size must be between 10 to 50 characters")
    private String name;

    @Size(max = 255, message = "Description has to be shorter than 255 characters")
    private String description;

    @FutureOrPresent (message = "Date has to be either in the future or the present")
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    @NotNull (message = "Please fill in field")
    private Date dueDate;

    private String priority;

    private String status;

    private Date createdAt;

    private Date updatedAt;


    public @Size(max = 50, message = "Max length is 50 characters") String getId() {
        return id;
    }

    public void setId(@Size(max = 50, message = "Max length is 50 characters") String id) {
        this.id = id;
    }

    public @Size(min = 10, max = 50) String getName() {
        return name;
    }

    public void setName(@Size(min = 10, max = 50) String name) {
        this.name = name;
    }

    public @Size(max = 250) String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 250) String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';

    }

    public TodoModel() {}

    public TodoModel(@NotEmpty (message = "ID cannot be empty") @Size(max = 50, message = "Max length is 50 characters") String id,
                     @NotEmpty (message = "Name cannot be empty") @Size(min = 10, max = 50, message = "size must be between 10 to 50 characters") String name,
                     @Size(max = 255, message = "Description has to be shorter than 255 characters") String description,
                     @FutureOrPresent (message = "Date has to be either in the future or the present") @DateTimeFormat (pattern = "yyyy-MM-dd") @NotNull (message = "Please fill in field")Date dueDate, String priorityLevel,
                     String status,

                     Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priorityLevel;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
