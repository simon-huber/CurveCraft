package com.ibhh.CurveCraft;

import com.ibhh.CurveCraft.logger.LoggerUtility;

import org.bukkit.entity.Player;

public class Help {

    private final CurveCraft plugin;

    public Help(CurveCraft pl) {
        this.plugin = pl;
    }

    public void help(Player player, String[] args) {
        this.plugin.getLoggerUtility().log("Help executed!", LoggerUtility.Level.DEBUG);
        if (args.length == 0) {
            for (String command : this.plugin.getCommands()) {
                if (this.plugin.getPermissions().checkpermissionssilent(player, this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".permission"))) {
                    this.plugin.getLoggerUtility().log(player, this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".usage"), LoggerUtility.Level.INFO);
                }
            }
        } else if (args.length > 0) {
            boolean found = false;
            for (String command : this.plugin.getCommands()) {
                if ((!this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".name").equalsIgnoreCase(args[0]))
                        || (!this.plugin.getPermissions().checkpermissions(player, this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".permission")))) {
                    continue;
                }
                this.plugin.getLoggerUtility().log(player, "-----------", LoggerUtility.Level.INFO);
                this.plugin.getLoggerUtility().log(player, this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".usage"), LoggerUtility.Level.INFO);
                this.plugin.getLoggerUtility().log(player, this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".description"), LoggerUtility.Level.INFO);
                found = true;
                return;
            }

            if (!found) {
                for (String command : this.plugin.getCommands()) {
                    if (this.plugin.getPermissions().checkpermissionssilent(player, this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".permission"))) {
                        this.plugin.getLoggerUtility().log(player, "-----------", LoggerUtility.Level.INFO);
                        this.plugin.getLoggerUtility().log(player, this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".usage"), LoggerUtility.Level.INFO);
                        this.plugin.getLoggerUtility().log(player, this.plugin.getConfigHandler().getLanguage_config().getString("commands." + command + ".description"), LoggerUtility.Level.INFO);
                    }
                }
            }
        }
    }
}