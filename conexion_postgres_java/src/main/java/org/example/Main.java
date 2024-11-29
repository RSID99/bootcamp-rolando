package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Market", "postgres", "admin");

            topClientesFacturas(c);
            topClientesGasto(c);
            topMonedas(c);
            topProveedor(c);
            topProductos(c);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }


    public static void topClientesFacturas(Connection c) throws SQLException {
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT c.nombre || ' ' || c.apellido AS CLIENTE, " +
                     "COUNT(f.cliente_id) AS CANTIDAD_FACTURAS " +
                     "FROM factura f " +
                     "JOIN cliente c ON c.id = f.cliente_id " +
                     "GROUP BY c.nombre, c.apellido " +
                     "ORDER BY COUNT(f.cliente_id) DESC;")) {
            while (rs.next()) {
                System.out.println("Cliente: " + rs.getString("CLIENTE") +
                        ", Cantidad de Facturas: " + rs.getInt("CANTIDAD_FACTURAS"));
            }
        }
    }

    public static void topClientesGasto(Connection c) throws SQLException{
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT C.NOMBRE||' '||C.APELLIDO \"CLIENTE\", SUM(FD.CANTIDAD*P.PRECIO) \"MONTO\"\n" +
                     "FROM CLIENTE C \n" +
                     "JOIN FACTURA F ON C.ID=F.CLIENTE_ID\n" +
                     "JOIN FACTURA_DETALLE FD ON F.ID=FD.FACTURA_ID\n" +
                     "JOIN PRODUCTO P ON P.ID=FD.PRODUCTO_ID\n" +
                     "GROUP BY C.NOMBRE||' '||C.APELLIDO\n" +
                     "ORDER BY \"MONTO\" DESC\n" +
                     "LIMIT 5;")) {
            while (rs.next()) {
                System.out.println("CLIENTE: " + rs.getString("CLIENTE") +
                        ", MONTO TOTAL :" + rs.getInt("MONTO"));
            }
        }
    }

    public static void topMonedas(Connection c) throws SQLException{
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT M.NOMBRE \"MONEDA\", COUNT(F.MONEDA_ID) \"CANTIDAD\"\n" +
                     "FROM MONEDA M \n" +
                     "JOIN FACTURA F ON M.ID=F.MONEDA_ID\n" +
                     "GROUP BY M.NOMBRE\n" +
                     "ORDER BY \"CANTIDAD\" DESC\n" +
                     "LIMIT 5;")) {
            while (rs.next()) {
                System.out.println("MONEDA: " + rs.getString("MONEDA") +
                        ", CANTIDAD :" + rs.getInt("CANTIDAD"));
            }
        }
    }

    public static void topProveedor(Connection c) throws SQLException{
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT PR.RUC RUC, PR.NOMBRE PRODUCTO, COUNT(P.PROVEEDOR_ID) CANTIDAD\n" +
                     "FROM PROVEEDOR PR \n" +
                     "JOIN PRODUCTO P ON PR.ID=P.PROVEEDOR_ID\n" +
                     "GROUP BY PR.RUC, PR.NOMBRE\n" +
                     "ORDER BY CANTIDAD DESC\n" +
                     "LIMIT 5;")) {
            while (rs.next()) {
                System.out.println("RUC: "+rs.getString("RUC")+ ", PROVEEDOR: " + rs.getString("PRODUCTO") +
                        ", CANTIDAD :" + rs.getInt("CANTIDAD"));
            }
        }
    }

    public static void topProductos(Connection c) throws SQLException{
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT P.NOMBRE PRODUCTOS, SUM(FD.CANTIDAD) CANTIDAD\n" +
                     "FROM PRODUCTO P \n" +
                     "JOIN FACTURA_DETALLE FD ON P.ID=FD.PRODUCTO_ID\n" +
                     "GROUP BY P.NOMBRE\n" +
                     "ORDER BY CANTIDAD DESC\n" +
                     "LIMIT 5;")) {
            while (rs.next()) {
                System.out.println (" PRODUCTO: " + rs.getString("PRODUCTOS") +
                        ", CANTIDAD :" + rs.getInt("CANTIDAD"));
            }
        }
    }


}
