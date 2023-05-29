package service;

import library.utilities.eav.models.entityModel;
import models.applicationModel;


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
        System.out.println(""+title);
        System.out.println("********************************");
        System.out.println("               ");
    }
    public static void createShow1(String title) {
        System.out.println(">>>>>> "+title);
    }

    public static void showApplicationDetail(applicationModel application){
        createShow("Application detail");
        System.out.println("Slug : "+application.getSlug());
        System.out.println("Title : "+application.getTitle());
        System.out.println("Description : "+application.getDescription());
        createShow(" Pages");
        if(application.getPageModelList().isEmpty()){
            createShow1("Rien pour l'instant");
        }else {
            int index = 0;
            for (entityModel page: application.getPageModelList()) {
                System.out.println(index+" : " + page.getTitle());
                index++;
            }
        }
    }
}
