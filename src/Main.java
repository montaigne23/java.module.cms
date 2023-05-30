import library.utilities.eav.models.entityModel;
import library.utilities.eav.models.userModel;
import models.applicationModel;
import service.serviceApplication;

import java.util.*;

public class Main {
    static userModel user = new userModel("", "");
    static List<entityModel> applicationList = new ArrayList<>();
    static Scanner answer = new Scanner(System.in);
    static boolean isFirst = false;
    static boolean process = true;

    public static void main(String[] args) {
        getStarted();

    }

    public static void getStarted() {
        serviceApplication.bienvenuShow();

        Scanner answer = new Scanner(System.in);

        while (process) {
            if (isFirst) {
                isFirstShow();
            }
            if (!isFirst) {
                isNotFirst();
            }
        }
        answer.close();
    }

    public static void isNotFirst() {
        serviceApplication.menuSetup();
        System.out.print("entrez un nombre : ");
        String texte = answer.nextLine();
        switch (texte) {
            case "1":
                serviceApplication.createShow("Create New Application");
                showCreateNewApp();
                break;
            case "2":
                serviceApplication.createShow("Choisir une application pour continuer");
                showAppForDetails();
                break;
            case "3":
                showScreen("vues");
                break;
            case "4":
                showScreen("pages");
                break;
            case "5":
                showScreen("composants");
                break;
            case "q":
                System.out.println("baye baye !!!");
                process = false;
                break;
            default:
                serviceApplication.createShow1("Commande invalide");
        }
    }

    public static void showScreen(String type) {
        serviceApplication.createShow("Choisir une application pour continuer");
        if (applicationList.isEmpty()) {
            serviceApplication.createShow1("Aucune application pour l'instant");
            answer.nextLine();
        } else {
            long _indexCount = applicationList.stream().count();
            int indexChoice = 999999999;
            int index = 0;
            for (entityModel application : applicationList) {
                System.out.println(index + " : " + application.getTitle());
                index++;
            }
            System.out.println("tape * to return");
            int _ans = 99999999;
            boolean isQuit = false;
            do {
                System.out.print("entrez un nombre : ");
                String ans = answer.nextLine();
                switch (ans) {
                    case "*":
                        isQuit = true;
                        break;
                    default:
                        try {
                            _ans = Integer.parseInt(ans);
                            if (_ans > _indexCount - 1) {
                                serviceApplication.createShow1("Commande incorrect");
                            } else {
                                indexChoice = _ans;
//                                                System.out.println(indexChoice + " ok");
//                                                answer.nextLine();
                                isQuit = true;
                            }
                        } catch (NumberFormatException e) {
                            serviceApplication.createShow1("Commande incorrect");
                        }
                        break;
                }

            } while (!isQuit);

            if (indexChoice != 999999999) {
                boolean isQuitVue = false;
                while (!isQuitVue) {
                    serviceApplication.createShow("Application : " + applicationList.get(indexChoice).getTitle());
                    serviceApplication.createShow1("Voici la liste des " + type + " actuelle de cette app");
                    switch (type) {
                        case "vues":
                            applicationModel application;
                            application = (applicationModel) applicationList.get(indexChoice);
                            serviceApplication.showApplicationOptionDetail(application, type);
                            break;
                        case "pages":
                            applicationModel application1;
                            application1 = (applicationModel) applicationList.get(indexChoice);
                            serviceApplication.showApplicationOptionDetail(application1, type);
                            break;
                        case "composants":
                            applicationModel application2;
                            application2 = (applicationModel) applicationList.get(indexChoice);
                            serviceApplication.showApplicationOptionDetail(application2, type);
                            break;
                        default:
                            break;
                    }
                    isQuitVue = true;
                }
                answer.nextLine();
            }

        }
    }

    public static void showCreateNewApp() {
        String res;
        applicationModel newApplication = new applicationModel();
        System.out.print("Entrez titre : ");
        res = answer.nextLine();
        newApplication.setTitle(res);
        newApplication.setSlug(res.replace(" ", "-"));
        System.out.print("Entrez une description : ");
        res = answer.nextLine();
        newApplication.setDescription(res);
        newApplication.setCreatedBy(user);
        newApplication.setCreatedAt(new Date());
        newApplication.setUpdatedAt(new Date());
        newApplication.setUpdatedBy(user);
        serviceApplication.createShow1("Voulez vous enregistrer cette nouvelle App ? y/n");

        boolean isStatus = true;
        while (isStatus) {
            System.out.print("Entrez votre reponse : ");
            res = answer.nextLine();
            switch (res) {
                case "y":
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("         - r pour retourner au menu principale");
                    System.out.println("         - c pour continuer vers l'application");
                    System.out.println(" ");
                    boolean isNotV = false;
                    while (!isNotV) {
                        System.out.print("Entrez votre reponse : ");
                        res = answer.nextLine();
                        switch (res) {
                            case "r":

                                applicationList.add(newApplication);
                                System.out.println("Application creee avec succes  : ");
                                isNotV = true;
                                // answer.nextLine();
                                break;
                            case "c":
                                serviceApplication.createShow(newApplication.getTitle());
                                newApplication.manageApplication();
                                System.out.println(" ");
                                applicationList.add(newApplication);
                                System.out.println("Application creee avec succes  : ");
                                isNotV = true;
                                break;
                            default:
                                serviceApplication.createShow1("Commande invalide");

                                break;
                        }
                    }
                    serviceApplication.showApplicationDetail(newApplication);
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
    }

    public static void showAppForDetails() {

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
            int _ans = 99999999;
            boolean isQuit = false;
            do {
                System.out.print("entrez un nombre : ");
                String ans = answer.nextLine();
                switch (ans) {
                    case "*":
                        isQuit = true;
                        break;
                    default:
                        try {
                            _ans = Integer.parseInt(ans);
                            if (_ans > _indexCount - 1) {
                                serviceApplication.createShow1("Commande incorrect");
                            } else {
                                applicationModel _applicationModel = (applicationModel) applicationList.get(_ans);

                                serviceApplication.createShow1(_applicationModel.getTitle());
                                boolean status = _applicationModel.manageApplication();
                                if (!status) {
                                    serviceApplication.createShow1("Voulez vous enregistrer les modification ? y/n");
                                    System.out.print(" : ");
                                    String res = answer.nextLine();
                                    boolean isValidate = true;
                                    while (isValidate) {
                                        switch (res) {
                                            case "y":
                                                applicationList.set(_ans, _applicationModel);
                                                serviceApplication.createShow("Application mise a jour avec succes");
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
                                    isQuit = true;
                                } else {
                                    applicationList.remove(_ans);
                                    serviceApplication.createShow("Application supprimee avec succes");
                                    serviceApplication.createShow1("Taper entre pour continuer");
                                    answer.nextLine();
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

    public static void isFirstShow() {
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
}
