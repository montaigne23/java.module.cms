package library.utilities.eav.models;
import java.util.UUID;

import java.util.Date;

public interface entityModel {

    UUID getId();

    void setId(UUID id);
    String getSlug();

    void setSlug(String slug);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    userModel getCreatedBy();

    void setCreatedBy(userModel createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    userModel getUpdatedBy();

    void setUpdatedBy(userModel updatedBy);

    Date getDeletedAt();

    void setDeletedAt(Date deletedAt);

    userModel getDeletedBy();

    void setDeletedBy(userModel deletedBy);

}
