-- Create Players Table
CREATE TABLE IF NOT EXISTS players (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    uuid TEXT UNIQUE NOT NULL,
    username TEXT NOT NULL
);

-- Create Groups Table
CREATE TABLE IF NOT EXISTS groups (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT UNIQUE NOT NULL
);

-- Create Player Groups Join Table
CREATE TABLE IF NOT EXISTS player_groups (
    player_id INTEGER,
    group_id INTEGER,
    PRIMARY KEY (player_id, group_id),
    FOREIGN KEY (player_id) REFERENCES players (id),
    FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE
);

-- Create Permissions Table
CREATE TABLE IF NOT EXISTS permissions (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    permission TEXT UNIQUE NOT NULL
);

-- Create Player Permissions Join Table
CREATE TABLE IF NOT EXISTS player_permissions (
    player_id INTEGER,
    permission_id INTEGER,
    PRIMARY KEY (player_id, permission_id),
    FOREIGN KEY (player_id) REFERENCES players (id),
    FOREIGN KEY (permission_id) REFERENCES permissions (id)
);

-- Create Group Permissions Join Table
CREATE TABLE IF NOT EXISTS group_permissions (
    group_id INTEGER,
    permission_id INTEGER,
    PRIMARY KEY (group_id, permission_id),
    FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE,
    FOREIGN KEY (permission_id) REFERENCES permissions (id)
);

-- Enable foreign key support for SQLite
PRAGMA foreign_keys = ON;
