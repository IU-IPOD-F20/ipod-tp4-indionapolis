package application.actionlist;

import application.AccesBankAgency;
import application.action.Action;
import bank.Account;
import bank.BankAgency;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GenericActionList implements ActionList {
    private String message;
    private String code;
    private String title;
    private ArrayList<Action> actionlist;

    public GenericActionList(String code){
        message = "Tinkoff Bank (Kazan)";
        this.code = code;
        title = "General Menu";
        actionlist = new ArrayList<>();
    }

    @Override
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return actionlist.size();
    }

    @Override
    public boolean addAction(Action ac) {
        return actionlist.add(ac);
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(BankAgency ag) throws Exception {
        boolean proceed ;
        Scanner lect;
        Action action;
        String choice;
        int choice_id;

        lect = new Scanner( System.in );
        lect.useLocale(Locale.US);

        proceed = true;
        while (proceed) {
            printMenu();
            choice = lect.next();
            choice_id = Integer.valueOf(choice);

            if (choice_id == 0){
                proceed = false;
                continue;
            }

            action = actionlist.get(choice_id-1);
            action.execute(ag);

        }
    }
    public void printMenu() {
        System.out.println(listTitle());
        for (int i = 0; i < size(); i++) {
            Action a = actionlist.get(i);
            System.out.println(a.actionCode()+" "+a.actionMessage());
        }
        System.out.println("0 - Quit");
        System.out.print("Choice -> ");
    }
}
