package application.action;

import bank.BankAgency;

public class ActionAccountsLists implements Action{
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
    public void execute(BankAgency ag) throws Exception {
        ag.print();
    }
}
