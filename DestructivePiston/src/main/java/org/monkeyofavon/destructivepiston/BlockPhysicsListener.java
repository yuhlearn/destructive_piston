package org.monkeyofavon.destructivepiston;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Piston;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class BlockPhysicsListener implements Listener {
    @EventHandler
    public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
        if (event != null && !event.isCancelled()) {
            Block block = event.getBlock();
            if (block.getType() == Material.PISTON && (block.isBlockPowered() || block.isBlockIndirectlyPowered())) {
                Piston piston = (Piston)block.getBlockData();
                if (!piston.isExtended()) {
                    BlockFace face = piston.getFacing();
                    if (block.getRelative(face, 2).getType() == Material.OBSIDIAN)
                        block.getRelative(face, 1).breakNaturally();
                }
            }
        }
    }
}
