package models;

import library.utilities.eav.models.attributeSetModel;
import library.utilities.eav.models.entityModel;
import library.utilities.eav.models.userModel;
import service.serviceApplication;

import java.awt.*;
import java.time.format.DateTimeParseException;
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
    private List<entityModel> pageModelList;
    private List<nestedComponentModel> componentInPageModelList;
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

    public List<entityModel> getPageModelList() {
        return pageModelList;
    }

    public List<entityModel> getViewModelList() {
        return viewModelList;
    }

    public List<nestedComponentModel> getComponentInPageModelList() {
        return componentInPageModelList;
    }

    public List<attributeSetModel> getSattributeSetModelList() {
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


    public void showAllView() {
        int index = 0;
        for (entityModel view : this.viewModelList) {
            System.out.println("        " + index + view.getTitle());
        }
    }

    public void showAppMenu() {
        serviceApplication.showApplicationDetail(this);
        System.out.println("Que souhaitez vous faire.");
        System.out.println("               ");
        System.out.println("        1 - Ajouter, consulter ou supprimer une Vue");
        System.out.println("        2 - Ajouter, consulter ou supprimer une page");
        System.out.println("        3 - Ajouter, consulter ou supprimer un composant");
        System.out.println("        4 - Ajouter, consulter ou supprimer un attribut");
        System.out.println("         Tapez q pour quitter ");
        System.out.println("         Tapez s pour supprimer ");
        System.out.println("               ");
    }

    public boolean manageApplication(userModel user) {
        Scanner answer = new Scanner(System.in);
        showAppMenu();
        String res;
        boolean isTrue = true;
        boolean isDeleted = false;
        while (isTrue) {
            System.out.print("Entrez votre reponse : ");
            res = answer.nextLine();
            switch (res) {
                case "1":
                    manageView(user);
                    // isTrue = false;
                    break;
                case "2":
                    managePage(user);
                    //isTrue = false;
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
                case "s":
                    serviceApplication.createShow1("Voulez vous vraiment supprimer cette App ? yes/no");
                    System.out.print(" : ");
                    res = answer.nextLine();
                    boolean isShooce = true;
                    while (isShooce) {
                        switch (res) {
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

    public void manageView(userModel user) {
        Scanner answer = new Scanner(System.in);
        String res;
        serviceApplication.createShow("CRUD VUES");
        if (viewModelList.isEmpty()) {
            serviceApplication.createShow1("Aucune vue disponible");
            System.out.println("    c - pour creer ");
            System.out.println("    * - pour retourner ");
            boolean isAnsVue = true;
            while (isAnsVue) {
                res = answer.nextLine();
                switch (res) {

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

        } else {
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
    }

    public void managePage(userModel user) {
        Scanner answer = new Scanner(System.in);
        String res;
        serviceApplication.createShow("CRUD Pages");
        if (pageModelList.isEmpty()) {
            serviceApplication.createShow1("Aucune page disponible");
            System.out.println("    c - pour creer ");
            System.out.println("    * - pour retourner ");
            boolean isAnsVue = true;
            while (isAnsVue) {
                res = answer.nextLine();
                switch (res) {

                    case "c":
                        serviceApplication.createShow("Create New View");
                        entityModel newPage = new pageModel();
                        System.out.print("    entrer le title : ");
                        res = answer.nextLine();
                        newPage.setTitle(res);
                        System.out.print("    entrer la description : ");
                        res = answer.nextLine();
                        newPage.setTitle(res);
                        newPage.setCreatedBy(user);
                        newPage.setCreatedAt(new Date());
                        newPage.setUpdatedAt(new Date());
                        newPage.setUpdatedBy(user);
                        serviceApplication.createShow1("Voulez vous enregistrer cette nouvelle Vue ? y/n");
                        boolean isStatus = true;
                        while (isStatus) {
                            System.out.print("Entrez votre reponse : ");
                            res = answer.nextLine();
                            switch (res) {
                                case "y":
                                    System.out.println(" ");
                                    pageModelList.add(newPage);
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

        } else {
            long _indexCount = pageModelList.stream().count();
            int index = 0;
            for (entityModel page : pageModelList) {
                System.out.println(index + " : " + page.getTitle());
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
                        serviceApplication.createShow("Create New Page");
                        entityModel newPage = new pageModel();
                        System.out.print("    entrer le title : ");
                        res = answer.nextLine();
                        newPage.setTitle(res);
                        System.out.print("    entrer la description : ");
                        res = answer.nextLine();
                        newPage.setTitle(res);
                        newPage.setCreatedBy(user);
                        newPage.setCreatedAt(new Date());
                        newPage.setUpdatedAt(new Date());
                        newPage.setUpdatedBy(user);
                        serviceApplication.createShow1("Voulez vous enregistrer cette nouvelle Page ? y/n");
                        boolean isStatus = true;
                        while (isStatus) {
                            System.out.print("Entrez votre reponse : ");
                            res = answer.nextLine();
                            switch (res) {
                                case "y":
                                    System.out.println(" ");
                                    pageModelList.add(newPage);
                                    System.out.println("Page creee avec succes  : ");
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
//                        answer.nextLine();
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
                                entityModel _pageModel = (viewModel) pageModelList.get(_ans);

                                serviceApplication.createShow1(_pageModel.getTitle());
                                boolean status = ((pageModel) _pageModel).manageView();
                                if (!status) {
                                    serviceApplication.createShow1("Voulez vous enregistrer les modification ? y/n");
                                    System.out.print(" : ");
                                    res = answer.nextLine();
                                    boolean isValidate = true;
                                    while (isValidate) {
                                        switch (res) {
                                            case "y":
                                                pageModelList.set(_ans, _pageModel);
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
                                    pageModelList.remove(_ans);
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
    }

    public void manageComponent(userModel user) {
        Scanner answer = new Scanner(System.in);
        String res;
        serviceApplication.createShow("CRUD Pages");
        if (componentInPageModelList.isEmpty()) {
            serviceApplication.createShow1("Aucun composant disponible");
            System.out.println("    c - pour creer ");
            System.out.println("    * - pour retourner ");
            boolean isAnsVue = true;
            while (isAnsVue) {
                res = answer.nextLine();
                switch (res) {

                    case "c":
                        serviceApplication.createShow("Create New component");
                        nestedComponentModel newComponent = new componentInPageModel();
                        boolean isNotDate = true;

                        while (isNotDate) {
                            System.out.print("    entrer la date de debut au format yyyy-MM-dd : ");
                            try {
                                res = answer.nextLine();
                                Date startDate = new Date(res);
                                newComponent.setStartDate(startDate);
                                isNotDate = false;
                            } catch (DateTimeParseException e) {
                                serviceApplication.createShow1("forma de date invalide : yyyy-MM-dd est attendu");
                            }
                        }
                        while (isNotDate) {
                            System.out.print("    entrer la date de fin au format yyyy-MM-dd : ");
                            try {
                                res = answer.nextLine();
                                Date endDate = new Date(res);
                                newComponent.setEndDate(endDate);
                                isNotDate = false;
                            } catch (DateTimeParseException e) {
                                serviceApplication.createShow1("forma de date invalide : yyyy-MM-dd est attendu");
                            }
                        }

                        System.out.print("    Le composant sera t-il visible ?");
                        boolean isNotVisibleSet = true;

                        while (isNotVisibleSet) {
                            res = answer.nextLine();
                            switch (res) {
                                case "y":
                                    newComponent.setVisible(true);
                                    break;
                                case "n":
                                    newComponent.setVisible(false);
                                    break;
                                case "Y":
                                    newComponent.setVisible(true);
                                    break;
                                case "N":
                                    newComponent.setVisible(false);
                                    break;
                                default:
                                    serviceApplication.createShow1("Format incorrect : attendu, Y/y ou N/n");
                                    break;
                            }
                        }
                        componentModel component = new componentModel();
                        ((componentInPageModel) newComponent).setComponent(component);
                        serviceApplication.createShow1("Voulez vous enregistrer cette nouvelle Vue ? y/n");
                        boolean isStatus = true;
                        while (isStatus) {
                            System.out.print("Entrez votre reponse : ");
                            res = answer.nextLine();
                            switch (res) {
                                case "y":
                                    System.out.println(" ");
                                    componentInPageModelList.add(newComponent);
                                    System.out.println("Composant cree avec succes  : ");
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

        } else {
            long _indexCount = pageModelList.stream().count();
            int index = 0;
            for (entityModel page : pageModelList) {
                System.out.println(index + " : " + page.getTitle());
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
                        serviceApplication.createShow("Create New component");
                        nestedComponentModel newComponent = new componentInPageModel();
                        boolean isNotDate = true;

                        while (isNotDate) {
                            System.out.print("    entrer la date de debut au format yyyy-MM-dd : ");
                            try {
                                res = answer.nextLine();
                                Date startDate = new Date(res);
                                newComponent.setStartDate(startDate);
                                isNotDate = false;
                            } catch (DateTimeParseException e) {
                                serviceApplication.createShow1("forma de date invalide : yyyy-MM-dd est attendu");
                            }
                        }
                        while (isNotDate) {
                            System.out.print("    entrer la date de fin au format yyyy-MM-dd : ");
                            try {
                                res = answer.nextLine();
                                Date endDate = new Date(res);
                                newComponent.setEndDate(endDate);
                                isNotDate = false;
                            } catch (DateTimeParseException e) {
                                serviceApplication.createShow1("forma de date invalide : yyyy-MM-dd est attendu");
                            }
                        }

                        System.out.print("    Le composant sera t-il visible ?");
                        boolean isNotVisibleSet = true;

                        while (isNotVisibleSet) {
                            res = answer.nextLine();
                            switch (res) {
                                case "y":
                                    newComponent.setVisible(true);
                                    break;
                                case "n":
                                    newComponent.setVisible(false);
                                    break;
                                case "Y":
                                    newComponent.setVisible(true);
                                    break;
                                case "N":
                                    newComponent.setVisible(false);
                                    break;
                                default:
                                    serviceApplication.createShow1("Format incorrect : attendu, Y/y ou N/n");
                                    break;
                            }
                        }
                        componentModel component = new componentModel();
                        ((componentInPageModel) newComponent).setComponent(component);
                        serviceApplication.createShow1("Voulez vous enregistrer cette nouvelle Vue ? y/n");
                        boolean isStatus = true;
                        while (isStatus) {
                            System.out.print("Entrez votre reponse : ");
                            res = answer.nextLine();
                            switch (res) {
                                case "y":
                                    System.out.println(" ");
                                    componentInPageModelList.add(newComponent);
                                    System.out.println("Composant cree avec succes  : ");
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
                                nestedComponentModel _componentModel = (componentInPageModel) componentInPageModelList.get(_ans);

                                serviceApplication.createShow1(_componentModel.getStartDate().toString());
                                serviceApplication.createShow1(_componentModel.getEndDate().toString());
                                boolean status = ((componentInPageModel) _componentModel).manageView();
                                if (!status) {
                                    serviceApplication.createShow1("Voulez vous enregistrer les modification ? y/n");
                                    System.out.print(" : ");
                                    res = answer.nextLine();
                                    boolean isValidate = true;
                                    while (isValidate) {
                                        switch (res) {
                                            case "y":
                                                componentInPageModelList.set(_ans, _componentModel);
                                                serviceApplication.createShow("Composant mit a jour avec succes");
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
                                    pageModelList.remove(_ans);
                                    serviceApplication.createShow("Composant supprimee avec succes");
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
