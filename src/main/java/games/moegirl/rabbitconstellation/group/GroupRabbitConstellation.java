package games.moegirl.rabbitconstellation.group;

import games.moegirl.rabbitconstellation.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GroupRabbitConstellation extends ItemGroup {
    public GroupRabbitConstellation() {
        super("rabbit_constellation");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.MUSIC_DISC_FOR_RIVER.get());
    }
}
