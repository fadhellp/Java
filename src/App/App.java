package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class App extends javax.swing.JFrame {
    private int totalBelanja = 0;
    
    public void clear(){
        box_namaBarang.setText("");
        box_hargaBarang.setText("");
        box_jumlahBarang.setText("");
        box_namaBarang.requestFocus();
        
    }
    
    public App() {
        initComponents();
        loadData();
    }

    private void loadData() {
        // Konfigurasi koneksi database
        String url = "jdbc:mysql://localhost:3306/pb_produk";
        String username = "root";
        String password = "";
    
        // Koneksi ke database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Statement untuk menjalankan query
            Statement stmt = conn.createStatement();
    
            // Query untuk mengambil data dari tabel
            String query = "SELECT * FROM pb_tabel";
    
            // Eksekusi query dan ambil hasilnya
            ResultSet rs = stmt.executeQuery(query);
    
            // Buat model tabel
            DefaultTableModel model = (DefaultTableModel) table.getModel();
    
            // Hapus semua baris yang ada di tabel
            model.setRowCount(0);
    
            // Loop melalui hasil query dan tambahkan data ke dalam model tabel
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nama = rs.getString("Nama");
                long harga = rs.getLong("Harga");
                int stock = rs.getInt("Stock");
    
                // Tambahkan data ke dalam baris baru pada model tabel
                model.addRow(new Object[]{id, nama, harga, stock});
            }
    
            // Tutup statement dan result set
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        box_namaBarang = new javax.swing.JTextField();
        box_hargaBarang = new javax.swing.JTextField();
        box_jumlahBarang = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        box_total = new javax.swing.JTextField();
        box_tunai = new javax.swing.JTextField();
        box_kembali = new javax.swing.JTextField();
        btn_hitung = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TOKO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Harga Barang");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Jumlah Barang");

        box_namaBarang.setBackground(new java.awt.Color(102, 102, 102));
        box_namaBarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        box_namaBarang.setForeground(new java.awt.Color(255, 255, 255));
        box_namaBarang.setBorder(null);
        box_namaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_namaBarangActionPerformed(evt);
            }
        });

        box_hargaBarang.setBackground(new java.awt.Color(102, 102, 102));
        box_hargaBarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        box_hargaBarang.setForeground(new java.awt.Color(255, 255, 255));
        box_hargaBarang.setBorder(null);
        box_hargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_hargaBarangActionPerformed(evt);
            }
        });

        box_jumlahBarang.setBackground(new java.awt.Color(102, 102, 102));
        box_jumlahBarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        box_jumlahBarang.setForeground(new java.awt.Color(255, 255, 255));
        box_jumlahBarang.setBorder(null);
        box_jumlahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_jumlahBarangActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(102, 102, 102));
        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.setBorder(null);
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nama = box_namaBarang.getText();
                String hargaStr = box_hargaBarang.getText();
                String stockStr = box_jumlahBarang.getText();

                long harga = Long.parseLong(hargaStr);
                int stock = Integer.parseInt(stockStr);

                String url = "jdbc:mysql://localhost:3306/pb_produk";
                String username = "root";
                String password = "";

                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                    String query = "INSERT INTO pb_tabel (Nama, Harga, Stock) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, nama);
                    pstmt.setLong(2, harga);
                    pstmt.setInt(3, stock);
                    pstmt.executeUpdate();
                    pstmt.close();

                    // Mengosongkan field setelah menambahkan produk
                    box_namaBarang.setText("");
                    box_hargaBarang.setText("");
                    box_jumlahBarang.setText("");

                    // Memuat ulang data
                    loadData();
                } catch (SQLException e) {
                    e.printStackTrace();
                }               }
        });

        btn_clear.setBackground(new java.awt.Color(204, 0, 0));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.setBorder(null);

        btn_edit.setBackground(new java.awt.Color(102, 102, 102));
        btn_edit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.setBorder(null);

        btn_delete.setBackground(new java.awt.Color(102, 102, 102));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.setBorder(null);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    // Mendapatkan indeks baris yang dipilih
                    int selectedRow = table.getSelectedRow();

                    if (selectedRow != -1) {
                        // Mendapatkan nilai ID pada kolom "ID" di baris yang dipilih
                        int id = (int) table.getValueAt(selectedRow, 0);

                        // Konfigurasi koneksi database
                        String url = "jdbc:mysql://localhost:3306/pb_produk";
                        String username = "root";
                        String password = "";

                        // Koneksi ke database
                        try (Connection conn = DriverManager.getConnection(url, username, password)) {
                            // Statement untuk menjalankan query
                            Statement stmt = conn.createStatement();

                            // Query untuk menghapus data dari tabel berdasarkan ID
                            String query = "DELETE FROM pb_tabel WHERE ID = " + id;

                            // Eksekusi query
                            int affectedRows = stmt.executeUpdate(query);

                            if (affectedRows > 0) {
                                // Hapus baris dari model tabel
                                DefaultTableModel model = (DefaultTableModel) table.getModel();
                                model.removeRow(selectedRow);
                            }
                            // Tutup statement
                            stmt.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }            
                }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tunai");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kembali");

        box_total.setBackground(new java.awt.Color(51, 51, 51));
        box_total.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        box_total.setForeground(new java.awt.Color(255, 255, 255));
        box_total.setText("Rp.");
        box_total.setBorder(null);

        box_tunai.setBackground(new java.awt.Color(51, 51, 51));
        box_tunai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        box_tunai.setForeground(new java.awt.Color(255, 255, 255));
        box_tunai.setBorder(null);
        box_tunai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_tunaiActionPerformed(evt);
            }
        });

        box_kembali.setBackground(new java.awt.Color(51, 51, 51));
        box_kembali.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        box_kembali.setForeground(new java.awt.Color(255, 255, 255));
        box_kembali.setText("Rp.");
        box_kembali.setBorder(null);

        btn_hitung.setBackground(new java.awt.Color(0, 153, 153));
        btn_hitung.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_hitung.setForeground(new java.awt.Color(255, 255, 255));
        btn_hitung.setText("Hitung");
        btn_hitung.setBorder(null);
        btn_hitung.setText("BAYAR");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String input = box_tunai.getText();
                try {
                    int number = Integer.parseInt(input);
                    int totalKembalian = number - totalBelanja;
                    if (totalKembalian < 0){
                        box_kembali.setText("Uang anda tidak cukup");
                    } else {
                        box_kembali.setText(String.valueOf("RP. " + totalKembalian));
                    }

                } catch (NumberFormatException ex) {
                    // Tangani kesalahan jika String tidak dapat diubah menjadi integer
                        box_kembali.setText("Inputan Hanya Berupa Angka");
                }
            }
        });

        btn_simpan.setBackground(new java.awt.Color(0, 153, 153));
        btn_simpan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.setBorder(null);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    try {
                        // Mendapatkan data stok pada kolom "Stok" di baris yang dipilih
                        int stock = (int) table.getValueAt(selectedRow, 3);
                        if (stock > 0) {
                            // Mengurangi stok dengan 1
                            stock--;

                            // Memperbarui stok di dalam tabel
                            table.setValueAt(stock, selectedRow, 3);

                            // Mendapatkan ID barang dari kolom "ID" di baris yang dipilih
                            int id = (int) table.getValueAt(selectedRow, 0);

                            // Menghubungkan ke database
                            String url = "jdbc:mysql://localhost:3306/pb_produk";
                            String username = "root";
                            String password = "";
                            Connection connection = DriverManager.getConnection(url, username, password);

                            // Update stok di database
                            String query = "UPDATE pb_tabel SET stock = ? WHERE id = ?";
                            PreparedStatement statement = connection.prepareStatement(query);
                            statement.setInt(1, stock);
                            statement.setInt(2, id);
                            statement.executeUpdate();

                            // Lakukan sesuatu dengan stok yang telah diperbarui

                            // Menutup koneksi ke database
                            statement.close();
                            connection.close();
                        } else {
                            System.out.println("Stok barang kosong");
                        }

                        double hargaBarang = Double.parseDouble(table.getValueAt(selectedRow, 2).toString());

                        // Menambahkan harga barang ke total belanjaan
                        totalBelanja += hargaBarang;

                        // Memperbarui label atau field yang menampilkan total belanjaan
                        box_total.setText(String.valueOf("Rp. " + totalBelanja));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(box_total, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                            .addComponent(box_tunai)
                            .addComponent(box_kembali)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(box_tunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(box_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hitung)
                    .addComponent(btn_simpan))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama", "Harga", "Jumlah"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(box_hargaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(box_jumlahBarang)
                            .addComponent(box_namaBarang)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(box_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(box_hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(box_jumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void box_jumlahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_jumlahBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_jumlahBarangActionPerformed

    private void box_hargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_hargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_hargaBarangActionPerformed

    private void box_namaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_namaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_namaBarangActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void box_tunaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_tunaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_tunaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField box_hargaBarang;
    private javax.swing.JTextField box_jumlahBarang;
    private javax.swing.JTextField box_kembali;
    private javax.swing.JTextField box_namaBarang;
    private javax.swing.JTextField box_total;
    private javax.swing.JTextField box_tunai;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}


