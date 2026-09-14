public class StudyCaseWeek2 {
    char[] nama;
    public StudyCaseWeek2(char[] input){
        this.nama = new char[input.length];
        for (int i = 0; i < input.length; i++){
            this.nama[i] = input[i];
        }
    }

    public int hitungJumlahString(){
        int jumlah = 0;
        for(char x : nama){
            if (x >= 32) {
                jumlah++;
            }
        }
        return jumlah;
    }

    public String toUpperCase(){
        char[] hasil = new char[nama.length];
        for (int i = 0; i < nama.length; i++) {
            char x = nama[i];
            if (x >= 'a' && x <= 'z') {
                hasil[i] = (char) (x - 32);
            } else {
                hasil[i] = x;
            }
        }
        return new String(hasil);
    }
    
    public String toLowerCase(){
        char[] hasil = new char[nama.length];
        for (int i = 0; i < nama.length; i++) {
            char x = nama[i];
            if (x >= 'A' && x <= 'Z') {
                hasil[i] = (char) (x + 32);
            } else {
                hasil[i] = x;
            }
        }
        return new String(hasil);
    }

    public String printNama(){
        return new String(nama);
    }

    public static void main(String[] args){
        char[] input1 = {'h', 'a', 'a', 'r', 'i', 't', 'h', '\n'};
        StudyCaseWeek2 objek1 = new StudyCaseWeek2(input1);
        System.out.println("Nama: " + objek1.printNama());
        System.out.println("Jumlah string: " + objek1.hitungJumlahString());
        System.out.println("Uppercase: " + objek1.toUpperCase());
        
        char[] input2 = {'A', 'N', 'A', 'M', 'T', 'A', '\t'};
        StudyCaseWeek2 objek2 = new StudyCaseWeek2(input2);
        System.out.println("Nama: " + objek2.printNama());
        System.out.println("Jumlah string: " + objek2.hitungJumlahString());
        System.out.println("Lowercase: " + objek2.toLowerCase());
    }
}