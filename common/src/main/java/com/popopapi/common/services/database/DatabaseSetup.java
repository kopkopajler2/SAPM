package com.popopapi.common.services.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.popopapi.common.services.logger.MinecraftLogger;

public class DatabaseSetup {
    private static final String DB_NAME = "sapm.db";
    private static final String PLUGINS_DIR = "plugins";
    private static final String PLUGIN_NAME = "SpigotAdvancedPermissionManager";
    private static final String DB_DIR = Paths.get(PLUGINS_DIR, PLUGIN_NAME).toString();
    private static final String DB_URL = "jdbc:sqlite:" + Paths.get(DB_DIR, DB_NAME);

    public DatabaseSetup() {
        createDatabaseAndTables();
    }

    public void createDatabaseAndTables() {
        MinecraftLogger.debug("DB URL: " + DB_URL, true);

        try {
            // Create the directory if it doesn't exist
            Files.createDirectories(Paths.get(DB_DIR));
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            if (!connection.isValid(5)) {
                throw new SQLException("Connection is not valid!");
            }
            MinecraftLogger.info("Connection is valid!");

            // Enable foreign keys
            statement.execute("PRAGMA foreign_keys = ON;");

            // Create tables
            statement.execute("""
                CREATE TABLE IF NOT EXISTS players (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    uuid TEXT UNIQUE NOT NULL,
                    username TEXT NOT NULL
                );""");

            statement.execute("""
                CREATE TABLE IF NOT EXISTS groups (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT UNIQUE NOT NULL
                );""");

            statement.execute("""
                    CREATE TABLE IF NOT EXISTS player_groups (
                        player_id INTEGER,
                        group_id INTEGER,
                        PRIMARY KEY (player_id, group_id),
                        FOREIGN KEY (player_id) REFERENCES players (id),
                        FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE
                    );""");

            statement.execute("""
                CREATE TABLE IF NOT EXISTS permissions (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    permission TEXT UNIQUE NOT NULL
                );""");

            statement.execute("""
                CREATE TABLE IF NOT EXISTS player_permissions (
                    player_id INTEGER,
                    permission_id INTEGER,
                    PRIMARY KEY (player_id, permission_id),
                    FOREIGN KEY (player_id) REFERENCES players (id),
                    FOREIGN KEY (permission_id) REFERENCES permissions (id)
                );""");

            statement.execute("""
                CREATE TABLE IF NOT EXISTS group_permissions (
                    group_id INTEGER,
                    permission_id INTEGER,
                    PRIMARY KEY (group_id, permission_id),
                    FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE,
                    FOREIGN KEY (permission_id) REFERENCES permissions (id)
                );""");

            MinecraftLogger.info("Database and tables created successfully.");
        } catch (SQLException e) {
            MinecraftLogger.error("Error creating database and tables: " + e.getMessage(), true);
        }
    }
}
