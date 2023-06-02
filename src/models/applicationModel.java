package models;

import library.utilities.eav.models.attributeSetModel;
import library.utilities.eav.models.entityModel;
import library.utilities.eav.models.userModel;
import service.serviceApplication;

import java.awt.*;
import java.util.*;
import java.util.List;

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
    private List<entityModel> viewModelList;
    private List<pageModel> pageModelList;
    private List<componentInPageModel> componentInPageModelList;
    private List<attributeSetModel> sattributeSetModelList;

    public applicationModel() {
        this.viewModelList = new ArrayList<>();
        this.pageModelList = new ArrayList<>();
        this.componentInPageModelList = new ArrayList<>();
        this.sattributeSetModelList = new ArrayList<>();
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
    public List<entityModel> getViewModelList(){
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


    public void showAllView(){
       int index = 0;
        for (entityModel view: this.viewModelList) {
            System.out.println("        " +index + view.getTitle());
        }
    }

    public void showAppMenu(){
        serviceApplication.showApplicationDetail(this);
        System.out.println("Que souhaitez vous faire.");
        System.out.println("               ");
        System.out.println("        1 - Ajouter, consulter ou supprimer une Vue");
        System.out.println("        2 - Ajouter, consulter ou supprimer un composant");
        System.out.println("        3 - Ajouter, consulter ou supprimer une page");
        System.out.println("        4 - Ajouter, consulter ou supprimer un attribut");
        System.out.println("         Tapez q pour quitter ");
        System.out.println("         Tapez s pour supprimer ");
        System.out.println("               ");
    }
    public boolean manageApplication(userModel user){
        Scanner answer = new Scanner(System.in);
        showAppMenu();
        String res;
        boolean isTrue = true;
        boolean isDeleted = false;
        while (isTrue){
            System.out.print("Entrez votre reponse : ");
            res = answer.nextLine();
            switch (res){
                case "1":
                    serviceApplication.createShow("CRUD VUES");
                    if (viewModelList.isEmpty()){
                        serviceApplication.createShow1("Aucune vue disponible");
                        System.out.println("    c - pour creer ");
                        System.out.println("    * - pour retourner ");
                        boolean isAnsVue = true;
                        while (isAnsVue){
                            res = answer.nextLine();
                            switch (res){

                                case "c":
                                    serviceApplication.createShow("Create New View");
                                    entityModel newView = new viewModel();
                                    System.out.print("    entrer le title : ");
                                    res = answer.nextLine();
                                    newView.setTitle(res);
                                    System.out.print("    entrer la description : ");
                                    res = answer.nextLine();
                                    newView.setTitle(res);
                                    newView.setCreatedBy(user);
                                    newView.setCreatedAt(new Date());
                                    newView.setUpdatedAt(new Date());
                                    newView.setUpdatedBy(user);
                                    serviceApplication.createShow1("Voulez vous enregistrer cette nouvelle Vue ? y/n");
                                    boolean isStatus = true;
                                    while (isStatus) {
                                        System.out.print("Entrez votre reponse : ");
                                        res = answer.nextLine();
                                        switch (res) {
                                            case "y":
                                                System.out.println(" ");
                                                viewModelList.add(newView);
                                                System.out.println("Vue creee avec succes  : ");
                                                serviceApplication.createShow1("Taper entrer pour continuer vers le menu pricipale");
                                                isStatus = false;
                                                break;
                                            case "n":
                                                serviceApplication.createShow1("Tapez entrer pour continuer vers le menu principale : ");
                                                isStatus = false;
                                                break;
                                            default:
                                                serviceApplication.createShow1("Commande invalide tapez y/n");
                                                break;
                                        }
                                    }
                                    answer.nextLine();
                                    showAppMenu();
                                    isAnsVue = false;

                                    break;
                                case "*":
                                    showAppMenu();
                                    isAnsVue = false;
                                    break;
                                default:
                                    serviceApplication.createShow1("Commande invalide");
                                    break;
                            }
                        }

                    }else{
                        long _indexCount = viewModelList.stream().count();
                        int index = 0;
                        for (entityModel view : viewModelList) {
                            System.out.println(index + " : " + view.getTitle());
                            index++;
                        }
                        System.out.println("tape c to create");
                        System.out.println("tape * to return");
                        int _ans = 99999999;
                        boolean isQuit = false;
                        do {
                            System.out.print("entrez un nombre : ");
                            String ans = answer.nextLine();
                            switch (ans) {
                                case "c":
                                    serviceApplication.createShow("Create New View");
                                    entityModel newView = new viewModel();
                                    System.out.print("    entrer le title : ");
                                    res = answer.nextLine();
                                    newView.setTitle(res);
                                    System.out.print("    entrer la description : ");
                                    res = answer.nextLine();
                                    newView.setTitle(res);
                                    newView.setCreatedBy(user);
                                    newView.setCreatedAt(new Date());
                                    newView.setUpdatedAt(new Date());
                                    newView.setUpdatedBy(user);
                                    serviceApplication.createShow1("Voulez vous enregistrer cette nouvelle Vue ? y/n");
                                    boolean isStatus = true;
                                    while (isStatus) {
                                        System.out.print("Entrez votre reponse : ");
                                        res = answer.nextLine();
                                        switch (res) {
                                            case "y":
                                                System.out.println(" ");
                                                viewModelList.add(newView);
                                                System.out.println("Vue creee avec succes  : ");
                                                serviceApplication.createShow1("Taper entrer pour continuer vers le menu pricipale");
                                                isStatus = false;
                                                break;
                                            case "n":
                                                serviceApplication.createShow1("Tapez entrer pour continuer vers le menu principale : ");
                                                isStatus = false;
                                                break;
                                            default:
                                                serviceApplication.createShow1("Commande invalide tapez y/n");
                                                break;
                                        }
                                    }
                                    answer.nextLine();
                                    showAppMenu();
                                    isQuit = true;
                                    break;
                                case "*":
                                    showAppMenu();
                                    isQuit = true;
                                    break;
                                default:
                                    try {
                                        _ans = Integer.parseInt(ans);
                                        if (_ans > _indexCount - 1) {
                                            serviceApplication.createShow1("Commande incorrect");
                                        } else {
                                            entityModel _viewModel = (viewModel) viewModelList.get(_ans);

                                            serviceApplication.createShow1(_viewModel.getTitle());
                                            boolean status = ((viewModel) _viewModel).manageView();
                                            if (!status) {
                                                serviceApplication.createShow1("Voulez vous enregistrer les modification ? y/n");
                                                System.out.print(" : ");
                                                 res = answer.nextLine();
                                                boolean isValidate = true;
                                                while (isValidate) {
                                                    switch (res) {
                                                        case "y":
                                                            viewModelList.set(_ans, _viewModel);
                                                            serviceApplication.createShow("Vue mise a jour avec succes");
                                                            answer.nextLine();
                                                            isValidate = false;
                                                            break;
                                                        case "n":
                                                            serviceApplication.createShow1("Modifications annulees");
                                                            answer.nextLine();
                                                            isValidate = false;
                                                            break;
                                                        default:
                                                            serviceApplication.createShow1("Commande invalide");
                                                            break;
                                                    }
                                                }
                                                answer.nextLine();
                                                showAppMenu();
                                                isQuit = true;
                                            } else {
                                                viewModelList.remove(_ans);
                                                serviceApplication.createShow("Vue supprimee avec succes");
                                                serviceApplication.createShow1("Taper entre pour continuer");
                                                answer.nextLine();
                                                showAppMenu();
                                                isQuit = true;

                                            }
                                        }

                                    } catch (NumberFormatException e) {
                                        serviceApplication.createShow1("Commande incorrect");
                                    }
                                    break;
                            }

                        } while (!isQuit);
                    }

//                    isTrue = false;
                    break;
                case "2":

                    isTrue = false;
                    break;
                case "3":

                    isTrue = false;
                    break;
                case "4":

                    isTrue = false;
                    break;
                case "q":

                    isTrue = false;
                    break;
                case "s" :
                   serviceApplication.createShow1("Voulez vous vraiment supprimer cette App ? yes/no");
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
                               showAppMenu();
                               break;
                           default:
                               serviceApplication.createShow1("Commande invalide");
                               break;
                       }
                   }
                    isDeleted = true;
                    break;
                default:
                    serviceApplication.createShow1("Commande invalide");
                    break;
            }
        }
        return isDeleted;
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
