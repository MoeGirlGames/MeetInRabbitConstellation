package games.moegirl.rabbitconstellation.block;

import games.moegirl.rabbitconstellation.RabbitConstellation;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RabbitConstellation.MODID);

    public ModBlocks(IEventBus bus) {
        RabbitConstellation.getInstance().getLogger().info("Registering blocks.");
        BLOCKS.register(bus);
    }

    // Blocks below.
    public static final RegistryObject<Block> PAPER_RABBIT = BLOCKS.register("paper_rabbit", PaperRabbitBlock::new);
}
