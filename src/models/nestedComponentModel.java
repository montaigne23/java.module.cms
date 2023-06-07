package models;

import library.utilities.eav.models.attributeModel;

import java.util.Date;

public interface nestedComponentModel {

    public Date getStartDate();
    public void setStartDate(Date startDate);

    public Date getEndDate();
    public void setEndDate(Date startDate);
    public boolean getVisible();
    public void setVisible(boolean visible);
}
