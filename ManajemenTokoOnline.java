class Produk {
    private String kodeProduk;
    private String namaProduk;
    private double harga;
    private int stok;

    public Produk(String kodeProduk, String namaProduk, double harga, int stok) {
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanInfoProduk() {
        System.out.println("Kode Produk: " + kodeProduk);
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }

    public boolean kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
            return true;
        } else {
            System.out.println("Stok tidak mencukupi!");
            return false;
        }
    }

    public double getHarga() {
        return harga;
    }
}

// Class Pelanggan
class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String email;
    private double saldo;

    public Pelanggan(String idPelanggan, String nama, String email, double saldo) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.saldo = saldo;
    }

    public void tampilkanInfoPelanggan() {
        System.out.println("ID Pelanggan: " + idPelanggan);
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
        System.out.println("Saldo: " + saldo);
    }

    public void topUpSaldo(double jumlah) {
        saldo += jumlah;
        System.out.println("Top-up berhasil. Saldo sekarang: " + saldo);
    }

    public boolean kurangiSaldo(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        } else {
            System.out.println("Saldo tidak mencukupi!");
            return false;
        }
    }
}

// Class Transaksi
class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Produk produk;
    private int jumlahBeli;
    private double totalHarga;

    public Transaksi(String idTransaksi, Pelanggan pelanggan, Produk produk, int jumlahBeli) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.jumlahBeli = jumlahBeli;
        this.totalHarga = produk.getHarga() * jumlahBeli;
    }

    public void prosesTransaksi() {
        if (pelanggan.kurangiSaldo(totalHarga) && produk.kurangiStok(jumlahBeli)) {
            System.out.println("Transaksi berhasil!");
        } else {
            System.out.println("Transaksi gagal!");
        }
    }

    public void tampilkanDetailTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Pelanggan: " + pelanggan);
        System.out.println("Produk: " + produk);
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total Harga: " + totalHarga);
    }
}

public class ManajemenTokoOnline {
    public static void main(String[] args) {
        Produk produk1 = new Produk("P001", "Laptop", 7500000, 10);
        Pelanggan pelanggan1 = new Pelanggan("C001", "Budi", 
        "budi@email.com", 10000000);

        // Menampilkan informasi awal
        produk1.tampilkanInfoProduk();
        pelanggan1.tampilkanInfoPelanggan();

        // Melakukan transaksi
        Transaksi transaksi1 = new Transaksi("T001", pelanggan1, produk1, 1);
        transaksi1.prosesTransaksi();
        transaksi1.tampilkanDetailTransaksi();
    }
} 