package application;

import application.action.ActionAccountsLists;
import application.action.ActionSeeAccountNumber;
import application.actionlist.ActionList;
import application.actionlist.GenericActionList;
import bank.Account;
import bank.BankAgency;

import java.util.Locale;
import java.util.Scanner;

public class ActionApp {
    public static void main(String[] args) throws Exception {
        BankAgency myAgency ;
        ActionList mainList = new GenericActionList("0");

        mainList.addAction(new ActionAccountsLists("1"));
        mainList.addAction(new ActionSeeAccountNumber("2"));


        myAgency = AccesBankAgency.getBankAgency();
        mainList.execute(myAgency);
    }
}
