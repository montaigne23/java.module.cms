package models;

import library.utilities.eav.models.attributeModel;

import java.util.ArrayList;
import java.util.List;

public class componentModel extends viewModel {
    private List<attributeModel> attributeModelList;
    private List<componentModel> componentModelList;
    private componentTypeModel componentType;

    componentModel(){
        this.attributeModelList = new ArrayList<>();
        this.componentModelList = new ArrayList<>();
    }
    public componentTypeModel getComponentType(){
        return componentType;
    }
    public void setComponentType(componentTypeModel componentType){
        this.componentType = componentType;
    }
    public void addAttribute(attributeModel attribute){
        this.attributeModelList.add(attribute);
    }
    public void removeAttribute(attributeModel attribute){
        this.attributeModelList.remove(attribute);
    }
    public void addComponent(componentModel component){
        this.componentModelList.add(component);
    }
    public void removeComponent(componentModel component){
        this.componentModelList.remove(component);
    }
}
