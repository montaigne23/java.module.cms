import library.utilities.eav.models.entityModel;
import library.utilities.eav.models.userModel;
import models.applicationModel;
import service.serviceApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static userModel user = new userModel("", "");
    static List<entityModel> applicationList = new ArrayList<>();

    public static void main(String[] args) {
        getStarted();


    }

    public static void getStarted() {
        serviceApplication.bienvenuShow();
        boolean isFirst = false;
        Scanner answer = new Scanner(System.in);
        boolean process = true;
        while (process) {
            if (isFirst) {
                serviceApplication.startSetup();
                System.out.print("entrez un nombre : ");
                String texte = answer.nextLine();
                //   System.out.println(texte);
                switch (texte) {
                    case "1":
                        String res;
                        System.out.print("entrez votre nom : ");
                        res = answer.nextLine();
                        user.setName(res);
                        System.out.print("entrez votre email : ");
                        res = answer.nextLine();
                        user.setEmail(res);
                        serviceApplication.succesShow();
                        isFirst = false;
                        break;
                    case "2":
                        System.out.println("baye baye !!!");
                        process = false;
                        break;
                }
            }
            if (!isFirst) {
                serviceApplication.menuSetup();
                System.out.print("entrez un nombre : ");
                String texte = answer.nextLine();
                switch (texte) {
                    case "1":
                        serviceApplication.createShow("Create New Application");
                        String res;
                        applicationModel newApplication = new applicationModel();
                        System.out.print("Entrez titre : ");
                        res = answer.nextLine();
                        newApplication.setTitle(res);
                        newApplication.setSlug(res.replace(" ", "-"));
                        System.out.print("Entrez une description : ");
                        res = answer.nextLine();
                        newApplication.setDescription(res);
                        applicationList.add(newApplication);
                        serviceApplication.showApplicationDetail(newApplication);
                        answer.nextLine();
                        break;
                    case "2":
                        serviceApplication.createShow("Choisir une application pour continuer");
                        if (applicationList.isEmpty()) {
                            serviceApplication.createShow1("Rien pour l'instant");
                            answer.nextLine();
                        } else {
                            int index = 0;
                            for (entityModel application : applicationList) {
                                System.out.println(index + " : " + application.getTitle());
                                index++;
                            }
                            answer.nextLine();

                        }
                        break;
                    case "3":
                        serviceApplication.createShow("Choisir une application pour continuer");
                        if (applicationList.isEmpty()) {
                            serviceApplication.createShow1("Rien pour l'instant");
                            answer.nextLine();
                        } else {
                            long _indexCount = applicationList.stream().count();
                            int index = 0;
                            for (entityModel application : applicationList) {
                                System.out.println(index + " : " + application.getTitle());
                                index++;
                            }
                            System.out.println("tape * to return");
                            long _ans = 99999999;
                            boolean isQuit = false;
                            do {
                                try{
                                    String ans = answer.nextLine();
                                    if(ans == "*"){
                                        isQuit = true;
                                    }else {
                                        _ans = Long.parseLong(ans);
                                    }
                                }catch (NumberFormatException e){
                                    serviceApplication.createShow1("Commande incorrect");
                                }
                            }while (_ans > _indexCount||isQuit);
                        }
                        break;
                    default:
                        serviceApplication.createShow1("Commande invalide");
                        answer.nextLine();
                        break;
                }
                // System.out.println(texte);
            }
        }
    }

}