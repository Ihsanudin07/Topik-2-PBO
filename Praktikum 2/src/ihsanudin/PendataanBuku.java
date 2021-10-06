package ihsanudin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PendataanBuku {

    //atribut dari Pendataan Buku
    private final String isbn;
    private String judul;
    private String pengarang;
    private String tahun;
    private int harga;
    private float rating;

    //konstruktor dengan menggunakan 6 paramater
    public PendataanBuku(String isbn, String judul, String pengarang, String tahun, int harga, float rating) {
        this.isbn = isbn;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahun = tahun;
        this.harga = harga;
        this.rating = rating;
    }

    //membuat method set
    void setJudul(String judul) {
        this.judul = judul;
    }

    void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    void setTahun(String tahun) {
        this.tahun = tahun;
    }

    void setHarga(int harga) {
        this.harga = harga;
    }

    void setRating(float rating) {
        this.rating = rating;
    }

    //membuat method get
    public String getIsbn() {
        return isbn;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getTahun() {
        return tahun;
    }

    public int getHarga() {
        return harga;
    }

    public float getRating() {
        return rating;
    }

    static Scanner masukan = new Scanner(System.in);
    static ArrayList<PendataanBuku> buku = new ArrayList<>();

    static void tambahData() {
        System.out.print("isbn = ");
        String isbn = masukan.next();
        System.out.print("judul = ");
        String judul = masukan.next();
        System.out.print("pengarang = ");
        String pengarang = masukan.next();
        System.out.print("tahun terbit = ");
        String tahun = masukan.next();
        System.out.print("harga = ");
        int harga = masukan.nextInt();
        System.out.print("rating = ");
        float rating = masukan.nextFloat();
        buku.add(new PendataanBuku(isbn, judul, pengarang, tahun, harga, rating));
        System.out.println("Data berhasil ditambahkan:)");
    }

    static void tampilanData() {
        for (PendataanBuku pendataanBuku : buku) {
            System.out.println("-------------------------------------");
            System.out.println("isbn = " + pendataanBuku.getIsbn());
            System.out.println("judul = " + pendataanBuku.getJudul());
            System.out.println("pengarang = " + pendataanBuku.getPengarang());
            System.out.println("tahun terbit = " + pendataanBuku.getTahun());
            System.out.println("harga = " + pendataanBuku.getHarga());
            System.out.println("rating = " + pendataanBuku.getRating());
        }
    }

    static void editData(String judul) {
        for (PendataanBuku pendataanBuku : buku) {
            if (judul.equals(pendataanBuku.getIsbn())) {
                System.out.print("judul = ");
                String updateJudul = masukan.next();
                pendataanBuku.setJudul(updateJudul);
                System.out.print("pengarang = ");
                String updatePengarang = masukan.next();
                pendataanBuku.setPengarang(updatePengarang);
                System.out.print("tahun terbit = ");
                String updateTahun = masukan.next();
                pendataanBuku.setTahun(updateTahun);
                System.out.print("harga = ");
                int updateHarga = masukan.nextInt();
                pendataanBuku.setHarga(updateHarga);
                System.out.print("rating = ");
                float updateRating = masukan.nextFloat();
                pendataanBuku.setRating(updateRating);
                System.out.println("edit data berhasil");
            } else {
                System.out.println("Buku tidak ada ada");
            }
        }
    }

    static void cariData(String isbnX) {
        buku.sort(Comparator.comparing(PendataanBuku::getIsbn));
        for (PendataanBuku pendataanBuku : buku) {
            if (isbnX.equals(pendataanBuku.getIsbn())) {
                System.out.println("isbn = " + pendataanBuku.getIsbn());
                System.out.println("judul = " + pendataanBuku.getJudul());
                System.out.println("pengarang = " + pendataanBuku.getPengarang());
                System.out.println("tahun terbit = " + pendataanBuku.getTahun());
                System.out.println("harga = " + pendataanBuku.getHarga());
                System.out.println("rating = " + pendataanBuku.getRating());
            } else {
                System.out.println("Data buku tidak ada dalam daftar");
            }
        }
    }

    static void hapusData(String isbnIsbn) {
        for (int i = 0; i < buku.size(); i++) {
            if (isbnIsbn.equals(buku.get(i).getIsbn())) {
                buku.remove(buku.get(i));
                System.out.println("Data Buku sudah dihapus dari daftar");
            } else {
                System.out.println("buku tidak ada");
            }
        }
    }

    public static void main(String[] args) {
        int menuPendataan;
        do {
            System.out.println("--------------------------");
            System.out.println("pilihan pendataan buku :");
            System.out.println("1. Tambah data buku");
            System.out.println("2. edit data buku");
            System.out.println("3. tampilkan data buku");
            System.out.println("4. cari data buku");
            System.out.println("5. hapus data buku");
            System.out.println("6. keluar");
            menuPendataan = masukan.nextInt();
            System.out.println();
            switch (menuPendataan){
                case 1:
                    tambahData();
                    break;
                case 2:
                    System.out.print("masukan isbn =");
                    String isbn = masukan.next();
                    editData(isbn);
                    break;
                case 3:
                    tampilanData();
                    break;
                case 4:
                    System.out.print("masukan isbn =");
                    String x = masukan.next();
                    cariData(x);
                    break;
                case 5:
                    System.out.print("masukan isbn =");
                    String o = masukan.next();
                    hapusData(o);
                    break;
            }
        }while (menuPendataan !=6);
    }
}
