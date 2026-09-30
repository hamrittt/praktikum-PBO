package com.ambank.model;

public class BusinessAccount extends Account {
    // TODO 11: Tambahkan konstanta limit transfer bisnis (Rp 50.000.000)
    public static final int BUSINESS_TRANSFER_LIMIT = 50000000;

    private String NPWP;
    private String noSK;

    public BusinessAccount(String nameHolder) {
        super(nameHolder);
    }

    // TODO 12: Constructor overloading dengan super(nameHolder) serta inisialisasi NPWP dan noSK
    public BusinessAccount(String nameHolder, String NPWP, String noSK) {
        super(nameHolder);
        // TODO 12: inisialisasi atribut NPWP dan noSK di sini
        this.NPWP = NPWP;
        this.noSK = noSK;
    }
    
    // TODO 13: Sediakan getter dan setter untuk NPWP dan noSK
    public String getNPWP() {
        // TODO 13: return NPWP
        return this.NPWP;
    }
    
    public void setNPWP(String NPWP) {
        // TODO 13: set NPWP
        this.NPWP = NPWP;
    }
    
    public String getNoSK() {
        // TODO 13: return noSK
        return this.noSK;
    }
    
    public void setNoSK(String noSK) {
        // TODO 13: set noSK
        this.noSK = noSK;
    }

    // TODO 14: Override getTransferLimit() agar me-return BUSINESS_TRANSFER_LIMIT
    @Override
    public int getTransferLimit() {
        // TODO 14: kembalikan BUSINESS_TRANSFER_LIMIT
        return BUSINESS_TRANSFER_LIMIT;
    }

    // TODO 15: Override displayAccount() panggil super.displayAccount() lalu cetak NPWP dan noSK
    @Override
    public void displayAccount() {
        super.displayAccount();
        // TODO 15: cetak data bisnis di sini
        System.out.println("NPWP  : " + this.NPWP);
        System.out.println("No SK : " + this.noSK);
    }
}
