package com.popopapi.services.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

 class DatabaseSetup {
    private static final String DB_NAME = "sapm.db";
    private static final String DB_URL = "jdbc:sqlite:./services/src/main/resources/Databases/" + DB_NAME;
    public static void createDatabaseAndTables() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            // Enable foreign keys
            statement.execute("PRAGMA foreign_keys = ON;");

            // Create tables
            statement.execute("CREATE TABLE IF NOT EXISTS players (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "uuid TEXT UNIQUE," +
                    "username TEXT" +
                    ");");

            statement.execute("CREATE TABLE IF NOT EXISTS groups (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT UNIQUE" +
                    ");");

            statement.execute("CREATE TABLE IF NOT EXISTS player_groups (" +
                    "player_id INTEGER," +
                    "group_id INTEGER," +
                    "PRIMARY KEY (player_id, group_id)," +
                    "FOREIGN KEY (player_id) REFERENCES players (id)," +
                    "FOREIGN KEY (group_id) REFERENCES groups (id)" +
                    ");");

            statement.execute("CREATE TABLE IF NOT EXISTS permissions (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "permission TEXT UNIQUE" +
                    ");");

            statement.execute("CREATE TABLE IF NOT EXISTS player_permissions (" +
                    "player_id INTEGER," +
                    "permission_id INTEGER," +
                    "PRIMARY KEY (player_id, permission_id)," +
                    "FOREIGN KEY (player_id) REFERENCES players (id)," +
                    "FOREIGN KEY (permission_id) REFERENCES permissions (id)" +
                    ");");

            statement.execute("CREATE TABLE IF NOT EXISTS group_permissions (" +
                    "group_id INTEGER," +
                    "permission_id INTEGER," +
                    "PRIMARY KEY (group_id, permission_id)," +
                    "FOREIGN KEY (group_id) REFERENCES groups (id)," +
                    "FOREIGN KEY (permission_id) REFERENCES permissions (id)" +
                    ");");

            System.out.println("Database and tables created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating database and tables: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createDatabaseAndTables();
    }
}
