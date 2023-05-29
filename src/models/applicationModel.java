package models;

import library.utilities.eav.models.attributeSetModel;
import library.utilities.eav.models.entityModel;
import library.utilities.eav.models.userModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class applicationModel implements seoDataModel, entityModel {
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

    private Image logo;
    private String slogan;
    private List<viewModel> viewModelList;
    private List<pageModel> pageModelList;
    private List<componentInPageModel> componentInPageModelList;
    private List<attributeSetModel> sattributeSetModelList;

    public applicationModel() {
        this.viewModelList = new ArrayList<>();
        this.pageModelList = new ArrayList<>();
        this.componentInPageModelList = new ArrayList<>();
    }
    public void addAttributesSet(attributeSetModel attributeSet) {
        this.sattributeSetModelList.add(attributeSet);
    }

    public void removeAttributesSet(attributeSetModel attributeSet) {
        this.sattributeSetModelList.remove(attributeSet);
    }

    public List<pageModel> getPageModelList(){
        return pageModelList;
    }
    public List<viewModel> getViewModelList(){
        return viewModelList;
    }
    public List<componentInPageModel> getComponentInPageModelList(){
        return componentInPageModelList;
    }
    public List<attributeSetModel> getSattributeSetModelList(){
        return sattributeSetModelList;
    }

    public void addViewModel(viewModel view) {
        this.viewModelList.add(view);
    }

    public void removeViewModel(viewModel view) {
        this.viewModelList.remove(view);
    }

    public void addComponentInPageModel(componentInPageModel componentInPage) {
        this.componentInPageModelList.add(componentInPage);
    }

    public void removeComponentInPageModel(componentInPageModel componentInPage) {
        this.componentInPageModelList.remove(componentInPage);
    }

    public void addPageModel(pageModel page) {
        this.pageModelList.add(page);
    }

    public void removePageModel(pageModel page) {
        this.pageModelList.remove(page);
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
