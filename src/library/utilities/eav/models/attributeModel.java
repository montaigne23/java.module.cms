package library.utilities.eav.models;

import library.utilities.eav.enumeration.attributeType;

import java.util.Date;
import java.util.UUID;

public class attributeModel implements entityModel {
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
    private attributeType type;
    private boolean inherited;
    private boolean requiredValue;
    private boolean multipleValues;
    private boolean freezeValues;
    private boolean overridden;
    private boolean shareable;
    private boolean shared;
    private boolean measurable;
    private boolean isEntityDedicated;
    private attributeValueModel attributeValue;
    public attributeModel() {
        this.inherited = false;
        this.requiredValue = false;
        this.multipleValues = false;
        this.freezeValues = false;
        this.overridden = false;
        this.shareable = false;
        this.shared = false;
        this.measurable = false;
        this.isEntityDedicated = false;
        this.attributeValue = new attributeValueModel("", true, "", "");
    }

    public attributeType getType() {
        return type;
    }

    public void setType(attributeType type) {
        this.type = type;
    }

    public attributeValueModel getAttributeValue() {
        return attributeValue;
    }

    public void setType(attributeValueModel attributeValue) {
        this.attributeValue = attributeValue;
    }

    public boolean isInherited() {
        return inherited;
    }

    public void setInherited(boolean inherited) {
        this.inherited = inherited;
    }

    public boolean isRequiredValue() {
        return requiredValue;
    }

    public void setRequiredValue(boolean requiredValue) {
        this.requiredValue = requiredValue;
    }

    public boolean isMultipleValues() {
        return multipleValues;
    }

    public void setMultipleValues(boolean multipleValues) {
        this.multipleValues = multipleValues;
    }

    public boolean isFreezeValues() {
        return freezeValues;
    }

    public void setFreezeValues(boolean freezeValues) {
        this.freezeValues = freezeValues;
    }

    public boolean isOverridden() {
        return overridden;
    }

    public void setOverridden(boolean overridden) {
        this.overridden = overridden;
    }

    public boolean isShareable() {
        return shareable;
    }

    public void setShareable(boolean shareable) {
        this.shareable = shareable;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public boolean isMeasurable() {
        return measurable;
    }

    public void setMeasurable(boolean measurable) {
        this.measurable = measurable;
    }

    public boolean isEntityDedicated() {
        return isEntityDedicated;
    }

    public void setEntityDedicated(boolean entityDedicated) {
        isEntityDedicated = entityDedicated;
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
