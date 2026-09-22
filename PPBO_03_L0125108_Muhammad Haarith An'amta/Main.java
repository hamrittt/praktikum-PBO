/* 
    Muhammad Haarith An'amta - L0125108
*/

public class Main {
    public static void main(String[] args) {
        // Bikin objek bebas banyaknya (minimal 2 lah pastinya)
        // Dia harus make semua method di Entitas sama Vector3 (via Entitas)
        Entitas player1 = new Entitas("rio", 2.0f);
        Entitas player2 = new Entitas("ujang", 3.0f, 4.0f, 0.0f, 1.5f);

        System.out.println("Posisi awal " + player1.name + ": " + player1.position.x + ", " + player1.position.y + ", " + player1.position.z);
        System.out.println("Posisi awal " + player2.name + ": " + player2.position.x + ", " + player2.position.y + ", " + player2.position.z);

        boolean bertabrakan = player1.isColliding(player2);
        System.out.println("Bertabrakan? (true/false): " + bertabrakan);
        
        Vector3 pergeseran = new Vector3(2.0f, 2.0f, 0.0f);
        player1.move(pergeseran);
        
        System.out.println(player1.name + " bergerak: " + pergeseran.x + ", " + pergeseran.y + ", " + pergeseran.z);
        System.out.println("Posisi " + player1.name + ": " + player1.position.x + ", " + player1.position.y + ", " + player1.position.z);
        
        bertabrakan = player1.isColliding(player2);
        System.out.println("Bertabrakan? (true/false): " + bertabrakan);

        Vector2 bayanganRio = player1.position.shadow();
        System.out.println("Proyeksi bayangan " + player1.name + " (x, y): " + bayanganRio.x + ", " + bayanganRio.y);
    }
}

// TODO:
// Sekarang, class Entitas masih entitas yang 2D
// Aku mau entitas ini full 3D, kita bikin game 3D, yey
// Pake Vector3...
class Entitas {
    String name;
    Vector3 position; // diganti jadi vector3
    float radius;

    public Entitas(String name, float radius) {
        this.name = name;
        this.position = new Vector3(0, 0, 0); // diganti jadi vector3
        this.radius = radius;
    }
    
    public Entitas(String name, float x, float y, float z, float radius) {
        this.name = name;
        this.position = new Vector3(x, y, z); // diganti jadi vector3
        this.radius = radius;
    }

    public void move(Vector3 v) { // diganti jadi vector3
        // TODO:
        // Konsep translasi
        this.position.x += v.x;
        this.position.y += v.y;
        this.position.z += v.z;
    }

    public boolean isColliding(Entitas e) {
        // TODO:
        // Cek apakah objek ini nabrak objek e (pake radius objek e)
        float jarak = this.position.distance(e.position);
        return jarak <= (this.radius + e.radius);
    }
}

class Vector2 {
    float x;
    float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float distance(Vector2 v) {
        return (float)Math.sqrt(Math.pow(v.x-this.x, 2) + Math.pow(v.y-this.y, 2));
    }
}

class Vector3 extends Vector2 {
    float z;
    // TODO:
    // Karena Vector3 itu 3 dimensi
    // Tambahkan komponen dengan extends Vector2 sebagai base untuk x,y
    // Jadi Vector3 bisa diconstruct dengan Vector3(x,y,z)
    // Gunakan super()
    // Override method yang ada seperti distance (insyaallah bisa)
    // Bonus: tambah 1 method yang dia tu spesifik di 3D
    public Vector3(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    @Override 
    public float distance(Vector2 v) {
        if (v instanceof Vector3) {
            Vector3 v3 = (Vector3) v;
            return (float)Math.sqrt(Math.pow(v3.x - this.x, 2) + Math.pow(v3.y - this.y, 2) + Math.pow(v3.z - this.z, 2));
        }
        return super.distance(v);
    }

    public float distance(Vector3 v) {
        return (float)Math.sqrt(Math.pow(v.x - this.x, 2) + Math.pow(v.y - this.y, 2) + Math.pow(v.z - this.z, 2));
    }

    public Vector2 shadow() {
        return new Vector2(this.x, this.y);
    }
}

// Bonus: Dimensi ke-4
// OPSIONAL, Tapi Bonus. Jadi kalo implement, harus dipake juga, ehehehe
// class Vector4 {
//     float time;
// }