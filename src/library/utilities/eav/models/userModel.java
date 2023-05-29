package library.utilities.eav.models;

import java.util.Date;
import java.util.UUID;

public class userModel implements entityModel {
    private UUID id;
    private String slug;
    private String title;
    private String description;
    private userModel createdBy;
    private Date createdAt;
    private Date updatedAt;
    private userModel updatedBy;
    private Date deletedAt;
    private userModel deletedBy;
    private String name;
    private String email;

    public userModel(String name, String email){
        this.name = name;
        this.email = email;
        this.createdAt = new Date();

    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }


    @Override
    public void setId(UUID slug) {
        this.id = id;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public void setSlug(String slug) {
        this.slug = slug;
    }
    @Override
    public String getSlug() {
        return this.slug;
    }
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String getTitle() {
        return this.title;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String getDescription() {
        return this.description;
    }
    @Override
    public void setCreatedBy(userModel createdBy) {
        this.createdBy = createdBy;
    }
    @Override
    public userModel getCreatedBy() {
        return this.createdBy;
    }
    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public Date getCreatedAt() {
        return this.createdAt;
    }
    @Override
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    @Override
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    @Override
    public void setUpdatedBy(userModel updatedBy) {
        this.updatedBy = updatedBy;
    }
    @Override
    public userModel getUpdatedBy() {
        return this.updatedBy;
    }
    @Override
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    @Override
    public Date getDeletedAt() {
        return deletedAt;
    }
    @Override
    public void setDeletedBy(userModel deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public userModel getDeletedBy() {
        return this.deletedBy;
    }

}
