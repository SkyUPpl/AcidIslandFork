package world.bentobox.acidisland.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import world.bentobox.bentobox.api.events.IslandBaseEvent;
import world.bentobox.bentobox.database.objects.Island;

/**
 * Fired when an ItemStack (water bottle or bucket) is filled with acid water.
 * Cancel this event to prevent the acid bottle from being given to the player.
 * @author Poslovitch
 * @since 1.0
 */
public class ItemFillWithAcidEvent extends IslandBaseEvent implements Cancellable {

    private final Player player;
    private final ItemStack item;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return getHandlerList();
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public ItemFillWithAcidEvent(Island island, Player player, ItemStack item) {
        super(island);
        this.player = player;
        this.item = item;
    }

    /**
     * Gets the player who triggered the event
     * @return the player who triggered the event
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the item that will be acid-ified
     * @return the item that will be acid-ified
     */
    public ItemStack getItem() {
        return item;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
