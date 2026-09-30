package com.ambank.app;

import com.ambank.model.Account;
import java.util.ArrayList;

public class Transaction {
    private static ArrayList<Transaction> transactions;
    private static final Account AMBANK_ACCOUNT = new Account("AmBank");

    protected Account senderAccount;
    protected Account receiverAccount;
    protected int amount;

    private Transaction(Account senderAccount, Account receiverAccount, int amount) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
    }

    public static void initTransactionList() {
        if (transactions == null) {
            transactions = new ArrayList<Transaction>();
        }
    }

    public static boolean makeTransaction(Account sender, Account receiver, int amount) {
        initTransactionList();

        // Validasi keamanan: parameter null, amount tidak valid, atau transfer ke akun sendiri
        if (sender == null || receiver == null || sender == receiver || amount <= 0) {
            return false;
        }

        if (((sender.getSaldo() - Account.MINIMUM_SALDO) >= amount) || sender == AMBANK_ACCOUNT) {
            // TODO 16: Ganti Account.TRANSFER_LIMIT dengan sender.getTransferLimit() agar polimorfisme aktif
            if ((amount > 10000 && amount <= Account.TRANSFER_LIMIT) || sender == AMBANK_ACCOUNT) {
                transactions.add(new Transaction(sender, receiver, amount));
                return true;
            }
        }

        return false;
    }

    public static int getSaldoFromAccount(Account account) {
        initTransactionList();
        if (account == null) {
            return 0;
        }

        int saldo = 0;
        for (Transaction transaction : transactions) {
            if (transaction.senderAccount == account) {
                saldo -= transaction.amount;
            } else if (transaction.receiverAccount == account) {
                saldo += transaction.amount;
            }
        }
        return saldo;
    }

    public static void setorUang(Account account, int amount) {
        if (amount > 0) {
            Transaction.makeTransaction(AMBANK_ACCOUNT, account, amount);
        }
    }

    // TODO 17: Tarik tunai ke AMBANK_ACCOUNT menggunakan makeTransaction
    public static boolean tarikUang(Account account, int amount) {
        // TODO 17: implementasikan tarik tunai di sini
        return false;
    }

    // TODO 18: Tarik tunai via ATM (validasi kartu & verifikasi PIN)
    public static boolean tarikUang(Account account, int amount, String pin) {
        // TODO 18: implementasikan verifikasi kartu dan PIN sebelum tarik tunai
        return false;
    }
}
