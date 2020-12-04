package application.action;

import application.GenericClass;
import bank.BankAgency;

public class ActionAccountsLists<E extends GenericClass> implements Action<E>{
    private String message = "";
    private String code = "";

    public ActionAccountsLists(String code) {
        message = "List of the Agency accounts";
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
        ag.print();
    }
}
