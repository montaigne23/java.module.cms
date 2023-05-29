package models;

import java.util.ArrayList;
import java.util.List;

public class pageModel extends viewModel {
    private List<pageRegionModel> pageRegionModelList;
    private List<componentInPageModel> componentInPageModelList;
    pageModel(){
        this.pageRegionModelList = new ArrayList<>();
        this.componentInPageModelList = new ArrayList<>();
    }

    public void addPageRegion(pageRegionModel pageRegion){
        this.pageRegionModelList.add(pageRegion);
    }
    public void removePageRegion(pageRegionModel pageRegion){
        this.pageRegionModelList.remove(pageRegion);
    }

    public void addComponentInPage(componentInPageModel componentInPage){
        this.componentInPageModelList.add(componentInPage);
    }
    public void removeComponentInPage(componentInPageModel componentInPage){
        this.componentInPageModelList.remove(componentInPage);
    }
}
