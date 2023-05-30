package service;

import library.utilities.eav.models.entityModel;
import models.applicationModel;
import models.nestedComponentModel;


public class serviceApplication {
    public static void startSetup() {
        System.out.println("Pour commencer vous devez configurer \n votre profil");
        System.out.println("               ");
        System.out.println("        1 - config");
        System.out.println("        2 - exit");
        System.out.println("               ");

    }

    public static void menuSetup() {
        System.out.println("Que souhaitez vous faire.");
        System.out.println("               ");
        System.out.println("        1 - Creer une application");
        System.out.println("        2 - Consulter les details d'une applications");
        System.out.println("        3 - Consulter les vues d'une application");
        System.out.println("        4 - Consulter les pages d'une application");
        System.out.println("        5 - Consulter les composants d'une application");
        System.out.println("         Tapez q pour quitter ");
        System.out.println("               ");

    }

    public static void bienvenuShow() {
        System.out.println("                ");
        System.out.println("                ");
        System.out.println("                ");
        System.out.println("                *************************************************");
        System.out.println("                *                                               *");
        System.out.println("                *          BIENVENU DANS LE MODULE CMS          *");
        System.out.println("                *                                               *");
        System.out.println("                *************************************************");
        System.out.println("                ");
        System.out.println("                ");
        System.out.println("                ");
    }

    public static void succesShow() {
        System.out.println("               ");
        System.out.println("               ********************************");
        System.out.println("              Information mise jour avec succes");
        System.out.println("               ********************************");
        System.out.println("               ");
        System.out.println("               ");
    }

    public static void createShow(String title) {
        System.out.println("               ");
        System.out.println("********************************");
        System.out.println("" + title);
        System.out.println("********************************");
        System.out.println("               ");
    }

    public static void createShow1(String title) {
        System.out.println(">>>>>> " + title);
    }

    public static void showApplicationDetail(applicationModel application) {
        createShow("Application detail");
        System.out.println("Slug : " + application.getSlug());
        System.out.println("Title : " + application.getTitle());
        System.out.println("Description : " + application.getDescription());
        createShow(" Pages");
        if (application.getPageModelList().isEmpty()) {
            createShow1("Rien pour l'instant");
        } else {
            int index = 0;
            for (entityModel page : application.getPageModelList()) {
                System.out.println(index + " : " + page.getTitle());
                index++;
            }
        }
        createShow(" Vues");
        if (application.getViewModelList().isEmpty()) {
            createShow1("Rien pour l'instant");
        } else {
            int index = 0;
            for (entityModel page : application.getViewModelList()) {
                System.out.println(index + " : " + page.getTitle());
                index++;
            }
        }
        createShow(" Composant");
        if (application.getComponentInPageModelList().isEmpty()) {
            createShow1("Rien pour l'instant");
        } else {
            int index = 0;
            for (nestedComponentModel page : application.getComponentInPageModelList()) {
                System.out.println(index + " : " + page.getStartDate());
                index++;
            }
        }
        createShow("Attributs");
        if (application.getSattributeSetModelList().isEmpty()) {
            createShow1("Rien pour l'instant");
        } else {
            int index = 0;
            for (entityModel page : application.getSattributeSetModelList()) {
                System.out.println(index + " : " + page.getTitle());
                index++;
            }
        }
    }

    public static void showApplicationOptionDetail(applicationModel application, String type) {
       // createShow("Application detail");
        System.out.println("Slug : " + application.getSlug());
        System.out.println("Title : " + application.getTitle());
        System.out.println("Description : " + application.getDescription());
        switch (type) {
            case "pages":
                createShow(" Pages");
                if (application.getPageModelList().isEmpty()) {
                    createShow1("Rien pour l'instant");
                } else {
                    int index = 0;
                    for (entityModel page : application.getPageModelList()) {
                        System.out.println(index + " : " + page.getTitle());
                        index++;
                    }
                }
                break;
            case "vues":
                createShow(" Vues");
                if (application.getViewModelList().isEmpty()) {
                    createShow1("Rien pour l'instant");
                } else {
                    int index = 0;
                    for (entityModel page : application.getViewModelList()) {
                        System.out.println(index + " : " + page.getTitle());
                        index++;
                    }
                }
                break;
            case "composants":
                createShow(" Composants");
                if (application.getComponentInPageModelList().isEmpty()) {
                    createShow1("Rien pour l'instant");
                } else {
                    int index = 0;
                    for (nestedComponentModel page : application.getComponentInPageModelList()) {
                        System.out.println(index + " : " + page.getStartDate());
                        index++;
                    }
                }
                break;
            case "Attributs":
                createShow("Attributs");
                if (application.getSattributeSetModelList().isEmpty()) {
                    createShow1("Rien pour l'instant");
                } else {
                    int index = 0;
                    for (entityModel page : application.getSattributeSetModelList()) {
                        System.out.println(index + " : " + page.getTitle());
                        index++;
                    }
                }
                break;
        }
    }

}
