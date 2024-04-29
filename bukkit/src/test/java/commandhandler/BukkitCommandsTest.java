package commandhandler;


import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.bukkit.command.CommandSender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BukkitCommandsTest {
    private ServerMock server;
    private BukkitCommands bukkitCommands;
    private CommandSender sender;

    @Before
    public void setUp() {
        server = MockBukkit.mock();
        bukkitCommands = new BukkitCommands();
        sender = server.addPlayer("TestPlayer");
    }

    @After
    public void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    public void testHandleCreateGroupCommand() {
        assertTrue(bukkitCommands.handleCommand(sender, new String[]{"creategroup", "TestGroup"}));
        // Assert that the group was created successfully
        // ...
    }

    @Test
    public void testHandleDeleteGroupCommand() {
        // Assume the group "TestGroup" exists
        assertTrue(bukkitCommands.handleCommand(sender, new String[]{"deletegroup", "TestGroup"}));
        // Assert that the group was deleted successfully
        // ...
    }

    @Test
    public void testHandleWebEditorCommand() {
        assertTrue(bukkitCommands.handleCommand(sender, new String[]{"webeditor"}));
        // Assert that the correct message was sent to the sender
        // ...
    }

    @Test
    public void testHandleListGroupsCommand() {
        assertTrue(bukkitCommands.handleCommand(sender, new String[]{"listgroups"}));
        // Assert that the correct list of groups was sent to the sender
        // ...
    }

    @Test
    public void testHandleAddPlayerToGroupCommand() {
        // Assume the group "TestGroup" exists
        PlayerMock player = server.addPlayer("TestPlayer");
        assertTrue(bukkitCommands.handleCommand(sender, new String[]{"group", "TestGroup", "addplayer", player.getName()}));
        // Assert that the player was added to the group successfully
        // ...
    }

    // Add more test methods for other commands and scenarios
    @Test
    public void testHandleTabComplete() {
        // Test tab completion for the root command
        assertEquals(Arrays.asList("creategroup", "deletegroup", "webeditor", "listgroups", "group", "player"),
                bukkitCommands.handleTabComplete(new String[]{""}));

        // Test tab completion for the "group" command
        assertEquals(Arrays.asList("clear", "info", "rename", "permission", "addplayer", "deleteplayer"),
                bukkitCommands.handleTabComplete(new String[]{"group", "TestGroup"}));

        // Test tab completion for the "player" command
        assertEquals(Arrays.asList("permission", "info"),
                bukkitCommands.handleTabComplete(new String[]{"player", "TestPlayer"}));

        // Test tab completion for the "group addplayer" command
        PlayerMock player1 = server.addPlayer("Player1");
        PlayerMock player2 = server.addPlayer("Player2");
        assertEquals(Arrays.asList(player1.getName(), player2.getName()),
                bukkitCommands.handleTabComplete(new String[]{"group", "TestGroup", "addplayer"}));

        // Test tab completion for the "group deleteplayer" command
        // Assume "Player1" is already in the "TestGroup"
        assertEquals(Arrays.asList(player1.getName()),
                bukkitCommands.handleTabComplete(new String[]{"group", "TestGroup", "deleteplayer"}));

        // Test tab completion for the "group permission" command
        assertEquals(Arrays.asList("add", "remove", "show"),
                bukkitCommands.handleTabComplete(new String[]{"group", "TestGroup", "permission"}));

        // Test tab completion for the "group permission add" command
        assertEquals(Arrays.asList("permission1", "permission2", "permission3"),
                bukkitCommands.handleTabComplete(new String[]{"group", "TestGroup", "permission", "add"}));

        // Test tab completion for the "group permission remove" command
        // Assume "permission1" is already assigned to "TestGroup"
        assertEquals(Arrays.asList("permission1"),
                bukkitCommands.handleTabComplete(new String[]{"group", "TestGroup", "permission", "remove"}));

        // Test tab completion for the "player permission" command
        assertEquals(Arrays.asList("add", "remove", "show"),
                bukkitCommands.handleTabComplete(new String[]{"player", "TestPlayer", "permission"}));

        // Test tab completion for the "player permission add" command
        assertEquals(Arrays.asList("permission1", "permission2", "permission3"),
                bukkitCommands.handleTabComplete(new String[]{"player", "TestPlayer", "permission", "add"}));

        // Test tab completion for the "player permission remove" command
        // Assume "permission1" is already assigned to "TestPlayer"
        assertEquals(Arrays.asList("permission1"),
                bukkitCommands.handleTabComplete(new String[]{"player", "TestPlayer", "permission", "remove"}));
    }

}