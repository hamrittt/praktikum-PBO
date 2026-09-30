package com.ambank.app;

import com.ambank.model.Account;
import com.ambank.model.BusinessAccount;

public class App {
    public static void main(String[] args) {
        Transaction.initTransactionList();

        Account joras = new Account("JORAS");
        Account yafi = new Account("YAFI");
        BusinessAccount rotiOLempuyangan = new BusinessAccount("Roti O Lempuyangan", "01.234.567.8-901.000", "SK-2024-998");

        Transaction.setorUang(joras, 6000000);
        Transaction.setorUang(yafi, 10000000);
        Transaction.setorUang(rotiOLempuyangan, 50000000);

        joras.issueCard("123456");

        joras.displayAccount();
        yafi.displayAccount();
        rotiOLempuyangan.displayAccount();

        // Tarik tunai dengan PIN
        Transaction.tarikUang(joras, 500000, "123456");

        // Transfer antar akun
        Transaction.makeTransaction(joras, yafi, 1000000);
        Transaction.makeTransaction(rotiOLempuyangan, joras, 25000000);

        joras.displayAccount();
        yafi.displayAccount();
        rotiOLempuyangan.displayAccount();
    }
}
