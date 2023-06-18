package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_produk";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private Connection connect;
    private Statement statement;
    private ResultSet resultSet;

    public MyConfig() {
        connect = null;
        statement = null;
        resultSet = null;
    }

    public void connection() {
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Database Connected Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connect != null)
                connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDatabase() {
        connection();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT id,nama,harga,jumlah FROM `tb_table` ORDER BY ID DESC");

            while (resultSet.next()) {
                System.out.println(
                    resultSet.getString("nama")+ ": Rp."+
                    resultSet.getInt("harga")+ " (" +
                    resultSet.getInt("jumlah") + ")"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void insertData() {
        int idBaru;
        String namaBaru;
        long hargaBaru;
        int jumlahBaru;

        Scanner input = new Scanner(System.in);

        System.out.print("id : ");
        idBaru = input.nextInt();
        input.nextLine();

        System.out.print("nama : ");
        namaBaru = input.nextLine();

        System.out.print("harga : ");
        hargaBaru = input.nextLong();

        System.out.print("jumlah : ");
        jumlahBaru = input.nextInt();

        connection();
        try {
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `tb_table` (`id`, `nama`, `harga`, `jumlah`) VALUES ('"+idBaru+"', '"+namaBaru+"', '"+hargaBaru+"', '"+jumlahBaru+"') ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        input.close();
    }


    public void editData(int id, String nama, double harga, int jumlah) {
        connection();
        try {
            statement = connect.createStatement();
            String sql = "UPDATE `tb_table` SET `nama` = '" + nama + "', `harga` = " + harga + ", `jumlah` = " + jumlah + " WHERE `tb_table`.`id` = " + id;
            statement.executeUpdate(sql);
            System.out.println("Data successfully updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteData() {
        int id;
        Scanner sc = new Scanner(System.in);
        System.out.print("masukkan id yang ingin dihapus: ");
        id = sc.nextInt();
        connection();
        try {
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `tb_table` WHERE `ID` = " + id);
            System.out.println("Data successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        sc.close();
    }

}