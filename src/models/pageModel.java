package models;

import service.serviceApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pageModel extends viewModel {
    private List<pageRegionModel> pageRegionModelList;
    private List<componentInPageModel> componentInPageModelList;
    pageModel(){
        this.pageRegionModelList = new ArrayList<>();
        this.componentInPageModelList = new ArrayList<>();
    }
    public void showMenu(){
        System.out.println("Que souhaitez vous faire.");
        System.out.println("               ");
        System.out.println("        1 - voir toutes les regions");
        System.out.println("        2 - Ajouter une regions");
        System.out.println("         Tapez q pour quitter ");
        System.out.println("         Tapez s pour supprimer ");
        System.out.println("         Tapez m pour modifier ");
    }
    public boolean managePage(){
        Scanner answer = new Scanner(System.in);
        showMenu();
        String res;
        boolean isTrue = true;
        boolean isDeleted = false;
        while (isTrue){
            res = answer.nextLine();
            switch (res){
                case "1":

                    break;
                case "2":
                    break;
                case "s":
                    serviceApplication.createShow1("Voulez vous vraiment supprimer cette page ? yes/no");
                    System.out.print(" : ");
                    res = answer.nextLine();
                    boolean isShooce = true;
                    while (isShooce){
                        switch (res){
                            case "yes":
                                isDeleted = true;
                                isTrue = false;
                                isShooce = false;
                                break;
                            case "no":
                                isShooce = false;
                                showMenu();
                                break;
                            default:
                                serviceApplication.createShow1("Commande invalide");
                                break;
                        }
                    }
                    isDeleted = true;
                    break;
                case "q":
                    isTrue = false;
                    break;
                default:
                    serviceApplication.createShow1("Commande invalide");
                    break;
            }
        }
        return isDeleted;
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
