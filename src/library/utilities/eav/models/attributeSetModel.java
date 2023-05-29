package library.utilities.eav.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class attributeSetModel implements entityModel {
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
    private boolean shareable;
    private List<attributeOptionModel> attributeOptionModelList;

    public attributeSetModel(String title, String description, boolean shareable) {
        this.title = title;
        this.description = description;
        this.shareable = shareable;
        this.attributeOptionModelList = new ArrayList<>();
        this.deletedBy = new userModel("", "");
        this.updatedBy = new userModel("","");
        this.createdBy = new userModel("","");
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.deletedAt = new Date();
    }

    public void addAttributeOptionModel(attributeOptionModel attributeOption){
        this.attributeOptionModelList.add(attributeOption);
    }
    public void removeAttributeOption(attributeOptionModel attributeOption){
        this.attributeOptionModelList.remove(attributeOption);
    }

    public boolean isShareable() {
        return shareable;
    }

    public void setShareable(boolean shareable) {
        this.shareable = shareable;
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
