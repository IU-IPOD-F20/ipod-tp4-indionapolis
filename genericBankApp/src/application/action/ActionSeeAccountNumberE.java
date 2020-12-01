package application.action;

import bank.Account;
import bank.BankAgency;

import java.util.Locale;
import java.util.Scanner;

public class ActionSeeAccountNumberE implements ActionE<E> {
    private String message = "";
    private String code = "";

    public ActionSeeAccountNumberE(String code) {
        message = "View an account (by its number)";
        this.code = code;
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
    public void execute(E ag) throws Exception {
        Scanner lect;
        String number;
        Account c;

        lect = new Scanner( System.in );
        lect.useLocale(Locale.US);
        System.out.print("Account Number -> ");
        number = lect.next();
        c = ag.getAccount(number);
        if (c==null) {
            System.out.println("Account non existing ...");
        } else {
            c.print();
        }
    }
}
