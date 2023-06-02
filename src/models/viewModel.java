package models;

import library.utilities.eav.models.attributeSetModel;
import library.utilities.eav.models.entityModel;
import library.utilities.eav.models.userModel;
import service.serviceApplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class viewModel implements seoDataModel, entityModel {
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
    private List<attributeSetModel> seoAttributes;


    public void addAttributesSet(attributeSetModel attributeSet) {
        this.seoAttributes.add(attributeSet);
    }

    public void removeAttributesSet(attributeSetModel attributeSet) {
        this.seoAttributes.remove(attributeSet);
    }
        public void showMenu(){
            System.out.println("Que souhaitez vous faire.");
            System.out.println("               ");
            System.out.println("        1 - voir tous les attributs");
            System.out.println("        2 - Ajouter un attributs");
            System.out.println("         Tapez q pour quitter ");
            System.out.println("         Tapez s pour supprimer ");
            System.out.println("         Tapez m pour modifier ");
        }
    public boolean manageView(){
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
