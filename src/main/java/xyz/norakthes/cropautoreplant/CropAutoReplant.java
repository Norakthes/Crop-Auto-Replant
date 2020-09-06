package xyz.norakthes.cropautoreplant;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public final class CropAutoReplant extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            String world = event.getPlayer().getWorld().getName();
            Location location = event.getClickedBlock().getLocation();
            Material block = event.getClickedBlock().getType();
            String blockData = event.getClickedBlock().getBlockData().getAsString();
            Collection<ItemStack> drops = event.getClickedBlock().getDrops();
            switch (blockData.trim()){
                case "minecraft:wheat[age=7]":
                    drops.add(new ItemStack(Material.WHEAT_SEEDS, -1));
                    event.getClickedBlock().breakNaturally();
                    location.getWorld().getBlockAt(location).setType(Material.WHEAT);
                    Bukkit.getWorld(world).spawnParticle(Particle.BLOCK_CRACK, location.add(0.5, 0, 0.5), 200, block.createBlockData());
                    break;

                case "minecraft:carrots[age=7]":
                    drops.add(new ItemStack(Material.CARROT, -1));
                    event.getClickedBlock().breakNaturally();
                    location.getWorld().getBlockAt(location).setType(Material.CARROTS);
                    Bukkit.getWorld(world).spawnParticle(Particle.BLOCK_CRACK, location.add(0.5, 0, 0.5), 200, block.createBlockData());
                    break;

                case "minecraft:potatoes[age=7]":
                    drops.add(new ItemStack(Material.POTATO, -1));
                    event.getClickedBlock().breakNaturally();
                    location.getWorld().getBlockAt(location).setType(Material.POTATOES);
                    Bukkit.getWorld(world).spawnParticle(Particle.BLOCK_CRACK, location.add(0.5, 0, 0.5), 200, block.createBlockData());
                    break;

                case "minecraft:beetroots[age=3]":
                    drops.add(new ItemStack(Material.BEETROOT_SEEDS, -1));
                    event.getClickedBlock().breakNaturally();
                    location.getWorld().getBlockAt(location).setType(Material.BEETROOTS);
                    Bukkit.getWorld(world).spawnParticle(Particle.BLOCK_CRACK, location.add(0.5, 0, 0.5), 200, block.createBlockData());
                    break;

            }
        }
    }
}
