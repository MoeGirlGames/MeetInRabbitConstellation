package games.moegirl.rabbitconstellation.item;

import games.moegirl.rabbitconstellation.RabbitConstellation;
import games.moegirl.rabbitconstellation.block.ModBlocks;
import games.moegirl.rabbitconstellation.group.ModGroups;
import games.moegirl.rabbitconstellation.sound.ModSounds;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RabbitConstellation.MODID);

    public ModItems(IEventBus bus) {
        RabbitConstellation.getInstance().getLogger().info("Registering items.");
        ITEMS.register(bus);
    }

    // Items below.
    public static RegistryObject<Item> MUSIC_DISC_FOR_RIVER = ITEMS.register("music_disc_for_river", () -> new MusicDiscItem(1, () -> ModSounds.FOR_RIVER.get(), new Item.Properties().maxStackSize(1).group(ModGroups.RABBIT_CONSTELLATION).rarity(Rarity.RARE)));
    public static RegistryObject<BlockItem> PAPER_RABBIT = ITEMS.register("paper_rabbit", () -> new BlockItem(ModBlocks.PAPER_RABBIT.get(), new Item.Properties().group(ModGroups.RABBIT_CONSTELLATION)));
}
