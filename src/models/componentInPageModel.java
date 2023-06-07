package models;

import library.utilities.eav.models.attributeModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class componentInPageModel implements nestedComponentModel {

    private attributeModel overrideAttribute;
    private Date startDate;
    private Date endDate;
    private boolean visible;

    private pageRegionModel pageRegion;
    private componentModel component;

    public boolean  manageView() {
        boolean isDeleted = false;

        return isDeleted;
    }

    public componentModel getComponent() {
        return component;
    }

    public void setComponent(componentModel component) {
        this.component = component;
    }

    public pageRegionModel getPageRegion() {
        return pageRegion;
    }

    public void setPageRegion(pageRegionModel pageRegion) {
        this.pageRegion = pageRegion;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date startDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean getVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
