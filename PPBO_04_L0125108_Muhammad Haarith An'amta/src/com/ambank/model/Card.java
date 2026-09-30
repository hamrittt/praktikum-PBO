package com.ambank.model;

import java.security.SecureRandom;

public class Card {
    // TODO 1: Atribut dibuat private (enkapsulasi), JANGAN buat getPin()
    private String nameHolder;
    private String cardNumber;
    private String pin;
    private boolean isBlocked;
    private int failedAttempts;

    public static final int MAX_FAILED_ATTEMPTS = 3;

    // TODO 2: Validasi PIN harus 6 digit angka, jika tidak valid set default "123456"
    public Card(String nameHolder, String pin) {
        this.nameHolder = nameHolder;
        // TODO 2: lakukan validasi format PIN di sini (6 digit angka)
        this.pin = isValidPin(pin) ? pin: "123456";
        this.cardNumber = generateCardNumber();
        this.isBlocked = false;
        this.failedAttempts = 0;
    }

    // Method untuk mengecek pin terdiri dari 6 angka atau tidak
    private boolean isValidPin(String pin) {
        return pin != null && pin.matches("\\d{6}");
    }

    // Menggunakan SecureRandom untuk keamanan nomor kartu (CWE-330 fix)
    private String generateCardNumber() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    // TODO 3: Verifikasi PIN (cek blokir, reset failedAttempts jika benar, tambah jika salah, auto-blokir jika salah 3x)
    public boolean verifyPin(String inputPin) {
        // TODO 3: implementasikan verifikasi PIN di sini
        if (this.isBlocked) {
            return false;
        }
        if (this.pin.equals(inputPin)) {
            this.failedAttempts = 0;
            return true;
        } else {
            this.failedAttempts++;
            if (this.failedAttempts >= MAX_FAILED_ATTEMPTS) {
                this.isBlocked = true;
            }
            return false;
        }
    }

    // TODO 4: Ganti PIN (verifikasi oldPin dulu, lalu cek format newPin 6 digit angka)
    public boolean changePin(String oldPin, String newPin) {
        // TODO 4: implementasikan ganti PIN di sini
        if (!verifyPin(oldPin)) {
            return false;
        }
        if (isValidPin(newPin)) {
            this.pin = newPin;
            return true;
        }
        return false;
    }

    // TODO 5: Sensor nomor kartu, tampilkan 4 digit terakhir saja (contoh: ****-****-****-1234)
    public String getMaskedCardNumber() {
        // TODO 5: implementasikan masking nomor kartu di sini
        if (this.cardNumber == null || this.cardNumber.length() < 4) {
            return "****-****-****-****";
        }
        String lastFourDigits = this.cardNumber.substring(this.cardNumber.length() - 4);
        return "****-****-****-****" + lastFourDigits; 
    }

    public String getNameHolder() {
        return nameHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }
}
